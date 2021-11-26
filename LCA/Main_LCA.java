package LCA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_LCA {
    static ArrayList<Integer>[] tree;
    static int[] depth;
    static int[] parent;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine().trim());
        tree = new ArrayList[N + 1];
        depth = new int[N + 1];
        parent = new int[N + 1];
        v = new boolean[N + 1];
        for(int i=1; i <= N; i++){
            tree[i] = new ArrayList<>();
        }
        
        for(int i=0; i < N - 1; i++){
            st = new StringTokenizer(br.readLine().trim());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            tree[from].add(to);
            tree[to].add(from);
        }

        DFS(1, 0, 0);

        int M = Integer.parseInt(br.readLine().trim());
        for(int i=0;i < M; i++){
            st = new StringTokenizer(br.readLine().trim());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(LCA(a, b));
        }
    }

    static boolean[] v;
    static void DFS(int current, int p, int d){
        v[current] = true;
        depth[current] = d;
        parent[current] = p;

        for(Integer node : tree[current]){
            if(v[node]) continue;
            DFS(node, current, d + 1);   
        }
    }

    static int LCA(int a, int b){
        int depthA = depth[a];
        int depthB = depth[b];
        while(depthA > depthB){
            a = parent[a];
            depthA--;
        }
        while(depthA < depthB){
            b = parent[b];
            depthB--;
        }
        while(a!=b){
            a = parent[a];
            b = parent[b];
        }
        return a;
    }
}
