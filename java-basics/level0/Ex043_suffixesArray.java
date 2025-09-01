
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// 어떤 문자열에 대해서 접미사는 특정 인덱스부터 시작하는 문자열을 의미합니다. 
// 예를 들어, "banana"의 모든 접미사는 "banana", "anana", "nana", "ana", "na", "a"입니다.
// 문자열 my_string이 매개변수로 주어질 때, my_string의 모든 접미사를 사전순으로 정렬한 문자열 배열을 return 하는 solution 함수를 작성해 주세요.

// 제한사항
// my_string은 알파벳 소문자로만 이루어져 있습니다.
// 1 ≤ my_string의 길이 ≤ 100

public class Ex043_suffixesArray {
    public static void main(String[] args) {
        // Print the sorted array of suffixes for the input string "banana"
        // "banana"에 대한 정렬된 접미사 배열 출력
        System.out.println(Arrays.toString(solution("banana")));
    }

    public static String[] solution(String myString) {
        // Create a list to store all suffixes
        // 모든 접미사를 저장할 리스트 생성
        ArrayList<String> list = new ArrayList<>();
        
        // Extract suffixes starting from each index and add to the list
        // 각 인덱스부터 시작하는 접미사를 추출하여 리스트에 추가
        for(int i = 0; i < myString.length(); i++) {
            list.add(myString.substring(i));
        }
        
        // Sort the suffixes lexicographically
        // 접미사를 사전 순으로 정렬
        Collections.sort(list); 
        
        // Convert the list back to a String array and return
        // 리스트를 다시 문자열 배열로 변환하여 반환
        return list.toArray(new String[0]);
    }
}