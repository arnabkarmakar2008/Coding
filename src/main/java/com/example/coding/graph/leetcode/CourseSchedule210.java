package com.example.coding.graph.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule210 {

  /**
   * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
   * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must
   * take course bi first if you want to take course ai.
   *
   * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
   * Return the ordering of courses you should take to finish all courses. If there are many valid answers,
   * return any of them. If it is impossible to finish all courses, return an empty array.
   */

  public static int[] findOrder(int numCourses, int[][] prerequisites) {
    int[] answer = new int[numCourses];
    int[] indegree = new int[numCourses];
    int courseTaken = 0;
    ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
    Queue<Integer> queue = new LinkedList<>();

    for (int ct=0; ct < numCourses; ct++) {
      adjList.add(ct, new ArrayList<>());
    }

    for (int ct=0; ct < prerequisites.length; ct++) {
      adjList.get(prerequisites[ct][1]).add(prerequisites[ct][0]);
      indegree[prerequisites[ct][0]]++;
    }

    for (int ct=0; ct<numCourses; ct++) {
      if (indegree[ct] == 0) {
        queue.add(ct);
      }
    }

    while (!queue.isEmpty()) {
      int topCourse = queue.remove();
      answer[courseTaken] = topCourse;
      courseTaken++;

      for (Integer adjCourse : adjList.get(topCourse)) {
        if (--indegree[adjCourse] == 0) {
          queue.add(adjCourse);
        }
      }
    }

    if (courseTaken == numCourses) {
      return answer;
    } else {
      return new int[numCourses];
    }
  }

  public static void main(String[] args) {
    int[][] courses = {{1,0},{2,0},{3,1},{3,2}};
    int[] ans = findOrder(4, courses);
    for (int course : ans)
      System.out.println(course);
  }
}
