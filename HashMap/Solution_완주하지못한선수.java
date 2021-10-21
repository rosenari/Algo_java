package HashMap;

import java.util.*;

public class Solution_완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        Arrays.stream(completion).forEach(c -> {
            if(map.get(c) == null) map.put(c, 1);
            else map.put(c, map.get(c) + 1);
        });
        return Arrays.stream(participant).peek(p -> {
            if(map.get(p) == null) map.put(p, -1);
            else map.put(p, map.get(p) - 1);
        }).filter(p -> map.get(p) < 0).toArray(String[]::new)[0];
    }
}
