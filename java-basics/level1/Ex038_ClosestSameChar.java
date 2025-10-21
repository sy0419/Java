// 문자열 s가 주어졌을 때, s의 각 위치마다 자신보다 앞에 나왔으면서, 자신과 가장 가까운 곳에 있는 같은 글자가 어디 있는지 알고 싶습니다.
// 예를 들어, s="banana"라고 할 때,  각 글자들을 왼쪽부터 오른쪽으로 읽어 나가면서 다음과 같이 진행할 수 있습니다.
// b는 처음 나왔기 때문에 자신의 앞에 같은 글자가 없습니다. 이는 -1로 표현합니다.
// a는 처음 나왔기 때문에 자신의 앞에 같은 글자가 없습니다. 이는 -1로 표현합니다.
// n은 처음 나왔기 때문에 자신의 앞에 같은 글자가 없습니다. 이는 -1로 표현합니다.
// a는 자신보다 두 칸 앞에 a가 있습니다. 이는 2로 표현합니다.
// n도 자신보다 두 칸 앞에 n이 있습니다. 이는 2로 표현합니다.
// a는 자신보다 두 칸, 네 칸 앞에 a가 있습니다. 이 중 가까운 것은 두 칸 앞이고, 이는 2로 표현합니다.
// 따라서 최종 결과물은 [-1, -1, -1, 2, 2, 2]가 됩니다.
// 문자열 s이 주어질 때, 위와 같이 정의된 연산을 수행하는 함수 solution을 완성해주세요.

// 제한사항
// 1 ≤ s의 길이 ≤ 10,000
// s은 영어 소문자로만 이루어져 있습니다.

import java.util.Arrays;

public class Ex038_ClosestSameChar {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("banana"))); // 결과 출력 # Print result
        System.out.println(Arrays.toString(solution("foobar"))); // 결과 출력 # Print result
    }

    public static int[] solution(String s) {
        int[] result = new int[s.length()]; // 결과 저장 배열 생성 # Create array to store results
        int[] lastIndex = new int[26];      // 알파벳별 마지막 인덱스 저장 배열 # Store last index of each alphabet
        for (int i = 0; i < 26; i++) {
            lastIndex[i] = -1;               // 초기값 -1로 세팅 # Initialize all with -1
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);           // 현재 글자 가져오기 # Get current character
            int index = ch - 'a';            // 알파벳 인덱스 계산 # Calculate alphabet index (0~25)

            if (lastIndex[index] == -1) {   // 처음 나온 글자인지 확인 # Check if first occurrence
                result[i] = -1;              // 처음 나온 글자면 -1 저장 # Store -1 if first time
            } else {
                result[i] = i - lastIndex[index]; // 가장 가까운 같은 글자와 거리 계산 # Calculate distance to last occurrence
            }

            lastIndex[index] = i;            // 현재 글자의 인덱스로 마지막 위치 업데이트 # Update last index of current character
        }

        return result;                      // 결과 배열 반환 # Return result array
    }
}