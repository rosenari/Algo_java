package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_빗물 {
    static int[][] map;
    public static void main(String[] args) throws IOException{
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        st = new StringTokenizer(br.readLine().trim());
        for(int c = 0; c < W; c++){
            int h = Integer.parseInt(st.nextToken());
            for(int r=0;r < h;r++){
                map[r][c] = 1;
            }
        }
        for(int r = 0; r < H; r++){
            int temp = -1;
            for(int c = 0; c < W; c++){
                if(map[r][c] == 1){
                    if(temp >= 0){
                        for(int i = temp + 1; i < c; i++){
                           answer++; 
                        }
                    }
                    temp = c;
                }
            }
        }
        System.out.println(answer);
    }
}
