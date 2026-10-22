
// 숫자 카드 나누기
// 철수와 영희는 선생님으로부터 숫자가 하나씩 적힌 카드들을 절반씩 나눠 가진다.
// 다음 두 조건 중 하나를 만족하는 가장 큰 양의 정수 a를 구하려고 한다.
// 1. 철수가 가진 카드에 적힌 모든 숫자를 나눌 수 있고, 영희가 가진 카드에 적힌 숫자 중 하나도 나눌 수 없는 양의 정수 a
// 2. 영희가 가진 카드에 적힌 모든 숫자를 나눌 수 있고, 철수가 가진 카드에 적힌 숫자 중 하나도 나눌 수 없는 양의 정수 a
//
// 조건을 만족하는 양의 정수가 없다면 0을 반환한다.
//
// 제한사항
// - 1 <= arrayA.length == arrayB.length <= 500,000
// - 1 <= arrayA[i], arrayB[i] <= 100,000,000
//
// 입출력 예
//     arrayA              arrayB              result
//    [10, 17]             [5, 20]                0
//    [10, 20]             [5, 17]               10
// [14, 35, 119]       [18, 30, 102]              7
//
// 입출력 예 설명
// 입출력 예 #1
// 철수가 가진 카드의 숫자 10과 17을 모두 나눌 수 있는 양의 정수는 1뿐이다.
// 1은 영희가 가진 카드의 숫자 5와 20도 나눌 수 있으므로 조건을 만족하지 않는다.
// 영희가 가진 카드의 숫자 5와 20을 모두 나눌 수 있는 양의 정수 중에서도
// 철수가 가진 카드의 숫자 10과 17을 하나도 나눌 수 없는 정수는 없다.
// 따라서 0을 반환한다.
//
// 입출력 예 #2
// 철수가 가진 카드의 숫자 10과 20을 모두 나눌 수 있는 양의 정수 중에서
// 영희가 가진 카드의 숫자 5와 17을 하나도 나눌 수 없는 가장 큰 정수는 10이다.
// 따라서 10을 반환한다.
//
// 입출력 예 #3
// 철수가 가진 카드의 숫자 14, 35, 119를 모두 나눌 수 있는 양의 정수 중에서
// 영희가 가진 카드의 숫자 18, 30, 102를 하나도 나눌 수 없는 가장 큰 정수는 7이다.
// 3은 영희가 가진 카드의 숫자를 모두 나눌 수 있지만 철수가 가진 카드의 숫자도 나눌 수 있으므로 조건을 만족하지 않는다.
// 따라서 7을 반환한다.

// Number Card Division
// Cheolsu and Younghee each receive half of a set of numbered cards.
// Find the largest positive integer a that satisfies either of the following conditions:
//
// 1. a divides every number in Cheolsu's cards but does not divide any number in Younghee's cards.
// 2. a divides every number in Younghee's cards but does not divide any number in Cheolsu's cards.
//
// Return 0 if no positive integer satisfies either condition.
//
// Constraints
// - 1 <= arrayA.length == arrayB.length <= 500,000
// - 1 <= arrayA[i], arrayB[i] <= 100,000,000
//
// Examples
//     arrayA              arrayB              result
//    [10, 17]             [5, 20]                0
//    [10, 20]             [5, 17]               10
// [14, 35, 119]       [18, 30, 102]              7
//
// Example Explanations
// Example 1
// The only positive integer that divides both 10 and 17 is 1.
// However, 1 also divides both 5 and 20, so it does not satisfy the condition.
// There is also no positive integer that divides both 5 and 20
// but does not divide either 10 or 17.
// Therefore, return 0.
//
// Example 2
// The largest positive integer that divides both 10 and 20
// but does not divide either 5 or 17 is 10.
// Therefore, return 10.
//
// Example 3
// The largest positive integer that divides 14, 35, and 119
// but does not divide any of 18, 30, and 102 is 7.
// Although 3 divides all the numbers in Younghee's cards,
// it also divides some numbers in Cheolsu's cards, so it does not satisfy the condition.
// Therefore, return 7.

public class Ex066_NumberCardDivision {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{10, 17}, new int[]{5, 20}));       
        System.out.println(solution(new int[]{10, 20}, new int[]{5, 17}));     
        System.out.println(solution(new int[]{14, 35, 119}, new int[]{18, 30, 102})); 
    }

    public static int solution(int[] arrayA, int[] arrayB) {
        int result = 0; // 조건을 만족하는 가장 큰 수 / Largest number satisfying the condition
        int gcdArrayA = arrayA[0]; // 배열 A의 최대공약수 초기값 / Initial GCD of array A
        int gcdArrayB = arrayB[0]; // 배열 B의 최대공약수 초기값 / Initial GCD of array B
        boolean isValid = true; // 후보가 조건을 만족하는지 확인 / Check whether the candidate is valid

        // 배열 A의 모든 원소의 최대공약수를 구한다 / Find the GCD of all elements in array A
        for (int i = 1; i < arrayA.length; i++) {
            gcdArrayA = gcdCalulator(gcdArrayA, arrayA[i]);
        }

        // A의 최대공약수가 배열 B의 어떤 원소도 나누지 않는지 확인한다
        // Check that the GCD of A does not divide any element in array B
        for (int i = 0; i < arrayB.length; i++) {
            if (arrayB[i] % gcdArrayA == 0) {
                isValid = false; // 조건을 만족하지 않음 / The candidate is invalid
                break; // 더 확인할 필요 없이 반복문 종료 / Stop checking further elements
            }
        }

        // 유효한 후보라면 결과를 갱신한다 / Update the result if the candidate is valid
        if (isValid && result < gcdArrayA) {
            result = gcdArrayA;
        }

        isValid = true; // 두 번째 후보를 검사하기 위해 초기화 / Reset for the second candidate

        // 배열 B의 모든 원소의 최대공약수를 구한다 / Find the GCD of all elements in array B
        for (int i = 1; i < arrayB.length; i++) {
            gcdArrayB = gcdCalulator(gcdArrayB, arrayB[i]);
        }

        // B의 최대공약수가 배열 A의 어떤 원소도 나누지 않는지 확인한다
        // Check that the GCD of B does not divide any element in array A
        for (int i = 0; i < arrayA.length; i++) {
            if (arrayA[i] % gcdArrayB == 0) {
                isValid = false; // 조건을 만족하지 않음 / The candidate is invalid
                break; // 더 확인할 필요 없이 반복문 종료 / Stop checking further elements
            }
        }

        // 두 번째 후보가 더 크고 유효하면 결과를 갱신한다
        // Update the result if the second candidate is valid and larger
        if (isValid && result < gcdArrayB) {
            result = gcdArrayB;
        }

        return result; // 최종 결과 반환 / Return the final result
    }

    public static int gcdCalulator(int a, int b) {
        int gcd = 0;

        // 나머지가 0이면 b가 최대공약수이다 / If the remainder is zero, b is the GCD
        if (a % b == 0) {
            gcd = b;
        } else {
            // 나머지가 0이 될 때까지 유클리드 호제법을 반복한다
            // Apply the Euclidean algorithm until the remainder becomes zero
            while (a % b != 0) {
                int i = a % b; // 나머지 저장 / Store the remainder
                a = b; // 이전 b를 a로 이동 / Move the previous b to a
                b = i; // 나머지를 b로 이동 / Move the remainder to b
            }
            gcd = b; // 마지막으로 남은 b가 최대공약수이다 / The final b is the GCD
        }

        return gcd; // 최대공약수 반환 / Return the GCD
    }
}