public class Maths {
    public static void main(String[] args){
        int num1 = 7;
        int num2 = 5;

        // math operators
        double addition = num1 + num2;
        double substraktion = num1 - num2;
        double division = num1 / num2;
        double multiplikation = num1 * num2;
        double allOperations = (num1 * num2) + (num1 /num2) - (num2 - num1);

        //output to console
        System.out.println(num1 + " + " + num2 + " = " + addition);
        System.out.println(num1 + " - " + num2 + " = " + substraktion);
        System.out.println(num1 + " / " + num2 + " = " + division);
        System.out.println(num1 + " * " + num2 + " = " + multiplikation);
        System.out.println("(" + num1 + "*" + num2 + ") + "  + "(" + num1 + "/" + num2 +") - " + "(" + num2 + "-" + num1 + ")" + " = " + allOperations);

        // Löse 128 * 512 mit addition und einer for-schleife
        int num3 = 128;
        int num4 = 512;
        float sum = 0;
        for (int i = 0; i < num3; i++){
             sum += num4;
             System.out.println("Zwischensumme: " + sum);
            if (sum > 60000){
                System.out.println("Schleife verlassen");
                break;
            }
        }
        System.out.println("for-Schleife: " + num3 + " * " + num4 + " = " + sum);

        // for-Schleife durch while-schleife ersetzen
        int i = 0;
        float whileSum = 0;
        while (i < num3){
            whileSum += num4;
            System.out.println("Zwischensumme: " + whileSum);
            if (whileSum > 60000){
                System.out.println("whileSum ist größer als 60000");
                break;
            }
            i++;
        }
        System.out.println("while-Schleife: " + num3 + " * " + num4 + " = " + whileSum);



    }
}
