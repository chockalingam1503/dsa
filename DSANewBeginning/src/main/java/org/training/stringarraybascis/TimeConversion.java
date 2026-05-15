package org.training.stringarraybascis;

import java.util.Scanner;

public class TimeConversion {

    //    My initial solution
    public static String timeConversion(String s) {


        if (Integer.parseInt(s.substring(0, 2)) > 12) {
            return "Enter valid format";

        }
        StringBuilder sb = new StringBuilder();
        if (s.endsWith("PM")) {
            s = s.replace("PM", "");
            String arr[] = s.split(":");
            if (!arr[0].equals("12"))
                sb.append(String.valueOf((Integer.parseInt(arr[0]) + 12))).append(":").append(arr[1]).append(":").append(arr[2]);
            else
                sb.append(s);
        } else if (s.endsWith("AM") && s.startsWith("12")) {
            s = s.replace("AM", "");
            s = s.replaceFirst("12", "00");
            sb.append(s);
        } else {
            s = s.replace("AM", "");
            sb.append(s);
        }


        return sb.toString();
    }

    public static String timeConversionImprovised(String s) {

        int hour = Integer.parseInt(s.substring(0, 2));
        if (hour > 12 && hour <01) {
            return "Enter valid format";
        }
        boolean secondHalf = s.endsWith("PM");
       // s = s.replace(s.substring(s.length()-2, s.length()), "");
        s = s.substring(0,8);
        if (!secondHalf && hour == 12) s = s.replaceFirst("12", "00");
        if (!secondHalf) return s;

        hour = (hour != 12) ?  hour + 12 :hour;
        s = s.replace(s.substring(0, 2), String.valueOf(hour));

        return s;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read single time
        String time = sc.next();
        System.out.println(time);

        // Read full line
        String line = sc.nextLine();
        System.out.println(line);

        sc.close();

        System.out.println(timeConversionImprovised(time));


    }

}
