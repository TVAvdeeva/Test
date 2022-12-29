
import java.util.*;



public class Main {

    enum Operation
    {
        PLUS("+"),
        MINUS("-"),
        DIVIDE("/"),
        MULTIPLY("*");
        String symb;

        Operation(String symb)
        {
            this.symb = symb;
        }

    }
    static  class Mathexp
    {

        int arg1;
        int arg2;
        String znak;



       int Calk()
        {
            int rezultat;
            switch(getOper(znak))
            {     case PLUS:
                rezultat= arg1+ arg2;
                    break;
                case MINUS:
                    rezultat= arg1- arg2;
                    break;
                case DIVIDE:
                    rezultat= arg1/arg2;
                    break;
                case MULTIPLY:
                    rezultat= arg1*arg2;
                    break;
                default:
                    rezultat=  -1000000;
            }
          return rezultat;
        }

    }
    static Operation getOper(String str)
    {
        if (str.equals("-")){return Operation.MINUS;}
        if (str.equals("+")){return Operation.PLUS;}
        if (str.equals("/")){return Operation.DIVIDE;}
        if (str.equals("*")){return Operation. MULTIPLY;}
        throw new RuntimeException("Неизвестный оператор");
    }

    static boolean ExprisEmty(String str)//Метод провереяет пустая строка или нет
    {
        return !(str == null|| str.isEmpty()||str.trim().isEmpty());

    }
    static String  Znaki(String str)// Метод проверяет если ли знаки *,-,+,/
    {
        char[] znak ={'-','+','*','/'};
        for (int i = 0; i < 4; i++)
        {
            if (str.indexOf(znak[i])!=-1) {return String.valueOf(znak[i]);}
        }
        return "1";
    }
    static boolean  RealNum(String str, int Number)// Метод `проверяет целое число или нет
    {
        try {
            Integer.valueOf(str);
        }
        catch (NumberFormatException e)
        {
            System.err.println("Неправильно введено "+Number +"-ое число " );
            return false;
        }
        return true;
    }
    public static String calc(String expr) {
        String znak;    //`знак действия
        String outstring;
        int arg1;     // первое число
        int arg2;    //второе число
        String[] StrNumber; // массив строк
        znak = Znaki(expr);//  знак операции .возращает 1 если нет знаков

        outstring = "";
        try {

            if ("1".equals(znak))
             {
                throw new Exception("Отсуствуют знаки оперции "); // выкидывает, если нет знаков опреции
             }


            if (!"/".equals(znak)) // делим строку
             {
                StrNumber = expr.split("\\" + znak);
             } else {
                StrNumber = expr.split(znak);
              }
             if (StrNumber.length != 2)//  разделилась на три и более строки
              {
                throw new Exception("Формат математической операции не удолетворяет заданию.");
               }

             if (!RealNum(StrNumber[0].trim(), 1) || !RealNum(StrNumber[1].trim(), 2))//проверка  пробуем перевеси в целые числа
              {
                throw new Exception("Формат выражения ");
               }
            arg1 = Integer.parseInt(StrNumber[0].trim()); // первое число
            arg2 = Integer.parseInt(StrNumber[1].trim()); // второе число

            if (arg1 < 0 || arg1 > 10) {
                throw new Exception("Диапозон первого числа должне быть от 0 до 10");
            }
            if (arg2 < 0 || arg2 > 10) {
                throw new Exception("Диапозон второго числа должне быть от 0 до 10");
            }

            if ("/".equals(znak) && arg2 == 0)//на ноль делить нельзя
            {
                throw new Exception("Деление на ноль!");
            }

            Mathexp mexp = new Mathexp();// вычисляем
            mexp.arg1 = arg1;
            mexp.arg2 = arg2;
            mexp.znak = znak;
            outstring = String.valueOf(mexp.Calk());

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            return outstring;
        }
    }

    public static void main(String[] args)
    {
        Scanner scn=new Scanner(System.in);
        String[] StrNumber; // массив строк


        String expr=scn.nextLine(); // считываем выражение
        try
        {
          System.out.println(calc(expr));}
         catch (Exception e){
              System.out.println(e);
          }
    }
}




