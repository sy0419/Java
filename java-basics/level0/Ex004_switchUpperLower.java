/* 문제 설명
영어 알파벳으로 이루어진 문자열 str이 주어집니다. 
각 알파벳을 대문자는 소문자로 소문자는 대문자로 변환해서 출력하는 코드를 작성해 보세요.
제한사항) 1 ≤ str의 길이 ≤ 20 , str은 알파벳으로 이루어진 문자열입니다. */

public class Ex004_switchUpperLower {
    public static void main(String[] args) {
        String result = solution("aBcDeFg");
        String result2 = solution2("aBcDeFg");
        System.out.println(result);
        System.out.println("-------");
        System.out.println(result2);
    }

    public static String solution(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isLowerCase(c)) {
                result += Character.toUpperCase(c);
            } else {
                result += Character.toLowerCase(c);
            }
        }
        return result;
    }

    public static String solution2(String str) {
        StringBuilder result = new StringBuilder();  // StringBuilder 객체 생성
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isLowerCase(c)) {
                result.append(Character.toUpperCase(c));  // 대문자로 바꿔서 추가
            } else {
                result.append(Character.toLowerCase(c));  // 소문자로 바꿔서 추가
            }
        }
        return result.toString();  // 최종 문자열 반환
    }
}

/* for (int i = 0; i < str.length(); i++) {
 * Starts a for loop that goes through each character in the input string from index 0 to str.length() - 1.
 * 문자열의 길이만큼 반복하는 for 반복문이다. 0번 인덱스부터 마지막 문자까지 하나씩 검사한다.
 */

/* char c = str.charAt(i);
 * Retrieves the character at index i from the input string and stores it in a variable c.
 * 문자열에서 i번째 문자를 하나씩 꺼냅니다.
 */

/* if (Character.isLowerCase(c))
 * Checks if the character c is a lowercase letter.
 * If c is lowercase, this converts it to uppercase and adds it to the result string.
 * If c is not lowercase (meaning it's uppercase), this converts it to lowercase and adds it to the result string.
 * 문자가 소문자인지 확인 후 true이면 대문자로 변환하고, false이면 (즉, 대문자면) 소문자로 변환한다.
 */

 /* result += ...
  * 변환된 문자를 누적하여 result라는 새 문자열에 저장한다.
  */

  /* StringBuilder is a class in Java that allows for efficient string concatenation.
   * A String object is immutable, meaning once it is created, its content cannot be changed.
   * So, every time you append to a String, a new String object is created.
   * This leads to memory waste and slower performance, especially inside loops.
   * StringBuilder, on the other hand, modifies the string in-place using an internal buffer.
   * As a result, it’s faster and more memory-efficient.
   * StringBuilder is an effective tool for improving performance when you need to concatenate strings frequently.
   * StringBuilder는 자바에서 문자열을 효율적으로 이어 붙일 수 있게 해주는 클래스.
   * String 객체는 한 번 만들어지면 내용을 바꿀 수 없다. (즉, 불변) 
   * 그래서 문자열을 이어 붙일 때마다 새로운 String 객체가 계속 생성된다.
   * 메모리도 낭비되고 속도도 느려지고. 특히 반복문 안에서는 더 심각해진다.
   * StringBuilder는 문자열을 바꿔도 새 객체를 만들지 않고, 내부 버퍼에서 바로 처리한다.
   * 그래서 속도도 빠르고, 메모리 사용도 효율적이다.
   * StringBuilder는 문자열을 많이 이어붙일 때 성능을 향상시켜주는 효율적인 도구.
   */