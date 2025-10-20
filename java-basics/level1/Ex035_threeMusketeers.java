// 한국중학교에 다니는 학생들은 각자 정수 번호를 갖고 있습니다. 
// 이 학교 학생 3명의 정수 번호를 더했을 때 0이 되면 3명의 학생은 삼총사라고 합니다. 
// 예를 들어, 5명의 학생이 있고, 각각의 정수 번호가 순서대로 -2, 3, 0, 2, -5일 때, 
// 첫 번째, 세 번째, 네 번째 학생의 정수 번호를 더하면 0이므로 세 학생은 삼총사입니다. 
// 또한, 두 번째, 네 번째, 다섯 번째 학생의 정수 번호를 더해도 0이므로 세 학생도 삼총사입니다.
// 따라서 이 경우 한국중학교에서는 두 가지 방법으로 삼총사를 만들 수 있습니다.
// 한국중학교 학생들의 번호를 나타내는 정수 배열 number가 매개변수로 주어질 때, 
// 학생들 중 삼총사를 만들 수 있는 방법의 수를 return 하도록 solution 함수를 완성하세요.

// 제한사항
// 3 ≤ number의 길이 ≤ 13
// -1,000 ≤ number의 각 원소 ≤ 1,000
// 서로 다른 학생의 정수 번호가 같을 수 있습니다.

public class Ex035_threeMusketeers {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {-2, 3, 0, 2, -5}));     // 결과: 2 # Expected output: 2
        System.out.println(solution(new int[] {-3, -2, -1, 0, 1, 2, 3})); // 결과: 5 # Expected output: 5
        System.out.println(solution(new int[] {-1, 1, -1, 1}));         // 결과: 0 # Expected output: 0
    }

    public static int solution(int[] number) {
        int count = 0; // 삼총사 조합 개수 저장 변수 # Variable to store the count of valid combinations

        for (int i = 0; i < number.length - 2; i++) {       // 첫 번째 학생 선택 # Select first student
            for (int j = i + 1; j < number.length - 1; j++) { // 두 번째 학생 선택 # Select second student
                for (int k = j + 1; k < number.length; k++) { // 세 번째 학생 선택 # Select third student
                    if (number[i] + number[j] + number[k] == 0) { // 세 학생의 번호 합이 0인지 확인 # Check if the sum is zero
                        count++; // 조건 만족 시 count 증가 # Increment count if valid
                    }
                }
            }
        }

        return count; // 삼총사 조합 수 반환 # Return the total number of combinations
    }
}