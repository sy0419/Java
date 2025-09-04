// 최대 5명씩 탑승가능한 놀이기구를 타기 위해 줄을 서있는 사람들의 이름이 담긴 문자열 리스트 names가 주어질 때, 
// 앞에서 부터 5명씩 묶은 그룹의 가장 앞에 서있는 사람들의 이름을 담은 리스트를 return하도록 solution 함수를 완성해주세요. 
// 마지막 그룹이 5명이 되지 않더라도 가장 앞에 있는 사람의 이름을 포함합니다.

// 제한사항
// 5 ≤ names의 길이 ≤ 30
// 1 ≤ names의 원소의 길이 ≤ 10
// names의 원소는 영어 알파벳 소문자로만 이루어져 있습니다.

import java.util.ArrayList;
import java.util.Arrays;

public class Ex065_groupOfFive {
    public static void main(String[] args) {
        // 테스트 케이스 출력 # Print test case
        System.out.println(Arrays.toString(solution(new String[] {"nami", "ahri", "jayce", "garen", "ivern", "vex", "jinx"})));
    }

    public static String[] solution(String[] names){
        ArrayList<String> nameList = new ArrayList(); // 결과를 담을 리스트 생성 # Create list to store result

        for (int i = 0; i < names.length; i++) {
            if(i % 5 == 0) {
                nameList.add(names[i]); // 5명 단위의 첫 번째 사람 추가 # Add the first person of each group of 5
            }
        }

        String[] frontNames = new String[nameList.size()]; // 최종 결과 배열 생성 # Create result array
        for (int i = 0; i < nameList.size(); i++) {
            frontNames[i] = nameList.get(i); // 리스트 값을 배열에 복사 # Copy values from list to array
        }

        return frontNames; // 결과 배열 반환 # Return the result array
    }
}