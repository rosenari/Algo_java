package DFSBFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_숨박꼭질 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        if(N==K){
            System.out.println(0);
            return;
        }
        System.out.println(BFS(N, K));
    }   
    static int BFS(int start,int destination) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] v = new boolean[100001];
        v[start] = true;
        if(start > 0){
            v[start - 1] = true;
            queue.offer(new int[]{start - 1, 1});
        }
        if(start <= destination){
            v[start + 1] = true;
            queue.offer(new int[]{start + 1, 1});
            if(start * 2 < 100001){
                v[start * 2] = true;
                queue.offer(new int[]{start * 2, 1});
            }
        }
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            if(cur[0] == destination){
                return cur[1];
            }

            if(cur[0] > 0 && !v[cur[0] - 1]){
                v[cur[0] - 1] = true;
                queue.offer(new int[]{cur[0] - 1, cur[1] + 1});
            }
            if(cur[0] > destination) continue;
            if(!v[cur[0] + 1]){
                v[cur[0] + 1] = true;
                queue.offer(new int[]{cur[0] + 1, cur[1] + 1});
            }
            if(cur[0] * 2 >= 100001) continue;
            if(!v[cur[0] * 2]){
                v[cur[0] * 2] = true;
                queue.offer(new int[]{cur[0] * 2, cur[1] + 1});
            }
        }

        return -1;
    }
}