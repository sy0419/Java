// 오픈채팅방
// 카카오톡 오픈채팅방에서는 친구가 아닌 사람들과 대화를 할 수 있는데, 
// 본래 닉네임이 아닌 가상의 닉네임을 사용하여 채팅방에 들어갈 수 있다.
// 신입사원인 김크루는 카카오톡 오픈 채팅방을 개설한 사람을 위해, 다양한 사람들이 들어오고, 
// 나가는 것을 지켜볼 수 있는 관리자창을 만들기로 했다.
// 채팅방에 누군가 들어오면 다음 메시지가 출력된다.
// "[닉네임]님이 들어왔습니다."
// 채팅방에서 누군가 나가면 다음 메시지가 출력된다.
// "[닉네임]님이 나갔습니다."
// 채팅방에서 닉네임을 변경하는 방법은 다음과 같이 두 가지이다.
// 채팅방을 나간 후, 새로운 닉네임으로 다시 들어온다.
// 채팅방에서 닉네임을 변경한다.
// 닉네임을 변경할 때는 기존에 채팅방에 출력되어 있던 메시지의 닉네임도 전부 변경된다.

// 예를 들어, 채팅방에 "Muzi"와 "Prodo"라는 닉네임을 사용하는 사람이 순서대로 들어오면 채팅방에는 다음과 같이 메시지가 출력된다.
// "Muzi님이 들어왔습니다."
// "Prodo님이 들어왔습니다."
// 채팅방에 있던 사람이 나가면 채팅방에는 다음과 같이 메시지가 남는다.
// "Muzi님이 들어왔습니다."
// "Prodo님이 들어왔습니다."
// "Muzi님이 나갔습니다."
// Muzi가 나간후 다시 들어올 때, Prodo 라는 닉네임으로 들어올 경우 기존에 채팅방에 남아있던 Muzi도 Prodo로 다음과 같이 변경된다.
// "Prodo님이 들어왔습니다."
// "Prodo님이 들어왔습니다."
// "Prodo님이 나갔습니다."
// "Prodo님이 들어왔습니다."
// 채팅방은 중복 닉네임을 허용하기 때문에, 현재 채팅방에는 Prodo라는 닉네임을 사용하는 사람이 두 명이 있다.
// 이제, 채팅방에 두 번째로 들어왔던 Prodo가 Ryan으로 닉네임을 변경하면 채팅방 메시지는 다음과 같이 변경된다.
// "Prodo님이 들어왔습니다."
// "Ryan님이 들어왔습니다."
// "Prodo님이 나갔습니다."
// "Prodo님이 들어왔습니다."
// 채팅방에 들어오고 나가거나, 닉네임을 변경한 기록이 담긴 문자열 배열 record가 매개변수로 주어질 때,
// 모든 기록이 처리된 후, 최종적으로 방을 개설한 사람이 보게 되는 메시지를 문자열 배열 형태로 return 하도록 solution 함수를 완성하라.

// 제한사항
// record는 다음과 같은 문자열이 담긴 배열이며, 길이는 1 이상 100,000 이하이다.
// 다음은 record에 담긴 문자열에 대한 설명이다.
// 모든 유저는 [유저 아이디]로 구분한다.
// [유저 아이디] 사용자가 [닉네임]으로 채팅방에 입장 - "Enter [유저 아이디] [닉네임]" (ex. "Enter uid1234 Muzi")
// [유저 아이디] 사용자가 채팅방에서 퇴장 - "Leave [유저 아이디]" (ex. "Leave uid1234")
// [유저 아이디] 사용자가 닉네임을 [닉네임]으로 변경 - "Change [유저 아이디] [닉네임]" (ex. "Change uid1234 Muzi")
// 첫 단어는 Enter, Leave, Change 중 하나이다.
// 각 단어는 공백으로 구분되어 있으며, 알파벳 대문자, 소문자, 숫자로만 이루어져있다.
// 유저 아이디와 닉네임은 알파벳 대문자, 소문자를 구별한다.
// 유저 아이디와 닉네임의 길이는 1 이상 10 이하이다.
// 채팅방에서 나간 유저가 닉네임을 변경하는 등 잘못 된 입력은 주어지지 않는다.

// 입출력 예
// record	result
// ["Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"]
// ["Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."]

// Open Chat Room
// In KakaoTalk open chat rooms, people can have conversations with others who are not their friends 
// by entering the chat room with a virtual nickname instead of their real name.
// Kim Crew, a new employee, decided to create an administrator window for the person who created 
// the KakaoTalk open chat room, allowing them to monitor various people entering and leaving the room.
// When someone enters the chat room, the following message is displayed.
// "[Nickname]님이 들어왔습니다."
// When someone leaves the chat room, the following message is displayed.
// "[Nickname]님이 나갔습니다."
// There are two ways to change a nickname.
// The user leaves the chat room and enters again with a new nickname.
// The user changes their nickname while remaining in the chat room.
// When a nickname is changed, the nicknames in all previously displayed messages are also changed.

