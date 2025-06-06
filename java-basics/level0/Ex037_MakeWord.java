/* 문자열 myString 정수 배열 indexList가가 매개변수로 주어집니다. 
   myString의 indexList의 원소들에 해당하는 인덱스의 글자들을 순서대로 이어 붙인 문자열을 return 하는 solution 함수를 작성해 주세요.
   제한사항 
   1 ≤ myString의 길이 ≤ 1,000
   myString의 원소는 영소문자로 이루어져 있습니다.
   1 ≤ indexList의 길이 ≤ 1,000
   0 ≤ indexList의 원소 < myString의 길이 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex037_MakeWord {
    public static void main(String[] args) {
        System.out.println(solution("cvsgiorszzzmrpaqpe", new int[] {16, 6, 5, 3, 12, 14, 11, 11, 17, 12, 7}));
        System.out.println(solution("zpiaz", new int[] {1, 2, 0, 0, 3}));
        System.out.println(solution2());
    }

    public static String solution(String myString, int[] indexList) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indexList.length; i++) {
            char c = myString.charAt(indexList[i]);
            sb.append(c);
        }
        return sb.toString();
    }
    
    public static String solution2() {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        System.out.print("String: ");
        String myString = sc.next();
        List<Integer> indexList = new ArrayList<>();
        System.out.print("Index List(-1 to stop): ");
        while (true) { 
            int input = sc.nextInt();
            if (input == -1) {
                break;
            }
            indexList.add(input);
        }
        for (int i = 0; i < indexList.size(); i++) {
            char c = myString.charAt(indexList.get(i));
            sb.append(c);
        }
        return sb.toString();
    }
}

/* StringBuilder sb = new StringBuilder();
 * A class used to efficiently concatenate strings.
 * 문자열을 효율적으로 이어 붙이기 위해 사용되는 클래스
 */

/* for (int i = 0; i < indexList.length; i++)
 * Repeat as many times as the length of the array.
 * 배열의 길이만큼 반복
 */

/* char c = myString.charAt(indexList[i]);
 * Extract the character at the index position from myString.
 * myString에서 인덱스 위치에 해당하는 문자 하나 꺼낸다.
 */

/* sb.append(c);
 * Append the character to the StringBuilder.
 * 그 문자를 StringBuilder에 붙인다.
 */

/* StringBuilder를 사용하는 이유
 * Performance - Much faster than using + when repeatedly concatenating strings.
 * Memory efficient - Does not create a new object every time like String.
 * Readability - append() makes string manipulation clear and easy to follow.
 * Good in loops - Ideal for building strings in a for-loop.
 * 성능	- 문자열을 반복해서 붙일 때 + 연산보다 훨씬 빠르다.
 * 메모리 효율 - String처럼 매번 새 객체를 만들지 않는다.
 * 가독성 - append() 메서드로 명확하게 문자열 조작 가능하다.
 * 반복문에 적합 - for문 안에서 많은 문자열을 만들 때 유리하다.
 */