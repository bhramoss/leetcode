package java7features;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class RecursiveFileDelete {

	
	public static void main(String args[]){
		
		
		String baseDir = System.getProperty("user.dir");	
		
		Path path = Paths.get(baseDir+"/bla");
		try{
			
			Files.walkFileTree(path, new FileVisitor<Path>() {

				@Override
				public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
					System.out.println("Inside postVisitDirectory");
					System.out.println("Deleting Directory" + dir.getFileName().toString());					
					Files.delete(dir);
					return FileVisitResult.CONTINUE;
				}

				@Override
				public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
					System.out.println("Inside preVisitDirectory");
					return FileVisitResult.CONTINUE;
				}

				@Override
				public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
					System.out.println("Inside visitFile");
					System.out.println("Deleting File" + file.getFileName().toString());
					Files.delete(file);
					return FileVisitResult.CONTINUE;
				}

				@Override
				public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
					System.out.println("Inside visitFileFailed");
					return FileVisitResult.CONTINUE;
				}

			});
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
//		System.out.println(baseDir);
	}
}
