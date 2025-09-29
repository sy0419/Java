// 정수를 저장한 배열, arr 에서 가장 작은 수를 제거한 배열을 리턴하는 함수, solution을 완성해주세요. 
// 단, 리턴하려는 배열이 빈 배열인 경우엔 배열에 -1을 채워 리턴하세요. 
// 예를들어 arr이 [4,3,2,1]인 경우는 [4,3,2]를 리턴 하고, [10]면 [-1]을 리턴 합니다.

// 제한 조건
// arr은 길이 1 이상인 배열입니다.
// 인덱스 i, j에 대해 i ≠ j이면 arr[i] ≠ arr[j] 입니다.

import java.util.ArrayList;
import java.util.Arrays;

public class Ex021_RemoveMin {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution1(new int[] {4, 3, 2, 1})));  // [4, 3, 2] 출력 # prints [4, 3, 2]
        System.out.println(Arrays.toString(solution1(new int[] {10})));         // [-1] 출력 # prints [-1]
        System.out.println(Arrays.toString(solution2(new int[] {4, 3, 2, 1})));  // [4, 3, 2] 출력 # prints [4, 3, 2]
        System.out.println(Arrays.toString(solution2(new int[] {10})));         // [-1] 출력 # prints [-1]
    }

    // 방법 1: ArrayList 사용 # Method 1: Using ArrayList
    public static int[] solution1(int[] arr) {
        if (arr.length == 1) {                      // 배열이 1개인 경우 예외 처리 # Handle case where array has only one element
            return new int[] {-1};
        } else {
            int min = arr[0];                       // 최소값 초기화 # Initialize min value
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] < min) {
                     min = arr[i];                  // 더 작은 값으로 갱신 # Update min value
                }
            }

            ArrayList<Integer> arrList = new ArrayList<>();  // 값을 담을 리스트 생성 # Create list to store filtered values

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != min) {
                    arrList.add(arr[i]);            // 최소값이 아닌 값만 추가 # Add non-min values
                }
            }

            int[] result = new int[arrList.size()]; // 리스트 크기만큼 배열 생성 # Create result array from list
            for (int i = 0; i < arrList.size(); i++) {
                result[i] = arrList.get(i);         // 리스트 값을 배열로 복사 # Copy list values into array
            }

            return result;
        }
    }

    // 방법 2: 고정 크기 배열 사용 # Method 2: Using fixed-size array
    public static int[] solution2(int[] arr) {
        if (arr.length == 1) {
            return new int[] {-1};                  // 배열에 하나만 있을 경우 예외 처리 # Handle single element array
        }

        int min = arr[0];                           // 최소값 초기화 # Initialize min
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];                       // 최소값 갱신 # Update min
            }
        }

        int[] result = new int[arr.length - 1];     // 최소값을 뺀 크기로 결과 배열 생성 # Result array without min
        int index = 0;                              // 결과 배열 인덱스 추적 변수 # Index tracker for result array

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != min) {
                result[index++] = arr[i];           // 최소값이 아닌 경우만 복사 # Copy non-min values
            }
        }

        return result;
    }
}