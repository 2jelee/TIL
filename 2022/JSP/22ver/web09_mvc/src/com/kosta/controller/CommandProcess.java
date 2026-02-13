package com.kosta.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommandProcess {
	
	/*public void doProcess(HttpServletRequest  request , 
			HttpServletResponse response) throws Throwable;   // 추상메소드
	 */
	
	public String doProcess(HttpServletRequest  request , 
			HttpServletResponse response) throws Throwable;   // 추상메소드
}
