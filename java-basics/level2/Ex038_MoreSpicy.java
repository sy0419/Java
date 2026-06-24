// 더 맵게

// 매운 것을 좋아하는 Leo는 모든 음식의 스코빌 지수를 K 이상으로 만들고 싶습니다.
// 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 Leo는 스코빌 지수가 가장 낮은 두 개의 음식을
// 아래와 같이 특별한 방법으로 섞어 새로운 음식을 만듭니다.
// 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
// Leo는 모든 음식의 스코빌 지수가 K 이상이 될 때까지 반복하여 섞습니다.
// Leo가 가진 음식의 스코빌 지수를 담은 배열 scoville과 원하는 스코빌 지수 K가 주어질 때,
// 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 섞어야 하는 최소 횟수를 return 하도록 solution 함수를 작성해주세요.

// 제한 사항
// scoville의 길이는 2 이상 1,000,000 이하입니다.
// K는 0 이상 1,000,000,000 이하입니다.
// scoville의 원소는 각각 0 이상 1,000,000 이하입니다.
// 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return 합니다.

// 입출력 예
//        scoville          K      return
// [1, 2, 3, 9, 10, 12]     7        2

// 입출력 예 설명
// 스코빌 지수가 1인 음식과 2인 음식을 섞으면 음식의 스코빌 지수가 아래와 같이 됩니다.
// 새로운 음식의 스코빌 지수 = 1 + (2 * 2) = 5
// 가진 음식의 스코빌 지수 = [5, 3, 9, 10, 12]
// 스코빌 지수가 3인 음식과 5인 음식을 섞으면 음식의 스코빌 지수가 아래와 같이 됩니다.
// 새로운 음식의 스코빌 지수 = 3 + (5 * 2) = 13
// 가진 음식의 스코빌 지수 = [13, 9, 10, 12]

// 모든 음식의 스코빌 지수가 7 이상이 되었고 이때 섞은 횟수는 2회입니다.

// [English]
// More Spicy
//
// Leo loves spicy food and wants every food's Scoville index to be at least K.
// To make all foods reach a Scoville index of at least K,
// he mixes the two foods with the lowest Scoville indices
// and creates a new food using the following formula.
// New Scoville Index = Least spicy food + (Second least spicy food × 2)
// Leo repeats this process until every food's Scoville index is at least K.
// Given an array scoville containing the Scoville index of each food
// and the target value K,
// write the solution function to return the minimum number of mixes required
// to make every food's Scoville index at least K.

// Constraints
// The length of scoville is between 2 and 1,000,000.
// K is between 0 and 1,000,000,000.
// Each element of scoville is between 0 and 1,000,000.
// Return -1 if it is impossible to make every food's Scoville index at least K.

// Example Input / Output
//        scoville          K      return
// [1, 2, 3, 9, 10, 12]     7        2

// Example Explanation
// Mixing the foods with Scoville indices 1 and 2 results in:
// New Scoville Index = 1 + (2 * 2) = 5
// Current foods = [5, 3, 9, 10, 12]
// Mixing the foods with Scoville indices 3 and 5 results in:
// New Scoville Index = 3 + (5 * 2) = 13
// Current foods = [13, 9, 10, 12]
// Now all foods have a Scoville index of at least 7,
// and the number of mixes performed is 2.

import java.util.PriorityQueue;

public class Ex038_MoreSpicy {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {1, 2, 3, 9, 10, 12}, 7));
    }

    public static int solution(int[] scoville, int k) {
        // 최소 힙(PriorityQueue)을 생성한다. # Create a min heap (PriorityQueue).
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 섞은 횟수를 저장한다. # Store the number of mixes.
        int result = 0;

        // 모든 음식의 스코빌 지수를 최소 힙에 저장한다. # Store all Scoville indices in the min heap.
        for (int num : scoville) {
            pq.offer(num);
        }

        // 가장 작은 스코빌 지수가 K보다 작은 동안 반복한다.
        // Repeat while the smallest Scoville index is less than K.
        while (pq.peek() < k) {

            // 음식이 1개뿐이면 더 이상 섞을 수 없으므로 -1을 반환한다.
            // If only one food remains, it cannot be mixed anymore, so return -1.
            if (pq.size() < 2) {
                return -1;
            }

            // 가장 작은 스코빌 지수를 꺼낸다. # Remove the smallest Scoville index.
            int first = pq.poll();

            // 두 번째로 작은 스코빌 지수를 꺼낸다. # Remove the second smallest Scoville index.
            int second = pq.poll();

            // 새로운 음식의 스코빌 지수를 계산한다. # Calculate the Scoville index of the new mixed food.
            int mixed = first + second * 2;

            // 새로 만든 음식을 최소 힙에 다시 넣는다. # Insert the newly mixed food back into the min heap.
            pq.offer(mixed);

            // 섞은 횟수를 증가시킨다. # Increase the mix count.
            result++;
        }

        // 모든 음식의 스코빌 지수가 K 이상이 되면 섞은 횟수를 반환한다.
        // # Return the number of mixes once all foods reach at least K.
        return result;
    }
}