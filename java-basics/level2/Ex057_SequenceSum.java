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
//   [2, 2, 2, 2, 2]            6         [0, 2]

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
// Since multiple subsequences have the same shortest length, return [0, 2].

import java.util.Arrays;

public class Ex057_SequenceSum {
    public static void main(String[] args) {
        // 첫 번째 테스트 케이스를 실행한다. # Run the first test case.
        System.out.println(Arrays.toString(solution(new int[] {1, 2, 3, 4, 5}, 7)));

        // 두 번째 테스트 케이스를 실행한다. # Run the second test case.
        System.out.println(Arrays.toString(solution(new int[] {1, 1, 1, 2, 3, 4, 5}, 5)));

        // 세 번째 테스트 케이스를 실행한다. # Run the third test case.
        System.out.println(Arrays.toString(solution(new int[] {2, 2, 2, 2, 2}, 6)));
    }

    public static int[] solution(int[] sequence, int k) {
        // 왼쪽 포인터를 0으로 초기화한다. # Initialize the left pointer to 0.
        int leftIndex = 0;

        // 현재 부분 수열의 합을 저장한다. # Store the current subsequence sum.
        long sum = 0;

        // 결과 부분 수열의 시작 인덱스를 저장한다. # Store the start index of the result subsequence.
        int resultLeft = 0;

        // 결과 부분 수열의 마지막 인덱스를 저장한다. # Store the end index of the result subsequence.
        int resultRight = 0;

        // 최소 부분 수열 길이를 최대 가능한 값보다 크게 초기화한다. # Initialize the minimum subsequence length above the maximum possible length.
        int minLength = sequence.length + 1;

        // 오른쪽 포인터를 이동하며 부분 수열을 탐색한다. # Move the right pointer to search for subsequences.
        for (int rightIndex = 0; rightIndex < sequence.length; rightIndex++) {
            // 현재 원소를 부분 수열에 추가한다. # Add the current element to the subsequence.
            sum += sequence[rightIndex];

            // 현재 합이 k보다 작으면 다음 원소를 추가한다. # Add the next element if the current sum is less than k.
            if (sum < k) {
                continue;
            }

            // 현재 합이 k와 같으면 정답 후보를 확인한다. # Check the candidate when the current sum equals k.
            if (sum == k) {
                // 현재 부분 수열의 길이를 계산한다. # Calculate the current subsequence length.
                int length = rightIndex - leftIndex + 1;

                // 현재 부분 수열이 더 짧으면 결과를 갱신한다. # Update the result if the current subsequence is shorter.
                if (length < minLength) {
                    resultLeft = leftIndex;
                    resultRight = rightIndex;
                    minLength = length;
                }
            } else {
                // 합이 k보다 크면 왼쪽 원소를 제거한다. # Remove elements from the left if the sum is greater than k.
                while (sum > k) {
                    sum -= sequence[leftIndex];
                    leftIndex++;
                }

                // 왼쪽 원소를 제거한 후 합이 k인지 확인한다. # Check whether the sum equals k after removing elements.
                if (sum == k) {
                    // 현재 부분 수열의 길이를 계산한다. # Calculate the current subsequence length.
                    int length = rightIndex - leftIndex + 1;

                    // 현재 부분 수열이 더 짧으면 결과를 갱신한다. # Update the result if the current subsequence is shorter.
                    if (length < minLength) {
                        resultLeft = leftIndex;
                        resultRight = rightIndex;
                        minLength = length;
                    }
                }
            }
        }

        // 가장 짧은 부분 수열의 시작과 마지막 인덱스를 반환한다. # Return the start and end indices of the shortest subsequence.
        return new int[] {resultLeft, resultRight};
    }
}