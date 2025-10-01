// 문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수, solution을 완성해주세요.
// s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다.

// 제한 사항
// str은 길이 1 이상인 문자열입니다.

import java.util.Arrays;

public class Ex025_SortStringDesc {
    public static void main(String[] args) {
        System.out.println(solution("Zbcdefg")); // gfedcbZ
    }

    public static String solution(String s) {
        char[] arrStr = s.toCharArray(); // 문자열을 문자 배열로 변환 # Convert string to char array
        Arrays.sort(arrStr); // 문자 배열 오름차순 정렬 # Sort char array in ascending order

        StringBuilder sb = new StringBuilder(); // 문자열을 효율적으로 조합할 도구 # StringBuilder to build result

        for (int i = arrStr.length - 1; i >= 0; i--) { // 배열을 역순으로 순회 # Traverse the array in reverse
            sb.append(arrStr[i]); // 큰 문자부터 추가 # Append characters from largest to smallest
        }

        return sb.toString(); // 최종 문자열 반환 # Return the final sorted string
    }
}