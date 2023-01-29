public class Main {
    public static void main(String[] args) {

        University university = new University("1","LOMONOSOV MOSCOW STATE UNIVERSITY", "MGU",1755, StudyProfile.MEDECINA);
        Student student = new Student("Ivan Ivanov","1",4, 83.6F);
        System.out.println(university.toString());
        System.out.println(student.toString());
    }
}
