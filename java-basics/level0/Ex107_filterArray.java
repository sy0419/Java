// 정수 배열 arr과 delete_list가 있습니다. arr의 원소 중 delete_list의 원소를 모두 삭제하고 남은 원소들은 기존의 arr에 있던 순서를 유지한 배열을 return 하는 solution 함수를 작성해 주세요.

// 제한사항
// 1 ≤ arr의 길이 ≤ 100
// 1 ≤ arr의 원소 ≤ 1,000
// arr의 원소는 모두 서로 다릅니다.
// 1 ≤ delete_list의 길이 ≤ 100
// 1 ≤ delete_list의 원소 ≤ 1,000
// delete_list의 원소는 모두 서로 다릅니다.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Ex107_filterArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution1(new int[] {293, 1000, 395, 678, 94}, new int[] {94, 777, 104, 1000, 1, 12}))); // 출력: [293, 395, 678] # Output: [293, 395, 678]
        System.out.println(Arrays.toString(solution1(new int[] {110, 66, 439, 785, 1}, new int[] {377, 823, 119, 43})));            // 출력: [110, 66, 439, 785, 1] # Output: [110, 66, 439, 785, 1]
        System.out.println(Arrays.toString(solution2(new int[] {293, 1000, 395, 678, 94}, new int[] {94, 777, 104, 1000, 1, 12}))); // 출력: [293, 395, 678] # Output: [293, 395, 678]
        System.out.println(Arrays.toString(solution2(new int[] {110, 66, 439, 785, 1}, new int[] {377, 823, 119, 43})));            // 출력: [110, 66, 439, 785, 1] # Output: [110, 66, 439, 785, 1]
    }

    public static int[] solution1(int[] arr, int[] deleteList) {
        ArrayList<Integer> numList = new ArrayList<>();        // 결과를 저장할 리스트 초기화 # Initialize list to store result
        HashSet<Integer> deleteSet = new HashSet<>();          // 삭제할 값을 빠르게 찾기 위한 Set # Set for fast lookup of elements to delete

        for (int num : deleteList) {
            deleteSet.add(num);                                // deleteList의 값들을 Set에 추가 # Add all deleteList values to Set
        }

        for (int num : arr) {
            if (!deleteSet.contains(num)) {                    // 삭제 대상이 아니라면 추가 # Add if not in deleteSet
                numList.add(num);
            }
        }

        int[] result = new int[numList.size()];                // 최종 결과 배열 생성 # Create result array
        for (int i = 0; i < numList.size(); i++) {
            result[i] = numList.get(i);                        // 리스트에서 배열로 복사 # Copy from list to array
        }
        return result;                                         // 결과 반환 # Return result
    }

    public int[] solution2(int[] arr, int[] delete_list) {
        List<Integer> list = new ArrayList<>();                // arr를 복사할 리스트 # List to copy values from arr

        for(int n : arr) {
            list.add(n);                                       // arr의 모든 값을 리스트에 추가 # Add all elements of arr to list
        }

        for(int n: delete_list) {
            list.remove((Integer)n);                           // delete_list에 있는 값을 제거 # Remove matching elements from list
        }

        int[] answer = new int[list.size()];                   // 결과 배열 생성 # Create result array
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);                           // 리스트에서 배열로 복사 # Copy from list to array
        }
        
        return answer;                                         // 결과 반환 # Return result
    }
}