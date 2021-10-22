package Heap;

import java.util.*;

public class Solution_디스크컨트롤러 {
    public int solution(int[][] jobs) {
        int N = jobs.length;
        PriorityQueue<Job> readyqueue = new PriorityQueue<>(new Comparator<Job>(){
            public int compare(Job j1,Job j2){
                return j1.req - j2.req;
            }
        });
        PriorityQueue<Job> runqueue = new PriorityQueue<>(new Comparator<Job>(){
            public int compare(Job j1,Job j2){
                return j1.run - j2.run;
            }
        });
        for(int i=0;i<jobs.length;i++) readyqueue.offer(new Job(jobs[i][0],jobs[i][1]));
        
        int sum = 0;
        int endTime = 0;
        while(!readyqueue.isEmpty() || !runqueue.isEmpty()){
            Job job = readyqueue.peek();
            if(!readyqueue.isEmpty() && endTime >= job.req){
                runqueue.offer(readyqueue.poll());
            }else {
                if(!runqueue.isEmpty()){
                    Job runJob = runqueue.poll();
                    endTime = endTime + runJob.run;
                    int time = endTime - runJob.req;
                    sum += time;
                }else{
                    endTime = job.req;
                }
            }
        }
        return sum / N;
    }
    
    static class Job {
        int req;
        int run;
        Job(int req,int run){
            this.req = req;
            this.run = run;
        }
    }
}
