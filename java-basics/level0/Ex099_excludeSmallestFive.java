// 정수로 이루어진 리스트 num_list가 주어집니다. num_list에서 가장 작은 5개의 수를 제외한 수들을 오름차순으로 담은 리스트를 return하도록 solution 함수를 완성해주세요.

// 제한사항
// 6 ≤ num_list의 길이 ≤ 30
// 1 ≤ num_list의 원소 ≤ 100

import java.util.ArrayList;
import java.util.Arrays;

public class Ex099_excludeSmallestFive {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[] {12, 4, 15, 46, 38, 1, 14, 56, 32, 10})));
    }

    public static int[] solution(int[] numList) {
        ArrayList<Integer> arrList = new ArrayList<>();
        // 배열을 오름차순으로 정렬합니다.
        // # Sort the array in ascending order.
        Arrays.sort(numList);

        // 정렬된 배열에서 가장 작은 5개는 제외하고, 6번째 요소부터 끝까지 리스트에 추가합니다.
        // # Exclude the smallest 5 elements and add elements from index 5 to the end into arrList.
        for (int i = 5; i < numList.length; i++) {
            arrList.add(numList[i]);
        }

        // ArrayList를 다시 int 배열로 변환합니다.
        // # Convert the ArrayList back to an int array.
        int[] result = new int[arrList.size()];
        for (int i = 0; i < arrList.size(); i++) {
            result[i] = arrList.get(i);
        }

        return result; // 결과 배열을 반환합니다.
        // # Return the resulting array.
    }
}