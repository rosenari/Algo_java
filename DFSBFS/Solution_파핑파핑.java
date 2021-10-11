package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_파핑파핑 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        for(int t = 1; t <= T; t++){
            int answer = 0;
            int N = Integer.parseInt(br.readLine().trim());
            char[][] map = new char[N][N];
            for(int i=0;i<N;i++){
                map[i] = br.readLine().trim().toCharArray();
            }
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(map[i][j] == '.' && getMineCount(i, j, map) == 0){
                        BFS(i,j,map);
                        answer++;
                    }
                }
            }

            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(map[i][j] == '.'){
                        answer++;
                    }
                }
            }

            System.out.println("#"+t+" "+answer);
        }
    }

    static int[] dr = {-1,-1,-1,0,1,1,1,0};
    static int[] dc = {-1,0,1,1,1,0,-1,-1};
    static void BFS(int r,int c,char[][] map){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r,c});
        map[r][c] = 'c';

        while(!queue.isEmpty()){
            int[] p = queue.poll();
            
            if(getMineCount(p[0], p[1], map) > 0) continue;
            for(int i=0;i<dr.length;i++){
                int nr = p[0] + dr[i];
                int nc = p[1] + dc[i];
                if(nr >= 0 && nr < map.length && nc >= 0 && nc < map.length && map[nr][nc]=='.'){
                    map[nr][nc] = 'c';
                    queue.offer(new int[]{ nr, nc });
                }
            }
        }
    }

    static int getMineCount(int r,int c,char[][] map){
        int cnt = 0;
        for(int i=0;i<dr.length;i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(nr >= 0 && nr < map.length && nc >= 0 && nc < map.length && map[nr][nc]=='*'){
                cnt++;
            }
        }

        return cnt;
    }
}