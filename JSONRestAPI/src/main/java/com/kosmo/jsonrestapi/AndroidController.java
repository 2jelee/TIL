package com.kosmo.jsonrestapi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import mybatis.IAndroidDAO;
import mybatis.MemberVO;

@Controller
public class AndroidController {

	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping("/android/memberObject.do")
	@ResponseBody
	public Map<String, Object> memberObject(HttpServletRequest req) {
		Map<String, Object> map = new HashMap<String, Object>();
		ArrayList<MemberVO> lists = sqlSession.getMapper(IAndroidDAO.class).memberList();
		map.put("memberList", lists);
		return map;
	}
	
	//JSONArray로 데이터 반환
	@RequestMapping("/android/memberList.do")
	@ResponseBody
	public ArrayList<MemberVO> memberList(HttpServletRequest req) {
		System.out.println("요청들어옴");
		ArrayList<MemberVO> lists = sqlSession.getMapper(IAndroidDAO.class).memberList();
		return lists;
	}
}
