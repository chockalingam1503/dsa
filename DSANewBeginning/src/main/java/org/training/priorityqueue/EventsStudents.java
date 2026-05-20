package org.training.priorityqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Comparator;

/*
 * Student Class
 */
class Student {

    int id;
    String name;
    double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getID() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getCGPA() {
        return this.cgpa;
    }
}

/*
 * Priorities Class
 */
class Priorities {

    public List<Student> getStudents(List<String> events) {

        PriorityQueue<Student> queue = new PriorityQueue<>(new Comparator<Student>() {

            @Override
            public int compare(Student s1, Student s2) {

                // Higher CGPA first
                if (s2.getCGPA() != s1.getCGPA()) {
                    return Double.compare(s2.getCGPA(), s1.getCGPA());
                }

                // Alphabetical name
                else if (!s1.getName().equals(s2.getName())) {
                    return s1.getName().compareTo(s2.getName());
                }

                // Smaller ID first
                else {
                    return s1.getID() - s2.getID();
                }
            }
        });

        for (String event : events) {

            String[] eventArr = event.split(" ");

            String command = eventArr[0];

            switch (command) {

                case "ENTER":

                    queue.add(
                            new Student(
                                    Integer.parseInt(eventArr[3]),
                                    eventArr[1],
                                    Double.parseDouble(eventArr[2])
                            )
                    );

                    break;

                case "SERVED":

                    queue.poll();
                    break;
            }
        }

        List<Student> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            result.add(queue.poll());
        }

        return result;
    }
}

/*
 * Main Class
 */
public class EventsStudents {

    public static void main(String[] args) {

        List<String> events = new ArrayList<>();

        // Test Cases
        events.add("ENTER John 3.75 50");
        events.add("ENTER Mark 3.8 24");
        events.add("ENTER Shafaet 3.7 35");
        events.add("SERVED");
        events.add("ENTER Samiha 3.85 36");
        events.add("SERVED");
        events.add("ENTER Ashley 3.9 42");
        events.add("ENTER Maria 3.6 46");
        events.add("ENTER Anik 3.95 49");
        events.add("ENTER Dan 3.95 50");

        Priorities priorities = new Priorities();

        List<Student> students = priorities.getStudents(events);

        // Output
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {

            System.out.println("Students remaining in priority order:");

            for (Student student : students) {
                System.out.println(
                        student.getName()
                                + " | CGPA: " + student.getCGPA()
                                + " | ID: " + student.getID()
                );
            }
        }
    }
}
