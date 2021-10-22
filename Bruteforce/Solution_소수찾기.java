package Bruteforce;

import java.util.*;

public class Solution_소수찾기 {
    public int solution(String numbers) {
        int N = numbers.length();
        for(int target=1;target<=N;target++){
            v = new boolean[N];
            nPr(0,target, new String[target], Arrays.stream(numbers.split("")).mapToInt(i->Integer.parseInt(i)).toArray());
        }
        return prime.size();
    }
    static HashSet<Integer> prime = new HashSet<>();
    static HashSet<Integer> already = new HashSet<>();
    static boolean[] v;
    static void nPr(int cnt,int target, String[] space,int[] numbers){
        if(cnt == target){
            String resultStr = String.join("",space);
            Integer result = Integer.parseInt(resultStr);
            if(already.contains(result)) return;
            if(isPrime(result)){
                prime.add(result);
            }
            already.add(result);
            return;
        }
        
        for(int i=0;i<numbers.length;i++){
            if(v[i]) continue;
            v[i] = true;
            space[cnt] = numbers[i] + "";
            nPr(cnt + 1,target, space, numbers);
            v[i] = false;
        }
    }
    
    static boolean isPrime(Integer number){
        if(number==0 || number ==1) return false;
        boolean[] isNot = new boolean[number + 1];
        for(int i=2;i <= Math.sqrt(number);i++){
            if(isNot[i]) continue;
            
            for(int j=i+i;j<=number;j+=i){
                isNot[j] = true;
            }
        }
        
        return !isNot[number];
    }
}
