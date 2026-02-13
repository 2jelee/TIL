package class1;

/**
 문제: 영화 리뷰 관리하기2
 기존 문제에 배열을 도입하고, 영화 리뷰를 배열에 관리하자.
 리뷰를 출력할 때 배열과 `for` 문을 사용해서 `System.out.println` 을 한번만 사용하자.
 * **출력 예시**
 * 영화 제목: 인셉션, 리뷰: 인생은 무한 루프
 * 영화 제목: 어바웃 타임, 리뷰: 인생 시간 영화!
 */
public class MovieReviewMain2 {
    public static void main(String[] args) {
        // 영화 리뷰 정보 선언
        MovieReview[] reviews = new MovieReview[2];

        MovieReview inception = new MovieReview();
        inception.title = "인셉션";
        inception.review = "인생은 무한 루프";
        reviews[0] = inception;

        MovieReview aboutTime = new MovieReview();
        aboutTime.title = "어바웃 타임";
        aboutTime.review = "인생 시간 영화!";
        reviews[1] = aboutTime;

        // 영화 리뷰 정보 출력
        for (MovieReview item: reviews){
            System.out.println("영화 제목: "+item.title + ", "+ "리뷰: "+item.review);

        }
    }
}