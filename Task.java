/**
 * This is the parent class for PersonalTask and AcademicTask. This stores name, date, location, and time.
 *
 * @author Katie Nguyen, Jinhui Oh
 * @version 0.3 (4/28/23)
 */

import java.util.ArrayList;
public class Task {
    // instance variables
    protected String date;
    protected String time;
    protected String task;
    protected String location;

    /**
     * Constructor for objects of class Task
     */
    public Task(){
        task = null;
        location = null;
    }

    /**
     * This will set the date for a specific task
     *
     * @param date of the task
     */
    public void setDate(String date){
        this.date = date;
    }

    /**
     * This will set the time of a specific task
     *
     * @param time of task
     */
    public void setTime(String time){
        this.time = time;
    }
    /**
     * This will set the name of the task
     * @param task name
     */
    public void setTask(String task){
        this.task = task;
    }

    /**
     * This will set the location of the task
     * @param location
     */
    public void setLocation(String location){
        this.location = location;
    }

    /**
     * This will return the date of a task
     * @return date
     */
    public String getDate(){return date;}

    /**
     * This will return the time of a task
     * @return
     */
    public String getTime(){return time;}

    /**
     * This will return the name of a task
     * @return task name
     */
    public String getTask(){
        return task;
    }

    /**
     * This will return the location of a task
     * @return location
     */
    public String getLocation(){
        return location;
    }

    /**
     * This will check if the time is a valid input by checking if there is a column in the middle and the length is 5
     * @param time It is a time when a task is due or when an event happens
     * @return  true if the time is valid and false if it is not
     */
    public boolean checkTime(String time){
        if (time.length()>=3) {
            Character column = time.charAt(2);
            if (column.equals(':') && time.length() == 5) {
                return true;
            } else {
                return false;
            }
        }else{
            return false;
        }
    }
    /**
     * This will check if the time is a valid input by checking if there is a column in the middle and the length is 5
     * @param date It is a date when a task is due or when an event happens
     * @return  true if the time is valid and false if it is not
     */
    public boolean checkDate(String date) {
        if (date.length() >= 6) {
            Character dash1 = date.charAt(2);
            Character dash2 = date.charAt(5);
            if (dash1.equals('/') && dash2.equals('/') && date.length() == 10) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    /**
     * This is the base of the toString methods for the child classes
     * @return a base description of a task
     */
    public String toString(){
        return "Name : " + task + "\nDate : " + date + "\nTime : ";
    }
}
