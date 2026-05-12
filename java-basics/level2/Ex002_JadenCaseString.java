// JadenCase 문자열 만들기

// JadenCase란 모든 단어의 첫 문자가 대문자이고, 그 외의 알파벳은 소문자인 문자열입니다. 
// 단, 첫 문자가 알파벳이 아닐 때에는 이어지는 알파벳은 소문자로 쓰면 됩니다. (첫 번째 입출력 예 참고)
// 문자열 s가 주어졌을 때, s를 JadenCase로 바꾼 문자열을 리턴하는 함수, solution을 완성해주세요.

// 제한 조건
// s는 길이 1 이상 200 이하인 문자열입니다.
// s는 알파벳과 숫자, 공백문자(" ")로 이루어져 있습니다.
// 숫자는 단어의 첫 문자로만 나옵니다.
// 숫자로만 이루어진 단어는 없습니다.
// 공백문자가 연속해서 나올 수 있습니다.

// 입출력 예
//             s	                    return
// "3people unFollowed me"	   "3people Unfollowed Me"
//   "for the last week"	    "For The Last Week"

public class Ex002_JadenCaseString {
    public static void main(String[] args) {
        System.out.println(solution("3people unFollowed me"));
        System.out.println(solution("for the last week"));
    }

    public static String solution(String s) {

        // 문자열을 문자 배열로 변환 / Convert string to char array
        char[] arr = s.toCharArray();

        // 결과 저장용 문자열 빌더 / StringBuilder for result
        StringBuilder sb = new StringBuilder();

        // 현재 문자가 단어 시작인지 여부 / Indicates whether current char is word start
        boolean isStart = true;

        // 문자 하나씩 순회 / Traverse each character
        for (char c : arr) {

            // 공백이면 그대로 추가 후 다음 문자를 단어 시작으로 설정
            // If space, append as-is and mark next char as word start
            if (c == ' ') {
                sb.append(c);
                isStart = true;
            }

            // 단어 시작 문자면 대문자로 변환
            // Convert first character of word to uppercase
            else if (isStart) {
                sb.append(Character.toUpperCase(c));
                isStart = false;
            }

            // 단어 내부 문자는 소문자로 변환
            // Convert remaining characters to lowercase
            else {
                sb.append(Character.toLowerCase(c));
            }
        }

        // 최종 문자열 반환 / Return final converted string
        return sb.toString();
    }
}