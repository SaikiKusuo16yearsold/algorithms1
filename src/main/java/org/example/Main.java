package org.example;

import org.example.StringList;
import org.example.myArrayList;

import java.util.List;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        StringList stringList = new myArrayList(3);
        stringList.add("ass");


        stringList.add(1, "zovi kurit");

        stringList.set(1, "gavai");

        String[] myArray = stringList.toArray();
        for (int i = 0; i < myArray.length; i++) {
            System.out.println(myArray[i]);

        }
    }
}
