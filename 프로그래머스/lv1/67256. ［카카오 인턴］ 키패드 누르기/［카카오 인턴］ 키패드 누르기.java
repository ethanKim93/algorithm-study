import java.util.*;
import java.util.stream.Collectors;

class Solution {
    
    private static class Hand {
        
        public int baseX;
        public String hand;
        public int x;
        public int y; 
        public float pre; 
        
        public Hand(String hand,boolean isPre,int x){
            this.baseX = x;
            this.hand = hand;
            this.x = x;
            this.y = 3;
            this.pre = isPre? 0.5f : 0;
        }
        
        public float getDistanse(int x,int y){
            if(baseX == x) return 0;
            int distance = Math.abs(this.x - x) + Math.abs(this.y - y);
            return distance - this.pre;
        }
        
        public void move(int x , int y){
            this.x = x;
            this.y = y; 
        }
    }
    
    public static int getX(int n){
        if(n == 0) return 1;
        return (n-1) % 3;
    }
    
    public static int getY(int n){
        if(n == 0) return 3;
        return (n -1) / 3;
    }
    
    private Hand press(int n,Hand right , Hand left){
            int x = getX(n);
            int y = getY(n);
            
            Hand hand = right;
            if(right.getDistanse(x,y) > left.getDistanse(x,y)){
                hand = left;
            }
            hand.move(x,y);
            return hand;
    }
    
    public String solution(int[] numbers, String hand) {
        String answer = "";
        Hand right = new Hand("R","right".equals(hand),2);
        Hand left = new Hand("L","left".equals(hand),0);

        return Arrays.stream(numbers).mapToObj(n -> press(n,right,left).hand)
            .collect(Collectors.joining());
    }
}