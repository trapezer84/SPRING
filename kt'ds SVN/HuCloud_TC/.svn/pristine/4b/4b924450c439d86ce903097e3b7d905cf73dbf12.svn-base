package kr.co.hucloud.security.code.example.member.web;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.hucloud.security.code.example.common.Session;
import kr.co.hucloud.security.code.example.common.util.SendMessage;
import kr.co.hucloud.security.code.example.member.service.MemberService;
import kr.co.hucloud.security.code.example.member.util.LoginFaileCountSecurity;
import kr.co.hucloud.security.code.example.member.vo.LoginVO;
import kr.co.hucloud.security.code.example.member.vo.MemberRegistryVO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {

	private MemberService memberService;

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	@RequestMapping(value=("/member/login"), method=RequestMethod.POST )
	public void login(LoginVO loginVO, HttpSession session, HttpServletResponse response) {
		boolean isLoginSuccess = memberService.login(session, loginVO);
		//FIXME 로그인 횟수 제한 방어코드 작성
		LoginFaileCountSecurity loginSec = (LoginFaileCountSecurity) session.getAttribute(Session.LOGIN_COUNT);
		if ( loginSec == null ) {
			loginSec = new LoginFaileCountSecurity();
		}
		
		if ( loginSec.isExceedValidLoginFailCount() ) {
			if ( loginSec.isInTime60Seconds() ) {
				SendMessage.send(response, "9"); // 잠시 후 로그인 시도하세요.
				return;
			}
			else {
				loginSec.resetLoginFailCount();
			}
		}
		
		if ( !isLoginSuccess ) {
			loginSec.addLoginFailCount();
			loginSec.setLatestFailTimeMillis();
		}
		
		session.setAttribute(Session.LOGIN_COUNT, loginSec);
		
		//FIXME Token 값 생성 및 등록 코드 작성
		//이후 게시판 글 쓰기 페이지에서 Token 값 전달 받아 비교.
		if ( isLoginSuccess ) {
			String token = UUID.randomUUID().toString();
			session.setAttribute(Session.CSRF_TOKEN, token);
		}
		
		SendMessage.send(response, isLoginSuccess ? "OK" : "NO");
	}
	
	@RequestMapping(value=("/member/logout"), method=RequestMethod.POST )
	public void logout(HttpSession session, HttpServletResponse response) {
		session.invalidate();
		SendMessage.send(response, "OK");
	}
	
	@RequestMapping("/member/registry" )
	public void registryMember(MemberRegistryVO memberVO, HttpServletResponse response) {
		try {
			//FIXME 회원가입시 비밀번호 체크하기
			/*
			 * 하나 이상의 알파벳을 포함해야 함
			 * 하나 이상의 숫자를 포함해야 함
			 * 하나 이상의 특수문자를 포함해야 함
			 * 최소 8글자 이상 입력해야 함
			 */
			
			//FIXME 회원가입시 비밀번호를 SHA-256 으로 SALT 이용해 암호화 하기
			//Salt 만들기
			//Salt 도 DB에 Insert 함
			//로그인 할 때 Salt값을 가져와 똑같은 방법으로 암호화 한 후 대조
			Random random = new Random();
			byte[] salt = new byte[8];
			random.nextBytes(salt);
			
			String password = memberVO.getUserPassword();
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			digest.update(salt);
			password = new String(digest.digest(password.getBytes()));
			System.out.println("암호화된 비번 : " + password);
			
			memberService.addMember(memberVO);
			SendMessage.send(response, "OK");
		}
		catch(RuntimeException re) {
			re.printStackTrace();
			SendMessage.send(response, memberVO.getUserId() + "은(는) 이미 등록된 아이디 입니다.");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} 
	}
	
}
