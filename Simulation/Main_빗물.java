package Simulation;

import java.io.*;
import java.util.*;

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
                        answer += (c - temp - 1);
                    }
                    temp = c;
                }
            }
        }
        System.out.println(answer);
    }
}
