package com.science.mapper;

import com.science.entity.User;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    public Integer insert(User user);
    public User findByUsername(String username);
    public Integer updateAvatar(int uid,String avatar);
    public Integer getUidByUsername(String username);
}
