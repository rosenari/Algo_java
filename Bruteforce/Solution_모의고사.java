package Bruteforce;

import java.util.*;

public class Solution_모의고사 {
    public int[] solution(int[] answers) {
        int[][] pattern = new int[][]{{1,2,3,4,5},{2,1,2,3,2,4,2,5},{3,3,1,1,2,2,4,4,5,5}};
        int[] cnt = new int[3];
        for(int i=0;i<answers.length;i++){
            if(answers[i]==pattern[0][i%pattern[0].length]) cnt[0]++;
            if(answers[i]==pattern[1][i%pattern[1].length]) cnt[1]++;
            if(answers[i]==pattern[2][i%pattern[2].length]) cnt[2]++;
        }
        int max = Arrays.stream(cnt).max().orElse(0);
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=0;i<cnt.length;i++) if(cnt[i] >= max) answer.add(i + 1);
        return answer.stream().mapToInt(i->i).toArray();
    }
}
