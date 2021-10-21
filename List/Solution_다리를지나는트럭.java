package List;

import java.util.*;

public class Solution_다리를지나는트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        ArrayList<Truck> bridge = new ArrayList<>();
        ArrayList<Integer> trucks = new ArrayList<>();
        for(int i=0;i<truck_weights.length;i++) trucks.add(truck_weights[i]);
        
        while(!bridge.isEmpty() || !trucks.isEmpty()){
            for(int i=0;i<bridge.size();i++) {
                Truck truck = bridge.get(i);
                if(truck.time == bridge_length){
                    bridge.remove(truck);
                    i--;
                }
            }

            if(bridge.size() < bridge_length && trucks.size() > 0 && bridge.stream().mapToInt(truck -> truck.weight).sum() + trucks.get(0) <= weight){
                bridge.add(new Truck(trucks.remove(0), 0));
            }
            for(int i=0;i<bridge.size();i++){
                bridge.get(i).time += 1;
            }    
            
            answer++;
        }
        return answer;
    }
    
    static class Truck{
        int weight;
        int time;
        Truck(int weight, int time) {
            this.weight = weight;
            this.time = time;
        }
        
        public String toString(){
            return weight +","+ time;
        }
    }
}
