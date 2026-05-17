package org.training.stringarraybascis;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ArrayRot {

    public static List<Integer> circularArrayRotation(List<Integer> a, int k, List<Integer> queries) {



        int  [] tempArray = new int [a.size()];

        k = k%a.size();

        for(int i=0;i<a.size();i++){
            int newIndex = (i+k) % a.size();
            tempArray[newIndex]=a.get(i);
        }
        a = new ArrayList<>(queries.size());

        System.out.println(Arrays.toString(tempArray));

        for(int index: queries){
            a.add(tempArray[index]);
        }

        return a;
    }

    public static void main(String[] args) {

        List<Integer> array = Arrays.asList(1, 2, 3, 4, 5);

        int k = 2;

        List<Integer> queries = Arrays.asList(0, 1, 2, 3, 4);

        List<Integer> result = circularArrayRotation(array, k, queries);

        System.out.println("Rotated Array Elements:");
        System.out.println(result);
    }


}
