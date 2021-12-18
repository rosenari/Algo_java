package Queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_이중우선순위큐 {
    static int T,K;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());    
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        T = Integer.parseInt(br.readLine().trim());
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int t = 1; t <= T; t++){
            K = Integer.parseInt(br.readLine().trim());
            for(int k = 1; k <= K; k++){
                st = new StringTokenizer(br.readLine().trim());
                String op = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                if(op.equals("I")){
                    maxQueue.offer(num);
                    minQueue.offer(num);
                    if(map.get(num) == null) map.put(num, 1);
                    else map.put(num, map.get(num) + 1);
                }else{
                    if(map.isEmpty()) continue;
                    if(num == 1){
                        delete(maxQueue,map);
                    }else{
                        delete(minQueue,map);
                    }
                }
            }
            if(map.isEmpty()){
                sb.append("EMPTY").append("\n");
            }else{
                int res = delete(maxQueue,map);
                sb.append(res).append(" ");
                if(!map.isEmpty()) sb.append(delete(minQueue,map)).append("\n");
                else sb.append(res).append("\n");
            }
            minQueue.clear();
            maxQueue.clear();
            map.clear();
        }
        System.out.println(sb.toString());
    }

    static int delete(PriorityQueue<Integer> queue, HashMap<Integer,Integer> map){
        int res = 0;
        while(true){
            int n = queue.poll();
            int cnt = map.getOrDefault(n,0);
            if(cnt == 0) continue;
            if(cnt == 1) map.remove(n);
            else map.put(n, cnt - 1);
            res = n;
            break;
        }
        return res;
    }
}
