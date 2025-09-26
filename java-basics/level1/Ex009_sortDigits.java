// 함수 solution은 정수 n을 매개변수로 입력받습니다. n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요. 예를 들어 n이 118372면 873211을 리턴하면 됩니다.

// 제한 조건
// n은 1이상 8000000000 이하인 자연수입니다.

import java.util.Arrays;

public class Ex009_sortDigits {
    public static void main(String[] args) {
        System.out.println(solution(873211)); 
    }

    public static long solution(long n) {
        // 1. n을 문자열로 변환 # Convert long n to String # Convert n to String
        String strN = Long.toString(n);

        // 2. 문자열을 문자 배열로 변환 # Convert the String to a character array # Convert String to char array
        char[] arr = strN.toCharArray();

        // 3. 문자 배열을 오름차순으로 정렬 # Sort array in ascending order # Sort characters in ascending order
        Arrays.sort(arr); 
        
        // 4. 정렬된 배열을 내림차순으로 뒤집기 # Reverse the array to make it descending order # Reverse the string to make it descending order
        StringBuilder sb = new StringBuilder(new String(arr)); // Convert sorted array back to String # Convert the sorted char array to String
        sb.reverse(); // 내림차순으로 뒤집기 # Reverse the String to make it descending order

        // 5. 내림차순으로 정렬된 문자열을 다시 long 타입으로 변환하여 반환 # Convert the String back to long and return it # Convert the String to long and return
        return Long.parseLong(sb.toString()); // 문자열을 long 타입으로 변환 후 반환 # Convert the String to long and return
    }
}