import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
public class ExampleFileIO {

	public static void main(String args[]) {
		ExampleFileIO fio = new ExampleFileIO();
		fio.playingWithFiles();
		fio.usingTextFiles();
	}
	public void playingWithFiles() {
		//writing to a byte file
		try {
			OutputStream byteFile = Files.newOutputStream(Paths.get("src/myFirstFile.bin"), StandardOpenOption.CREATE);
			byteFile.write(117);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//reading from a byte file
		try {
			InputStream byteFile = Files.newInputStream(Paths.get("src/myFirstFile.bin"));
			System.out.println("Value in byte file is "+byteFile.read());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void usingTextFiles() {
		try {
			BufferedWriter textFile = Files.newBufferedWriter(Paths.get("src/TextFile.bin"), StandardOpenOption.CREATE);
			// \n puts text on next line
			textFile.write("Bugs Bunny 90 80\n");
			textFile.write("Daffy Duck 70 85\n");
			textFile.write("Daisy Duck 95 85\n");
			textFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		ArrayList<Student> roster = new ArrayList<Student>();
		try {
			BufferedReader textFile = Files.newBufferedReader(Paths.get("src/TextFile.bin"));
			String tempLine = textFile.readLine();
			while(tempLine!=null) {
			Scanner scan = new Scanner(tempLine);
			Student s = new Student();
			s.setFname(scan.next());
			s.setLname(scan.next());
			s.setFscore(scan.nextInt());
			s.setSscore(scan.nextInt());
			roster.add(s);
			//System.out.println(s.getFname()+"'s average is "+(s.getFscore()+s.getSscore())/2);
				tempLine = textFile.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		Collections.sort(roster, new SortByAvg());
		System.out.println("The highest f score is "+roster.get(roster.size()-1).getFscore());
	}
}
