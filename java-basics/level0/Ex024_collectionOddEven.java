/* 정수가 담긴 리스트 num_list가 주어집니다. num_list의 홀수만 순서대로 이어 붙인 수와 짝수만 순서대로 이어 붙인 수의 합을 return하도록 solution 함수를 완성해주세요.
   제한사항
   2 ≤ num_list의 길이 ≤ 10
   1 ≤ num_list의 원소 ≤ 9
   num_list에는 적어도 한 개씩의 짝수와 홀수가 있습니다. */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex024_collectionOddEven {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {3, 4, 5, 2, 1}));
        System.out.println(solution2());
        System.out.println(solution3());
    }

    public static int solution(int[] num_list) {
        String odd = "";
        String even = "";
        for (int i = 0; i < num_list.length; i++) {
            if (num_list[i] % 2 == 1) {
                odd += num_list[i];
            } else {
                even += num_list[i];
            }
        }
        int oddInt = Integer.parseInt(odd);
        int evenInt = Integer.parseInt(even);
        int sum = oddInt + evenInt;
        return sum;
    }

    public static int solution2() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Length number of array: ");
        int n = sc.nextInt();
        System.out.print("numbers: ");
        int[] num_list = new int[n];
        for (int i = 0; i < n; i++) {
            num_list[i] = sc.nextInt();
        }
        String odd = "";
        String even = "";
        for (int i = 0; i < num_list.length; i++) {
            if (num_list[i] % 2 == 1) {
                odd += num_list[i];
            } else {
                even += num_list[i];
            }
        }
        int oddInt = Integer.parseInt(odd);
        int evenInt = Integer.parseInt(even);
        int sum = oddInt + evenInt;
        return sum;
    }

    public static int solution3() {
        Scanner sc = new Scanner(System.in);
        List<Integer> num_list = new ArrayList<>();
        System.out.print("numbers (type -1 to stop): ");
        while (true) {
            int input = sc.nextInt();
            if (input == -1) break;
            num_list.add(input);
        }

        String odd = "";
        String even = "";
        for (int num : num_list) {
            if (num % 2 == 1) {
                odd += num;
            } else {
                even += num;
            }
        }
        int oddInt = Integer.parseInt(odd);
        int evenInt = Integer.parseInt(even);
        return oddInt + evenInt;
    }
}

/* List<Integer> num_list = new ArrayList<>();
 * Creates a dynamic array (ArrayList) that can store integers.
 * Here, num_list is a list that stores the numbers in order.
 * 정수를 저장할 수 있는 동적 배열 ArrayList를 생성한다.
 * 여기서 num_list는 숫자들을 순서대로 저장할 리스트이다.
 */

/* while (true) {
 * Starts an infinite loop. The loop will break when a specific condition is met.
 * 무한 반복문을 시작한다. 내부에서 특정 조건이 만족되면 반복을 종료한다. 
 */

/* int input = sc.nextInt();
 * Receives an integer input from the user and stores it in the variable 'input'.
 * 사용자로부터 정수 한 개를 입력받아 변수 input에 저장한다.
 */

/* if (input == -1) break;
 * If the input value is -1, the loop is terminated using 'break'.
 * This acts as a signal to stop entering numbers.
 * 만약 입력값이 -1이면 반복문을 종료(break)한다. 이는 숫자 입력 종료 신호이다.
 */

/* num_list.add(input);
 * Adds the entered number to the num_list.
 * 입력받은 숫자를 num_list 리스트에 추가한다.
 */

/* String odd = "";     String even = "";
 * Initializes an empty string 'odd' to concatenate odd numbers.
 * Initializes an empty string 'even' to concatenate even numbers.
 * 홀수 숫자들을 이어붙일 빈 문자열 odd를 생성한다. 짝수 숫자들을 이어붙일 빈 문자열 even도 생성한다.
 */

/*  for (int num : num_list) {
 * Iterates through each integer 'num' in the list num_list.
 * Processes all elements in num_list in order.
 * 리스트 num_list의 각 정수 num에 대해 반복문을 실행한다. num_list의 모든 요소를 순서대로 처리한다.
 */

/* if (num % 2 == 1) {
 * Checks if 'num' is an odd number. The '%' operator calculates the remainder,
 * and 'num % 2 == 1' means the number is odd.
 * num이 홀수인지 확인한다. %는 나머지 연산자이고, num % 2 == 1은 홀수를 의미한다.
 */

/* odd += num;
 * Appends the value of 'num' to the 'odd' string.
 * For example, if 'odd' is "3" and 'num' is 5, the result becomes "35".
 * odd 문자열에 num 값을 문자열로 변환하여 이어 붙인다. 예를 들어, odd가 "3"이고 num이 5면 "35"가 된다.
 */

/* } else {
            even += num;
        }
 * If 'num' is even, appends it to the 'even' string. 
 * num이 짝수라면 even 문자열에 num을 이어 붙인다. 
 */

/* int oddInt = Integer.parseInt(odd);  int evenInt = Integer.parseInt(even);
 * Converts the concatenated odd string to an integer and stores it in 'oddInt'.
 * Converts the concatenated even string to an integer and stores it in 'evenInt'.
 * 홀수로 이어붙인 문자열 odd를 정수로 변환하여 oddInt에 저장한다.
 * 짝수로 이어붙인 문자열 even을 정수로 변환하여 evenInt에 저장한다.
 */

/* return oddInt + evenInt;
 * Returns the sum of the integer created from odd numbers and the integer created from even numbers.
 * 홀수 숫자로 만들어진 정수와 짝수 숫자로 만들어진 정수의 합을 반환한다.
 */