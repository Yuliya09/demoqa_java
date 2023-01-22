package tests;

import java.awt.print.Book;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Operations {
    byte aByte; // 8 bit -128 ... 127
    short aShort = 100; // 16 bit -32768 ... 32767

    // самый используемый
    int aInt = 1_100_000; // 32 bit -2 ^ 31 ... (2 ^ 31) -1
    long aLong = 100L; // 64 bit -2 ^ 63 ... (2 ^ 63) -1

    float aFloat = 0.0F; // 32 bit
    // самый используемый (если просто хранить, но не использовать арифметику)
    double aDouble = 0.0D; // 64 bit

    char aChar = 'c';
    boolean aBoolean = false;
    String aString = "hello, qa.guru!";

    public static void main(String[] args) {
        // + -- сложение
        // - -- вычитание
        // * -- умножение
        // / -- целочисленное деление
        // % -- остаток от деления
        // инкремент ++
        // декремент --

//        System.out.println(5 + 10);

        // >
        // <
        // >=
        // <=
        // ==
        // !=
//        System.out.println(2 != 3);

        // =
        // +=
        // -=...
        int a = 10;
        int b = 4;
        int c = 10;
        double f = 3.7;
        long m = 13L;

        System.out.println("a+b= " + (a+b));
        System.out.println("a-b= " +(a-b));
        System.out.println("a/b= " + (a/b));
        System.out.println("a*b= " + (a*b));
        System.out.println("a%b= " +(a%b));
        System.out.println("b<c ?" + (b<c));
        System.out.println("c == a ?" + (c==a));
        System.out.println("c>=a ?" + (c>=a));
        System.out.println("b!=a" + (b!=a));
        System.out.println("f - m = " + (f-m));

//        System.out.println(5 % 2);

        //&& (&) = AND
        // || (|) - OR
        //! - NO
        System.out.println((((f+m)<=0)) || ((f*m)<=0));
        System.out.println(((a+b)>0) && ((b+c)>0));

        NewPage javapage = new NewPage();
        //javapage.doStartNewPage;

        // переполнение
        System.out.println("Переполнение при сложении " + (2147483647+ a));
        System.out.println("Переполнение при вычитании " + (-2147483647-a));


        boolean result = (3 < 4) || false;

    }
}
