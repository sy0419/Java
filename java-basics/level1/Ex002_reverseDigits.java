// 자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요. 예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.

// 제한 조건
// n은 10,000,000,000이하인 자연수입니다.

import java.util.ArrayList;
import java.util.Arrays;

public class Ex002_reverseDigits {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(12345))); // 테스트 결과 출력 # Print test result
    }

    public static int[] solution(long n) {
        ArrayList<Integer> arr = new ArrayList<>(); // 자릿수를 저장할 리스트 생성# Create a list to store digits

        String strNum = Long.toString(n); // long 타입 숫자를 문자열로 변환 # Convert long number to string

        for (int i = strNum.length() - 1; i >= 0; i--) {
            char ch = strNum.charAt(i); // 문자열의 각 문자 추출 # Extract each character from string
            arr.add(ch - '0'); // 문자를 숫자로 변환하여 리스트에 추가 # Convert char to int and add to list
        }

        int[] result = new int[arr.size()]; // 리스트 크기로 배열 생성 # Create an array of the same size as the list

        for (int i = 0; i < arr.size(); i++) {
            result[i] = arr.get(i); // 리스트의 값을 배열에 복사 # Copy values from list to array
        }

        return result; // 결과 배열 반환 # Return the result array
    }
}