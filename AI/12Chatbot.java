import java.util.Scanner;

public class AIChatBot {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input;

        System.out.println("===== AI CUSTOMER CHATBOT =====");

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.println("Hello " + name + "! How can I help you?");
        System.out.println("Type 'exit' to stop.");

        while (true) {

            System.out.print("\nYou: ");

            input = sc.nextLine().toLowerCase();

            if (input.equals("exit")) {

                System.out.println("Bot: Thank you " + name + "!");
                break;
            }

            else if (input.contains("hello") ||
                    input.contains("hi")) {

                System.out.println("Bot: Hello " + name + "!");
            }

            else if (input.contains("product")) {

                System.out.println("Bot: We sell laptops, mobiles, and smart watches.");
            }

            else if (input.contains("price")) {

                System.out.println("Bot: Prices start from Rs. 10,000.");
            }

            else if (input.contains("delivery")) {

                System.out.println("Bot: Delivery takes 3-5 days.");
            }

            else if (input.contains("payment")) {

                System.out.println("Bot: We accept UPI and cards.");
            }

            else if (input.contains("thank")) {

                System.out.println("Bot: You are welcome!");
            }

            else {

                System.out.println("Bot: Sorry, I cannot understand.");
            }
        }

        sc.close();
    }
}