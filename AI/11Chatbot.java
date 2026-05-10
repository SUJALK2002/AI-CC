import java.util.Scanner;

public class SimpleChatbot {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String userInput;

        System.out.println("===== CUSTOMER SUPPORT CHATBOT =====");
        System.out.println("Type 'exit' to end chat.");

        while (true) {

            System.out.print("\nYou: ");
            userInput = sc.nextLine().toLowerCase();

            // Exit Condition
            if (userInput.equals("exit")) {

                System.out.println("Bot: Thank you! Visit again.");
                break;
            }

            // Product Information
            else if (userInput.contains("product")) {

                System.out.println("Bot: We provide laptops, mobiles, and accessories.");
            }

            // Price Query
            else if (userInput.contains("price")) {

                System.out.println("Bot: Prices start from Rs. 10,000 depending on the product.");
            }

            // Service Details
            else if (userInput.contains("service")) {

                System.out.println("Bot: We provide free delivery and 1-year warranty service.");
            }

            // Delivery Query
            else if (userInput.contains("delivery")) {

                System.out.println("Bot: Delivery usually takes 3 to 5 business days.");
            }

            // Warranty Query
            else if (userInput.contains("warranty")) {

                System.out.println("Bot: All products include a 1-year warranty.");
            }

            // Payment Query
            else if (userInput.contains("payment")) {

                System.out.println("Bot: We accept UPI, Debit Card, Credit Card, and Cash.");
            }

            // Contact Query
            else if (userInput.contains("contact")) {

                System.out.println("Bot: Contact us at support@company.com");
            }

            // Greeting
            else if (userInput.contains("hello") ||
                    userInput.contains("hi")) {

                System.out.println("Bot: Hello! How can I help you?");
            }

            // Default Response
            else {

                System.out.println("Bot: Sorry, I don't understand your query.");
            }
        }

        sc.close();
    }
}