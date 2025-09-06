// 임의의 문자열이 주어졌을 때 문자 "a", "b", "c"를 구분자로 사용해 문자열을 나누고자 합니다.
// 예를 들어 주어진 문자열이 "baconlettucetomato"라면 나눠진 문자열 목록은 ["onlettu", "etom", "to"] 가 됩니다.
// 문자열 myStr이 주어졌을 때 위 예시와 같이 "a", "b", "c"를 사용해 나눠진 문자열을 순서대로 저장한 배열을 return 하는 solution 함수를 완성해 주세요.
// 단, 두 구분자 사이에 다른 문자가 없을 경우에는 아무것도 저장하지 않으며, return할 배열이 빈 배열이라면 ["EMPTY"]를 return 합니다.

// 제한사항
// 1 ≤ myStr의 길이 ≤ 1,000,000
// myStr은 알파벳 소문자로 이루어진 문자열 입니다.
import java.util.ArrayList;
import java.util.Arrays;

public class Ex089_threeSeparators {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("baconlettucetomato"))); // → ["onlettu", "etom", "to"]
        System.out.println(Arrays.toString(solution("abcd")));               // → ["d"]
        System.out.println(Arrays.toString(solution("cabab")));             // → ["EMPTY"]
    }

    public static String[] solution(String myString) {
        ArrayList<String> strList = new ArrayList<>();

        // a, b, c 중 하나라도 나오면 구분자로 문자열 나누기  # Split string by any of 'a', 'b', or 'c'
        String[] parts = myString.split("[abc]");

        // 빈 문자열이 아닌 경우만 결과 리스트에 추가  # Add non-empty substrings to the result list
        for (String part : parts) {
            if (!part.isEmpty()) {
                strList.add(part);
            }
        }

        // 결과가 없으면 "EMPTY" 배열 반환  # Return ["EMPTY"] if result list is empty
        if (strList.isEmpty()) {
            return new String[] {"EMPTY"};
        }

        // 리스트를 배열로 변환해 반환  # Convert list to array and return
        return strList.toArray(new String[0]);
    }
}