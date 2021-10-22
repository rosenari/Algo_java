package Sort;

import java.util.*;

public class Solution_가장큰수 {
    public String solution(int[] numbers) {
        Integer[] nums = Arrays.stream(numbers).mapToObj(i->i).toArray(Integer[]::new);
        Arrays.sort(nums, new Comparator<Integer>(){
            public int compare(Integer o1,Integer o2){
                return Integer.parseInt(o2 + "" + o1) - Integer.parseInt(o1 + "" + o2);
            }
        });
        if(Arrays.stream(nums).allMatch(num -> num == 0)) return "0";
        
        return String.join("",Arrays.stream(nums).map(i -> i+"").toArray(String[]::new)) + "";
    }
}
