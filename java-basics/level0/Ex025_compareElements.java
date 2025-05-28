/* 정수 리스트 num_list가 주어질 때, 마지막 원소가 그전 원소보다 크면 마지막 원소에서 
   그전 원소를 뺀 값을 마지막 원소가 그전 원소보다 크지 않다면 마지막 원소를 두 배한 값을 추가하여 return하도록 solution 함수를 완성해주세요.
   제한사항) 2 ≤ num_list의 길이 ≤ 10 , 1 ≤ num_list의 원소 ≤ 9 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ex025_compareElements {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{2, 1, 6})));
        solution2();
    }

    public static int[] solution(int[] num_list) {
        int last = num_list[num_list.length-1];
        int beforeLast = num_list[num_list.length-2];
        int[] newArr = new int[num_list.length + 1];
        for (int i = 0; i < num_list.length; i++) {
            newArr[i] = num_list[i];
        }
        if (last > beforeLast) {
            newArr[newArr.length - 1] = last - beforeLast;
        } else {
            newArr[newArr.length - 1] = last * 2;
        }
        return newArr;        
    }

    public static int[] solution2() {
        Scanner sc = new Scanner(System.in);
        List<Integer> num_list = new ArrayList<>();
        System.out.print("integer array(-1 to stop): ");
        while (true) { 
            int input = sc.nextInt();
            if (input == -1) break;
            num_list.add(input);   
        }
        int[] arr = new int[num_list.size()];
        for (int i = 0; i < num_list.size(); i++) {
            arr[i] = num_list.get(i);
        }
        if (arr.length < 2) {
            System.out.println("It needs more than 2 elements.");
            return null;
        }
        int[] result = solution(arr);
        System.out.println(Arrays.toString(result));
        return result;
    }
}

/* System.out.println(Arrays.toString(solution(new int[]{2, 1, 6})));
 * This prints the resulting array after applying the solution.
 * Arrays.toString() is used to convert the array into a readable string format for output.
 * 그 결과는 새로운 배열이 되는데, 그 배열을 보기 좋게 문자열로 변환해서 출력하려고 Arrays.toString()을 사용한다.
 */

/* int last = num_list[num_list.length - 1];
 * int beforeLast = num_list[num_list.length - 2];
 * `last`: the last element of the array  
 * `beforeLast`: the element just before the last one  
 * `num_list.length - 1` gives the index of the last element in the array.
 * last: 배열의 마지막 원소
 * beforeLast: 마지막 바로 앞의 원소
 * 배열에서 length - 1은 마지막 인덱스를 의미한다.
 */

/* int[] newArr = new int[num_list.length + 1];
 * We create a new array with one additional slot, because we need to add one more value based on the condition. 
 * 조건에 따라 새 값을 하나 추가해야하므로 원래 배열보다 크기가 하나 더 큰 새 배열을 만든다.
 */

/* for (int i = 0; i < num_list.length; i++) {
            newArr[i] = num_list[i];
        }
 * This loop copies all elements from the original array into the new one.
 * It uses index `i` to assign each value from `num_list[i]` to `newArr[i]`.
 * 기존 배열의 값을 새 배열에 복사하는 반복문이다. 인덱스 i를 이용해 num_list[i]를 newArr[i]에 그대로 옮깁니다.
 */

/* if (last > beforeLast) {
            newArr[newArr.length - 1] = last - beforeLast;
        } else {
            newArr[newArr.length - 1] = last * 2;
        }
 * This is a conditional statement: 
 * If the last element is greater than the one before it → store the difference at the end of the new array.
 * Otherwise → store the double of the last element.
 * `newArr.length - 1` represents the index of the last element in the new array.
 * 조건문입니다: 마지막 값이 그전 값보다 크면 → 두 수를 뺀 값을 배열 끝에 넣고, 그렇지 않으면 → 마지막 값을 두 배 해서 배열 끝에 넣습니다.
 * newArr.length - 1은 새 배열의 마지막 인덱스이다.
 */

/* while (true) {
    int input = sc.nextInt();
    if (input == -1) break;
    num_list.add(input);
    }
 * Starts an infinite loop. `input = sc.nextInt()` reads integers entered by the user one by one.  
 * If the input is -1, the loop stops. Otherwise, the number is added to the list.
 * 무한 루프를 시작한다. input = sc.nextInt()는 사용자가 입력한 정수를 하나씩 읽는다. 
 * input == -1이면 입력을 멈추고 while문을 종료한한다. 그 외 숫자는 리스트에 추가한다.
 */

/* int[] arr = new int[num_list.size()];
 * Creates an integer array with the same size as the list. 
 * The `solution()` function takes an array as input, so we need to convert the List into an int[] array.
 * 리스트의 크기만큼 정수 배열을 만든다. solution() 함수는 배열을 매개변수로 받기 때문에 List를 int[]로 변환해야 한다.
 */

/* for (int i = 0; i < num_list.size(); i++) {
    arr[i] = num_list.get(i);
    }
 * Copies the values from the list into the array one by one.
 * `get(i)` is a method that returns the i-th element from the list.
 * 리스트에 있는 값을 배열에 하나씩 복사한다. get(i)는 리스트의 i번째 값을 가져오는 메서드이다.
 */ 

/* if (arr.length < 2) {
    System.out.println("It needs more than 2 elements.");
    return null;
    }
 * If the array has fewer than 2 elements, it prints a warning message and returns null.  
 * This is because the problem requires at least 2 integers.
 * 배열의 길이가 2보다 작으면 경고 메시지를 출력하고 null을 반환한다. 문제 조건상 최소 2개 이상의 정수가 필요하기 때문이다.
 */

/* int[] result = solution(arr);
 * Passes the `arr` array to the `solution()` function and gets the result.  
 * The `solution()` function returns a new array based on certain conditions.
 * 아까 만든 arr 배열을 solution() 함수에 넘기고 결과를 받는다. 이 solution() 함수는 조건에 따라 새 배열을 만들어 반환한다.
 */

/* System.out.println(Arrays.toString(result));
 * Converts the result array to a readable string format and prints it.  
 * Without `Arrays.toString()`, the output would look like `[I@1b6d3586`, 
 * which is the memory address — not a readable array.
 * 결과 배열을 보기 좋게 문자열로 바꿔서 출력한다. Arrays.toString() 없이는 [I@1b6d3586 같은 이상한 형태로 출력된다.
 */

/* return result;
 * Returns the final array so it can be used again, for example, in the `main()` method or somewhere else in the program.
 * 최종적으로 만들어진 배열을 반환한다. main()이나 다른 곳에서 이 결과를 또 사용할 수 있게 된다.
 */