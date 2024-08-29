/*
 * @(#) TestCourse.java     1.0     8/29/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package edu.iuh.fit;

import java.util.Scanner;

/*
 * @description
 * @author: Nhien Tran
 * @date:    8/29/2024
 * @version: 1.0
 */
public class TestCourse {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CourseList courseList = new CourseList(10);

        initData(courseList);

        int choice;
        do {
            System.out.println("1. Add a course");
            System.out.println("2. Display all courses");
            System.out.println("3. Remove a course");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter course id: ");
                    String id = sc.nextLine();
                    System.out.print("Enter course title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter course credit: ");
                    int credit = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter course department: ");
                    String department = sc.nextLine();
                    Course course = new Course(credit, title, id, department);
                    if (courseList.addCourse(course)) {
                        System.out.println("Course added successfully!");
                    } else {
                        System.out.println("Course not added!");
                    }
                }
                case 2 -> {
                    System.out.println("Course List");
                    System.out.println("-------------------------------------------------------------");
                    System.out.println(String.format("%-10s%-30s%2s %-10s", "ID", "Title", "Credit", "Department"));
                    System.out.println("-------------------------------------------------------------");
                    for (Course c : courseList.getCourses()) {
                        if (c != null)
                            System.out.println(c);
                    }
                    System.out.println("-------------------------------------------------------------");
                }
                case 3 -> {
                    System.out.print("Enter course ID to remove: ");
                    String idToRemove = sc.nextLine();
                    if (courseList.removeCourse(idToRemove)) {
                        System.out.println("Course removed successfully!");
                    } else {
                        System.out.println("Course not found or unable to remove.");
                    }
                }
                default ->
                        System.out.println("Invalid choice!");
                }
                } while (choice != 0);

    }

    private static void initData(CourseList courseList) {
        Course course1 = new Course(1, "Java Programming", "FIT101", "FIT");
        Course course2 = new Course(2, "Web Programming","FIT102" , "FIT");
        Course course3 = new Course(3, "Database Programming","FIT103" , "FIT");


        courseList.addCourse(course1);
        courseList.addCourse(course2);
        courseList.addCourse(course3);

    }
}

