package Lab4;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        try {
            Student[] students = {
                    new Student(1, "John", 20, 3.5, "Computer Science"),
                    new Student(2, "Alice", 22, 3.8, "Engineering"),
                    new Student(3, "Bob", 21, 3.2, "Mathematics"),
                    new Student(4, "Eve", 23, 3.9, "Physics"),
                    new Student(5, "Carol", 19, 3.6, "Biology")
            };

            // Сортування за зростанням по полю "age"
            Arrays.sort(students, Comparator.comparing(Student::getAge));

            System.out.println("Сортування за зростанням за віком:");
            for (Student student : students) {
                System.out.println(student);
            }

            // Сортування за спаданням по полю "gpa"
            Arrays.sort(students, Comparator.comparing(Student::getGrades).reversed());

            System.out.println("\nСортування за спаданням за середнім балом (GPA):");
            for (Student student : students) {
                System.out.println(student);
            }


            // Сортування за спаданням по полю "gpa"
            Arrays.sort(students, Comparator.comparing(Student::getName));

            System.out.println("\nСортування за іменем:");
            for (Student student : students) {
                System.out.println(student);

            }

            // Сортування за спаданням по полю "id"
            Arrays.sort(students, Comparator.comparing(Student::getId));

            System.out.println("\nСортування по Id:");
            for (Student student : students) {
                System.out.println(student);
            }
        }
        catch (IllegalArgumentException e){
            System.out.println("Помилка: " + e.getMessage());

        }

    }
}
