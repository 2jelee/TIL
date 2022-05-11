package edu.kosa.dao_di;

public class UserDAO { // 추상 클래스 
	private ConnectionMaker connectionMaker;
	
	// DI
	public UserDAO(ConnectionMaker connectionMaker) {
		this.connectionMaker = connectionMaker;
	}

	// 3. 사용 
}
