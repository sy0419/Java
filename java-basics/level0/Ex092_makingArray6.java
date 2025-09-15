// 0과 1로만 이루어진 정수 배열 arr가 주어집니다. arr를 이용해 새로운 배열 stk을 만드려고 합니다.
// i의 초기값을 0으로 설정하고 i가 arr의 길이보다 작으면 다음을 반복합니다.
// 만약 stk이 빈 배열이라면 arr[i]를 stk에 추가하고 i에 1을 더합니다.
// stk에 원소가 있고, stk의 마지막 원소가 arr[i]와 같으면 stk의 마지막 원소를 stk에서 제거하고 i에 1을 더합니다.
// stk에 원소가 있는데 stk의 마지막 원소가 arr[i]와 다르면 stk의 맨 마지막에 arr[i]를 추가하고 i에 1을 더합니다.
// 위 작업을 마친 후 만들어진 stk을 return 하는 solution 함수를 완성해 주세요.
// 단, 만약 빈 배열을 return 해야한다면 [-1]을 return 합니다.

// 제한사항
// 1 ≤ arr의 길이 ≤ 1,000,000
// arr의 원소는 0 또는 1 입니다.

import java.util.ArrayList;
import java.util.Arrays;

public class Ex092_makingArray6 {
    public static void main(String[] args) {
        // 테스트 케이스 출력
        // # Print test cases
        System.out.println(Arrays.toString(solution(new int[] {0, 1, 1, 1, 0})));
        System.out.println(Arrays.toString(solution(new int[] {0, 1, 0, 1, 0})));
        System.out.println(Arrays.toString(solution(new int[] {0, 1, 1, 0})));
    }

    public static int[] solution(int[] arr) {
        // stk 역할을 하는 리스트 생성
        // # Create a list to act as stack
        ArrayList<Integer> arrList = new ArrayList<>();

        // arr의 각 요소를 순회
        // # Traverse through arr
        for(int i = 0; i < arr.length; i++) {
            // stk이 비어있으면 현재 값을 추가
            // # If stk is empty, add current value
            if(arrList.isEmpty()) {
                arrList.add(arr[i]);
            } else {
                // 마지막 원소가 현재 값과 같으면 제거
                // # If last element equals current, remove it
                if(arrList.get(arrList.size() - 1).equals(arr[i])) {
                    arrList.remove(arrList.size() - 1);
                } else {
                    // 다르면 추가
                    // # Else, add current value
                    arrList.add(arr[i]);
                }
            }
        }

        // stk이 비었으면 [-1] 반환
        // # If stk is empty, return [-1]
        if (arrList.isEmpty()) {
            return new int[]{-1}; 
        }

        // 리스트를 배열로 변환
        // # Convert list to array
        int[] stk = new int[arrList.size()];
        for(int i = 0; i < arrList.size(); i++) {
            stk[i] = arrList.get(i);
        }

        return stk;
    }
}