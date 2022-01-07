package com.example.coding.graph.algo.kahns;

public class ShortestDistanceFloydWarshall {
  /**
   * Find shortest distance from all nodes to all other nodes. It detects negative cycle as well.
   *
   * dist[i][j] via k = min(dist[i][j], dist[i][k] + dist[k][j])
   * Note : if we have -ve distance from a vertex to itself then we have negative cycle
   */

  public static void floydWarshall(int[][] graph, int N) {
    int dist[][] = new int[N][N];

    for (int i = 0; i<N; i++) {
      for (int j=0; j<N; j++) {
        dist[i][j] = graph[i][j];
      }
    }

    for (int k=0; k<N; k++) { // for all intermediate paths
      for (int i=0; i<N; i++) { // for all starting nodes
        for (int j=0; j<N; j++) { // for all ending nodes
          if (dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE) {
            continue; //unreachable
          } else if ( (dist[i][k] + dist[k][j]) < dist[i][j] ) {
            dist[i][j] = (dist[i][k] + dist[k][j]);
          }
        }
      }
    }

    //Check for negative cycles
    for (int i=0; i<N ; i++) {
      if (dist[i][i] < 0) {
        System.out.println("There is negative cycle");
        return;
      }
    }

    for (int i=0; i<N; i++) {
      for (int j=0; j<N; j++) {
        System.out.println("Shortest distance from "+i+ " to "+j+" is "+dist[i][j]);
      }
    }



  }
}
