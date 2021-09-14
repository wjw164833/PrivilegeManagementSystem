package xyz.wjw.priviligemanagementsystem.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.springframework.util.StringUtils;
import xyz.wjw.priviligemanagementsystem.entity.User;
import xyz.wjw.priviligemanagementsystem.enums.ErrorEnum;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Date;

/**
 * Token加解密相关工具
 */
public class TokenUtils {

    public static final long EXPIRE = 1000 * 60 * 60 * 24; //token过期时间
    public static final String APP_SECRET = "Pc83x7RJ0uT2djtbwZFWVQsKqXYAmHyz"; //秘钥

    public static String encrpt(TokenData data) {
        return Base64.getEncoder().encodeToString(data.toString().getBytes());
    }

    public static TokenData decrpt(String token) {
        try {
            String decodeString = new String(Base64.getDecoder().decode(token.getBytes()));
            String[] args = decodeString.split(":");
            // 长度不对
            if (args.length != 2) {
                return null;
            }
            return new TokenData(args[0], args[1]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @AllArgsConstructor
    @Getter
    public static class TokenData {
        private String account;
        private String username;

        @Override
        public String toString() {
            return account + ":" + username;
        }
    }

    //生成token字符串的方法
    public static String getJwtToken(String account,String password) {

        String JwtToken = Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))

                .claim("account", account)  //设置token主体部分 ，存储用户信息
                .claim("password", password)  //设置token主体部分 ，存储用户信息
                .signWith(SignatureAlgorithm.HS256, APP_SECRET)
                .compact();

        return JwtToken;
    }
    public static boolean checkToken(String token) {
        if (StringUtils.hasLength(token)) {
            try {
                Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(token);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static String getUserID(String token) {
        if (token == null || token.equals("")) {
            return "";
        }
        Claims claims = Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(token).getBody();
        return (String) claims.get("id");
    }
    public static User getUser(HttpServletRequest request) {
        String token= request.getHeader("Authorization");
        if (token == null || token.equals("")) {
            new BizException(ErrorEnum.SIGNATURE_NOT_MATCH.getResultCode(),"你没有权限");
        }
        System.out.println(token);
        Claims claims = Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(token).getBody();
        String id = (String) claims.get("id");
        String password = (String) claims.get("password");
        User userEntity = new User();
        userEntity.setId((String) claims.get("id"));
        userEntity.setPassword((String) claims.get("password"));
        return userEntity;
    }
    /**
     * 直接通过这个方法得到存储在token中的UserId
     * @param request
     * @return
     */
    public static String getMemberIdByJwtToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
//        token = getJwtToken(Id,UserType);
        if (token == null || token.equals("")) {
            return "";
        }
        Claims claims = Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(token).getBody();
        return (String) claims.get("id");
    }
}
