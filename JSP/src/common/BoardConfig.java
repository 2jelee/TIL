package common;

/*
웹 어플리케이션 제작 시 설정값은 인터페이스형 상수를 활용하기도 한다.
인터페이스에 정의된 상수는 public static final로 정의되므로
객체 생성없이 클래스명으로 가져다 쓸 수 있기 때문임.
 */
public interface BoardConfig {
	int PAGE_PER_SIZE = 2; //게시판 목록에서 한 페이지에 출력할 개시물의 갯수
	int PAGE_PER_BLOCK = 2; //한 블럭당 출력할 페이지 번호의 갯수
}
