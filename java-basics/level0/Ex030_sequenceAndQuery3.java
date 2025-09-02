/* 정수 배열 arr와 2차원 정수 배열 queries이 주어집니다. queries의 원소는 각각 하나의 query를 나타내며, [s, e, k] 꼴입니다.
   각 query마다 순서대로 s ≤ i ≤ e인 모든 i에 대해 i가 k의 배수이면 arr[i]에 1을 더합니다.
   위 규칙에 따라 queries를 처리한 이후의 arr를 return 하는 solution 함수를 완성해 주세요.
   제한사항 
   1 ≤ arr의 길이 ≤ 1,000
   0 ≤ arr의 원소 ≤ 1,000,000
   1 ≤ queries의 길이 ≤ 1,000
   0 ≤ s ≤ e < arr의 길이
   0 ≤ k ≤ 5 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ex030_sequenceAndQuery3 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[] {0, 1, 2, 4, 3}, new int[][] {{0, 4, 1}, {0, 3, 2}, {0, 3, 3}})));
        System.out.println(Arrays.toString(solution2()));
    }

    public static int[] solution(int[] arr, int[][] queries) {
        for (int[] query: queries) {
            int s = query[0];
            int e = query[1];
            int k = query[2];
            for(int i = s; i <= e; i++) {
                if (k != 0 && i % k == 0) {
                    arr[i] = arr[i] + 1;
                }
            }
        }
        return arr;
    }

    public static int[] solution2() {
        int[] arr;
        int[][] queries;
        try (Scanner sc = new Scanner(System.in)) {
            List<Integer> arrList = new ArrayList<>();
            System.out.print("Array(-1 to stop): ");
            while (true) { 
                int input = sc.nextInt();
                if (input == -1) {
                    break;
                }
                arrList.add(input);
            }
            arr = new int[arrList.size()];
            for (int i = 0; i < arrList.size(); i++) {
                arr[i] = arrList.get(i);
            }
            List<int[]> queryList = new ArrayList<>();
            System.out.println("Queries(-1 to stop)");
            while (true) { 
                System.out.print("s: ");
                int s = sc.nextInt();
                if (s == -1) {
                    break;
                }
                System.out.print("e: ");
                int e = sc.nextInt();
                System.out.print("k: ");
                int k = sc.nextInt();
                queryList.add(new int[] {s, e, k});
            }
            queries = new int[queryList.size()][];
            for (int i = 0; i < queryList.size(); i++){
                queries[i] = queryList.get(i);
            }
        }
        return solution(arr, queries);
    }
}
