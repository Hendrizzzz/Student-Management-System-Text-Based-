package StudentGradeSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();
        int userChoice;
        int menuChoice = 0;
        boolean isValidMenuInput = true;
        boolean exit = false;

        Scanner kbd = new Scanner(System.in);

        while (!exit) {
            userChoice = menu(kbd, isValidMenuInput, menuChoice);

            switch (userChoice) {
                case 1 -> addStudent(students, kbd);
                case 2 -> removeStudent(students, kbd);
                case 3 -> getData(kbd, students);
                case 4 -> getStudentCount();
                case 5 -> exit = true;
            }
        }
    }


    private static int menu(Scanner kbd, boolean isValidMenuInput, int menuChoice) {
        while(isValidMenuInput){
            try{
                System.out.println("Menu: ");
                System.out.println("1. Add a Student ");
                System.out.println("2. Remove a student ");
                System.out.println("3. Get student's data ");
                System.out.println("4. Get number of students ");
                System.out.println("5. Exit \n");

                menuChoice = Integer.parseInt(kbd.nextLine());

                if (menuChoice < 5 && menuChoice > 0) isValidMenuInput = false;
                else System.out.println("Selected choice not in the menu. Please select again. \n");

            } catch (NumberFormatException e){
                System.out.println("Invalid Input \n");
            }
        }
        return menuChoice;
    }


    private static void addStudent(ArrayList<Student> students, Scanner kbd) {
        String addAnotherResponse;
        boolean loopAddAnotherQuestion = true;
        String name;
        ArrayList<Integer> grades = new ArrayList<>();

        System.out.print("Enter the student's name: ");
        name = kbd.nextLine();

        while(loopAddAnotherQuestion){
            System.out.println("Enter the student's grades: ");
            grades.add(Integer.parseInt(kbd.nextLine()));

            while(true) {
                System.out.print("Add another (yes/no): ");
                addAnotherResponse = kbd.nextLine();

                if (addAnotherResponse.equalsIgnoreCase("no")) {
                    loopAddAnotherQuestion = false;
                    break;
                } else if (addAnotherResponse.equalsIgnoreCase("yes")) {
                    break;
                } else {
                    System.out.println("Answer \"yes\" or \"no\" \n");
                }
            }
        }

        Student student = new Student(name, grades);
        students.add(student);
        System.out.println("Student has been added successfully! \n");
    }


    private static void removeStudent(ArrayList<Student> students, Scanner kbd) {
        if(students.isEmpty()) {
            System.out.println("No students to be removed \n");
            return;
        }

        System.out.print("Enter the name of the student: ");
        String enteredStudentName = kbd.nextLine();

        Student foundStudent = null;
        for(Student i : students){
            if(i.getName().equalsIgnoreCase(enteredStudentName)) foundStudent = i;
        }

        if (foundStudent != null) foundStudent.removeStudentFromList(students, foundStudent);
        else System.out.println("Student " + enteredStudentName + " is not found \n");
    }


    private static void getData(Scanner kbd, ArrayList<Student> students) {
        if(students.isEmpty()) {
            System.out.println("No students to be checked \n");
            return;
        }

        System.out.print("Enter the name of the student: ");
        String enteredStudentName = kbd.nextLine();

        Student foundStudent = null;
        for(Student j : students){
            if (j.getName().equalsIgnoreCase(enteredStudentName)) foundStudent = j;
        }

        if (foundStudent != null) foundStudent.printData();
        else System.out.println("Student " + enteredStudentName + " is not found \n");
    }

    private static void getStudentCount() {
        System.out.println("There are " + Student.getStudentCount() + " students \n");
    }
}