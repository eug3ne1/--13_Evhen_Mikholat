package Lab4;

public class Student {
    private final int id;
    private final String name;
    private final int age;
    private final double grades;
    private final String major;

    public Student(Integer id, String name, Integer age, double grades, String major) {
        if (name == null || name.isEmpty() ) {
            throw new IllegalArgumentException("Ім'я не може бути пустими полем.");
        } else if (major == null || major.isEmpty()) {
            throw new IllegalArgumentException("Cпеціальність не можe бути пустими полем.");
        }
        this.id = id;
        this.name = name;
        this.age = age;
        this.grades = grades;
        this.major = major;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getGrades() {
        return grades;
    }

    public String getMajor() {
        return major;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", grades=" + grades +
                ", major='" + major + '\'' +
                '}';
    }
}
