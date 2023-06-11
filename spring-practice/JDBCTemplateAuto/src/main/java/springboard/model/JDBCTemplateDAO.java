package springboard.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

/* 
JdbcTemplate 관련 주요메소드

[이하 공통 => select계열의 쿼리문  << 기존의 내용을 변경하지 X]
//Object로 반환한다 => 모든 형으로 반환 가능하다
Object queryForObject(String sql, RowMapper rm)
	: '하나의 레코드나 하나의 결과값'을 반환하는 select계열의 쿼리문을 실행할때 사용한다.
	>> 인파라미터 없는
Object queryForObject(String sql, Object[] args, RowMapper rm)
	: '인파라미터가 있'고 하나의 레코드를 반환하는
	select 계열의 쿼리문 실행에 사용한다.
	>> 인파라미터 있는
	
List query(String sql, RowMapper rm)
	: '여러개'의 레코드를 반환하는 select계열의 쿼리문인 경우 사용함.
List query(String sql, Object[] args, RowMapper rm)
	: 인파라미터를 가진 여러개의 레코드를 반환하는 
	select계열의 쿼리문인 경우 사용함.
	>> 인파라미터를 가져오는 부분은 Object[] args로 배열처리
	
	
[이하 공통 => update/insert/delete 계열의 쿼리문  << 기존의 내용을 변경하는 O]	
int update(String sql)
	: 인파라미터가 없는 update/insert/delete 쿼리문을 처리할때 사용한다.
int update(String sql, Object[] args)
	: 인파라미터가 있는 update/insert/delete 쿼리문을 처리할때 사용한다.
	
int >> 성공/실패 확인 가능
*/

@Repository
public class JDBCTemplateDAO {

	/*
	컨트롤러에서 @Autowired를 통해 자동 주입받았던 빈을
	정적변수인 JdbcTemplateConst.template에 값을 할당했으므로
	DB연결정보를 DAO에서 바로 사용할 수 있다. (보다 간결해짐)
	 */
	@Autowired
	JdbcTemplate template;
	public JDBCTemplateDAO() {
		System.out.println("JDBCTemplateDAO() 생성자 호출");
	}
	public void close() {
		/*
		JDBCTemplate에서는 자원해제를 사용하지 X.
		Spring 설정파일에서 빈을 생성하므로 자원을 해제하면
		다시 new를 통해 생성해야하므로 자원해제를 사용하지 X
		*/
	}
	
	//게시물 수 카운트
	public int getTotalCount(Map<String, Object> map) {
		String sql = "SELECT COUNT(*) FROM springboard ";
		
		if(map.get("Word")!=null) {
			sql +=" WHERE "+map.get("Column")+ " "
				+ " 	LIKE '%"+map.get("Word")+"%' ";
		}
		//쿼리문에서 count(*)를 통해 반환되는 값을 정수 형태로 가져옴.
		return template.queryForObject(sql, Integer.class);
	}
	
	//게시판 리스트 가져오기(페이지 처리 없음)
	public ArrayList<SpringBbsDTO> list(Map<String, Object> map){
		
		String sql = "SELECT * FROM springboard ";
			if(map.get("Word")!=null) {
				sql +=" WHERE "+map.get("Column")+" "
					+ " LIKE '%"+map.get("Word")+"%' ";
			}
			sql += " ORDER BY idx DESC";
		
		/*
		RowMapper가 select를 통해 얻어온 ResultSet을 DTO객체에 저장하고
		List컬렉션에 적재하여 반환한다.
		그러므로 DAO에서 개발자가 반복적으로 하던 작업을 지동으로 처리해준다.
		 */
		return (ArrayList<SpringBbsDTO>)template
				.query(sql, new BeanPropertyRowMapper<SpringBbsDTO>(SpringBbsDTO.class));	
	}
	
	
	
