// 괄호 회전하기

// 다음 규칙을 지키는 문자열을 올바른 괄호 문자열이라고 정의합니다.

// (), [], {} 는 모두 올바른 괄호 문자열입니다.
// 만약 A가 올바른 괄호 문자열이라면, (A), [A], {A} 도 올바른 괄호 문자열입니다. 
// 예를 들어, [] 가 올바른 괄호 문자열이므로, ([]) 도 올바른 괄호 문자열입니다.
// 만약 A, B가 올바른 괄호 문자열이라면, AB 도 올바른 괄호 문자열입니다. 
// 예를 들어, {} 와 ([]) 가 올바른 괄호 문자열이므로, {}([]) 도 올바른 괄호 문자열입니다.
// 대괄호, 중괄호, 그리고 소괄호로 이루어진 문자열 s가 매개변수로 주어집니다. 
// 이 s를 왼쪽으로 x (0 ≤ x < (s의 길이)) 칸만큼 회전시켰을 때 s가 올바른 괄호 문자열이 되게 하는
// x의 개수를 return 하도록 solution 함수를 완성해주세요.

// 제한사항
// s의 길이는 1 이상 1,000 이하입니다.

// 입출력 예
//     s      result
// "[](){}"	    3
// "}]()[{"	    2
//  "[)(]"	    0
//   "}}}"	    0

// 입출력 예 설명
// 입출력 예 #1
// 다음 표는 "[](){}" 를 회전시킨 모습을 나타낸 것입니다.
// x	s를 왼쪽으로 x칸만큼 회전	올바른 괄호 문자열?
// 0	       "[](){}"	                 O
// 1	       "](){}["	                 X
// 2	       "(){}[]"	                 O
// 3	       "){}[]("                  X
// 4	       "{}[]()"	                 O
// 5	       "}[](){"	                 X
// 올바른 괄호 문자열이 되는 x가 3개이므로, 3을 return 해야 합니다.

// 입출력 예 #2
// 다음 표는 "}]()[{" 를 회전시킨 모습을 나타낸 것입니다.
// x	s를 왼쪽으로 x칸만큼 회전	올바른 괄호 문자열?
// 0	       "}]()[{"	                 X
// 1	       "]()[{}"	                 X
// 2	       "()[{}]"	                 O
// 3	       ")[{}]("	                 X
// 4	       "[{}]()"	                 O
// 5	       "{}]()["	                 X
// 올바른 괄호 문자열이 되는 x가 2개이므로, 2를 return 해야 합니다.

// 입출력 예 #3
// s를 어떻게 회전하더라도 올바른 괄호 문자열을 만들 수 없으므로, 0을 return 해야 합니다.

// 입출력 예 #4
// s를 어떻게 회전하더라도 올바른 괄호 문자열을 만들 수 없으므로, 0을 return 해야 합니다.


// Bracket Rotation

// A string is considered a valid bracket string if it follows these rules.

// (), [], {} are all valid bracket strings.
// If A is a valid bracket string, then (A), [A], and {A} are also valid bracket strings.
// For example, since [] is a valid bracket string, ([]) is also valid.
// If A and B are valid bracket strings, then AB is also a valid bracket string.
// For example, since {} and ([]) are valid bracket strings, {}([]) is also valid.
// A string s consisting of square brackets, curly brackets, and parentheses is given.
// Rotate s to the left by x positions (0 ≤ x < s.length).
// Return the number of x values that make s a valid bracket string.

// Constraints
// 1 ≤ s.length ≤ 1,000

// Example Input / Output
//     s      result
// "[](){}"	    3
// "}]()[{"	    2
//  "[)(]"	    0
//   "}}}"	    0

// Example Explanation
// Example #1
// The table below shows all rotations of "[](){}".
// x	Rotated string	        Valid bracket string?
// 0	    "[](){}"	                    O
// 1	    "](){}["	                    X
// 2	    "(){}[]"	                    O
// 3	    "){}[]("	                    X
// 4	    "{}[]()"	                    O
// 5	    "}[](){"	                    X
// Since there are 3 valid rotations, return 3.

// Example #2
// The table below shows all rotations of "}]()[{".
// x	Rotated string	        Valid bracket string?
// 0	    "}]()[{"	                    X
// 1	    "]()[{}"	                    X
// 2	    "()[{}]"	                    O
// 3	    ")[{}]("	                    X
// 4	    "[{}]()"	                    O
// 5	    "{}]()["	                    X
// Since there are 2 valid rotations, return 2.

// Example #3
// No rotation can make s a valid bracket string, so return 0.

// Example #4
// No rotation can make s a valid bracket string, so return 0.

import java.util.Stack;

public class Ex020_BracketRotation {

    public static void main(String[] args) {
        System.out.println(solution("[](){}"));
        System.out.println(solution("}]()[{"));
        System.out.println(solution("[)(]"));
        System.out.println(solution("}}}"));
    }

    public static int solution(String s) {
        int count = 0; // 올바른 괄호 회전 개수 저장 # Store valid bracket rotation count

        // 문자열을 한 칸씩 회전하며 검사 # Check every possible rotation
        for (int i = 0; i < s.length(); i++) {
            String rotated = s.substring(i) + s.substring(0, i); // 회전 문자열 생성 # Create rotated string

            // 올바른 괄호 문자열이면 개수 증가 # Increase count if valid
            if (isValid(rotated)) {
                count++;
            }
        }

        return count; // 결과 반환 # Return result
    }

    private static boolean isValid(String str) {
        Stack<Character> stack = new Stack<>(); // 괄호 저장용 스택 # Stack for brackets

        // 문자열 문자 하나씩 검사 # Check each character
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i); // 현재 문자 저장 # Store current character

            // 여는 괄호는 스택에 추가 # Push opening bracket
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {

                // 닫는 괄호인데 스택이 비어있으면 실패 # Fail if stack is empty
                if (stack.isEmpty()) {
                    return false;
                }

                // 소괄호 짝 확인 # Check parentheses ()
                if (ch == ')' && stack.peek() == '(') {
                    stack.pop();
                }

                // 대괄호 짝 확인 # Check square brackets []
                else if (ch == ']' && stack.peek() == '[') {
                    stack.pop();
                }

                // 중괄호 짝 확인 # Check curly brackets {}
                else if (ch == '}' && stack.peek() == '{') {
                    stack.pop();
                }

                // 괄호 짝이 맞지 않으면 실패 # Fail if bracket mismatch
                else {
                    return false;
                }
            }
        }

        return stack.isEmpty(); // 스택이 비어있으면 올바른 괄호 # Valid if stack is empty
    }
}