// 정수 배열 arr가 주어집니다. 이때 arr의 원소는 1 또는 0입니다. 
// 정수 idx가 주어졌을 때, idx보다 크거나 같은 배열의 값이 1인 가장 작은 인덱스를 찾아서 반환하는 solution 함수를 완성해 주세요.
// 단, 만약 그러한 인덱스가 없다면 -1을 반환합니다.

// 제한사항
// 3 ≤ arr의 길이 ≤ 100'000
// arr의 원소는 전부 1 또는 0입니다.

public class Ex054_findingClosestIndex {
    public static void main(String[] args) {
        // 테스트 케이스 결과 출력
        // Print results of test cases
        System.out.println(solution(new int[] {0, 0, 0, 1}, 1));
        System.out.println(solution(new int[] {1, 0, 0, 1, 0, 0}, 4));
        System.out.println(solution(new int[] {1, 1, 1, 1, 0}, 3));
    }

    public static int solution(int[] arr, int idx) {
        // idx부터 시작해 배열 끝까지 순차 탐색
        // Search from idx to the end of the array
        for (int i = idx; i < arr.length; i++) {
            // 값이 1인 인덱스를 찾으면 반환
            // Return the index if the value is 1
            if (arr[i] == 1) {
                return i;
            }
        }
        // 조건을 만족하는 인덱스를 찾지 못한 경우 -1 반환
        // Return -1 if no such index is found
        return -1;
    }
}