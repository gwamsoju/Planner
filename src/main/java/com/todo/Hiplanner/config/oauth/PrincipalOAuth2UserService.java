package com.todo.Hiplanner.config.oauth;

import com.todo.Hiplanner.config.auth.PrincipalDetails;
import com.todo.Hiplanner.mapper.MemberMapper;
import com.todo.Hiplanner.vo.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class PrincipalOAuth2UserService extends DefaultOAuth2UserService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final MemberMapper memberMapper;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        OAuth2User oAuth2User = super.loadUser(userRequest);

        if(userRequest.getClientRegistration().getRegistrationId().equals("google")) {
            System.out.println("구글 로그인 요청");
        }
        Map<String, Object> userInfo = oAuth2User.getAttributes();

        String username = (String)userInfo.get("sub");
        String name = (String) userInfo.get("name");
        String password = bCryptPasswordEncoder.encode("gwamsoju");
        String email = (String)userInfo.get("email");
        String job = "학생";

        Member member = memberMapper.findByUsername(username);

        if(member == null){
            member = Member.builder()
                    .username(username)
                    .name(name)
                    .password(password)
                    .mail(email)
                    .job("")
                    .phone("")
                    .gender("")
                    .build();
            memberMapper.insertMember(member);
        }

        return new PrincipalDetails(member, oAuth2User.getAttributes());
    }
}
