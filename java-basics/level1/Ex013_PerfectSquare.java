// 임의의 양의 정수 n에 대해, n이 어떤 양의 정수 x의 제곱인지 아닌지 판단하려 합니다.
// n이 양의 정수 x의 제곱이라면 x+1의 제곱을 리턴하고, n이 양의 정수 x의 제곱이 아니라면 -1을 리턴하는 함수를 완성하세요.

// 제한 사항
// n은 1이상, 50000000000000 이하인 양의 정수입니다.

public class Ex013_PerfectSquare {
    public static void main(String[] args) {
        System.out.println(solution(121)); // 121은 11의 제곱, (11+1)^2 = 144 반환 기대 # 121 is 11 squared, expect 144 as (11+1)^2
        System.out.println(solution(3));   // 3은 완전 제곱수가 아니므로 -1 반환 기대 # 3 is not a perfect square, expect -1
    }

    public static long solution(long n) {
        double x = Math.sqrt(n); // n의 제곱근 구하기 # Calculate square root of n
        if (x % 1 == 0) {        // 제곱근이 정수인지 확인 # Check if the square root is an integer
            return (long) Math.pow(x + 1, 2); // (x+1)^2 계산 후 반환 # Return (x+1) squared
        }
        return -1; // 완전 제곱수가 아니면 -1 반환 # Return -1 if not a perfect square
    }
}
