package DFSBFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_달이차오른다가자 {
    static int R,C;
    static char[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        v = new int[R][C];
        for(int r = 0; r < R; r++) {
            map[r] = br.readLine().trim().toCharArray();
        }
        for(int r = 0; r < R; r++) {
            for(int c = 0; c < C; c++){
                if(map[r][c] == '0'){
                    map[r][c] = '.';
                    System.out.println(BFS(r, c));
                    return;
                }
            }
        }
    }
    static int[][] v;
    static int[] dr = {0,-1,0,1};
    static int[] dc = {-1,0,1,0};
    static int BFS(int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c, 0, 1});//r, c, cnt, flag
        v[r][c] |= 1;

        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            if(map[pos[0]][pos[1]] == '1'){
                return pos[2];
            }

            for(int i = 0; i < dr.length; i++){
                int nr = pos[0] + dr[i];
                int nc = pos[1] + dc[i];
                int flag = pos[3];
                if(nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
                if(map[nr][nc] == '#') continue;
                if((v[nr][nc] ^ flag) == 0) continue;
                if(map[nr][nc] >= 'A' && map[nr][nc] <= 'F'){
                    if(((2 << (map[nr][nc] - 'A')) & flag) != (2 << (map[nr][nc] - 'A'))) continue;
                }
                if(map[nr][nc] >= 'a' && map[nr][nc] <= 'f'){
                    flag |= (2 << (map[nr][nc] - 'a'));
                }
                v[nr][nc] |= flag;
                queue.offer(new int[]{nr,nc,pos[2] + 1, flag });
            }
        }

        return -1;
    }
}
