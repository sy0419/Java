// 정수 리스트 num_list와 찾으려는 정수 n이 주어질 때,
// num_list 안에 n이 있으면 1을 없으면 0을 return하도록 solution 함수를 완성해주세요.
// Given an integer list num_list and an integer n to find,
// return 1 if n exists in num_list, otherwise return 0.

// 제한사항
// 3 ≤ num_list의 길이 ≤ 100
// 1 ≤ num_list의 원소 ≤ 100
// 1 ≤ n ≤ 100

public class Ex110_containsNumber {
    public static void main(String[] args) {
        // 테스트 예제 실행
        // Run test examples
        System.out.println(solution(new int[] {1, 2, 3, 4, 5}, 3));  // 1 expected
        System.out.println(solution(new int[] {15, 98, 23, 2, 15}, 20));  // 0 expected
    }

    public static int solution(int[] numList, int n) {
        // 배열을 순회하면서 n과 일치하는 원소가 있는지 확인
        // Loop through the array to check if any element matches n
        for (int i = 0; i < numList.length; i++) {
            if (numList[i] == n) {
                return 1;  // 있으면 1 반환, return 1 if found
            }
        }
        return 0;  // 없으면 0 반환, return 0 if not found
    }
}