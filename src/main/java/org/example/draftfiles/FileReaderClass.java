//package org.example.util;
//
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.Scanner;
//
//public class FileReaderClass {
//
//    public static void fileReader() throws IOException {
//        File file = new File("C:\\Users\\Serge\\Desktop\\homework_JDBC\\companies.txt");
//        Scanner sc  = new Scanner(file);
//        String content = "";
//        while(sc.hasNext()){
//        content = content.concat(sc.nextLine()+ "\n");}
//
//
//        FileWriter writer = new FileWriter("C:\\Users\\Serge\\Desktop\\homework_JDBC\\new_companies.txt");
//        writer.write(content);
//        writer.close();
//    }
//
//
//    public static void main(String[] args) throws IOException {
//        fileReader();
//    }
//}
