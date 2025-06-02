/* 정수 배열 arr와 2차원 정수 배열 queries이 주어집니다. queries의 원소는 각각 하나의 query를 나타내며, [s, e, k] 꼴입니다.
   각 query마다 순서대로 s ≤ i ≤ e인 모든 i에 대해 k보다 크면서 가장 작은 arr[i]를 찾습니다.
   각 쿼리의 순서에 맞게 답을 저장한 배열을 반환하는 solution 함수를 완성해 주세요.
   단, 특정 쿼리의 답이 존재하지 않으면 -1을 저장합니다.
   제한사항)
   1 ≤ arr의 길이 ≤ 1,000
   0 ≤ arr의 원소 ≤ 1,000,000
   1 ≤ queries의 길이 ≤ 1,000
   0 ≤ s ≤ e < arr의 길이
   0 ≤ k ≤ 1,000,000 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ex029_sequenceAndQuery2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[] {0, 1, 2, 4, 3}, new int[][] {{0, 4, 2}, {0, 3, 2}, {0, 2, 2}})));
        System.out.println(Arrays.toString(solution2()));
    }

    public static int[] solution(int[] arr, int[][] queries) {
        List<Integer> result = new ArrayList<>();
        for(int[] query:queries) {
            int s = query[0];
            int e = query[1];
            int k = query[2];

            int minVal = Integer.MAX_VALUE;
            boolean found = false;
            for (int i = s; i <= e; i++) {
                if (arr[i] > k) {
                    if (arr[i] < minVal) {
                        minVal = arr[i];
                        found = true;
                    }
                }
            }
            if (found) {
                result.add(minVal);
            } else {
                result.add(-1);
            }
        }
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }

    public static int[] solution2() {
        int[] arr;
        int[][] queries;
        try (Scanner sc = new Scanner(System.in)) {
            List<Integer> arrList = new ArrayList<>();
            System.out.print("Array(-1 to stop): ");
            while (true) {
                int input = sc.nextInt();
                if (input == -1) {
                    break;
                } arrList.add(input);
            }   
            arr = new int[arrList.size()];
            for (int i = 0; i < arrList.size(); i++) {
                arr[i] = arrList.get(i);
            }   List<int[]> queriesList = new ArrayList<>();
            System.out.println("Queries(-1 to stop)");
            while (true) {
                System.out.print("s: ");
                int s = sc.nextInt();
                if (s == -1) {
                    break;
                }
                System.out.print("e: ");
                int e = sc.nextInt();
                System.out.print("k: ");
                int k = sc.nextInt();
                queriesList.add(new int[] {s, e, k});
            }   queries = new int[queriesList.size()][];
            for (int i = 0; i < queriesList.size(); i++) {
                queries[i] = queriesList.get(i);
            }
        }
        
        return solution(arr, queries);
    }
}

/* List<Integer> result = new ArrayList<>();
 * List to store the results.
 * 결과를 저장할 리스트.
 */

/* for(int[] query : queries) 
 * Iterate over each query in queries. Each query is in the format [s, e, k].
 * 쿼리 배열 하나씩 순회한다. 각 query는 [s, e, k] 형식이다.
 */

/* int s = query[0];
 * int e = query[1];
 * int k = query[2];
 * Extract the start index (s), end index (e), and comparison value (k) from the query.
 * 쿼리에서 시작 인덱스 s, 끝 인덱스 e, 비교 값 k 추출한다.
 */

/* int minVal = Integer.MAX_VALUE;
 * Initialize with the maximum possible value to find the minimum.
 * Initialize minVal with a very large value, and during the loop, if a number meets the condition and is smaller than minVal, update it.
 * 가장 작은 값을 찾기 위해 초기값 설정한다.
 * minVal을 아주 큰 값으로 초기화해 놓고, 반복문에서 조건에 맞는 수가 있으면, 그보다 작으면 갱신하는 식입니다.
 */

/* boolean found = false;
 * Flag to check if a valid value was found.
 * 조건을 만족하는 값이 있었는지 여부이다.
 */

/* for (int i = s; i <= e; i++) {
        if (arr[i] > k) {
            if (arr[i] < minVal) {
                minVal = arr[i];
                found = true;
            }
        }
    }
 * Loop to find the smallest arr[i] that is greater than k in the range [s, e].
 * arr[i]가 k보다 크면서 가장 작은 값인지 체크하는 반복문이다.
 */

/* result.add(minVal);
 * Add the minimum value that satisfies the condition.
 * 조건을 만족하는 최소값 추가한다.
 */

