package com.todo.Hiplanner.config.auth;

import com.todo.Hiplanner.mapper.MemberMapper;
import com.todo.Hiplanner.vo.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {

    private final MemberMapper memberMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("username = " + username);
        Member member = memberMapper.findByUsername(username);
        if(member != null){
            return new PrincipalDetails(member);
        }
        return null;
    }
}
