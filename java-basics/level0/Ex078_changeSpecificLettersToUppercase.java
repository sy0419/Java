// 영소문자로 이루어진 문자열 my_string과 영소문자 1글자로 이루어진 문자열 alp가 매개변수로 주어질 때, 
// my_string에서 alp에 해당하는 모든 글자를 대문자로 바꾼 문자열을 return 하는 solution 함수를 작성해 주세요.

// 제한사항
// 1 ≤ my_string의 길이 ≤ 1,000

public class Ex078_changeSpecificLettersToUppercase {
    public static void main(String[] args) {
        System.out.println(solution("programmers", "p")); // 기대 결과: Programmers
        System.out.println(solution("lowercase", "x"));   // 기대 결과: lowercase
    }

    public static String solution(String myString, String alp) {
        // alp 문자를 대문자로 변환하여 대체
        // # Replace all occurrences of 'alp' in 'myString' with its uppercase version
        return myString.replaceAll(alp, alp.toUpperCase());
    }
}