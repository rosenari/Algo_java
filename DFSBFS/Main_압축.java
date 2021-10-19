package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_압축 {
    static boolean[] v;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().trim();
        v = new boolean[input.toCharArray().length];
        System.out.println(DFS(input, 0));
    }

    static int DFS(String s,int index){
        int cnt = 0;
        char[] str = s.toCharArray();
        for(int i=index;i<str.length;i++){
            if(!v[i] && str[i] == '('){
                v[i] = true;
                int result = DFS(s, i + 1);
                cnt = (cnt - 1) + (result * (str[i - 1] - '0'));
            }else if(!v[i] && str[i]==')'){
                v[i] = true;
                return cnt;
            }else if(!v[i]){
                v[i] = true;
                cnt++;
            }
        }

        return cnt;
    }  
}
