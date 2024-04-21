// @author Furkan Tosun / @since 03.03.24

public class Assignment01_20220808025 {

    public static void main(String[] args) {

       // Create a Course object 'c' with the following details:
        // department: "CSE", course number: 102, title: "Programming 2", description: "Introduction to 00P", ECTS: 6
        Course c = new Course ("CSE", 102, "Programming 2", "Introduction to 00P", 6);
        System.out.println(c.courseCode() + " " + c.getTitle());

System.out.println(c);
    Teacher t = new Teacher("Joseph LEDET", "josephledet@akdeniz.edu.tr", 123L, "CSE", 1);
System.out.println(t);
    Student s = new Student ("Test STUDENT", "me@somewhere.com", 456L, "CSE");
System.out.println(s);
s.passCourse (c); // Student 's' passes course 'c'
System.out.println(s.getAkts());
System.out.println("------");
    Course course = new Course ("CSE", 101, "Computer Programming 1", "Introduction to Programming", 6);
    Student student = new Student ("Can DO", "cando@akdeniz.edu.tr", 123L, "CSE");
student.passCourse (course); // Student 'student' passes course 'course'
course.setCourseNumber(course.getCourseNumber() + 10);
System.out.println(student);
System.out.println(course);
    course = new Course ("CSE", 102, "Computer Programming 2", "Introduction to OOP", 4);
student.passCourse (course); // Student 'student' passes course 'course'
course.setCourseNumber(course.getCourseNumber() - 1);
System.out.println(course);
System.out.println(student);
        GradStudent newgrad=new GradStudent("Test STUDENT", "me@somewhere.com", 20220808025L, "CSE",3,"OOP");
        System.out.println(newgrad);
        System.out.println(newgrad.getLevel());

        Course cs = new Course("CSE", 102, "Programming 2", "Introduction to OOP", 6);
        System.out.println("Course Code: " + cs.courseCode());
        System.out.println("Course Title: " + cs.getTitle());
        System.out.println("Course Details: " + cs);

        // Test Teacher class
        Teacher ts = new Teacher("Joseph LEDET", "josephledet@akdeniz.edu.tr", 123L, "CSE", 1);
        System.out.println("Teacher Details: " + ts);
        ts.promote(); // Promote the teacher
        System.out.println("After Promotion: " + ts);

        // Test Student class
        Student ss = new Student("Test STUDENT", "me@somewhere.com", 456L, "CSE");
        System.out.println("Student Details: " + ss);
        System.out.println("Student AKTS: " + ss.getAkts());

        // Test passCourse method
        s.passCourse(cs);
        System.out.println("After Passing Course: " + cs);
        System.out.println("Student AKTS after passing course: " + cs.getAkts());

        // Test GradStudent class
        GradStudent newgrads = new GradStudent("Test STUDENT", "me@somewhere.com", 20220808025L, "CSE", 3, "OOP");
        System.out.println("Grad Student Details: " + newgrads);
        System.out.println("Grad Student Level: " + newgrads.getLevel());
        System.out.println("Grad Student Thesis Topic: " + newgrads.getThesisTopic());




        



    }

}
class Course{
    private String departmentCode;
    private int courseNumber;

    private String title;
    private  String description;
    private int akts;

public Course(String departmantCode, int courseNumber, String title, String description, int akts){
setDepartmentCode(departmantCode);
setCourseNumber(courseNumber);
setTitle(title);
setAkts(akts);
setDescription(description);
}

    public String getDepartmentCode() {
        return departmentCode;
    }


    public void setDepartmentCode(String departmentCode) {
    if(departmentCode.length()!=3 && departmentCode.length()!=4){
        throw new RuntimeException("ERROR: Invalid Department Code");}
    else{ this.departmentCode = departmentCode; }
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(int courseNumber) {
    if (100<courseNumber && courseNumber<1000) {this.courseNumber = courseNumber;}
    else if (5000<courseNumber && courseNumber<5999){this.courseNumber=courseNumber;}
    else if (7000<courseNumber && courseNumber<7999){this.courseNumber=courseNumber;}
    else throw new RuntimeException("ERROR: Invalid Course Number");}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAkts() {
        return akts;
    }

    public void setAkts(int akts) {

    if(akts>=0){    this.akts = akts;}
    else throw new RuntimeException("ERROR: Invalid AKTS");
    }
    public String courseCode(){
    return departmentCode+courseNumber;
    }

    @Override
    public String toString() {
        return courseCode()+ " - "+ title+ " ("+ akts + ")";
    }
}


class Person{
    private String name;
    private String email;
    private long id;
    private String departmentCode;
public Person(String name, String email, long id, String departmentCode){
    setName(name);
    setEmail(email);
    setId(id);
    setDepartmentCode(departmentCode);
}

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String[] parts = email.split("@");
        if (parts.length != 2) {
            throw new RuntimeException("ERROR: Invalid Email Format");
        }

        String[] domainParts = parts[1].split("\\.");
        if (domainParts.length != 2 && domainParts.length !=3) {
            throw new RuntimeException("ERROR: Invalid Email Format");
        }

        this.email = email;
    }


    @Override
    public String toString() {
        return name+" - ("+id+") - "+email;
    }
}

class Teacher extends Person {
    private int rank;

    public Teacher(String name, String email, long id, String deparmentCode, int rank) {
        super(name, email, id, deparmentCode);
        setRank(rank);
    }

    public void setRank(int rank) {
        if (rank > 0 && rank < 5) {
            this.rank = rank;
        }
        else throw new RuntimeException("ERROR: Invalid rank");
    }

    public String getTitle() {
        switch (rank) {
            case 1:
                return "Lecturer";
            case 2:
                return "Assistant Professor";
            case 3:
                return "Associate Professor";
            case 4:
                return "Professor";
            default:
                System.out.println("ERROR: Invalid rank");
                return "Error";
        }
    }

    public void promote(){
        if(rank!=4) {rank++;}
    }
    public void  demote(){
        if(rank!=0){rank--;}

    }

    @Override
    public String toString() {
        return getTitle()+ " " +super.toString();
    }
}


class Student extends Person {
    private int akts;
    public Student(String  name,String  email,long id, String department){
    super(name,email,id,department);
    this.akts = 0;
    }

    public int getAkts() {
        return akts;
    }
    public void passCourse(Course course) {
    this.akts+=course.getAkts();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

class GradStudent extends Student{
    private int rank;
    private String thesisTopic;
    public GradStudent(String name, String email, long id, String department, int rank, String thesisTopic){
    super(name,email,id,department);
    setRank(rank);
    this.thesisTopic=thesisTopic;
    }

    public void setRank(int rank) {
        if(rank>0 && rank<4){this.rank = rank;}
        else throw new RuntimeException("ERROR: Invalid rank");
    }
    public String getLevel(){
    switch (rank){
        case 1: return "Master’s Student";
        case 2: return "Doctoral Student";
        case 3: return  "Doctoral Candidate";
        default:
            System.out.println("error");
    }
return "error";

    }

    public String getThesisTopic() {
        return thesisTopic;
    }

    public void setThesisTopic(String thesisTopic) {
        this.thesisTopic = thesisTopic;
    }

}


