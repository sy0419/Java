// 정수 배열 arr가 주어집니다. arr의 각 원소에 대해 값이 50보다 크거나 같은 짝수라면 2로 나누고, 
// 50보다 작은 홀수라면 2를 곱하고 다시 1을 더합니다.
// 이러한 작업을 x번 반복한 결과인 배열을 arr(x)라고 표현했을 때, arr(x) = arr(x + 1)인 x가 항상 존재합니다. 이러한 x 중 가장 작은 값을 return 하는 solution 함수를 완성해 주세요.
// 단, 두 배열에 대한 "="는 두 배열의 크기가 서로 같으며, 같은 인덱스의 원소가 각각 서로 같음을 의미합니다.

// 제한사항
// 1 ≤ arr의 길이 ≤ 1,000,000
// 1 ≤ arr의 원소의 값 ≤ 100

import java.util.Arrays;

public class Ex070_convertingASequence2 {
    public static void main(String[] args) {
        // 테스트 케이스 실행 # Run test case
        System.out.println(solution1(new int[] {1, 2, 3, 100, 99, 98}));
    }

    public static int solution1(int[] arr) {
        int count = 0;  
        // # 횟수를 저장할 변수 (몇 번 반복했는지) # Variable to count how many iterations were needed
        
        while (true) {
            int[] newArr = new int[arr.length];  
            // # 현재 배열을 규칙에 따라 바꾼 새 배열 # Array to store transformed values

            for (int i = 0; i < arr.length; i++) {
                int num = arr[i];  
                // # 현재 숫자 가져오기 # Get current number

                if (num >= 50 && num % 2 == 0) {
                    newArr[i] = num / 2;  
                    // # 50 이상 짝수는 2로 나누기 # Rule 1: Divide even numbers ≥ 50 by 2
                } else if (num < 50 && num % 2 == 1) {
                    newArr[i] = num * 2 + 1;  
                    // # 50 미만 홀수는 2를 곱하고 1 더하기 # Rule 2: Multiply odd numbers < 50 by 2, then add 1
                } else {
                    newArr[i] = num;  
                    // # 그 외는 그대로 복사 # Otherwise, keep the number as is
                }
            }

            if (Arrays.equals(arr, newArr)) {
                // # 이전 배열과 새 배열이 같으면 반복 종료 # Stop if the array no longer changes
                break;
            }

            arr = newArr;  
            // # 새로운 배열을 기준으로 다음 반복을 준비 # Update the array for the next round
            count++;  
            // # 반복 횟수 증가 # Increase iteration count
        }

        return count;  
        // # 조건을 만족한 최소 반복 횟수 반환 # Return the smallest x where arr(x) = arr(x + 1)
    }
}