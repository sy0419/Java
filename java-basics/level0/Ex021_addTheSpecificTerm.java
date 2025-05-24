/* 두 정수 a, d와 길이가 n인 boolean 배열 included가 주어집니다. 첫째항이 a, 공차가 d인 등차수열에서 included[i]가 i + 1항을 의미할 때, 이 등차수열의 1항부터 n항까지 included가 true인 항들만 더한 값을 return 하는 solution 함수를 작성해 주세요.
   제한사항
   1 ≤ a ≤ 100
   1 ≤ d ≤ 100
   1 ≤ included의 길이 ≤ 100
   included에는 true가 적어도 하나 존재합니다. */
   
import java.util.Scanner;

public class Ex021_addTheSpecificTerm {
    public static void main(String[] args) {
        System.out.println(solution(3, 4, new boolean[]{true, false, false, true, true}));
        System.out.println(solution(7, 1, new boolean[]{false, false, false, true, false, false, false}));
        System.out.println(solution2());
    }

    public static int solution(int a, int d, boolean[] included) {
        int result = 0;
        for (int i = 0; i < included.length; i++) {
            if (included[i]) {
                result += a + i * d;
            }
        }
        return result;        
    }

    public static int solution2() {
        Scanner sc = new Scanner(System.in);
        System.out.print("a: ");
        int a = sc.nextInt();
        System.out.print("d: ");
        int d = sc.nextInt();
        System.out.print("Array length: ");
        int n = sc.nextInt();
        System.out.print("included: ");
        boolean [] included = new boolean[n];
        for (int i = 0; i < n; i++) {
            included[i] = sc.nextBoolean();
        }
        int result = 0;
        for (int i = 0; i < included.length; i++) {
            if (included[i]) {
                result += a + i * d;
            }
        }
        return result;   
    }
}

/* boolean [] included = new boolean[n];
 * Creates a boolean array named `included` with length `n`.
 * 길이가 n인 boolean 배열 included를 생성한다.
 */

/* for (int i = 0; i < n; i++) {
 *     included[i] = sc.nextBoolean();
 * }
 * Repeats from 0 to n-1, and stores the user's input (true or false) into included[i].
 * 0부터 n-1까지 반복하면서, 사용자로부터 true 또는 false를 입력받아 included[i]에 저장한다.
 */

/* for (int i = 0; i < included.length; i++) {
 *     if (included[i]) {
 *         result += a + i * d;
 *     }
 * }
 * Iterates through the `included` array, and if the i-th element is true,
 * calculates the value of the corresponding term in the arithmetic sequence and adds it to the result.
 * 포함 배열을 반복하며, i번째 항이 포함될 경우, 해당 항 값을 계산하여 result에 더한다.
 */