import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_미로1 {
    static int T = 10, N = 16;
    static char[][] map = new char[N][N];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = 1; t <= T; t++){
            int tc = Integer.parseInt(br.readLine().trim());
            for(int i = 0; i < N; i++){
                map[i] = br.readLine().trim().toCharArray();
            }
            for(int i=0; i < N; i++){
                for(int j=0; j < N; j++){
                    if(map[i][j]=='2'){
                        System.out.println("#" + tc + " " + BFS(i, j));
                        break;
                    }
                }
            }
        }
    }

    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    public static int BFS(int r, int c){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int []{r, c});
        map[r][c] = '1';
        while(!queue.isEmpty()){
            int[] p = queue.poll();
            for(int i = 0; i < dr.length ; i++){
                int nr = p[0] + dr[i];
                int nc = p[1] + dc[i];
                if(map[nr][nc] != '1'){
                    if(map[nr][nc] == '3') return 1;
                    map[nr][nc] = '1';
                    queue.offer(new int[]{nr , nc});
                }
            }
        }

        return 0;
    }
}