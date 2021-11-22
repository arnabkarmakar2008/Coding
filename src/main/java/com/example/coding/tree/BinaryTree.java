package com.example.coding.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

    public Node root;

    public BinaryTree(int key) {
        root = new Node(key);
    }

    public BinaryTree() {
        root = null;
    }

    public static int count=0;
    public static int postOrderCount=0;
    public static int sumOfParent;

    public static void inorderTraversal(Node rootNode) {
        if (rootNode == null) {
            return;
        }

        inorderTraversal(rootNode.left);
        System.out.println(rootNode.key + " ");
        inorderTraversal(rootNode.right);
    }

    public static void postOrderTraversal(Node rootNode) {
        if (rootNode == null) {
            return;
        }

        postOrderTraversal(rootNode.left);
        postOrderTraversal(rootNode.right);
        System.out.println(rootNode.key + " ");
    }

    public static void levelOrderTraversal(Node root) {
        if (root == null) {
            return;
        } else if (root.left == null && root.right == null) {
            System.out.println(root.key);
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            Node temp = queue.peek();
            System.out.println(temp.key);
            queue.remove();

            if (temp.left != null) {
                queue.add(temp.left);
            }

            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
    }

    public static void levelOrderTraversalSpiral(Node root) {
        if (root == null) {
            return;
        }

        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        s1.push(root);

        while (!s1.empty() || !s2.empty()) {
            while (!s1.empty()) {
                Node temp = s1.peek();
                s1.pop();

                System.out.println(temp.key + " ");

                if (temp.right != null) {
                    s2.push(temp.right);
                }

                if (temp.left != null) {
                    s2.push(temp.left);
                }
            }

            while (!s2.empty()) {
                Node temp = s2.peek();
                s2.pop();

                System.out.println(temp.key + " ");

                if (temp.left != null) {
                    s1.push(temp.left);
                }

                if (temp.right != null) {
                    s1.push(temp.right);
                }
            }
        }

    }

    public static void levelOrderTraversalLineByLine(Node root) {
        /**
         * OP : 1
         *      2 3
         *      4 5 6 7
         */

        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while(!queue.isEmpty()) {
            Node current = queue.poll();

            if (current == null) {
                if (!queue.isEmpty()) {
                    queue.add(null);
                    System.out.println();
                }
            } else {
                if (current.left != null) {
                    queue.add(current.left);
                }

                if (current.right != null) {
                    queue.add(current.right);
                }
                System.out.print(current.key + " ");
            }


        }
    }


    public static void postOrderNthElement(Node root, int n) {
        if (root == null) {
            return;
        }

        if (postOrderCount <= n) {
            postOrderNthElement(root.left, n);
            postOrderNthElement(root.right, n);
            postOrderCount++;

            if (postOrderCount == n) {
                System.out.println("Nth Element :: " + root.key);
            }
        }

    }

    public static void inOrderNthElement(Node root, int n) {
        if (root == null) {
            return;
        }

        if (count <= n) {
            inOrderNthElement(root.left, n);
            count++;

            if (count == n) {
                System.out.println("Nth Element :: " + root.key);
            }

            inOrderNthElement(root.right, n);
        }

    }

    /**
     * Insert at first empty left or right node
     * @param root
     * @param key
     */
    public static void insert(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            Node temp = queue.peek();
            queue.remove();

            if (temp.left == null) {
                temp.left = new Node(key);
                break;
            } else {
                queue.add(temp.left);
            }

            if (temp.right == null) {
                temp.right = new Node(key);
                break;
            } else {
                queue.add(temp.right);
            }
        }

    }

    /**
     * Delete node with deepest node
     * @param root
     * @param key
     */
    public static void delete(Node root, int key) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            if (root.key == key) {
                root = null;
            }
        }

        Node keyNode = null;
        Node temp = null;
        Node last = null; // Parent of deepest node

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            temp = queue.peek();
            queue.remove();

            if (temp.key == key) {
                keyNode = temp;
            }

            if (temp.left != null) {
                last = temp;
                queue.add(temp.left);

            }

            if (temp.right != null) {
                last = temp;
                queue.add(temp.right);
            }
        }

        if (keyNode != null) {
            keyNode.key = temp.key;

            if (last.right == temp) {
                last.right = null;
            } else {
                last.left = null;
            }
        }
    }

    public static void inorderTraversalWithoutRecursion(Node root) {
        if (root == null) return;

        Stack<Node> stack = new Stack<>();
        Node current = root;

        while (current != null || stack.size()>0) {
            while (current != null) {
                stack.push(current); //Go till farthest left. This will push root node as well.
                current = current.left;
            }

            current = stack.pop();
            System.out.println(current.key);

            current = current.right;
        }
    }

    public static int sumOfAllNode(Node root) {
        if (root == null) {
            return 0;
        }

        return root.key + sumOfAllNode(root.left) + sumOfAllNode(root.right);
    }

    public static void sumOfParentNodeWithChild(Node root, int key) {
        if (root == null) {
            return;
        }

        if ((root.left!= null && root.left.key == key) || (root.right!= null && root.right.key == key)) {
            sumOfParent = sumOfParent + root.key;
        }

        sumOfParentNodeWithChild(root.left, key);
        sumOfParentNodeWithChild(root.right, key);
    }

    public static int leftLeafSum;
    public static void sumOfLeftLeaf(Node root) {
        if (root == null) {
            return;
        }

        if (isLeaf(root.left)) {
            leftLeafSum += root.left.key;
        } else {
            sumOfLeftLeaf(root.left);
        }

        sumOfLeftLeaf(root.right);
    }

    public static boolean isLeaf(Node node) {
        if (node == null) {
            return false;
        }
        if (node.right == null && node.left == null) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(1);

        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        inorderTraversal(tree.root);

        /*insert(tree.root, 8);
        System.out.println("========");
        inorderTraversal(tree.root);
        delete(tree.root, 2);
        System.out.println("===========");
        inorderTraversal(tree.root);
*/
        System.out.println("===========");

        inorderTraversalWithoutRecursion(tree.root);
        System.out.println("===========");
        inOrderNthElement(tree.root, 3);
        System.out.println("===========");

        postOrderTraversal(tree.root);
        System.out.println("===========");
        postOrderNthElement(tree.root, 3);
        System.out.println("===========");
        levelOrderTraversal(tree.root);

        System.out.println("===========");
        levelOrderTraversalSpiral(tree.root);

        System.out.println("===========");
        levelOrderTraversalLineByLine(tree.root);

        System.out.println("Sum of all node :: " + sumOfAllNode(tree.root));

        sumOfParentNodeWithChild(tree.root, 4);
        System.out.println("Sum of parent :: " + sumOfParent);
        sumOfLeftLeaf(tree.root);
        System.out.println("Sum of left leaf :: " + leftLeafSum);
    }
}
