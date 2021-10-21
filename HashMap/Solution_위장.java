package HashMap;

import java.util.*;

public class Solution_위장 {
    public int solution(String[][] clothes) {
        Map<String,Integer> map = new HashMap<>();
        Arrays.stream(clothes).forEach(c ->{
            if(map.get(c[1]) == null) map.put(c[1], 1);
            else map.put(c[1], map.get(c[1]) + 1);
        });
        return map.values().stream().reduce(1, (total, num) -> total * (num + 1)) - 1;
    }
}
