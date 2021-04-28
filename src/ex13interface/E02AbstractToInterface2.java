package ex13interface;

/*
추상클래스를 인터페이스로 변경하기
	abstract class => interface
	메소드인 경우 public abstract 제거
	멤버상수인 경우 public static final 제거	
 */
interface PersonalNumberStorageImpl {
	void addPersonalInfo(String juminNum, 
			String name);//정보저장용
	String searchPersonalInfo(String juminNum);//정보검색용
}
//DTO는 정보를 저장하는 용도이므로 변경없음
class PersonalInfoVO { 
	private String name;
	private String juminNum;
	
	public PersonalInfoVO(String name, String juminNum) {
		this.name = name;
		this.juminNum = juminNum;
	}
	//private멤버를 반환하기 위한 getter 메소드 정의
	public String getName() { return name; }
	public String getJuminNum() { return juminNum; }
}
/*
클래스가 클래스를 상속할때 => extends
클래스가 인터페이스를 상속할때 => implements
인터페이스가 인터페이스를 상속할때 => extends 를 사용한다. 

extends는 '상속'이라 표현하고, implements는 '구현'이라 표현한다.
 */
class PersonalNumberStorage implements PersonalNumberStorageImpl {	
	
	PersonalInfoDTO[] personalArr;//정보저장용 객체배열
	int numOfPerInfo;//입력정보 카운트
	//생성자
	public PersonalNumberStorage(int arrSize) {
		personalArr = new PersonalInfoDTO[arrSize];
		numOfPerInfo = 0;
	}
	 
	/*
	상속을 통해 추상메소드를 포함하게 되었으므로 반드시 아래와 같이
	오버라이딩 해야한다. 필수사항이며 하지 않을경우 에러가 발생한다.
	 */
	
	//전달받은 인자를 통해 DTO객체를 생성한 후 객체배열에 추가한다.
	@Override
	public void addPersonalInfo(String juminNum, String name) {		
		personalArr[numOfPerInfo] = 
				new PersonalInfoDTO(name, juminNum);
		numOfPerInfo++;
	}
	//주민번호를 인자로 객체배열을 검색한후 정보를 반환한다. 
	@Override
	public String searchPersonalInfo(String juminNum) {
		for(int i=0 ; i<numOfPerInfo ; i++) {
			if(juminNum.compareTo(personalArr[i].getJuminNum())==0)
			{
				return personalArr[i].getName();
			}
		}
		//검색결과가 없을때는 null을 반환한다.
		return null; 
	}
}

public class E02AbstractToInterface2 {
	public static void main(String[] args) {
		//객체 생성
		PersonalNumberStorage storage = 
			new PersonalNumberStorage(10);
		
		//정보 추가
		storage.addPersonalInfo("901234-2222222", "김태희");
		storage.addPersonalInfo("901234-1111111", "정지훈");
		
		//주민번호를 통해 정보 검색
		System.out.println(storage.searchPersonalInfo("901234-2222222"));
		System.out.println(storage.searchPersonalInfo("901234-1111111"));
		System.out.println(storage.searchPersonalInfo("001024-1090333"));
	}
}
