
# 1. 介绍
- 基于springboot+mybatis+通用mapper的后台框架
- 集成shiro+jwt权限认证功能，能自动验证接口鉴权。
- 集成swagger-ui接口管理和测试插件，方便接口文档的生成和调试。

# 2. 准备工作

## 2.1 JWT

因为我们要实现的`RESTful`风格的认证系统，采用的是当下最流行的前后端分离的Token认证。因此，就需要用JWT相关的库。首先，我们添加相关的Maven依赖：

```xml
<!--shiro集成Spring库-->
<dependency>
	<groupId>org.apache.shiro</groupId>
	<artifactId>shiro-spring</artifactId>
	<version>1.4.0</version>
</dependency>
<!--jjwt 用于解码和编码Token-->
<dependency>
	<groupId>io.jsonwebtoken</groupId>
	<artifactId>jjwt</artifactId>
	<version>0.9.1</version>
</dependency>
```

并且准备一个`JWTUtil`工具类，用来生成和解密Token：

```java
public class JWTUtil {

    private static final String SECRET_KEY = "f9251e38-7f92-469a-8c04-7c8d2f9a7edc";

    public static String encode(String userId) {
        Integer ept = 10080;  // 一周
        return JWTUtil.encode(userId, ept);
    }

    // 加密Token
    public static String encode(String userId, Integer exceptionTime) {
        Map<String, Object> claims = new HashMap<>();
        long nowMillis = System.currentTimeMillis();
        long expirationMillis = nowMillis + exceptionTime * 60000L;
        claims.put("userId", userId);
        return Jwts.builder()
                .setSubject("subValue")
                .addClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(new Date(expirationMillis))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
    }

    // 解密Token
    public static String decode(String accessToken) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(accessToken).getBody();
            return (String) claims.get("userId");
        } catch (Exception e) {  // 解密失败，返回null
            return null;
        }
    }
}
```

准备好了数据源和工具类， 下面我们开始关键的Shiro的配置。

# 3. Shiro配置

## 3.1 身份令牌

身份验证，**即在应用中谁能证明他就是他的本人**。在我们搭建的`RESTful`认证系统当中，身份验证标识当然是根据用户`id`生成的Token了。我们定义`JwtToken`，让它实现`AuthenticationToken`接口：

```java
public class JwtToken implements AuthenticationToken {

    private String token;

    public JwtToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
```

`AuthenticationToken`接口定义了两个方法，`getPrincipal()`用于获得主体的标识属性，这里是采用staffId属性生成的token，方便基于主键的操作。

```java
package org.apache.shiro.authc;

public interface AuthenticationToken extends Serializable {
    
    Object getPrincipal();

    Object getCredentials();
}
```

在这里，我们让通过用户`id`生成的Token既当做是标识属性，也当做是证明凭证。

## 3.3 Filter

另外，我们来需要通过滤器来实现Shiro的认证的流程。我们让定义的过滤器`ShiroFilter`类继承自`BasicHttpAuthenticationFilter`，并且重写主要的认证的方法。

`ShiroFilter`中各个方法调用的逻辑和顺序如下图：

![](https://i.loli.net/2018/11/21/5bf54f2a0ef3e.png)

# 4 使用方法
- 运行springboot主类，启动web服务器
- 浏览器访问：http://127.0.1.1:8080/swagger-ui.html
- 可以按类别浏览各个公开的API的基本信息
- 可以点击某个API展示其详细信息
- 可以通过每个接口右上角的“try it out"按钮对该API进行测试
  - 测试步骤：
  - 先在Parameters区域填好接口所需的参数
  - 按execute按钮发送http请求到后台服务器
  - 在Server response区域查看测试结果
  - Responses区域是该API可能会产生的http状态码和对应的响应体说明


