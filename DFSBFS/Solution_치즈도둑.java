package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_치즈도둑 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine().trim());
        for(int t = 1; t <= T; t++){
            int answer = 0;
            int N = Integer.parseInt(br.readLine().trim());
            int[][] map = new int[N][N];
            boolean[][] v = new boolean[N][N];
            for(int i=0; i < N; i++){
                st = new StringTokenizer(br.readLine().trim());
                for(int j=0; j < N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int day = 0 ;day <= 100; day++){
                int cnt = 0;
                for(int i = 0; i < N; i++){
                    for(int j = 0; j < N; j++){
                        if(map[i][j] > day && !v[i][j]) {
                            DFS(i,j,day,map,v);
                            cnt++;
                        }
                    }
                }
                answer = Math.max(cnt, answer);
                for(int i=0;i<v.length;i++) Arrays.fill(v[i], false);
            }

            System.out.println("#" + t + " " + answer);
        }
    }
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    static void DFS(int r, int c, int day,int[][] map, boolean[][] v){
        v[r][c] = true;

        for(int i=0; i < dr.length; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(nr >= 0 && nr < map.length && nc >= 0 && nc < map.length && !v[nr][nc] && map[nr][nc] > day){
                DFS(nr,nc,day,map,v);
            }
        }
    } 
}
