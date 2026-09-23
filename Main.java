import java.util.Scanner;

public class Main
{
    public static void beginning()
    {
        System.out.println("======================================================");
        System.out.println("Welcome to Volleyball Serving Simulator!");
        System.out.println("======================================================\n");

        System.out.println("Type anything to acknowledge that you play volleyball.");
    }

    public static void start(Player obj, Scanner input)
    {
        boolean quit = false;

        while (!quit)
        {
            System.out.println("\n1. Start Practice");
            System.out.println("2. View Stats");
            System.out.println("3. Personal Best");
            System.out.println("4. Quit");

            int option = input.nextInt();
            input.nextLine();

            if (option == 1)
            {
                System.out.println("\nStarting a practice round!");
                System.out.println("You will attempt 10 serves.");

                // Definite count-based loop
                for (int i = 1; i <= 10; i++)
                {
                    System.out.println("\nServe " + i + " of 10");
                    System.out.println("Float [1]");
                    System.out.println("Top spin [2]");
                    System.out.println("Short serve [3]");
                    System.out.println("Natural serve [0]");

                    int serveOption = input.nextInt();

                    // Return value is actively evaluated
                    String result = obj.serve(serveOption);
                    System.out.println(result);

                    if (obj.calculateAccuracy() >= 0.50)
                    {
                        System.out.println("Your current accuracy is at least 50%!");
                    }
                    else
                    {
                        System.out.println("Keep practicing your accuracy!");
                    }
                }

                System.out.println("\nPractice round completed!");
            }
            else if (option == 2)
            {
                obj.viewStats();
            }
            else if (option == 3)
            {
                System.out.println("Personal Best feature coming soon!");
            }
            else if (option == 4)
            {
                quit = true;
                System.out.println("Thank you for playing!");
            }
            else
            {
                System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        Player player1 = new Player();

        beginning();
        input.nextLine();

        start(player1, input);

        input.close();
    }
}