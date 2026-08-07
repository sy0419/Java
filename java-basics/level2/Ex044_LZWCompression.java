// 3차 압축
// 신입사원 어피치는 카카오톡으로 전송되는 메시지를 압축하여 전송 효율을 높이는 업무를 맡게 되었다. 
// 메시지를 압축하더라도 전달되는 정보가 바뀌어서는 안 되므로, 
// 압축 전의 정보를 완벽하게 복원 가능한 무손실 압축 알고리즘을 구현하기로 했다.

// 어피치는 여러 압축 알고리즘 중에서 성능이 좋고 구현이 간단한 LZW(Lempel–Ziv–Welch) 압축을 구현하기로 했다. 
// LZW 압축은 1983년 발표된 알고리즘으로, 이미지 파일 포맷인 GIF 등 다양한 응용에서 사용되었다.
// LZW 압축은 다음 과정을 거친다.
// 1. 길이가 1인 모든 단어를 포함하도록 사전을 초기화한다.
// 2. 사전에서 현재 입력과 일치하는 가장 긴 문자열 w를 찾는다.
// 3. w에 해당하는 사전의 색인 번호를 출력하고, 입력에서 w를 제거한다.
// 4. 입력에서 처리되지 않은 다음 글자가 남아있다면(c), w+c에 해당하는 단어를 사전에 등록한다.
// 5. 단계 2로 돌아간다.

// 압축 알고리즘이 영문 대문자만 처리한다고 할 때, 사전은 다음과 같이 초기화된다. 
// 사전의 색인 번호는 정수값으로 주어지며, 1부터 시작한다고 하자.
// 색인 번호	1	2	3	...	24	25	26
//   단어	    A   B	C	...	X	Y	Z

// 예를 들어 입력으로 KAKAO가 들어온다고 하자.
// 현재 사전에는 KAKAO의 첫 글자 K는 등록되어 있으나, 두 번째 글자까지인 KA는 없으므로, 
// 첫 글자 K에 해당하는 색인 번호 11을 출력하고, 다음 글자인 A를 포함한 KA를 사전에 27 번째로 등록한다.
// 두 번째 글자 A는 사전에 있으나, 세 번째 글자까지인 AK는 사전에 없으므로, A의 색인 번호 1을 출력하고, 
// AK를 사전에 28 번째로 등록한다.
// 세 번째 글자에서 시작하는 KA가 사전에 있으므로, KA에 해당하는 색인 번호 27을 출력하고, 
// 다음 글자 O를 포함한 KAO를 29 번째로 등록한다.
// 마지막으로 처리되지 않은 글자 O에 해당하는 색인 번호 15를 출력한다.
// 현재 입력(w)	다음 글자(c)	출력	사전 추가(w+c)
//     K	       A	       11	     27: KA
//     A	       K	       1	     28: AK
//     KA	       O	       27	     29: KAO
//     O		               15	
// 이 과정을 거쳐 다섯 글자의 문장 KAKAO가 4개의 색인 번호 [11, 1, 27, 15]로 압축된다.

// 입력으로 TOBEORNOTTOBEORTOBEORNOT가 들어오면 다음과 같이 압축이 진행된다.
// 현재 입력(w)	 다음 글자(c)	출력	사전 추가(w+c)
//     T	        O	       20	     27: TO
//     O	        B	       15	     28: OB
//     B	        E	       2	     29: BE
//     E	        O	       5	     30: EO
//     O	        R	       15	     31: OR
//     R	        N	       18	     32: RN
//     N	        O	       14	     33: NO
//     O	        T	       15	     34: OT
//     T	        T	       20	     35: TT
//     TO	        B	       27	     36: TOB
//     BE	        O	       29	     37: BEO
//     OR	        T	       31	     38: ORT
//     TOB	        E	       36	     39: TOBE
//     EO	        R	       30	     40: EOR
//     RN	        O	       32	     41: RNO
//     OT		               34	

// 입력 형식
// 입력으로 영문 대문자로만 이뤄진 문자열 msg가 주어진다. msg의 길이는 1 글자 이상, 1000 글자 이하이다.
// 출력 형식
// 주어진 문자열을 압축한 후의 사전 색인 번호를 배열로 출력하라.
// 입출력 예제
//          msg	                                          answer
//           KAKAO	                                 [11, 1, 27, 15]
// TOBEORNOTTOBEORTOBEORNOT    	[20, 15, 2, 5, 15, 18, 14, 15, 20, 27, 29, 31, 36, 30, 32, 34]
//     ABABABABABABABAB	                         [1, 2, 27, 29, 28, 31, 30]

// 3rd Compression
// Apeach, a new employee, is responsible for compressing messages sent through KakaoTalk to improve transmission efficiency.
// Even after compression, the information must not be changed, so Apeach decides to implement a lossless compression algorithm
// that can perfectly restore the original information.

// Among various compression algorithms, Apeach decides to implement LZW (Lempel–Ziv–Welch) compression,
// which provides good performance and is relatively simple to implement.
// LZW compression was introduced in 1983 and has been used in various applications,
// including the GIF image file format.
// LZW compression follows these steps.
// 1. Initialize the dictionary to contain all words of length 1.
// 2. Find the longest string w in the dictionary that matches the current input.
// 3. Output the dictionary index number corresponding to w and remove w from the input.
// 4. If there is a next unprocessed character c, add the word w+c to the dictionary.
// 5. Return to step 2.

