// 문자열 myString과 pat이 주어집니다. myString에서 pat이 등장하는 횟수를 return 하는 solution 함수를 완성해 주세요.

// 제한사항
// 1 ≤ myString ≤ 1000
// 1 ≤ pat ≤ 10

public class Ex080_countString {
    public static void main(String[] args) {
        System.out.println("1.");
        System.out.println(solution1("banana", "ana")); // 기대 결과: 2
        System.out.println(solution1("aaaa", "aa"));    // 기대 결과: 3

        System.out.println("2.");
        System.out.println(solution2("banana", "ana")); // 기대 결과: 2
        System.out.println(solution2("aaaa", "aa"));    // 기대 결과: 3
    }

    public static int solution1(String myString, String pat) {
        int count = 0;  // pat이 등장한 횟수를 저장할 변수
        // # Variable to count the number of occurrences of 'pat'

        // i는 myString의 처음부터 끝까지 순회하면서 pat 길이만큼 자르기 위해
        // # Loop from start to the last valid index for checking 'pat'
        for (int i = 0; i <= myString.length() - pat.length(); i++) {
            // i번째부터 pat 길이만큼 잘라서 pat과 같은지 확인
            // # Extract substring of length 'pat' and compare
            if (myString.substring(i, i + pat.length()).equals(pat)) {
                count++; // 일치하면 카운트 증가
                // # Increase count if match is found
            }
        }

        return count; // 총 등장 횟수 반환
        // # Return total occurrences
    }

    public static int solution2(String myString, String pat) {
        int count = 0;  // 등장 횟수 저장
        // # Variable to count occurrences

        // i부터 시작하는 부분 문자열이 pat으로 시작하는지 확인
        // # Check if substring starting from index i starts with 'pat'
        for (int i = 0; i < myString.length(); i++) {
            if (myString.substring(i).startsWith(pat)) {
                count++; // 시작하면 카운트 증가
                // # If it starts with 'pat', increment count
            }
        }

        return count; // 최종 결과 반환
        // # Return final count
    }
}