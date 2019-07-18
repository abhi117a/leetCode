package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

  public void bfs(Vertex root) {

    Queue<Vertex> qu = new LinkedList<>();

    qu.add(root);
    root.setVisited(true);

    while (!qu.isEmpty()) {

      Vertex actualVertex = qu.remove();
      System.out.println(actualVertex);

      for (Vertex v : actualVertex.getNeighborList()) {
        if (!v.isVisited()) {
          v.setVisited(true);
          qu.add(v);
        }
      }
    }
  }
}
