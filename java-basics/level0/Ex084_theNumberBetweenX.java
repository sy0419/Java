// 문자열 myString이 주어집니다. myString을 문자 "x"를 기준으로 나눴을 때 나눠진 문자열 각각의 길이를 순서대로 저장한 배열을 return 하는 solution 함수를 완성해 주세요.

// 제한사항
// 1 ≤ myString의 길이 ≤ 100,000
// myString은 알파벳 소문자로 이루어진 문자열입니다.
import java.util.Arrays;

public class Ex084_theNumberBetweenX {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("oxooxoxxox")));
        System.out.println(Arrays.toString(solution("xabcxdefxghi")));
    }

    public static int[] solution(String myString) {
        // "x" 기준으로 분리, 끝의 빈 문자열도 모두 포함하도록 -1 limit 사용  # Split by "x" and keep trailing empty strings
        String[] newMyString = myString.split("x", -1);

        int[] lengths = new int[newMyString.length]; // 각 조각 길이 저장 배열  # Array to store lengths

        for (int i = 0; i < newMyString.length; i++) {
            lengths[i] = newMyString[i].length(); // 각 조각 길이 저장  # Store length of each substring
        }

        return lengths; // 결과 반환  # Return result
    }
}