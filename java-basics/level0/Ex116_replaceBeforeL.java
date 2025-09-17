// 알파벳 소문자로 이루어진 문자열 myString이 주어집니다. 
// 알파벳 순서에서 "l"보다 앞서는 모든 문자를 "l"로 바꾼 문자열을 return 하는 solution 함수를 완성해 주세요.

// 제한사항
// 1 ≤ myString ≤ 100,000
// myString은 알파벳 소문자로 이루어진 문자열입니다.

public class Ex116_replaceBeforeL {
    public static void main(String[] args) {
        // 테스트 케이스 출력 # Print test case results
        System.out.println(solution1("abcdevwxyz")); // 예상 출력: lllllevwxyz
        System.out.println(solution1("jjnnllkkmm")); // 예상 출력: llnnllllmm
        System.out.println(solution2("abcdevwxyz")); // 예상 출력: lllllevwxyz
        System.out.println(solution2("jjnnllkkmm")); // 예상 출력: llnnllllmm
    }

    // 방법 1: 반복문과 StringBuilder 사용 # Method 1: Use loop and StringBuilder
    public static String solution1(String myString) {
        // 결과 문자열 생성을 위한 StringBuilder # Create a StringBuilder to build the result
        StringBuilder sb = new StringBuilder();

        // 문자열을 한 글자씩 확인 # Iterate through each character
        for (int i = 0; i < myString.length(); i++) {
            char ch = myString.charAt(i); // 현재 문자 가져오기 # Get current character

            if (ch < 'l') {
                // 'l'보다 앞선 문자는 'l'로 변환 # Replace characters before 'l' with 'l'
                sb.append('l');
            } else {
                // 나머지는 그대로 추가 # Otherwise, keep the character
                sb.append(ch);
            }
        }

        // 최종 문자열 반환 # Return the final result string
        return sb.toString();
    }

    // 방법 2: 정규식을 사용한 치환 # Method 2: Use regular expression for replacement
    public static String solution2(String myString) {
        // [^l-z]는 'l'부터 'z'를 제외한 나머지 모든 문자 (즉, 'a'~'k')를 의미
        // 이 문자들을 'l'로 치환
        // # Replace all characters not in 'l' to 'z' range with 'l'
        return myString.replaceAll("[^l-z]", "l");
    }
}