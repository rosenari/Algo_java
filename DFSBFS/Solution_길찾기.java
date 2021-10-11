package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_길찾기 {
    static int[] arr1 = new int[100];
    static int[] arr2 = new int[100];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int t = 1; t <= 10; t++){
            st = new StringTokenizer(br.readLine().trim());
            int tc = Integer.parseInt(st.nextToken());
            int inputNum = Integer.parseInt(st.nextToken());
            Arrays.fill(arr1, -1);
            Arrays.fill(arr2, -1);

            st = new StringTokenizer(br.readLine().trim());
            for(int i=0; i < inputNum; i++){
                int s = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                if(arr1[s] == -1) arr1[s] = d;
                else arr2[s] = d;
            }

            System.out.println("#" + tc + " " + powerSet(0));
        }        
    }

    static int powerSet(int s){
        int answer = 0;
        if(s == -1) return 0;
        if(s == 99){
            return 1;
        }
        
        answer |= powerSet(arr1[s]);
        answer |= powerSet(arr2[s]);

        return answer;
    }
}
