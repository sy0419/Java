// 랜덤으로 서로 다른 k개의 수를 저장한 배열을 만드려고 합니다. 
// 적절한 방법이 떠오르지 않기 때문에 일정한 범위 내에서 무작위로 수를 뽑은 후, 
// 지금까지 나온적이 없는 수이면 배열 맨 뒤에 추가하는 방식으로 만들기로 합니다.
// 이미 어떤 수가 무작위로 주어질지 알고 있다고 가정하고, 실제 만들어질 길이 k의 배열을 예상해봅시다.
// 정수 배열 arr가 주어집니다. 문제에서의 무작위의 수는 arr에 저장된 순서대로 주어질 예정이라고 했을 때, 
// 완성될 배열을 return 하는 solution 함수를 완성해 주세요.
// 단, 완성될 배열의 길이가 k보다 작으면 나머지 값을 전부 -1로 채워서 return 합니다.

// 제한사항
// 1 ≤ arr의 길이 ≤ 100,000
// 0 ≤ arr의 원소 ≤ 100,000
// 1 ≤ k ≤ 1,000

import java.util.ArrayList;
import java.util.Arrays;

public class Ex093_randomNumberPick {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[] {0, 1, 1, 2, 2, 3}, 3)));
        System.out.println(Arrays.toString(solution(new int[] {0, 1, 1, 1, 1}, 4)));
    }

    public static int[] solution(int[] arr, int k) {
        ArrayList<Integer> arrList = new ArrayList<>();

        for(int i = 0; i < arr.length; i++) {
            // 만약 arr[i]가 아직 arrList에 없다면 추가한다.
            // # If arr[i] is not in arrList yet, add it
            if (!arrList.contains(arr[i])) {
                arrList.add(arr[i]);
            }
            // 만약 arrList의 크기가 k에 도달하면 반복을 종료한다.
            // # If arrList size reaches k, stop the loop
            if (arrList.size() == k) {
                break;
            }
        }

        int[] result = new int[k];
        for(int i = 0; i < k; i++) {
            if (i < arrList.size()) {
                result[i] = arrList.get(i);
            } else {
                result[i] = -1; // 남은 자리는 -1로 채운다.
                // # Fill remaining positions with -1
            }
        }

        return result;
    }
}