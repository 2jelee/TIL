package ex01.jdbc;

// import 시 user패키지(유저가 생성한)가 우선순위가 높으므로 위에 선언하자. 
import connUtil.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class JDBCProjectEx2_DBSetting extends JFrame implements ActionListener{
	// [component 객체 선언]
	JPanel panWest, panSouth;  //왼쪽텍스트필드, 아래쪽 버튼
	JPanel p1,p2,p3,p4,p5; 
	JTextField txtNo, txtName, txtEmail, txtPhone;
	JButton  btnTotal, btnAdd, btnDel, btnSearch, btnCancel;
	
	JTable table; //검색과 전체 보기를 위한 테이블 객체 생성
	//상태변화를 위한 변수 선언
	// final이다. 즉, 값 변경 X
	private static final int NONE = 0;
	private static final int ADD = 1;
	private static final int DELETE = 2;
	private static final int SEARCH = 3;
	private static final int TOTAL = 4;
	int cmd = NONE;
	
	// [생성자 함수] - 멤버변수 초기화 담당
	public JDBCProjectEx2_DBSetting(){
		setTitle("고객 정보 입력 폼");
		
		//component 등록
		panWest = new JPanel(new GridLayout(5, 0)); //행:5 열:0
		p1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p1.add(new JLabel("번    호"));
		p1.add(txtNo = new JTextField(12));
		panWest.add(p1);
		
		p2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p2.add(new JLabel("이    름"));
		p2.add(txtName = new JTextField(12));
		panWest.add(p2);
		
		p3 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p3.add(new JLabel("이  메  일"));
		p3.add(txtEmail = new JTextField(12));
		panWest.add(p3);
		
		p4 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p4.add(new JLabel("전화번호"));
		p4.add(txtPhone = new JTextField(12));
		panWest.add(p4);
		
		p5 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p5.add(new JLabel(""));
		panWest.add(p5);
		
		add(panWest, "West"); //위 panWest ~p5까지 West방향으로 붙이겠다. 
		
		//button 화면 아래 등록
		panSouth = new JPanel();
		panSouth.add(btnTotal= new JButton("전체보기")); 
		panSouth.add(btnAdd= new JButton("추     가"));
		panSouth.add(btnDel= new JButton("삭     제"));
		panSouth.add(btnSearch= new JButton("검     색"));
		panSouth.add(btnCancel= new JButton("취     소"));
		add(panSouth, "South"); //하단(South)으로 붙여줘
		
		//event 처리
		btnTotal.addActionListener(this);
		btnAdd.addActionListener(this);
		btnDel.addActionListener(this);
		btnSearch.addActionListener(this);
		btnCancel.addActionListener(this);
		
		//테이블 객체 생성
		add(new JScrollPane(table = new JTable()), "Center");
		//close
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//메인 창 출력
		//setBounds(100, 100, 700, 300); x좌표 100, y좌표 100, width:700, height:300
		setBounds(100, 100, 700, 300); //setSize(W,H);   pack(); 
		setVisible(true);		
		
		dbConnect();
	} //constuctor end
	
	
	
	/*******************************************************************************/
	//DB Setting
	Connection conn;
	Statement stmt;
	PreparedStatement pstmtInsert, pstmtDelete;
	PreparedStatement pstmtSelect, pstmtScroll;
	PreparedStatement pstmtSearch, pstmtSearchScroll; //pstmtSearch : 조건에 의한 검색
	
	private String sqlInsert = "INSERT INTO Customers values(?, ?, ?, ?)";
	private String sqlDelete = "DELETE FROM customers WHERE code = ?";
	private String sqlSelect = "SELECT * FROM customers"; 
	private String sqlSearch = "SELECT * FROM customers WHERE name = ?";

	
	public void dbConnect() {
		try {
			// DB 연결
			conn = DBConnection.getConnection();
			
			//prepareStatement는 인자 반드시 필요
			pstmtInsert = conn.prepareStatement(sqlInsert);
			pstmtDelete = conn.prepareStatement(sqlDelete);
			pstmtSelect = conn.prepareStatement(sqlSelect);
			pstmtSearch = conn.prepareStatement(sqlSearch);
			
			/*
			 * ResultSet.CONCUR_READ_ONLY : 읽기 전용
			 * ResultSet.CONCUR_UPDATABLE : resultset object의 변경이 가능 <=> read_only
			 */
			pstmtScroll = conn.prepareCall(sqlSelect, 
											ResultSet.TYPE_SCROLL_SENSITIVE, //커서 이동을 자유롭게 하고 업데이트 내용 반영
											ResultSet.CONCUR_UPDATABLE); 
			pstmtSearchScroll = conn.prepareCall(sqlSearch,
												ResultSet.TYPE_SCROLL_SENSITIVE, 
												ResultSet.CONCUR_UPDATABLE);  
		} catch (Exception e) { 
			e.printStackTrace();
		}
	}
	
	
	

	/*******************************************************************************/
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) { // Button Click Event 처리
		Object obj = e.getSource();
		if( obj == btnAdd ){
			if( cmd != ADD ){
				setText(ADD);  //user method
				return;
			} //if in
			setTitle(e.getActionCommand());
			//add();  추가
			
		}else if( obj == btnDel ){
			if( cmd != DELETE ){
				setText(DELETE);  //user method
				return;
			} //if in
			setTitle(e.getActionCommand());
			//del();  삭제
			
		}else if( obj == btnSearch ){
			if( cmd != SEARCH ){
				setText(SEARCH);  //user method
				return;
			} //if in
			setTitle(e.getActionCommand());
			//search();  검색
			
		}else if( obj == btnTotal ){
			setTitle(e.getActionCommand());
			//total();  전체보기
		}
		setText(NONE);
		init(); //초기화 메소드, user method
	}// actionPerformed end
	
	private void init() {  //초기화 메소드
		txtNo.setText("");			txtNo.setEditable(false);
		txtName.setText("");		txtName.setEditable(false);
		txtEmail.setText("");		txtEmail.setEditable(false);
		txtPhone.setText("");		txtPhone.setEditable(false);
	}// init() end

	private void setText(int command) {
		switch(command){
			case ADD :
				txtNo.setEditable(true);
				txtName.setEditable(true);
				txtEmail.setEditable(true);
				txtPhone.setEditable(true);
				break;
			case DELETE :
				txtNo.setEditable(true);
			case SEARCH :
				txtName.setEditable(true);
				break;
		}//switch end
		
		setButton(command);  //user method
	}// setText() end 

	private void setButton(int command) {
		//cancel button 제외하고 어떤 버튼이 눌리더라도 모든 버튼이 비활성화
		btnTotal.setEnabled(false);
		btnAdd.setEnabled(false);
		btnDel.setEnabled(false);
		btnSearch.setEnabled(false);
		 
		switch(command){
			case ADD :
				btnAdd.setEnabled(true);
				cmd = ADD;
				break;
			case DELETE :
				btnDel.setEnabled(true);
				cmd = DELETE;
				break;
				
			case SEARCH :
				btnSearch.setEnabled(true);
				cmd = SEARCH;
				break;
			case TOTAL :
				btnTotal.setEnabled(true);
				cmd = TOTAL;
				break;
			case NONE :
				btnTotal.setEnabled(true);
				btnAdd.setEnabled(true);
				btnDel.setEnabled(true);
				btnSearch.setEnabled(true);
				btnCancel.setEnabled(true);  //
				cmd = NONE;
				break;
		}//switch end	
	}//setButton end

	public static void main(String[] args) {
		new JDBCProjectEx2_DBSetting();
	}
} 