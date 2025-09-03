// 문자열 리스트 str_list에는 "u", "d", "l", "r" 네 개의 문자열이 여러 개 저장되어 있습니다. 
// str_list에서 "l"과 "r" 중 먼저 나오는 문자열이 "l"이라면 해당 문자열을 기준으로 왼쪽에 있는 문자열들을 순서대로 담은 리스트를, 
// 먼저 나오는 문자열이 "r"이라면 해당 문자열을 기준으로 오른쪽에 있는 문자열들을 순서대로 담은 리스트를 return하도록 solution 함수를 완성해주세요. "l"이나 "r"이 없다면 빈 리스트를 return합니다.

// 제한사항
// 1 ≤ str_list의 길이 ≤ 20
// str_list는 "u", "d", "l", "r" 네 개의 문자열로 이루어져 있습니다.

import java.util.ArrayList;
import java.util.Arrays;

public class Ex061_leftRight {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[] {"u", "u", "l", "r"})));  // [u, u]
        System.out.println(Arrays.toString(solution(new String[] {"l"})));                 // []
    }

    public static String[] solution(String[] strList) {
        ArrayList<String> list = new ArrayList<>(); // 결과를 담을 ArrayList 생성  
        // # Create an ArrayList to store the result

        int lIndex = -1; // "l"의 첫 등장 위치 저장  
        // # Store the first occurrence index of "l"
        int rIndex = -1; // "r"의 첫 등장 위치 저장  
        // # Store the first occurrence index of "r"

        // "l"과 "r"의 첫 위치 찾기  
        // # Find the first positions of "l" and "r"
        for (int i = 0; i < strList.length; i++) {
            if (strList[i].equals("l") && lIndex == -1) { 
                lIndex = i; // 첫 "l" 위치 저장  
                // # Save the first "l" index
            }
            if (strList[i].equals("r") && rIndex == -1) {
                rIndex = i; // 첫 "r" 위치 저장  
                // # Save the first "r" index
            }
        }

        if (lIndex == -1 && rIndex == -1) {
            return new String[0]; // "l"과 "r" 모두 없으면 빈 배열 반환  
            // # Return empty array if neither "l" nor "r" found
        }

        if (lIndex != -1 && (rIndex == -1 || lIndex < rIndex)) {
            // "l"이 먼저 나오면 "l" 기준 왼쪽 원소들을 리스트에 추가  
            // # If "l" comes first, add all elements to the left of "l"
            for (int i = 0; i < lIndex; i++) {
                list.add(strList[i]);
            }
        } else {
            // "r"이 먼저 나오면 "r" 기준 오른쪽 원소들을 리스트에 추가  
            // # If "r" comes first, add all elements to the right of "r"
            for (int i = rIndex + 1; i < strList.length; i++) {
                list.add(strList[i]);
            }
        }

        return list.toArray(new String[0]); // ArrayList를 배열로 변환 후 반환  
        // # Convert ArrayList to array and return
    }
}