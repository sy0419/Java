// 정수 리스트 num_list와 정수 n이 주어질 때, num_list의 첫 번째 원소부터 n 번째 원소까지의 모든 원소를 담은 리스트를 return하도록 solution 함수를 완성해주세요.

// 제한사항
// 2 ≤ num_list의 길이 ≤ 30
// 1 ≤ num_list의 원소 ≤ 9
// 1 ≤ n ≤ num_list의 길이

import java.util.ArrayList;
import java.util.Arrays;

public class Ex062_printJustBeforeN {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[] {2, 1, 6}, 1)));        // [2]
        System.out.println(Arrays.toString(solution(new int[] {5, 2, 1, 7, 5}, 3)));  // [5, 2, 1]
    }

    public static int[] solution(int[] numList, int n) {
        ArrayList<Integer> list = new ArrayList<>();

        // n번째 원소까지 리스트에 추가
        // # Add elements from the beginning up to the nth element
        for (int i = 0; i < n; i++) {
            list.add(numList[i]);
        }

        // ArrayList → 배열 변환
        // # Convert ArrayList to int array
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}