
import java.util.Scanner;




public class Main {
    public static void main(String[] args) throws Exception {


        class calc {
            public static boolean romanCheck(String a) {
                String[] roman = new String[10];
                roman[0] = "I";
                roman[1] = "II";
                roman[2] = "III";
                roman[3] = "IV";
                roman[4] = "V";
                roman[5] = "VI";
                roman[6] = "VII";
                roman[7] = "VIII";
                roman[8] = "IX";
                roman[9] = "X";
                boolean checkResult = false;
                for (int i = 0; i <= 9; i++) {
                    if (a.equalsIgnoreCase(roman[i])) {
                        checkResult = true;
                    }
                }
                return checkResult;

            }

            public static String convertToArabic(String a) {
                String[] roman = new String[10];
                roman[0] = "I";
                roman[1] = "II";
                roman[2] = "III";
                roman[3] = "IV";
                roman[4] = "V";
                roman[5] = "VI";
                roman[6] = "VII";
                roman[7] = "VIII";
                roman[8] = "IX";
                roman[9] = "X";

                for (int i = 0; i <= 9; i++) {
                    if (roman[i].equalsIgnoreCase(a)) {
                        i++;
                        a = String.valueOf(i);
                    }
                }
                return a;
            }

            public static String convertToRoman(String a) throws Exception {
                String result = "";
                int i = Integer.parseInt(a);
                if (i <= 0) {
                    throw new Exception("У римлян есть только числа больше нуля!");
                }

                while (i > 0) {
                    if (i == 100) {
                        result = result + "C";
                        i = 0;
                    } else if (i > 50) {
                        result = result + "L";
                        i = i - 50;
                    } else if (i >= 10) {
                        result = result + "X";
                        i = i - 10;
                    } else if (i == 9) {
                        result = result + "IX";
                        i = 0;

                    } else if (i >= 5) {
                        result = result + "V";
                        i = i - 5;
                    } else if (i == 4) {
                        result = result + "IV";
                        i = 0;
                    } else if (i >= 1) {
                        result = result + "I";
                        i--;
                    }
                }


                return result;
            }

            public static boolean mathCheck(String a) {
                String[] operators = new String[4];
                operators[0] = "+";
                operators[1] = "-";
                operators[2] = "*";
                operators[3] = "/";
                boolean checkResult = false;
                for (int i = 0; i <= 3; i++) {
                    if (a.equalsIgnoreCase(operators[i])) {
                        checkResult = true;
                    }
                }
                return checkResult;
            }

            public static String calc(String input) throws Exception {
                int a, b;
                boolean arabicnumber = false;

                String result = "";
                String splited[] = input.split(" ");
                if (romanCheck(splited[0]) == true) {
                    a = Integer.parseInt(convertToArabic(splited[0]));
                    b = Integer.parseInt(convertToArabic(splited[2]));

                } else {
                    a = Integer.parseInt(splited[0]);
                    b = Integer.parseInt(splited[2]);
                    arabicnumber = true;
                }

                switch (splited[1]) {
                    case ("+"):
                        result = String.valueOf(a + b);
                        break;
                    case ("-"):
                        result = String.valueOf(a - b);
                        break;
                    case ("*"):
                        result = String.valueOf(a * b);
                        break;
                    case ("/"):
                        try {
                            result = String.valueOf(a / b);
                        } catch (ArithmeticException e) {
                            throw new Exception("Не придумано способов деления на 0!");
                        }
                        break;
                }
                if (arabicnumber == false) {
                    result = convertToRoman(result);
                }
                return result;
            }

            public static void problemCheck(String input) throws Exception {
                boolean checkResult = false;
                boolean aisroman = false;
                boolean bisroman = false;
                int a, b, length;
                String splited[] = input.split(" ");
                length = 3;
                if (length < splited.length) {
                    throw new Exception("неверно введена операция!");
                }
                if (length > splited.length) {
                    throw new Exception("неверно введена операция!");
                }
                try {
                    a = Integer.parseInt(splited[0]);
                } catch (NumberFormatException e) {
                    if (romanCheck(splited[0]) == false) {
                        throw new Exception("неверно введено значение!");
                    } else aisroman = true;
                }
                try {
                    b = Integer.parseInt(splited[2]);
                } catch (NumberFormatException e) {
                    if (romanCheck(splited[2]) == false) {
                        throw new Exception("неверно введено значение!");
                    } else bisroman = true;
                }
                if (mathCheck(splited[1]) == false) {
                    throw new Exception("неверно введен оператор!");
                }
                if (aisroman != bisroman) {
                    throw new Exception("либо римские либо арабские, по другому нельзя");
                }
                if (aisroman==true)
                {
                    a = Integer.parseInt(convertToArabic(splited[0]));
                    b = Integer.parseInt(convertToArabic(splited[2]));

                }else {
                a = Integer.parseInt(splited[0]);
                b = Integer.parseInt(splited[2]);}
                if (a > 10) {
                    throw new Exception("неверно введено значение!");
                }
                if (b > 10) {
                    throw new Exception("неверно введено значение!");
                }


            }


        }
        System.out.println("введите желаемую операцию в виде: 1 + 2, II * V; значения не должны превышать 10");
        Scanner console = new Scanner(System.in);
        String input = console.nextLine();
        calc.problemCheck(input);
        System.out.println(calc.calc(input));

    }
}