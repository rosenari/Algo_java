package Queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_N번째큰수 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine().trim());
        for(int i=0; i < N; i++){
            st = new StringTokenizer(br.readLine().trim());
            for(int j=0; j < N; j++){
                int num = Integer.parseInt(st.nextToken());
                if(queue.size() >= N){
                    if(queue.peek() < num){
                        queue.poll();
                        queue.offer(num);
                    }
                }else{
                    queue.offer(num);
                }
            }
        }
        System.out.println(queue.peek());
    }
}
