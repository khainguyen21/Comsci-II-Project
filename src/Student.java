import com.fasterxml.jackson.annotation.JsonProperty;

public class Student {
    @JsonProperty("Name")
    private String name;

    @JsonProperty("Age")
    private long age;

    @JsonProperty("Major")
    private String major;

    @JsonProperty("Hobby")
    private String hobby;

    @JsonProperty("Interest")
    private String interest;

    @JsonProperty("StudentID")
    private long studentID;

    public Student(String name, long age, String major, String hobby, String interest, long studentID) {
        this.interest = interest;
        this.hobby = hobby;
        this.major = major;
        this.age = age;
        this.name = name;
        this.studentID = studentID;
    }

    // Getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public long getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getMajor() { return major; }
    public void setMajor(String major) { this.major = major; }

    public String getHobby() { return hobby; }
    public void setHobby(String hobby) { this.hobby = hobby; }

    public String getInterest() { return interest; }
    public void setInterest(String interest) { this.interest = interest; }

    public long getStudentId() { return studentID; }
    // PROPERLY IMPLEMENTED toString()
    @Override
    public String toString() {
        return String.format(
                "Student[name=%s, age=%d, major=%s, hobby=%s, interest=%s, id=%d]",
                name, age, major, hobby, interest, studentID
        );
    }
}