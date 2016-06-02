package com.ktds.leina.mongo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.leina.mongo.dao.MemoDAO;
import com.ktds.leina.mongo.vo.MemoSearchVO;

@Controller
public class MemoController {
	
	private MemoDAO memoDAO;

	public void setMemoDAO(MemoDAO memoDAO) {
		this.memoDAO = memoDAO;
	}

	@RequestMapping("/write")
	public ModelAndView viewWritePage() {
		ModelAndView view = new ModelAndView();
		view.setViewName("write");
		return view;
	}
	
	@RequestMapping("/list")
	public ModelAndView viewListPage(MemoSearchVO memoSearchVO) {
		return memoDAO.getMemoList(memoSearchVO);
	}
	
	@RequestMapping("/detail/{id}") 
	public ModelAndView viewDetailPage(@PathVariable String id) {
		ModelAndView view = new ModelAndView();
		view.setViewName("detail");
		view.addObject("memo", memoDAO.getMemo(id));
		return view;
	}
	
	@RequestMapping("/doWrite")
	public String doWriteMemoAction(@RequestParam String memo) {
		memoDAO.insertMemo(memo);
		return "redirect:/list";
	}
	
	@RequestMapping("/doUpdate")
	public String doUpdateMemoAction(@RequestParam String id, @RequestParam String memo) {
		memoDAO.updateMemo(id, memo);
		return "redirect:/list";
	}
	
	@RequestMapping("/doDelete/{id}") 
	public String doDeleteMemoAction(@PathVariable String id) {
		memoDAO.removeMemo(id);
		return "redirect:/list";
	}
}

