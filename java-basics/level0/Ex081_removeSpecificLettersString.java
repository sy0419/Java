// 문자열 배열 strArr가 주어집니다.
// 배열 내의 문자열 중 "ad"라는 부분 문자열을 포함하고 있는 모든 문자열을 제거하고 남은 문자열을 순서를 유지하여 배열로 return 하는 solution 함수를 완성해 주세요.

// 제한사항
// 1 ≤ strArr의 길이 ≤ 1,000
// 1 ≤ strArr의 원소의 길이 ≤ 20
// strArr의 원소는 알파벳 소문자로 이루어진 문자열입니다.

import java.util.ArrayList;
import java.util.Arrays;

public class Ex081_removeSpecificLettersString {
    public static void main(String[] args) {
        // 테스트 케이스 결과 출력  # Print the result of test cases
        System.out.println(Arrays.toString(solution(new String[] {"and","notad","abcd"})));
        System.out.println(Arrays.toString(solution(new String[] {"there","are","no","a","ds"})));
    }

    public static String[] solution(String[] strArr) {
        ArrayList<String> strList = new ArrayList<>(); // 조건을 만족하는 문자열을 저장할 리스트 생성  # Create a list to store strings that meet the condition

        for (String strArr1 : strArr) {
            if (!strArr1.contains("ad")) { // 문자열에 "ad"가 포함되어 있지 않으면  # If the string does not contain "ad"
                strList.add(strArr1); // 리스트에 해당 문자열 추가  # Add the string to the list
            }
        }

        String[] result = new String[strList.size()]; // 최종 결과를 담을 배열 생성  # Create an array to store the final result
        for (int i = 0; i < strList.size(); i++) {
            result[i] = strList.get(i); // 리스트의 요소를 배열로 복사  # Copy elements from the list to the array
        }

        return result; // 결과 배열 반환  # Return the result array
    }
}
