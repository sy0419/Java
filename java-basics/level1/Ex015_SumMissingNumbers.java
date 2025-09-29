// 0부터 9까지의 숫자 중 일부가 들어있는 정수 배열 numbers가 매개변수로 주어집니다. numbers에서 찾을 수 없는 0부터 9까지의 숫자를 모두 찾아 더한 수를 return 하도록 solution 함수를 완성해주세요.

// 제한사항
// 1 ≤ numbers의 길이 ≤ 9
// 0 ≤ numbers의 모든 원소 ≤ 9
// numbers의 모든 원소는 서로 다릅니다.

public class Ex015_SumMissingNumbers {
    public static void main(String[] args) {
        System.out.println(solution1(new int[] {1,2,3,4,6,7,8,0}));  // 14 반환 예상 # Expect 14
        System.out.println(solution1(new int[] {5,8,4,0,6,7,9}));    // 6 반환 예상 # Expect 6
        System.out.println(solution2(new int[] {1,2,3,4,6,7,8,0}));  // 14 반환 예상 # Expect 14
        System.out.println(solution2(new int[] {5,8,4,0,6,7,9}));    // 6 반환 예상 # Expect 6
    }

    // 인덱스 기반 for문을 사용해 배열의 합을 구하고, 45에서 빼기 # Use index-based for loop to sum array and subtract from 45
    public static int solution1(int[] numbers) {
        int total = 45; 
        int arrSum = 0;
        for (int i = 0; i < numbers.length; i++) {
            arrSum += numbers[i];
        }
        return total - arrSum;
    }

    // 향상된 for문 사용해 배열 요소를 바로 빼면서 합 계산 # Use enhanced for loop to subtract elements from 45
    public static int solution2(int[] numbers) {
        int sum = 45;
        for (int i : numbers) {
            sum -= i;
        }
        return sum;
    }
}