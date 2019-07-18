public class KnapSack_0_1 {

  private int W;
  private int[] v;
  private int[] w;

  KnapSack_0_1(int W, int[] v, int[] w) {
    this.v = v;
    this.W = W;
    this.w = w;
  }

  private void knapSack() {

    int[][] T = new int[v.length + 1][W + 1];
    for (int i = 1; i < v.length; i++) {
      for (int j = 0; j <= W; j++) {

        if (w[i - 1] > W) {
          T[i][j] = T[i - 1][j];
        } else {
          T[i][j] = Integer.max(v[i - 1] + T[i - 1][j - w[i - 1]], T[i - 1][j]);
        }
      }
    }
  }
}
