// array의 각 element 중 divisor로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환하는 함수, solution을 작성해주세요.
// divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환하세요.

// 제한사항
// arr은 자연수를 담은 배열입니다.
// 정수 i, j에 대해 i ≠ j 이면 arr[i] ≠ arr[j] 입니다.
// divisor는 자연수입니다.
// array는 길이 1 이상인 배열입니다.

import java.util.ArrayList;
import java.util.Arrays;

public class Ex016_DivisibleNumbers {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[] {5, 9, 7, 10}, 5)));  // [5, 10] 반환 기대 # Expect [5, 10]
        System.out.println(Arrays.toString(solution(new int[] {2, 36, 1, 3}, 1)));  // [1, 2, 3, 36] 반환 기대 # Expect [1, 2, 3, 36]
        System.out.println(Arrays.toString(solution(new int[] {3, 2, 6}, 10)));     // [-1] 반환 기대 # Expect [-1]
    }

    public static int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> arrList = new ArrayList<>();  // 나누어 떨어지는 숫자를 담을 리스트 # List to store divisible numbers

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) {
                arrList.add(arr[i]); // 나누어 떨어지는 숫자만 추가 # Add number if divisible
            }
        }

        if (arrList.isEmpty()) {
            arrList.add(-1); // 조건에 맞는 숫자가 없을 경우 -1 추가 # Add -1 if no divisible numbers found
        }

        int[] result = new int[arrList.size()];
        for (int i = 0; i < arrList.size(); i++) {
            result[i] = arrList.get(i); // 리스트를 배열로 변환 # Convert list to array
        }

        Arrays.sort(result); // 결과 배열 오름차순 정렬 # Sort the result array in ascending order

        return result;
    }
}