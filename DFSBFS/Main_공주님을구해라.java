package DFSBFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_공주님을구해라 {
    static int R,C,T;
    static int[][] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        v = new boolean[R][C];
        sv = new boolean[R][C];
        int[] sword = new int[2];
        for(int r = 0; r < R; r++){
            st = new StringTokenizer(br.readLine().trim());
            for(int c = 0; c < C; c++){
                map[r][c] = Integer.parseInt(st.nextToken());
                if(map[r][c] == 2){
                    sword[0] = r;
                    sword[1] = c;
                }
            }
        }
        int answer = BFS(0,0);
        if(answer==-1 || answer > T) System.out.println("Fail");
        else System.out.println(answer);
    }
    static boolean[][] v;
    static boolean[][] sv;
    static int[] dr = {0,-1,0,1};
    static int[] dc = {-1,0,1,0};
    static int BFS(int r,int c){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r,c,0,0});
        v[r][c] = true;
        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            if(pos[0] == R-1 && pos[1] == C-1) return pos[2];
            if(map[pos[0]][pos[1]]==2) pos[3] = 1;

            for(int i=0;i<dr.length;i++){
                int nr = pos[0] + dr[i];
                int nc = pos[1] + dc[i];
                if(nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
                if(pos[3] == 0 && (v[nr][nc] || map[nr][nc] == 1)) continue;
                if(pos[3] == 1 && sv[nr][nc]) continue;
                if(pos[3] == 0) v[nr][nc] = true;
                else sv[nr][nc] = true;

                queue.offer(new int[]{nr,nc,pos[2]+1,pos[3]});
            }
        }

        return -1;
    }
}
