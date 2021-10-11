package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_NQueen {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int answer = DFS(0, N, new int[N]);
        System.out.println(answer);
    }

    static int DFS(int r, int N, int[] chess){
        int cnt = 0;
        if(r == N){
            return 1;
        }

        for(int c=0; c < N; c++) {
            if(isPossible(chess, r, c)){
                chess[r] = c;
                cnt += DFS(r + 1, N, chess);
            }
        }

        return cnt;
    }

    static boolean isPossible(int[] chess, int r, int c){
        for(int i = 0; i < r; i++){
            if(chess[i] == c) return false;
            if(i - chess[i] == r - c) return false; 
            if(i + chess[i] == r + c) return false;
        }

        return true;
    }
}