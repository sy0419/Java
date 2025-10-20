// 숫자로 이루어진 문자열 t와 p가 주어질 때, t에서 p와 길이가 같은 부분문자열 중에서,  
// 이 부분문자열이 나타내는 수가 p가 나타내는 수보다 작거나 같은 것이 나오는 횟수를 return하는 함수 solution을 완성하세요.  
// 예를 들어, t="3141592"이고 p="271" 인 경우, t의 길이가 3인 부분 문자열은 314, 141, 415, 159, 592입니다.  
// 이 문자열이 나타내는 수 중 271보다 작거나 같은 수는 141, 159 2개 입니다.

// 제한사항  
// 1 ≤ p의 길이 ≤ 18  
// p의 길이 ≤ t의 길이 ≤ 10,000  
// t와 p는 숫자로만 이루어진 문자열이며, 0으로 시작하지 않습니다.

public class Ex032_substringCount {
    public static void main(String[] args) {
        System.out.println(solution("3141592", "271"));       // 2 출력 # Expect 2
        System.out.println(solution("500220839878", "7"));    // 8 출력 # Expect 8
        System.out.println(solution("10203", "15"));          // 3 출력 # Expect 3
    }

    public static int solution(String t, String p) {
        int count = 0;                            // 조건에 맞는 부분문자열 개수 카운트 # Count of substrings satisfying condition
        int len = p.length();                     // p 길이 저장 # Length of p
        long pLong = Long.parseLong(p);           // p를 long 타입 숫자로 변환 # Convert p to long number

        for (int i = 0; i <= t.length() - len; i++) {     // t 길이- p 길이 만큼 반복 # Iterate over possible substring start positions
            String part = t.substring(i, i + len);        // 길이 len 만큼 부분문자열 추출 # Extract substring of length len
            long partLong = Long.parseLong(part);          // 부분문자열을 숫자로 변환 # Convert substring to long
            if (pLong >= partLong) {                         // 부분문자열 숫자가 p 숫자보다 작거나 같으면 # Compare numbers
                count++;                                     // 조건 만족 개수 증가 # Increase count
            }
        }
        return count;                                       // 최종 카운트 반환 # Return total count
    }
}