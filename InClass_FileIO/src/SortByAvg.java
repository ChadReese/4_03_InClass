import java.util.Comparator;

public class SortByAvg implements Comparator<Student> {

	public int compare(Student s1, Student s2) {
		if(s1.getFscore() > s2.getFscore()) return 1;
		else if(s1.getFscore() < s2.getFscore()) return -1;
		else return 0;
	}

}
