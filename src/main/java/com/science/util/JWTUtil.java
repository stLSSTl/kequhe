package com.science.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class JWTUtil {
    @Value("${jwt.secret-key}")
    private String secretKey;
    private Algorithm algorithm;
    @PostConstruct
    public void init() {
        algorithm = Algorithm.HMAC256(secretKey);
    }
    public String createToken(String username){
        return JWT.create().withSubject(username)
                        .withIssuedAt(new Date())
                        .withExpiresAt(new Date(System.currentTimeMillis()+1000*60*60))
                        .sign(algorithm);
    }
    /**Claims(声明,会用于生成负载部分的编码):
     sub (主题)：通常用于标识 JWT 的用户。
     iat (签发时间)：JWT 被创建的时间。
     exp (过期时间)：JWT 的过期时间。
     Algorithm用于指定签名*/
    public  DecodedJWT verifyToken(String token){
         DecodedJWT decodedJWT;
         try {
            JWTVerifier verifier = JWT.require(algorithm)
                    .build(); // 创建一个可重用的验证器实例
            decodedJWT=verifier.verify(token); // 如果验证成功，返回解码后的 JWT
        } catch (JWTVerificationException exception) {
            // 令牌无效或过期
            return null;
        }
         System.out.println(decodedJWT.getSubject());
         return decodedJWT;
    }
}
