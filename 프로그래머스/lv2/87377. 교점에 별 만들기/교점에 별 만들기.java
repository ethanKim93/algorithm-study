import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        
        List<Point> crossPoints = new ArrayList<Point>();
        
        for(int i = 0 ; i < line.length ; i ++){
            int[] line1 = line[i];
            for(int j = i ; j < line.length ; j ++){
                int[] line2 = line[j];
                Point point = crossLine(line1,line2,crossPoints);
                if(point != null){
                    crossPoints.add(point);
                }
            }
        }

        Point maximum = getMaxPosition(crossPoints);
        Point minimum = getMinPosition(crossPoints);
        

        int height = (int) (maximum.y - minimum.y + 1);
        int width = (int) (maximum.x - minimum.x + 1);
        
        char[][] arr = new char[height][width];
        for(char[] row : arr){
            Arrays.fill(row,'.');
        }
        // System.out.println(crossPoints.toString());
        //         System.out.println(maximum);
        // System.out.println(minimum);

        for(Point p : crossPoints){
            int x = (int)(p.x - minimum.x);
            int y = (int)(maximum.y - p.y);
            arr[y][x] = '*';
        }

        String[] answer = new String[arr.length];
        for(int i = 0; i < answer.length; i++){
            answer[i] = new String(arr[i]);
        }
        return answer;
        
        // return  new String[1];

    }
    
    // 교차점 찾는 method
    static Point crossLine(int[] line1 , int[] line2 , List<Point> crossPoints){
        long A = line1[0];
        long B = line1[1];
        long E = line1[2];
        
        long C = line2[0];
        long D = line2[1];
        long F = line2[2];
        
   
        
        double x = (double) (B*F - E*D) / (A*D - B*C);
        double y = (double) (E*C - A*F) / (A*D - B*C);

        if(x%1 != 0 || y%1 !=0) return null;
            
        return new Point((long)x,(long)y);
    } 
    
    // 최소 좌표 
    static Point getMinPosition(List<Point> points){
        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;
        
        for(Point p : points){
            if(p.x < x) x = p.x;
            if(p.y < y) y = p.y;
        }
        
        return new Point(x,y);
    }
    
     // 최대 좌표 
    static Point getMaxPosition(List<Point> points){
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;
        
        for(Point p : points){
            if(p.x > x) x = p.x;
            if(p.y > y) y = p.y;
        }
        
        return new Point(x,y);
    }
  
    
    static class Point {
        private long x;
        private long y;
        
        private Point(long x , long y){
            this.x = x ; 
            this.y = y ;
        }
        
        @Override
        public String toString() {
            return String.format("[x = %s,y = %s]", x, y);
        }
    }
}