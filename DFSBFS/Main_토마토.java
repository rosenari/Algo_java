package DFSBFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_토마토 {
    static int R,C;
    static int[][] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        Queue<int[]> queue = new LinkedList<>();
        for(int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine().trim());
            for(int c = 0; c < C; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                if(map[r][c] == 1){
                    queue.offer(new int[]{r, c, 0});
                }
            }
        }
        int answer = BFS(queue);
        if(checkAllRipe(map)) System.out.println(answer);
        else System.out.println(-1);

    }
    static int[] dr = {0,-1,0,1};
    static int[] dc = {-1,0,1,0};
    static int BFS(Queue<int[]> queue) {
        int answer = 0;
        
        while(!queue.isEmpty()){
            int[] data = queue.poll();
            answer = Math.max(answer, data[2]);

            for(int i=0;i<dr.length;i++){
                int nr = data[0] + dr[i];
                int nc = data[1] + dc[i];
                if(nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
                if(map[nr][nc] == 1 || map[nr][nc] == -1) continue;
                map[nr][nc] = 1;
                queue.offer(new int[]{ nr, nc, data[2] + 1 });
            }

        }

        return answer;
    }
    static boolean checkAllRipe(int[][] map){
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[i].length;j++){
                if(map[i][j] == 0) return false;
            }
        }
        return true;
    }
}
