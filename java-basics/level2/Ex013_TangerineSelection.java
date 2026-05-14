// 귤 고르기

// 경화는 과수원에서 귤을 수확했습니다. 경화는 수확한 귤 중 'k'개를 골라 상자 하나에 담아 판매하려고 합니다. 
// 그런데 수확한 귤의 크기가 일정하지 않아 보기에 좋지 않다고 생각한 경화는 귤을 크기별로 분류했을 때 서로 다른 종류의 수를 
// 최소화하고 싶습니다.

// 예를 들어, 경화가 수확한 귤 8개의 크기가 [1, 3, 2, 5, 4, 5, 2, 3] 이라고 합시다. 
// 경화가 귤 6개를 판매하고 싶다면, 크기가 1, 4인 귤을 제외한 여섯 개의 귤을 상자에 담으면, 
// 귤의 크기의 종류가 2, 3, 5로 총 3가지가 되며 이때가 서로 다른 종류가 최소일 때입니다.

// 경화가 한 상자에 담으려는 귤의 개수 k와 귤의 크기를 담은 배열 tangerine이 매개변수로 주어집니다. 
// 경화가 귤 k개를 고를 때 크기가 서로 다른 종류의 수의 최솟값을 return 하도록 solution 함수를 작성해주세요.

// 제한사항
// 1 ≤ k ≤ tangerine의 길이 ≤ 100,000
// 1 ≤ tangerine의 원소 ≤ 10,000,000

// 입출력 예
// k	       tangerine	       result
// 6	[1, 3, 2, 5, 4, 5, 2, 3]	 3
// 4	[1, 3, 2, 5, 4, 5, 2, 3]     2
// 2	[1, 1, 1, 1, 2, 2, 2, 3]	 1

// 입출력 예 설명
// 입출력 예 #1
// 본문에서 설명한 예시입니다.

// 입출력 예 #2
// 경화는 크기가 2인 귤 2개와 3인 귤 2개 또는 2인 귤 2개와 5인 귤 2개 또는 3인 귤 2개와 5인 귤 2개로 귤을 판매할 수 있습니다. 
// 이때의 크기 종류는 2가지로 이 값이 최소가 됩니다.

// 입출력 예 #3
// 경화는 크기가 1인 귤 2개를 판매하거나 2인 귤 2개를 판매할 수 있습니다. 
// 이때의 크기 종류는 1가지로, 이 값이 최소가 됩니다.

import java.util.*;

public class Ex013_TangerineSelection {
    public static void main(String[] args) {
        System.out.println(solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
        System.out.println(solution(4, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
        System.out.println(solution(2, new int[]{1, 1, 1, 1, 2, 2, 2, 3}));
    }

    public static int solution(int k, int[] tangerine) {

        // 귤 크기별 개수 저장용 HashMap # HashMap to store count of each tangerine size
        Map<Integer, Integer> tangerineCount = new HashMap<>();

        // 사용한 귤 종류 수 #  Number of tangerine types used
        int type = 0;

        // 귤 크기별 등장 횟수 카운팅 # Count occurrences of each tangerine size
        for (int i = 0; i < tangerine.length; i++) {
            tangerineCount.put(
                tangerine[i],
                tangerineCount.getOrDefault(tangerine[i], 0) + 1
            );
        }

        // 등장 횟수만 List로 변환 # Convert counts into List
        List<Integer> counts = new ArrayList<>(tangerineCount.values());

        // 많이 나온 귤부터 사용하기 위해 내림차순 정렬 # Sort counts in descending order
        Collections.sort(counts, Collections.reverseOrder());

        // 큰 개수부터 k 차감 #  Subtract larger counts first
        for (int i = 0; i < counts.size(); i++) {

            // 현재 귤 개수만큼 k 감소 # Reduce k by current count
            k -= counts.get(i);

            // 사용한 귤 종류 증가 #  Increase used type count
            type++;

            // k개를 모두 채웠으면 종료 # Stop when enough tangerines are selected
            if (k <= 0) {
                break;
            }
        }

        // 최소 귤 종류 개수 반환 # Return minimum number of tangerine types
        return type;
    }
}