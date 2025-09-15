// 문자열 배열 strArr이 주어집니다. strArr의 원소들을 길이가 같은 문자열들끼리 그룹으로 묶었을 때 
// 가장 개수가 많은 그룹의 크기를 return 하는 solution 함수를 완성해 주세요.

// 제한사항
// 1 ≤ strArr의 길이 ≤ 100,000
// 1 ≤ strArr의 원소의 길이 ≤ 30
// strArr의 원소들은 알파벳 소문자로 이루어진 문자열입니다.

import java.util.HashMap;
import java.util.Map;

public class Ex096_maxiumStringInArray {
    public static void main(String[] args) {
        // 테스트 케이스 출력 # Print test case result
        System.out.println(solution(new String[] {"a", "bc", "d", "efg", "hi"})); // 출력: 2
    }

    public static int solution(String[] strArr) {
        // 문자열 길이를 key로, 해당 길이의 문자열 개수를 value로 저장할 맵 생성 # Create a map with string length as key and count as value
        Map<Integer, Integer> map = new HashMap<>();

        // 각 문자열의 길이를 기준으로 개수 세기 # Count strings grouped by their length
        for (String s : strArr) {
            int len = s.length();
            if (map.containsKey(len)) {
                map.put(len, map.get(len) + 1);
            } else {
                map.put(len, 1);
            }
        }

        // 가장 많은 개수를 가진 그룹의 크기 찾기 # Find the size of the largest group
        int max = 0;
        for (int count : map.values()) {
            if (count > max) {
                max = count;
            }
        }

        return max;
    }
}