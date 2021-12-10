package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Stack;

public class Main_괄호제거 {
    static HashSet<String> answer = new HashSet<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<Integer>();
        ArrayList<int[]> list = new ArrayList<>();
        char[] input = br.readLine().trim().toCharArray();
        StringBuilder str = new StringBuilder();
        for(int i=0; i < input.length; i++){
            if(input[i] == '('){
                stack.push(i);
            }else if(input[i] == ')'){
                list.add(new int[]{ stack.pop(), i });
            }else{
                str.append(input[i]);
            }
        }
        answer.add(str.toString());
        for(int r = 1; r < list.size(); r++){
            nCr(new HashSet<Integer>(), input, list, 0, 0, r);
        }
        ArrayList<String> answerList = new ArrayList<>(answer);
        Collections.sort(answerList);
        for(String a : answerList){
            System.out.println(a);
        }
    }
    
    static void nCr(HashSet<Integer> set,char[] input, ArrayList<int[]> list,int cnt,int start, int r) {
        if(cnt == r){
            StringBuilder str = new StringBuilder();
            for(int i = 0; i < input.length; i++){
                if(!set.contains(i)){
                    str.append(input[i]);
                }
            }
            answer.add(str.toString());
            return;
        }

        for(int i=start;i<list.size();i++){
            int[] index = list.get(i);
            set.add(index[0]);
            set.add(index[1]);
            nCr(set, input, list, cnt + 1, i + 1, r);
            set.remove(index[0]);
            set.remove(index[1]);
        }
    }
}
