// 길이가 같은 문자열 배열 my_strings와 이차원 정수 배열 parts가 매개변수로 주어집니다. 
// parts[i]는 [s, e] 형태로, my_string[i]의 인덱스 s부터 인덱스 e까지의 부분 문자열을 의미합니다. 
// 각 my_strings의 원소의 parts에 해당하는 부분 문자열을 순서대로 이어 붙인 문자열을 return 하는 solution 함수를 작성해 주세요.

// 제한사항
// 1 ≤ my_strings의 길이 = parts의 길이 ≤ 100
// 1 ≤ my_strings의 원소의 길이 ≤ 100
// parts[i]를 [s, e]라 할 때, 다음을 만족합니다.
// 0 ≤ s ≤ e < my_strings[i]의 길이

public class Ex041_connectPartsofString {
    public static void main(String[] args) {
        System.out.println(solution(new String[] {"progressive", "hamburger", "hammer", "ahocorasick"}, 
            new int[][] { {0, 4}, {1, 2}, {3, 5}, {7, 7} }));
    }

    public static String solution(String[] myString, int[][] parts) {
        StringBuilder sb = new StringBuilder();  
        // 결과 문자열을 효율적으로 만들기 위해 StringBuilder 사용
        // Use StringBuilder to efficiently build the result string

        for (int i = 0; i < myString.length; i++) {
            int start = parts[i][0];               
            // 부분 문자열의 시작 인덱스
            // Start index of the substring

            int end = parts[i][1];                 
            // 부분 문자열의 끝 인덱스
            // End index of the substring

            String sub = myString[i].substring(start, end + 1); 
            // start부터 end까지의 부분 문자열 추출 (end 인덱스 포함)
            // Extract substring from start to end (inclusive)

            sb.append(sub);                        
            // 추출한 부분 문자열을 결과 문자열에 추가
            // Append the extracted substring to the result
        }

        return sb.toString();                      
        // 완성된 문자열 반환
        // Return the completed string
    }
}