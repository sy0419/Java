// 새로 생긴 놀이기구는 인기가 매우 많아 줄이 끊이질 않습니다. 이 놀이기구의 원래 이용료는 price원 인데, 놀이기구를 N 번 째 이용한다면 원래 이용료의 N배를 받기로 하였습니다. 즉, 처음 이용료가 100이었다면 2번째에는 200, 3번째에는 300으로 요금이 인상됩니다.
// 놀이기구를 count번 타게 되면 현재 자신이 가지고 있는 금액에서 얼마가 모자라는지를 return 하도록 solution 함수를 완성하세요.
// 단, 금액이 부족하지 않으면 0을 return 하세요.

// 제한사항
// 놀이기구의 이용료 price : 1 ≤ price ≤ 2,500, price는 자연수
// 처음 가지고 있던 금액 money : 1 ≤ money ≤ 1,000,000,000, money는 자연수
// 놀이기구의 이용 횟수 count : 1 ≤ count ≤ 2,500, count는 자연수

public class Ex026_calculateShortfall {
    public static void main(String[] args) {
        System.out.println(solution1(3, 20, 4)); // 반복문 방식 # Loop-based
        System.out.println(solution2(3, 20, 4)); // 등차수열 공식 방식 # Arithmetic series formula
    }

    // 방법 1: 반복문으로 요금을 누적 계산 # Method 1: Loop to calculate total cost
    public static long solution1(int price, int money, int count) {
        long total = 0L; // 총 이용료 # Total cost
        for (int i = 1; i <= count; i++) {
            total += price * i; // i번째 이용 요금 추가 # Add cost for i-th ride
        }
        if (total > money) {
            return total - money; // 부족한 금액 반환 # Return shortfall
        }
        return 0; // 부족하지 않으면 0 반환 # Return 0 if no shortfall
    }

    // 방법 2: 등차수열 공식 사용 # Method 2: Use arithmetic series formula
    public static long solution2(int price, int money, int count) {
        return Math.max(price * (count * (count + 1) / 2) - money, 0); 
        // 계산된 총 요금 - 보유 금액 (부족하지 않으면 0) # Return max(shortfall, 0)
    }
}