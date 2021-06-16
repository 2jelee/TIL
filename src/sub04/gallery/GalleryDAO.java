package sub04.gallery;

import java.util.List;
import java.util.Map;
import java.util.Vector;

import common.ConnectionPool;

public class GalleryDAO extends ConnectionPool {

	public GalleryDAO() {
		super();
	}	
	//게시물 갯수 카운트
	public int selectCount(Map<String, Object> map) {
		int totalCount = 0;		
		String query = "SELECT COUNT(*) FROM gallery";		
		if(map.get("searchWord")!=null) {
			query += " WHERE "+ map.get("searchField") +" "
					+ " LIKE '%"+ map.get("searchWord") +"%'";
		}
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);			
			rs.next();
			totalCount = rs.getInt(1);
		}
		catch(Exception e) {
			System.out.println("게시물 카운트중 예외발생");
			e.printStackTrace();
		}

		return totalCount;
	}
	
	//목록 보기
	public List<GalleryDTO> selectListPage(Map<String,Object> map){
		List<GalleryDTO> bbs = new Vector<GalleryDTO>();
		String query = "SELECT * FROM gallery ";
		if(map.get("searchWord")!=null)
		{
			query +=" WHERE "+ map.get("searchField") +" "
					+" LIKE '%"+ map.get("searchWord") +"%' "; 
		}
		query += " ORDER BY idx DESC LIMIT ?, ?";
 
		try {
			psmt = con.prepareStatement(query);
			psmt.setInt(1, Integer.parseInt(map.get("start").toString()));
			psmt.setInt(2, Integer.parseInt(map.get("end").toString()));
			rs = psmt.executeQuery();
			while(rs.next()) {
				GalleryDTO dto = new GalleryDTO();
				
				dto.setIdx(rs.getString(1));
//				dto.setName(rs.getString(2));
				dto.setId(rs.getString("id"));
				dto.setTitle(rs.getString("title"));
				dto.setVisitCount(rs.getInt("visitcount"));	//? int로 만들었나?
				dto.setPostdate(rs.getDate("postdate"));
//				dto.setContent(rs.getString(5));
				dto.setOfile(rs.getString("ofile"));
//				dto.setSfile(rs.getString(8));
//				dto.setDowncount(rs.getInt(9));
//				dto.setPass(rs.getString(10));
				
				bbs.add(dto);
			}
		}
		catch(Exception e) {
			System.out.println("게시물 조회중 예외발생");
			e.printStackTrace();
		}
		return bbs;
	}
	
	//글 작성하기
	public int insertWrite(GalleryDTO dto) {
		int result = 0;
		try {
			String query = "INSERT INTO gallery ( "
				+ " id,title,content,ofile,sfile) "
				+ " VALUES ( "
				+ " ?,?,?,?,?)";
			psmt = con.prepareStatement(query);
//			psmt.setString(1, dto.getName());
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getTitle());
			psmt.setString(3, dto.getContent());
			psmt.setString(4, dto.getOfile());
			psmt.setString(5, dto.getSfile());
//			psmt.setString(6, dto.getPass());
			result = psmt.executeUpdate();
		} 
		catch(Exception e) {
			System.out.println("게시물 입력중 예외발생");
			e.printStackTrace();
		}
		return result;
	}
	
	//내용 보기
	public GalleryDTO selectView(String idx) {
		GalleryDTO dto = new GalleryDTO();
		String query = "SELECT * FROM gallery WHERE idx=?";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, idx);
			rs = psmt.executeQuery();
			if(rs.next()) {
				dto.setIdx(rs.getString(1));
				dto.setId(rs.getString("id"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setPostdate(rs.getDate("postdate"));
				dto.setVisitCount(rs.getInt("visitcount"));
//				dto.setIdx(rs.getString(1));
//				dto.setIdx(rs.getString(1));
//				dto.setIdx(rs.getString(1));
//				dto.setName(rs.getString(2));
//				dto.setId(rs.getString(2));
//				dto.setTitle(rs.getString(3));
//				dto.setContent(rs.getString(4));
//				dto.setPostdate(rs.getDate(5));
//				dto.setOfile(rs.getString(6));
//				dto.setSfile(rs.getString(7));
//				dto.setDowncount(rs.getInt(8));
//				dto.setPass(rs.getString(9));
//				dto.setVisitCount(rs.getInt(10));
			}
		}
		catch(Exception e) {
			System.out.println("게시물 상세보기중 예외발생");
			e.printStackTrace();
		}
		return dto;
	}
	
	
	
	//게시물 조회수 증가
	public void updateVisitCount(String idx) {
		String query = "UPDATE gallery SET "
			+ " visitcount=visitcount+1 "
			+ " WHERE idx=?";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, idx);
			psmt.executeQuery();
		}
		catch(Exception e) {
			System.out.println("게시물 조회수증가중 예외발생");
			e.printStackTrace();
		}
	} 
	//파일 다운로드 카운트
	public void downCountPlus(String idx){
		String sql = "UPDATE gallery SET "
				+ " downcount=downcount+1 "
				+ " WHERE idx=? ";
		try{
			psmt = con.prepareStatement(sql);
			psmt.setString(1, idx);
			psmt.executeUpdate();
		}
		catch(Exception e){}
	}
	public boolean confirmPassword(String pass, String idx) {
		boolean isCorr = true;
		try {
			//일련번호와 패스워드가 일치하는 게시물이 있는지 확인
			String sql = "SELECT COUNT(*) FROM gallery WHERE pass=? AND idx=?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, pass);
			psmt.setString(2, idx);
			rs = psmt.executeQuery();
			rs.next();
			if(rs.getInt(1)==0) {
				//패스워드가 일치하는 게시물이 없으므로 false
				isCorr = false;
			}
		}
		catch(Exception e) {
			//예외가 발생하여 확인이 불가하므로 false
			isCorr = false;
			e.printStackTrace();
		}
		return isCorr;
	}
	//삭제처리
	public int deletePost(String idx) {
		int result = 0;
		try {
			//비밀번호 검증후 즉시 삭제하므로 비밀번호는 조건에서 제외한다. 
			String query = "DELETE FROM gallery WHERE idx=?";
			psmt = con.prepareStatement(query);
			psmt.setString(1, idx);
			result = psmt.executeUpdate();
		}
		catch(Exception e) {
			System.out.println("게시물 삭제중 예외발생");
			e.printStackTrace();
		}
		return result;
	}
	//수정처리
	public int updatePost(GalleryDTO dto) {
		int result = 0;
		try {
			//비회원제 게시판이므로 패스워드까지 where절에 추가함.
			String query = "UPDATE gallery SET "
					+ " title=?, name=?, content=?, ofile=?, sfile=? "
					+ " WHERE idx=? and pass=?";
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getName());
			psmt.setString(3, dto.getContent());
			psmt.setString(4, dto.getOfile());	
			psmt.setString(5, dto.getSfile());	
			psmt.setString(6, dto.getIdx()); 
			psmt.setString(7, dto.getPass());
			result = psmt.executeUpdate();
		}
		catch(Exception e) {
			System.out.println("게시물 수정중 예외발생");
			e.printStackTrace();
		}
		return result;
	}
