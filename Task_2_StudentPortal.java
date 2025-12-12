import java.util.*;

public class StudentPortal {
    public static void main(String[] args) {

        List<Student> list = new ArrayList<>();

        list.add(new Student("S1", "Yash", 75));
        list.add(new Student("S2", "Shubbham", 60));
        list.add(new Student("S1", "Tarak", 100));

        list.add(new GraduateStudent("G1", "Mandeep", 90, "Physiology"));
        list.add(new HonorStudent("H1", "Krish", 120, 10));

        Repository<Student> repo = new Repository<>();
        for (Student s : list) repo.save(s.getId(), s);

        System.out.println("ALL:");
        list.forEach(System.out::println);

        System.out.println("\nLOOKUP S2:");
        Student s = repo.find("S2");
        System.out.println(s != null ? s : "not found");

        Iterator<Student> it = list.iterator();
        while (it.hasNext()) {
            Student st = it.next();
            if (st.getMarks() < 80) {
                it.remove();
                repo.delete(st.getId());
            }
        }

        Iterator<Student> it2 = list.iterator();

        //FINDING TOPPER
        Student topper = null;

        while (it2.hasNext()) {
            Student st = it2.next();
            if (topper == null || st.getMarks() > topper.getMarks()) {
                topper = st;
            }
        }

        System.out.println("TOPPER IS: " + topper);

        System.out.println("\nAFTER REMOVAL:");
        list.forEach(System.out::println);
    }
}

class Student {
    private String id, name;
    private int marks;

    public Student(String id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public String getId() {
        return id;
    }

    public int getMarks() {
        return marks;
    }

    public String getrole() {
        return "Undergrad";
    }

    @Override
    public String toString() {
        return id + " - " + name + " (" + marks + ") " + getrole();
    }
}

class GraduateStudent extends Student {
    private String area;

    public GraduateStudent(String id, String name, int marks, String area) {
        super(id, name, marks);
        this.area = area;
    }

    @Override
    public String getrole() {
        return "Grad (" + area + ")";
    }
}

//HONOR STUDENT+ BONUS MARKS
class HonorStudent extends Student {
    private int bonus;

    public HonorStudent(String id, String name, int marks, int bonus) {
        super(id, name, marks);
        this.bonus = bonus;
    }

    @Override
    public String getrole() {
        return "Honor (bonus " + bonus + ")";
    }
}

class Repository<T> {
    private Map<String, T> data = new HashMap<>();

    public void save(String id, T obj) {
        data.put(id, obj);
    }

    public T find(String id) {
        return data.get(id);
    }

    public void delete(String id) {
        data.remove(id);
    }
}
