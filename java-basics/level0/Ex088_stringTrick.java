// 'm'과 "rn"이 모양이 비슷하게 생긴 점을 활용해 문자열에 장난을 하려고 합니다. 
// 문자열 rny_string이 주어질 때, rny_string의 모든 'm'을 "rn"으로 바꾼 문자열을 return 하는 solution 함수를 작성해 주세요.

// 제한사항
// 1 ≤ rny_string의 길이 ≤ 100
// rny_string은 영소문자로만 이루어져 있습니다.

public class Ex088_stringTrick {
    public static void main(String[] args) {
        // 테스트 케이스 출력  # Print test cases
        System.out.println(solution("masterpiece"));   // 기대 출력: "rnasterpiece"
        System.out.println(solution("programmers"));   // 기대 출력: "programrnerrns"
        System.out.println(solution("jerry"));         // 기대 출력: "jerry"
        System.out.println(solution("burn"));          // 기대 출력: "burn"
    }

    public static String solution(String rnyString) {
        // 'm'을 "rn"으로 치환  # Replace all occurrences of 'm' with "rn"
        return rnyString.replace("m", "rn");
    }
}