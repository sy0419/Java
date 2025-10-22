// 네오와 프로도가 숫자놀이를 하고 있습니다. 네오가 프로도에게 숫자를 건넬 때 일부 자릿수를 영단어로 바꾼 카드를 건네주면 
// 프로도는 원래 숫자를 찾는 게임입니다.
// 다음은 숫자의 일부 자릿수를 영단어로 바꾸는 예시입니다:

// 1478 → "one4seveneight"
// 234567 → "23four5six7"
// 10203 → "1zerotwozero3"

// 제한사항
// 1 ≤ s의 길이 ≤ 50
// s가 "zero" 또는 "0"으로 시작하는 경우는 주어지지 않습니다.
// return 값이 1 이상 2,000,000,000 이하의 정수가 되는 올바른 입력만 s로 주어집니다.

import java.util.HashMap;
import java.util.Map;

public class Ex042_ReplaceWordsWithDigits {
    public static void main(String[] args) {
        System.out.println(solution("one4seveneight")); // 1478
        System.out.println(solution("23four5six7"));    // 234567
        System.out.println(solution("2three45sixseven")); // 234567
        System.out.println(solution("123")); // 123
    }

    public static int solution(String s) {
        Map<String, String> number = new HashMap<>(); // 숫자 단어 매핑을 위한 HashMap 생성 # Create a map to store word-to-digit mappings

        number.put("zero", "0");  // zero -> 0
        number.put("one", "1");   // one -> 1
        number.put("two", "2");   // two -> 2
        number.put("three", "3"); // three -> 3
        number.put("four", "4");  // four -> 4
        number.put("five", "5");  // five -> 5
        number.put("six", "6");   // six -> 6
        number.put("seven", "7"); // seven -> 7
        number.put("eight", "8"); // eight -> 8
        number.put("nine", "9");  // nine -> 9

        for (String key : number.keySet()) {
            s = s.replace(key, number.get(key)); // 각 영단어를 대응되는 숫자로 치환 # Replace each word with its corresponding digit
        }

        return Integer.parseInt(s); // 최종적으로 숫자로 변환하여 반환 # Convert the final string to integer and return
    }
}