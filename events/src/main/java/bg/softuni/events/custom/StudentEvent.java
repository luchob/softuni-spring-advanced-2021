package bg.softuni.events.custom;

import org.springframework.context.ApplicationEvent;

public class StudentEvent extends ApplicationEvent {

  private String studentName;
  private double studentGrade;

  public StudentEvent(String studentName, double studentGrade) {
    super(studentName);
    this.studentName = studentName;
    this.studentGrade = studentGrade;
  }

  public String getStudentName() {
    return studentName;
  }

  public StudentEvent setStudentName(String studentName) {
    this.studentName = studentName;
    return this;
  }

  public double getStudentGrade() {
    return studentGrade;
  }

  public StudentEvent setStudentGrade(double studentGrade) {
    this.studentGrade = studentGrade;
    return this;
  }

  @Override
  public String toString() {
    return "StudentEvent{" +
        "studentName='" + studentName + '\'' +
        ", studentGrade=" + studentGrade +
        '}';
  }
}
