// 문자열로 구성된 리스트 strings와, 정수 n이 주어졌을 때, 각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬하려 합니다. 
// 예를 들어 strings가 ["sun", "bed", "car"]이고 n이 1이면 각 단어의 인덱스 1의 문자 "u", "e", "a"로 strings를 정렬합니다.

// 제한 조건
// strings는 길이 1 이상, 50이하인 배열입니다.
// strings의 원소는 소문자 알파벳으로 이루어져 있습니다.
// strings의 원소는 길이 1 이상, 100이하인 문자열입니다.
// 모든 strings의 원소의 길이는 n보다 큽니다.
// 인덱스 1의 문자가 같은 문자열이 여럿 일 경우, 사전순으로 앞선 문자열이 앞쪽에 위치합니다.

import java.util.Arrays;

public class Ex045_sortByNthChar {
    public static void main(String[] args) {
        // 테스트 케이스 출력 # print test cases
        System.out.println(Arrays.toString(solution(new String[] {"sun", "bed", "car"}, 1)));  
        System.out.println(Arrays.toString(solution(new String[] {"abce", "abcd", "cdx"}, 2)));
    }

    public static String[] solution(String[] strings, int n) {
        String[] result = new String[strings.length];  // 결과를 저장할 배열 생성 # create an array to store the sorted result

        // 각 문자열의 n번째 문자를 문자열 앞에 붙이기 # prepend the n-th character to each string
        for (int i = 0; i < strings.length; i++) {
            strings[i] = strings[i].charAt(n) + strings[i];  // 문자 + 문자열 결합으로 새로운 문자열 생성 # combine char and string to create a new string
        }

        Arrays.sort(strings);  // 문자열 전체를 사전순으로 정렬 # sort all modified strings in lexicographical order

        // 맨 앞의 문자 제거하여 원래 형태로 복원 # remove the prepended character to restore original form
        for (int i = 0; i < strings.length; i++) {
            result[i] = strings[i].substring(1);  // 첫 글자 제거 후 결과 배열에 저장 # remove first character and store in result array
        }

        return result;  // 최종 정렬 결과 반환 # return the final sorted array
    }
}