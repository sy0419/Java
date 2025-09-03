// 정수 리스트 num_list가 주어질 때, 첫 번째로 나오는 음수의 인덱스를 return하도록 solution 함수를 완성해주세요. 
// 음수가 없다면 -1을 return합니다.

// 제한사항
// 5 ≤ num_list의 길이 ≤ 100
// -10 ≤ num_list의 원소 ≤ 100

public class Ex056_theFirstNegativeNumberIndex {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {12, 4, 15, 46, 38, -2, 15}));
        System.out.println(solution(new int[] {13, 22, 53, 24, 15, 6}));
    }

    public static int solution(int[] numList){
        for (int i = 0; i < numList.length; i++) {  // numList의 모든 원소를 순회함  # Loop through all elements of numList
            if (numList[i] < 0) {                  // 음수를 만나면  # If a negative number is found
                return i;                          // 해당 인덱스를 반환  # Return its index
            }
        }
        return -1;  // 음수가 없는 경우 -1 반환  # Return -1 if no negative number is found
    }
}