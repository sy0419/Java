// 모음사전

// 사전에 알파벳 모음 'A', 'E', 'I', 'O', 'U'만을 사용하여 만들 수 있는, 길이 5 이하의 모든 단어가 수록되어 있습니다.
// 사전에서 첫 번째 단어는 "A"이고, 그다음은 "AA"이며, 마지막 단어는 "UUUUU"입니다.
// 단어 하나 word가 매개변수로 주어질 때, 이 단어가 사전에서 몇 번째 단어인지 return 하도록 solution 함수를 완성해주세요.

// 제한사항
// word의 길이는 1 이상 5 이하입니다.
// word는 알파벳 대문자 'A', 'E', 'I', 'O', 'U'로만 이루어져 있습니다.

// 입출력 예
//  word	 result
// "AAAAE"	   6
// "AAAE"	   10
//  "I" 	  1563
// "EIO"	  1189

// 입출력 예 설명
// 입출력 예 #1
// 사전에서 첫 번째 단어는 "A"이고, 그다음은 "AA", "AAA", "AAAA", "AAAAA", "AAAAE", ... 와 같습니다.
// "AAAAE"는 사전에서 6번째 단어입니다.
// 입출력 예 #2
// "AAAE"는 "A", "AA", "AAA", "AAAA", "AAAAA", "AAAAE", "AAAAI", "AAAAO", "AAAAU"의 다음인 10번째 단어입니다.
// 입출력 예 #3
// "I"는 1563번째 단어입니다.
// 입출력 예 #4
// "EIO"는 1189번째 단어입니다.


// Vowel Dictionary
//
// The dictionary contains all possible words of length 5 or less
// made using only the vowels 'A', 'E', 'I', 'O', 'U'.
// The first word in the dictionary is "A", followed by "AA",
// and the last word is "UUUUU".
// Given a word, complete the solution function so that it returns
// the position of the word in the dictionary.

// Constraints
// The length of word is between 1 and 5.
// word consists only of uppercase vowels: 'A', 'E', 'I', 'O', 'U'.

// Input/Output Examples
//  word	 result
// "AAAAE"	   6
// "AAAE"	   10
//  "I" 	  1563
// "EIO"	  1189

// Explanation of Examples
// Example #1
// The first word in the dictionary is "A",
// followed by "AA", "AAA", "AAAA", "AAAAA", "AAAAE", ... .
// "AAAAE" is the 6th word in the dictionary.
//
// Example #2
// "AAAE" comes after:
// "A", "AA", "AAA", "AAAA", "AAAAA", "AAAAE",
// "AAAAI", "AAAAO", "AAAAU".
// Therefore, it is the 10th word.
//
// Example #3
// "I" is the 1563rd word.
//
// Example #4
// "EIO" is the 1189th word.

public class Ex034_VowelDictionary {

    public static void main(String[] args) {
        System.out.println(solution("AAAAE"));
        System.out.println(solution("AAAE"));
        System.out.println(solution("I"));
        System.out.println(solution("EIO"));
    }

    public static int solution(String word) {
        // 결과 저장 변수 # Store final result
        int result = 0;

        // 최대 단어 길이 # Maximum word length
        int limitNum = 5;

        // 자리별 가중치 저장 배열 # Array to store positional weights
        int[] positionWeight = new int[5];

        // 각 자리의 가중치 계산 # Calculate positional weights
        for (int i = 0; i < limitNum; i++) {

            // 현재 자리 가중치 합 # Sum of current position weight
            int sum = 0;

            // 5의 거듭제곱 누적 # Accumulate powers of 5
            for (int j = 0; j < limitNum - i; j++) {
                sum += (int) Math.pow(5, j);
            }
            // 계산된 가중치 저장 # Store calculated weight
            positionWeight[i] = sum;
        }
        // 모음 순서 문자열 # String representing vowel order
        String vowels = "AEIOU";

        // 단어를 한 글자씩 탐색 # Traverse each character of the word
        for (int i = 0; i < word.length(); i++) {

            // 현재 문자 가져오기 # Get current character
            char ch = word.charAt(i);

            // 현재 문자의 모음 순서 찾기 # Find vowel index
            int idx = vowels.indexOf(ch);

            // (모음 인덱스 × 자리 가중치) + 자기 자신 포함 # (vowel index × position weight) + include current word
            result += idx * positionWeight[i] + 1;
        }

        return result;
    }
}