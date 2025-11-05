// 두 문자열 s와 skip, 그리고 자연수 index가 주어질 때, 다음 규칙에 따라 문자열을 만들려 합니다. 암호의 규칙은 다음과 같습니다.

// 문자열 s의 각 알파벳을 index만큼 뒤의 알파벳으로 바꿔줍니다.
// index만큼의 뒤의 알파벳이 z를 넘어갈 경우 다시 a로 돌아갑니다.
// skip에 있는 알파벳은 제외하고 건너뜁니다.
// 예를 들어 s = "aukks", skip = "wbqd", index = 5일 때, a에서 5만큼 뒤에 있는 알파벳은 f지만 [b, c, d, e, f]에서 'b'와 'd'는 skip에 포함되므로 세지 않습니다. 
// 따라서 'b', 'd'를 제외하고 'a'에서 5만큼 뒤에 있는 알파벳은 [c, e, f, g, h] 순서에 의해 'h'가 됩니다. 
// 나머지 "ukks" 또한 위 규칙대로 바꾸면 "appy"가 되며 결과는 "happy"가 됩니다.

// 두 문자열 s와 skip, 그리고 자연수 index가 매개변수로 주어질 때 위 규칙대로 s를 변환한 결과를 return하도록 solution 함수를 완성해주세요.

// 제한사항
// 5 ≤ s의 길이 ≤ 50
// 1 ≤ skip의 길이 ≤ 10
// s와 skip은 알파벳 소문자로만 이루어져 있습니다.
// skip에 포함되는 알파벳은 s에 포함되지 않습니다.
// 1 ≤ index ≤ 20

import java.util.ArrayList;
import java.util.List;

public class Ex061_secretCipher {
    public static void main(String[] args) {
        System.out.println(solution("aukks", "wbqd", 5)); // happy
    }

    public static String solution(String s, String skip, int index) {
        List<Character> list = new ArrayList<>(); // 알파벳을 저장할 리스트 # List of available alphabets
        StringBuilder sb = new StringBuilder();   // 결과 문자열을 만들 StringBuilder # StringBuilder for result

        // 알파벳 리스트 생성 ('a' ~ 'z')
        for (char c = 'a'; c <= 'z'; c++) { 
            list.add(c); // 알파벳을 리스트에 추가 # Add alphabet to list
        }

        // skip에 포함된 문자 제거
        for (char skipLetter : skip.toCharArray()) { 
            list.remove(Character.valueOf(skipLetter)); // skip 문자를 리스트에서 제거 # Remove skip letters
        }
        
        // s의 각 문자를 변환
        for (char letter : s.toCharArray()) { 
            int currentIndex = list.indexOf(letter);              // 현재 문자의 위치 # Find current letter's index
            int newIndex = (currentIndex + index) % list.size();  // index만큼 이동 (z를 넘으면 다시 처음으로) # Move index forward circularly
            sb.append(list.get(newIndex));                        // 새 문자 추가 # Append new shifted letter
        }

        return sb.toString(); // 변환된 문자열 반환 # Return encoded result
    }
}