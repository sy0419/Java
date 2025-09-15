// 이 문제에서 두 정수 배열의 대소관계를 다음과 같이 정의합니다.
// 두 배열의 길이가 다르다면, 배열의 길이가 긴 쪽이 더 큽니다.
// 배열의 길이가 같다면 각 배열에 있는 모든 원소의 합을 비교하여 다르다면 더 큰 쪽이 크고, 같다면 같습니다.
// 두 정수 배열 arr1과 arr2가 주어질 때, 위에서 정의한 배열의 대소관계에 대하여 arr2가 크다면 -1, arr1이 크다면 1, 두 배열이 같다면 0을 return 하는 solution 함수를 작성해 주세요.

// 제한사항
// 1 ≤ arr1의 길이 ≤ 100
// 1 ≤ arr2의 길이 ≤ 100
// 1 ≤ arr1의 원소 ≤ 100
// 1 ≤ arr2의 원소 ≤ 100
// 문제에서 정의한 배열의 대소관계가 일반적인 프로그래밍 언어에서 정의된 배열의 대소관계와 다를 수 있는 점에 유의해주세요.

public class Ex095_compareArray {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {49, 13}, new int[] {70, 11, 2}));          // -1
        System.out.println(solution(new int[] {100, 17, 84, 1}, new int[] {55, 12, 65, 36})); // 1
        System.out.println(solution(new int[] {1, 2, 3, 4, 5}, new int[] {3, 3, 3, 3, 3}));   // 0
    }

    public static int solution(int[] arr1, int[] arr2) {
        int arr1Len = arr1.length;
        int arr2Len = arr2.length;

        // 배열 길이 비교
        // # Compare array lengths
        if (arr1Len > arr2Len) {
            return 1;
        } else if (arr1Len < arr2Len) {
            return -1;
        } else {
            // 배열의 길이가 같을 경우 합을 비교
            // # If lengths are equal, compare the sums of elements
            int arr1Sum = 0;
            int arr2Sum = 0;

            for (int i = 0; i < arr1Len; i++) {
                arr1Sum += arr1[i];
                arr2Sum += arr2[i];
            }

            // 합이 더 큰 배열 판별
            // # Determine which array has the greater sum
            if (arr1Sum > arr2Sum) {
                return 1;
            } else if (arr1Sum < arr2Sum) {
                return -1;
            } else {
                return 0; // 합도 같을 경우
                // # If sums are equal, arrays are considered equal
            }
        }
    }
}