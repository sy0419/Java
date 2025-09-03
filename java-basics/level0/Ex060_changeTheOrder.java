// 정수 리스트 num_list와 정수 n이 주어질 때, num_list를 n 번째 원소 이후의 원소들과 n 번째까지의 원소들로 나눠 n 번째 원소 이후의 원소들을 n 번째까지의 원소들 앞에 붙인 리스트를 return하도록 solution 함수를 완성해주세요.

// 제한사항
// 2 ≤ num_list의 길이 ≤ 30
// 1 ≤ num_list의 원소 ≤ 9
// 1 ≤ n ≤ num_list의 길이

import java.util.ArrayList;
import java.util.Arrays;

public class Ex060_changeTheOrder {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[] {2, 1, 6}, 1)));          // [1, 6, 2]
        System.out.println(Arrays.toString(solution(new int[] {5, 2, 1, 7, 5}, 3)));    // [7, 5, 5, 2, 1]
    }

    public static int[] solution(int[] numList, int n) {
        ArrayList<Integer> list = new ArrayList<>();

        // n번째 원소 이후의 원소들을 먼저 추가
        // # Add elements after the nth element first
        for (int i = n; i < numList.length; i++) {
            list.add(numList[i]);
        }

        // 그 다음 n번째까지의 원소들을 추가
        // # Then add the elements up to the nth element
        for (int i = 0; i < n; i++) {
            list.add(numList[i]);
        }

        // ArrayList를 배열로 변환
        // # Convert the ArrayList to a regular array
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}
