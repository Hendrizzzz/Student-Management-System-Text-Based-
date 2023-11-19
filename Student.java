package StudentGradeSystem;

import java.util.ArrayList;

public class Student {
    private String name;
    private ArrayList<Integer> grades;
    private static int studentCount = 0;

    public Student(String name, ArrayList<Integer> grades){
        this.name = name;
        this.grades = grades;
        studentCount++;
    }

    public void setName(String name){
        this.name = name;
    }


    public void setGrades(ArrayList<Integer> grades){
        this.grades = grades;
    }

    public String getName(){
        return name;
    }

    public ArrayList<Integer> getGrades(){
        return grades;
    }

    public int getAverage(){
        int sum = 0;
        for(Integer i : grades){
            sum += i;
        }
        return sum/ grades.size();
    }

    public String getStatus(){
        if(getAverage() > 98) return "A+";
        else if (getAverage() > 93) return "A";
        else if (getAverage() > 90) return "A-";
        else if (getAverage() > 87) return "B+";
        else if (getAverage() > 83) return "B";
        else if (getAverage() > 80) return "B-";
        else if (getAverage() > 77) return "C+";
        else if (getAverage() > 73) return "C";
        else if (getAverage() > 70) return "C-";
        else if (getAverage() > 67) return "D+";
        else if (getAverage() > 60) return "D";
        return "F";
    }

    public void printData() {
        System.out.println("Name: " + getName());
        System.out.println("Grades: " + getGrades());
        System.out.println("Average: " + getAverage());
        System.out.println("Status: " + getStatus() + "\n");
    }

    public void removeStudentFromList(ArrayList<Student> students, Student foundStudent){
        students.remove(foundStudent);
        System.out.println("Student has been successfully removed! \n");
        studentCount--;
    }

    public static int getStudentCount(){

        return studentCount;
    }
}