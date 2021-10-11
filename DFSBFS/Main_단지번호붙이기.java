package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_단지번호붙이기{
    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> answer = new PriorityQueue<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        char[][] map = new char[N][N];

        for(int i=0; i < N; i++) {
            map[i] = br.readLine().trim().toCharArray();
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j] == '1'){
                    answer.offer(DFS(i,j,map));
                }
            }
        }
        System.out.println(answer.size());
        while(!answer.isEmpty()) System.out.println(answer.poll());
    }
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    public static int DFS(int r, int c,char[][] map){
        map[r][c] = '0';
        int result = 1;

        for(int i=0;i<dr.length;i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(nr >=0 && nr < map.length && nc >=0 && nc < map.length && map[nr][nc] == '1') {
                result += DFS(nr,nc,map);
            }
        }

        return result;
    }
}