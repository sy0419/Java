// 정수 리스트 num_list가 주어집니다. 
// 가장 첫 번째 원소를 1번 원소라고 할 때, 홀수 번째 원소들의 합과 짝수 번째 원소들의 합 중 큰 값을 return 하도록 solution 함수를 완성해주세요. 두 값이 같을 경우 그 값을 return합니다.

// 제한사항
// 5 ≤ num_list의 길이 ≤ 50
// -9 ≤ num_list의 원소 ≤ 9

public class Ex064_oddEvenIndex {
    public static void main(String[] args) {
        // 테스트 케이스 출력 # Print test cases
        System.out.println(solution(new int[] {4, 2, 6, 1, 7, 6}));
        System.out.println(solution(new int[] {-1, 2, 5, 6, 3}));
    }

    public static int solution(int[] numList) {
        int oddIndexSum = 0;  // 홀수 인덱스의 합 # Sum of odd indices
        int evenIndexSum = 0; // 짝수 인덱스의 합 # Sum of even indices

        for(int i = 0; i < numList.length; i++){
            if (i % 2 == 1) {
                oddIndexSum += numList[i];  // 인덱스가 홀수일 경우 더함 # Add if index is odd
            } else {
                evenIndexSum += numList[i]; // 인덱스가 짝수일 경우 더함 # Add if index is even
            }
        }

        // 두 값 중 더 큰 값을 반환 # Return the greater of the two sums
        // 아래는 Math.max 없이 구현한 코드 # Equivalent version without using Math.max
        // if (oddIndexSum >= evenIndexSum) {
        //     return oddIndexSum;  // 홀수 인덱스 합이 크거나 같으면 반환 # Return oddIndexSum if greater or equal
        // } else {
        //     return evenIndexSum; // 그 외엔 짝수 인덱스 합 반환 # Otherwise return evenIndexSum
        // }

        return Math.max(oddIndexSum, evenIndexSum); // 더 큰 값 반환 # Return the greater value
    }
}