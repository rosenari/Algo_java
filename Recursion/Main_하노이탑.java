package Recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main_하노이탑 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        
        BigInteger answer = new BigInteger("2");
        BigInteger one = new BigInteger("1");
        answer = answer.pow(N);

        sb.append(answer.subtract(one)).append("\n");
        if(N <= 20) {
            Hanoi(sb,1,3,2,N);
            System.out.print(sb.toString());
        }else {
            System.out.print(sb.toString());
        }
    }

    static void Hanoi(StringBuilder sb, int a, int b, int c, int n){
        if(n==0) return;

        Hanoi(sb, a, c, b, n - 1);
        sb.append(a).append(" ").append(b).append("\n");
        Hanoi(sb, c, b, a, n - 1);
    }
}