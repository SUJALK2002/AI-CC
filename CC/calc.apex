public class CalculatorDemo {

    public static void operations() {

        Integer a = 20;
        Integer b = 10;

        Integer add = a + b;
        Integer sub = a - b;
        Integer mul = a * b;
        Integer div = a / b;

        System.debug('Addition = ' + add);
        System.debug('Subtraction = ' + sub);
        System.debug('Multiplication = ' + mul);
        System.debug('Division = ' + div);
    }
}

How to Run in Salesforce Apex
Login to Salesforce
Open Developer Console
Go to File → New → Apex Class
Paste the code and save
Open Debug → Open Execute Anonymous Window
Call the method like:
TableOfTen.displayTable();