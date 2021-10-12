package DFSBFS;

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
            answer = Integer.parseInt(st.nextToken());
            
            int[] plan = new int[12];
            st = new StringTokenizer(br.readLine().trim());
            for(int m = 0 ;m < 12; m++){
                plan[m] = Integer.parseInt(st.nextToken());
            }

            powerSet(0, 0, plan, day, month, tmonth);
            System.out.println("#"+tc+" "+answer);
        }
    }
    static int answer;
    static void powerSet(int sum, int cur, int[] plan,int day, int month, int tmonth){
        if(cur > 11 || sum > answer){
            answer = Math.min(sum, answer);
            return;
        }

        powerSet(sum + (plan[cur] * day),cur + 1, plan, day, month, tmonth);
        powerSet(sum + month, cur + 1, plan, day, month, tmonth);
        powerSet(sum + tmonth, cur + 3, plan, day, month, tmonth);
    }
}
