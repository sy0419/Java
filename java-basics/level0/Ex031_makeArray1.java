/* 정수 l과 r이 주어졌을 때, l 이상 r이하의 정수 중에서 숫자 "0"과 "5"로만 이루어진 모든 정수를 
   오름차순으로 저장한 배열을 return 하는 solution 함수를 완성해 주세요.
   만약 그러한 정수가 없다면, -1이 담긴 배열을 return 합니다.
   제한사항) 1 ≤ l ≤ r ≤ 1,000,000 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ex031_makeArray1 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, 555)));
        System.out.println(Arrays.toString(solution2()));
    }

    public static int[] solution(int l, int r) {
        List<Integer> result = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            String stringNum = Integer.toString(i);
            boolean isValid = true;
            for (int j = 0; j < stringNum.length(); j++) {
                char c = stringNum.charAt(j);
                if (c != '0' && c != '5') {
                    isValid = false;
                    break;
                } 
            }
            if (isValid) {
                result.add(i);
            }
        }
        if (result.isEmpty()) {
            return new int[]{-1};
        }
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }

    public static int[] solution2() {
        Scanner sc = new Scanner(System.in);
        System.out.print("l: ");
        int l = sc.nextInt();
        System.out.print("r: ");
        int r = sc.nextInt();
        List<Integer> result = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            String stringNum = Integer.toString(i);
            boolean isValid = true;
            for (int j = 0; j < stringNum.length(); j++) {
                char c = stringNum.charAt(j);
                if (c != '0' && c != '5') {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                result.add(i);
            }
        }
        if (result.isEmpty()) {
                return new int[]{-1};
            } 
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}


/* for (int i = l; i <= r; i++)
 * A loop that checks every integer from l to r.
 * l부터 r까지 모든 정수를 확인하는 반복문이다.
 */

/* String stringNum = Integer.toString(i);
 * Converts the current number to a string.
 * 현재 숫자를 문자열로 변환한다.
 */

/* boolean isValid = true;
 * A flag to check if the number is valid (contains only '0' and '5').
 * 유효한 숫자인지 판별할 플래그를 설정한다.
 */

/* for (int j = 0; j < stringNum.length(); j++)
 * A loop to check each digit (character) in the string.
 * 문자열의 각 문자(숫자 자리수)를 확인하는 반복문이다.
 */

/* char c = stringNum.charAt(j);
 * Retrieves the character at the current position.
 * 현재 자리의 문자를 가져온다.
 */

/* if (c != '0' && c != '5') {
       isValid = false;
       break;
    }
 * If the character is neither '0' nor '5', mark it as invalid and exit the loop.
 * 문자가 '0'도 아니고 '5'도 아니라면, 유효하지 않으므로 false로 설정하고 반복을 종료한다.
 */

/* if (isValid) {
       result.add(i);
    }
 * If all digits are valid, add the number to the result list.
 * 모든 자리수가 유효하면 결과 리스트에 추가한다.
 */

/* if (result.isEmpty()) {
       return new int[]{-1};
    }
 * If no valid numbers were found, return an array containing only -1.
 * 조건에 맞는 수가 하나도 없으면 -1을 배열로 리턴한다.
 */

/* int[] answer = new int[result.size()];
 * Create an array to store the results from the list.
 * 결과 리스트를 정수 배열로 변환할 공간을 생성한다.
 */

/* for (int i = 0; i < result.size(); i++) {
        answer[i] = result.get(i);
    }
 * Copy each element from the list to the array.
 * 리스트의 각 요소를 배열에 복사한다.
 */