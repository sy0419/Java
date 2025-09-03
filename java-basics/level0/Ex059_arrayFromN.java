// 정수 리스트 num_list와 정수 n이 주어질 때, 
// n 번째 원소부터 마지막 원소까지의 모든 원소를 담은 리스트를 return하도록 solution 함수를 완성해주세요.

// 제한사항
// 2 ≤ num_list의 길이 ≤ 30
// 1 ≤ num_list의 원소 ≤ 9
// 1 ≤ n ≤ num_list의 길이

import java.util.ArrayList;
import java.util.Arrays;

public class Ex059_arrayFromN {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution1(new int[] {2, 1, 6}, 3)));         // [6]
        System.out.println(Arrays.toString(solution1(new int[] {5, 2, 1, 7, 5}, 2)));   // [2, 1, 7, 5]
        System.out.println(Arrays.toString(solution2(new int[] {2, 1, 6}, 3)));         // [6]
        System.out.println(Arrays.toString(solution2(new int[] {5, 2, 1, 7, 5}, 2)));   // [2, 1, 7, 5]
    }

    // 반복문 2번 사용한 방식
    // # Method using two nested loops
    public static int[] solution1(int[] numList, int n) {
        ArrayList<Integer> list = new ArrayList<>();

        // n번째 원소부터 마지막 원소까지 순회
        // # Iterate from the (n-1)th element to the end
        for (int i = 0; i < numList.length; i++) {
            if (i == (n - 1)) {
                for (int j = i; j < numList.length; j++) {
                    list.add(numList[j]);
                }
            }
        }

        // ArrayList를 배열로 변환
        // # Convert ArrayList to an int array
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    // 반복문 1번 사용한 방식 (최적화된 풀이)
    // # Method using a single loop (optimized)
    public static int[] solution2(int[] numList, int n) {
        // 결과 배열 길이 계산
        // # Calculate size of the result array
        int[] result = new int[numList.length - (n - 1)];

        // n번째 원소부터 끝까지 복사
        // # Copy from the (n-1)th index to the end
        for (int i = n - 1; i < numList.length; i++) {
            result[i - (n - 1)] = numList[i];
        }

        return result;
    }
}