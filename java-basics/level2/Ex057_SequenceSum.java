// 연속 부분 수열 합
// 비내림차순으로 정렬된 수열이 주어질 때, 다음 조건을 만족하는 부분 수열을 찾는다.
// 기존 수열에서 임의의 두 인덱스의 원소와 그 사이의 원소를 모두 포함하는 부분 수열이어야 한다.
// 부분 수열의 합은 k이다.
// 합이 k인 부분 수열이 여러 개인 경우 길이가 짧은 수열을 찾는다.
// 길이가 짧은 수열이 여러 개인 경우 앞쪽에 나오는 수열을 찾는다.
// 수열의 시작 인덱스와 마지막 인덱스를 배열에 담아 반환한다.
// 인덱스는 0부터 시작한다.

// 제한사항
// 5 ≤ sequence의 길이 ≤ 1,000,000
// 1 ≤ sequence의 원소 ≤ 1,000
// sequence는 비내림차순으로 정렬되어 있습니다.
// 5 ≤ k ≤ 1,000,000,000
// k는 항상 sequence의 부분 수열로 만들 수 있는 값입니다.

// 입출력 예
//      sequence                k          result
//   [1, 2, 3, 4, 5]            7          [2, 3]
// [1, 1, 1, 2, 3, 4, 5]        5          [6, 6]
//   [2, 2, 2, 2, 2]            6          [0, 2]

// 입출력 예 설명
// 입출력 예 #1
// [1, 2, 3, 4, 5]에서 합이 7인 연속된 부분 수열은 [3, 4]뿐이므로
// 해당 수열의 시작 인덱스인 2와 마지막 인덱스 3을 배열에 담아 [2, 3]을 반환합니다.
// 입출력 예 #2
// [1, 1, 1, 2, 3, 4, 5]에서 합이 5인 연속된 부분 수열은
// [1, 1, 1, 2], [2, 3], [5]가 있습니다.
// 이 중 [5]의 길이가 제일 짧으므로 해당 수열의 시작 인덱스와 마지막 인덱스를 담은 [6, 6]을 반환합니다.
// 입출력 예 #3
// [2, 2, 2, 2, 2]에서 합이 6인 연속된 부분 수열은 [2, 2, 2]로 3가지 경우가 있는데,
// 길이가 짧은 수열이 여러 개인 경우 앞쪽에 나온 수열을 찾으므로 [0, 2]를 반환합니다.

// Sequence Sum
// Given a non-decreasing sequence, find a contiguous subsequence that satisfies the following conditions.
// The subsequence must include the elements at two arbitrary indices from the original sequence and all elements between them.
// The sum of the subsequence must be k.
// If multiple subsequences have a sum of k, find the shortest one.
// If multiple subsequences have the same shortest length, find the one that appears first.
// Return the starting and ending indices of the subsequence.
// The indices start from 0.

// Constraints
// 5 ≤ sequence.length ≤ 1,000,000
// 1 ≤ sequence[i] ≤ 1,000
// sequence is sorted in non-decreasing order.
// 5 ≤ k ≤ 1,000,000,000
// k can always be formed as the sum of a subsequence.

// Examples
//      sequence                k          result
//   [1, 2, 3, 4, 5]            7          [2, 3]
// [1, 1, 1, 2, 3, 4, 5]        5          [6, 6]
//   [2, 2, 2, 2, 2]            6          [0, 2]

// Example Explanation
// Example #1
// In [1, 2, 3, 4, 5], the only contiguous subsequence with a sum of 7 is [3, 4],
// so return [2, 3], the starting and ending indices of the subsequence.
// Example #2
// In [1, 1, 1, 2, 3, 4, 5], the contiguous subsequences with a sum of 5 are
// [1, 1, 1, 2], [2, 3], and [5].
// Among them, [5] is the shortest, so return [6, 6].
// Example #3
// In [2, 2, 2, 2, 2], there are three contiguous subsequences [2, 2, 2] with a sum of 6.
// Since multiple subsequences have the same shortest length, return the one that appears first, [0, 2].

import java.util.Arrays;

public class Ex057_SequenceSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[] {1, 2, 3, 4, 5}, 7)));
        System.out.println(Arrays.toString(solution(new int[] {1, 1, 1, 2, 3, 4, 5}, 5)));
        System.out.println(Arrays.toString(solution(new int[] {2, 2, 2, 2, 2}, 6)));
    }

    public static int[] solution(int[] sequence, int k) {
        // 부분 수열의 시작과 끝을 가리킬 두 개의 포인터를 선언한다.
        // Declare two pointers to represent the start and end of the subsequence.
        int leftIndex = 0;
        int rightIndex = 0;

        // 현재 부분 수열의 합을 저장한다.
        // Store the sum of the current subsequence.
        long sum = 0;

        // 조건을 만족하는 부분 수열의 시작과 끝 인덱스를 저장한다.
        // Store the start and end indices of the valid subsequence.
        int resultLeft = 0;
        int resultRight = 0;

        // 가장 짧은 부분 수열의 길이를 저장한다.
        // Store the length of the shortest subsequence.
        int minLength = sequence.length;

        // 오른쪽 포인터가 배열의 끝에 도달하지 않았거나 현재 합이 k 이상인 동안 탐색한다.
        // Continue searching while the right pointer has not reached the end or the current sum is at least k.
        while (rightIndex < sequence.length || sum >= k) {

            // 현재 합이 k보다 작으면 오른쪽 포인터를 이동하여 원소를 추가한다.
            // If the current sum is less than k, move the right pointer and add an element.
            if (sum < k) {
                sum += sequence[rightIndex];
                rightIndex++;

            // 현재 합이 k보다 크면 왼쪽 포인터를 이동하여 원소를 제거한다.
            // If the current sum is greater than k, move the left pointer and remove an element.
            } else if (sum > k) {
                sum -= sequence[leftIndex];
                leftIndex++;

            // 현재 합이 k와 같으면 조건을 만족하는 부분 수열을 확인한다.
            // If the current sum equals k, check the valid subsequence.
            } else {

                // 현재 부분 수열의 길이를 계산한다.
                // Calculate the length of the current subsequence.
                int length = rightIndex - leftIndex;

                // 현재 부분 수열이 기존 결과보다 짧은 경우 결과를 갱신한다.
                // Update the result if the current subsequence is shorter than the previous result.
                if (length < minLength) {
                    resultLeft = leftIndex;
                    resultRight = rightIndex - 1;
                    minLength = length;
                }

                // 다음 부분 수열을 탐색하기 위해 가장 왼쪽 원소를 제거한다.
                // Remove the leftmost element to search for the next subsequence.
                sum -= sequence[leftIndex];
                leftIndex++;
            }
        }

        // 가장 짧은 부분 수열의 시작과 끝 인덱스를 반환한다.
        // Return the start and end indices of the shortest subsequence.
        return new int[] {resultLeft, resultRight};
    }
}