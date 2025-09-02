import java.util.Arrays;

// my_string에서 'B'의 개수,..., my_string에서 'Z'의 개수, my_string에서 'a'의 개수, 
// my_string에서 'b'의 개수,..., my_string에서 'z'의 개수를 순서대로 담은 길이 52의 정수 배열을 return 하는 solution 함수를 작성해 주세요.
// Write a function that returns an integer array of length 52 containing counts of each uppercase and lowercase letter in order.

// 제한사항
// 1 ≤ my_string의 길이 ≤ 1,000
// 1 ≤ length of my_string ≤ 1,000

public class Ex050_letterCounting {
    public static void main(String[] args) {
        // "Programmers" 문자열의 알파벳 개수를 출력합니다.
        // Print counts of alphabets in the string "Programmers".
        System.out.println(Arrays.toString(solution("Programmers")));
    }

    public static int[] solution(String myString) {
        // 알파벳 대소문자 개수를 저장할 길이 52 배열 생성 (A-Z: 0~25, a-z: 26~51)
        // Create an integer array of length 52 to store counts of uppercase (0-25) and lowercase letters (26-51).
        int[] counts = new int[52];

        // myString의 각 문자에 대해 반복
        // Iterate over each character in myString
        for(int i = 0; i < myString.length(); i++) {
            // i번째 문자 추출
            // Extract the character at index i
            char letter = myString.charAt(i);

            // 대문자 범위일 경우, 해당 인덱스 값 증가
            // If uppercase letter, increase count at corresponding index
            if (letter >= 'A' && letter <= 'Z') {
                counts[letter - 'A']++;
            } 
            // 소문자 범위일 경우, 26부터 시작하는 인덱스 값 증가
            // If lowercase letter, increase count at index starting from 26
            else if (letter >= 'a' && letter <= 'z') {
                counts[26 + (letter - 'a')]++;
            }
        }
        // 결과 배열 반환
        // Return the resulting counts array
        return counts;
    }
}