public class Trees {

  public static TreeNodee root;

  public TreeNodee creatTree(int data) {

    if (root == null) {
      root = new TreeNodee(data);
      return root;
    }

    TreeNodee parent = null;
    TreeNodee child = root;

    while (child != null) {
      parent = child;
      if (child.key > data) {
        child = child.left;
      } else {
        child = child.right;
      }
    }

    if (parent.key > data) {
      parent.left = new TreeNodee(data);
    } else {
      parent.right = new TreeNodee(data);
    }
    return root;
  }

  public void inorder(TreeNodee root) {
    if (root == null) {
      return;
    } else {
      inorder(root.left);
      System.out.println(root.key + " ");
      inorder(root.right);
    }
  }

  public static void main(String[] args) {
    Trees t = new Trees();
    int[] keys = {15, 10, 20, 8, 12, 16, 25};
    for (int x : keys) {
      t.creatTree(x);
    }
    t.inorder(root);
  }
}
