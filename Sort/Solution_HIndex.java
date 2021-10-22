package Sort;

import java.util.*;

public class Solution_HIndex {
    public int solution(int[] citations) {
        Integer[] array = Arrays.stream(citations).mapToObj(i->i).toArray(Integer[]::new);
        Arrays.sort(array, Collections.reverseOrder());
        int max = array[0];
        for(int i = max; i >= 0 ; i--){
            final int h = i;
            long cnt = Arrays.stream(array).filter(num -> num >= h).count();
            if(cnt >= h) return h;
        }
        return 0;
    }
}