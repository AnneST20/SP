package com.company;
import javax.lang.model.type.NullType;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


public class Main {

    public static void main(String[] args) throws Exception {
        String pathname ="C:\\My information\\3 course\\СП\\little-prince.txt";
        String str=get_text(pathname);
        str=get_clear_strings(str);
        String[] words = get_separate_words(str);
        print_result(words);
    }

    public static String get_text (String pathname) throws Exception {
        File f = new File(pathname);
        final int length = (int) f.length();
        if (length != 0) {
            char[] words = new char[length];
            //InputStreamReader stream = new InputStreamReader(new FileInputStream(f), "CP1251");
            InputStreamReader stream = new InputStreamReader(new FileInputStream(f), "UTF-8");
            final int read = stream.read(words);
            String str = new String(words, 0, read);
            stream.close();
            return str;
        }
        else{
            throw new Exception("Ôàéë ïóñòèé àáî éîãî íå ³ñíóº");
        }
    }

    public static String get_clear_strings( String str){
        str = str.trim();
        str = str.toLowerCase();
        //str = str.replaceAll("[^A-Za-zÀ-ß¯ª²à-ÿ¿º³ûú']+", " ");
        str = str.replaceAll("[^A-Za-zА-Яа-яІіЇї']+", " ");
        return str;
    }

    public static String[] get_separate_words(String str) {
        int count_words = 0;
        for (char element: str.toCharArray()) {
            if (element == ' ') { count_words++; }
        }
        String[] words = new String[count_words + 1];
        String word = "";
        int number = 0;
        boolean repeats = false;
        for (char element : str.toCharArray()) {
            if(element != ' ') {
                for (char letter: word.toCharArray()) {
                    if (letter == element) {
                        repeats = true;
                        break;
                    }
                }
                if (repeats == false) {
                    word += element;
                }
            }
            else {
                if (repeats == false) {
                    words[number] = word;
                    number++;
                }
                repeats = false;
                word = "";
            }
        }
        return words;
    }

    public static void print_result(String[] words) {
        System.out.println("Варіант 4 (знайти слова, літери яких не повторюються):");
        int quantity = 1;
        for (String word : words) {
            if(word != null && quantity < 100) {
                System.out.println(quantity + "." + word);
                quantity++;
            }
        }
    }
}
