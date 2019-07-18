package Graph;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

  public int getData() {
    return data;
  }

  public void setData(int data) {
    this.data = data;
  }

  public boolean isVisited() {
    return visited;
  }

  public void setVisited(boolean visited) {
    this.visited = visited;
  }

  public List<Vertex> getNeighborList() {
    return neighborList;
  }

  public void setNeighborList(List<Vertex> neighborList) {
    this.neighborList = neighborList;
  }

  private int data;
  private boolean visited;
  private List<Vertex> neighborList;

  Vertex(int data) {
    this.data = data;
    this.neighborList = new ArrayList<>();
  }

  public void addNeighbourList(Vertex vertex) {
    this.neighborList.add(vertex);
  }

  @Override
  public String toString() {
    return "Vertex{" + "data=" + data + '}';
  }
}
