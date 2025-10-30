// 각 기사는 자신의 기사 번호의 약수 개수에 해당하는 공격력을 가진 무기를 구매하려 합니다. 
// 단, 이웃나라와의 협약에 의해 공격력의 제한수치를 정하고, 제한수치보다 큰 공격력을 가진 기사가 사용할 무기를 정해야 합니다.
// # Each knight buys a weapon with attack power equal to the number of divisors of their number. 
// # If the attack power exceeds the limit set by a neighboring agreement, they use a fixed power instead.

// 예를 들어, 15번 기사단원은 15의 약수가 1, 3, 5, 15로 4개이므로 공격력이 4인 무기를 구매합니다.
// 제한이 3이고 power가 2라면, 4 > 3이므로 공격력 2 무기를 구매합니다.
// # For example, knight 15 has divisors 1, 3, 5, 15 → attack power 4. 
// # If limit is 3 and power is 2, he buys a weapon with power 2.

// 무기 제작에 필요한 철 1kg = 공격력 1
// # 1 kg of iron per attack power

// 기사단원의 수 number, 제한 limit, power가 주어질 때 총 철 무게 반환
// # Return total iron weight required for number of knights given limit and power

// 제한사항
// 1 ≤ number ≤ 100,000
// 2 ≤ limit ≤ 100
// 1 ≤ power ≤ limit

public class Ex051_KnightWeapon {
    public static void main(String[] args) {
        System.out.println(solution(5, 3, 2)); // # Test case 1
        System.out.println(solution(10, 3, 2)); // # Test case 2
    }

    public static int solution(int number, int limit, int power) {
        int total = 0; // 총 철 무게 합계 초기화 # Initialize total iron weight

        for (int i = 1; i <= number; i++) { // 1번 기사부터 number번 기사까지 반복 # Loop through each knight
            int count = 0; // 현재 기사의 공격력 계산용 # Count divisors for current knight

            for (int j = 1; j * j <= i; j++) { // 제곱근까지만 반복 # Only check divisors up to sqrt(i)
                if (i % j == 0) { // 나누어 떨어지면 약수 발견 # If j divides i
                    count += 2; // j와 i/j 두 개의 약수 # Count both j and i/j
                    if (j * j == i) { // 완전제곱수이면 중복 제거 # If i is a perfect square, decrement one
                        count--;
                    }
                }
            }

            if (count > limit) { // 제한 초과 시 power로 변경 # Use fixed power if count exceeds limit
                count = power;
            }

            total += count; // 공격력을 총합에 더함 # Add to total iron weight
        }

        return total; // 총 철 무게 반환 # Return total iron weight
    }
}