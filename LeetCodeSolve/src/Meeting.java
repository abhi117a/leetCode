import java.util.List;

public class Meeting {
  private int startTime;
  private int endTime;

  public Meeting(int startTime, int endTime) {
    // number of 30 min blocks past 9:00 am
    this.startTime = startTime;
    this.endTime = endTime;
  }

  public int getStartTime() {
    return startTime;
  }

  public void setStartTime(int startTime) {
    this.startTime = startTime;
  }

  public int getEndTime() {
    return endTime;
  }

  public void setEndTime(int endTime) {
    this.endTime = endTime;
  }

  private void mergeRanges(List<Meeting> meeting) {}

  public static void main(String[] args) {}
}
