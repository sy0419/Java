// 문자열 배열 intStrs와 정수 k, s, l가 주어집니다. intStrs의 원소는 숫자로 이루어져 있습니다.
// 배열 intStrs의 각 원소마다 s번 인덱스에서 시작하는 길이 l짜리 부분 문자열을 잘라내 정수로 변환합니다. 
// 이때 변환한 정수값이 k보다 큰 값들을 담은 배열을 return 하는 solution 함수를 완성해 주세요.
// 제한사항
// 0 ≤ s < 100
// 1 ≤ l ≤ 8
// 10l - 1 ≤ k < 10l
// 1 ≤ intStrs의 길이 ≤ 10,000
// s + l ≤ intStrs의 원소의 길이 ≤ 120

import java.util.ArrayList;
import java.util.Arrays;

public class Ex040_makingArray5 {
    public static void main(String[] args) {
        // 테스트 케이스 실행 및 결과 출력
        // Run test case and print the result
        int[] result = solution(new String[] {"0123456789","9876543210","9999999999999"}, 50000, 5, 5);
        System.out.println(Arrays.toString(result)); // 배열 내용을 문자열로 변환하여 출력
    }

    // 문자열 배열 intStrs와 정수 k, s, l을 받아 조건에 맞는 숫자 배열 반환
    // Takes a string array intStrs and integers k, s, l; returns an int array with values > k after substring extraction
    public static int[] solution(String[] intStrs, int k, int s, int l) {
        ArrayList<Integer> list = new ArrayList<>(); // 조건을 만족하는 정수들을 저장할 리스트
        for (String intStr : intStrs) {
            // 각 문자열에서 s 인덱스부터 길이 l만큼 부분 문자열 추출
            // Extract substring starting at index s with length l from each string
            String tep = intStr.substring(s, s+l);
            // 부분 문자열을 정수로 변환
            // Convert substring to integer
            int num = Integer.parseInt(tep);
            // 변환한 숫자가 k보다 크면 리스트에 추가
            // Add to list if number is greater than k
            if(num > k) {
                list.add(num);
            }
        }

        // 리스트 크기만큼의 정수 배열 생성
        // Create int array sized to the list
        int[] answer = new int[list.size()];

        // 리스트의 값을 배열로 복사
        // Copy values from list to array
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        // 결과 배열 반환
        // Return the resulting array
        return answer;
    }
}