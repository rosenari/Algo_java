package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_DFSBFS{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] adjList = new ArrayList[N + 1];
        boolean[] v = new boolean[N + 1];
        for(int i=1;i<adjList.length;i++) adjList[i] = new ArrayList<Integer>();
        for(int i=0; i < M ; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjList[from].add(to);
            adjList[to].add(from);
        }
        for(int i=1;i<adjList.length;i++) Collections.sort(adjList[i]);
        DFS(adjList, v, V);
        System.out.println();
        Arrays.fill(v, false);
        BFS(adjList, v, V);
    }
    static void DFS(ArrayList<Integer>[] adjList, boolean[] v, int s){
        System.out.print(s+" ");
        v[s] = true;

        for(Integer d : adjList[s]){
            if(v[d]) continue;
            
            DFS(adjList, v, d);
        }
    }
    static void BFS(ArrayList<Integer>[] adjList, boolean[] v, int num) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(num);
        v[num] = true;

        while(!queue.isEmpty()){
            Integer s = queue.poll();
            System.out.print(s+" ");

            for(Integer d : adjList[s]){
                if(v[d]) continue;
                v[d] = true;
                queue.offer(d);
            }
        }
    }
}