package my.bbs2;

import java.util.*;

import javax.servlet.http.*;

import com.oreilly.servlet.*;
import java.sql.*;

/**
 *  개발자들이 직접 접근하게 될 클래스
 *  API가 되는 클래스
 *
 */
public class BbsManager {
	
	static private BbsManager instance = new BbsManager();
	
	private BbsManager(){
		
	} // 기본 생성자 ------

	public static BbsManager getInstance(){
		return instance;
	}
	
	/** 
		#1. 글쓰기 ... writeOk()
	*/
	public int writeOk(MultipartRequest mr)
		throws SQLException{
		
		BbsDAO dao = new BbsDAO();
		int n = dao.writeOk(mr);
		return n;
		
	}
	
	/**
		#2 .글 목록... listAll()
	*/
	
	public ArrayList<BbsDTO> listAll(int cpage, int pageSize)
		throws SQLException{
		BbsDAO dao = new BbsDAO();
		return dao.listAll(cpage,pageSize);
	}
	/*===========================================*
 	#2_1 총 게시물 수 구하기 관련
 	
 *==========================================*/
	public int getTotalGulCount()
		throws SQLException{
		BbsDAO dao = new BbsDAO();
		return dao.getTotalGulCount();
	}
	
/**===============================================
 	#3. 글내용 보기
 	ViewContent()
 =============================================== */
	public BbsDTO viewContent(String idx)
		throws SQLException{
		BbsDAO dao = new BbsDAO();
		return dao.viewContent(idx);
	}
	
/**=====================================================
 * #3_1. 글내용(viewContent)관련
 * 			조회수 (readnum) 증가 메소드
 ======================================================*/
	public boolean getReadnum(String idx)
		throws SQLException{
		BbsDAO  dao = new BbsDAO();
		return dao.getReadnum(idx);
	}
	
/*==========================================
 	#4. 글 삭제 관련 --deleteOk
 ========================================== */	
	public int deleteOk(String idx, String pwd)
		throws SQLException{
		return new BbsDAO().deleteOk(idx, pwd);
	}
/**======================================================
	#5. 글 내용 편집 관련 --edit
========================================================*/
	public BbsDTO edit(String idx)
		throws SQLException{
		return new BbsDAO().edit(idx);
	}
	
/** ================================================
  	#5_1. 글 편집 성공 여부 관련 --editOk
================================================= */
	public int editOk(HttpServletRequest req)
		throws SQLException{
		return new BbsDAO().editOk(req);
	}
	
/** ================================================
  	#6. 답글 쓰기 관련 --rewirteOk()
================================================= */
	public int rewriteOk(MultipartRequest mr)
		throws SQLException{
		return new BbsDAO().rewriteOk(mr);
	}
	
/**=====================================================
 	#7. 꼬리말 쓰기 관련 ----replySave()
 =======================================================*/
	public int replySave(String idx, String writer, String content, String pwd)
		throws SQLException{
		return new BbsDAO().replySave(idx,writer,content, pwd);
	}
/**=====================================================
 	#7_1. 꼬리말 목록 가져오기 ----replyList()
 =======================================================*/	
	public ArrayList<ReplyDTO> replyList(String idx)
		throws SQLException{
		return new BbsDAO().replyList(idx);
	}
/**=====================================================
 	#7_2. 꼬리말 삭제 ---- replyDelPwd()
=======================================================*/
	public int replyDelPwd(String no, String pwd)
		throws SQLException{
		return new BbsDAO().replyDelPwd(no,pwd);
	}
/* ======================================================*/
} /////////////////////////////////////

