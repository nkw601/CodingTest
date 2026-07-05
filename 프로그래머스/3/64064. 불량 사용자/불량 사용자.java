import java.util.*;

class Solution {

    Set<Set<String>> answer = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {

        dfs(0, new HashSet<>(), user_id, banned_id);

        return answer.size();
    }

    boolean isMatched(String user, String banned) {
        if (user.length() != banned.length()) {
            return false;
        }

        // b가 *이 아니고, u랑 b가 다르면 불량 아님
        for (int i = 0; i < user.length(); i++) {
            char u = user.charAt(i);
            char b = banned.charAt(i);

            if (b != '*' && u != b) {
                return false;
            }
        }

        return true;
    }

    void dfs(int idx, Set<String> visited, String[] user_id, String[] banned_id) {
        // 끝까지 다 왔음
        if (idx == banned_id.length) {
            // 중복 방지 -> set으로 만들어서 넣어주기
            answer.add(new HashSet<>(visited));
            return;
        }

        for (String user : user_id) {
            // 방문 확인
            if (visited.contains(user)) {
                continue;
            }

            // 불량 사용자 잡히는지 확인
            if (!isMatched(user, banned_id[idx])) {
                continue;
            }

            visited.add(user);
            dfs(idx + 1, visited, user_id, banned_id);
            visited.remove(user);
        }
    }
}