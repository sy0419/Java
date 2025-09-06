// 문자열 myString이 주어집니다. "x"를 기준으로 해당 문자열을 잘라내 배열을 만든 후 사전순으로 정렬한 배열을 return 하는 solution 함수를 완성해 주세요.
// 단, 빈 문자열은 반환할 배열에 넣지 않습니다.

// 제한사항
// 1 ≤ myString ≤ 100,000
// myString은 알파벳 소문자로 이루어진 문자열입니다.
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ex085_splitStringThenSort {
    public static void main(String[] args) {
        // 결과 배열 출력  # Print the resulting array
        System.out.println(Arrays.toString(solution("axbxcxdx")));
        System.out.println(Arrays.toString(solution("dxccxbbbxaaaa")));
    }

    @SuppressWarnings("CollectionsToArray")
    public static String[] solution(String myString) {
        String[] splitParts = myString.split("x"); // "x"를 기준으로 분리  # Split by "x"

        List<String> filtered = new ArrayList<>(); // 빈 문자열 제거 후 담을 리스트  # List to store non-empty strings
        for (String part : splitParts) {
            if (!part.isEmpty()) {
                filtered.add(part); // 빈 문자열이 아니면 추가  # Add non-empty part
            }
        }

        Collections.sort(filtered); // 사전순 정렬  # Sort the list alphabetically

        return filtered.toArray(new String[0]); // 리스트를 배열로 변환하여 반환  # Convert list to array and return
    }
}