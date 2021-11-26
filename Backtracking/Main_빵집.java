package Backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_빵집 {
    static int R,C;
    static char[][] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for(int r = 0; r < R; r++){
            map[r] = br.readLine().trim().toCharArray();
        }

        for(int r = 0; r < R; r++){
            if(map[r][0] == '.') DFS(r, 0);
        }

        System.out.println(answer);
    }
    static int answer = 0;
    static int[] dr = {-1,0,1};
    static int[] dc = {1,1,1};
    static boolean DFS(int r, int c){
        if(c == C - 1){
            map[r][c] = 'x';
            answer++;
            return true;
        }
        map[r][c] = 'x';

        for(int i=0;i<dr.length;i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(nr >= 0 && nc >= 0 && nr < R && nc < C && map[nr][nc] == '.'){
                if(DFS(nr, nc)) return true;
            }
        }

        return false;
    }
}
