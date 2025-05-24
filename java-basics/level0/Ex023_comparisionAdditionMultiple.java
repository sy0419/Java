/* 정수가 담긴 리스트 num_list가 주어질 때, 모든 원소들의 곱이 모든 원소들의 합의 제곱보다 작으면 1을 크면 0을 return하도록 solution 함수를 완성해주세요.
   제한사항) 2 ≤ num_list의 길이 ≤ 10 , 1 ≤ num_list의 원소 ≤ 9 */

import java.util.Scanner;

public class Ex023_comparisionAdditionMultiple {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {3, 4, 5, 2, 1}));
        System.out.println(solution(new int[] {5, 7, 8, 3}));
        System.out.println(solution2());
    }

    public static int solution(int[] num_list) {
        int sum = 0;
        int multi = 1;
        for (int i = 0; i < num_list.length; i++) {
            sum += num_list[i];
            multi *= num_list[i];
        }
        int squareSum = (int) Math.pow(sum, 2);
        if (squareSum > multi) {
            return 1;
        } else {
            return 0;
        }
    }

    public static int solution2() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Length number of array: ");
        int n = sc.nextInt();
        int[] num_list = new int[n];
        for (int i = 0; i < n; i++) {
            num_list[i] = sc.nextInt();
        }
        int sum = 0;
        int multi = 1;
        for (int i = 0; i < num_list.length; i++) {
            sum += num_list[i];
            multi *= num_list[i];
        }
        int squareSum = (int) Math.pow(sum, 2);
        if (squareSum > multi) {
            return 1;
        } else {
            return 0;
        }
    }
}
