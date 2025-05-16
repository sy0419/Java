/* 문자열 str과 정수 n이 주어집니다. str이 n번 반복된 문자열을 만들어 출력하는 코드를 작성해 보세요.
제한사항) 1 ≤ str의 길이 ≤ 10 , 1 ≤ n ≤ 5 */

public class repeatString_003 {
    public static void main(String[] args) {
        String result = solution("string", 5);
        System.out.println(result);
    }

    public static String solution(String str, int n){
        String result = "";  
        for (int i = 0; i < n; i++) {
            result += str;
        }
        return result;
    }
}

/* for (int i = 0; i < n; i++) { result += str; }
 * This is the core of the method. The loop runs n times to add str to result in each iteration. 
 * n번 반복문을 실행하여 str을 result에 계속 이어붙입니다.
 * The loop starts with i = 0 and continues while i < n, which means the loop runs n times.
 * i = 0부터 시작하여 i < n일 때까지 반복합니다. 즉, 반복문은 n번 실행됩니다.
 * Inside the loop, result += str; appends str to the result string on each iteration.
 * 매 반복마다 result += str;는 현재의 result에 str을 추가하는 작업을 합니다.
 */

 /* return result;
  * After the loop finishes, the method returns the final result, which contains the repeated string.
  * 반복문이 끝난 후, 최종적으로 만들어진 result를 반환합니다. 이 반환값은 main 메서드에서 출력됩니다.
  */
