// 정수 배열 arr와 자연수 k가 주어집니다.
// 만약 k가 홀수라면 arr의 모든 원소에 k를 곱하고, k가 짝수라면 arr의 모든 원소에 k를 더합니다.
// 이러한 변환을 마친 후의 arr를 return 하는 solution 함수를 완성해 주세요.

// 제한사항
// 1 ≤ arr의 길이 ≤ 1,000,000
// 1 ≤ arr의 원소의 값 ≤ 100
// 1 ≤ k ≤ 100

import java.util.ArrayList;
import java.util.Arrays;

public class Ex115_transformArr {
    public static void main(String[] args) {
        // 테스트 케이스 실행
        System.out.println(Arrays.toString(solution1(new int[] {1, 2, 3, 100, 99, 98}, 3)));
        System.out.println(Arrays.toString(solution1(new int[] {1, 2, 3, 100, 99, 98}, 2)));
        System.out.println(Arrays.toString(solution2(new int[] {1, 2, 3, 100, 99, 98}, 3)));
        System.out.println(Arrays.toString(solution2(new int[] {1, 2, 3, 100, 99, 98}, 2)));
        System.out.println(Arrays.toString(solution3(new int[] {1, 2, 3, 100, 99, 98}, 3)));
        System.out.println(Arrays.toString(solution3(new int[] {1, 2, 3, 100, 99, 98}, 2)));
    }

    // 배열을 새로 만들어 처리하는 방법
    // # Efficient approach using new array
    public static int[] solution1(int[] arr, int k) {
        int[] result = new int[arr.length]; // 변환된 값을 저장할 배열
        // # Array to store transformed values

        for (int i = 0; i < arr.length; i++) {
            if (k % 2 == 1) {
                result[i] = arr[i] * k; // k가 홀수일 때 곱셈
                // # Multiply each element by k if k is odd
            } else {
                result[i] = arr[i] + k; // k가 짝수일 때 덧셈
                // # Add k to each element if k is even
            }
        }

        return result; // 결과 반환
        // # Return the result
    }

    // ArrayList를 사용하는 방법 (비효율적)
    // # Less efficient method using ArrayList
    public static int[] solution2(int[] arr, int k) {
        ArrayList<Integer> numList = new ArrayList<>(); // 리스트 생성
        // # Create temporary list

        for (int i = 0; i < arr.length; i++) {
            if (k % 2 == 1) {
                numList.add(arr[i] * k); // k가 홀수면 곱하기
                // # Multiply if k is odd
            } else {
                numList.add(arr[i] + k); // k가 짝수면 더하기
                // # Add if k is even
            }
        }

        // 리스트를 배열로 변환
        // # Convert list to array
        int[] result = new int[numList.size()];
        for (int i = 0; i < numList.size(); i++) {
            result[i] = numList.get(i);
        }

        return result; // 결과 반환
        // # Return the result
    }

    // 기존 배열을 직접 수정하는 가장 간단한 방식 (in-place)
    // # In-place transformation (modifies input array directly)
    public static int[] solution3(int[] arr, int k) {
        if (k % 2 == 0) {
            // k가 짝수일 경우
            // # If k is even, add to each element
            for (int i = 0; i < arr.length; i++) {
                arr[i] = arr[i] + k;
            }
        } else {
            // k가 홀수일 경우
            // # If k is odd, multiply each element
            for (int i = 0; i < arr.length; i++) {
                arr[i] = arr[i] * k;
            }
        }
        return arr; // 변경된 원본 배열 반환
        // # Return the modified input array
    }
}