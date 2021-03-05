package hw8.src;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Имеется следующая структура:
 interface Student {
    String getName();
    List<Course> getAllCourses();
 }
 interface Course {
     String getName();
 }

 class GBCourse implements Course {
     private String name;

     GBCourse(String name){
         this.name = name;
     }


     public String getName(){ return name; }

     public void setName(String name) {
         this.name = name;
     }
 }

 class GBStudent implements Student {
     private String name;
     private List<Course> courses = new ArrayList<Course>();

     public String getName(){ return name; }

     public void setName(String name) {
         this.name = name;
     }

     public void setCourse(Course course) {
         courses.add(course);
     }

     @Override
     public List<Course> getAllCourses(){
         return courses;
     }
 }
//
// Написать функцию, принимающую список Student и возвращающую список уникальных курсов,
// на которые подписаны студенты.
// Написать функцию, принимающую на вход список Student и
// возвращающую список из трех самых любознательных (любознательность определяется количеством курсов).
// Написать функцию, принимающую на вход список Student и экземпляр Course,
// возвращающую список студентов, которые посещают этот курс.


public class HW8 {

    public static void main(String args[]) {
        List<GBStudent> students = new ArrayList<GBStudent>();
        //заполним коллекцию студентов
        for (int i = 0; i < 10; i++) {
            GBStudent student = new GBStudent();
            student.setName("Name" + i);
            for (int j = 0; j <= i; j++) {
                for (int k = 0; k < j; k++) {
                    Course course = new GBCourse("course" + j);
                    student.setCourse(course);
                }
            }
            students.add(student);
        }

//
//        for(Student student : students){
//            System.out.println(student.getName());
//            for(Course course : student.getAllCourses()){
//                System.out.print(course.getName() + ", ");
//            }
//            System.out.println();
//        }

        List<String> uniqueCourses =uniqCoursesNames(students);
        System.out.println("Список уникальных курсов: "+ uniqueCourses.toString());

        System.out.println("Тройка самых любознательных студентов: ");
        topThreeMostCurious(students).stream()
                .map(stud -> stud.getName())
                .forEach(System.out::println);

        Course course = new GBCourse("course7");
        System.out.printf("Студенты на курсе %s: \n", course.getName());
        studentsOnCourse(students, course).stream()
                .map(stud -> stud.getName())
                .forEach(System.out::println);
    }

// Написать функцию, принимающую список Student и возвращающую список уникальных курсов,
// на которые подписаны студенты.
static List<String> uniqCoursesNames(List<GBStudent> students) {
             List<String> uniqueCourses =
                    students.stream()
                            .map(stud -> stud.getAllCourses())
                            .flatMap(Collection::stream)
                            .map(c -> c.getName())
                            .distinct()
                            .collect(Collectors.toList());
            return uniqueCourses;
        }


// Написать функцию, принимающую на вход список Student и
// возвращающую список из трех самых любознательных (любознательность определяется количеством курсов).
static List<Student> topThreeMostCurious(List<GBStudent> students) {
    List<Student> topThree =
            students.stream()
                    .sorted((stud1, stud2) -> stud2.getAllCourses().size() - stud1.getAllCourses().size())
                    .limit(3)
                    .collect(Collectors.toList());
    return topThree;
}

// Написать функцию, принимающую на вход список Student и экземпляр Course,
// возвращающую список студентов, которые посещают этот курс.
static List<Student> studentsOnCourse(List<GBStudent> students, Course course) {
        String courseName = course.getName();
    List<Student> studentsOnCourse =
            students.stream()
                    .filter(stud -> stud.getAllCourses().stream()
                            .filter(c -> c.getName().equals(courseName))
                            .count() > 0)
                    .collect(Collectors.toList());
    return studentsOnCourse;
}


}
