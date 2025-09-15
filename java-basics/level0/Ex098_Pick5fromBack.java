// 정수로 이루어진 리스트 num_list가 주어집니다. num_list에서 가장 작은 5개의 수를 오름차순으로 담은 리스트를 return하도록 solution 함수를 완성해주세요.

// 제한사항
// 6 ≤ num_list의 길이 ≤ 30
// 1 ≤ num_list의 원소 ≤ 100

import java.util.ArrayList;
import java.util.Arrays;

public class Ex098_Pick5fromBack {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[] {12, 4, 15, 46, 38, 1, 14})));
    }

    public static int[] solution(int[] numList) {
        // 배열을 오름차순으로 정렬합니다.
        // # Sort the array in ascending order.
        Arrays.sort(numList);

        // 정렬된 배열의 앞 5개 원소를 ArrayList에 추가합니다.
        // # Add the first 5 elements of the sorted array to an ArrayList.
        ArrayList<Integer> arrList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            arrList.add(numList[i]);
        }

        // ArrayList를 다시 배열로 변환합니다.
        // # Convert the ArrayList back to an int array.
        int[] result = new int[arrList.size()];
        for (int i = 0; i < arrList.size(); i++) {
            result[i] = arrList.get(i);
        }

        // 결과 배열을 반환합니다.
        // # Return the resulting array.
        return result;
    }
}