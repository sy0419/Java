/* 정수 a와 b가 주어집니다. 각 수를 입력받아 입출력 예와 같은 형식으로 출력하는 코드를 작성해 보세요.
   제한사항) -100,000 ≤ a, b ≤ 100,000
 */

public class Ex002_printAandB2 {
    public static void main(String[] args) {
        String result1 = solution1("3", "4");
        String result2 = solution2("3", "4");
        System.out.println(result1);
        System.out.println(result2);
    }

    public static String solution1(String a, String b) {
        return "a: " + a + "\nb: " + b;
    }

    public static String solution2(String a, String b) {
        int numA = Integer.parseInt(a);
        int numB = Integer.parseInt(b);
        return "a + b: " + (numA + numB);
    }
}

/* public static String solution1(String a, String b) → method 메서드
 * public static String solution2(String a, String b) → method 메서드
 */

 /* return "a: " + a + "\nb: " + b;
  * Concatenates "a: " with the value of a and "b: " with the value of b. 입력받은 문자열 a, b를 그대로 출력 포맷에 맞춰 문자열로 조합해 반환해요.
  */

/* int numA = Integer.parseInt(a); / int numB = Integer.parseInt(b);
 * Converts the string inputs to integers using Integer.parseInt().
 * Integer.parseInt(a) → 문자열 "a"을 정수 a으로 바꿈 / Integer.parseInt(b) → 문자열 "b"을 정수 b으로 바꿈
 */  

 /* 메서드가 반환하는 타입과 변수에 할당되는 값이 같은 타입이어야 한다.
  * 즉, 메서드의 리턴 타입이 String이라면 그 값을 받을 변수도 String이어야 하고, 리턴 타입이 int라면 변수도 int여야 한다는 것입니다.
  * public static void main(String[] args) {
        "'String'" message = greet("John");  // 메서드가 반환하는 String 값을 받는 변수도 String이어야 함
        System.out.println(message);
    }
  * public static "'String'"" greet(String name) {
        return "Hello, " + name;  // 이 메서드는 String을 반환
    }
  */