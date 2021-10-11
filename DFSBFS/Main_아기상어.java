package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_아기상어 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int answer = 0;
        int N = Integer.parseInt(br.readLine().trim());
        int[][] map = new int[N][N];
        Shark shark = null;
        for(int i = 0;i < N;i++){
            st = new StringTokenizer(br.readLine().trim());
            for(int j = 0;j < N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9){
                    shark = new Shark(i,j);
                    map[i][j] = 0;
                }
            }
        }
        int move = 0;
        while((move = searchAndEatFish(shark,map,N)) > 0){
            answer += move;
            move = 0; 
        }
        System.out.println(answer);
    }

    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    static int searchAndEatFish(Shark shark, int[][] map, int N){
        boolean[][] v = new boolean[N][N];
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[2] - o2[2] == 0){
                    if(o1[0] - o2[0] == 0){
                        return o1[1] - o2[1];
                    }
                    return o1[0] - o2[0];
                }
                return o1[2] - o2[2];
            }
        });
        v[shark.r][shark.c] = true;
        queue.offer(new int[]{ shark.r, shark.c, 0 });
        
        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            if(map[pos[0]][pos[1]] > 0 && map[pos[0]][pos[1]] < shark.size){
                    map[pos[0]][pos[1]] = 0;
                    shark.r = pos[0];
                    shark.c = pos[1];
                    shark.eat();
                    return pos[2];
            }
            
            for(int i = 0; i < dr.length; i++){
                int nr = pos[0] + dr[i];
                int nc = pos[1] + dc[i];

                if(nr >= 0 && nr < N && nc >= 0 && nc < N && !v[nr][nc] && map[nr][nc] <= shark.size){
                    v[nr][nc] = true;
                    queue.offer(new int[]{ nr, nc, pos[2] + 1});
                }
            }
        }
        return 0;
    }
    
    
    static class Shark {
        int size;
        int r;
        int c;
        int eatCnt;
        Shark(int r, int c){
            this.r = r;
            this.c = c;
            this.size = 2;
            this.eatCnt = 0;
        }
        
        public void eat(){
            this.eatCnt += 1;
            if(this.size == this.eatCnt){
                this.eatCnt = 0;
                this.size += 1;
            }
        }
    }
}
