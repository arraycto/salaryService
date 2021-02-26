package com.weyoung.wxapp.common.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 生成存放userId的sessionId(token)的工具类
 *
 * @author Pushy
 */

public class JWTUtil {

    /**
     * TOKEN缓存时间
     */
    public static final long EXPIRED_TIME = 30 * 60 * 1000L;
    private static final String SECRET_KEY = "f9251e38-7f92-469a-8c04-7c8d2f9a7edc";
    private static Logger logger = LoggerFactory.getLogger(JWTUtil.class);

    public static String encode(String userId) {
        // token失效时间：一周
        long ept = 10080 * 60000L;
        return JWTUtil.encode(userId, ept);
    }

    public static String encode(String userId, long exceptionTime) {
        Map<String, Object> claims = new HashMap<>();
        long nowMillis = System.currentTimeMillis();
        long expirationMillis = nowMillis + exceptionTime;
        claims.put("userId", userId);
        return Jwts.builder()
                .setSubject("subValue")
                .addClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(new Date(expirationMillis))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
    }

    public static String decode(String accessToken) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(accessToken).getBody();
            return (String) claims.get("userId");
        } catch (Exception e) {  // 解密失败，返回null
            logger.error(e.getMessage());
            return null;
        }
    }

    public static Claims parseJwt(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token).getBody();
    }
}
