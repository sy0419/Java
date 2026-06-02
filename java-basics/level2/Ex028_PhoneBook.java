// 전화번호 목록

// 전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
// 전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.
// 구조대 : 119
// 박준영 : 97 674 223
// 지영석 : 11 9552 4421
// 전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때,
// 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.

// 제한 사항
// phone_book의 길이는 1 이상 1,000,000 이하입니다.
// 각 전화번호의 길이는 1 이상 20 이하입니다.
// 같은 전화번호가 중복해서 들어있지 않습니다.

// 입출력 예제
//            phone_book	              return
// ["119", "97674223", "1195524421"]	   false
//       ["123","456","789"]	           true
// ["12","123","1235","567","88"]	       false

// 입출력 예 설명
// 입출력 예 #1
// 앞에서 설명한 예와 같습니다.
// 입출력 예 #2
// 한 번호가 다른 번호의 접두사인 경우가 없으므로, 답은 true입니다.
// 입출력 예 #3
// 첫 번째 전화번호, “12”가 두 번째 전화번호 “123”의 접두사입니다. 따라서 답은 false입니다.

// Phone Book

// Check whether one phone number in the phone book is a prefix of another phone number.
// For example, in the following case, the emergency number is a prefix of Yeongseok's phone number.
// Emergency : 119
// Junyoung : 97 674 223
// Yeongseok : 11 9552 4421
// Given a string array phone_book containing phone numbers,
// return false if any number is a prefix of another number, otherwise return true.

// Constraints
// 1 ≤ phone_book.length ≤ 1,000,000
// 1 ≤ length of each phone number ≤ 20
// No duplicate phone numbers exist.

// Example Input / Output
//            phone_book	              return
// ["119", "97674223", "1195524421"]	   false
//       ["123","456","789"]	           true
// ["12","123","1235","567","88"]	       false

// Example Explanation
// Example #1
// Same as described above.
//
// Example #2
// No phone number is a prefix of another,
// therefore the result is true.
//
// Example #3
// The first phone number "12" is a prefix of the second phone number "123".
// Therefore, the result is false.

import java.util.Arrays;

public class Ex028_PhoneBook {
    public static void main(String[] args) {
        System.out.println(solution(new String[] {"119", "97674223", "1195524421"}));
        System.out.println(solution(new String[] {"123","456","789"}));
        System.out.println(solution(new String[] {"12","123","1235","567","88"}));
    }

    public static boolean solution(String[] phoneBook) {
        Arrays.sort(phoneBook); // 전화번호 정렬 # Sort phone numbers

        for (int i = 0; i < phoneBook.length - 1; i++) { // 마지막 전 번호까지만 비교 # Compare until the second last number
            if (phoneBook[i + 1].startsWith(phoneBook[i])) { // 다음 번호가 현재 번호로 시작하면 접두어 # Check prefix
                return false;
            }
        }

        return true;
    }
}