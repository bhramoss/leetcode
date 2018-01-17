package google;

import java.util.HashSet;
import java.util.Set;

class NextClosestTime {
    public String nextClosestTime(String time) {
        
        Set<Integer> set = new HashSet<Integer>();
        
        for(char c: time.toCharArray()){
            if(c != ':')
                set.add(Character.getNumericValue(c));
        }

        String[] t = time.split(":");
        int hours = Integer.valueOf(t[0]);
        int mins = Integer.valueOf(t[1]);
        
        while(true){
            
            if(++mins%60 == 0){
                mins = 00;
                if(++hours%24 == 0){
                    hours = 00;
                }
            }
            
            //perform check:
            int h1 = hours/10;
            int h2 = hours%10;
            int m1 = mins/10;
            int m2 = mins%10;
            
            if(!set.contains(h1) || !set.contains(h2) || !set.contains(m1) || !set.contains(m2)){
                continue;
            }else{
                StringBuilder builder = new StringBuilder();
                builder.append(Integer.toString(h1));
                builder.append(Integer.toString(h2));
                builder.append(":");
                builder.append(Integer.toString(m1));
                builder.append(Integer.toString(m2));                
                return builder.toString();
            }
        }
    }
    
    public static void main(String[] args){
    	
    	NextClosestTime obj = new NextClosestTime();
    	
    	System.out.println(obj.nextClosestTime("23:59"));
    }

}