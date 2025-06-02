/* 모든 자연수 x에 대해서 현재 값이 x이면 x가 짝수일 때는 2로 나누고, x가 홀수일 때는 3 * x + 1로 바꾸는 계산을 계속해서 반복하면 언젠가는 반드시 x가 1이 되는지 묻는 문제를 콜라츠 문제라고 부릅니다.
   그리고 위 과정에서 거쳐간 모든 수를 기록한 수열을 콜라츠 수열이라고 부릅니다.
   계산 결과 1,000 보다 작거나 같은 수에 대해서는 전부 언젠가 1에 도달한다는 것이 알려져 있습니다.
   임의의 1,000 보다 작거나 같은 양의 정수 n이 주어질 때 초기값이 n인 콜라츠 수열을 return 하는 solution 함수를 완성해 주세요.
   제한사항) 1 ≤ n ≤ 1,000 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex033_collatzSequence {
    public static void main(String[] args) {
        System.out.println(solution(10));
        System.out.println(solution2());
    }

    public static List<Integer> solution(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(n); 
        while (n != 1) {
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = 3 * n + 1;
            }
            result.add(n);  
        }
        return result;
    }

    public static List<Integer> solution2() {
        Scanner sc = new Scanner(System.in);
        System.out.print("n: ");
        int n = sc.nextInt();
        List<Integer> result = new ArrayList<>();
        result.add(n);
        while (n != 1) {
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = 3 * n + 1;
            }
            result.add(n);
        }
        return result;
    }
}

/* List<Integer> result = new ArrayList<>();
 * Creates an ArrayList to store the resulting sequence with dynamic size.
 * 결과를 저장할 동적 크기 리스트인 ArrayList 객체를 생성한다.
 */

/* result.add(n);
 * Adds the initial value n as the first element of the list.
 * 초기값 n을 리스트에 첫 번째 원소로 추가한다.
 */

/* while (n != 1)
 * Starts a while loop that continues as long as n is not equal to 1.
 * n이 1이 아닐 동안 계속 반복하는 while 루프를 시작한다.
 */

/* if (n % 2 == 0) {
      n = n / 2;
   } else {
      n = 3 * n + 1;
   }
 * Checks whether n is even. If it is, updates n by dividing it by 2.
 * If n is odd, enters the else block and updates n by multiplying by 3 and adding 1.
 * n이 짝수인지 검사한다. n이 짝수일 경우, 2로 나누어 값을 갱신한다.
 * n이 짝수가 아닌 경우(홀수일 경우), else 블록으로 들어간다. 홀수인 n에 대해 3을 곱하고 1을 더해 값을 갱신한다.
 */

/* result.add(n);
 * Adds the updated value of n to the list as the next element in the Collatz sequence.
 * 갱신된 n 값을 리스트에 추가하여 콜라츠 수열의 다음 원소로 저장한다.
 */