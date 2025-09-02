
import java.util.HashSet;

// 문자열 my_string과 정수 배열 indices가 주어질 때, my_string에서 indices의 원소에 해당하는 인덱스의 글자를 지우고 
// 이어 붙인 문자열을 return 하는 solution 함수를 작성해 주세요.

// 제한사항
// 1 ≤ indices의 길이 < my_string의 길이 ≤ 100
// my_string은 영소문자로만 이루어져 있습니다
// 0 ≤ indices의 원소 < my_string의 길이
// indices의 원소는 모두 서로 다릅니다.

public class Ex052_removeStrings {
    public static void main(String[] args) {
        System.out.println(solution("apporoograpemmemprs", new int[] {1, 16, 6, 15, 0, 10, 11, 3}));
    }

    public static String solution(String myString, int[] indices) {
        // 삭제할 인덱스를 저장할 HashSet 생성
        // Create a HashSet to store indices to be removed
        HashSet<Integer> set = new HashSet<>();
        for (int idx : indices) {
            set.add(idx);
        }

        // 결과 문자열을 만들 StringBuilder 생성
        // Use StringBuilder to build the result string
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < myString.length(); i++) {
            // 해당 인덱스가 삭제 대상이 아니면 문자열에 추가
            // If index is not in the set, append the character
            if (!set.contains(i)) {
                sb.append(myString.charAt(i));
            }
        }

        // 결과 문자열 반환
        // Return the final string
        return sb.toString();
    }
}