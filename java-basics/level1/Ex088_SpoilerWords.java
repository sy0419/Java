// 중요한 단어를 스포 방지

// 카카오톡은 메시지의 일부를 가려두었다가, 클릭했을 때만 공개되는 스포 방지 기능을 제공합니다. 
// 이 기능을 활용하면 중요한 정보를 가리고 보낼 수 있습니다.

// 무지는 이 기능을 이용해 하나의 메시지 곳곳에 스포 방지 기능을 적용해 당신에게 보냈습니다. 
// 당신은 메시지 시작부터 왼쪽 → 오른쪽 순서로 스포 방지 구간을 하나씩 클릭해 공개되는 단어들 중, 
// 중요한 단어가 몇 개인지 확인하려 합니다.

// 단어 및 중요한 단어 규칙
// 단어는 공백으로 구분되며, 알파벳 소문자와 숫자로만 구성된 연속된 문자열입니다.
// 단어를 구성하는 문자들의 인덱스 중 하나 이상이 스포 방지 구간에 포함될 경우, 해당 단어는 스포일러 방지 단어로 간주합니다. 
// 즉, 단어 내 일부 문자에만 스포일러 방지 기능이 적용되더라도, 해당 단어 전체를 스포일러 방지 단어로 간주합니다.
// 한 단어가 여러 개의 스포 방지 구간에 걸쳐 있을 수 있으며, 하나의 스포 방지 구간에 여러 단어가 포함될 수 있습니다.
// 스포 방지 구간을 클릭해 단어의 모든 문자가 공개되었을 때, 그 단어가 아래 조건을 모두 만족하면 중요한 단어입니다.
// 스포 방지 단어여야 합니다.
// 메시지의 스포 방지 구간이 아닌 구간(= 어떤 스포 방지 구간에도 속하지 않는 모든 구간: 각 구간의 앞·사이·뒤 포함)에 
// 등장한 적이 없어야 합니다.
// 이전에 공개된 스포 방지 단어와 중복되지 않아야 합니다.
// 여러 단어가 동시에 공개된 경우, 왼쪽부터 순서대로 하나씩 중요한 단어인지 판단합니다.
// 무지가 당신에게 보내온 메시지를 나타내는 문자열 message와 스포 방지가 적용된 구간을 
// 나타내는 2차원 정수 배열 spoiler_ranges가 매개변수로 주어질 때, 
// 스포 방지 단어 중 중요한 단어의 수를 return 하도록 solution 함수를 완성해 주세요.

// 제한사항
// 1 ≤ message의 길이 ≤ 20,000
// message는 알파벳 소문자, 숫자 그리고 공백으로 이루어져 있습니다.
// message는 하나 이상의 단어로 구성된 문자열입니다.
// 공백은 연속해서 등장하지 않습니다.
// 1 ≤ spoiler_ranges의 길이 ≤ 1,000
// spoiler_ranges[i]는 [start, end] 형태로 스포 방지를 적용한 구간을 나타냅니다. 이때 start와 end는 문자 인덱스이며, 
// 두 인덱스 모두 구간에 포함됩니다.
// 0 ≤ start ≤ end < message의 길이
// 모든 구간은 서로 겹치지 않으며, start 기준으로 오름차순 정렬되어 주어집니다.

// 테스트 케이스 구성 안내
// 아래는 테스트 케이스 구성을 나타냅니다. 각 그룹은 하나 이상의 하위 그룹으로 이루어져 있으며, 
// 하위 그룹의 모든 테스트 케이스를 통과하면 해당 그룹에 할당된 점수를 획득할 수 있습니다.

// 그룹	총점	추가 제한 사항
// #1	7%	message의 모든 단어는 중복없이 한 번씩만 등장합니다.
// #2	13%	모든 스포 방지 구간은 각각 정확히 한 단어의 시작과 끝을 가리킵니다. spoiler_ranges의 길이 = 1
// #3	45%	모든 스포 방지 구간은 각각 정확히 한 단어의 시작과 끝을 가리킵니다.
// #4	35%	추가 제한 사항 없음

// 입출력 예
//                         message	                                              spoiler_ranges	            result
//          "here is muzi here is a secret message"	                         [[0, 3], [23, 28]]	              1
// "my phone number is 01012345678 and may i have your phone number"	[[5, 5], [25, 28], [34, 40], [53, 59]]	  4

