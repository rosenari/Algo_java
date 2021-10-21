package HashMap;

import java.util.*;
import java.util.stream.IntStream;

public class Solution_베스트앨범 {
    public int[] solution(String[] genres, int[] plays) {
        Map<String,Integer> gplays = new HashMap<>();
        IntStream.range(0, plays.length).forEach(i -> {
            if(gplays.get(genres[i])!=null) gplays.put(genres[i], gplays.get(genres[i]) + plays[i]);
            else gplays.put(genres[i], plays[i]);
        });
        List<Song> list = new ArrayList<>();
        IntStream.range(0, plays.length).forEach(i -> list.add(new Song(i, plays[i], genres[i])));
        list.sort(new Comparator<Song>(){
            @Override
            public int compare(Song o1, Song o2) {
                if(gplays.get(o2.genre) - gplays.get(o1.genre) == 0){
                    if(o2.play - o1.play == 0){
                        return o1.index - o2.index;
                    }
                    return o2.play - o1.play;
                }
                return gplays.get(o2.genre) - gplays.get(o1.genre);
            }
        });
        ArrayList<Integer> answer = new ArrayList<>();
        int cnt = 1;
        String before = "";

        for(int i=0;i<list.size();i++){
            if(before.equals(list.get(i).genre)) cnt++;
            else cnt = 1;

            if(cnt <= 2) answer.add(list.get(i).index);
            before = list.get(i).genre;
        }
        return answer.stream().mapToInt(i->i).toArray();
    }
    
    static class Song{
        int index;
        int play;
        String genre;
        Song(int index, int play, String genre){
            this.index = index;
            this.play = play;
            this.genre = genre;
        }
    }
}
