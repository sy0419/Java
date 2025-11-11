import java.util.Arrays; // 배열 관련 유틸리티 import # Import array utilities

public class Ex063_lotto {

    public static void main(String[] args) {
        // 테스트 케이스 출력 # Print test cases
        System.out.println(Arrays.toString(solution(new int[] {44, 1, 0, 0, 31, 25}, new int[] {31, 10, 45, 1, 6, 19}))); // [3, 5]
        System.out.println(Arrays.toString(solution(new int[] {0, 0, 0, 0, 0, 0}, new int[] {38, 19, 20, 40, 15, 25}))); // [1, 6]
        System.out.println(Arrays.toString(solution(new int[] {45, 4, 35, 20, 3, 9}, new int[] {20, 9, 3, 45, 4, 35}))); // [1, 1]
    }

    public static int[] solution(int[] lottos, int[] win_nums) {
        int matching = 0; // 맞춘 번호 개수 # Number of matched numbers
        int zero = 0; // 0의 개수 # Number of unknown numbers (0)

        // 로또 번호 순회 # Iterate through lottos
        for (int num : lottos) {
            if (num == 0) {
                zero++; // 0이면 unknown 개수 증가 # Increase unknown number count
            } else {
                // 당첨 번호와 비교 # Compare with winning numbers
                for (int win : win_nums) {
                    if (num == win) {
                        matching++; // 맞춘 번호 증가 # Increase matched number count
                        break; // 이미 맞췄으므로 루프 종료 # Break since matched
                    }
                }
            }
        }

        int highest = matching + zero; // 최고 순위에 해당하는 맞춘 개수 # Max possible matched numbers
        int lowest = matching; // 최저 순위에 해당하는 맞춘 개수 # Min possible matched numbers

        // 맞춘 개수별 순위 매핑 # Mapping matched number to rank
        int[] rank = {6, 6, 5, 4, 3, 2, 1}; // index 0~6 correspond to matched numbers 0~6

        return new int[] {rank[highest], rank[lowest]}; // 최고, 최저 순위 반환 # Return [highest rank, lowest rank]
    }
}