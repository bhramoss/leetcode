package java7features;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.Future;

public class AsynchronousFileChannelExample {

	public static void main(String args[]){

		String baseDir = System.getProperty("user.dir");	
		Path path = Paths.get(baseDir+"/bla/input.txt");
		System.out.println(path);
		ByteBuffer buffer = ByteBuffer.allocate(1024);
	    long pos = 0;
		try {
			AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.READ);
			Future<Integer> result = fileChannel.read(buffer, pos);
			
			while(!result.isDone());
			
				buffer.flip();
				byte [] data = new byte[buffer.limit()];
				buffer.get(data);
				System.out.println(new String(data));
				buffer.clear();
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
}
