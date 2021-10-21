package Queue;

import java.util.*;

public class Solution_프린터 {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Job> queue = new LinkedList<>();
        for(int i=0;i<priorities.length;i++) queue.offer(new Job(i,priorities[i]));
        while(!queue.isEmpty()){
            Job current = queue.poll();
            if(queue.stream().anyMatch(job -> job.priority > current.priority)){
                queue.offer(current);
            }else{
                answer++;
                if(location == current.index) return answer;
            }
        }
        return answer;
    }
    
    static class Job{
        int index;
        int priority;
        Job(int index, int priority){
            this.index = index;
            this.priority = priority;
        }
    }
}
