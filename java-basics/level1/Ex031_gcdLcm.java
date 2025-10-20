import java.util.Arrays;

// 두 수를 입력받아 두 수의 최대공약수와 최소공배수를 반환하는 함수, solution을 완성해 보세요. 배열의 맨 앞에 최대공약수, 그다음 최소공배수를 넣어 반환하면 됩니다. 예를 들어 두 수 3, 12의 최대공약수는 3, 최소공배수는 12이므로 solution(3, 12)는 [3, 12]를 반환해야 합니다.

// 제한 사항
// 두 수는 1이상 1000000이하의 자연수입니다.

public class Ex031_gcdLcm {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, 12))); // 최대공약수 3, 최소공배수 12 출력 # Print GCD 3 and LCM 12
        System.out.println(Arrays.toString(solution(2, 5)));  // 최대공약수 1, 최소공배수 10 출력 # Print GCD 1 and LCM 10
    }

    public static int[] solution(int n, int m) {
        int a = n;                     // 원래 첫 번째 수 저장 # Store original first number
        int b = m;                     // 원래 두 번째 수 저장 # Store original second number

        while(b != 0) {                // b가 0이 될 때까지 반복 # Repeat until b becomes 0
            int temp = b;              // b 값을 임시 저장 # Temporarily store b
            b = a % b;                 // a를 b로 나눈 나머지를 b에 저장 # Assign b to remainder of a divided by b
            a = temp;                  // 이전 b 값을 a에 저장 # Assign previous b value to a
        }
        int gcd = a;                   // 최대공약수는 a에 저장됨 # GCD is stored in a
        int lcm = (n * m) / gcd;       // 최소공배수는 두 수 곱을 최대공약수로 나눈 값 # LCM = product of n and m divided by GCD

        return new int[]{gcd, lcm};    // 결과 배열로 최대공약수, 최소공배수를 반환 # Return array with GCD and LCM
    }
}