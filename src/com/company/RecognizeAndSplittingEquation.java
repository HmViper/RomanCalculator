package com.company;

import java.util.Scanner;

public class RecognizeAndSplittingEquation {
    public String[] Splitting(String eq){
        String signOfAction = "";

        String[] splittingEquation = new String[2];
        String expressionClean = eq.trim().toUpperCase(); //Очистка строки

        if(expressionClean.indexOf('-')>-1){
            splittingEquation = expressionClean.split("-");
        }else
        if(expressionClean.indexOf('+')>-1){
            splittingEquation = expressionClean.split("\\+");
        }else
        if(expressionClean.indexOf('*')>-1){
            splittingEquation = expressionClean.split("\\*");
        }else
        if(expressionClean.indexOf('/')>-1){
            splittingEquation = expressionClean.split("/");
        }else
        if(expressionClean.indexOf('.')>-1 || expressionClean.indexOf(',')>-1)  {
            throw new UnsupportedOperationException("Введено не целое число");
        }
        else throw new UnsupportedOperationException("Нет знаков действия для выражения");
        if (splittingEquation.length>2){
            throw new UnsupportedOperationException("Введено более 2-х чисел");
        }

       return splittingEquation;

    }
    public String SignOfAction(String eq){
        String signValue = "";
        if(eq.indexOf('-')>-1)
            signValue = "minus";
        else if(eq.indexOf('+')>-1)
            signValue = "plus";
        else if(eq.indexOf('*')>-1)
            signValue = "multiply";
        else if(eq.indexOf('/')>-1)
            signValue = "divide";
        return signValue;
    }
    public String ToRoman(int eq){
        String toRoman = "";
        if (eq / 90 > 0) {
            eq = eq % 90;
            toRoman += "XC";
        }
        if (eq / 50 > 0) {
            eq = eq % 50;
            toRoman += "L";
        }
        if (eq / 40 > 0) {
            eq = eq % 40;
            toRoman += "XL";
        }
        if (eq / 10 > 0) {

            for (int i = 0; i < ((int) eq / 10); i++)
                toRoman += "X";
        }
        eq = eq % 10;
        toRoman = toRoman + RomanNum.I.toRoman(eq);
        return toRoman;
    }
}



