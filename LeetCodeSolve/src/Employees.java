import java.util.Objects;

public class Employees {

  private String Name;
  private String Job;
  private String Id;

  public Employees(String name, String job, String id) {
    Name = name;
    Job = job;
    Id = id;
  }

  public String getName() {
    return Name;
  }

  public void setName(String name) {
    Name = name;
  }

  public String getJob() {
    return Job;
  }

  public void setJob(String job) {
    Job = job;
  }

  public String getId() {
    return Id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Employees employees = (Employees) o;
    return Objects.equals(Name, employees.Name)
        && Objects.equals(Job, employees.Job)
        && Objects.equals(Id, employees.Id);
  }

  @Override
  public int hashCode() {

    return Objects.hash(Name, Job, Id);
  }

  @Override
  public String toString() {
    return "Employees{"
        + "Name='"
        + Name
        + '\''
        + ", Job='"
        + Job
        + '\''
        + ", Id='"
        + Id
        + '\''
        + '}';
  }

  public void setId(String id) {
    Id = id;
  }
}
