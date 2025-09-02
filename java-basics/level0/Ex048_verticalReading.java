public class Ex048_verticalReading {
    public static void main(String[] args) {
        System.out.println(solution("ihrhbakrfpndopljhygc", 4, 2));
        System.out.println(solution("programmers", 1, 1));
    }

    public static String solution(String myString, int m, int c) {
        StringBuilder sb = new StringBuilder();  // 결과를 담을 문자열 생성 / StringBuilder to build the result string

        // 전체 문자열을 m글자씩 나눴을 때 생기는 줄(row)의 수 만큼 반복
        // Iterate over the number of rows created by dividing the string into m-length chunks
        for (int i = 0; i < myString.length() / m; i++) {
            // i번째 줄에서 c번째 열에 해당하는 문자 선택 (0-based index 이므로 c-1)
            // Pick the character in the c-th column of the i-th row
            char ch = myString.charAt(i * m + (c - 1));
            sb.append(ch);  // 선택한 문자를 결과 문자열에 추가 / Append the character to the result
        }

        return sb.toString();  // 결과 문자열 반환 / Return the result string
    }
}