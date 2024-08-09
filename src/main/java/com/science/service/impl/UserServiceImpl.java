package com.science.service.impl;

import com.science.dto.UserLoginRequestDTO;
import com.science.dto.UserLoginResponseDTO;
import com.science.dto.UserRegDTO;
import com.science.entity.User;
import com.science.mapper.UserMapper;
import com.science.service.IUserService;
import com.science.service.ex.*;
import com.science.util.AliOssUtil;
import com.science.util.JWTUtil;
import com.science.util.UserLoginResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.UUID;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private JWTUtil jwtUtil;
    @Autowired
    private AliOssUtil aliOssUtil;
    @Override
    public void reg(UserRegDTO userRegDTO,String avatar) {
        User result=userMapper.findByUsername(userRegDTO.getUsername());
        if(result!=null){
            throw new UsernameDuplicatedException("用户名重复的异常");
        }
        String oldPassword= userRegDTO.getPassword();
        String salt=UUID.randomUUID().toString().toUpperCase();

        User user=new User();
        user.setUsername(userRegDTO.getUsername());
        user.setUserType(userRegDTO.getUserType());
        user.setAvatar(avatar);
        user.setSalt(salt);
        String MD5Password=getMD5Password(oldPassword,salt);
        user.setPassword(MD5Password);
        user.setIsDelete(0);
        user.setCreateUser(user.getUsername());
        user.setCreateTime(new Date());

        Integer rows=userMapper.insert(user);
        if(rows!=1){
            throw new InsertException("插入数据时产生未知异常");
        }
    }
    private String getMD5Password(String password,String salt){
        for(int i=1;i<=3;i++){
            password=DigestUtils.md5DigestAsHex((salt+password+salt).getBytes()).toUpperCase();
        }
        return password;
    }

    /**
     * 根据前端传回的数据，在数据库进行查找，返回查找值
     * @param userLoginRequestDTO
     * @return
     */
    @Override
    public UserLoginResult login(UserLoginRequestDTO userLoginRequestDTO) {
        UserLoginResponseDTO userLoginResponseDTO=new UserLoginResponseDTO();
        String username = userLoginRequestDTO.getUsername();
        String password = userLoginRequestDTO.getPassword();
        User result = userMapper.findByUsername(username);
        if(result == null){
            throw new AccountNotFoundException("账号不存在");
        }
        userLoginResponseDTO.setUid(result.getUid());
        userLoginResponseDTO.setUsername(result.getUsername());
        userLoginResponseDTO.setAvatar(result.getAvatar());
        userLoginResponseDTO.setUserType(result.getUserType());
        String salt=result.getSalt();
        password = getMD5Password(password,salt);
        //密码错误
        if(!password.equals(result.getPassword())){
            throw new PasswordErrorException("密码错误");
        }
        String jwtToken;
        try{
            jwtToken=jwtUtil.createToken(username);
        }catch (JWTCreationException e){
            throw new JWTCreationException("生成jwt令牌出错",e);
        }
        UserLoginResult userLoginResult=new UserLoginResult(userLoginResponseDTO,jwtToken);
        return userLoginResult;
    }

    @Override
    public String getAvatar(int uid) {
        String avatar=userMapper.getAvatarByUid(uid);
        return avatar;
    }

    @Override
    public void deleteOldAvatar(String avatar){
        aliOssUtil.delete(avatar);
    }
    @Override
    public void changeAvatar(int uid, String avatar) {
        Integer rows=userMapper.updateAvatar(uid,avatar);
        if(rows!=1){
            throw new UpdateException("更新头像时发生未知异常");
        }
    }

}
