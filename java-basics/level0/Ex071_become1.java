// 정수가 있을 때, 짝수라면 반으로 나누고, 홀수라면 1을 뺀 뒤 반으로 나누면, 마지막엔 1이 됩니다. 
// 예를 들어 10이 있다면 다음과 같은 과정으로 1이 됩니다.

// 10 / 2 = 5
// (5 - 1) / 2 = 2
// 2 / 2 = 1
// 위와 같이 3번의 나누기 연산으로 1이 되었습니다.
// 정수들이 담긴 리스트 num_list가 주어질 때, num_list의 모든 원소를 1로 만들기 위해서 필요한 나누기 연산의 횟수를 return하도록 solution 함수를 완성해주세요.

// 제한사항
// 3 ≤ num_list의 길이 ≤ 15
// 1 ≤ num_list의 원소 ≤ 30

public class Ex071_become1 {
    public static void main(String[] args) {
        // 테스트 케이스 실행 및 결과 출력
        // # Run test case and print the result
        System.out.println(solution(new int[] {12, 4, 15, 1, 14}));
    }

    public static int solution(int[] numList) {
        int count = 0; 
        // # Total count of division operations

        for(int i = 0; i < numList.length; i++) {
            // # Repeat until each number becomes 1
            while(numList[i] != 1) {
                if (numList[i] % 2 == 1) {
                    numList[i] = (numList[i] - 1) / 2; 
                    // # If odd: subtract 1, then divide by 2
                } else {
                    numList[i] = numList[i] / 2;
                    // # If even: divide by 2
                }
                count++; 
                // # Increase count for each division operation
            }
        }
        return count; 
        // # Return total number of division steps
    }
}