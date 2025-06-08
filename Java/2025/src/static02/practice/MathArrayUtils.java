package static02.practice;

/**
 * sum(int[] array)` : 배열의 모든 요소를 더하여 합계를 반환합니다.
 * `average(int[] array)` : 배열의 모든 요소의 평균값을 계산합니다.
 * `min(int[] array)` : 배열에서 최소값을 찾습니다.
 * `max(int[] array)` : 배열에서 최대값을 찾습니다.
 */
public class MathArrayUtils {
//    private static int[] array;

    /**
     * `MathArrayUtils` 은 객체를 생성하지 않고 사용해야 합니다.
     * 누군가 실수로 `MathArrayUtils` 의 인스턴스를 생성하지 못하게 막으세요.
     */
    // 생성자를 private으로 막아버림.
    private MathArrayUtils(){
        // private 인스턴스 생성을 막는다.
    }

    // 배열의 모든 요소를 더하여 합계를 반환합니다.
    public static int sum(int[] values){
        int total = 0;
        for (int value : values){
            total += value;
        }
        return total;
    }

    // 소수점 고려 -> double
    public static double average(int[] values){
        return (double) sum(values) / values.length;
    }

    public static int min(int[] values){
        int minValue = values[0]; // 하나씩 비교하고자.
        for (int value : values) {
            if(value < minValue){
                minValue = value;
            }
        }
        return minValue;
    }

    public static int max(int[] values){
        int maxValue = values[0];
        for (int value : values){
            if(value > maxValue){
                maxValue = value;
            }
        }
        return maxValue;
    }
}
