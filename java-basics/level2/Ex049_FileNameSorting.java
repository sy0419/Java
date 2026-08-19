// 파일명 정렬
// 세 차례의 코딩 테스트와 두 차례의 면접이라는 기나긴 블라인드 공채를 무사히 통과해 카카오에 입사한 무지는 
// 파일 저장소 서버 관리를 맡게 되었다.
// 저장소 서버에는 프로그램의 과거 버전을 모두 담고 있어, 이름 순으로 정렬된 파일 목록은 보기가 불편했다. 
// 파일을 이름 순으로 정렬하면 나중에 만들어진 ver-10.zip이 ver-9.zip보다 먼저 표시되기 때문이다.
// 버전 번호 외에도 숫자가 포함된 파일 목록은 여러 면에서 관리하기 불편했다. 
// 예컨대 파일 목록이 ["img12.png", "img10.png", "img2.png", "img1.png"]일 경우, 
// 일반적인 정렬은 ["img1.png", "img10.png", "img12.png", "img2.png"] 순이 되지만, 
// 숫자 순으로 정렬된 ["img1.png", "img2.png", "img10.png", img12.png"] 순이 훨씬 자연스럽다.

// 무지는 단순한 문자 코드 순이 아닌, 파일명에 포함된 숫자를 반영한 정렬 기능을 저장소 관리 프로그램에 구현하기로 했다.
// 소스 파일 저장소에 저장된 파일명은 100 글자 이내로, 
// 영문 대소문자, 숫자, 공백(" "), 마침표("."), 빼기 부호("-")만으로 이루어져 있다. 
// 파일명은 영문자로 시작하며, 숫자를 하나 이상 포함하고 있다.
// 파일명은 크게 HEAD, NUMBER, TAIL의 세 부분으로 구성된다.
// HEAD는 숫자가 아닌 문자로 이루어져 있으며, 최소한 한 글자 이상이다.
// NUMBER는 한 글자에서 최대 다섯 글자 사이의 연속된 숫자로 이루어져 있으며, 앞쪽에 0이 올 수 있다. 
// 0부터 99999 사이의 숫자로, 00000이나 0101 등도 가능하다.
// TAIL은 그 나머지 부분으로, 여기에는 숫자가 다시 나타날 수도 있으며, 아무 글자도 없을 수 있다.

//      파일명	      HEAD	  NUMBER	   TAIL
//     foo9.txt	      foo	    9	      .txt
// foo010bar020.zip	  foo	   010	    bar020.zip
//      F-15	      F-	   15	    (빈 문자열)

// 파일명을 세 부분으로 나눈 후, 다음 기준에 따라 파일명을 정렬한다.
// 파일명은 우선 HEAD 부분을 기준으로 사전 순으로 정렬한다. 이때, 문자열 비교 시 대소문자 구분을 하지 않는다. 
// MUZI와 muzi, MuZi는 정렬 시에 같은 순서로 취급된다.
// 파일명의 HEAD 부분이 대소문자 차이 외에는 같을 경우, NUMBER의 숫자 순으로 정렬한다. 
// 9 < 10 < 0011 < 012 < 13 < 014 순으로 정렬된다. 
// 숫자 앞의 0은 무시되며, 012와 12는 정렬 시에 같은 같은 값으로 처리된다.
// 두 파일의 HEAD 부분과, NUMBER의 숫자도 같을 경우, 원래 입력에 주어진 순서를 유지한다. 
// MUZI01.zip과 muzi1.png가 입력으로 들어오면, 정렬 후에도 입력 시 주어진 두 파일의 순서가 바뀌어서는 안 된다.
// 무지를 도와 파일명 정렬 프로그램을 구현하라.

// 입력 형식
// 입력으로 배열 files가 주어진다.
// files는 1000 개 이하의 파일명을 포함하는 문자열 배열이다.
// 각 파일명은 100 글자 이하 길이로, 영문 대소문자, 숫자, 공백(" "), 마침표("."), 빼기 부호("-")만으로 이루어져 있다. 
// 파일명은 영문자로 시작하며, 숫자를 하나 이상 포함하고 있다.
// 중복된 파일명은 없으나, 대소문자나 숫자 앞부분의 0 차이가 있는 경우는 함께 주어질 수 있다. 
// (muzi1.txt, MUZI1.txt, muzi001.txt, muzi1.TXT는 함께 입력으로 주어질 수 있다.)

// 출력 형식
// 위 기준에 따라 정렬된 배열을 출력한다.
// 입출력 예제
// 입력: ["img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"]
// 출력: ["img1.png", "IMG01.GIF", "img02.png", "img2.JPG", "img10.png", "img12.png"]
// 입력: ["F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"]
// 출력: ["A-10 Thunderbolt II", "B-50 Superfortress", "F-5 Freedom Fighter", "F-14 Tomcat"]

// File Name Sorting
// After successfully passing three coding tests and two interviews in a long blind recruitment process, 
// Muzi joined Kakao and was assigned to manage a file storage server.
// The storage server contains all past versions of programs, so the file list sorted by name was difficult to read.
//  If the files are sorted by name, the later-created ver-10.zip appears before ver-9.zip.
// File lists containing numbers were also inconvenient to manage in many ways. 
// For example, if the file list is ["img12.png", "img10.png", "img2.png", "img1.png"], 
// a normal sort results in ["img1.png", "img10.png", "img12.png", "img2.png"], 
// but the numerically sorted order ["img1.png", "img2.png", "img10.png", "img12.png"] is much more natural.

