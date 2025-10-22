// 정수 배열 numbers가 주어집니다. numbers에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더해서 만들 수 있는 
// 모든 수를 배열에 오름차순으로 담아 return 하도록 solution 함수를 완성해주세요.

// 제한사항
// numbers의 길이는 2 이상 100 이하입니다.
// numbers의 모든 수는 0 이상 100 이하입니다.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ex040_SumOfPairs {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[] {2,1,3,4,1}))); // [2, 3, 4, 5, 6, 7]
        System.out.println(Arrays.toString(solution(new int[] {5,0,2,7})));   // [2, 5, 7, 9, 12]
    }

    public static int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();            // 중복 제거를 위한 Set 생성 # Create a Set to avoid duplicates

        for (int i = 0; i < numbers.length; i++) {     // 첫 번째 수 선택 # Select the first number
            for (int j = i + 1; j < numbers.length; j++) { // 두 번째 수 선택, i보다 큰 인덱스만 # Select second number with index greater than i
                set.add(numbers[i] + numbers[j]);      // 두 수의 합을 Set에 추가 # Add the sum of two numbers to the Set
            }
        }

        List<Integer> list = new ArrayList<>(set);     // Set을 List로 변환 # Convert Set to List
        Collections.sort(list);                         // 오름차순 정렬 # Sort the list in ascending order

        int[] result = new int[list.size()];           // 결과를 담을 배열 생성 # Create array to store results
        for (int i = 0; i < list.size(); i++) {        // List의 값을 배열로 복사 # Copy List values to array
            result[i] = list.get(i);
        }

        return result;                                  // 결과 배열 반환 # Return the result array
    }
}