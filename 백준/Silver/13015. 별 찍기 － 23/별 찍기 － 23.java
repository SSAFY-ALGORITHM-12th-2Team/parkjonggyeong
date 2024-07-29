import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.io.*;
import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.*;

public class Main {


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= 2 * n - 1; i++) {
            if (i == 1 || i == 2 * n - 1) {
                for (int j = 0; j < n; j++) {
                    System.out.print("*");
                }
                for (int j = 0; j < (2 * n) - 3; j++) {
                    System.out.print(" ");

                }
                for (int j = 0; j < n; j++) {
                    System.out.print("*");
                }
            } else {
                if (i < n) {
                    for (int j = 1; j <= i - 1; j++) {
                        System.out.print(" ");
                    }
                    System.out.print("*");
                    for (int j = 2; j <= n - 1; j++) {
                        System.out.print(" ");
                    }
                    System.out.print("*");
                    for (int j = 1; j <= (n - 1) + (n - 2) - 2 * (i - 1); j++) {
                        System.out.print(" ");
                    }
                    System.out.print("*");
                    for (int j = 1; j < n - 1; j++) {
                        System.out.print(" ");
                    }
                    System.out.print("*");
                }
                if (i > n) {
                    for (int j = 2 * n - 2; j > i - 1; j--) {
                        System.out.print(" ");
                    }
                    System.out.print("*");
                    for (int j = 2; j <= n - 1; j++) {
                        System.out.print(" ");
                    }
                    System.out.print("*");
                    for (int j = 1; j <= 2 * (i % n) - 1; j++) {
                        System.out.print(" ");
                    }
                    System.out.print("*");
                    for (int j = 1; j < n - 1; j++) {
                        System.out.print(" ");
                    }
                    System.out.print("*");
                }
                if(i == n){
                    for (int j = 1; j < n; j++) {
                        System.out.print(" ");
                    }
                    System.out.print("*");

                    for (int j = 1; j < n - 1; j++) {
                        System.out.print(" ");
                    }
                    System.out.print("*");
                    for (int j = 1; j < n - 1; j++) {
                        System.out.print(" ");
                    }
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}
