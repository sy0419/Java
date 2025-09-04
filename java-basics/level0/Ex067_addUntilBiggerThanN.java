// 정수 배열 numbers와 정수 n이 매개변수로 주어집니다. 
// numbers의 원소를 앞에서부터 하나씩 더하다가 그 합이 n보다 커지는 순간 이때까지 더했던 원소들의 합을 return 하는 solution 함수를 작성해 주세요.

// 제한사항
// 1 ≤ numbers의 길이 ≤ 100
// 1 ≤ numbers의 원소 ≤ 100
// 0 ≤ n < numbers의 모든 원소의 합

public class Ex067_addUntilBiggerThanN {
    public static void main(String[] args) {
        // 테스트 케이스 출력 # Print test cases
        System.out.println(solution(new int[] {34, 5, 71, 29, 100, 34}, 123));
        System.out.println(solution(new int[] {58, 44, 27, 10, 100}, 139));
    }

    public static int solution(int[] numbers, int n){
        int temp = 0;  // 합계를 저장할 변수 # Variable to store the sum

        for (int i = 0; i < numbers.length; i++) {
            temp += numbers[i];      // 현재 숫자 더함 # Add current number to sum
            if (temp > n) break;     // 합이 n보다 크면 반복 종료 # Break if sum exceeds n
        }

        return temp;  // 결과 반환 # Return the accumulated sum
    }
}