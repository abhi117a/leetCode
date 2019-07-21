import java.util.*;
import java.util.Arrays;
import java.util.LinkedList;

public class Treess {

  private static TreeNode root;
  private static final String NULL_SYMBOL = "X";
  private static final String DELIMITER = ",";

  private TreeNode addTree(int data) {

    if (root == null) {
      root = new TreeNode(data);
      return root;
    }
    TreeNode child = root;
    TreeNode parent = null;

    while (child != null) {
      parent = child;
      if (child.data > data) {
        child = child.left;
      } else {
        child = child.right;
      }
    }
    if (parent.data > data) {
      parent.left = new TreeNode(data);
    } else {
      parent.right = new TreeNode(data);
    }

    return root;
  }

  public void inorder(TreeNode root) {
    if (root == null) {
      return;
    } else {
      inorder(root.left);
      System.out.print(root.data + " ");
      inorder(root.right);
    }
  }

  public void postOrd(TreeNode root) {
    postOrd(root.left);
    postOrd(root.right);
    System.out.println(root.data);
  }

  private void LevelOrderTraversal(TreeNode root) {

    if (root == null) {
      return;
    }
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    while (!q.isEmpty()) {
      TreeNode tmp = q.poll();
      System.out.print(tmp.data + " ");
      if (tmp.left != null) {
        q.offer(tmp.left);
      }
      if (tmp.right != null) {
        q.offer(tmp.right);
      }
    }
  }

  private void LevelOrderTraversalReverse(TreeNode root) {
    if (root == null) {
      return;
    }
    Queue<TreeNode> qu = new LinkedList<>();
    Stack<TreeNode> st = new Stack<>();
    qu.offer(root);
    while (!qu.isEmpty()) {
      TreeNode tmp = qu.poll();
      st.push(tmp);
      if (tmp.right != null) {
        qu.offer(tmp.right);
      }
      if (tmp.left != null) {
        qu.offer(tmp.left);
      }
    }

    while (!st.isEmpty()) {
      System.out.print(st.pop().data + " ");
    }
  }

  private void HeightOfATree(TreeNode root) {
    Queue<TreeNode> qu = new LinkedList<>();
    int height = 0;
    if (root == null) {
      return;
    }
    qu.offer(root);
    qu.offer(null);

    while (!qu.isEmpty()) {
      TreeNode tmp = qu.poll();
      if (tmp == null) {
        if (!qu.isEmpty()) {
          qu.offer(null);
        }
        height++;
      } else {
        if (tmp.left != null) {
          qu.offer(tmp.left);
        }
        if (tmp.right != null) {
          qu.offer(tmp.right);
        }
      }
    }
    System.out.println("Height is: " + height);
  }

  private void findMinimumHeight(TreeNode root) {
    if (root == null) {
      return;
    }

    Queue<TreeNode> qu = new LinkedList<>();
    int height = 1;
    qu.offer(root);
    qu.offer(null);
    while (!qu.isEmpty()) {
      TreeNode tmp = qu.poll();

      if (tmp != null) {
        if (tmp.left == null && tmp.right == null) {
          System.out.println("Min Height is: " + height);
          return;
        } else {
          if (tmp.left != null) {
            qu.offer(tmp.left);
          }
          if (tmp.right != null) {
            qu.offer(tmp.right);
          }
        }
      }
      if (tmp == null) {
        if (!qu.isEmpty()) {
          qu.offer(null);
        }
        height++;
      }
    }
  }

  private int heightOfTree(TreeNode root) {
    if (root == null) {
      return 0;
    } else {
      int lHeight = heightOfTree(root.left);
      int rHeight = heightOfTree(root.right);

      return lHeight > rHeight ? lHeight + 1 : rHeight + 1;
    }
  }

