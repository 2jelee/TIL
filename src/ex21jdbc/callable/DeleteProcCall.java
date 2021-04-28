package ex21jdbc.callable;

import java.sql.Types;

import ex21jdbc.connect.IConnectImpl;

public class DeleteProcCall extends IConnectImpl {

	public DeleteProcCall() {
		super("kosmo", "1234");
	}
	
	@Override
	public void execute() {
		try {
			//Connection객체의 prepareCall() 메소드를 통해 프로시저 호출
			csmt = con.prepareCall("{call KosmoMemberDelete(?,?)}");
			/*
			In파라미터 설정 : 실제 삭제할 아이디를 입력받은후 전달
			Out파라미터 설정 : 반환되는 값에 대한 타입만 설정
			 */
			csmt.setString(1, scanValue("삭제할아이디"));
			csmt.registerOutParameter(2, Types.VARCHAR);
			csmt.execute();
			
			System.out.println("삭제프로시저 실행결과:");
			System.out.println(csmt.getString(2));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}		
	}
	
	public static void main(String[] args) {	
		new DeleteProcCall().execute();
	}
}
