package final01.ex;

public class Member {
    private final String id; // final 키워드 사용
    private String name;

    // 생성자 => 반환타입 없음, 클래스 이름과 동일
    public Member(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // 메서드
//    public void changeData(String id, String name) {
    public void changeData(String name) {
//        this.id = id; //  컴파일 오류
        this.name = name;
    }

    public void print(){
        System.out.println("id : "+id+ ", name : "+name);
    }
}
