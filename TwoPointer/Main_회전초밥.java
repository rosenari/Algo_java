package TwoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_회전초밥 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] belt = new int[N];
        int[] select = new int[d + 1];
        int answer = 0;
        int total = 0;
        for(int i=0;i<N;i++){
            belt[i] = Integer.parseInt(br.readLine().trim());
            if(i < k){ 
                if(select[belt[i]]++ == 0) total++;
            }
        }
        if(select[c] == 0) answer = total + 1;
        else answer = total;
        for(int s=1;s<N;s++){
            int e = (s + k - 1) % N;
            if(select[belt[s - 1]]-- == 1){
                total--;
            }
            if(select[belt[e]]++ == 0){
                total++;
            }
            if(select[c] == 0) answer = Math.max(answer, total + 1);
            else answer = Math.max(answer, total);
        }
        System.out.println(answer);        
    }
}
