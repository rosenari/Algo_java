package Heap;

import java.util.*;

public class Solution_이중우선순위큐 {
    public int[] solution(String[] operations) {
        LinkedList<Integer> list = new LinkedList<>();
        for(String operation : operations){
            String[] op = operation.split(" ");
            String cmd = op[0];
            int num = Integer.parseInt(op[1]);
            if(cmd.equals("I")){
                list.offer(num);
                Collections.sort(list, new Comparator<Integer>(){
                    public int compare(Integer o1, Integer o2){
                        return o2 - o1;
                    }
                });
            }else{
                if(num == 1){
                    list.poll();
                }else {
                    list.pollLast();
                }
            }
        }
        if(list.size() == 0){
            return new int[]{0,0};
        }else{
            return new int[]{list.getFirst(),list.getLast()};
        }
    }
}
