/* 정수 start_num와 end_num가 주어질 때, start_num부터 end_num까지의 숫자를 차례로 담은 리스트를 return하도록 solution 함수를 완성해주세요.
   제한사항) 0 ≤ start_num ≤ end_num ≤ 50 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex032_countUp {
    public static void main(String[] args) {
        System.out.println(solution(3, 10));
        System.out.println(solution2());
    }

    public static List<Integer> solution(int start_num, int end_num) {
        List<Integer> result = new ArrayList<>();
        for (int i = start_num; i <= end_num; i++) {
            result.add(i);
        }
        return result;
    }

    public static List<Integer> solution2() {
        Scanner sc = new Scanner(System.in);
        System.out.print("start_num: ");
        int start_num = sc.nextInt();
        System.out.print("end_num: ");
        int end_num = sc.nextInt();
        List<Integer> result = new ArrayList<>();
        for (int i = start_num; i <= end_num; i++) {
            result.add(i);
        }
        return result;
    }
}

/* for (int i = start_num; i <= end_num; i++)
 * Repeats from start_num to end_num (inclusive).
 * start_num부터 end_num까지 반복합니다 (포함하여).
 */

/* result.add(i);
 * Adds the current number i to the list.
 * 현재 숫자 i를 리스트에 추가합니다.
 */