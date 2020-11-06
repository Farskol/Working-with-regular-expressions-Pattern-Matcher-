package com.company;

import java.util.Scanner;

public class Main {
    static String [] Sorter2 (int sizeOfStrings [], String arrayOfStrs [], int n) {
        for(int j = 1; j< sizeOfStrings.length; j++) {
            for (int i = n; i < sizeOfStrings.length - j; i++) {
                if (sizeOfStrings[i] > sizeOfStrings[i + 1]) {
                    int f = sizeOfStrings[i];
                    sizeOfStrings[i] = sizeOfStrings[i + 1];
                    sizeOfStrings[i + 1] = f;
                    String f2 = arrayOfStrs[i];
                    arrayOfStrs [i] = arrayOfStrs[i+1];
                    arrayOfStrs [i+1] = f2;
                }
            }
        }
        return arrayOfStrs;
    }
    static String [] Sorter3 (int sizeOfStrings [], String arrayOfStrs [], int n) {
        for(int j = 1; j< sizeOfStrings.length; j++) {
            for (int i = n; i < sizeOfStrings.length - j; i++) {
                if (sizeOfStrings[i] < sizeOfStrings[i + 1]) {
                    int f = sizeOfStrings[i];
                    sizeOfStrings[i] = sizeOfStrings[i + 1];
                    sizeOfStrings[i + 1] = f;
                    String f2 = arrayOfStrs[i];
                    arrayOfStrs [i] = arrayOfStrs[i+1];
                    arrayOfStrs [i+1] = f2;
                }
                else {
                    if (sizeOfStrings[i] == sizeOfStrings[i+1]){
                        if (arrayOfStrs[i].charAt(0) > arrayOfStrs[i+1].charAt(0)){
                            int f = sizeOfStrings[i];
                            sizeOfStrings[i] = sizeOfStrings[i + 1];
                            sizeOfStrings[i + 1] = f;
                            String f2 = arrayOfStrs[i];
                            arrayOfStrs [i] = arrayOfStrs[i+1];
                            arrayOfStrs [i+1] = f2;
                        }
                    }
                }
            }
        }
        return arrayOfStrs;
    }
    public static void main(String[] args) {
        System.out.println("Please write your text:");
        Scanner console = new Scanner(System.in);
        String strs = console.nextLine();
        String[] arrayOfStrs1 = strs.split("\\s*(\t)\\s*");
        if (arrayOfStrs1[0] == "") {
            for (int i = 1; i < arrayOfStrs1.length; i++) {
                System.out.println(arrayOfStrs1[i]);
            }
        } else {
            for (String word : arrayOfStrs1) {
                System.out.println(word);
            }
        }
        System.out.println("");
        System.out.println("Please chose operation:");
        switch (console.nextInt()) {
            case 1:
                String arrayOfStrs [] = arrayOfStrs1;
                int sizeOfStrings[] = new int[arrayOfStrs.length];
                for (int i = 0; i < arrayOfStrs.length; i++) {
                    String str[] = arrayOfStrs[i].split("\\s*(\\.|\\s|!|\\?)\\s*");
                    sizeOfStrings[i] = str.length;
                }
                if (arrayOfStrs[0] == "") {
                    arrayOfStrs = Sorter2(sizeOfStrings, arrayOfStrs, 1);
                } else {
                    arrayOfStrs = Sorter2(sizeOfStrings, arrayOfStrs, 0);
                }
                for (String word : arrayOfStrs) {
                    System.out.print(word + "\t");
                }
                break;
            case 2:
                String[] arrayOfStrs2 = arrayOfStrs1;
                for (int i = 0; i < arrayOfStrs2.length; i++) {
                    String arrayOfStrInParagraph[] = arrayOfStrs2[i].split("\\s*(\\.|!|\\?)\\s*");
                    char symbols[] = new char[arrayOfStrInParagraph.length];
                    int k = 0;
                    for (int j = 0; j < arrayOfStrs2[i].length(); j++) {
                        if (arrayOfStrs2[i].charAt(j) == '.' || arrayOfStrs2[i].charAt(j) == '!'
                                || arrayOfStrs2[i].charAt(j) == '?') {
                            symbols[k] = arrayOfStrs2[i].charAt(j);
                            k++;
                        }
                    }
                    for (int f = 0; f < arrayOfStrInParagraph.length; f++) {
                        String words[] = arrayOfStrInParagraph[f].split("\\s*(\\W)\\s*");
                        int sizeOfWords[] = new int[words.length];
                        char symbolsInStr[] = new char[words.length];
                        for (int l = 0; l < sizeOfWords.length; l++) {
                            sizeOfWords[l] = words[l].length();
                        }
                        k = 0;
                        for (int j = 0; j < arrayOfStrInParagraph[f].length(); j++) {
                            if (arrayOfStrInParagraph[f].charAt(j) == ',') {
                                symbolsInStr[k] = arrayOfStrInParagraph[f].charAt(j);
                                k++;
                            }
                            else {
                                if(arrayOfStrInParagraph[f].charAt(j) == ' '
                                        && arrayOfStrInParagraph[f].charAt(j-1) != ','){
                                    k++;
                                }
                            }
                        }
                        words = Sorter2(sizeOfWords, words, 0);
                        arrayOfStrInParagraph[f] = "";
                        for (int j = 0; j < words.length; j++){
                            if (j == words.length-1){
                                arrayOfStrInParagraph[f] += words[j] + symbolsInStr[j];
                            }
                            else {
                            arrayOfStrInParagraph[f] += words[j] + symbolsInStr[j] + " ";
                            }
                        }
                    }
                    arrayOfStrs2[i] = "";
                    for (int j = 0; j < arrayOfStrInParagraph.length; j++){
                        arrayOfStrs2[i] += arrayOfStrInParagraph[j] + symbols[j] + " ";
                    }
                }
                for (int i = 0; i < arrayOfStrs2.length; i++){
                    System.out.print(arrayOfStrs2[i] + "\t");
                }
                break;
            case 3:
                System.out.println("Please write symbol");
                Scanner scanner = new Scanner(System.in);
                String writeSomething = scanner.nextLine();
                char symbol = writeSomething.charAt(0);
                System.out.println(symbol);
                String[] arrayOfStrs3 = arrayOfStrs1;
                for (int i = 0; i < arrayOfStrs3.length; i++) {
                    String arrayOfStrInParagraph[] = arrayOfStrs3[i].split("\\s*(\\.|!|\\?)\\s*");
                    char symbols[] = new char[arrayOfStrInParagraph.length];
                    int k = 0;
                    for (int j = 0; j < arrayOfStrs3[i].length(); j++) {
                        if (arrayOfStrs3[i].charAt(j) == '.' || arrayOfStrs3[i].charAt(j) == '!'
                                || arrayOfStrs3[i].charAt(j) == '?') {
                            symbols[k] = arrayOfStrs3[i].charAt(j);
                            k++;
                        }
                    }
                    for (int f = 0; f < arrayOfStrInParagraph.length; f++) {
                        String words[] = arrayOfStrInParagraph[f].split("\\s*(\\W)\\s*");
                        int sizeOfWords[] = new int[words.length];
                        char symbolsInStr[] = new char[words.length];
                        for (int l = 0; l < sizeOfWords.length; l++) {
                            int n = 0;
                            for (int j = 0; j < words[l].length(); j++){
                                if (words[l].charAt(j) == symbol){
                                    n++;
                                }
                            }
                            sizeOfWords[l] = n;
                        }
                        k = 0;
                        for (int j = 0; j < arrayOfStrInParagraph[f].length(); j++) {
                            if (arrayOfStrInParagraph[f].charAt(j) == ',') {
                                symbolsInStr[k] = arrayOfStrInParagraph[f].charAt(j);
                                k++;
                            }
                            else {
                                if(arrayOfStrInParagraph[f].charAt(j) == ' '
                                        && arrayOfStrInParagraph[f].charAt(j-1) != ','){
                                    k++;
                                }
                            }
                        }
                        words = Sorter3(sizeOfWords, words, 0);
                        arrayOfStrInParagraph[f] = "";
                        for (int j = 0; j < words.length; j++){
                            if (j == words.length-1){
                                arrayOfStrInParagraph[f] += words[j] + symbolsInStr[j];
                            }
                            else {
                                arrayOfStrInParagraph[f] += words[j] + symbolsInStr[j] + " ";
                            }
                        }
                    }
                    arrayOfStrs3[i] = "";
                    for (int j = 0; j < arrayOfStrInParagraph.length; j++){
                        arrayOfStrs3[i] += arrayOfStrInParagraph[j] + symbols[j] + " ";
                    }
                }
                for (int i = 0; i < arrayOfStrs3.length; i++){
                    System.out.print(arrayOfStrs3[i] + "\t");
                }
        }
    }
}