	//글쓰기 처리1
	public void write(final SpringBbsDTO springBbsDTO) { //커맨드객체 : SpringBbsDTO
		//final을 지울경우(선언하지 않으면) error
		/*
		Java의 규칙 :
			매개변수로 전달되는 값을 익명클래스 내에서 사용할 때에는
			반드시 final로 선언하여 값의 변경이 불가능하게 처리해야 한다.
		 */
		
		/*
		//원래 =>
		참조변수 = new PreparedStatementCreator(){
			@Override ~
		 */
		
		template.update(new PreparedStatementCreator() { //PreparedStatementCreator는 익명클래스임. 이를 볼줄 알아야한다.
			
			//PreparedStatementCreator의 자식 영역 //@Override = 상속받는다 << 자식!
			@Override
			public PreparedStatement createPreparedStatement(Connection con) 
					throws SQLException {
				
				/*
				답변형 게시판에서 원본글인 경우, idx와 bgroup은 반드시 일치해야 한다.
				리스트에서 게시물 정렬 시 bgroup을 통해 order by절을 구성하기 때문임.
				또한 NEXTVAL은 한 문장에서 여러번 사용하더라도 항상 같은 시퀀스를 반환함.
				'
				**bgroup
				jsp에서 만든 게시판 방식은 idx을 값을 가지고 order by desc; 했다.
				지금 만드는 답변형 게시판의 방식은 idx대신 그룹화된 컬럼인 bgroup으로 order by할 것임.
				 */
				String sql = "INSERT INTO springboard ("
						+ " idx, name, title, contents, hits "
						+ " , bgroup, bstep, bindent, pass) "
						+ " VALUES ("
						+ " springboard_seq.NEXTVAL,?,?,?,0,"
						+ " springboard_seq.NEXTVAL,0,0,?)";
				/*
				NEXTVAL : 다음 시퀀스가 나온다.
					여러번 쓰면 다른 값이 나오는가?
					No. 하나의 쿼리문에서 NEXTVAL을 여러번 쓰더라도 같은 값을 반환한다.
				 */
				
				PreparedStatement psmt = con.prepareStatement(sql);
				psmt.setString(1, springBbsDTO.getName());
				psmt.setString(2, springBbsDTO.getTitle());
				psmt.setString(3, springBbsDTO.getContents());
				psmt.setString(4, springBbsDTO.getPass());
				
				//인파라미터를 설정한 후 객체를 반환한다.
				return psmt; //psmt를 반환하여 update 메소드가 동작(처리).
			}
		});
	}
	
	
	//조회수 증가 << 게시물의 일련번호(idx) 필요
	public void updateHit(final String idx) {	// final임을 확인!
		//쿼리문 작성
		String sql = "UPDATE springboard SET "
				+ " hits=hits+1 "
				+ " WHERE idx=? ";
		
		//update의 첫번째 인자로 쿼리문, 두번째 인자는 익명클래스를 통해
		//인파라미터 설정
		template.update(sql, new PreparedStatementSetter() { //PreparedStatementSetter << 익명 클래스
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				//인파라미터 설정
				ps.setInt(1, Integer.parseInt(idx));
			}
		});
	}
	
	//상세보기 위한 레코드 가져오기 (view메소드가 내용을 가져오는)
	public SpringBbsDTO view(String idx) {
		
		//조회수 증가를 위한 메소드 호출
		updateHit(idx);
		
		//쿼리문 작성
		SpringBbsDTO dto = new SpringBbsDTO();
		String sql = "SELECT * FROM springboard "
				+ " WHERE idx="+idx;
		try {
			/*
			하나의 결과를 반환하는 select 계열의 쿼리문을 실행할 때는 
			queryForObject() 메소드를 사용한다.
			단, 반환결과가 0이거나 2이상이면 예외를 발생시키므로
				반드시 예외처리하는 것이 좋다.	 << 반환결과가 1개만 나오게 되어있기 때문
			 */
			dto = template.queryForObject(sql, 
					new BeanPropertyRowMapper<SpringBbsDTO>(
						SpringBbsDTO.class));
		}
		catch (Exception e) {
			System.out.println("View() 실행 시 예외발생");
		}
		return dto;
	}
	
	
	//패스워드 검증하기
	public int password(String idx, String pass) {
		int retNum = 0;
		String sql = "SELECT * FROM springboard "
				+ " WHERE pass="+pass+" AND idx="+idx;
		
		try {
			SpringBbsDTO dto = template.queryForObject(sql, 
				new BeanPropertyRowMapper<SpringBbsDTO>(
					SpringBbsDTO.class)); //검증이 완료되면 dto로 
			
			/*
			일련번호는 시퀀스를 사용하므로 반드시 1이상의 값을 가지게 된다.
			따라서 0이하의 값이 반환된다면 패스워드 검증 실패로 판단할 수 있다.
			 */
			retNum = dto.getIdx(); //sequence는 기본적으로 1이상의 값을 가지므로 이로 판단 가능 | 0이하 << 실패
		}
		catch (Exception e) {
			System.out.println("password() 예외발생");
		}
		
		return retNum;
	}
	
	
	//수정 처리
	public void edit(final SpringBbsDTO dto) {
		String sql = "UPDATE springboard "
				+ " SET name=?, title=?, contents=?"
				+ " WHERE idx=? AND pass=?";
		
		template.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, dto.getName());
				ps.setString(2, dto.getTitle());
				ps.setString(3, dto.getContents());
				ps.setInt(4, dto.getIdx());
				ps.setString(5, dto.getPass());
			}
		});
	}
	
	
	//삭제처리
	public void delete(final String idx, final String pass) { //final << 익명 클래스 내에서 쓰기 위해
		
		String sql = "DELETE FROM springboard "
				+ " WHERE idx=? AND pass=?";
		
		template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, idx);
				ps.setString(2, pass);
				
			}
		});
	}
	
	
	public void reply(final SpringBbsDTO dto) {
		
		//답변 글쓰기 전 레코드 업데이트
		replyPrevUpdate(dto.getBgroup(), dto.getBstep()); //아래에 replyPrevUpdate()를 생성함으로써 주석 해제함.
		
		/*
		답변글의 경우라도 새로운 게시물이므로 일련번호를
		새로운 시퀀스를 입력해야 한다. 					<< springboard_seq.nextval로?
		글쓰기(write)와 다른 점은 원본글의 bgroup번호를 그대로 입력하는 것임. 
		 */
		String sql = "INSERT INTO springboard "
				+ " (idx, name, title, contents, pass, "
				+ " bgroup, bstep, bindent) "
				+ " VALUES "
				+ " (springboard_seq.nextval, ?, ?, ?, ?,"
				+ " ?, ?, ?)";
		
		template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {

				ps.setString(1, dto.getName());
				ps.setString(2, dto.getTitle());
				ps.setString(3, dto.getContents());
				ps.setString(4, dto.getPass());
				ps.setInt(5, dto.getBgroup()); //원본글의 bgroup번호를 그대로 입력함
				//원본글의 bstep, bindent를 +1 한 후 입력함.
				ps.setInt(6, dto.getBstep()+1); //동일 그룹 내에서 정렬 순서
				ps.setInt(7, dto.getBindent()+1); //답변글의 깊이
			}
		});
	}
	
	
	//listPage() 메소드 추가
	//리스트 가져오기 [페이지처리 O]
	public ArrayList<SpringBbsDTO> listPage( 
			Map<String, Object> map){
		
		int start = Integer.parseInt(map.get("start").toString());
		int end = Integer.parseInt(map.get("end").toString());
		
		String sql = ""
				+"SELECT * FROM ("
				+"    SELECT Tb.*, rownum rNum FROM ("
				+"        SELECT * FROM springboard ";				
			if(map.get("Word")!=null){
				sql +=" WHERE "+map.get("Column")+" "
					+ " LIKE '%"+map.get("Word")+"%' ";				
			}			
			sql += " ORDER BY bgroup DESC, bstep ASC"	//order by idx가 아님을 확인!
			+"    ) Tb"
			+")"
			+" WHERE rNum BETWEEN "+start+" and "+end;
		
		return (ArrayList<SpringBbsDTO>)
			template.query(sql, 
				new BeanPropertyRowMapper<SpringBbsDTO>(
				SpringBbsDTO.class));
		}

	
	/*
	답변글을 입력하기 전 현재 step보다 큰 게시물들을 일괄적으로 step+1해서
	뒤로 밀어주는 작업을 진행한다.
	 */
	public void replyPrevUpdate(final int strGroup, final int strStep) {
		
		String sql = "UPDATE springboard "
				+ " SET bstep = bstep+1 "
				+ " WHERE bgroup=? AND bstep>?";
		
		template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, strGroup);
				ps.setInt(2, strStep);
			}
		});
	}
}
