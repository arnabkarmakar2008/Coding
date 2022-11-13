package com.example.coding.tree.misc;

import com.example.coding.tree.Node;

import java.util.*;

/**
 * Given the root of a binary tree, the value of a target node target, and an integer k,
 * return an array of the values of all nodes that have a distance k from the target node.
 *
 * You can return the answer in any order.
 */
public class AllNodeAtKDistance {

  /*public static void kDown(Node targetNode, int k, Node blockerNode, ArrayList<Integer> answer) {
    if (k < 0 || targetNode == null || targetNode == blockerNode) {
      return;
    }

    if (k == 0) {
      answer.add(targetNode.key);
      return;
    }

    kDown(targetNode.left, k-1, blockerNode, answer);
    kDown(targetNode.right, k-1, blockerNode, answer);

  }

  public static boolean rootToNode(Node root, int target, Stack<Node> stack) {
    if (root == null) {
      return false;
    }

    // Push node in stack
    stack.push(root);

    if (root.key == target) {
      return true;
    }

    boolean leftTraversal = rootToNode(root.left, target, stack);

    if (leftTraversal == true) {
      return true;
    } else if (rootToNode(root.right, target, stack)) {
      return true;
    } else {
      // Target node is not there in left and right subtree. So remove.
      stack.pop();
      return false;
    }
  }

  public static void allKDistanceNodes(Node root, int targetNode ,int k) {
    // First get root to node path for target node
    Stack<Node> targetToRootPath = new Stack<>();
    rootToNode(root, targetNode, targetToRootPath);

    ArrayList<Integer> answer = new ArrayList<>();

    int distance = 0;
    Node previousNode = null;
    while (!targetToRootPath.isEmpty() && distance <= k) {
      Node currentNode = targetToRootPath.pop();
      kDown(currentNode, k - distance, previousNode, answer); // Have to do k - distance as we are travelling that
      // much distance and then we have to travel further
      distance++;
    }

    System.out.println(answer.size());
  }
*/

  /**
   * https://www.youtube.com/watch?v=i9ORlEy6EsI
   * @param root
   * @param parentMap
   */

  private static void createParentMap(Node root, Map<Node, Node> parentMap) {
    Queue<Node> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      Node current = queue.poll();

      if (current.left != null) {
        parentMap.put(current.left, current);
        queue.offer(current.left);
      }

      if (current.right != null) {
        parentMap.put(current.right, current);
        queue.offer(current.right);
      }
    }
  }


  private static Node getTargetNode(Node root, int target) {
    if (root == null) {
      return null;
    }

    if (root.key == target) {
      return root;
    }

    Node leftSideNode = getTargetNode(root.left, target);

    if (leftSideNode != null) {
      return leftSideNode;
    } else {
      return getTargetNode(root.right, target);
    }
  }

  private static List<Integer> distanceK(Node root, int target, int distance) {
    Node targetNode = getTargetNode(root, target);

    Map<Node, Node> parentMap = new HashMap<>();
    createParentMap(root, parentMap);

    Map<Node, Boolean> visitedMap = new HashMap<>();
    Queue<Node> queue = new LinkedList<>();

    queue.offer(targetNode);
    visitedMap.put(targetNode, true);

    int currentLevel = 0;

    while (!queue.isEmpty()) {
      int size = queue.size();

      if (currentLevel == distance) {
        break;
      }

      currentLevel++;

      for (int ct=0; ct<size; ct++) {
        Node current = queue.poll();

        if (current.left != null && visitedMap.get(current.left) == null) {
          queue.offer(current.left);
          visitedMap.put(current.left, true);
        }

        if (current.right != null && visitedMap.get(current.right) == null) {
          queue.offer(current.right);
          visitedMap.put(current.right, true);
        }

        if (parentMap.get(current) != null && visitedMap.get(parentMap.get(current)) == null) {
          queue.offer(parentMap.get(current));
          visitedMap.put(parentMap.get(current), true);
        }
      }
    }

    List<Integer> resultList = new ArrayList<>();

    while (! queue.isEmpty()) {
      resultList.add(queue.peek().key);
    }

    return resultList;

  }

  public static void main(String[] args) {
    Node root1 = new Node(1);
    root1.left = new Node(2);
    root1.right = new Node(3);
    root1.left.left = new Node(4);
    root1.left.right = new Node(5);
    root1.right.left = new Node(6);
    root1.right.right = new Node(7);

    root1.right.right.left = new Node(8);
    root1.right.right.right = new Node(9);

    root1.right.right.left.left = new Node(10);
    root1.right.right.left.left.left = new Node(14);
    root1.right.right.left.left.right = new Node(13);

    distanceK(root1, 8, 2);
  }
}