// Muzi decided to implement a file sorting feature that reflects the numbers contained in file names 
// rather than simply sorting by character code.
// Each file name stored in the source file repository is at most 100 characters long 
// and consists only of uppercase and lowercase English letters, digits, spaces (" "), periods ("."), 
// and hyphens ("-"). Each file name starts with an English letter and contains at least one digit.
// A file name consists of three parts: HEAD, NUMBER, and TAIL.
// HEAD consists of non-digit characters and contains at least one character.
// NUMBER consists of consecutive digits from one to five characters, and may have leading zeros. 
// It represents a number between 0 and 99999, and values such as 00000 and 0101 are allowed.
// TAIL is the remaining part of the file name. It may contain digits again, and it may also be empty.

//     File Name	  HEAD	  NUMBER	   TAIL
//     foo9.txt	      foo	    9	       .txt
// foo010bar020.zip	  foo	   010	     bar020.zip
//      F-15	      F-	   15	   (empty string)

// After dividing the file names into three parts, sort the file names according to the following criteria.
// First, sort the file names lexicographically based on the HEAD part. 
// When comparing strings, uppercase and lowercase letters are treated as the same. 
// MUZI, muzi, and MuZi are considered to be in the same order when sorting.
// If the HEAD parts are the same except for differences in letter case, sort them by the numerical value of NUMBER.
//  The order is 9 < 10 < 0011 < 012 < 13 < 014. Leading zeros are ignored, 
// so 012 and 12 are treated as the same value when sorting.
// If both the HEAD and the numerical value of NUMBER are the same, maintain the original input order. 
// If MUZI01.zip and muzi1.png are given as input, their order must remain unchanged after sorting.
// Help Muzi implement the file name sorting program.

// Input Format
// The input is given as an array files.
// files contains at most 1,000 file names.
// Each file name is at most 100 characters long and consists only of uppercase and lowercase English letters, 
// digits, spaces (" "), periods ("."), and hyphens ("-"). Each file name starts with an English letter 
// and contains at least one digit.
// There are no duplicate file names, 
// but files differing only in letter case or leading zeros in the number may be given together. 
// (muzi1.txt, MUZI1.txt, muzi001.txt, and muzi1.TXT may all be given together.)

// Output Format
// Return the array of file names sorted according to the above criteria.
// Examples
// Input: ["img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"]
// Output: ["img1.png", "IMG01.GIF", "img02.png", "img2.JPG", "img10.png", "img12.png"]
// Input: ["F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"]
// Output: ["A-10 Thunderbolt II", "B-50 Superfortress", "F-5 Freedom Fighter", "F-14 Tomcat"]

import java.util.*;

public class Ex049_FileNameSorting {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[] {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"})));
        System.out.println(Arrays.toString(solution(new String[] {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"})));
    }

    public static String[] solution(String[] files) {
        ArrayList<FileInfo> list = new ArrayList<>();

        // 파일명을 하나씩 확인한다. # Process each file name.
        for (String file : files) {
            int numStart = 0; // NUMBER의 시작 위치 # Start index of NUMBER
            int numEnd = file.length(); // NUMBER의 끝 위치, 기본값은 파일의 끝 # End index of NUMBER, defaulting to the end of the file

            // 첫 번째 숫자의 위치를 찾는다. # Find the position of the first digit.
            for (int i = 0; i < file.length(); i++) {
                if (Character.isDigit(file.charAt(i))) {
                    numStart = i;
                    break;
                }
            }

            // NUMBER가 끝나는 위치를 찾는다. # Find the position where NUMBER ends.
            for (int i = numStart; i < file.length(); i++) {
                if (!Character.isDigit(file.charAt(i))) {
                    numEnd = i;
                    break;
                }
            }

            // HEAD와 NUMBER를 추출한다. # Extract HEAD and NUMBER.
            String head = file.substring(0, numStart).toLowerCase();
            String number = file.substring(numStart, numEnd);

            // NUMBER를 정수로 변환한다. # Convert NUMBER to an integer.
            int num = Integer.parseInt(number);

            // 정렬에 필요한 정보를 FileInfo 객체로 저장한다. # Store the information needed for sorting in a FileInfo object.
            FileInfo info = new FileInfo(file, head, num);
            list.add(info);
        }

        // HEAD를 우선 비교하고, HEAD가 같으면 NUMBER를 비교한다. # Compare HEAD first, then NUMBER if HEADs are equal.
        list.sort((a, b) -> {
            int headComparison = a.head.compareTo(b.head);

            if (headComparison == 0) {
                return Integer.compare(a.number, b.number);
            }

            return headComparison;
        });

        // 정렬된 FileInfo에서 원본 파일명을 추출한다. # Extract original file names from the sorted FileInfo objects.
        String[] result = new String[list.size()];

        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i).file;
        }

        return result;
    }

    // 파일명과 정렬 기준인 HEAD, NUMBER를 저장한다. # Store the file name, HEAD, and NUMBER used for sorting.
    public static class FileInfo {
        String file;
        String head;
        int number;

        public FileInfo(String file, String head, int number) {
            this.file = file;
            this.head = head;
            this.number = number;
        }
    }
}