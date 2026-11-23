// 124 나라의 숫자
// 124 나라가 있습니다. 124 나라에서는 10진법이 아닌 다음과 같은 자신들만의 규칙으로 수를 표현합니다.
// 1. 124 나라에는 자연수만 존재합니다.
// 2. 124 나라에는 모든 수를 표현할 때 1, 2, 4만 사용합니다.
// 예를 들어서 124 나라에서 사용하는 숫자는 다음과 같이 변환됩니다.
// 10진법    124 나라 숫자
//     1          1
//     2          2
//     3          4
//     4         11
//     5         12
//     6         14
//     7         21
//     8         22
//     9         24
//    10         41
// 자연수 n이 매개변수로 주어질 때, n을 124 나라에서 사용하는 숫자로 바꾼 값을 return 하도록 solution 함수를 완성해 주세요.

// 제한사항
// - n은 50,000,000 이하의 자연수입니다.

// 입출력 예
// n    result
// 1      1
// 2      2
// 3      4
// 4      11
// 입출력 예 설명
// 예제 1
// 1은 124 나라에서 1로 표현됩니다.
// 예제 2
// 2는 124 나라에서 2로 표현됩니다.
// 예제 3
// 3은 124 나라에서 4로 표현됩니다.
// 예제 4
// 4는 124 나라에서 11로 표현됩니다.

// Number of the 124 Country
// There is a country called 124. In this country, numbers are represented using their own rules instead of the decimal system.
// 1. Only natural numbers exist in country 124.
// 2. Only the digits 1, 2, and 4 are used to represent numbers.
// For example, decimal numbers are converted into the following numbers in country 124.
// Decimal   Country 124
//     1          1
//     2          2
//     3          4
//     4         11
//     5         12
//     6         14
//     7         21
//     8         22
//     9         24
//    10         41
// Given a natural number n, complete the solution function so that it returns the representation of n in the number system used by country 124.

// Constraints
// - n is a natural number less than or equal to 50,000,000.

// Input/Output Examples
// n    result
// 1      1
// 2      2
// 3      4
// 4      11
// Example Explanation
// Example 1
// 1 is represented as 1 in country 124.
// Example 2
// 2 is represented as 2 in country 124.
// Example 3
// 3 is represented as 4 in country 124.
// Example 4
// 4 is represented as 11 in country 124.

public class Ex072_Number124 {

    public static void main(String[] args) {
        System.out.println(solution(1)); 
        System.out.println(solution(2));  
        System.out.println(solution(3));  
        System.out.println(solution(4)); 
    }

     public static String solution(int n) {
        StringBuilder result = new StringBuilder();

        // n이 0보다 큰 동안 반복하며 각 자릿수를 계산한다. # Repeat while n is greater than 0 to calculate each digit.
        while (n > 0) {

            // n을 3으로 나눈 나머지에 따라 현재 자릿수를 결정한다. # Determine the current digit based on the remainder when n is divided by 3.
            switch (n % 3) {
                case 0 -> {
                    // 나머지가 0이면 현재 자릿수에 4를 추가한다. # If the remainder is 0, append 4 as the current digit.
                    result.append(4);

                    // 다음 자릿수를 계산하기 위해 몫에서 1을 뺀다. # Subtract 1 from the quotient to calculate the next digit.
                    n = n / 3 - 1;
                }
                case 1 -> {
                    // 나머지가 1이면 현재 자릿수에 1을 추가한다. # If the remainder is 1, append 1 as the current digit.
                    result.append(1);

                    // 다음 자릿수를 계산하기 위해 몫을 사용한다. # Use the quotient to calculate the next digit.
                    n = n / 3;
                }
                default -> {
                    // 나머지가 2이면 현재 자릿수에 2를 추가한다. # If the remainder is 2, append 2 as the current digit.
                    result.append(2);

                    // 다음 자릿수를 계산하기 위해 몫을 사용한다. # Use the quotient to calculate the next digit.
                    n = n / 3;
                }
            }
        }

        // 낮은 자릿수부터 저장된 결과를 뒤집어 문자열로 반환한다. # Reverse the digits stored from the lowest place and return the result as a string.
        return result.reverse().toString();
    }
}