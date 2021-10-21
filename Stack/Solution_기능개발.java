package Stack;

import java.util.*;

public class Solution_기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        Stack<Integer> answer = new Stack<>();
        int maxDay = 0;
        for(int i=0;i<progresses.length;i++){
            int day = (int)Math.ceil((double)(100 - progresses[i]) / speeds[i]);
            if(answer.size() == 0 || maxDay < day){
                maxDay = day;
                answer.push(1);
            } else{
                answer.push(answer.pop() + 1);
            }
        }
        return answer.stream().mapToInt(i->i).toArray();
    }
}
