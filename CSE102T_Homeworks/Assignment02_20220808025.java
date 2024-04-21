// @author Furkan Tosun / @since 03.03.24

import java.util.ArrayList;

public class Assignment02_20220808025 {

    public static void main(String[] args) {

        Department department = new Department("cde","dfdwfs");


    }


}



class Department {
    private String code;
    private  String name;
    private Teacher chair;

    public Department(String code, String name){
        setName(name);
        setCode(code);

    }


    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        if(code.length()!=3 && code.length()!=4){
            throw new InvalidValueException(getClass().getSimpleName(),code); }
        else{ this.code = code; }
    }


    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public Teacher getChair() {
        return chair;
    }

    public void setChair(Teacher chair) {
        if(chair.getDepartment()!=this){throw new DepartmentMismatchException(this,chair);}
        else
            this.chair = chair;
    }

}








class Course{
    private Department department;
    private Teacher teacher;
    private int courseNumber;

    private String title;
    private  String description;
    private int akts;
    private Course course;

public Course(Department department, int courseNumber, String title, String description, int akts, Teacher teacher){



setDepartment(department);
setCourseNumber(courseNumber);
setTitle(title);
setDescription(description);
setAkts(akts);
setTeacher(teacher);


}

    public String courseCode(){
        return department.getCode()+this.courseNumber;
    }

    @Override
    public String toString() {
        return courseCode()+ " - "+ title+ " ("+ akts + ")";
    }

    public void setTeacher(Teacher teacher) {
    if(this.department!=teacher.getDepartment()) {
        throw  new DepartmentMismatchException(this,teacher);} // NEDEN NULL POINTER
    this.teacher = teacher;
    } //Throws DepartmentMismatchException

    public Teacher getTeacher() {
        return teacher;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }


    public int getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(int courseNumber) {
    if (100<courseNumber && courseNumber<1000) {this.courseNumber = courseNumber;}
    else if (5000<courseNumber && courseNumber<5999){this.courseNumber=courseNumber;}
    else if (7000<courseNumber && courseNumber<7999){this.courseNumber=courseNumber;}
    else throw new InvalidValueException(this,courseNumber);} //invalid course number exception

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
    else throw new InvalidValueException(akts); // invalid akts
    }

}


abstract class Person{
    private  Department department;
    private String name;
    private String email;
    private long id;
public Person(String name, String email, long id, Department department){
    setName(name);
    setEmail(email);
    setId(id);
    setDepartment(department);
}

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Department getDepartment() {
        return department;
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
            throw new RuntimeException("ERROR: Invalid Email Format");    // e mail format
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

    public Teacher(String name, String email, long id, Department deparment, int rank) {
        super(name, email, id, deparment);
        setRank(rank);
    }

    @Override
    public void setDepartment(Department department) {
        if(this==department.getChair()){department.setChair(null);}
        super.setDepartment(department);



    }

    public void setRank(int rank) {
        if (rank > 0 && rank <= 5) {
            this.rank = rank;
        }
        else throw new InvalidRankException();
    }

    public String getTitle() {
        switch (rank) {
            case 1:
                return "Teaching Assistant";
            case 2:
                return "Lecturer";
            case 3:
                return "Assistant Professor";
            case 4:
                return "Associate Professor";
            case 5:
                return "Professor";
            default:
                System.out.println("ERROR: Invalid rank");
                return "Error";
        }
    }

    public void promote(){
        if(rank==5) {

            throw new InvalidRankException();}
        else rank++;
    }
    public void  demote(){
        if(rank==1){throw new InvalidRankException();}
        else{ rank--;}

    }

    @Override
    public String toString() {
        return getTitle()+ " " +super.toString();
    }
}


class Student extends Person {
    private ArrayList<Integer>akts_array;
    private  ArrayList<Integer>passed_akts;
    private int akts;
    private ArrayList<Course> course;
    private ArrayList<Double> grade;

    public Student(String  name,String  email,long id,Department department){
    super(name,email,id,department);
    setAKTS(0);
    this.akts_array=new ArrayList<>();
    this.course=new ArrayList<>();
    this.grade=new ArrayList<>();
    this.passed_akts=new ArrayList<>();
    }

    public ArrayList<Integer> getAkts_array() {
        return akts_array;
    }

    public void setAKTS(int akts) {
        this.akts = akts;
    }

    public int getAKTS() {
        // returns total AKTS of student based on passed courses
    int passedakts=0;
        for (int i = 0; i < this.passed_akts.size(); i++) {
            passedakts+=this.passed_akts.get(i);
        }
        return passedakts;
    }
    public int getAttemptedAKTS(){
        for (int i = 0; i < this.akts_array.size(); i++) {
            this.akts+=this.akts_array.get(i);
        }

        return akts;
    }

