// 원형 수열의 연속 부분 수열 합

// 철호는 수열을 가지고 놀기 좋아합니다.
// 어느 날 철호는 어떤 자연수로 이루어진 원형 수열의 연속하는 부분 수열의 합으로 만들 수 있는 수가
// 모두 몇 가지인지 알아보고 싶어졌습니다.

// 원형 수열이란 일반적인 수열에서 처음과 끝이 연결된 형태의 수열을 말합니다.
// 예를 들어 수열 [7, 9, 1, 1, 4] 로 원형 수열을 만들면 처음과 끝이 연결됩니다.

// 원형 수열의 모든 원소 elements가 순서대로 주어질 때,
// 원형 수열의 연속 부분 수열 합으로 만들 수 있는 수의 개수를
// return 하도록 solution 함수를 완성해주세요.

// 제한사항
// 3 ≤ elements의 길이 ≤ 1,000
// 1 ≤ elements의 원소 ≤ 1,000

// 입출력 예
// elements	        result
// [7,9,1,1,4]	    18

import java.util.HashSet;

public class Ex015_CircularSubsequenceSum {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{7, 9, 1, 1, 4}));
    }

    public static int solution(int[] elements) {

        // 원본 배열 길이 저장 # Store original array length
        int n = elements.length;

        // 원형 처리를 위한 2배 배열 생성 # Create doubled array for circular sequence
        int[] arr = new int[n * 2];

        // 중복 제거를 위한 HashSet # HashSet to remove duplicate sums
        HashSet<Integer> hashSet = new HashSet<>();

        // 배열 2배 복사 # Copy array twice
        for (int i = 0; i < n; i++) {
            arr[i] = elements[i];
            arr[i + n] = elements[i];
        }

        // 부분 수열 길이 반복 (1 ~ n) # Repeat subsequence length from 1 to n
        for (int length = 1; length <= n; length++) {

            // 시작 위치 반복 # Repeat start position
            for (int start = 0; start < n; start++) {

                // 부분 수열 합 저장 변수 # Variable to store subsequence sum
                int sum = 0;

                // 길이만큼 숫자 더하기 # Add numbers according to subsequence length
                for (int k = 0; k < length; k++) {
                    sum += arr[start + k];
                }

                // 중복 제거하며 저장 # Store unique sum only
                hashSet.add(sum);
            }
        }

        // 중복 제거된 합 개수 반환 # Return number of unique sums
        return hashSet.size();
    }
}