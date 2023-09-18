/**
 * 
 * This program will allow users to set personal reminders in a digital planner.
 * 
 * This program can set personal and academic reminders by asking the user for the date, time, and location of a task
 * This program also allows users to delete, edit, and display tasks in their planner, as well as display a list of federal holidays
 *
 * @author Katie Nguyen, Alexandria Zacherl, Jinhui Oh
 * @version 0.5 (4/28/23)
 * */

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.util.InputMismatchException;

public class Calender {
    /**
     * Main method
     * <p>
     * Calls all other task classes
     */
    public static void main(String[] args) {
        //local variables
        ///counter will help keep track of how many times an input is in the list
        Scanner stdip = new Scanner(System.in);
        int userInt = 0;
        String userString = "";
        int counter = 0;
        BufferedReader br = null;
        ArrayList<Task> taskList = new ArrayList<Task>();
        ArrayList<String> taskNameList = new ArrayList<String>();

        //print welcome message and menu options
        System.out.println("Hi, I'm your calendar  /( °-°)/");

        //input validation
        while (userInt != 6) {
            System.out.println("\n1) Add Task \n2) Delete Task \n3) Change Task \n4) Display Task \n5) Display federal holidays \n6) Exit");
            System.out.print("\nPlease select the option above: ");
            userInt = stdip.nextInt();
            //if user input is not in range 1-6
            if (userInt < 1 || userInt > 6) {
                System.out.print("You entered: " + userInt + "\n");
                System.out.print("Sorry, " + userInt + " is not a valid option.\n\n");
            } else if (userInt == 1) {
                System.out.print("You entered: " + userInt + "\n");
                System.out.print("Is this a reminder for your school or others?: ");
                String schoolOrOthers = stdip.nextLine();
                schoolOrOthers = stdip.nextLine();

                if (schoolOrOthers.equals("school")) {
                    AcademicTask at = new AcademicTask();
                    System.out.print("Please enter a name for your task: ");
                    userString = stdip.nextLine();
                    taskNameList.add(userString);
                    at.setTask(userString);
                    System.out.print("Please enter due date of task (e.g. 01/31/2023): ");
                    String date = stdip.nextLine();

                    if (at.checkDate(date)) {
                        at.setDate(date);
                        System.out.print("which course is this task for? (e.g. CPSC 1302): ");
                        userString = stdip.nextLine();
                        at.setCourse(userString);
                        System.out.print("Please enter the time the task is due (e.g. 05:20): ");
                        String time = stdip.nextLine();

                        if (at.checkTime(time)) {
                            at.setTime(time);
                            System.out.print("Please enter the location of your task: ");
                            userString = stdip.nextLine();
                            at.setLocation(userString);
                            taskList.add(at);
                            System.out.println("\nI added this event on your calendar! ");
                        } else {
                            System.out.println("Sorry, " + time + " is not a valid time. Try again.");
                        }
                    } else {
                        System.out.println("Sorry, " + date + " is not a valid date. Try again.");
                    }
                } else if (schoolOrOthers.toLowerCase().equals("others")) {
                    System.out.print("\nPlease select the type of reminder:\n1) Birthday\n2) Anniversary\n3) Other Event \n");
                    try {
                        int taskType = stdip.nextInt();
                        System.out.println("You entered " + taskType + "\n");
                        if (taskType == 1) {
                            PersonalTask pt = new PersonalTask();
                            System.out.print("Whose birthday is it? ");
                            String bdayPerson = stdip.nextLine();
                            bdayPerson = stdip.nextLine();
                            pt.setBirthday(bdayPerson + "'s Birthday");
                            taskNameList.add(bdayPerson + "'s Birthday");
                            System.out.print("When is " + bdayPerson + "'s birthday party? (e.g. 01/31/2023): ");
                            String date = stdip.nextLine();

                            if (pt.checkDate(date)) {
                                pt.setDate(date);
                                System.out.print("Where is this birthday party happening at?: ");
                                String location = stdip.nextLine();
                                pt.setLocation(location);
                                System.out.print("What time is the event? (e.g. 10:00): ");
                                String time = stdip.nextLine();
                                if (pt.checkTime(time)){
                                    pt.setTime(time);
                                    taskList.add(pt);
                                    System.out.println("\nI added this event on your calendar! ");
                                }else{
                                    System.out.println("Sorry, " + time + " is not a valid time. Try again.");
                                }
                            } else {
                                System.out.println("Sorry, " + date + " is not a valid date. Try again.");
                            }
                        }
                        if (taskType == 2) {
                            PersonalTask pt = new PersonalTask();
                            System.out.print("What's the anniversary for?: ");
                            String anniversaryType = stdip.nextLine();
                            anniversaryType = stdip.nextLine();
                            pt.setAnniversary(anniversaryType);
                            taskNameList.add(anniversaryType);
                            System.out.print("When is " + anniversaryType + "? (e.g. 01/31/2023): ");
                            String date = stdip.nextLine();
                            if (pt.checkDate(date)) {
                                pt.setDate(date);
                                System.out.print("Where is this event happening at?: ");
                                String location = stdip.nextLine();
                                pt.setLocation(location);
                                System.out.print("What time is the event (e.g. 10:00)?: ");
                                String time = stdip.nextLine();
                                if (pt.checkTime(time)) {
                                    pt.setTime(time);
                                    taskList.add(pt);
                                    System.out.println("\nI added this event on your calendar! ");
                                } else {
                                    System.out.println("Sorry, " + time + " is not a valid time. Try again.");
                                }
                            }else {
                                System.out.println("Sorry, " + date + " is not a valid date. Try again.");
                            }
                        } else if (taskType == 3) {
                            PersonalTask pt = new PersonalTask();
                            System.out.print("What's this event for?: ");
                            String eventType = stdip.nextLine();
                            eventType = stdip.nextLine();
                            pt.setAnniversary(eventType);
                            taskNameList.add(eventType);
                            System.out.print("When is this event happening? (e.g. 01/31/2023): ");
                            String date = stdip.nextLine();
                            if (pt.checkDate(date)){
                                pt.setDate(date);
                                System.out.print("Where is this event happening at?: ");
                                String location = stdip.nextLine();
                                pt.setLocation(location);
                                System.out.print("What time is the event? (e.g. 10:00): ");
                                String time = stdip.nextLine();
                                if (pt.checkTime(time)) {
                                    pt.setTime(time);
                                    taskList.add(pt);
                                    System.out.println("\nI added this event on your calendar! ");
                                }else{
                                    System.out.println("Sorry, " + time + " is not a valid time. Try again.");
                                }
                            }else{
                                System.out.println("Sorry, " + date + " is not a valid date. Try again.");
                            }
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Sorry, your response is not valid. Please try again. ");
                    }

                } else {
                    System.out.println("Sorry, your response is neither school nor others. Please try again.");
                }
            } else if (userInt == 2) {
                System.out.print("You entered: " + userInt + "\n");
                if (taskNameList.size() == 0) {
                    System.out.println("Sorry, there is nothing to delete.");
                } else if (taskNameList.size() > 0) {
                    System.out.println("\nHere is the list of tasks in your calendar: ");
                    for (int index = 0; index < taskNameList.size(); ++index) {
                        if (taskNameList.size() != 0) {
                            System.out.println("* " + taskList.get(index).getTask());
                        }
                    }
                    counter = 0;
                    System.out.println("\nPlease enter the task you would like to delete: ");
                    userString = stdip.nextLine();
                    userString = stdip.nextLine();
                    for (int i = 0; i < taskList.size(); ++i) {
                        if (userString.equals(taskList.get(i).getTask())) {
                            System.out.println("\nOkay :D Let me delete " + userString + ".");
                            taskList.remove(i);
                            taskNameList.remove(i);
                            System.out.println("Deletion complete!");
                            ++counter;
                        }
                    }
                    if (counter == 0) {
                        System.out.println("Sorry, " + userString + " does not exist. Please try again");
                    }
                }
            } else if (userInt == 3) {
                System.out.print("You entered: " + userInt + "\n");
                if (taskNameList.size() == 0) {
                    System.out.println("Sorry, there is nothing to change..");
                } else if (taskNameList.size() > 0) {
                    System.out.println("\nHere is the list of tasks in your calendar: ");
                    for (int index = 0; index < taskNameList.size(); ++index) {
                        if (taskNameList.size() != 0) {
                            System.out.println("* " + taskList.get(index).getTask());
                        }
                    }
                    int taskToChange = 0;
                    System.out.println("\nPlease enter the task you would like to change: ");
                    userString = stdip.nextLine();
                    userString = stdip.nextLine();
                    for (int index2 = 0; index2 < taskList.size(); ++index2) {
                        if (userString.equals(taskList.get(index2).getTask())) {
                            taskToChange = index2;
                        }
                    }
                    System.out.print("\nWhat do you want to change about " + userString + "? \n1) Name \n2) Date \n3) Time \n4) Location \n");
                    userString = stdip.nextLine();
                    if ((!(Integer.parseInt(userString) == 1 && Integer.parseInt(userString) == 2 && Integer.parseInt(userString) == 3 && Integer.parseInt(userString) == 4))) {
                        if (Integer.parseInt(userString) == 1) {
                            System.out.println("Please enter the new name for the task: ");
                            String newName = stdip.nextLine();
                            taskList.get(taskToChange).setTask(newName);
                        } else if (Integer.parseInt(userString) == 2) {
                            System.out.println("Please enter the new date for the task: ");
                            String newDate = stdip.nextLine();
                            taskList.get(taskToChange).setDate(newDate);
                        } else if (Integer.parseInt(userString) == 3) {
                            System.out.println("Please enter the new time for the task: ");
                            String newTime = stdip.nextLine();
                            taskList.get(taskToChange).setTime(newTime);
                        } else if (Integer.parseInt(userString) == 4) {
                            System.out.println("Please enter the new location for the task: ");
                            String newLocation = stdip.nextLine();
                            taskList.get(taskToChange).setLocation(newLocation);
                        }
                        System.out.println("\nIt's changed!\nHere is the updated task: \n");
                        System.out.println(taskList.get(taskToChange).toString());
                    }
                }
            } else if (userInt == 4) {
                System.out.print("You entered: " + userInt + "\n");
                System.out.println("Which do you want to do? \n1) Show all tasks \n2) Show specific task \n3) Show tasks on specific day");
                userInt = stdip.nextInt();

                if (userInt == 1) {
                    //displays all items in arraylist
                    for (int i = 0; i < taskList.size(); i++) {
                        System.out.println(taskList.get(i).toString());
                    }

                } else if (userInt == 3) {
                    //Show all tasks on a specific day
                    System.out.println("Which day did you want to see?: ");
                    userString = stdip.nextLine();
                    userString = stdip.nextLine();
                    for (int i = 0; i < taskList.size(); i++) {
                        if (taskList.get(i).getDate().equals(userString)) {
                            System.out.println("\n"+taskList.get(i).toString());
                            counter++;
                        }
                    }
                    if (counter == 0) {
                        System.out.println("Sorry. Your task does not exist.");
                    }

                } else if (userInt == 2) {
                    //show specific task
                    if (taskNameList.size() == 0) {
                        System.out.println("Sorry, there are no tasks.");
                    } else if (taskNameList.size() > 0) {
                        System.out.println("\nHere is the list of tasks in your calendar: ");
                        for (int index = 0; index < taskNameList.size(); ++index) {
                            if (taskNameList.size() != 0) {
                                System.out.println("* " + taskList.get(index).getTask());
                            }
                        }
                        System.out.println("Which task did you want to see?: ");
                        counter = 0;
                        userString = stdip.nextLine();
                        userString = stdip.nextLine();
                        for (int i = 0; i < taskList.size(); i++) {
                            if (taskList.get(i).getTask().equals(userString)) {
                                System.out.println(taskList.get(i).toString());
                                counter++;
                            }
                        }
                        if (counter == 0) {
                            System.out.println("Sorry. Your task does not exist.");
                        }
                    } else {
                        System.out.println("Invalid Input.");
                    }
                }
            } else if (userInt == 5) {
                System.out.print("You entered: " + userInt + "\n");
                System.out.print("Here is the list of federal holidays:" + "\n");

                try {
                    String fileName = "FedHolidays.txt";
                    br = new BufferedReader(new FileReader(fileName));
                    Scanner fileScanner = new Scanner(br);

                    while (fileScanner.hasNext()) {
                        System.out.println(fileScanner.nextLine());
                    }
                    br.close();
                } catch (Exception e) {
                    System.out.println("failed");
                    e.getMessage();
                }

            }
        }
        System.out.print("You entered: " + userInt + "\n");
        System.out.print("Thank you! /( °-°)/");
        System.exit(0);
    }
}