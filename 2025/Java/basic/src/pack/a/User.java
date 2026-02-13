package pack.a;

public class User {
    /**
     *  **참고**: 생성자에 `public` 을 사용했다. 다른 패키지에서 이 클래스의 생성자를 호출하려면 `public` 을 사용해야 한다.
     * 자세한 내용은 접근 제어자에서 설명한다. 지금은 코드와 같이 생성자에 `public` 키워드를 넣어두자.
     */
    public User(){
        System.out.println("패키지 pack.a 회원 생성");
    }
}
