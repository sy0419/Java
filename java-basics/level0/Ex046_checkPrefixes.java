// 어떤 문자열에 대해서 접두사는 특정 인덱스까지의 문자열을 의미합니다. 
// 예를 들어, "banana"의 모든 접두사는 "b", "ba", "ban", "bana", "banan", "banana"입니다.
// 문자열 my_string과 is_prefix가 주어질 때, is_prefix가 my_string의 접두사라면 1을, 아니면 0을 return 하는 solution 함수를 작성해 주세요.

// 제한사항
// 1 ≤ my_string의 길이 ≤ 100
// 1 ≤ is_prefix의 길이 ≤ 100
// my_string과 is_prefix는 영소문자로만 이루어져 있습니다.

public class Ex046_checkPrefixes {
    public static void main(String[] args) {
        System.out.println(solution("banana", "ban"));  // 출력: 1 (isPrefix가 접두사임)
        System.out.println(solution("banana", "nan"));  // 출력: 0 (isPrefix가 접두사가 아님)
        System.out.println(solution("banana", "abcd")); // 출력: 0 (isPrefix가 접두사가 아님)
    }

    public static int solution(String myString, String isPrefix) {
        // myString이 isPrefix로 시작하면 1을 반환
        // Return 1 if myString starts with isPrefix
        if (myString.startsWith(isPrefix)) {
            return 1;
        }
        // 그렇지 않으면 0을 반환
        // Otherwise, return 0
        return 0;
    } 
}