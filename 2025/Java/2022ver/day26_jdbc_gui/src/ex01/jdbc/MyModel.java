package ex01.jdbc;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.table.AbstractTableModel;

public class MyModel extends AbstractTableModel {
	Object[][] data;
	String[] columnName;
	int rows, cols; // 레코드의 행과 열의 갯수를 저장하는 변수
	
	@Override
	public int getColumnCount() { //필드(열)의 갯수
		return columnName.length;
	}

	@Override
	public int getRowCount() {	 //레코드 갯수 알아내기
		return data.length;
	}
	
	// Overload
	//레코드 개수 알아내기 -user method
	public void getRowCount(ResultSet rsScroll) { //레코드 갯수 알아내기
		try {
			rsScroll.last(); //레코드의 마지막 행으로 커서 이동
			rows = rsScroll.getRow();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//valueAt은 데이터 하나하나를 의미함
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
//		return null;
		return data[rowIndex][columnIndex];
	}

	//DB에 저장된 데이터 채움
	public void setData(ResultSet rs) { //executeQuery한 결과 받아옴
		try {
			String title;
			//데이터에 대한 정보 얻어옴
			ResultSetMetaData rsmd = rs.getMetaData();
			cols = rsmd.getColumnCount(); //열의 갯수 얻어오기
			columnName = new String[cols];
			
			for (int i = 0; i < cols; i++) {
				columnName[i] = rsmd.getColumnName(i+1); // i+1 하는 이유 => DB의 배열은 1부터 시작하므로 <-> Java : 0부터
			}
			
			data = new Object[rows][cols];
			int r = 0;
			
			while(rs.next()) {
				for (int i = 0; i < cols; i++) {
					if(i != 1) {	//즉, 없다면
						data[r][i] = rs.getObject(i+1); //number type
					} else {
						data[r][i] = rs.getObject(i+1); //varchar2 type
					}
					r++; //전달되는 r을 증가시키겠다.
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
