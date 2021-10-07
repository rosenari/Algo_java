import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_보급로 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        for(int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine().trim());
            int[][] map = new int[N][N];
            boolean[][] v = new boolean[N][N];
            for(int i=0;i < N;i++){
                char[] line = br.readLine().trim().toCharArray();
                for(int j=0; j < N; j++){
                    map[i][j] = line[j] - '0';
                }
            }
            System.out.println("#" + t + " " + BFS(0,0,N-1,N-1,map,v));
        }
    }
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    static int BFS(int sR,int sC,int dR,int dC,int[][] map,boolean[][] v){
        PriorityQueue<int[]> pque = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        v[sR][sC]= true;
        pque.offer(new int[]{sR, sC, 0});
        
        while(!pque.isEmpty()){
            int[] pos = pque.poll();
            if(pos[0]==dR && pos[1]==dC){
                return pos[2];
            }
            
            for(int i=0;i<dr.length;i++){
                int nr = pos[0] + dr[i];
                int nc = pos[1] + dc[i];
                if(nr >= 0 && nr <= dR && nc >= 0 && nc <= dC && !v[nr][nc]){
                    v[nr][nc] = true;
                    pque.offer(new int[]{nr, nc, pos[2] + map[nr][nc]});
                }
            }
        }

        return 0;
    }
}
