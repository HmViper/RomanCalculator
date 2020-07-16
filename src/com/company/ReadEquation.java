package com.company;

import java.util.Scanner;

public class ReadEquation {
    public String Read(){
        Scanner sc = new Scanner(System.in);
        String expression = sc.nextLine();
        return expression.trim();
    }

}
