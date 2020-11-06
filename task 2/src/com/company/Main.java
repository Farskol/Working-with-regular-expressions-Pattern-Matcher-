package com.company;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static int Size(String input) {
        int j = 0;
        for(int i = 0; i < input.length(); ++i) {
            if (input.charAt(i) == '<' && input.charAt(i + 1) != '/') {
                ++j;
            }
        }
        return j;
    }

    public static String[] ArrayOfTegs(String input) {
        String[] array = new String[Size(input)];
        int k = 0;
        for(int i = 0; i < input.length(); ++i) {
            if (input.charAt(i) == '<' && input.charAt(i + 1) != '/') {
                array[k] = "";
                for(int j = i + 1; input.charAt(j) != '>'; ++j) {
                    array[k] = array[k] + input.charAt(j);
                }
                ++k;
            }
        }
        return array;
    }
    public static void main(String[] args) {
        String input = "";
        try(FileReader reader = new FileReader("notes.txt"))
        {
            int c;
            while((c=reader.read())!=-1){
                input += (char) c;
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        Scanner console = new Scanner(System.in);
        String[] array = new String[Size(input)];
        array = ArrayOfTegs(input);
        int sizeOfNotes = 0;
        for(int i = 1; i < array.length; ++i) {
            for(int j = 0; j < array[i].length(); ++j) {
                int f = array[i].charAt(j);
                if (f > '/' && f < ':') {
                    ++sizeOfNotes;
                    break;
                }
            }
        }
        System.out.println("We have " + sizeOfNotes + " " + array[0] + ":");
        System.out.println("Please write number of " + array[0] + "what you want read");
        String WrittenNumberOfNotes = console.nextLine();
        int numberOfNotes = WrittenNumberOfNotes.charAt(0);

        for(int i = 1; i < array.length; ++i) {
            String note = "";
            boolean flag = false;
            Matcher matcher_2;
            Pattern pattern_3;
            for(int j = 0; j < array[i].length(); ++j) {
                int f = array[i].charAt(j);
                if (f == numberOfNotes) {
                    String secondWord = "";
                    for(int k = 0; k < array[i].length() && array[i].charAt(k) != ' '; ++k) {
                        secondWord = secondWord + array[i].charAt(k);
                    }
                    pattern_3 = Pattern.compile("<" + array[i] + ">\\D*</" + secondWord + ">");
                    matcher_2 = pattern_3.matcher(input);
                    if (matcher_2.find()) {
                        note = matcher_2.group();
                    }
                    flag = true;
                    break;
                }
            }
            String[] newArray = new String[Size(note)];
            newArray = ArrayOfTegs(note);
            if (flag) {
                System.out.println("In " + WrittenNumberOfNotes + " written:");
                for(int j = 1; j < newArray.length && !newArray[j].endsWith("/"); ++j) {
                    Pattern pattern_2 = Pattern.compile("<" + newArray[j] + ">\\D*</" + newArray[j] + ">");
                    pattern_3 = Pattern.compile("<" + newArray[j] + ">|</" + newArray[j] + ">");
                    matcher_2 = pattern_2.matcher(input);
                    System.out.print(newArray[j] + " -> ");
                    if (matcher_2.find()) {
                        String str = matcher_2.group();
                        Matcher matcher_3 = pattern_3.matcher(str);
                        str = "";
                        System.out.println(matcher_3.replaceAll(str));
                    }
                }
            }
        }
    }
}
