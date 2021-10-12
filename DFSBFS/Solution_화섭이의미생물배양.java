package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_화섭이의미생물배양 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        StringTokenizer st;
        for(int t=1; t <= T; t++){
            st = new StringTokenizer(br.readLine().trim());
            int[] input = new int[4];
            for(int i=0;i<4;i++){
                input[i] = Integer.parseInt(st.nextToken());
            }
            int s = input[0],d = input[1], a = input[2],b = input[3];
            if(s==d) System.out.println("#"+t+" 0");
            else if(b == 1 && (d - s) % a == 0) System.out.println("#" + t + " " + ((d - s) / a));
            else if(b == 1 && (d - s) % a != 0) System.out.println("#" + t +" -1");
            else {
                int answer = BFS(s, d, a, b);
                System.out.println("#"+t+" "+answer); 
            }           
        }
    }

    static int BFS(int s, int d,int a, int b){
        int min = d - s;     
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{d, 0});
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            if(cur[0] <= s || cur[1] >= min){
                if(cur[0] == s) return cur[1];
            }else {
                if(cur[0] % b == 0 && cur[0] / b < cur[0] - a && cur[0] / b >= s) queue.offer(new int[]{cur[0] / b, cur[1]+1});
                else queue.offer(new int[]{cur[0] - a, cur[1]+1});
            }
        }

        return -1;
    }
}
