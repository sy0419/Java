// 카카오에 입사한 신입 개발자 네오는 "카카오계정개발팀"에 배치되어, 카카오 서비스에 가입하는 유저들의 아이디를 생성하는 업무를 담당하게 되었습니다.
// "네오"에게 주어진 첫 업무는 새로 가입하는 유저들이 카카오 아이디 규칙에 맞지 않는 아이디를 입력했을 때, 
// 입력된 아이디와 유사하면서 규칙에 맞는 아이디를 추천해주는 프로그램을 개발하는 것입니다.
// 다음은 카카오 아이디의 규칙입니다.

// 아이디의 길이는 3자 이상 15자 이하여야 합니다.
// 아이디는 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.) 문자만 사용할 수 있습니다.
// 단, 마침표(.)는 처음과 끝에 사용할 수 없으며 또한 연속으로 사용할 수 없습니다.
// "네오"는 다음과 같이 7단계의 순차적인 처리 과정을 통해 신규 유저가 입력한 아이디가 카카오 아이디 규칙에 맞는 지 검사하고
// 규칙에 맞지 않은 경우 규칙에 맞는 새로운 아이디를 추천해 주려고 합니다.

// [문제]
// 신규 유저가 입력한 아이디를 나타내는 new_id가 매개변수로 주어질 때, "네오"가 설계한 7단계의 처리 과정을 거친 후의 추천 아이디를 return 하도록 solution 함수를 완성해 주세요.

// [제한사항]
// new_id는 길이 1 이상 1,000 이하인 문자열입니다.
// new_id는 알파벳 대문자, 알파벳 소문자, 숫자, 특수문자로 구성되어 있습니다.
// new_id에 나타날 수 있는 특수문자는 -_.~!@#$%^&*()=+[{]}:?,<>/ 로 한정됩니다.

public class Ex075_NewIdRecommendation {
    public static void main(String[] args) {
        // 테스트 케이스 출력 # Print test cases
        System.out.println(solution("...!@BaT#*..y.abcdefghijklm"));
        System.out.println(solution("z-+.^."));
        System.out.println(solution("=.="));
        System.out.println(solution("123_.def"));
        System.out.println(solution("abcdefghijklmn.p"));
    }

    public static String solution(String newID) {
        // 1단계, 2단계, 3단계, 4단계 처리 # Steps 1-4: Lowercase, remove invalid chars, collapse dots, trim dots
        String editedID = newID.toLowerCase()                              // 1단계: 대문자를 소문자로 변경 # Step 1: Convert to lowercase
                       .replaceAll("[^a-z0-9-_.]", "")  // 2단계: 허용되지 않는 문자 제거 # Step 2: Remove invalid characters
                       .replaceAll("\\.{2,}", ".")      // 3단계: 연속된 점을 하나로 # Step 3: Replace multiple dots with one
                       .replaceAll("^\\.|\\.$", "");    // 4단계: 처음/끝 점 제거 # Step 4: Remove dot at start or end

        // 5단계: 빈 문자열이면 "a" 대입 # Step 5: If empty, set to "a"
        if (editedID.isEmpty()) {
            editedID = "a";
        }

        // 6단계: 길이 16 이상이면 15자까지 자르고 끝 점 제거 # Step 6: Trim to 15 chars and remove trailing dot
        if (editedID.length() >= 16) {
            editedID = editedID.substring(0, 15);       // 처음 15자까지 자름 # Keep first 15 characters
            editedID = editedID.replaceAll("\\.$", "");   // 마지막 점 제거 # Remove trailing dot
        }

        // 7단계: 길이가 2 이하이면 마지막 문자 반복 # Step 7: Repeat last character until length is 3
        while (editedID.length() < 3) {
            editedID += editedID.charAt(editedID.length() - 1);   // 마지막 문자 반복 # Append last character
        }

        return editedID;  // 최종 추천 아이디 반환 # Return final recommended ID
    }
}