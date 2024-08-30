/*
 * @(#) CourseList.java     1.0     8/29/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package edu.iuh.fit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * @description
 * @author: Nhien Tran
 * @date:    8/29/2024
 * @version: 1.0
 */
public class CourseList {
    private Course[] courses;
    private static int count = 0;


    public CourseList(int n) {
        if (n <= 0)
            throw new IllegalArgumentException("Length of the array must be greater than 0");
        courses = new Course[n]; // create an array of n elements
    }


    public boolean addCourse(Course course) {
        if(course == null)
            return false;
        if(exists(course))
            return false;
        if (count == courses.length)
            return false;
        courses[count++] = course;
        return true;
    }

    private boolean exists(Course course) {
        for (int i = 0; i < count; i++) {
            if (courses[i] != null && courses[i].getId().equalsIgnoreCase(course.getId()))
                return true;
        }
        return false;
    }

    public boolean removeCourse(String courseId) {
        for (int i = 0; i < courses.length; i++) {
            if (courses[i] != null && courses[i].getId().equals(courseId)) {
                courses[i] = null;
                return true;
            }
        }
        return false;
    }

    public Course findCourseById(String courseId) {
        for (Course course : courses) {
            if (course != null && course.getId().equals(courseId)) {
                return course;
            }
        }
        return null;
    }

    public Course findCourseByTitle(String courseName) {
        for (Course course : courses) {
            if (course != null && course.getTitle().equals(courseName)) {
                return course;
            }
        }
        return null;
    }

    public Course findCourseByDepartment(String courseDepartment) {
        for (Course course : courses) {
            if (course != null && course.getDepartment().equals(courseDepartment)) {
                return course;
            }
        }
        return null;
    }

//    public Course SortCourseByTitle()
//    {
//
//    };

    public List<Course> findCoursesWithHighestCredits() {
        List<Course> result = new ArrayList<>();
        if (courses.length == 0) {
            return result;
        }

        int maxCredits = 0;

        // First pass to find the maximum number of credits
        for (Course course : courses) {
            if (course != null && course.getCredit() > maxCredits) {
                maxCredits = course.getCredit();
            }
        }

        // Second pass to collect courses with the maximum credits
        for (Course course : courses) {
            if (course != null && course.getCredit() == maxCredits) {
                result.add(course);
            }
        }

        return result;
    }

    public String findDepartmentWithMostCourses() {
        // Use a map to count courses per department
        java.util.Map<String, Integer> departmentCount = new java.util.HashMap<>();
        for (Course course : courses) {
            if (course != null) {
                departmentCount.put(course.getDepartment(),
                        departmentCount.getOrDefault(course.getDepartment(), 0) + 1);
            }
        }

        // Find the department with the highest count
        String departmentWithMostCourses = null;
        int maxCount = 0;
        for (java.util.Map.Entry<String, Integer> entry : departmentCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                departmentWithMostCourses = entry.getKey();
            }
        }

        return departmentWithMostCourses;
    }


    public Course[] getCourses() {
        return courses;
    }
}

