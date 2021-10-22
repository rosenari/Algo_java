package Greedy;

import java.util.*;

public class Solution_섬연결하기 {
    public int solution(int n, int[][] costs) {
        PriorityQueue<Edge> pque = new PriorityQueue<>(new Comparator<Edge>(){
            public int compare(Edge e1, Edge e2){
                return e1.weight - e2.weight;
            }
        });
        parent = new int[n];
        for(int i=0;i<parent.length;i++) parent[i] = i;
        for(int i=0;i<costs.length;i++){
            int from = costs[i][0];
            int to = costs[i][1];
            int weight = costs[i][2];
            pque.offer(new Edge(from,to,weight));
        }
        int answer = 0;
        int cnt = 0;
        while(!pque.isEmpty()){
            Edge edge = pque.poll();
            if(union(edge.from,edge.to)){
                answer += edge.weight;
                cnt++;
            }
            if(cnt == n-1){
                break;
            }
        }
        return answer;
    }
    static int[] parent;
    static int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    static boolean union(int x, int y){
        int px = find(x);
        int py = find(y);
        if(px == py) return false;
        parent[px] = py;
        return true;
    }
    static class Edge {
        int from;
        int to;
        int weight;
        Edge(int from, int to,int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
}
