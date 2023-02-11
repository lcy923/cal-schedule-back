package com.study.calscheduleback.jwt;


import com.study.calscheduleback.member.dto.MemberRequestDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Date;


@Component
public class JwtProvider {

    String sampleToken = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIyIn0.b15pj9e1-NeNjKaDymngI43HKuaaBeJxWmzNcWAgfPU";

    //create JWT token
    public String createToken(MemberRequestDto memberRequestDto) {

        String userId = memberRequestDto.getUserId().toString();
        String userPw = memberRequestDto.getUserPw().toString();


        Date now = new Date();
        Claims claims = Jwts.claims().setSubject(memberRequestDto.getUserId());

        return Jwts.builder()
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + Duration.ofMinutes(30).toMillis()))
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256,"7w1zdCfFqJaNdRgUjXn2r5u8xaA2DeGbasdfasdfsdf")
                .compact();
    }

    public Claims parseJwtToken(String authorizationHeader) {
        validationAuthorizationHeader(authorizationHeader); // (1)
        String token = extractToken(authorizationHeader); // (2)

        return Jwts.parser()
                .setSigningKey("secret") // (3)
                .parseClaimsJws(token) // (4)
                .getBody();
    }


    private void validationAuthorizationHeader(String header) {
        if (header == null || !header.startsWith("Bearer ")) {
            throw new IllegalArgumentException();
        }
    }

    private String extractToken(String authorizationHeader) {
        return authorizationHeader.substring("Bearer ".length());
    }

    //JWT 토큰에서 아이디 추출
    public String getUserIdFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey("7w1zdCfFqJaNdRgUjXn2r5u8xaA2DeGbasdfasdfsdf")
                .parseClaimsJws(token)
                .getBody();
        System.out.println("id: "+claims.getId());
        System.out.println("subject: "+claims.getSubject());
        System.out.println("issue: "+claims.getIssuedAt().toString());

        return claims.getSubject();
    }

    public boolean validationToken(String token) {

            Jwts.parser().setSigningKey("7w1zdCfFqJaNdRgUjXn2r5u8xaA2DeGbasdfasdfsdf")
                    .parseClaimsJws(token);
            return true;
    }



}
//@Component
//public class JwtProvider {
//
//    private String secretKey;
//
//    //==토큰 생성 메소드==//
//    public String createToken(String subject) {
//        Date now = new Date();
//        Date expiration = new Date(now.getTime() + Duration.ofDays(1).toMillis()); // 만료기간 1일
//
//        return Jwts.builder()
//                .setHeaderParam(Header.TYPE, Header.JWT_TYPE) // (1)
//                .setIssuer("test") // 토큰발급자(iss)
//                .setIssuedAt(now) // 발급시간(iat)
//                .setExpiration(expiration) // 만료시간(exp)
//                .setSubject(subject) //  토큰 제목(subject)
//                .signWith(SignatureAlgorithm.HS256, Base64.getEncoder().encodeToString(secretKey.getBytes())) // 알고리즘, 시크릿 키
//                .compact();
//    }
//
//    //==Jwt 토큰의 유효성 체크 메소드==//
//    public Claims parseJwtToken(String token) {
//        token = BearerRemove(token); // Bearer 제거
//        return Jwts.parser()
//                .setSigningKey(Base64.getEncoder().encodeToString(secretKey.getBytes()))
//                .parseClaimsJws(token)
//                .getBody();
//    }
//
//    //==토큰 앞 부분('Bearer') 제거 메소드==//
//    private String BearerRemove(String token) {
//        return token.substring("Bearer ".length());
//    }
//}