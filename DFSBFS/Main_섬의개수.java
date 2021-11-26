package DFSBFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_섬의개수 {
    static int R,C;
    static int[][] map;
    static boolean[][] v;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while(true){
            int answer = 0;
            st = new StringTokenizer(br.readLine().trim());
            C = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            if(R == 0 && C == 0) break;

            map = new int[R][C];
            v = new boolean[R][C];
            for(int r = 0; r < R; r++) {
                st = new StringTokenizer(br.readLine().trim());
                for(int c = 0; c < C; c++) {
                    map[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            for(int r = 0; r < R; r++) {
                for(int c = 0; c < C; c++) {
                    if(map[r][c] == 1 && !v[r][c]){
                        DFS(r,c);
                        answer++;
                    }
                }
            }
            System.out.println(answer);
        }
    }
    static int[] dr = {-1,-1,-1,0,1,1,1,0};
    static int[] dc = {-1,0,1,1,1,0,-1,-1};
    static void DFS(int r,int c){
        v[r][c] = true;

        for(int i=0 ;i < dr.length; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(nr < 0 || nc < 0 || nr >= R || nc >= C || map[nr][nc] == 0 || v[nr][nc]) continue;
            DFS(nr,nc);
        }
    }
}
