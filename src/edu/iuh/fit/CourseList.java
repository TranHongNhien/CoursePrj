/*
 * @(#) CourseList.java     1.0     8/29/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package edu.iuh.fit;

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

    public Course[] getCourses() {
        return courses;
    }
}

