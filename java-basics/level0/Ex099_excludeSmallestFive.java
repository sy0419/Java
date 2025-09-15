// 정수로 이루어진 리스트 num_list가 주어집니다. num_list에서 가장 작은 5개의 수를 제외한 수들을 오름차순으로 담은 리스트를 return하도록 solution 함수를 완성해주세요.

// 제한사항
// 6 ≤ num_list의 길이 ≤ 30
// 1 ≤ num_list의 원소 ≤ 100

import java.util.Arrays;

public class Ex099_excludeSmallestFive {
    public static void main(String[] args) {
        // 테스트용 예시 배열을 출력합니다.
        // # Print the example array for testing.
        System.out.println(Arrays.toString(solution(new int[] {12, 4, 15, 46, 38, 1, 14, 56, 32, 10})));
    }

    public static int[] solution(int[] numList) {
        // 입력 배열 길이에서 가장 작은 5개를 제외한 만큼의 크기로 결과 배열을 만듭니다.
        // # Create an answer array sized to exclude the smallest five elements.
        int[] answer = new int[numList.length - 5];

        // 배열을 오름차순으로 정렬합니다.
        // # Sort the array in ascending order.
        Arrays.sort(numList);

        // 정렬된 배열에서 가장 작은 5개를 제외한 나머지 수들을 결과 배열에 복사합니다.
        // # Copy elements from index 5 to the end into the answer array.
        for(int i = 5 ; i < numList.length ; i++) {
            answer[i - 5] = numList[i];
        }

        // 결과 배열을 반환합니다.
        // # Return the resulting array.
        return answer;
    }
}