//public class GalleryDAO extends ConnectionPool {
//
//	public GalleryDAO() {
//		super();
//	}
//	
//	//게시물 갯수 카운트
//	public int selectCount(Map<String, Object> map) {
//		int totalCount = 0;
//		String query = "SELECT COUNT(*) FROM gallery";
//		if(map.get("searchWord")!=null) {
//			query += " WHERE " + map.get("searchField") +" "
//					+ " LIKE '%" + map.get("searchWord") +"%'";
//		} 
//		try {
//			stmt = con.createStatement();
//			rs = stmt.executeQuery(query);
//			rs.next();
//			totalCount = rs.getInt(1);
//		}
//		catch (Exception e) {
//			System.out.println("게시물 카운트중 예외 발생");
//			e.printStackTrace();
//		}
//		return totalCount;
//	}
//	
//	
//	//목록 보기
//	public List<GalleryDTO> selectListPage(Map<String,Object> map){
//		List<GalleryDTO> bbs = new Vector<GalleryDTO>();
//		String query = "SELECT * FROM gallery ";
//		if(map.get("searchWord")!=null)
//		{
//			query +=" WHERE "+ map.get("searchField") +" "
//					+" LIKE '%"+ map.get("searchWord") +"%' "; 
//		}
//		query += " ORDER BY idx DESC LIMIT ?, ?";
// 
//		try {
//			psmt = con.prepareStatement(query);
//			psmt.setInt(1, Integer.parseInt(map.get("start").toString()));
//			psmt.setInt(2, Integer.parseInt(map.get("end").toString()));
//			rs = psmt.executeQuery();
//			while(rs.next()) {
//				GalleryDTO dto = new GalleryDTO();
//				
//				dto.setIdx(rs.getString(1));
//				
//				dto.setName(rs.getString(2));
////				dto.setId(rs.getString(2));
//				dto.setTitle(rs.getString(3));
//				dto.setContent(rs.getString(4));
//				dto.setPostdate(rs.getDate(5));
//				dto.setOfile(rs.getString(6));
//				dto.setSfile(rs.getString(7));
//				dto.setDowncount(rs.getInt(8));
//				dto.setPass(rs.getString(9));
//				dto.setVisitCount(rs.getInt(10));
//				
//				bbs.add(dto);
//			}
//		}
//		catch(Exception e) {
//			System.out.println("게시물 조회중 예외발생");
//			e.printStackTrace();
//		}
//		return bbs;
//	}
//	
//	
//	
//	
//	
//	public int insertWrite(GalleryDTO dto) {
//		int result = 0;
//		try {
//			String query = "INSERT INTO gallery ( "
//				+ " id,title,content,ofile,sfile,pass) "
//				+ " VALUES ( "
//				+ " ?,?,?,?,?,?)";
//			psmt = con.prepareStatement(query);
////			psmt.setString(1, dto.getName());
//			psmt.setString(1, dto.getId());
//			psmt.setString(2, dto.getTitle());
//			psmt.setString(3, dto.getContent());
//			psmt.setString(4, dto.getOfile());
//			psmt.setString(5, dto.getSfile());
//			psmt.setString(6, dto.getPass());
//			result = psmt.executeUpdate();
//		} 
//		catch(Exception e) {
//			System.out.println("게시물 입력중 예외발생");
//			e.printStackTrace();
//		}
//		return result;
//	}
//	
//	
//	//내용 보기
//	public GalleryDTO selectView(String idx) {
//		GalleryDTO dto = new GalleryDTO();
//		String query = "SELECT * FROM gallery WHERE idx=?";
//		try {
//			psmt = con.prepareStatement(query);
//			psmt.setString(1, idx);
//			rs = psmt.executeQuery();
//			if(rs.next()) {
//				dto.setIdx(rs.getString(1));
////				dto.setName(rs.getString(2));
//				dto.setId(rs.getString(2));
//				dto.setTitle(rs.getString(3));
//				dto.setContent(rs.getString(4));
//				dto.setPostdate(rs.getDate(5));
//				dto.setOfile(rs.getString(6));
//				dto.setSfile(rs.getString(7));
//				dto.setDowncount(rs.getInt(8));
//				dto.setPass(rs.getString(9));
//				dto.setVisitCount(rs.getInt(10));
//			}
//		}
//		catch(Exception e) {
//			System.out.println("게시물 상세보기중 예외발생");
//			e.printStackTrace();
//		}
//		return dto;
//	}
//	
//	
//	//게시물 조회수 증가
//	public void updateVisitCount(String idx) {
//		String query = "UPDATE gallery SET "
//			+ " visitcount=visitcount+1 "
//			+ " WHERE idx=?";
//		try {
//			psmt = con.prepareStatement(query);
//			psmt.setString(1, idx);
//			psmt.executeQuery();
//		}
//		catch(Exception e) {
//			System.out.println("게시물 조회수증가중 예외발생");
//			e.printStackTrace();
//		}
//	} 
//	
//	
//	//파일 다운로드 카운트
//	public void downCountPlus(String idx){
//		String sql = "UPDATE gallery SET "
//				+ " downcount=downcount+1 "
//				+ " WHERE idx=? ";
//		try{
//			psmt = con.prepareStatement(sql);
//			psmt.setString(1, idx);
//			psmt.executeUpdate();
//		}
//		catch(Exception e){}
//	}
//	
//	
//	public boolean confirmPassword(String pass, String idx) {
//		boolean isCorr = true;
//		try {
//			//일련번호와 패스워드가 일치하는 게시물이 있는지 확인		//2106 추후수정
//			String sql = "SELECT COUNT(*) FROM gallery WHERE pass=? AND idx=?";
//			psmt = con.prepareStatement(sql);
//			psmt.setString(1, pass);
//			psmt.setString(2, idx);
//			rs = psmt.executeQuery();
//			rs.next();
//			if(rs.getInt(1)==0) {
//				//패스워드가 일치하는 게시물이 없으므로 false
//				isCorr = false;
//			}
//		}
//		catch(Exception e) {
//			//예외가 발생하여 확인이 불가하므로 false
//			isCorr = false;
//			e.printStackTrace();
//		}
//		return isCorr;
//	}
//	//삭제처리
//	public int deletePost(String idx) {
//		int result = 0;
//		try {
//			//비밀번호 검증후 즉시 삭제하므로 비밀번호는 조건에서 제외한다. 
//			String query = "DELETE FROM gallery WHERE idx=?";
//			psmt = con.prepareStatement(query);
//			psmt.setString(1, idx);
//			result = psmt.executeUpdate();
//		}
//		catch(Exception e) {
//			System.out.println("게시물 삭제중 예외발생");
//			e.printStackTrace();
//		}
//		return result;
//	}
//	
//	
//	//수정처리
//	public int updatePost(GalleryDTO dto) {
//		int result = 0;
//		try {
//			//비회원제 게시판이므로 패스워드까지 where절에 추가함.
//			String query = "UPDATE gallery SET "
//					+ " title=?, id=?, content=?, ofile=?, sfile=? "
//					+ " WHERE idx=? and pass=?";
//			psmt = con.prepareStatement(query);
//			psmt.setString(1, dto.getTitle());
//			psmt.setString(2, dto.getId());
////			psmt.setString(2, dto.getName());
//			psmt.setString(3, dto.getContent());
//			psmt.setString(4, dto.getOfile());	
//			psmt.setString(5, dto.getSfile());	
//			psmt.setString(6, dto.getIdx()); 
//			psmt.setString(7, dto.getPass());
//			result = psmt.executeUpdate();
//		}
//		catch(Exception e) {
//			System.out.println("게시물 수정중 예외발생");
//			e.printStackTrace();
//		}
//		return result;
//	}
}
