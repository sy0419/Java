// 튜플
// 셀수있는 수량의 순서있는 열거 또는 어떤 순서를 따르는 요소들의 모음을 튜플(tuple)이라고 합니다. 
// n개의 요소를 가진 튜플을 n-튜플(n-tuple)이라고 하며, 다음과 같이 표현할 수 있습니다.
// (a1, a2, a3, ..., an) 
// 튜플은 다음과 같은 성질을 가지고 있습니다.
// 중복된 원소가 있을 수 있습니다. ex : (2, 3, 1, 2)
// 원소에 정해진 순서가 있으며, 원소의 순서가 다르면 서로 다른 튜플입니다. ex : (1, 2, 3) ≠ (1, 3, 2)
// 튜플의 원소 개수는 유한합니다.
// 원소의 개수가 n개이고, 중복되는 원소가 없는 튜플 (a1, a2, a3, ..., an)이 주어질 때(단, a1, a2, ..., an은 자연수), 
// 이는 다음과 같이 집합 기호 '{', '}'를 이용해 표현할 수 있습니다.
// {{a1}, {a1, a2}, {a1, a2, a3}, {a1, a2, a3, a4}, ... {a1, a2, a3, a4, ..., an}}

// 예를 들어 튜플이 (2, 1, 3, 4)인 경우 이는
// {{2}, {2, 1}, {2, 1, 3}, {2, 1, 3, 4}}
// 와 같이 표현할 수 있습니다. 이때, 집합은 원소의 순서가 바뀌어도 상관없으므로
// {{2}, {2, 1}, {2, 1, 3}, {2, 1, 3, 4}}
// {{2, 1, 3, 4}, {2}, {2, 1, 3}, {2, 1}}
// {{1, 2, 3}, {2, 1}, {1, 2, 4, 3}, {2}} 는 모두 같은 튜플 (2, 1, 3, 4)를 나타냅니다.

// 특정 튜플을 표현하는 집합이 담긴 문자열 s가 매개변수로 주어질 때, s가 표현하는 튜플을 배열에 담아 return 하도록 solution 함수를 완성해주세요.

// [제한사항]
// s의 길이는 5 이상 1,000,000 이하입니다.
// s는 숫자와 '{', '}', ',' 로만 이루어져 있습니다.
// 숫자가 0으로 시작하는 경우는 없습니다.
// s는 항상 중복되는 원소가 없는 튜플을 올바르게 표현하고 있습니다.
// s가 표현하는 튜플의 원소는 1 이상 100,000 이하인 자연수입니다.
// return 하는 배열의 길이가 1 이상 500 이하인 경우만 입력으로 주어집니다.

// [입출력 예]
//               s	                    result
// "{{2},{2,1},{2,1,3},{2,1,3,4}}"	 [2, 1, 3, 4]
// "{{1,2,3},{2,1},{1,2,4,3},{2}}"	 [2, 1, 3, 4]
//        "{{20,111},{111}}"	      [111, 20]
//            "{{123}}"            	    [123]
// "{{4,2,3},{3},{2,3,4,1},{2,3}}"	 [3, 2, 4, 1]

// 입출력 예에 대한 설명
// 입출력 예 #1
// 문제 예시와 같습니다.
// 입출력 예 #2
// 문제 예시와 같습니다.
// 입출력 예 #3
// (111, 20)을 집합 기호를 이용해 표현하면 {{111}, {111,20}}이 되며, 이는 {{20,111},{111}}과 같습니다.
// 입출력 예 #4
// (123)을 집합 기호를 이용해 표현하면 {{123}} 입니다.
// 입출력 예 #5
// (3, 2, 4, 1)을 집합 기호를 이용해 표현하면 {{3},{3,2},{3,2,4},{3,2,4,1}}이 되며, 이는 {{4,2,3},{3},{2,3,4,1},{2,3}}과 같습니다.


// Tuple

// A tuple is an ordered collection of countable elements
// or elements following a certain sequence.
// A tuple with n elements is called an n-tuple
// and can be expressed as follows.
// (a1, a2, a3, ..., an)
// Tuples have the following properties.
// Duplicate elements are allowed. ex : (2, 3, 1, 2)
// Elements have a fixed order,
// and tuples with different orders are considered different.
// ex : (1, 2, 3) ≠ (1, 3, 2)
// The number of elements in a tuple is finite.
// When a tuple (a1, a2, a3, ..., an) contains n distinct natural numbers,
// it can be represented using set notation '{', '}' as follows.
// {{a1}, {a1, a2}, {a1, a2, a3},
// {a1, a2, a3, a4}, ... {a1, a2, a3, a4, ..., an}}

