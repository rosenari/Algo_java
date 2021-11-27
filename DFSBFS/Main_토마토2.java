package DFSBFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_토마토2 {
    static int R,C,H;
    static int[][][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][R][C];
        Queue<int[]> queue = new LinkedList<>();
        for(int h = 0; h < H; h++){
            for(int r = 0; r < R; r++){
                st = new StringTokenizer(br.readLine().trim());
                for(int c = 0; c < C; c++){
                    map[h][r][c] = Integer.parseInt(st.nextToken());
                    if(map[h][r][c] == 1) queue.offer(new int[]{h,r,c,0}); 
                }
            }
        }
        int answer = BFS(queue);
        if(checkAllRipe(map)) System.out.println(answer);
        else System.out.println(-1);
    }

    static int[] dh = {1,-1,0,0,0,0};
    static int[] dr = {0,0,0,-1,0,1};
    static int[] dc = {0,0,-1,0,1,0};
    static int BFS(Queue<int[]> queue){
        int answer = 0;
        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            answer = Math.max(answer, pos[3]);

            for(int i = 0; i < dr.length; i++){
                int nh = pos[0] + dh[i];
                int nr = pos[1] + dr[i];
                int nc = pos[2] + dc[i];
                if(nh < 0 || nr < 0 || nc < 0 || nh >= H || nr >= R || nc >= C) continue;
                if(map[nh][nr][nc] == -1 || map[nh][nr][nc] == 1) continue;
                map[nh][nr][nc] = 1;
                queue.offer(new int[]{ nh, nr, nc, pos[3] + 1 });
            }
        }
        
        return answer;
    }

    static boolean checkAllRipe(int[][][] map){
        for(int h = 0; h < H; h++){
            for(int r = 0; r < R; r++){
                for(int c = 0; c < C; c++){
                    if(map[h][r][c] == 0) return false;
                }
            }
        }
        return true;
    }
}
