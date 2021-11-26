package DFSBFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_영역구하기 {
    static int[][] board;
    static int M,N,K;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        ArrayList<Integer> answer = new ArrayList<>();
        M = Integer.parseInt(st.nextToken());//세로
        N = Integer.parseInt(st.nextToken());//가로
        K = Integer.parseInt(st.nextToken());//색종이수
        board = new int[M][N];
        v = new boolean[M][N];
        for(int i=0; i < K; i++){
            st = new StringTokenizer(br.readLine().trim());
            int sC = Integer.parseInt(st.nextToken());
            int sR = Integer.parseInt(st.nextToken());
            int dC = Integer.parseInt(st.nextToken());
            int dR = Integer.parseInt(st.nextToken());
            for(int c = sC; c < dC ; c++){
                for(int r = sR; r < dR; r++){
                    board[r][c] = 1;
                }
            }
        }

        for(int r=0;r<M;r++){
            for(int c=0;c<N;c++){
                if(board[r][c] == 0 && !v[r][c]) answer.add(DFS(r,c));
            }
        }

        Collections.sort(answer);
        System.out.println(answer.size());
        for(Integer a : answer) System.out.print(a + " ");
    }
    static boolean[][] v;
    static int[] dr = {0,-1,0,1};
    static int[] dc = {-1,0,1,0};
    static int DFS(int r, int c){
        int cnt = 1;
        v[r][c] = true;

        for(int d =0; d < dr.length; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(nr < 0 || nc < 0 || nr >= M || nc >= N || v[nr][nc] || board[nr][nc]!=0) continue;
            cnt += DFS(nr,nc);
        }
        return cnt;
    }
}
