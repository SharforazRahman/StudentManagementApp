package com.studentApplication.main;


import com.studentApplication.dao.StudentDao;
import com.studentApplication.dao.StudentDaoInterface;
import com.studentApplication.model.Student;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        StudentDaoInterface dao = new StudentDao();
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Student Management Application");

        while (true) {
            System.out.println("""

                    1.Add Student
                    2.Show All Students
                    3.Get Student based on roll Number
                    4.Delete Student
                    5.Update Student
                    6.Exist""");

            System.out.print("Enter Choice:");
            int ch = sc.nextInt();

            switch (ch) {
                case 1 -> {
                    System.out.println("Add Student");
                    System.out.println("Enter Student Name");
                    String name = sc.next();
                    System.out.println("Enter Student College Name");
                    String clgName = sc.next();
                    System.out.println("Enter City");
                    String city = sc.next();
                    System.out.println("Enter Percentage");
                    double percentage = sc.nextDouble();
                    Student st = new Student(name, clgName, city, percentage);
                    boolean ans = dao.insertStudent(st);
                    if (ans) System.out.println("Recorded inserted Successfully!!");
                    else System.out.println("Something went wrong, Please Try again");
                }
                case 2 -> {
                    System.out.println("Show all Students");
                    dao.showAllStudent();
                }
                case 3 -> {
                    System.out.println("Get students based on RollNumber");
                    System.out.println("Enter Roll_Number");
                    int roll = sc.nextInt();
                    boolean flag = dao.showStudentById(roll);
                    if (!flag) System.out.println("Student with this id is not available in our System, SORRY!!!");
                }
                case 4 -> {
                    System.out.println("Delete Student");
                    System.out.println("Enter Roll Number to Delete");
                    int rollnum = sc.nextInt();
                    boolean flagTwo = dao.delete(rollnum);
                    if (flagTwo) System.out.println("Record Deleted Successfully!");
                    else System.out.println("Something went wrong, sorry.... TRY AGAIN!!");
                }
                case 5 -> {
                    System.out.println("Update the student");
                    System.out.println("\n1.Update name \n2.Update clgName");
                    System.out.println("Enter your choice");
                    int choice = sc.nextInt();
                    if (choice == 1) {
                        System.out.println("Enter roll Number");
                        int rnum = sc.nextInt();
                        System.out.println("Enter new name");
                        String sname = sc.next();
                        Student std = new Student();
                        std.setName(sname);
                        boolean flagThree = dao.update(rnum, sname, choice, std);
                        if (flagThree) System.out.println("Name Updated Successfully");
                        else System.out.println("Something went wrong!!");
                    }
                }
                case 6 -> {
                    System.out.println("Thank you for using Student Management Application");
                    System.exit(0);
                }
                default -> System.out.println("Please Enter Valid Number!!, Thank you");
            }
        }
    }
}
