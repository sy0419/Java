/* 문자열 my_string, overwrite_string과 정수 s가 주어집니다. 문자열 my_string의 인덱스 s부터 overwrite_string의 길이만큼을 문자열 overwrite_string으로 바꾼 문자열을 return 하는 solution 함수를 작성해 주세요.
   제한사항
   my_string와 overwrite_string은 숫자와 알파벳으로 이루어져 있습니다.
   1 ≤ overwrite_string의 길이 ≤ my_string의 길이 ≤ 1,000
   0 ≤ s ≤ my_string의 길이 - overwrite_string의 길이 */

public class Ex010_OverlappingString {
    public static void main(String[] args) {
        System.out.println(solution("He11oWor1d", "lloWorl", 2));
    }

    public static String solution(String str1, String str2, int s) {
        String partOne = str1.substring(0, s);
        String partTwo = str2;
        String partThree = str1.substring(s + str2.length());
        return partOne + partTwo + partThree;
    }
}

/* String partOne = str1.substring(0, s);
 * Extracts the part of str1 from the beginning up to (but not including) index s, and stores it in partOne. This is the portion before the overwrite starts.
 * str1에서 시작부터 s 전까지를 잘라서 partOne에 저장한다. 즉, 덮어쓰기 앞부분을 추출한 것이다.
 */

 /* String partTwo = str2;
  * Stores the overwrite string (str2) directly in partTwo. This is the string that will be inserted in the middle.
  * 덮어쓸 문자열인 str2를 그대로 partTwo에 넣는다. 즉, 중간에 끼워질 문자열이다.
  */

  /* String partThree = str1.substring(s + str2.length());
   * Extracts the remaining part of str1 after the overwrite. The starting index is s + str2.length(), which is right after the overwrite ends.
   * str1에서 덮어쓰고 남은 뒷부분을 잘라낸 것이다. 시작 인덱스는 s + str2.length()이다. (덮어쓰기 끝난 다음 인덱스)
   */