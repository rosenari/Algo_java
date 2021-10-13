package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_색종이 {
    public static void main(String[] args) throws IOException{
        boolean[][] board = new boolean[100][100];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int answer = 0, N = Integer.parseInt(br.readLine().trim());
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine().trim());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            for(int nr=r; nr < r + 10; nr++){
                for(int nc=c; nc < c + 10; nc++){
                    if(!board[nr][nc]){
                        board[nr][nc] = true;
                        answer++;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
