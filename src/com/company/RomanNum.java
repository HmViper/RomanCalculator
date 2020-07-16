package com.company;

public enum RomanNum {
        I(1), II(2), III(3), IV(4), V(5),
        VI(6),VII(7),VIII(8),IX(9), X(10);

        private int value;

        RomanNum(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

   public int toInt(String key) {
            int retValue = -1;
           for (RomanNum i: this.values()) {
             if (i.name().equals(key.trim()))
                 retValue =  i.getValue();
           }
           return retValue;
    }
    public String toRoman(int key) {
            String retValue = "";
            for (RomanNum i: this.values()){
                if(i.getValue() == key)
                    retValue = i.name();

            }
        return retValue;
    }


}
