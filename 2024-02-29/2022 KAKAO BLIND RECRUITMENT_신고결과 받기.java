/**
Q: 2024-03-04 MON
게시판 불량 이용자 신고 시스템
각 사용자가 신고한 사용자를 저장하고, 사용자가 신고된 횟수를 저장한 후, 
각 사용자가 메일을 받은 횟수를 계산하는 과정
*/

import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
      // 각 사용자가 신고한 횟수를 저장하는 배열
        int[] answer = new int[id_list.length];

      // 유저를 신고하는 횟수를 저장하는 Map
        Map<String, Integer> reportMap = new HashMap<>();

      // 유저가 신고한 사람들을 저장하는 Map
        Map<String, Set<String>> userMap = new HashMap<>();

      // report 배열을 순회하면서 userMap에 유저와 그가 신고한 사람들을 저장
      // userMap의 키는 사용자의 이름, 값은 사용자가 신고한 사용자의 집합
        for (String r : report) {
            String[] split = r.split(" ");
            String user = split[0];
            String reportedUser = split[1];
            userMap.putIfAbsent(user, new HashSet<>());
            userMap.get(user).add(reportedUser);
        }

      // userMap을 순회하면서 reportMap에 신고받은 횟수를 저장
      // reportMap의 키는 사용자의 이름, 값은 사용자가 신고된 횟수
        for (String user : userMap.keySet()) {
            for (String reportedUser : userMap.get(user)) {
                reportMap.put(reportedUser, reportMap.getOrDefault(reportedUser, 0) + 1);
            }
        }

      // id_list를 순회하면서 answer 배열에 메일을 받은 횟수를 저장
      // 사용자가 신고한 사용자 중에서 k번 이상 신고된 사용자가 있으면, 해당 사용자는 메일을 받게 됨
      // 이 배열의 i번째 원소는 id_list의 i번째 사용자가 메일을 받은 횟수
        for (int i = 0; i < id_list.length; i++) {
            for (String reportedUser : userMap.getOrDefault(id_list[i], new HashSet<>())) {
                if (reportMap.getOrDefault(reportedUser, 0) >= k) {
                    answer[i]++;
                }
            }
        }

      // 결과 반환
        return answer;
    }
}
