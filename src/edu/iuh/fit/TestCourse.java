/*
 * @(#) TestCourse.java     1.0     8/29/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package edu.iuh.fit;

import java.util.List;
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
        CourseList courseList = new CourseList(5);

        initData(courseList);

        int choice;
        do {
            System.out.println("1. Add a course");
            System.out.println("2. Display all courses");
            System.out.println("3. Remove a course");
            System.out.println("4. Find a course by id");
            System.out.println("5. Find a course by title");
            System.out.println("6. Find a course by department");
            System.out.println("7. Sort courses by course title");
            System.out.println("8. Find courses with the highest number of credits");
            System.out.println("9. Find the department with the most courses");
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
                case 4 -> {
                    System.out.print("Enter course ID to find: ");
                    String idToFind = sc.nextLine();
                    if (courseList.findCourseById(idToFind) != null) {
                        System.out.println("Found course: " + courseList.findCourseById(idToFind));
                    } else {
                        System.out.println("Course with ID " + idToFind + " not found.");
                    }
                }
                case 5 -> {
                    System.out.println("Enter course title to find : ");
                    String titleToFind = sc.nextLine();
                    if (courseList.findCourseByTitle(titleToFind) != null) {
                        System.out.println("Found course: " + courseList.findCourseByTitle(titleToFind));
                    } else {
                        System.out.println("Course with title " + titleToFind + " not found.");
                    }
                }
                case 6 -> {
                    System.out.println("Enter course department to find : ");
                    String departmentToFind = sc.nextLine();
                    if (courseList.findCourseByDepartment(departmentToFind) != null) {
                        System.out.println("Found course: " + courseList.findCourseByDepartment(departmentToFind));
                    } else {
                        System.out.println("Course with department " + departmentToFind + " not found.");
                    }
                }
                case 7 -> {
                    List<Course> coursesWithMaxCredits = courseList.findCoursesWithHighestCredits();
                    if (coursesWithMaxCredits != null && !coursesWithMaxCredits.isEmpty()) {
                        System.out.println("Courses with the highest number of credits:");
                        for (Course c : coursesWithMaxCredits) {
                            System.out.println(c);
                        }
                    } else {
                        System.out.println("No course");
                    }
                }
                case 8 -> {
                    String departmentWithMostCourses = courseList.findDepartmentWithMostCourses();
                    if (departmentWithMostCourses != null) {
                        System.out.println("Department with the most courses: " + departmentWithMostCourses);
                    } else System.out.println("No departments found.");
                }
                case 9 -> {
                    String findDepartmentWithMostCourses = courseList.findDepartmentWithMostCourses();
                    if (findDepartmentWithMostCourses != null) {
                        System.out.println("Department with the most courses: " + findDepartmentWithMostCourses);
                    } else {
                        System.out.println("No departments found.");
                    }
                }
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice! Please enter a number between 0 and 9.");
            }
        } while (choice != 0);

        sc.close(); // Close the scanner
    }

    private static void initData(CourseList courseList) {
        Course course1 = new Course(2, "Java Programming", "FIT101", "FIT");
        Course course2 = new Course(2, "Web Programming","FIT102" , "FIT");
        Course course3 = new Course(3, "Database Programming","FIT103" , "FIT");


        courseList.addCourse(course1);
        courseList.addCourse(course2);
        courseList.addCourse(course3);

    }
}

