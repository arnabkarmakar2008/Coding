package com.example.coding.dynamicprogramming.leetcode.multidm;

import java.util.*;

/**
 * A frog is crossing a river. The river is divided into some number of units, and at each unit,
 * there may or may not exist a stone. The frog can jump on a stone, but it must not jump into the water.
 *
 * Given a list of stones' positions (in units) in sorted ascending order, determine if the
 * frog can cross the river by landing on the last stone. Initially, the frog is on the first stone and
 * assumes the first jump must be 1 unit.
 *
 * If the frog's last jump was k units, its next jump must be either k - 1, k, or k + 1 units.
 * The frog can only jump in the forward direction.
 */
public class FrogJump {

  /**
   * Note :  https://www.youtube.com/watch?v=1V8gRXh1qbU
   * {0,1,3,5,6,8,12,17}
   * Create a hashmap ad store stones a key. Populate where we can jump from each stone,
   * 0 -> 1 ## As from the first stone we take 1 jump. So 0+1 we will land to stone 1. So from stone 1 we can take 0,1,2 jump. Do not take 0. So update stone 1 values
   * 1 -> 1,2 ## 1+1 = 2. But 2 is water so continue. 1+2 = 3. So we can reach stone 3 by taking 2 steps. So from 3 we can take 1,2,3 steps.
   * 3 -> 1,2,3 3+1=4 water continue, 3+2=5 so we can reach 5 by taking 2 steps. So from 5 we can take 1,2,3 steps. 3+3=6 so from 6 we can take 2,3,4 steps.
   * 5 -> 1,2,3 5+1=6, so we can reach 6 by taking 1 step. So from 6 we can take 1,2 steps. Update 6. 5+2=7 water continue. 5+3=8 so we can reach 8 by taking 3 steps. So from 8 we can take 2,3,4
   * 6 -> 1, 2,3,4 6+1=7 water continue. 6+2 =8 we can take 2 steps to 8. So from 8 we can take 1,2,3, steps. Update 8. 6+3=9 water continue. 6+4=10 water continue.
   * 8-> 1,2,3,4 8+4 =12. Stone 12 can be reached by 4 steps. So from 12 we can take 3,4,5 steps.
   * 12-> 3,4,5 12+5 =17. 17 is the last stone. So we can reach from start to end.
   * @param stones
   * @return
   */
  public static boolean canCross(int[] stones) {

    Map<Integer, Set<Integer>> map = new HashMap<>();

    for (int i=0; i<stones.length; i++) {
      map.put(stones[i], new HashSet<Integer>());
    }

    map.get(0).add(1);

    for (int i=0; i<stones.length; i++) {
      int stoneIndex = stones[i];
      Set<Integer> jumpList = map.get(stoneIndex);

      for (int numberOfJump : jumpList) {
        int newStone = stoneIndex + numberOfJump;

        if (newStone == stones[stones.length-1]) {
          return true;
        }

        if (!map.containsKey(newStone)) continue;
        else {
          Set<Integer> existingJumpList = map.get(newStone);
          // So here we can take numberOfJump steps to reach stone newStone. So from newStone we can take numberOfJump-1, numberOfJump and numberOfJump+1 steps.
          if (numberOfJump-1 != 0) existingJumpList.add(numberOfJump-1);
          existingJumpList.add(numberOfJump);
          existingJumpList.add(numberOfJump+1);
        }
      }

    }

    return false;
  }

  public static void main(String[] args) {
    int[] stones = {0,1,3,5,6,8,12,17};
    System.out.println(canCross(stones));
  }
}
