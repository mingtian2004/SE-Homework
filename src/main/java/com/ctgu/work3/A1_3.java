package src.main.java.com.ctgu.work3;

public class A1_3 {
    public class School{
      private Department department;
      private Student student;
    }
    public class Department{
        private Instructor instructor;
        private Subject subject;
    }
    public class Instructor{
       private Department department;
       private Subject subject;
    }
    public class Subject{
        private Department department;
        private Instructor instructor;
        private Student student;
    }
    public class Student{
        private Subject subject;
    }
}