// For example, if the tuple is (2, 1, 3, 4),
// it can be represented as:
// {{2}, {2, 1}, {2, 1, 3}, {2, 1, 3, 4}}
// Since the order of elements inside a set does not matter,
// the following all represent the same tuple (2, 1, 3, 4):
// {{2}, {2, 1}, {2, 1, 3}, {2, 1, 3, 4}}
// {{2, 1, 3, 4}, {2}, {2, 1, 3}, {2, 1}}
// {{1, 2, 3}, {2, 1}, {1, 2, 4, 3}, {2}}
// Given a string s containing sets representing a tuple,
// complete the solution function to return the tuple as an array.

// [Constraints]
// The length of s is between 5 and 1,000,000.
// s consists only of numbers, '{', '}', and ','.
// Numbers never start with 0.
// s always correctly represents a tuple without duplicate elements.
// Each element in the tuple is a natural number
// between 1 and 100,000.
// The returned array length is always between 1 and 500.

// [Input/Output Examples]
//               s	                    result
// "{{2},{2,1},{2,1,3},{2,1,3,4}}"	 [2, 1, 3, 4]
// "{{1,2,3},{2,1},{1,2,4,3},{2}}"	 [2, 1, 3, 4]
//        "{{20,111},{111}}"	      [111, 20]
//            "{{123}}"            	    [123]
// "{{4,2,3},{3},{2,3,4,1},{2,3}}"	 [3, 2, 4, 1]

// Explanation of Examples
// Example #1
// Same as the problem example.
// Example #2
// Same as the problem example.
// Example #3
// (111, 20) represented using set notation becomes
// {{111}, {111,20}},
// which is equivalent to {{20,111},{111}}.
// Example #4
// (123) represented using set notation becomes {{123}}.
// Example #5
// (3, 2, 4, 1) represented using set notation becomes
// {{3},{3,2},{3,2,4},{3,2,4,1}},
// which is equivalent to {{4,2,3},{3},{2,3,4,1},{2,3}}.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Ex033_Tuple {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("{{2},{2,1},{2,1,3},{2,1,3,4}}")));
        System.out.println(Arrays.toString(solution("{{1,2,3},{2,1},{1,2,4,3},{2}}")));
        System.out.println(Arrays.toString(solution("{{20,111},{111}}")));
        System.out.println(Arrays.toString(solution("{{123}}")));
        System.out.println(Arrays.toString(solution("{{4,2,3},{3},{2,3,4,1},{2,3}}")));
    }

    public static int[] solution(String s) {

        // 양쪽의 {{ 와 }} 제거 # Remove outer {{ and }}
        s = s.substring(2, s.length() - 2);

        // "},{" 기준으로 집합 분리 # Split sets using "},{"
        String[] arr = s.split("\\},\\{");

        // 문자열 길이 기준 오름차순 정렬 # Sort by string length ascending
        Arrays.sort(arr, (a, b) -> a.length() - b.length());

        // 중복 숫자 확인용 Set # Set for duplicate number checking
        HashSet<Integer> sameNumberCheck = new HashSet<>();

        // 최종 결과 저장 리스트 # List to store final result
        ArrayList<Integer> resultList = new ArrayList<>();

        // 집합 하나씩 순회 # Iterate through each set
        for (String a : arr) {

            // "," 기준 숫자 분리 # Split numbers using comma
            String[] numbers = a.split(",");

            // 숫자 하나씩 확인 # Check each number
            for (String num : numbers) {

                // 문자열 숫자를 int로 변환 # Convert string to integer
                int number = Integer.parseInt(num);

                // 처음 등장한 숫자인 경우 # If number appears for the first time
                if (!sameNumberCheck.contains(number)) {

                    // Set에 추가하여 중복 방지 # Add to Set to prevent duplicates
                    sameNumberCheck.add(number);

                    // 결과 리스트에 추가 # Add to result list
                    resultList.add(number);
                }
            }
        }

        // List<Integer> → int[] 변환 # Convert List<Integer> to int[]
        int[] result = new int[resultList.size()];

        // 리스트 값을 배열에 복사 # Copy list values into array
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }
}