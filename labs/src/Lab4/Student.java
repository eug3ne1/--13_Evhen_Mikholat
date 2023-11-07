package Lab4;

public class Student {
    private int id;
    private String name;
    private int age;
    private double grades;
    private String major;

    public Student(Integer id, String name, Integer age, double grades, String major) {
        if (name == null || name.isEmpty() || major == null || major.isEmpty()) {
            throw new IllegalArgumentException("Ім'я та спеціальність не можуть бути пустими.");
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
