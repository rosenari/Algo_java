package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_수영장 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine().trim());
        for(int tc = 1; tc <= T ; tc++){
            st = new StringTokenizer(br.readLine().trim());
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int tmonth = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());
            
            int[] plan = new int[13];
            st = new StringTokenizer(br.readLine().trim());
            for(int m = 1 ;m <= 12; m++){
                plan[m] = Integer.parseInt(st.nextToken());
            }

            int[] dp = new int[13];
            for(int m = 1; m <= 12; m++){
                dp[m] = getMin(dp, m, plan, day, month, tmonth, year);
            }
            int answer = Math.min(dp[12], year);
            System.out.println("#"+tc+" "+answer);
        }
    }
    
    static int getMin(int[] dp,int m, int[] plan, int day, int month, int tmonth, int year){
        int min = dp[m-1] + (plan[m] * day);
        min = Math.min(min, dp[m-1] + month);
        if(m > 3) {
            min = Math.min(min, dp[m-3] + tmonth);
        }else {
            min = Math.min(min, tmonth);
        }
        return min;
    }
}
