package com.example.client.dto;

public class Req<T> {

	private Header header;
	
	private T httpBody;
	
	public static class Header {  // inner class
		
		private String responceCode;

		public String getResponceCode() {
			return responceCode;
		}

		public void setResponceCode(String responceCode) {
			this.responceCode = responceCode;
		}

		@Override
		public String toString() {
			return "Header [responceCode=" + responceCode + "]";
		}
	}  // class Header end

	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}

	public T getHttpBody() {
		return httpBody;
	}

	public void setHttpBody(T httpBody) {
		this.httpBody = httpBody;
	}

	@Override
	public String toString() {
		return "Req [header=" + header + ", httpBody=" + httpBody + "]";
	}
	
}

/*

// 서버측에서 내려지는 값이 수시로 변경되는 경우가 있다.
{
   "header": {
   		"response_code":"OK"
   },
   "body": {  // body의 내용이 수시로 바뀐다.
   		"name":"kingsmile",   // or "book":"spring boot",
   		"age": 10			  // or "page": 1024
   }
}
 
*/






