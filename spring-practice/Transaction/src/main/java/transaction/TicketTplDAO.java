package transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

public class TicketTplDAO {
	
	//트랜잭션 템플릿을 사용하기 위한 DAO
	
	//멤버변수 선언(XML설정파일에서 빈 생성시 사용함)
	JdbcTemplate template; //Spring-JDBC를 사용
	TransactionTemplate transcationTemplate; //트랜잭션 템플릿 사용
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transcationTemplate = transcationTemplate;
	}
	
	//생성자
	public TicketTplDAO() {
		System.out.println("TicketTplDAO() 생성자 호출됨");
	}
	
	//구매에 대한 트랜잭션 처리
	public boolean buyTicket(final TicketDTO dto) {
		System.out.println("buyTicket()메소드 호출");
		System.out.println(dto.getCustomerId()+"님이 티켓 "+dto.getAmount()+"장을 구매합니다.");
		
		try {
			//트랜잭션 템플릿은 execute()메소드를 통해 트랜잭션 처리를 한다.
			transcationTemplate.execute(new TransactionCallbackWithoutResult() {
				
				//익명클래스 내부에서 오버라이딩
				@Override
				protected void doInTransactionWithoutResult(TransactionStatus arg0) {
					//티켓 구매금액 처리
					template.update(new PreparedStatementCreator() {
						@Override
						public PreparedStatement createPreparedStatement(Connection con) 
								throws SQLException {
							String query = "INSERT INTO transaction_pay (customerId, "
											+ "amount) VALUES (?, ?)";
							PreparedStatement psmt = con.prepareStatement(query);
							psmt.setString(1, dto.getCustomerId());
							psmt.setInt(2, dto.getAmount()*10000);
							return psmt;
						}
					});	
					//티켓구매 장수에 대한 처리
					template.update(new PreparedStatementCreator() {
						@Override
						public PreparedStatement createPreparedStatement(Connection con) 
								throws SQLException {
							String query = "INSERT INTO transaction_ticket (customerId, "
									+ "countNum) VALUES (?, ?)";
							PreparedStatement psmt = con.prepareStatement(query);
							psmt.setString(1, dto.getCustomerId());
							psmt.setInt(2, dto.getAmount());
							return psmt;
						}
					});	
				}
			});
			
			/*
			모든 업무에 대해 성공처리 되었을때 true를 반환함.
			템플릿을 사용하는 경우 별도의 commit() 혹은 rollback()이 필요없다.
			 */
			System.out.println("카드결제와 티켓구매 모두 정상처리 되었습니다.");
			System.out.println("=트랜잭션 템플릿 사용함=");
			return true;
		}
		catch (Exception e) {
			System.out.println("제약조건 위반으로 모두 취소되었습니다.");
			return false;
		}
	}
}
