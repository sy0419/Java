// 정수 배열 arr과 정수 n이 매개변수로 주어집니다. arr의 길이가 홀수라면 arr의 모든 짝수 인덱스 위치에 n을 더한 배열을, 
// arr의 길이가 짝수라면 arr의 모든 홀수 인덱스 위치에 n을 더한 배열을 return 하는 solution 함수를 작성해 주세요.

// 제한사항
// 1 ≤ arr의 길이 ≤ 1,000
// 1 ≤ arr의 원소 ≤ 1,000
// 1 ≤ n ≤ 1,000

import java.util.ArrayList;
import java.util.Arrays;

public class Ex097_dependOnLengthOfArray {
    public static void main(String[] args) {
        // 테스트 케이스 실행 # Run test cases
        System.out.println(Arrays.toString(solution(new int[] {49, 12, 100, 276, 33}, 27)));
        System.out.println(Arrays.toString(solution(new int[] {444, 555, 666, 777}, 100)));
    }

    public static int[] solution(int[] arr, int n) {
        // 결과를 저장할 리스트 생성 # Create list to store result
        ArrayList<Integer> arrList = new ArrayList<>();

        int arrLen = arr.length;

        // 배열 길이가 홀수일 경우 # If array length is odd
        if (arrLen % 2 == 1) {
            for (int i = 0; i < arrLen; i++) {
                // 짝수 인덱스에 n을 더함 # Add n to even indices
                if (i % 2 == 0) {
                    arrList.add(arr[i] + n);
                } else {
                    arrList.add(arr[i]);
                }
            }
        } 
        // 배열 길이가 짝수일 경우 # If array length is even
        else {
            for (int i = 0; i < arrLen; i++) {
                // 홀수 인덱스에 n을 더함 # Add n to odd indices
                if (i % 2 == 0) {
                    arrList.add(arr[i]);
                } else {
                    arrList.add(arr[i] + n);
                }
            }
        }

        // ArrayList를 int[]로 변환 # Convert ArrayList to int array
        int[] result = new int[arrList.size()];
        for (int i = 0; i < arrList.size(); i++) {
            result[i] = arrList.get(i);
        }

        return result;
    }
}