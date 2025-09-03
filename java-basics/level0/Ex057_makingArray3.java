// 정수 배열 arr와 2개의 구간이 담긴 배열 intervals가 주어집니다.
// intervals는 항상 [[a1, b1], [a2, b2]]의 꼴로 주어지며 각 구간은 닫힌 구간입니다. 
// 닫힌 구간은 양 끝값과 그 사이의 값을 모두 포함하는 구간을 의미합니다.
// 이때 배열 arr의 첫 번째 구간에 해당하는 배열과 두 번째 구간에 해당하는 배열을 앞뒤로 붙여 새로운 배열을 만들어 return 하는 solution 함수를 완성해 주세요.

// 제한사항
// 1 ≤ arr의 길이 ≤ 100,000
// 1 ≤ arr의 원소 < 100
// 1 ≤ a1 ≤ b1 < arr의 길이
// 1 ≤ a2 ≤ b2 < arr의 길이

import java.util.ArrayList;
import java.util.Arrays;

public class Ex057_makingArray3 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[] {1, 2, 3, 4, 5}, new int[][] {{1, 3}, {0, 4}})));
    }

    public static int[] solution(int[] arr, int[][] intervals) {
        ArrayList<Integer> list = new ArrayList<>(); // 결과를 담을 리스트 생성 # Create list to hold result
        
        for (int[] interval : intervals) { // 각 구간 순회 # Iterate over each interval
            int a = interval[0]; // 구간 시작 인덱스 # Start index of interval
            int b = interval[1]; // 구간 끝 인덱스 # End index of interval

            for (int j = a; j <= b; j++) { // 해당 구간의 값들을 하나씩 list에 추가 # Add each value in the interval to the list
                list.add(arr[j]);
            }
        }

        int[] answer = new int[list.size()]; // 최종 결과 배열 생성 # Create final result array
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i); // 리스트에서 값을 꺼내 배열에 복사 # Copy values from list to array
        }

        return answer; // 결과 반환 # Return result array
    }
}