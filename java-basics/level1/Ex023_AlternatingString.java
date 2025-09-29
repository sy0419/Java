// 길이가 n이고, "수박수박수박수...."와 같은 패턴을 유지하는 문자열을 리턴하는 함수, solution을 완성하세요. 
// 예를들어 n이 4이면 "수박수박"을 리턴하고 3이라면 "수박수"를 리턴하면 됩니다.

// 제한 조건
// n은 길이 10,000이하인 자연수입니다.

public class Ex023_AlternatingString {
    public static void main(String[] args) {
        System.out.println(solution(3));
        System.out.println(solution(4));
    }

    public static String solution(int n) {
        StringBuilder sb = new StringBuilder(); // 문자열 효율적 연결을 위한 StringBuilder 생성 # Create StringBuilder for efficient string concatenation
        for (int i = 0; i < n; i++) { // 0부터 n-1까지 반복 # Loop from 0 to n-1
            if (i % 2 == 1) { // 홀수 인덱스일 때 # If the index is odd
                sb.append("b"); // "b" 문자 추가 # Append character "b"
            } else {
                sb.append("a"); // 짝수 인덱스일 때 "a" 문자 추가 # Append character "a" when index is even
            }
        }
        return sb.toString(); // 완성된 문자열 반환 # Return the completed string
    }
}