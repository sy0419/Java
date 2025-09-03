import java.util.Arrays;

// 정수 n과 정수 3개가 담긴 리스트 slicer 그리고 정수 여러 개가 담긴 리스트 num_list가 주어집니다. 
// slicer에 담긴 정수를 차례대로 a, b, c라고 할 때, n에 따라 다음과 같이 num_list를 슬라이싱 하려고 합니다.

// n = 1 : num_list의 0번 인덱스부터 b번 인덱스까지
// n = 2 : num_list의 a번 인덱스부터 마지막 인덱스까지
// n = 3 : num_list의 a번 인덱스부터 b번 인덱스까지
// n = 4 : num_list의 a번 인덱스부터 b번 인덱스까지 c 간격으로
// 올바르게 슬라이싱한 리스트를 return하도록 solution 함수를 완성해주세요.

// 제한사항
// n 은 1, 2, 3, 4 중 하나입니다.
// slicer의 길이 = 3
// slicer에 담긴 정수를 차례대로 a, b, c라고 할 때
// 0 ≤ a ≤ b ≤ num_list의 길이 - 1
// 1 ≤ c ≤ 3
// 5 ≤ num_list의 길이 ≤ 30
// 0 ≤ num_list의 원소 ≤ 100

public class Ex055_cuttingList {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, new int[] {1, 5, 2}, new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9})));  // [2, 3, 4, 5, 6]
        System.out.println(Arrays.toString(solution(4, new int[] {1, 5, 2}, new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9})));  // [2, 4, 6]
    }

    public static int[] solution(int n, int[] slicer, int[] numList) {
        int a = slicer[0];  // 시작 인덱스 start index
        int b = slicer[1];  // 끝 인덱스 end index
        int c = slicer[2];  // 간격 step

        int start;
        int end;
        int step = 1;       // 기본 간격 default step

        if (n == 1) {
            start = 0;
            end = b;
        } else if (n == 2) {
            start = a;
            end = numList.length - 1;
        } else if (n == 3) {
            start = a;
            end = b;
        } else {
            start = a;
            end = b;
            step = c;
        }
        
        int size = (end - start) / step + 1;  // 결과 배열 크기 size of result array
        int[] answer = new int[size];
        int idx = 0;

        for (int i = start; i <= end; i += step) {  // start부터 end까지 step만큼 반복 Loop from start to end with step
            answer[idx++] = numList[i];
        }
        return answer;
    }
}