package Recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_Z {
    static long R,C;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        long N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        Z(0,0,0,(long) Math.pow(2, N));
    }
    
    static void Z(long r,long c,long num, long N){
        if(N==1){
            if(r == R && c == C) System.out.println(num);
            return;
        }

        if(R < r + N / 2 && C < c + N / 2) Z(r, c ,num, N / 2);
        else if(R < r + N / 2 && C >= c + N / 2) Z(r, c + N / 2, num + N * N * 1 / 4, N / 2);
        else if(R >= r + N / 2 && C < c + N / 2) Z(r + N / 2, c, num + N * N * 2 / 4, N / 2);
        else Z(r + N / 2, c + N / 2, num + N * N * 3 / 4, N / 2);
    }
}