// 입출력 예 설명
// 입출력 예 #1
// 첫 번째 스포 방지 구간을 해제하면 단어 here이 공개됩니다. here은 스포 방지 구간이 아닌 영역에서 등장한 적 있습니다. 
// 따라서 중요한 단어가 아닙니다.
// 두 번째 스포 방지 구간을 해제하면 단어 secret이 공개됩니다. secret은 중요한 단어입니다.
// 중요한 단어는 secret 하나뿐이므로 1을 return 해야 합니다.

// 입출력 예 #2
// 첫 번째 스포 구간을 해제하면 단어 phone이 공개됩니다. 
// 이 단어는 스포 방지 구간이 아닌 구간에서 등장한 적이 없고 이전에 공개된 스포 방지 단어와 중복되지 않으므로 중요한 단어입니다.
// 두 번째 스포 구간을 해제하면 단어 01012345678이 공개됩니다. 이 단어는 중요한 단어입니다.
// 세 번째 스포 구간을 해제하면 단어 may, i가 공개됩니다. 두 단어 모두 중요한 단어입니다.
// 마지막 스포 구간을 해제하면 phone, number이 공개됩니다. 
// 이 중 phone은 이전에 공개된 스포 방지 단어에 포함되어 있고 number은 스포 방지 구간이 아닌 영역에서 공개된 적이 있습니다. 
// 따라서 중요한 단어가 아닙니다.
// 스포 방지가 적용된 단어 중 중요한 단어는 phone, 01012345678, may, i 4개입니다. 따라서 4를 return 해야 합니다.

import java.util.HashSet;
import java.util.Set;

public class Ex088_SpoilerWords {
    public static void main(String[] args) {

        System.out.println(solution(
                "here is muzi here is a secret message",
                new int[][]{{0, 3}, {23, 28}}
        ));

        System.out.println(solution(
                "my phone number is 01012345678 and may i have your phone number",
                new int[][]{{5, 5}, {25, 28}, {34, 40}, {53, 59}}
        ));
    }

    public static int solution(String message, int[][] spoiler_ranges) {

        String[] words = message.split(" ");  // 단어 분리 (공백 기준)   # Split words by spaces

        // 문자 배열 변환 (인덱스 기준 스포 체크용)   # Convert to char array for index-based checks
        char[] cMsg = message.toCharArray();

        // 각 문자 위치가 스포 구간인지 표시   # Mark whether each character is in spoiler range
        boolean[] rangeArr = new boolean[cMsg.length];

        // 스포 구간을 boolean 배열에 표시   # Mark spoiler ranges in boolean array
        for (int[] r : spoiler_ranges) {
            for (int j = r[0]; j <= r[1]; j++) {
                rangeArr[j] = true;
            }
        }

        int wordIdx = 0;
        boolean isSpoiler = false;
       
        Set<String> spoiler = new HashSet<>();    // 스포 단어 집합   # Set of spoiler words

        Set<String> nonSpoiler = new HashSet<>();    // 평문에서 등장한 단어 집합   # Set of words seen in normal text

        // 메시지를 문자 단위로 순회   # Traverse message character by character
        for (int i = 0; i < cMsg.length; i++) {

            // 스포 구간 여부 체크   # Check if current char is in spoiler range
            if (cMsg[i] != ' ') {
                if (rangeArr[i]) {
                    isSpoiler = true;
                }
            }

            // 단어 끝 처리 (공백 or 마지막 문자)   # End of word (space or last char)
            if (cMsg[i] == ' ' || i == cMsg.length - 1) {

                String word = words[wordIdx];

                // 스포 단어로 분류   # classify as spoiler word
                if (isSpoiler) {
                    spoiler.add(word);
                } else {
                    nonSpoiler.add(word);
                }

                wordIdx++;
                isSpoiler = false;
            }
        }

        // 평문에서 등장한 단어 제거   # remove words that appeared in normal text
        for (String w : nonSpoiler) {
            spoiler.remove(w);
        }

        return spoiler.size();  // 최종 스포 단어 개수 반환   # return final count of valid spoiler words
    }
}