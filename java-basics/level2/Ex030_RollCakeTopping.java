// 롤케이크 자르기

// 철수는 롤케이크를 두 조각으로 잘라서 동생과 한 조각씩 나눠 먹으려고 합니다. 
// 이 롤케이크에는 여러가지 토핑들이 일렬로 올려져 있습니다. 철수와 동생은 롤케이크를 공평하게 나눠먹으려 하는데, 
// 그들은 롤케이크의 크기보다 롤케이크 위에 올려진 토핑들의 종류에 더 관심이 많습니다.
// 그래서 잘린 조각들의 크기와 올려진 토핑의 개수에 상관없이 각 조각에 동일한 가짓수의 토핑이 올라가면 공평하게 롤케이크가 나누어진 것으로 생각합니다.

// 예를 들어, 롤케이크에 4가지 종류의 토핑이 올려져 있다고 합시다. 
// 토핑들을 1, 2, 3, 4와 같이 번호로 표시했을 때, 케이크 위에 토핑들이 [1, 2, 1, 3, 1, 4, 1, 2] 순서로 올려져 있습니다. 
// 만약 세 번째 토핑(1)과 네 번째 토핑(3) 사이를 자르면 롤케이크의 토핑은 [1, 2, 1], [3, 1, 4, 1, 2]로 나뉘게 됩니다. 
// 철수가 [1, 2, 1]이 놓인 조각을, 동생이 [3, 1, 4, 1, 2]가 놓인 조각을 먹게 되면 철수는 두 가지 토핑(1, 2)을 맛볼 수 있지만,
// 동생은 네 가지 토핑(1, 2, 3, 4)을 맛볼 수 있으므로, 이는 공평하게 나누어진 것이 아닙니다. 
// 만약 롤케이크의 네 번째 토핑(3)과 다섯 번째 토핑(1) 사이를 자르면 [1, 2, 1, 3], [1, 4, 1, 2]로 나뉘게 됩니다. 
// 이 경우 철수는 세 가지 토핑(1, 2, 3)을, 동생도 세 가지 토핑(1, 2, 4)을 맛볼 수 있으므로, 이는 공평하게 나누어진 것입니다.
// 공평하게 롤케이크를 자르는 방법은 여러가지 일 수 있습니다. 
// 위의 롤케이크를 [1, 2, 1, 3, 1], [4, 1, 2]으로 잘라도 공평하게 나뉩니다. 
// 어떤 경우에는 롤케이크를 공평하게 나누지 못할 수도 있습니다.

// 롤케이크에 올려진 토핑들의 번호를 저장한 정수 배열 topping이 매개변수로 주어질 때, 
// 롤케이크를 공평하게 자르는 방법의 수를 return 하도록 solution 함수를 완성해주세요.

// 제한사항
// 1 ≤ topping의 길이 ≤ 1,000,000
// 1 ≤ topping의 원소 ≤ 10,000

// 입출력 예
//         topping	          result
// [1, 2, 1, 3, 1, 4, 1, 2]	    2
//     [1, 2, 3, 1, 4]	        0

// 입출력 예 설명
// 입출력 예 #1
// 롤케이크를 [1, 2, 1, 3], [1, 4, 1, 2] 또는 [1, 2, 1, 3, 1], [4, 1, 2]와 같이 자르면 철수와 동생은 각각 
// 세 가지 토핑을 맛볼 수 있습니다. 이 경우 공평하게 롤케이크를 나누는 방법은 위의 두 가지만 존재합니다.

// 입출력 예 #2
// 롤케이크를 공평하게 나눌 수 없습니다.

// [English Translation]

// Roll Cake Cutting

// Cheolsu wants to split a roll cake into two pieces and share one piece with his younger sibling.
// This roll cake has several kinds of toppings arranged in a line.
// Cheolsu and his sibling want to divide the roll cake fairly,
// but they care more about the variety of toppings than the size of the cake.
// Therefore, regardless of the size of the pieces or the number of toppings,
// they consider the cake fairly divided if both pieces contain the same number of topping types.

// For example, suppose the roll cake has 4 types of toppings.
// If the toppings are labeled as 1, 2, 3, and 4,
// the toppings are arranged in the order [1, 2, 1, 3, 1, 4, 1, 2].
// If the cake is cut between the third topping (1) and the fourth topping (3),
// the cake becomes [1, 2, 1] and [3, 1, 4, 1, 2].
// In this case, Cheolsu can taste two topping types (1, 2),
// while the sibling can taste four topping types (1, 2, 3, 4),
// so this is not considered a fair split.
// If the cake is cut between the fourth topping (3) and the fifth topping (1),
// it becomes [1, 2, 1, 3] and [1, 4, 1, 2].
// In this case, both Cheolsu and the sibling can taste three topping types,
// so this is considered a fair split.
// There may be multiple ways to divide the roll cake fairly.
// For example, cutting the cake into [1, 2, 1, 3, 1] and [4, 1, 2]
// is also considered fair.
// In some cases, it may not be possible to divide the cake fairly.

// Given an integer array topping representing the toppings on the roll cake,
// complete the solution function to return the number of ways to split the cake fairly.

// Constraints
// 1 ≤ topping.length ≤ 1,000,000
// 1 ≤ topping[i] ≤ 10,000

// Examples
//        topping	            result
// [1, 2, 1, 3, 1, 4, 1, 2]	      2
//    [1, 2, 3, 1, 4]	          0

// Example Explanation
// Example #1
// If the cake is cut into [1, 2, 1, 3], [1, 4, 1, 2]
// or [1, 2, 1, 3, 1], [4, 1, 2],
// both Cheolsu and the sibling can taste three topping types.
// Therefore, there are exactly two fair ways to split the cake.

// Example #2
// It is impossible to divide the roll cake fairly.

import java.util.HashMap;
import java.util.HashSet;

public class Ex030_RollCakeTopping {

    public static int solution(int[] toppings) {

        HashSet<Integer> leftRollCake = new HashSet<>();
        // 왼쪽 롤케이크 토핑 종류 저장 # Store topping types on the left roll cake

        HashMap<Integer, Integer> rightRollCake = new HashMap<>();
        // 오른쪽 롤케이크 토핑 개수 저장 # Store topping counts on the right roll cake

        int answer = 0;
        // 공평하게 자르는 경우의 수 # Number of fair split cases

        // 오른쪽 롤케이크 전체 토핑 개수 저장 # Store total topping counts on the right roll cake
        for (int topping : toppings) {
            rightRollCake.put(topping, rightRollCake.getOrDefault(topping, 0) + 1);
        }

        // 토핑을 하나씩 왼쪽으로 이동 # Move toppings one by one to the left
        for (int topping : toppings) {

            // 오른쪽 토핑 개수 감소 # Decrease topping count on the right side
            rightRollCake.put(topping, rightRollCake.get(topping) - 1);

            // 토핑 개수가 0이면 제거 # Remove topping if count becomes zero
            if (rightRollCake.get(topping) == 0) {
                rightRollCake.remove(topping);
            }

            // 왼쪽에 토핑 종류 추가 # Add topping type to the left side
            leftRollCake.add(topping);

            // 양쪽 토핑 종류 수가 같으면 경우의 수 증가 # Increase count if both sides have the same number of topping types
            if (leftRollCake.size() == rightRollCake.size()) {
                answer++;
            }
        }

        return answer;
    }
}