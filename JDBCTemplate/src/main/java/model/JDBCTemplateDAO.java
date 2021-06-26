package model;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/*
JdbcTemplate 관련 주요메소드

//Object로 반환한다 => 모든 형으로 반환 가능하다
Object queryForObject(String sql, RowMapper rm)
	: 하나의 레코드나 결과값을 반환하는 select계열의 쿼리문을
	실행할때 사용한다.
	>> 인파라미터 없는
Object queryForObject(String sql, Object[] args, RowMapper rm)
	: '인파라미터가 있'고 하나의 레코드를 반환하는
	select 계열의 쿼리문 실행에 사용한다.
	>> 인파라미터 있는
	
List query(String sql, RowMapper rm)
	: 여러개의 레코드를 반환하는 
	select계열의 쿼리문인 경우 사용함.
List query(String sql, Object[] args, RowMapper rm)
	: 인파라미터를 가진 여러개의 레코드를 반환하는 
	select계열의 쿼리문인 경우 사용함.
	>> 인파라미터를 가져오는 부분은 Object[] args로 배열처리
*/

public class JDBCTemplateDAO {

	/*
	컨트롤러에서 @Autowired를 통해 자동 주입받았던 빈을
	정적변수인 JdbcTemplateConst.template에 값을 할당했으므로
	DB연결정보를 DAO에서 바로 사용할 수 있다. (보다 간결해짐)
	 */
	JdbcTemplate template;
	public JDBCTemplateDAO() {
		this.template = JdbcTemplateConst.template;
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
}
