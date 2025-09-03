import java.util.Arrays;

// 정수 start_num와 end_num가 주어질 때, start_num에서 end_num까지 1씩 감소하는 수들을 차례로 담은 리스트를 return하도록 solution 함수를 완성해주세요.

// 제한사항
// 0 ≤ end_num ≤ start_num ≤ 50

public class Ex053_countDown {
    public static void main(String[] args) {
        // 결과 배열을 문자열로 변환하여 출력
        // Print the result array as a string
        System.out.println(Arrays.toString(solution(10, 3)));
    }

    public static int[] solution(int startNum, int endNum) {
        // 결과 배열 선언 (크기 = startNum - endNum + 1)
        // Declare result array (size = startNum - endNum + 1)
        int[] answer = new int[startNum - endNum + 1];
        
        // 배열에 값을 넣기 위한 인덱스 초기화
        // Initialize index to insert values into array
        int index = 0;
        
        // startNum부터 endNum까지 1씩 감소하며 배열에 값 저장
        // Store values in array from startNum to endNum, decreasing by 1
        for (int i = startNum; i >= endNum; i--) {
            answer[index] = i;
            index++;
        }
        
        // 결과 배열 반환
        // Return the result array
        return answer;
    }
}