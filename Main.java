// Volleyball serving simulator
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
            System.out.println("\n1. Start practice");
            System.out.println("2. View stats");
            System.out.println("3. Personal Best");
            System.out.println("4. Quit");

            int option = input.nextInt();
            input.nextLine();

            if (option == 1)
            {
                String serveDec = "yes";

                while (!serveDec.equalsIgnoreCase("no"))
                {
                    System.out.println("\nDo you wish to do:");
                    System.out.println("Float [1]");
                    System.out.println("Top spin [2]");
                    System.out.println("Short serve [3]");
                    System.out.println("Natural serve [0]");

                    int serveOption = input.nextInt();

                    System.out.println(obj.Serve(serveOption));

                    input.nextLine();

                    System.out.println("Do you wish to continue? (yes/no)");
                    serveDec = input.nextLine();
                }
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