package etc_FEB;

/*
[일곱 난쟁이]
Q. 왕비를 피해 일곱 난쟁이들과 함께 평화롭게 생활하고 있던 백설공주에게 위기가 찾아왔다. 
일과를 마치고 돌아온 난쟁이가 일곱 명이 아닌 아홉 명이었던 것이다.
아홉 명의 난쟁이는 모두 자신이 "백설 공주와 일곱 난쟁이"의 주인공이라고 주장했다. 
뛰어난 수학적 직관력을 가지고 있던 백설공주는, 다행스럽게도 일곱 난쟁이의 키의 합이 100이 됨을 기억해 냈다.
아홉 난쟁이의 키가 주어졌을 때, 백설공주를 도와 일곱 난쟁이를 찾는 프로그램을 작성하시오.

입력 : 아홉 개의 줄에 걸쳐 난쟁이들의 키가 주어진다. 
		주어지는 키는 100을 넘지 않는 자연수이며, 아홉 난쟁이의 키는 모두 다르며, 
		가능한 정답이 여러 가지인 경우에는 아무거나 출력한다.
출력 : 일곱 난쟁이의 키를 오름차순으로 출력한다. 
		일곱 난쟁이를 찾을 수 없는 경우는 없다.


예제입력 :  20
			7
			23
			19
			10
			15
			25
			8
			13
예제출력 :  7
			8
			10
			13
			19
			20
			23
*/

/*
 * 해결방법(접근)
 * 브루트포스 알고리즘 : 가능한 모든 경우를 다 해봄으로 답을 찾는 알고리즘
 * 
 * 해당 문제의 경우의 수 : 9!
 * 일곱난쟁이의 키의 합이 100이라고 했다면 난쟁이들 중에 두 난쟁이의 키만 빼고 그 값이 100이어도 위의 논리와 같은 논리가 된다.
 */

import java.util.Scanner;
import java.util.Arrays;

public class Main2309 {
	//1. for문을 돌며 일곱 난쟁이를 하나씩 찾는 코드
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int[] nan = new int[9]; //원래 7명 => 9명이 됨
        for (int i = 0; i < 9; i++) {
        	nan[i] = sc.nextInt();
        }
        Arrays.sort(nan);	//오름차순 - 메서드의 매개 값으로 기본타입 배열이나 String 배열을 지정해주면 자동으로 오름차순 정렬
        int[] arr = new int[7];
        for (int i = 0; i < nan.length-6; i++) {
            for (int j = 0; j < nan.length-5; j++) {
                for (int k = 0; k < nan.length-4; k++) {
                    for (int l = 0; l < nan.length-3; l++) {
                        for (int m = 0; m < nan.length-2; m++) {
                            for (int n = 0; n < nan.length-1; n++) {
                                for (int o = 0; o < nan.length; o++) {
                                    if(nan[i] + nan[j] + nan[k] + nan[l] + nan[m] + nan[n] + nan[o] == 100){
                                        arr[0] = nan[i];
                                        arr[1] = nan[j];
                                        arr[2] = nan[k];
                                        arr[3] = nan[l];
                                        arr[4] = nan[m];
                                        arr[5] = nan[n];
                                        arr[6] = nan[o];
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        Arrays.sort(arr);
        for (int iter : arr) System.out.println(iter); 
	}
	
	/***********************************************************/
	
	/*
	public static void main(String[] args) {
		int nan = 9;	//원래 7명임. 그런데 9명이됨
		int[] arr = new int[nan];
		int sum=0;	//합을 담을 변수
		Scanner sc = new Scanner(System.in); 
		
		for(int i=0; i<nan; i++) {
			arr[i] = sc.nextInt();
			sum+=arr[i];
		}
		Arrays.sort(arr);
		for(int i=0; i<nan; i++) {
			for(int j=i+1; j<nan; j++) {
				if(sum-arr[i]-arr[j]==100) {
					for(int k=0; k<nan; k++) {
						if(i==k || j==k) {
							continue;
						}
						System.out.println(arr[k]);
					}
					System.exit(0);
				}
			}
		}
	}
	*/
	
	/***********************************************************/
	
	/*
	//2. 아홉 난쟁이의 키에서 두 난쟁이의 키를 뺀 코드
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] height = new int[9];
        int sum = 0;
        for(int i = 0; i < 9; i++) {
            height[i] = Integer.parseInt(br.readLine());
            sum += height[i];
        }
        Arrays.sort(height);
        loop: for(int i = 0; i < 8; i++) {
            for(int j = i + 1; j < 9; j++) {
                int num = height[i] + height[j];
                if(sum - num == 100) {
                    printHeight(height, i, j);
                    break loop;
                }
            }
        }
    }

    private static void printHeight(int[] arr, int index1, int index2) {

        for(int i = 0; i < arr.length; i++) {
            if(i != index1 && i != index2) System.out.println(arr[i]);
        }
    } 
	 */
}
