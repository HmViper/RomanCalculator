package com.company;


import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        int[] Rn = new int[]{-1, -1};
        int result = -1;
        boolean isRoman = false;
        ReadEquation ReadFlow = new ReadEquation();
        RecognizeAndSplittingEquation spl = new RecognizeAndSplittingEquation();
        String flow = ReadFlow.Read();
        String signOfAction = spl.SignOfAction(flow);            //узнаем какое действие необходимо проделать с числами
        String[] splitting = spl.Splitting(flow);               // пытаемся разделить строку по знаку действия

        // Если арабских нет
        for (int i = 0; i < splitting.length; i++) {    // распознаем римские используя enum
            Rn[i] = RomanNum.I.toInt(splitting[i]);
        }
        if (Rn[0] >= 0 && Rn[1] >= 0) {
            isRoman = true;                             //Выставляем флаг римских цифр
        }

        if ((Rn[0] == -1 && Rn[1] >= 0) || (Rn[0] == 0 && Rn[1] == -1)) {
            throw new UnsupportedOperationException("Введены смешанные арабские и римские цифры");
        }
        else {
            try {
                Rn[0] = Integer.parseInt(splitting[0].trim());  // Перевод в арабские цифры
                Rn[1] = Integer.parseInt(splitting[1].trim());

            } catch (NumberFormatException nfe) {

            }
        }
        if(Rn[0]<0 || Rn[0]>10 || Rn[1]<0 || Rn[1]>10){
            throw new UnsupportedOperationException("Введены цифры вне диапазона");
        }

        switch (signOfAction) {
            case "plus":
                result = Rn[0] + Rn[1];
                break;
            case "minus":
                result = Rn[0] - Rn[1];
                break;
            case "multiply":
                result = Rn[0] * Rn[1];
                break;
            case "divide":
                result = Rn[0] / Rn[1];
                break;
        }

        if (isRoman)
            System.out.println(spl.ToRoman(result));
        else
            System.out.println(result);


    }
}
