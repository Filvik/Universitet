import java.util.Comparator;

public interface StudentComparator extends Comparator<Student> {
  int compare(Student student1,Student student2);
}