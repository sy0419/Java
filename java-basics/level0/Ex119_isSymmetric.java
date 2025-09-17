// n × n 크기의 이차원 배열 arr이 매개변수로 주어질 때, arr이 다음을 만족하면 1을 아니라면 0을 return 하는 solution 함수를 작성해 주세요.
// 0 ≤ i, j < n인 정수 i, j에 대하여 arr[i][j] = arr[j][i]

// 제한사항
// 1 ≤ arr의 길이 = arr의 원소의 길이 ≤ 100
// 1 ≤ arr의 원소의 원소 ≤ 1,000
// 모든 arr의 원소의 길이는 같습니다.

public class Ex119_isSymmetric {
    public static void main(String[] args) {
        // 대칭 행렬 테스트 # Test with symmetric matrix
        System.out.println(solution(new int[][]{{5, 192, 33}, {192, 72, 95}, {33, 95, 999}})); // 예상 출력: 1

        // 비대칭 행렬 테스트 # Test with asymmetric matrix
        System.out.println(solution(new int[][]{{1, 2}, {3, 4}})); // 예상 출력: 0
    }

    public static int solution(int[][] arr) {
        // 모든 i < j 쌍에 대해 arr[i][j] == arr[j][i]인지 확인 # Check symmetry for all i < j
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i][j] != arr[j][i]) {
                    return 0; // 하나라도 다르면 대칭 아님 # Not symmetric if any pair mismatches
                }
            }
        }
        return 1; // 모두 같으면 대칭 행렬 # Symmetric matrix if all pairs match
    }
}