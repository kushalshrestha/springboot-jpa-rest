package id_authentication.service;

import id_authentication.domain.Member;
import id_authentication.domain.MyUserDetails;
import id_authentication.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserService implements UserDetailsService {

    @Autowired
    private MemberRepository memberRepository;

    public UserService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException , DataAccessException {
        Member user = memberRepository.findMemberByUserName(username);
        UserDetails userDetails = new MyUserDetails(user);
        return userDetails;
    }


}
