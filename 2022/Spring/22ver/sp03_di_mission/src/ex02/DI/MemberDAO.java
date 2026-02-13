package ex02.DI;

public class MemberDAO {
	
	private MemberBean vo;
	
	// default 생성
	public MemberDAO() { }

	// DI
	public MemberDAO(MemberBean vo) {
		super();
		this.vo = vo;
	}

	// DI
	public void setVo(MemberBean vo) {
		this.vo = vo;
	}
	
	// 출력용 
	public void insert() {
		System.out.println(vo.getName() + " < " + vo.getAge()+ " > " + vo.getMessage());
	}
}