    public void   addCourse(Course course, double grade){
        if(grade>=46 && !this.course.contains(course)){
            this.passed_akts.add(course.getAkts());
        }


        if(grade<0 || grade>100){throw new InvalidGradeException();}

        int count=0;
        for (int i = 0; i < this.course.size(); i++) {
            if(this.course.get(i)==course){
                count=i;
            }
        }
        if(count!=0){
            this.grade.set(count,grade);
        }
        else {
            this.course.add(course);
            this.grade.add(grade);
            this.akts_array.add(course.getAkts());
        }
    }
    public double courseGPAPoints(Course course){
        if(!this.course.contains(course)){throw new CourseNotFoundException(this,course);}
        // if the course not taken thwrow exception;
       return gpaPoints(this.grade.get(this.course.indexOf(course)));
    }
    public String courseGradeLetter(Course course){ // if the course not taken thwrow exception;

        if(!this.course.contains(course)){throw new CourseNotFoundException(this,course);}
        return  gradeLetter(this.grade.get(this.course.indexOf(course)));
    }
    public String courseResult(Course course){
        if(!this.course.contains(course)){throw new CourseNotFoundException(this,course);}
        return status(this.grade.get(this.course.indexOf(course)));
    }
    public double getGPA(){
        double totalakts=0;
        double totalpoint=0;
        for (int i = 0; i < this.course.size(); i++) {
            totalakts+=this.course.get(i).getAkts();
            totalpoint+=this.course.get(i).getAkts()*gpaPoints(this.grade.get(i));
        }
        return totalpoint/totalakts;

    }

    @Override
    public String toString() {
        return super.toString()+" - GPA : "+getGPA();
    }

    public ArrayList<Course> getCourse() {
        return course;
    }

    public ArrayList<Double> getGrade() {
        return grade;
    }

    public String gradeLetter(double grade) {
        String grade_letter;

        if (grade >= 88) { grade_letter = "AA";}
        else if (grade >= 81) { grade_letter= "BA";}
        else if (grade >= 74) { grade_letter= "BB";}
        else if (grade >= 67) { grade_letter= "CB";}
        else if (grade >= 60) { grade_letter= "CC";}
        else if (grade >= 53) { grade_letter= "DC";}
        else if (grade >= 46) { grade_letter= "DD";}
        else if (grade >= 35) { grade_letter= "FD";}
        else if (grade >= 0) { grade_letter= "FF";}
        else { grade_letter ="invalid value";}

        return grade_letter; }


    public  double gpaPoints(double grade) {
        double gpa_points;
        if (grade >= 88) { gpa_points = 4.0;}
        else if (grade >= 81) { gpa_points= 3.5;}
        else if (grade >= 74) { gpa_points= 3.0;}
        else if (grade >= 67) { gpa_points= 2.5;}
        else if (grade >= 60) { gpa_points= 2.0;}
        else if (grade >= 53) { gpa_points= 1.5;}
        else if (grade >= 46) { gpa_points= 1.0;}
        else if (grade >= 35) { gpa_points= 0.5;}
        else if (grade >= 0) { gpa_points= 0.0;}
        else { gpa_points = 999;}
        return gpa_points; }

    public String status(double grade) {
        String statuss;
        if (grade >= 88) { statuss = "passed";}
        else if (grade >= 81) { statuss= "passed";}
        else if (grade >= 74) { statuss= "passed";}
        else if (grade >= 67) { statuss= "passed";}
        else if (grade >= 60) { statuss= "passed";}
        else if (grade >= 53) { statuss=  "conditionally passed";}
        else if (grade >= 46) { statuss= "conditionally passed";}
        else if (grade >= 35) { statuss= "failed";}
        else if (grade >= 0) { statuss= "failed";}
        else { statuss = "invalid value";}
        return statuss; }

}

class GradStudent extends Student{
    private int rank;
    private String thesisTopic;
    public GradStudent(String name, String email, long id, Department department, int rank, String thesisTopic){
    super(name,email,id,department);
    setRank(rank);
    this.thesisTopic=thesisTopic;
    }

