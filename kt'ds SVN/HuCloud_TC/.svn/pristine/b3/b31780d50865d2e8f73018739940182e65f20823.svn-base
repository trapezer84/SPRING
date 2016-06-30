package kr.co.hucloud.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import kr.co.hucloud.security.code.example.member.dao.MemberDAO;
import kr.co.hucloud.security.code.example.member.vo.LoginVO;
import kr.co.hucloud.security.code.example.member.vo.MemberVO;

public class UserService implements AuthenticationProvider {

	private MemberDAO memberDAO;
	
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		// 사용자가 입력한 계정 ID
		String id = (String) authentication.getPrincipal();
		// 사용자가 입력한 계정 비밀번호
		String password = (String) authentication.getCredentials();
		
		LoginVO login = new LoginVO();
		login.setId(id);
		login.setPassword(password);
		
		MemberVO member = memberDAO.login(login);
		if(member != null) {
			List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
            roles.add(new SimpleGrantedAuthority("ROLE_USER"));
             
            UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(id, password, roles);
            result.setDetails(new User(id, password, member));
            return result;          
		} 
		else {
            throw new BadCredentialsException("Bad credentials");
        }
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}


}
