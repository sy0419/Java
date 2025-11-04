// 민수는 다양한 지폐를 수집하는 취미를 가지고 있습니다. 지폐마다 크기가 달라 지갑에 넣으려면 여러 번 접어서 넣어야 합니다. 
// 예를 들어 지갑의 크기가 30 * 15이고 지폐의 크기가 26 * 17이라면 한번 반으로 접어 13 * 17 크기로 만든 뒤 
// 90도 돌려서 지갑에 넣을 수 있습니다. 지폐를 접을 때는 다음과 같은 규칙을 지킵니다.

// 지폐를 접을 때는 항상 길이가 긴 쪽을 반으로 접습니다.
// 접기 전 길이가 홀수였다면 접은 후 소수점 이하는 버립니다.
// 접힌 지폐를 그대로 또는 90도 돌려서 지갑에 넣을 수 있다면 그만 접습니다.
// 지갑의 가로, 세로 크기를 담은 정수 리스트 wallet과 지폐의 가로, 세로 크기를 담은 정수 리스트 bill가 주어질 때, 
// 지갑에 넣기 위해서 지폐를 최소 몇 번 접어야 하는지 return하도록 solution함수를 완성해 주세요.

// 지폐를 지갑에 넣기 위해 접어야 하는 최소 횟수를 구하는 과정은 다음과 같습니다.
// 1. 지폐를 접은 횟수를 저장할 정수 변수 answer를 만들고 0을 저장합니다.
// 2. 반복문을 이용해 bill의 작은 값이 wallet의 작은 값 보다 크거나 bill의 큰 값이 wallet의 큰 값 보다 큰 동안 아래 과정을 반복합니다.
//     2-1. bill[0]이 bill[1]보다 크다면
//         bill[0]을 2로 나누고 나머지는 버립니다.
//     2-2. 그렇지 않다면
//         bill[1]을 2로 나누고 나머지는 버립니다.
//     2-3. answer을 1 증가시킵니다.
// 3. answer을 return합니다.
// 위의 의사코드와 작동방식이 다른 코드를 작성해도 상관없습니다.

// 제한사항
// wallet의 길이 = bill의 길이 = 2
// 10 ≤ wallet[0], wallet[1] ≤ 100
// 10 ≤ bill[0], bill[1] ≤ 2,000

public class Ex059_foldBill {
    public static void main(String[] args) {
        // 테스트 케이스 출력 # Test cases
        System.out.println(solution(new int[] {30, 15}, new int[] {26, 17})); // 1
        System.out.println(solution(new int[] {50, 50}, new int[] {100, 241})); // 4
    }

    public static int solution(int[] wallet, int[] bill) {
        int result = 0; // 접은 횟수 # Count of folds

        int w1 = Math.min(wallet[0], wallet[1]); // 지갑 작은쪽 # Wallet smaller side
        int w2 = Math.max(wallet[0], wallet[1]); // 지갑 큰쪽 # Wallet larger side
        int b1 = bill[0]; // 지폐 첫 번째 길이 # Bill side 1
        int b2 = bill[1]; // 지폐 두 번째 길이 # Bill side 2

        while (true) {
            // 지폐를 그대로 넣거나 90도 돌려 넣을 수 있는지 체크
            // Check if the bill can fit as is or rotated
            if ((b1 <= w1 && b2 <= w2) || (b1 <= w2 && b2 <= w1)) break;

            // 긴 쪽을 반으로 접기 # Fold the longer side
            if (b1 >= b2) b1 /= 2; 
            else b2 /= 2;

            result++; // 접은 횟수 증가 # Increase fold count
        }

        return result; // 최소 접은 횟수 반환 # Return minimum folds
    }
}