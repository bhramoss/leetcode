import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class hw1b {

	public static void main(String[] args){
		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		if(args.length != 0){
			FileInputStream input = null;
			BufferedInputStream buff = null;
			DataInputStream di = null;	
			try{
				String fileName = args[0];
				input = new FileInputStream(fileName);
				buff = new BufferedInputStream(input);
				Stack<String> stack = new Stack<>();
				di = new DataInputStream(buff);
				while(di.available() != 0){
					stack.push(di.readLine());
				}
				while(!stack.isEmpty()){
					System.out.println(stack.pop());
				}
			}catch(Exception e){
				System.out.println("Encountered exception :" + e.getMessage());
				try {
					input.close();
					buff.close();
					di.close();
				} catch (IOException e1) {
					System.out.println("Encountered exception :" + e.getMessage());
				}
				
			}
		}
	}
}