  private boolean isMirror(TreeNode node1, TreeNode node2) {

    if (node1 == null && node2 == null) {
      return true;
    }
    if (node1 != null && node2 != null && node1.data == node2.data) {
      return (isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left));
    }
    return false;
  }

  private int HeightOfATreeRecursive(TreeNode root) {
    if (root == null) {
      return 0;
    } else {
      return ((1 + HeightOfATreeRecursive(root.left) + HeightOfATreeRecursive(root.right)));
    }
  }

  private void widthOfBinaryTree(TreeNode root) {

    if (root == null) {
      return;
    }
    int tmpWidth = 0;
    int maxWidth = Integer.MIN_VALUE;
    Queue<TreeNode> qu = new LinkedList<>();
    qu.offer(root);
    qu.offer(null);
    while (!qu.isEmpty()) {
      TreeNode tmp = qu.poll();
      if (tmp != null) {
        tmpWidth++;
        if (tmp.left != null) {
          qu.offer(tmp.left);
        }
        if (tmp.right != null) {
          qu.offer(tmp.right);
        }
      } else if (tmp == null) {
        if (!qu.isEmpty()) {
          if (maxWidth < tmpWidth) {
            maxWidth = tmpWidth;
          }
          qu.offer(null);
          tmpWidth = 0;
        }
      }
    }
    if (tmpWidth > maxWidth) {
      maxWidth = tmpWidth;
    }
    System.out.println("Width is: " + maxWidth);
  }

  private void printLeafNodes(TreeNode root) {

    if (root == null) {
      return;
    }
    if (root.right == null && root.left == null) {
      System.out.println(root.data);
    } else {
      printLeafNodes(root.left);
      printLeafNodes(root.right);
    }
  }

  private boolean hasPathSum(TreeNode root, int sum) {

    if (root == null) {
      return false;
    } else if (root.left == null && root.right == null && root.data == sum) {
      return true;
    } else {
      return (hasPathSum(root.left, sum - root.data) || hasPathSum(root.right, sum - root.data));
    }
  }

  private void makeTreeMirrorImage(TreeNode root1) {

    if (root1 != null) {
      makeTreeMirrorImage(root1.left);
      makeTreeMirrorImage(root1.right);
      TreeNode tmp = root1.left;
      root1.left = root1.right;
      root1.right = tmp;
    }
  }

  private TreeNode LCA(TreeNode root, TreeNode n1, TreeNode n2) {

    if (root == null) {
      return null;
    }
    if (root == n1 || root == n2) {
      return root;
    }
    TreeNode left = LCA(root.left, n1, n2);
    TreeNode right = LCA(root.right, n1, n2);

    if (left != null && right != null) {
      return root;
    }
    return left != null ? left : right;
  }

  /// Diameter of a Tree

  private int diameterOfTree(TreeNode root) {

    if (root == null) {
      return 0;
    }

    int left = HeightOfATreeRecursive(root.left);
    int right = HeightOfATreeRecursive(root.right);

    int lDia = diameterOfTree(root.left);
    int rDia = diameterOfTree(root.right);

    return Math.max(left + right + 1, Math.max(lDia, rDia));
  }

  // If given a PreOrder and Inorder create a tree out of it

  // In preorder you get the root as the firstElement, find the element in InOrder arrray, elements
  // left of root will be left subtree and right for rightSubtree

  private TreeNode createATree(int[] preOrd, int[] InOrd, int iStart, int iEnd) {
    int counter = 0;
    if (iStart > iEnd) {
      return null;
    }

    TreeNode root = new TreeNode(preOrd[counter++]);
    if (iStart == iEnd) {
      return root;
    }
    int index = getIndexofRootFromInOrd(root, InOrd, iStart, iEnd);
    root.left = createATree(preOrd, InOrd, iStart, index - 1);
    root.right = createATree(preOrd, InOrd, index + 1, iEnd);

    return root;
  }

  private int getIndexofRootFromInOrd(TreeNode root, int[] InOrd, int iStart, int iEnd) {
    for (int i = iStart; i < iEnd; i++) {
      if (root.data == InOrd[i]) {
        return i;
      }
    }
    return -1;
  }

  private List<Integer> printRightSideOfTree(TreeNode root) {
    List<Integer> visible = new ArrayList<>();
    Queue<TreeNode> qu = new LinkedList<>();
    if (root == null) {
      return visible;
    }
    qu.offer(root);
    while (!qu.isEmpty()) {
      int size = qu.size();
      for (int i = 0; i < size; i++) {
        TreeNode tmp = qu.poll();
        if (i == size - 1) {
          visible.add(tmp.data);
        }
        if (tmp.left != null) {
          qu.offer(tmp.left);
        }
        if (tmp.right != null) {
          qu.offer(tmp.right);
        }
      }
    }
    return visible;
  }

  private boolean checkIfTreeIsBST(TreeNode root, int min, int max) {

    if (root == null) {
      return true;
    }

    if (root.data <= min || root.data >= max) {
      return false;
    }

    return checkIfTreeIsBST(root.left, min, root.data)
        && checkIfTreeIsBST(root.right, root.data, max);
  }

  private boolean isSymmetric(TreeNode root) {

    return helper(root, root);
  }

  private boolean helper(TreeNode node1, TreeNode node2) {

    if (node1 == null && node2 == null) {
      return true;
    }

    if (node1 == null || node2 == null) {
      return false;
    }

    if (node1 != null && node2 != null && node1.data == node2.data) {
      return true;
    }
    return helper(node1.left, node2.right) && helper(node1.right, node2.left);
  }

  // Serialize and Deserialize a tree

  public String serialize(TreeNode root) {
    if (root == null) {
      return NULL_SYMBOL + DELIMITER;
    }
    String leftSerialized = serialize(root.left);
    String rightSerialized = serialize(root.right);

    return root.data + DELIMITER + leftSerialized + rightSerialized;
  }

  public TreeNode deSerialize(String s) {
    Queue<String> qu = new LinkedList<>();
    qu.addAll(Arrays.asList(s.split(DELIMITER)));
    return deSerializeHelper(qu);
  }

  private TreeNode deSerializeHelper(Queue<String> nodesLeftToMaterialize) {
    String valueForNode = nodesLeftToMaterialize.poll();
    if (valueForNode == NULL_SYMBOL) {
      return null;
    }
    TreeNode nodee = new TreeNode(Integer.valueOf(valueForNode));
    nodee.left = deSerializeHelper(nodesLeftToMaterialize);
    nodee.right = deSerializeHelper(nodesLeftToMaterialize);

    return nodee;
  }

  private void zigZagTree(TreeNode root) {

    Stack<TreeNode> curr = new Stack<>();
    Stack<TreeNode> nextLev = new Stack<>();
    boolean leftToRight = true;
    curr.push(root);
    while (!curr.isEmpty()) {

      TreeNode t = curr.pop();

      if (leftToRight) {
        if (t.left != null) {
          nextLev.push(t.left);
        }
        if (t.right != null) {
          nextLev.push(t.right);
        }
      } else {
        if (t.right != null) {
          nextLev.push(t.right);
        }
        if (t.left != null) {
          nextLev.push(t.left);
        }
      }

      if (curr.isEmpty()) {
        leftToRight = !leftToRight;
        Stack<TreeNode> tmp = curr;
        curr = nextLev;
        nextLev = tmp;
      }
    }
  }

  // 108. Convert Sorted Array to Binary Search Tree

  private TreeNode convertArrayToBInaryTree(int nums[]) {

    if (nums.length == 0 || nums == null) {
      return null;
    }
    return convertHelper(nums, 0, nums.length - 1);
  }

  private TreeNode convertHelper(int[] nums, int left, int right) {
    if (left > right) {
      return null;
    }
    int mid = left + (right - left) / 2;

    TreeNode current = new TreeNode(nums[mid]);
    current.left = convertHelper(nums, left, mid - 1);
    current.right = convertHelper(nums, mid + 1, right);
    return current;
  }

  private boolean leafSimilar(TreeNode root1, TreeNode root2) {

    Queue<TreeNode> tree1 = new LinkedList<>();
    Queue<TreeNode> tree2 = new LinkedList<>();
    List<Integer> tre1 = new ArrayList<>();
    List<Integer> tre2 = new ArrayList<>();
    tree1.add(root1);
    tree2.add(root2);

    while (!tree1.isEmpty()) {
      TreeNode tmp = tree1.poll();
      if (tmp.left == null && tmp.right == null) {
        tre1.add(tmp.data);
      } else {
        if (tmp.left != null) {
          tree1.add(tmp.left);
        }
        if (tmp.right != null) {
          tree1.add(tmp.right);
        }
      }
    }

    while (!tree2.isEmpty()) {
      TreeNode tmp = tree2.poll();
      if (tmp.left == null && tmp.right == null) {
        tre2.add(tmp.data);
      } else {
        if (tmp.left != null) {
          tree2.add(tmp.left);
        }
        if (tmp.right != null) {
          tree2.add(tmp.right);
        }
      }
    }
    if (tre1.size() != tre2.size()) {
      return false;
    }
    for (int i = 0; i < tre1.size(); i++) {
      if (tre1.get(i) != tre2.get(i)) {
        return false;
      }
    }
    return true;
  }

  public static void main(String args[]) {

    Treess t = new Treess();
    int[] keys = {15, 10, 20, 8, 12, 16, 25};
    for (int x : keys) {
      t.addTree(x);
    }

    t.inorder(root);
    System.out.println(" ");
    t.LevelOrderTraversal(root);
    System.out.println(" ");
    t.LevelOrderTraversalReverse(root);
    t.HeightOfATree(root);
    t.findMinimumHeight(root);
    System.out.println(t.heightOfTree(root));
    System.out.println(" Recursive Height ");
    System.out.println(t.HeightOfATreeRecursive(root));
    t.widthOfBinaryTree(root);
    System.out.println(" Leaf Node printing ");
    t.printLeafNodes(root);
    System.out.println("ZigZag");
  }
}
