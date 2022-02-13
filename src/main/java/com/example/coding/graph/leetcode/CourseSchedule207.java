package com.example.coding.graph.leetcode;

import java.util.*;

public class CourseSchedule207 {

  /**
   * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
   * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must
   * take course bi first if you want to take course ai.
   *
   * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
   * Return true if you can finish all courses. Otherwise, return false.
   * @param numCourses
   * @param prerequisites
   * @return
   */
  public static boolean canFinish(int numCourses, int[][] prerequisites) {
    int courseTakenCount =0;
    //Create adjList and indegree array
    int[] indegree = new int[numCourses];
    Map<Integer, ArrayList<Integer>> adjMap = new HashMap<Integer, ArrayList<Integer>>();

    for (int ct=0; ct<numCourses; ct++) {
      adjMap.put(ct, new ArrayList<>());
    }

    for (int ct=0; ct< prerequisites.length; ct++) {
      adjMap.get(prerequisites[ct][1]).add(prerequisites[ct][0]);
      indegree[prerequisites[ct][0]] ++;
    }

    Queue<Integer> queue = new LinkedList<>();

    for (int ct=0; ct<numCourses; ct++) {
      if (indegree[ct] == 0) {
        queue.add(ct);
      }
    }

    while (!queue.isEmpty()) {
      courseTakenCount++;
      int topCourse = queue.poll();

      for (Integer adj : adjMap.get(topCourse)) {
        indegree[adj]--;
        if (indegree[adj] == 0) {
          queue.add(adj);
        }
      }
    }

    return courseTakenCount == numCourses;
  }

  public static void main(String[] args) {
    int[][] prerequisites = {{2,1},{2,0},{1,0}};
    System.out.println(canFinish(3, prerequisites));
  }
}
