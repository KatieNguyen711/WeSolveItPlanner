/**
 * Store attributes of Academic reminders
 *
 * @author Katie Nguyen
 * @version 0.2 (4/24/23)
 */
public class AcademicTask extends Task{
    String course = "";
    /**constructor with parameters*/
    public AcademicTask(String course)
    {
        this.course = course;
    }
    /**constructor without parameters*/
    public AcademicTask()
    {
        course = "";
    }
    /**
     * this will make a new course for an academic task
     *
     * @param course name
     */
    public void setCourse(String course){this.course = course;}

    /**
     * this will return what course is stored as
     *
     * @return course name
     */
    public String getCourse(){
        return course;
    }

    @Override
    /**
     * This will return a description of an academic task
     * @return description of task
     */
    public String toString(){
        return "Name : "+ task +"\nDate : " + date + "\nTime : "+ time + "\nLocation : "+ location +"\nCourse : " + course+ "\n";
    }
}
