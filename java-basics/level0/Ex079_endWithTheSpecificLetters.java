// 문자열 myString과 pat가 주어집니다. myString의 부분 문자열중 pat로 끝나는 가장 긴 부분 문자열을 찾아서 return 하는 solution 함수를 완성해 주세요.

// 제한사항
// 5 ≤ myString ≤ 20
// 1 ≤ pat ≤ 5
// pat은 반드시 myString의 부분 문자열로 주어집니다.
// myString과 pat에 등장하는 알파벳은 대문자와 소문자를 구분합니다.

public class Ex079_endWithTheSpecificLetters {
    public static void main(String[] args) {
        System.out.println(solution("AbCdEFG", "dE")); // 기대 결과: AbCdE
        System.out.println(solution("AAAAaaaa", "a")); // 기대 결과: AAAAaaaa
    }

    public static String solution(String myString, String pat) {
        int lastIndex = myString.lastIndexOf(pat); // pat이 마지막으로 등장하는 인덱스 찾기
        // # Find the last index where 'pat' appears in 'myString'

        return myString.substring(0, lastIndex + pat.length()); // 해당 위치까지 자르기
        // # Return the substring from index 0 to the end of 'pat' (inclusive)
    }
}