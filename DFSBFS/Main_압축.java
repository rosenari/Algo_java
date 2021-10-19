package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//예외 테케 : 33(33(3)33(3))
//output : 25
public class Main_압축 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().trim();
        char[] chs = input.toCharArray();        
        System.out.println(DFS(chs, 0, new boolean[chs.length]));
    }
    static int DFS(char[] chs, int idx, boolean[] v){
        int cnt = 0;

        for(int i= idx; i < chs.length; i++){
            if(v[i]) continue;
            v[i] = true;

            if(chs[i] == '('){
                cnt += (DFS(chs, idx + 1, v) * (chs[i - 1] - '0'));
                cnt--;
            }else if(chs[i] == ')'){
                return cnt;
            }else {
                cnt++;
            }
        }

        return cnt;
    }
}