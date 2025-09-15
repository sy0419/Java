// 아무 원소도 들어있지 않은 빈 배열 X가 있습니다. 길이가 같은 정수 배열 arr과 boolean 배열 flag가 매개변수로 주어질 때,
// flag를 차례대로 순회하며 flag[i]가 true라면 X의 뒤에 arr[i]를 arr[i] × 2 번 추가하고, 
// flag[i]가 false라면 X에서 마지막 arr[i]개의 원소를 제거한 뒤 X를 return 하는 solution 함수를 작성해 주세요.

// 제한사항
// 1 ≤ arr의 길이 = flag의 길이 ≤ 100
// arr의 모든 원소는 1 이상 9 이하의 정수입니다.
// 현재 X의 길이보다 더 많은 원소를 빼는 입력은 주어지지 않습니다.

import java.util.ArrayList;
import java.util.Arrays;

public class Ex091_emptyArrayAddDelete {
    public static void main(String[] args) {
        // 테스트용 입력값으로 solution 함수 결과 출력
        // # Print the result of calling solution() with sample inputs
        System.out.println(Arrays.toString(solution(new int[] {3, 2, 4, 1, 3}, new boolean[] {true, false, true, false, false})));
    }

    public static int[] solution(int[] arr, boolean[] flag) {
        // 동적으로 원소를 추가/삭제할 수 있는 리스트 생성
        // # Dynamic list to simulate array X
        ArrayList<Integer> arrlist = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (flag[i] == true) {
                // flag[i]가 true이면, arr[i]를 arr[i] * 2번 리스트에 추가
                // # If flag[i] is true, add arr[i] to the list arr[i] * 2 times
                for (int j = 0; j < arr[i] * 2; j++) {
                    arrlist.add(arr[i]);
                }
            } else {
                // flag[i]가 false이면, 리스트의 마지막에서 arr[i]개 제거
                // # If flag[i] is false, remove the last arr[i] elements from the list
                for (int j = 0; j < arr[i]; j++) {
                    arrlist.remove(arrlist.size() - 1);
                }
            }
        }

        // 최종 결과 배열 선언 및 ArrayList를 int[]로 변환
        // # Convert ArrayList<Integer> to int[]
        int[] answer = new int[arrlist.size()];
        for (int i = 0; i < arrlist.size(); i++) {
            // 리스트의 각 원소를 배열에 복사
            // # Copy each element into the result array
            answer[i] = arrlist.get(i);
        }

        // 결과 배열 반환
        // # Return the final array
        return answer;
    }
}