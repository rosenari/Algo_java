package Queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_문제추천시스템1 {
    static int N,M;
    static HashMap<Integer,int[]> hmap;
    static PriorityQueue<int[]> EasyQueue,HardQueue;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HardQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o2[1] - o1[1] == 0){
                    return o2[0] - o1[0];
                }
                return o2[1] - o1[1];
            }
        });
        EasyQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] - o2[1] == 0){
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });
        hmap = new HashMap<>(); 
        StringTokenizer st;
        N = Integer.parseInt(br.readLine().trim());
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine().trim());
            int P = Integer.parseInt(st.nextToken()); 
            int L = Integer.parseInt(st.nextToken());
            add(P, L);
        }
        M = Integer.parseInt(br.readLine().trim());
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine().trim());
            String op = st.nextToken();
            if(op.equals("add")){
                int P = Integer.parseInt(st.nextToken());
                int L = Integer.parseInt(st.nextToken());
                add(P, L);
            }else if(op.equals("recommend")){
                int priority = Integer.parseInt(st.nextToken());
                System.out.println(recommend(priority));
            }else{
                int P = Integer.parseInt(st.nextToken());
                solved(P);
            }
        }
    }

    static void add(int P, int L){
        HardQueue.offer(new int[]{P, L});
        EasyQueue.offer(new int[]{P, L});

        int[] data = hmap.get(P);
        if(data == null) hmap.put(P, new int[]{1, L});
        else hmap.put(P, new int[]{data[0] + 1, data[1]});
    }

    static void solved(int P){
        int[] data = hmap.get(P);
        if(data[0] == 1) hmap.remove(P);
        else hmap.put(P,new int[]{data[0] - 1, data[1]});
    }

    static int recommend(int op) {
        if(op == 1){
            return peek(HardQueue);
        }else{
            return peek(EasyQueue);
        }
    }
    static int peek(PriorityQueue<int[]> pque){
        int res = 0;
        while(true){
            int[] top = pque.peek();
            int[] data = hmap.get(top[0]);
            if(data == null || top[1] != data[1]){
                pque.poll();
                continue;
            }
            res = top[0];
            break;
        }
        return res;
    }
}
