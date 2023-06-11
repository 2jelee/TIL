package mybatis;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

//interface << mapper와 ~의 중간다리 역할
/*
해당 인터페이스는 컨트롤러와 DAO사이에서 매개역할을 하는 
서비스 객체로 사용된다.
 */
@Service	//없어도 됨.
public interface MybatisDAOImpl {
	
	//[검색기능 추가 전 - 1차버전에서 사용]
//	//게시물 수 카운트하기
//	public int getTotalCount();
//	//목록에 실제 출력할 게시물 가져오기
//	public ArrayList<MyBoardDTO> listPage(int s, int e);
	
	//[검색기능 추가 후 - 2차버전] : 파라미터를 저장한 DTO를 매개변수로 받음.
	public int getTotalCount(ParameterDTO parameterDTO);
	public ArrayList<MyBoardDTO> listPage(ParameterDTO parameterDTO);
	
	
	/*
	Mapper에서 파라미터를 처리할 수 있는 3번째 방법으로,
	@Param 어노테이션을 사용한다.
	이때는 변수명을 그대로 Mapper에서 사용할 수 있다.
	 */
//	public int write(@Param("_name") String name,
	public void write(@Param("_name") String name,
				@Param("_contents") String contents,
				@Param("_id") String id);
	
	
	//기존 게시물 조회
	public MyBoardDTO view(ParameterDTO parameterDTO);
	
	
	//수정 처리
	public int modify(MyBoardDTO myBoardDTO); //정수의 반환값 가짐
	
	
	//삭제 처리
	public int delete(String idx, String id); //정수의 반환값 가짐 //수정처리처럼 (MyBoardDTO myBoardDTO);형식으로 해도 O
	
	
	//Map컬렉션 사용을 위한 메소드
	public ArrayList<MyBoardDTO> hashMapUse(Map<String, String> hMap);
	//List컬렉션 사용을 위한 메소드
	public ArrayList<MyBoardDTO> arrayListUse(List<String> aList); //다음 MyBoardMapper.xml로 전달

}