// For example, if users with the nicknames "Muzi" and "Prodo" enter the chat room in that order, 
// the following messages are displayed.
// "Enter Muzi"
// "Enter Prodo"
// If a person in the chat room leaves, the following messages remain.
// "Enter Muzi"
// "Enter Prodo"
// "Leave Muzi"
// If Muzi leaves and later enters again with the nickname Prodo, 
// the existing Muzi nickname in the chat room is also changed to Prodo.
// "Enter Prodo"
// "Enter Prodo"
// "Leave Prodo"
// "Enter Prodo"
// Since the chat room allows duplicate nicknames, there are now two people using the nickname Prodo.
// If the second Prodo who entered the chat room changes their nickname to Ryan, the messages become:
// "Enter Prodo."
// "Enter Ryan"
// "Leave Prodo"
// "Enter Prodo"
// Given a string array record containing records of users entering, leaving, or changing their nicknames,
// complete the solution function so that it returns the messages ultimately seen by the person who created the chat room after all records have been processed.

// Constraints
// record is a string array containing the records described below, and its length is between 1 and 100,000.
// Each record contains one of the following formats.
// Every user is identified by a [User ID].
// A [User ID] user enters the chat room with a [Nickname] - "Enter [User ID] [Nickname]" (e.g. "Enter uid1234 Muzi")
// A [User ID] user leaves the chat room - "Leave [User ID]" (e.g. "Leave uid1234")
// A [User ID] user changes their nickname to [Nickname] - "Change [User ID] [Nickname]" (e.g. "Change uid1234 Muzi")
// The first word is one of Enter, Leave, or Change.
// Each word is separated by a space and consists only of uppercase and lowercase English letters and digits.
// User IDs and nicknames are case-sensitive.
// User IDs and nicknames have a length between 1 and 10.
// Invalid input, such as a user changing their nickname after leaving the chat room, will not be given.

// Input/Output Example
// record	result
// ["Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"]
// ["Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."]

import java.util.*;

public class Ex050_OpenChatRoom {
    public static void main(String[] args) {
        String[] record = {
            "Enter uid1234 Muzi",
            "Enter uid4567 Prodo",
            "Leave uid1234",
            "Enter uid1234 Prodo",
            "Change uid4567 Ryan"
        };

        System.out.println(Arrays.toString(solution(record)));
    }

    public static String[] solution(String[] record) {
        // 사용자 ID와 최종 닉네임을 저장한다. # Store each user ID and their final nickname.
        Map<String, String> userList = new HashMap<>();

        // 최종 메시지를 저장한다. # Store the final chat messages.
        ArrayList<String> answer = new ArrayList<>();

        // 모든 기록을 확인하여 각 사용자의 최종 닉네임을 저장한다. # Find the final nickname of each user.
        for (String recordInfo : record) {
            // 하나의 기록을 공백 기준으로 나눈다. # Split each record by spaces.
            String[] parts = recordInfo.split(" ");

            // 기록의 행동, 사용자 ID를 가져온다. # Get the behavior and user ID.
            String behavior = parts[0];
            String userId = parts[1];

            // 입장 또는 닉네임 변경 시 최종 닉네임을 저장한다. # Store the nickname when entering or changing it.
            if (behavior.equals("Enter")) {
                String nickName = parts[2];
                userList.put(userId, nickName);
            } else if (behavior.equals("Change")) {
                String nickName = parts[2];
                userList.put(userId, nickName);
            }
        }

        // 기록을 다시 확인하여 실제 출력할 메시지를 만든다. # Process the records again to create the output messages.
        for (String recordInfo : record) {
            // 하나의 기록을 공백 기준으로 나눈다. # Split each record by spaces.
            String[] parts = recordInfo.split(" ");

            // 기록의 행동과 사용자 ID를 가져온다. # Get the behavior and user ID.
            String behavior = parts[0];
            String userId = parts[1];

            // 사용자 ID를 이용하여 최종 닉네임을 가져온다. # Get the final nickname using the user ID.
            String finalNickName = userList.get(userId);

            // 입장과 퇴장 기록만 메시지로 변환한다. # Convert only Enter and Leave records into messages.
            if (behavior.equals("Enter")) {
                answer.add(finalNickName + "님이 들어왔습니다.");
            } else if (behavior.equals("Leave")) {
                answer.add(finalNickName + "님이 나갔습니다.");
            }
        }

        // ArrayList에 저장된 결과를 문자열 배열로 변환한다. # Convert the ArrayList result into a String array.
        String[] result = new String[answer.size()];

        // ArrayList의 각 메시지를 배열에 저장한다. # Store each message in the array.
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }

        return result;
    }
}