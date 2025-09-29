// 길이가 같은 두 1차원 정수 배열 a, b가 매개변수로 주어집니다. a와 b의 내적을 return 하도록 solution 함수를 완성해주세요.
// 이때, a와 b의 내적은 a[0]*b[0] + a[1]*b[1] + ... + a[n-1]*b[n-1] 입니다. (n은 a, b의 길이)

// 제한사항
// a, b의 길이는 1 이상 1,000 이하입니다.
// a, b의 모든 수는 -1,000 이상 1,000 이하입니다.

public class Ex022_DotProduct {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {1, 2, 3, 4}, new int[] {-3, -1, 0, 2}));
        System.out.println(solution(new int[] {-1, 0, 1}, new int[] {1, 0, -1}));
    }

    public static int solution(int[] a, int[] b) {
        int result = 0; // 결과값을 저장할 변수 선언 및 초기화 # Declare and initialize a variable to store the result
        for (int i = 0; i < a.length; i++) { // 배열 a의 길이만큼 반복 # Loop through the length of array a
            result += a[i] * b[i]; // 각 인덱스의 곱을 결과에 누적 # Accumulate the product of elements at each index into result
        }
        return result; // 누적된 내적 값을 반환 # Return the accumulated dot product value
    }
}