// Assume that the compression algorithm only processes uppercase English letters.
// The dictionary is initialized as follows.
// Dictionary index numbers are integers starting from 1.
// Index number	1	2	3	...	24	25	26
// Word	        A	B	C	...	X	Y	Z

// For example, suppose the input is KAKAO.
// The first character K of KAKAO is already registered in the dictionary,
// but KA, which includes the second character, is not.
// Therefore, output the dictionary index number 11 for K,
// and register KA, including the next character A, as entry 27 in the dictionary.
// The second character A is already in the dictionary,
// but AK, which includes the third character, is not.
// Therefore, output the dictionary index number 1 for A,
// and register AK as entry 28 in the dictionary.
// KA, starting from the third character, is already in the dictionary.
// Therefore, output the dictionary index number 27 for KA,
// and register KAO, including the next character O, as entry 29 in the dictionary.
// Finally, output the dictionary index number 15 for the remaining character O.
// Current input (w)	Next character (c)	Output	Dictionary addition (w+c)
//         K	                A	          11	       27: KA
//         A	                K	          1	           28: AK
//         KA	                O	          27	       29: KAO
//         O		                          15

// Through this process, the five-character message KAKAO is compressed into four index numbers [11, 1, 27, 15].

// If the input is TOBEORNOTTOBEORTOBEORNOT, the compression proceeds as follows.
// Current input (w)	Next character (c)	Output	Dictionary addition (w+c)
//        T	                    O	          20	       27: TO
//        O	                    B	          15	       28: OB
//        B	                    E	          2	           29: BE
//        E	                    O	          5	           30: EO
//        O	                    R	          15	       31: OR
//        R	                    N             18	       32: RN
//        N	                    O	          14	       33: NO
//        O	                    T	          15	       34: OT
//        T	                    T	          20	       35: TT
//        TO	                B	          27	       36: TOB
//        BE	                O	          29	       37: BEO
//        OR	                T	          31	       38: ORT
//        TOB	                E	          36	       39: TOBE
//        EO	                R	          30	       40: EOR
//        RN	                O	          32	       41: RNO
//        OT		                          34	

// Input Format
// The input is a string msg consisting only of uppercase English letters.
// The length of msg is between 1 and 1,000 characters.

// Output Format
// Return an array containing the dictionary index numbers after compressing the given string.

// Examples
// msg	                                          answer
// KAKAO	                                 [11, 1, 27, 15]
// TOBEORNOTTOBEORTOBEORNOT	[20, 15, 2, 5, 15, 18, 14, 15, 20, 27, 29, 31, 36, 30, 32, 34]
// ABABABABABABABAB	                [1, 2, 27, 29, 28, 31, 30]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Ex044_LZWCompression {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("KAKAO")));
        System.out.println(Arrays.toString(solution("TOBEORNOTTOBEORTOBEORNOT")));
        System.out.println(Arrays.toString(solution("ABABABABABABABAB")));
    }

    public static int[] solution(String msg) {
        Map<String, Integer> dictionary = new HashMap<>();
        // 사전을 생성한다. # Create the dictionary.

        ArrayList<Integer> answer = new ArrayList<>();
        // 압축 결과를 저장한다. # Store the compression result.

        int dictionaryIndex = 27;
        // 새로운 사전 항목의 시작 번호를 설정한다. # Set the starting index for new dictionary entries.

        for (int i = 1; i <= 26; i++) {
            char alphabet = (char) ('A' + i - 1);
            dictionary.put(String.valueOf(alphabet), i);
        }
        // A부터 Z까지 1~26번으로 사전을 초기화한다. # Initialize the dictionary with A to Z using indices 1 to 26.

        String w = String.valueOf(msg.charAt(0));
        // 첫 번째 문자를 현재 문자열 w로 설정한다. # Set the first character as the current string w.

        for (int i = 1; i < msg.length(); i++) {
            char c = msg.charAt(i);
            // 다음 문자를 가져온다. # Get the next character.

            String wc = w + c;
            // 현재 문자열과 다음 문자를 연결한다. # Combine the current string with the next character.

            if (!dictionary.containsKey(wc)) {
                answer.add(dictionary.get(w));
                // w의 사전 번호를 결과에 추가한다. # Add the dictionary index of w to the result.

                dictionary.put(wc, dictionaryIndex);
                // 새로운 문자열 wc를 사전에 추가한다. # Add the new string wc to the dictionary.

                dictionaryIndex++;
                // 다음 사전 번호를 증가시킨다. # Increment the next dictionary index.

                w = String.valueOf(c);
                // 다음 탐색을 위해 c를 새로운 w로 설정한다. # Set c as the new w for the next search.
            } else {
                w = wc;
                // wc가 사전에 있으면 w를 wc로 확장한다. # Extend w to wc if wc exists in the dictionary.
            }
        }

        answer.add(dictionary.get(w));
        // 마지막으로 남은 w의 사전 번호를 결과에 추가한다. # Add the dictionary index of the remaining w to the result.

        int[] result = new int[answer.size()];
        // ArrayList의 크기만큼 결과 배열을 생성한다. # Create a result array with the size of the ArrayList.

        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
            // 압축 결과를 배열에 옮긴다. # Copy the compression results into the array.
        }

        return result;
        // 압축 결과를 반환한다. # Return the compression result.
    }
}