    public void setRank(int rank) {
        if(rank>0 && rank<4){this.rank = rank;}
        else throw new InvalidRankException();
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


    @Override
    public double courseGPAPoints(Course course) {
        return gpaPoints(super.getGrade().get(super.getCourse().indexOf(course)));
    }

    @Override
    public String courseGradeLetter(Course course) {
        return gradeLetter(super.getGrade().get(super.getCourse().indexOf(course)));
    }

    @Override
    public String courseResult(Course course) {
        return status(super.getGrade().get(super.getCourse().indexOf(course)));
    }

    public String getThesisTopic() {
        return thesisTopic;
    }

    public void setThesisTopic(String thesisTopic) {
        this.thesisTopic = thesisTopic;
    }


    public String gradeLetter(double grade) {
        String grade_letter;

        if (grade >= 90) { grade_letter = "AA";}
        else if (grade >= 85) { grade_letter= "BA";}
        else if (grade >= 80) { grade_letter= "BB";}
        else if (grade >= 75) { grade_letter= "CB";}
        else if (grade >= 70) { grade_letter= "CC";}
        else if (grade >= 0) { grade_letter= "FF";}
        else { grade_letter ="invalid value";}

        return grade_letter; }


    public  double gpaPoints(double grade) {
        double gpa_points;
        if (grade >= 90) { gpa_points = 4.0;}
        else if (grade >= 85) { gpa_points= 3.5;}
        else if (grade >= 80) { gpa_points= 3.0;}
        else if (grade >=75) { gpa_points= 2.5;}
        else if (grade >= 70) { gpa_points= 2.0;}
        else if (grade >= 0) { gpa_points= 0.0;}
        else { gpa_points = 999;}
        return gpa_points; }

    public String status(double grade) {
        String statuss;
        if (grade >= 90) { statuss = "passed";}
        else if (grade >= 85) { statuss= "passed";}
        else if (grade >= 80) { statuss= "passed";}
        else if (grade >= 75) { statuss= "passed";}
        else if (grade >= 70) { statuss= "passed";}
        else if (grade >= 0) { statuss= "failed";}
        else { statuss = "invalid value";}
        return statuss; }
}

 class CourseNotFoundException extends RuntimeException {
    private Student student;
    private Course course;

    public CourseNotFoundException(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    @Override
    public String toString() {
        return "CourseNotFoundException: " + student.getId() + " has not yet taken " + course.courseCode();
    }
}

class DepartmentMismatchException extends RuntimeException {
    private  Department department;
    private Teacher person;
    private Course course;

    public  DepartmentMismatchException (Course course, Teacher person){
        setCourse(course);
        setTeacher(person);
        setDepartment(null);

    }
    public  DepartmentMismatchException (Department department, Teacher person){
        setCourse(null);
        setTeacher(person);
        setDepartment(department);

    }

    @Override
    public String toString() {
        if(course==null) {return "DepartmentMismatchException :"+ person.getName()+
                " ("+person.getId()+") cannot be chair of "+department.getCode()+
                " because he/she is currently assigned to "+person.getDepartment().getCode();}
        if(department==null){return "DepartmentMismatchException :"+ person.getName()+
                " ("+person.getId()+") cannot teach "+course.courseCode()+
                " because he/she is currently assigned to "+person.getDepartment().getCode();}

    return "a";
    }


    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setTeacher(Teacher person) {
        this.person = person;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}


class InvalidGradeException extends RuntimeException {
    private  double grade;

    @Override
    public String toString() {
        return "InvalidGradeException : "+grade;
    }
}
class InvalidRankException extends RuntimeException {
    private  int rank;

    @Override
    public String toString() {
        return "InvalidRankException :"+rank;
    }
}
class InvalidValueException extends RuntimeException {
    private Department departmen;
    private String code;
    private Course course;
    private  int courseNumber;
    private int akts;
    private Person person;
    private String email;
    private  String classname;
    private String name;


    public InvalidValueException(String classname,String code){
        setClassname(classname);
        setCode(code);

    }


    public InvalidValueException(Course course, int courseNumber){
        setCourse(course);
        setCourseNumber(courseNumber);
        this.classname="aada";
    }
    public InvalidValueException(int akts){

        setAkts(akts);
        this.classname="a";

    }
    public InvalidValueException(Person person, String email){
        setPerson(person);
        setEmail(email);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setAkts(int akts) {
        this.akts = akts;
    }

    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDepartmen(Department departmen) {
        this.departmen = departmen;
    }

    @Override
    public String toString() {
        if(this.classname.equals("Department"))// bak getClaSSne
            return "InvalidValueException :"+" "+this.classname+" "+this.code+" Invalid Value Attempted. Department Code must be 3 or 4 characters ";
        if (courseNumber!=0)
            return "InvalidValueException :"+" "+this.courseNumber+" Invalid Value Attempted. Course Number must be in the range 100-999 or 5000-5999 or 7000-7999";
        if(akts!=0)
            return "InvalidValueException :"+" "+this.akts+" Invalid Value Attempted. AKTS must be positive";
        if(email!=null)
            return "InvalidValueException :"+" "+this.name+"'s E-mail is invalid"+email;
    return "a";
    }
}














