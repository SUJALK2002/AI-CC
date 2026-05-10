public class TableOfTen {

    public static void displayTable() {

        for(Integer i = 1; i <= 10; i++) {

            System.debug('10 x ' + i + ' = ' + (10 * i));
        }
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