package fileupload;

import java.util.List;
import java.util.Vector;

import javax.servlet.ServletContext;

public class MyfileDAO extends JConnect{	//상속받음으로써 반복 줄이는.. 반복되는 것은 별도의 클래스로 빼낸다.
	
	//생성자에서는 부모생성자를 호출하기 위해 super()를 통해 호출함.
	public MyfileDAO(ServletContext application) {
		super(application);
	}
	
	//파일(게시물) 등록하는 부분
	public int myfileInsert(MyfileDTO dto) {
		int applyResult = 0;
		try {
			String query = "INSERT INTO myfile ( "
					+ " idx, name, title, cate, ofile, sfile) "
					+ " VALUES ( "
					+ " seq_board_num.nextval, ?, ?, ?, ?, ?)";
			
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getTitle());
			psmt.setString(3, dto.getCate());
			psmt.setString(4, dto.getOfile());
			psmt.setString(5, dto.getSfile());
			
			applyResult = psmt.executeUpdate();
		}
		catch (Exception e) {
			System.out.println("insert중 예외발생");
			e.printStackTrace();
		}
		return applyResult;
	}
	
	
	
	//파일리스트 가져오기
	public List<MyfileDTO> myFileList(){
		List<MyfileDTO> fileList = new Vector<MyfileDTO>();
		String query = "SELECT * FROM myfile ORDER BY idx DESC";
		try{
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				MyfileDTO dto = new MyfileDTO();
				dto.setIdx(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setCate(rs.getString(4));
				dto.setOfile(rs.getString(5));
				dto.setSfile(rs.getString(6));
				dto.setPostdate(rs.getString(7));
				
				fileList.add(dto);
			}
		}
		catch (Exception e) {
			System.out.println("Select시 예외발생");
			e.printStackTrace();
		}
		
		return fileList;
	}
}
