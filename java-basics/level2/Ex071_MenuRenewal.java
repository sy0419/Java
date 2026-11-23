// 메뉴 리뉴얼
// 레스토랑을 운영하던 스카피는 기존 단품 메뉴를 조합하여 코스요리 메뉴를 새로 구성하려고 합니다.
// 이전에 각 손님들이 주문할 때 가장 많이 함께 주문한 단품 메뉴들을 코스요리 메뉴로 구성하려고 합니다.
// 코스요리는 최소 2가지 이상의 단품 메뉴로 구성해야 합니다.
// 또한, 최소 2명 이상의 손님으로부터 주문된 메뉴 조합만 코스요리 후보에 포함합니다.
// 각 손님들이 주문한 단품 메뉴들이 문자열 형식으로 담긴 배열 orders와
// 추가하고 싶은 코스요리를 구성하는 단품 메뉴의 개수가 담긴 배열 course가 주어집니다.
// 가장 많이 함께 주문된 메뉴 조합을 찾아 문자열 배열로 return 하도록 solution 함수를 완성해 주세요.

// 제한사항
// - orders 배열의 크기는 2 이상 20 이하입니다.
// - orders 배열의 각 원소는 크기가 2 이상 10 이하인 문자열입니다.
// - 각 문자열은 알파벳 대문자로만 이루어져 있습니다.
// - 각 문자열에는 같은 알파벳이 중복해서 들어있지 않습니다.
// - course 배열의 크기는 1 이상 10 이하입니다.
// - course 배열의 각 원소는 2 이상 10 이하의 자연수이며 오름차순으로 정렬되어 있습니다.
// - course 배열에는 같은 값이 중복해서 들어있지 않습니다.
// - 정답은 각 코스요리 메뉴의 구성을 사전순으로 오름차순 정렬하여 return 합니다.
// - 각 메뉴 조합에 저장된 문자열도 알파벳 오름차순으로 정렬되어야 합니다.
// - 가장 많이 함께 주문된 메뉴 구성이 여러 개라면 모두 배열에 담아 return 합니다.
// - orders와 course는 return 배열의 길이가 1 이상이 되도록 주어집니다.

// 입출력 예
//                       orders                            course                   result
//  ["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"]      [2, 3, 4]      ["AC", "ACDE", "BCFG", "CDE"]
// ["ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"]     [2, 3, 5]    ["ACD", "AD", "ADE", "CD", "XYZ"]
//             ["XYZ", "XWY", "WXA"]                     [2, 3, 4]                ["WX", "XY"]

// 입출력 예 설명
// 예제 1
// 문제의 예시와 같습니다.
// 예제 2
// AD와 CD는 각각 3번 주문되었고, ACD, ADE, XYZ는 각각 2번 주문되었습니다.
// 5개 메뉴를 주문한 손님은 1명이므로, 5개 메뉴로 구성된 코스요리는 추가하지 않습니다.
// 예제 3
// WX와 XY는 각각 2번 주문되었습니다.
// 세 명의 손님 모두 메뉴를 3개씩 주문했지만, 최소 2명 이상이 함께 주문한 3개 메뉴 조합은 없습니다.
// 또한, 메뉴를 4개 이상 주문한 손님이 없으므로 4개 메뉴 코스도 추가하지 않습니다.

// Menu Renewal
// Scopy runs a restaurant and wants to create new course menus by combining existing individual menu items.
// Scopy decides to create course menus using combinations of individual menu items
// that customers most frequently ordered together.
// Each course menu must contain at least two different menu items.
// Only combinations ordered by at least two customers can be considered as course menu candidates.
// You are given an array orders containing the individual menu items ordered by each customer,
// and an array course containing the number of menu items to include in each course.
// Complete the solution function to return the selected course menu combinations as a string array.

// Constraints
// - The size of orders is between 2 and 20.
// - Each string in orders has a length between 2 and 10.
// - Each string contains only uppercase English letters.
// - No string contains duplicate letters.
// - The size of course is between 1 and 10.
// - Each element in course is an integer between 2 and 10, sorted in ascending order.
// - course contains no duplicate values.
// - Return the selected combinations in lexicographical ascending order.
// - The letters in each returned combination must also be sorted alphabetically.
// - If multiple combinations have the highest order count, include all of them.
// - The input is guaranteed to produce at least one result.

// Example 1
//                       orders                            course                   result
//  ["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"]      [2, 3, 4]      ["AC", "ACDE", "BCFG", "CDE"]
// ["ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"]     [2, 3, 5]    ["ACD", "AD", "ADE", "CD", "XYZ"]
//             ["XYZ", "XWY", "WXA"]                     [2, 3, 4]                ["WX", "XY"]

