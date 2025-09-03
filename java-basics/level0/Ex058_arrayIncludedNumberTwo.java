// 정수 배열 arr가 주어집니다. 배열 안의 2가 모두 포함된 가장 작은 연속된 부분 배열을 return 하는 solution 함수를 완성해 주세요.

// 단, arr에 2가 없는 경우 [-1]을 return 합니다.

// 제한사항
// 1 ≤ arr의 길이 ≤ 100,000
// 1 ≤ arr의 원소 ≤ 10
import java.util.ArrayList;
import java.util.Arrays;

public class Ex058_arrayIncludedNumberTwo {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[] {1, 2, 1, 4, 5, 2, 9})));        // # Example with multiple 2s
        System.out.println(Arrays.toString(solution(new int[] {1, 2, 1})));                    // # Example with single 2
        System.out.println(Arrays.toString(solution(new int[] {1, 1, 1})));                    // # Example with no 2
        System.out.println(Arrays.toString(solution(new int[] {1, 2, 1, 2, 1, 10, 2, 1})));   // # Multiple 2s scattered
    }

    public static int[] solution(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        int startIndex = -1; // 첫 번째 2가 나오는 위치 # Start index of the subarray where the first 2 appears
        int endIndex = -1;   // 마지막 2가 나오는 위치 # End index of the subarray where the last 2 appears

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 2) {
                if(startIndex == -1) { // 아직 시작 인덱스를 찾지 못했으면 # If startIndex has not been set yet
                    startIndex = i;    // 현재 인덱스를 시작 인덱스로 저장 # Save current index as startIndex
                }
                endIndex = i;          // 마지막으로 발견된 2의 인덱스를 저장 # Update endIndex to the current index
            }
        }

        if (startIndex == -1) {      // 2가 배열에 없는 경우 # If there is no 2 in the array
            return new int[] {-1};    // [-1] 반환 # Return [-1]
        }

        for(int i = startIndex; i <= endIndex; i++) {
            list.add(arr[i]);         // startIndex부터 endIndex까지의 값들을 리스트에 추가 # Add elements from startIndex to endIndex to list
        }

        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);  // 리스트를 배열로 변환 # Convert list to array
        }
        return result;
    }
}