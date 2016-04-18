package com.ktds.leina.web;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.leina.vo.LoginVO;

import kr.co.hucloud.utilities.excel.option.ReadOption;
import kr.co.hucloud.utilities.excel.read.ExcelRead;

@Controller
public class IndexController {
	
	private Logger logger = LoggerFactory.getLogger(IndexController.class);

	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String index() {
		return "mainPage";
		//String으로 리턴되는 것들은 mainPage를 말한다?
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(HttpSession session) {
		//WEB-INF/view/login/login.jsp
		
//		if( session.getAttribute("_MEMBER_") == null) {
//			//로그인을 하지 않았을 때의 처리
//			//return "redirect: http://www.daum.net" : 절대 URL 
//			//return "redirect:home" : 상대 URL
//			//return "http://localhost:8080/home"
//			//return "redirect:/home" : 같은 도메인의 절대 URL (상대 URL과의 차이점은 도메인이 있다 없다의 차이)
//			//Redirect 는 reponse.sendRedirect와 같이 대량의 데이터를 보낼 수 없다.  
//			return "redirect:/home";
//		}
		return "login/login";
	}
	
	@RequestMapping(value="/doLogin", method=RequestMethod.POST)
//	public String doLogin(HttpServletRequest request) {
//	변수의 명이 파라미터와 같다면 적을 필요 없다. 
//	public String doLogin(@RequestParam("id") String id) {
//	public String doLogin(HttpServletRequest request, @RequestParam String id, @RequestParam String password) {
//	public ModelAndView doLogin(@PathVariable String memberId, @Valid LoginVO loginVO, Errors errors, HttpSession session, HttpServletRequest request) {
	public ModelAndView doLogin(@Valid LoginVO loginVO, Errors errors, HttpSession session, HttpServletRequest request) {
		
		ModelAndView view = new ModelAndView();
		
		//에러가 있느냐 
		if (errors.hasErrors() ) {
			//있을 경우
			view.setViewName("login/login");
			return view;
		}
		
		view.setViewName("redirect:/home");
		
		MultipartFile uploadFile = loginVO.getUploadFile();
		
		if ( !uploadFile.isEmpty() ) {
			// 같은 파일을 올리더라도 중복되지 않고 random 값으로 제목이 입력된다. 
			// UUID 는 전세계 인들이 동일한 버튼을 누르더라도 각자 다른 것을 받아오게 된다. 
//			String randomFileName = UUID.randomUUID().toString();
			File tempFile = new File("D:\\" + uploadFile.getOriginalFilename());
//			File tempFile = new File("D:\\" + randomFileName);
			try {
				uploadFile.transferTo(tempFile);
				
				// getAbsolutePath() : 파일이 존재하는 절대 경로 
				String filePath = tempFile.getAbsolutePath(); 
				// exel 파일인지 묻는 것 (확장자 명으로)
				if (filePath.toUpperCase().endsWith(".XLS") || filePath.toUpperCase().endsWith(".XLSX")) {
					ReadOption option = new ReadOption();
					option.setFilePath(filePath);
					option.setOutputColumns("A", "B", "C");
					option.setStartRow(1);
					
					List<Map<String, String>> excel = ExcelRead.read(option);
					String content = "";
					for (Map<String, String> map : excel) {
						content = "";
						content += map.get("A");
						content += "\t";
						content += map.get("B");
						content += "\t";
						content += map.get("C");
						logger.info(content);
					}
					
				}
			} catch (IllegalStateException | IOException e) {
				throw new RuntimeException(e.getMessage(), e);
			}
		}
		
//		String id = request.getParameter("id");
//		String password = request.getParameter("password");
		
		session.setAttribute("_MEMBER_", loginVO.getId());
		
		
		
		return view;
	}
}