/* result.add(-1);
 * Add -1 if no such value exists.
 * 없으면 -1 추가한다.
 */

/* int[] answer = new int[result.size()];
 * Create an array to store the final answer.
 * 최종적으로 반환할 배열 생성한다.
 */

/* for (int i = 0; i < result.size(); i++) {
        answer[i] = result.get(i);
    }
 * Convert the List<Integer> to a regular int[] array.
 * List<Integer>를 int[]로 변환한다.
 */

/* while (true) {
        int input = sc.nextInt();
        if (input == -1) {
            break;
        }
        arrList.add(input);
    }
 * Read input values for arr until -1 is entered, and store them in a list.
 * arr 값들을 입력받아 리스트에 저장한다.
 */

/* int[] arr = new int[arrList.size()];
    for (int i = 0; i < arrList.size(); i++) {
        arr[i] = arrList.get(i); 
    }
 * Convert the list into an int array.
 * 리스트를 배열로 변환한다.
 */

/* try-with-resources 구문 사용 이유
 * The try-with-resources statement automatically closes I/O resources like Scanner.
 * When the try block ends, sc.close() is called automatically, preventing resource leaks.
 * This is a safer and cleaner way to handle closing resources compared to manually calling sc.close(), making it a good practice.
 * try-with-resources 구문은 Scanner 같은 I/O 자원을 자동으로 닫아준다.
 * try 블록이 끝나면 sc.close()가 자동으로 호출되어 리소스 누수를 방지해 준다.
 * 이전에 수동으로 sc.close() 했던 부분을 더 안전하고 깔끔하게 바꾼 것이라 좋은 습관이다.
 */

/* List<int[]> queriesList = new ArrayList<>();
    System.out.println("Queries(-1 to stop)");
 * Create a list to store the queries entered by the user.
 * queries 입력을 받을 리스트.
 */

/* while (true) {
    System.out.print("s: ");
    int s = sc.nextInt();
    if (s == -1) {
        break;
    }
    System.out.print("e: ");
    int e = sc.nextInt();
    System.out.print("k: ");
    int k = sc.nextInt();
    queriesList.add(new int[] {s, e, k});
    }
 * Read each query in the form [s, e, k] and store it in the list.
 * [s, e, k] 형태의 쿼리를 입력받아 리스트에 저장한다.
 */

/* int[][] queries = queriesList.toArray(new int[queriesList.size()][]);
 * Convert the list of queries into a 2D int array.
 * 리스트를 2차원 배열로 변환한다.
 */

/* sc.close();  
 * Close the Scanner to prevent resource leaks.
 * Why close the Scanner?
 * 1. Resource cleanup
 *    - Scanner uses the input stream (System.in) which consumes system resources.
 *    - Always close input streams when done to avoid memory leaks or input issues.
 * 2. Good practice
 *    - It's standard practice to close I/O resources (like files, sockets, scanners).
 *    - Though not strictly required in small programs, it's better coding hygiene.
 *
 * Warning:
 * Once closed, System.in cannot be used again. Closing the Scanner also closes System.in.
 * So, ideally, create the Scanner once and close it only at the end of the program.
 * Scanner 닫기 (리소스 누수 방지)
 * Scanner 객체를 닫는 이유
 *  1. 자원(Resource) 정리 
 *   - Scanner는 내부적으로 입력 스트림(System.in) 을 사용한다. 
 *   - 이 스트림은 운영체제의 자원(Resource) 을 사용하므로, 사용이 끝난 뒤에는 반드시 닫아줘야 한다. 
 *   - 닫지 않으면 메모리 누수나 입력 충돌이 발생할 수 있어요. 특히 복잡한 애플리케이션에서는 문제가 된다.
 *  2. 권장되는 습관(Good Practice)
 *   - 파일, 네트워크, 사용자 입력 등 입출력 스트림을 사용하는 모든 경우엔 사용 후 close()가 정석이다.
 *   - 예외적으로 간단한 콘솔 프로그램에서는 꼭 닫지 않아도 작동은 하지만, 깨끗한 코드 습관을 위해 닫는 것이 좋다.
 * 주의할 점
 * Scanner를 닫으면 System.in 도 함께 닫히므로, 이후에 다시 입력을 받으려 하면 예외(IllegalStateException) 가 발생한다.
 * 따라서 프로그램에서 Scanner를 한 번만 생성하고, 마지막에 닫는 것이 이상적이다. 
 */

/* return solution(arr, queries); 
 * Call the solution method using the inputs collected from the user.
 * 입력받은 데이터로 solution 함수 호출한다.
 */