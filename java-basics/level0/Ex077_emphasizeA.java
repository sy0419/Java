// 문자열 myString이 주어집니다. myString에서 알파벳 "a"가 등장하면 전부 "A"로 변환하고,
//  "A"가 아닌 모든 대문자 알파벳은 소문자 알파벳으로 변환하여 return 하는 solution 함수를 완성하세요.

// 제한사항
// 1 ≤ myString의 길이 ≤ 20
// myString은 알파벳으로 이루어진 문자열입니다.

public class Ex077_emphasizeA {
    public static void main(String[] args) {
        // 테스트 케이스 실행
        // # Run test cases
        System.out.println(solution("abstract algebra")); // 기대 결과: AbstrAct AlgebrA
        System.out.println(solution("PrOgRaMmErS")); // 기대 결과: progrAmmers
    }

    public static String solution(String myString) {
        // 결과 문자열을 만들기 위한 StringBuilder 선언
        // # Declare a StringBuilder to build the result string
        StringBuilder sb = new StringBuilder();

        // 문자열의 각 문자를 순회
        // # Loop through each character of the input string
        for (int i = 0; i < myString.length(); i++) {
            char ch = myString.charAt(i); // i번째 문자 가져오기
            // # Get the i-th character

            if (ch == 'a') {
                // 문자가 'a'이면 'A'로 변환
                // # If the character is 'a', convert it to 'A'
                sb.append('A');
            } else if (Character.isUpperCase(ch) && ch != 'A') {
                // 'A'가 아닌 대문자는 소문자로 변환
                // # If it's an uppercase letter and not 'A', convert to lowercase
                sb.append(Character.toLowerCase(ch));
            } else {
                // 그 외의 문자는 그대로 추가
                // # Otherwise, append the character as is
                sb.append(ch);
            }
        }

        return sb.toString(); // 최종 문자열 반환
                              // # Return the final string
    }
}