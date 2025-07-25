package com.instance.stusys.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/**
 *Jwt工具类
 */
public class TokenUtils {

    private String secret = "your_secret_key"; // 强密码
    private long expiration = 60 * 60 * 1000; // 1小时

    //这个方法用于生成 JWT。它接受用户名作为参数。
    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, username);
    }
    //私有方法，用于实际生成 JWT
    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()//开始构建 JWT 的构建器
                .setClaims(claims)//设置 JWT 中的声明
                .setSubject(subject)//设置主题（通常是用户名）
                .setIssuedAt(new Date(System.currentTimeMillis()))//设置 JWT 的签发时间
                .setExpiration(new Date(System.currentTimeMillis() + expiration))//设置 JWT 的过期时间
                .signWith(SignatureAlgorithm.HS256, secret)//使用指定的算法（HS256）和密钥对 JWT 进行签名
                .compact();//生成最终的 JWT 字符串
    }
    //用于验证给定的 JWT 是否有效。
    public Boolean validateToken(String token, String username) {
        final String extractedUsername = extractUsername(token);//提取 JWT 中的用户名
        return (extractedUsername.equals(username) && !isTokenExpired(token));//检查提取的用户名与提供的用户名是否匹配，并且检查 JWT 是否未过期
    }
    //从 JWT 中提取用户名
    public String extractUsername(String token) {
        return extractAllClaims(token).getSubject();
    }
    //解析 JWT 并返回所有声明
    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }//使用密钥解析 JWT 获取其主体部分（声明）

    //检查 JWT 是否已过期
    private Boolean isTokenExpired(String token) {
        return extractAllClaims(token).getExpiration().before(new Date());
    }
}

