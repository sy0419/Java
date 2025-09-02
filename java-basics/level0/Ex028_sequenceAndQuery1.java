/* 정수 배열 arr와 2차원 정수 배열 queries이 주어집니다. queries의 원소는 각각 하나의 query를 나타내며, [i, j] 꼴입니다.
   각 query마다 순서대로 arr[i]의 값과 arr[j]의 값을 서로 바꿉니다. 
   위 규칙에 따라 queries를 처리한 이후의 arr를 return 하는 solution 함수를 완성해 주세요.
   제한사항)
   1 ≤ arr의 길이 ≤ 1,000 
   0 ≤ arr의 원소 ≤ 1,000,000
   1 ≤ queries의 길이 ≤ 1,000
   0 ≤ i < j < arr의 길이 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ex028_sequenceAndQuery1 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[] {0, 1, 2, 3, 4}, new int[][] {{0, 3}, {1, 2}, {1, 4}})));
        System.out.println(Arrays.toString(solution2()));
    }

    public static int[] solution(int[] arr, int[][] queries) {
        for (int[] query : queries) {
            int i = query[0];
            int j = query[1];
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        return arr;
    }

    public static int[] solution2() {
        Scanner sc = new Scanner(System.in);
        List<Integer> arr = new ArrayList<>();
        System.out.print("Array(-1 to stop): ");
        while (true) { 
            int input = sc.nextInt();
            if (input == -1) {
                break;
            } arr.add(input);
        }
        int[] arrArray = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            arrArray[i] = arr.get(i);
        }

        List<int[]> queries = new ArrayList<>();
        System.out.println("Queries(i, j and -1 to stop)");
        while (true) {
            System.out.print("i: ");
            int i = sc.nextInt();
            System.out.print("j: ");
            int j = sc.nextInt();
            if (i == -1 && j == -1) {
                break;
            } queries.add(new int[] {i, j});
        }
        int[][] queriesArray = new int[queries.size()][2];
        for (int i = 0; i < queries.size(); i++) {
            queriesArray[i] = queries.get(i);
        }
        int[] result = solution(arrArray, queriesArray);
        return result;
    }
}

/* for (int[] query : queries) {
 * Enhanced for-loop (for-each loop). Iterates over each element (int[] query) in the queries array.
 * 향상된 for문 (for-each loop). queries 배열의 각 원소(int[] query)를 하나씩 꺼낸다.
 */

/* int i = query[0];
 * int j = query[1];
 * Extracts the i and j indices from the current query.
 * 현재 쿼리에서 i와 j 인덱스를 추출한다. 
 */

/* int temp = arr[i];
 * arr[i] = arr[j];
 * arr[j] = temp;
 * Swaps the values at indices i and j in the array.
 * 배열의 i번 인덱스와 j번 인덱스 값을 서로 바꾼다.
 */

/* List<Integer> arr = new ArrayList<>();
 * Creates a list to store the user's input values.
 * arr의 값을 입력받기 위해 리스트를 생성힌디.
 */

/* while (true) { 
        int input = sc.nextInt();
        if (input == -1) {
            break;
        }
        arr.add(input);
    }
 * Continues to read integers from the user until -1 is entered, and adds each to the list.
 * 사용자가 -1을 입력할 때까지 숫자를 계속 입력받고 리스트에 추가한다.
 */

/* int[] arrArray = new int[arr.size()];
   for (int i = 0; i < arr.size(); i++) {
       arrArray[i] = arr.get(i);
   }
 * Converts the List<Integer> into a regular int[] array, since the solution() method requires an array.
 * 리스트(List<Integer>)를 int[] 배열로 변환합니다. solution()이 배열을 요구하기 때문이다.
 */

/* List<int[]> queries = new ArrayList<>();
 * Creates a list to store query pairs.
 * 쿼리를 저장할 리스트를 만든다.
 */

/* while (true) {
        System.out.print("i: ");
        int i = sc.nextInt();
        System.out.print("j: ");
        int j = sc.nextInt();
        if (i == -1 || j == -1) {
            break;
        }
        queries.add(new int[] {i, j});
    }
 * Reads query pairs [i, j] from the user. Stops if either i or j is -1.
 * Each pair is stored as an int[] and added to the list.
 * 쿼리 [i, j] 쌍을 입력받고, -1이 입력되면 루프를 종료한다. 각 쌍을 int[]로 만들어 리스트에 저장한다.
 */

/* int[][] queriesArray = new int[queries.size()][2];
   for (int i = 0; i < queries.size(); i++) {
       queriesArray[i] = queries.get(i);
   }
 * Converts the List<int[]> into a 2D array (int[][]).
 * 리스트(List<int[]>)를 int[][] 배열로 변환한다.
 */

/* int[] result = solution(arrArray, queriesArray);
 * Calls the original solution() method with the converted array and queries.
 * 변환된 배열과 쿼리를 가지고 원래 solution() 함수를 호출한다.
 */