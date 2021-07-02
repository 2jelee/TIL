package mybatis;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;


@Service	
public interface IBoardDAO {
	
	//게시물 갯수 카운트
	public int getTotalCount(ParameterDTO parameterDTO);
	
	//출력할 게시물 가져오기
	public ArrayList<BoardDTO> listPage(ParameterDTO parameterDTO);
	
	//게시물 내용보기
	public ArrayList<BoardDTO> view(ParameterDTO parameterDTO);
	

	
	
//	//수정 처리
//	public int modify(BoardDTO myBoardDTO); //정수의 반환값 가짐
//	
//	
//	//삭제 처리
//	public int delete(String idx, String id); //정수의 반환값 가짐 //수정처리처럼 (MyBoardDTO myBoardDTO);형식으로 해도 O
//	
//	
//	//Map컬렉션 사용을 위한 메소드
//	public ArrayList<BoardDTO> hashMapUse(Map<String, String> hMap);
//	//List컬렉션 사용을 위한 메소드
//	public ArrayList<BoardDTO> arrayListUse(List<String> aList); //다음 MyBoardMapper.xml로 전달

}