// Example Explanation
// Example 1
// Same as the example above.
// Example 2
// AD and CD were each ordered 3 times.
// ACD, ADE, and XYZ were each ordered 2 times.
// Only one customer ordered 5 menu items, so no 5-item course is added.
// Example 3
// WX and XY were each ordered 2 times.
// All three customers ordered 3 menu items, but no combination of 3 menu items
// was ordered by at least two customers.
// No customer ordered 4 or more menu items, so no 4-item course is added.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ex071_MenuRenewal {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"},
                            new int[]{2, 3, 4})));
        System.out.println(Arrays.toString(solution(new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"},
                           new int[]{2, 3, 5})));
        System.out.println(Arrays.toString(solution(new String[]{"XYZ", "XWY", "WXA"}, new int[]{2, 3, 4})));
    }

    public static String[] solution(String[] orders, int[] course) {
        // 최종 메뉴 조합을 저장할 리스트 생성 # Create a list to store the final menu combinations
        List<String> result = new ArrayList<>();

        // 각 고객의 주문을 하나씩 확인 # Iterate through each customer's order
        for (int i = 0; i < orders.length; i++) {
            // 주문 문자열을 문자 배열로 변환 # Convert the order string into a character array
            char[] menu = orders[i].toCharArray();

            // 메뉴 문자를 알파벳순으로 정렬 # Sort the menu characters alphabetically
            Arrays.sort(menu);

            // 정렬된 문자 배열을 문자열로 변환 # Convert the sorted character array back into a string
            String sortedOrder = new String(menu);

            // 정렬된 주문으로 기존 주문을 갱신 # Update the original order with the sorted order
            orders[i] = sortedOrder;
        }

        // 원하는 메뉴 조합의 길이만큼 반복 # Iterate through each requested combination length
        for (int targetLength : course) {
            // 현재 조합 길이의 메뉴별 등장 횟수를 저장할 Map 생성 # Create a map to count combinations of the current length
            Map<String, Integer> countMap = new HashMap<>();

            // 모든 고객의 주문에서 조합 생성 # Generate combinations from every customer's order
            for (String order : orders) {
                // 재귀 메서드를 호출하여 조합 생성 및 등장 횟수 계산 # Generate combinations recursively and count their occurrences
                makeCombination(order, "", 0, targetLength, countMap);
            }

            // 가장 높은 등장 횟수를 저장할 변수 초기화 # Initialize the variable for the maximum occurrence count
            int maxCount = 0;

            // Map에 저장된 모든 등장 횟수 확인 # Check all occurrence counts stored in the map
            for (int count : countMap.values()) {
                // 현재 횟수가 최댓값보다 크면 갱신 # Update the maximum count if the current count is greater
                if (count > maxCount) {
                    maxCount = count;
                }
            }

            // Map에 저장된 모든 메뉴 조합 확인 # Check every menu combination stored in the map
            for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
                // 메뉴 조합 가져오기 # Get the menu combination
                String combination = entry.getKey();

                // 메뉴 조합의 등장 횟수 가져오기 # Get the occurrence count of the combination
                int count = entry.getValue();

                // 최댓값과 같고 2회 이상 등장한 조합만 선택 # Select combinations that have the maximum count and appear at least twice
                if (count == maxCount && count >= 2) {
                    // 조건을 만족하는 조합을 최종 결과에 추가 # Add the qualifying combination to the final result
                    result.add(combination);
                }
            }
        }

        // 최종 메뉴 조합을 알파벳순으로 정렬 # Sort the final menu combinations alphabetically
        Collections.sort(result);

        // 리스트를 문자열 배열로 변환하여 반환 # Convert the list into a string array and return it
        return result.toArray(new String[0]);
    }

    public static void makeCombination(String order, String combination, int start,
                                       int targetLength, Map<String, Integer> countMap) {
        // start 인덱스부터 주문에 포함된 문자를 하나씩 선택 # Select characters one by one starting from the given index
        for (int i = start; i < order.length(); i++) {
            // 기존 조합에 현재 선택한 문자를 추가 # Append the currently selected character to the existing combination
            String newCombination = combination + order.charAt(i);

            // 조합의 길이가 목표 길이에 도달했는지 확인 # Check whether the combination has reached the target length
            if (newCombination.length() == targetLength) {

                // 이미 존재하는 조합인지 확인 # Check whether the combination already exists
                if (countMap.containsKey(newCombination)) {
                    // 기존 등장 횟수에 1을 더해 갱신 # Increase the existing occurrence count by one
                    countMap.put(newCombination, countMap.get(newCombination) + 1);
                } else {
                    // 처음 등장한 조합을 1회로 저장 # Store a newly encountered combination with a count of one
                    countMap.put(newCombination, 1);
                }

            } else {
                // 아직 목표 길이에 도달하지 않았다면 다음 문자부터 재귀 호출 # Recursively continue from the next character if the target length has not been reached
                makeCombination(order, newCombination, i + 1, targetLength, countMap);
            }
        }
    }
}