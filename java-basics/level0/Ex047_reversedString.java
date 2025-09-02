public class Ex047_reversedString {
    public static void main(String[] args) {
        // 테스트 케이스 실행 / Run test cases
        System.out.println(solution("Progra21Sremm3", 6, 12));
        System.out.println(solution("Stanley1yelnatS", 4, 10));
    }

    public static String solution(String myString, int s, int e) {
        // s 이전 부분 문자열 추출 / Extract substring before index s
        String a = myString.substring(0, s);

        // s부터 e까지 부분 문자열 추출 / Extract substring from s to e
        String b = myString.substring(s, e + 1);

        // e 이후 부분 문자열 추출 / Extract substring after index e
        String c = myString.substring(e + 1);

        // StringBuilder를 사용해 부분 문자열 b를 뒤집기 / Reverse substring b using StringBuilder
        StringBuilder sb = new StringBuilder();
        String reverseB = sb.append(b).reverse().toString();

        // 세 부분을 합쳐 최종 문자열 반환 / Concatenate and return final result
        return a + reverseB + c;
    }
}