package facebook;

public class Hamming {
    public int hammingDistance(int x, int y) {
        int count = 0;
        while(x != 0 || y != 0){
            
            int temp1 = 1;
            temp1 &=x;
            int temp2 = 1;
            temp2 &=y;
            if(temp1 != temp2)
                count++;
            x>>=1;
            y>>=1;
            if(x == 0 && y == 0)
            	break;
        }
        return count;
    }
    public static void main(String[] args){
    	Hamming obj = new Hamming();
    	System.out.println(obj.hammingDistance(1, 4));
    }
}
