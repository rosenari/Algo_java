package DFSBFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_불 {
    static char[][] map;
    static int R,C;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        for(int r = 0; r < R ; r++){
            map[r] = br.readLine().trim().toCharArray();
        }

        int[] startJ = new int[2];
        Queue<int[]> startF = new LinkedList<>();
        for(int r = 0; r < R; r++){
            for(int c = 0; c < C; c++){
                if(map[r][c]=='J'){
                    startJ[0] = r;
                    startJ[1] = c;
                }else if(map[r][c]=='F'){
                    startF.offer(new int[]{r,c});
                }
            }
        }
        int answer = BFS(startJ, startF);
        if(answer == -1){
            System.out.println("IMPOSSIBLE");
        }else{
            System.out.println(answer);
        }
    }
    static int[] dr = {0,1,0,-1};
    static int[] dc = {-1,0,1,0};
    static int BFS(int[] startJ, Queue<int[]> fQueue){
        Queue<int[]> jQueue = new LinkedList<>();
        jQueue.offer(new int[]{startJ[0],startJ[1],0});
                
        HashSet<Integer> set = new HashSet<>();
        while(!jQueue.isEmpty()){
            int[] jPos = jQueue.poll();
            int fQueueSize = fQueue.size();
            
            if(!set.contains(jPos[2])){
                for(int f=0;f<fQueueSize;f++){
                    int[] fPos= fQueue.poll();
                    for(int i=0;i<dr.length;i++){
                        int Fnr = fPos[0] + dr[i];
                        int Fnc = fPos[1] + dc[i];
                        if(Fnr < 0 || Fnc < 0 || Fnr >= R || Fnc >= C) continue;
                        if(map[Fnr][Fnc] == '.' || map[Fnr][Fnc] == 'J'){
                            map[Fnr][Fnc] = 'F';
                            fQueue.offer(new int[]{Fnr,Fnc});
                        }
                    }
                }
                set.add(jPos[2]); 
            }

            for(int i=0;i<dr.length;i++){
                int Jnr = jPos[0] + dr[i];
                int Jnc = jPos[1] + dc[i];
                if(Jnr < 0 || Jnc < 0 || Jnr >= R || Jnc >= C) return jPos[2] + 1;
                if(map[Jnr][Jnc] == '.'){
                    map[Jnr][Jnc] = 'J';
                    jQueue.offer(new int[]{Jnr,Jnc, jPos[2] + 1});
                }
            }       
        }

        return -1;
    }
    static void print(){
        for(int r=0;r<map.length;r++){
            for(int c=0;c<map[r].length;c++){
                System.out.print(map[r][c]);
            }
            System.out.println();
        }
    }
}
