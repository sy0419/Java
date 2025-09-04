// 오늘 해야 할 일이 담긴 문자열 배열 todo_list와 각각의 일을 지금 마쳤는지를 나타내는 boolean 배열 finished가 매개변수로 주어질 때, 
// todo_list에서 아직 마치지 못한 일들을 순서대로 담은 문자열 배열을 return 하는 solution 함수를 작성해 주세요.

// 제한사항
// 1 ≤ todo_list의 길이 1 ≤ 100
// 2 ≤ todo_list의 원소의 길이 ≤ 20
// todo_list의 원소는 영소문자로만 이루어져 있습니다.
// todo_list의 원소는 모두 서로 다릅니다.
// finished[i]는 true 또는 false이고 true는 todo_list[i]를 마쳤음을, false는 아직 마치지 못했음을 나타냅니다.
// 아직 마치지 못한 일이 적어도 하나 있습니다.

import java.util.ArrayList;
import java.util.Arrays;

public class Ex066_toDoList {
    public static void main(String[] args) {
        // 테스트 케이스 출력 # Print test case result
        System.out.println(Arrays.toString(solution(
            new String[] {"problemsolving", "practiceguitar", "swim", "studygraph"},
            new boolean[] {true, false, true, false}
        )));
    }

    public static String[] solution(String[] todoList, boolean[] finished){
        ArrayList<String> todoLists = new ArrayList<>();  // 아직 끝나지 않은 할 일 저장 # Store unfinished tasks

        for(int i = 0; i < todoList.length; i++) {
            if (finished[i] == false) {  // 완료되지 않은 항목만 확인 # Check if task is unfinished
                todoLists.add(todoList[i]);  // 리스트에 추가 # Add task to result list
            }
        }

        String[] todo = new String[todoLists.size()];  // 결과 배열 생성 # Create result array
        for (int i = 0; i < todoLists.size(); i++) {
            todo[i] = todoLists.get(i);  // 리스트에서 배열로 복사 # Copy from list to array
        }

        return todo;  // 결과 반환 # Return the result array
    }
}
