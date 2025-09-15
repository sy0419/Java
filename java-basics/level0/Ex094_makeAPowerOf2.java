// 정수 배열 arr이 매개변수로 주어집니다. arr의 길이가 2의 정수 거듭제곱이 되도록 arr 뒤에 정수 0을 추가하려고 합니다. 
// arr에 최소한의 개수로 0을 추가한 배열을 return 하는 solution 함수를 작성해 주세요.

// 제한사항
// 1 ≤ arr의 길이 ≤ 1,000
// 1 ≤ arr의 원소 ≤ 1,000

import java.util.ArrayList;
import java.util.Arrays;

public class Ex094_makeAPowerOf2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[] {1, 2, 3, 4, 5, 6})));  // [1, 2, 3, 4, 5, 6, 0, 0]
        System.out.println(Arrays.toString(solution(new int[] {58, 172, 746, 89})));    // [58, 172, 746, 89]
    }

    public static int[] solution(int[] arr) {
        ArrayList<Integer> arrList = new ArrayList<>();

        // arr.length보다 크거나 같은 최소 2의 거듭제곱 n 구하기
        // # Find the smallest power of 2 greater than or equal to arr.length
        int n = 1;
        while (n < arr.length) {
            n *= 2;
        }

        // arr의 모든 원소를 arrList에 추가
        // # Add all elements from arr to arrList
        for (int num : arr) {
            arrList.add(num);
        }

        // arrList의 크기가 n이 될 때까지 0을 추가
        // # Add zeros until arrList size reaches n
        for (int i = arr.length; i < n; i++) {
            arrList.add(0);
        }

        // ArrayList를 int 배열로 변환
        // # Convert ArrayList to int array
        int[] result = new int[arrList.size()];
        for(int i = 0; i < arrList.size(); i++) {
            result[i] = arrList.get(i);
        }

        return result;
    }
}