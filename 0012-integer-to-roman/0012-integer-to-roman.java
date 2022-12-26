class Solution {
    public String intToRoman(int num) {
        String result = "";
        while(num != 0) {
            if (num >= 1000) {
                result += "M";
                num = num - 1000;
                continue;
            }
            if (num >= 500) {
                if (num >= 900 && num < 1000) {
                   result += "CM";
                    num -= 900;
                } else {
                    result += "D";
                    num = num - 500;
                }
                continue;
            }
            if (num >= 100) {
                if (num >= 400 && num < 500) {
                    result += "CD";
                    num -= 400;
                } else {
                    result += "C";
                    num = num - 100;
                }

                continue;
            }
            if (num >= 50) {
                if (num >= 90) {
                    result += "XC";
                    num -= 90;
                } else {
                    result += "L";
                    num = num - 50;
                }
                continue;
            }
            if (num >= 10) {
                if (num >= 40) {
                    result += "XL";
                    num -= 40;
                } else {
                    result += "X";
                    num = num - 10;
                }
                continue;
            }
            if (num >= 5) {
                if (num == 9) {
                    result += "IX";
                    num -= 9;
                } else {
                    result += "V";
                    num = num - 5;
                }
                continue;
            }
            if (num > 0 && num < 5) {
                if (num == 4) {
                    result += "IV";
                } else {
                    for(int i = 0; i < num; i++) {
                        result += "I";
                    }
                }
                num = 0;
            }
        }
        return result;
    }
}