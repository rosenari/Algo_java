package HashMap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Main_생태학 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        HashMap<String, Integer> hmap = new HashMap<>();
        float N = 0.0f;
        while(true){
            input = br.readLine();
            if(input == null || input.equals("")) break;
            if(hmap.get(input) == null) hmap.put(input, 1);
            else hmap.put(input, hmap.get(input) + 1);
            N++;
        }
        ArrayList<String> list = new ArrayList<>(hmap.keySet());
        Collections.sort(list);
        for(String type : list){
            System.out.print(type);
            System.out.printf(" %.4f\n",hmap.get(type) / N * 100);
        }
    }
}
