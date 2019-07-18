package lambdaStreamPractice;

import java.util.List;

public class Students {

  private String name;
  private int age;
  private Address address;
  private List<MobileNumber> mobileNumbers;

  public Students(String name, int age, Address address, List<MobileNumber> mobileNumbers) {
    this.name = name;
    this.age = age;
    this.address = address;
    this.mobileNumbers = mobileNumbers;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public List<MobileNumber> getMobileNumbers() {
    return mobileNumbers;
  }

  public void setMobileNumbers(List<MobileNumber> mobileNumbers) {
    this.mobileNumbers = mobileNumbers;
  }

  @Override
  public String toString() {
    return "Students{"
        + "name='"
        + name
        + '\''
        + ", age="
        + age
        + ", address="
        + address
        + ", mobileNumbers="
        + mobileNumbers
        + '}';
  }
}
