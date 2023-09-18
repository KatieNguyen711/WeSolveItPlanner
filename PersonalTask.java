/**
 * This class stores attributes of personal events.
 *
 * @author Alexandria Zacherl
 * @version 0.1 (4/28/23)
 */

public class PersonalTask extends Task
{
    //instance variables
    private String birthday;
    private String anniversary;
    private String otherEvents;

    /**constructor with parameters*/
    public PersonalTask(String birthday, String anniversary, String otherEvents)
    {
        this.birthday = birthday;
        this.anniversary = anniversary;
        this.otherEvents = otherEvents;
    }

    /**constructor without parameters*/
    public PersonalTask()
    {
        super();
        birthday = "";
        anniversary = "";
        otherEvents = "";
    }

    /**
     * Accessor method
     * @return This method returns a birthday that a user saves in this calendar.
     */
    public String getBirthday() {return task;}

    /**
     * Accessor method
     * @return It returns an anniversary that a user saves in this calendar.
     */
    public String getAnniversary() {return task;}

    /**
     * Accessor method
     * @return It returns an event that a user saves in this calendar.
     */
    public String getEvent() {return task;}

    /**
     * Setter method
     * @param birthdayIn Birthday of someone who is important to a user.
     */
    public void setBirthday(String birthdayIn)
    {
        task = birthdayIn;
    }

    /**
     * Setter method
     * @param anniversaryIn User's anniversary to celebrate.
     */
    public void setAnniversary(String anniversaryIn)
    {
        task = anniversaryIn;
    }

    /**
     * Setter method
     * @param otherEventsIn Events that are important to a user other than birthday and anniversary.
     */
    public void setEvent(String otherEventsIn)
    {
        task = otherEventsIn;
    }

    /**
     * returns name, date, time, and location about the event.
     * @return description of personal tasks.
     */
    @Override
    public String toString() {
        return "Name : " + task + "\nDate : " + date + "\nTime : " + time + "\nLocation : " + location + "\n";
    }
}