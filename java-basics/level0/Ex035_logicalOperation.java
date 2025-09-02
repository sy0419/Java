
import java.util.Scanner;

/* boolean 변수 x1, x2, x3, x4가 매개변수로 주어질 때, 다음의 식의 true/false를 return 하는 solution 함수를 작성해 주세요.
   (x1 ∨ x2) ∧ (x3 ∨ x4) 
   입출력 예
   x1	    x2	    x3	    x4	    result
   false	true	true	true	true
   true	    false	false	false	false
   입출력 예 설명
   입출력 예 #1
   예제 1번의 x1, x2, x3, x4로 식을 계산하면 다음과 같습니다.
   (x1 ∨ x2) ∧ (x3 ∨ x4) ≡ (F ∨ T) ∧ (T ∨ T) ≡ T ∧ T ≡ T
   따라서 true를 return 합니다.
   입출력 예 #2
   예제 2번의 x1, x2, x3, x4로 식을 계산하면 다음과 같습니다.
   (x1 ∨ x2) ∧ (x3 ∨ x4) ≡ (T ∨ F) ∧ (F ∨ F) ≡ T ∧ F ≡ F
   따라서 false를 return 합니다. */

public class Ex035_logicalOperation {
    public static void main(String[] args) {
        System.out.println(solution(false, true, true, true));
        System.out.println(solution(true, false, false, false));
        System.out.println(solution2());
    }

    public static boolean solution(boolean x1, boolean x2, boolean x3, boolean x4) {
        return (x1 || x2) && (x3 || x4);
    }

    public static boolean solution2() {
        Scanner sc = new Scanner(System.in);
        System.out.print("x1: ");
        boolean x1 = sc.nextBoolean();
        System.out.print("x2: ");
        boolean x2 = sc.nextBoolean();
        System.out.print("x3: ");
        boolean x3 = sc.nextBoolean();
        System.out.print("x4: ");
        boolean x4 = sc.nextBoolean();
        return (x1 || x2) && (x3 || x4);
    }
}

/* 논리합
 * || → logical OR, OR 연산 (하나라도 true면 true)
 * && → logical AND, AND 연산 (둘 다 true여야 true)
 * ! → logical NOT, NOT 연산
 */