// 정수 리스트 num_list와 정수 n이 주어질 때, num_list의 첫 번째 원소부터 마지막 원소까지 n개 간격으로 저장되어있는 원소들을 차례로 담은 리스트를 return하도록 solution 함수를 완성해주세요.

// 제한사항
// 5 ≤ num_list의 길이 ≤ 20
// 1 ≤ num_list의 원소 ≤ 9
// 1 ≤ n ≤ 4

import java.util.ArrayList;
import java.util.Arrays;

public class Ex063_intervalsN {
    public static void main(String[] args) {
        // 테스트 케이스 출력
        System.out.println(Arrays.toString(solution(new int[] {4, 2, 6, 1, 7, 6}, 2)));
        System.out.println(Arrays.toString(solution(new int[] {4, 2, 6, 1, 7, 6}, 4)));
    }

    public static int[] solution(int[] numList, int n){
        ArrayList<Integer> list = new ArrayList<>();
        // n 간격으로 원소를 list에 추가
        // Add elements to the list at every 'n' interval
        for(int i = 0; i < numList.length; i += n) {
            list.add(numList[i]);
        }

        // ArrayList를 일반 int 배열로 변환
        // Convert ArrayList to int array
        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;  // 결과 배열 반환 (Return result array)
    }
}