// 아무 원소도 들어있지 않은 빈 배열 X가 있습니다. 
// 양의 정수 배열 arr가 매개변수로 주어질 때, arr의 앞에서부터 차례대로 원소를 보면서 원소가 
// a라면 X의 맨 뒤에 a를 a번 추가하는 일을 반복한 뒤의 배열 X를 return 하는 solution 함수를 작성해 주세요.

// 제한사항
// 1 ≤ arr의 길이 ≤ 100
// 1 ≤ arr의 원소 ≤ 100

import java.util.ArrayList;
import java.util.Arrays;

public class Ex090_addAsManyElementsAsNumberInArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[] {5, 1, 4}))); // → [5, 5, 5, 5, 5, 1, 4, 4, 4, 4]
        System.out.println(Arrays.toString(solution(new int[] {6, 6})));    // → [6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6]
        System.out.println(Arrays.toString(solution(new int[] {1})));       // → [1]
    }

    public static int[] solution(int[] arr) {
        // 결과를 담을 동적 리스트 생성  # Create dynamic list to store results
        ArrayList<Integer> numList = new ArrayList<>();

        // 각 숫자를 숫자만큼 리스트에 추가  # For each number, add it to the list as many times as its value
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i]; j++) {
                numList.add(arr[i]);
            }
        }

        // 리스트를 배열로 변환  # Convert list to array
        int[] result = new int[numList.size()];
        for (int i = 0; i < numList.size(); i++) {
            result[i] = (int) numList.get(i); // 형변환 필요  # Cast Object to int
        }

        return result; // 결과 배열 반환  # Return the result array
    }
}
