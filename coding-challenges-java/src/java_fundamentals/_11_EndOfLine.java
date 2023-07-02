package java_fundamentals;

import java.util.Scanner;

/*
In computing, End Of File (commonly abbreviated EOF) is a condition in a computer operating system where no more data
can be read from a data source.
Read some unknown N number of lines of input from stdin(System.in) until you reach EOF; each line of input contains a non-empty String.
For each line, print the line number, followed by a single space, and then the line content received as input.

- given:
Hello world
I am a file
Read me until end-of-file.
- the function should return:
1 Hello world
2 I am a file
3 Read me until end-of-file.

 */

public class _11_EndOfLine {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        long counter = 1;
        boolean eol = false;

        while (!eol){
            try {
                System.out.println(counter + " " + scanner.nextLine());
                counter++;
            } catch (Exception e) {
                eol = true;
            }
        }

        scanner.close();

    }

}
