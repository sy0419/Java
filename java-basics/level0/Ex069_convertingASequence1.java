// 정수 배열 arr가 주어집니다. arr의 각 원소에 대해 값이 50보다 크거나 같은 짝수라면 2로 나누고, 
// 50보다 작은 홀수라면 2를 곱합니다. 그 결과인 정수 배열을 return 하는 solution 함수를 완성해 주세요.

// 제한사항
// 1 ≤ arr의 길이 ≤ 1,000,000
// 1 ≤ arr의 원소의 값 ≤ 100

import java.util.ArrayList;
import java.util.Arrays;

public class Ex069_convertingASequence1 {
    public static void main(String[] args) {
        // 테스트 케이스 출력 # Print the result of the test cases
        System.out.println(Arrays.toString(solution1(new int[] {1, 2, 3, 100, 99, 98})));
        System.out.println(Arrays.toString(solution2(new int[] {1, 2, 3, 100, 99, 98})));
    }

    public static int[] solution1(int[] arr) {
        ArrayList<Integer> numList = new ArrayList(); 
        // # Create a list to store transformed numbers

        for (int i = 0; i < arr.length; i++) {
            // 조건 1: 50보다 크거나 같고, 짝수이면 2로 나눈다
            // # Condition 1: If number is even and >= 50, divide by 2
            if (arr[i] >= 50 && arr[i] % 2 == 0) {
                numList.add(arr[i] / 2);
            } 
            // 조건 2: 50보다 작고, 홀수이면 2를 곱한다
            // # Condition 2: If number is odd and < 50, multiply by 2
            else if (arr[i] < 50 && arr[i] % 2 == 1) {
                numList.add(arr[i] * 2);
            } 
            // 그 외의 경우는 그대로 유지
            // # Otherwise, keep the number as is
            else {
                numList.add(arr[i]);
            }
        }

        // ArrayList를 배열로 변환
        // # Convert ArrayList to int[] array
        int[] result = new int[numList.size()];
        for (int i = 0; i < numList.size(); i++) {
            result[i] = (int) numList.get(i); 
            // # Cast to int because ArrayList stores Object
        }

        return result;
    }

    public static int[] solution2(int[] arr) {
        // # Directly modify the original array
        for (int i = 0; i < arr.length; i++) {
            // 50 이상 짝수는 2로 나누기
            // # Divide by 2 if even and >= 50
            if (arr[i] >= 50 && arr[i] % 2 == 0) {
                arr[i] /= 2;
            }
            // 50 미만 홀수는 2 곱하기
            // # Multiply by 2 if odd and < 50
            else if (arr[i] < 50 && arr[i] % 2 == 1) {
                arr[i] *= 2;
            }
            // 나머지는 그대로 (별도 처리 없음)
            // # Leave the value unchanged otherwise
        }

        return arr; // # Return the modified array
    }
}