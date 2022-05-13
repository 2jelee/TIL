package edu.kosa.model;

// Model
public class DeptDTO { 
	
	private int dcode, pdept;
	private String dname, area;
	
	public int getDcode() {
		return dcode;
	}
	public void setDcode(int dcode) {
		this.dcode = dcode;
	}
	public int getPdept() {
		return pdept;
	}
	public void setPdept(int pdept) {
		this.pdept = pdept;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	
	@Override
	public String toString() {
		return "DeptDTO [dcode=" + dcode + ", pdept=" + pdept + ", dname=" + dname + ", area=" + area + "]";
	}  
	
}
