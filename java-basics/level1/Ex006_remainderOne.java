// 자연수 n이 매개변수로 주어집니다. n을 x로 나눈 나머지가 1이 되도록 하는 가장 작은 자연수 x를 return 하도록 solution 함수를 완성해주세요. 답이 항상 존재함은 증명될 수 있습니다.

// 제한사항
// 3 ≤ n ≤ 1,000,000

public class Ex006_remainderOne { 
    public static void main(String[] args) { // main 메소드에서 테스트 케이스 실행 # Running the function with sample test cases
        System.out.println(solution(10)); // 입력값 10에 대해 실행 # Running the function with input 10
        System.out.println(solution(12)); // 입력값 12에 대해 실행 # Running the function with input 12
    }

    public static int solution(int n) { // solution 메소드: 주어진 n에 대해 가장 작은 x를 구하는 메소드 # solution method: A method to find the smallest x such that n % x == 1
        for (int i = 2; i < n; i++) { // x는 2부터 n-1까지 순차적으로 시도 # Try values of x starting from 2 up to n-1
            if (n % i == 1) { // n을 i로 나누었을 때 나머지가 1이면 x는 i # If n modulo i equals 1, return i as the smallest x
                return i; // 첫 번째로 나머지가 1인 i를 반환 # Return i when the first valid x is found
            }
        }
        return -1; // 만약 조건을 만족하는 값이 없다면 -1을 반환 (문제에서 항상 존재한다고 했지만 안전하게 추가) # Return -1 if no valid x is found (though the problem guarantees a solution, added for safety)
    }
}