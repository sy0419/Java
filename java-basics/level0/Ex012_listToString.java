/* 문자들이 담겨있는 배열 arr가 주어집니다. arr의 원소들을 순서대로 이어 붙인 문자열을 return 하는 solution함수를 작성해 주세요.
   제한사항) 1 ≤ arr의 길이 ≤ 200 , arr의 원소는 전부 알파벳 소문자로 이루어진 길이가 1인 문자열입니다. */

public class Ex012_listToString {
    public static void main(String[] args) {
        System.out.println(solution(new String[] {"a", "b", "c"}));
        System.out.println(solution2(new String[] {"a", "b", "c"}));
    }

    public static String solution(String[] arr) {
        String result = "";
        for (int i = 0; i < arr.length; i++) {
            result += arr[i];
        }
        return result;
    }

    public static String solution2(String[] arr) {
        String result = "";
        for (String arr1 : arr) {
            result += arr1;
        }
        return result;
    }
}

/* for (int i = 0; i < arr.length; i++)
 * This is a basic for loop that uses 'i' as an index to access each element in the array 'arr'.
 * It accesses the array elements directly using arr[i].
 * 기본적인 for 반복문, i를 인덱스로 사용해서 배열 arr의 각 요소에 접근하고 있다.
 * arr[i]로 배열의 각 원소에 직접 접근하고 있다.
 */

/* for (String arr1 : arr)
 * "Take each element from the array arr, assign it to the variable arr1, and repeat the loop using that value."
 * This is an enhanced for loop (also known as a for-each loop).
 * This approach allows you to automatically retrieve each element from the array one by one.
 * Instead of using an index to access the array, the variable 'arr1' directly represents each element in the array as the loop runs.
 * "배열 arr에 있는 원소를 하나씩 꺼내서 arr1이라는 변수에 넣고, 그걸로 반복해라."
 * 두 번째 코드는 향상된 for 문(또는 for-each 문)을 사용하고 있다. 이 방식은 배열의 원소를 하나씩 자동으로 꺼내서 사용할 수 있다.
 * arr1이라는 변수를 사용해서 arr 배열의 각 원소에 직접 접근하는 대신, 배열의 각 원소를 자동으로 반복문에서 가져와서 처리한다.
 */

/* for-each 문이란?
 * A for-each loop is a way to sequentially access all elements of an array or collection without using an index.
 * Using a for-each loop makes the code more concise and easier to read.
 * A for-each loop is very useful when you only need to read the elements of an array in order, but if you need to use the index or modify the array, a regular for loop is a better choice.
 * for-each 문은 배열이나 컬렉션의 모든 원소를 순차적으로 접근할 수 있는 방법으로, 반복문에서 인덱스를 사용하지 않고 배열의 각 원소를 하나씩 가져올 수 있다.
 * for-each 문을 사용하면 코드가 더 간결하고 읽기 쉽다.
 * for-each 문은 배열의 원소를 순차적으로 읽을 때 매우 유용하지만, 만약 인덱스를 사용하거나 배열을 수정해야 한다면 일반 for 문을 사용하는 게 더 좋을 수 있다.
 */