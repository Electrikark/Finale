public class Player
{
    private String name;
    private String club;
    private int servingSkill;

    private int successfulServes;
    private int failedServes;
    private int totalAttempts;

    private double personalBest;

    private static int numPlayers;

    // Default constructor
    public Player()
    {
        numPlayers++;

        name = "Naman";
        club = "Bay-to-Bay";
        servingSkill = 1;
        personalBest = 0.0;
    }

    // Overloaded constructor
    public Player(String n, int ss, String c)
    {
        numPlayers++;

        name = n;
        club = c;
        servingSkill = ss;
        personalBest = 0.0;
    }

    // Getters
    public String getName()
    {
        return name;
    }

    public String getClub()
    {
        return club;
    }

    public int getServingSkill()
    {
        return servingSkill;
    }

    public int getSuccessfulServes()
    {
        return successfulServes;
    }

    public int getFailedServes()
    {
        return failedServes;
    }

    public int getTotalAttempts()
    {
        return totalAttempts;
    }

    public double getPersonalBest()
    {
        return personalBest;
    }

    // Setters
    public void setName(String n)
    {
        name = n;
    }

    public void setClub(String c)
    {
        club = c;
    }

    public void setServingSkill(int skill)
    {
        if (skill >= 1 && skill <= 3)
        {
            servingSkill = skill;
        }
        else
        {
            System.out.println("Invalid serving skill.");
        }
    }

    // Calculates current serving accuracy
    public double calculateAccuracy()
    {
        if (totalAttempts == 0)
        {
            return 0.0;
        }

        return (double) successfulServes / totalAttempts;
    }

    // Updates personal best if current accuracy is higher
    public void updatePersonalBest()
    {
        if (calculateAccuracy() > personalBest)
        {
            personalBest = calculateAccuracy();
        }
    }

    // Performs a serve
    public String serve(int ss)
    {
        // Natural serve uses the player's default serving skill
        if (ss == 0)
        {
            ss = servingSkill;
        }

        // Handles invalid serve choices
        if (ss < 1 || ss > 3)
        {
            return "Invalid serve option. Please choose 0, 1, 2, or 3.";
        }

        totalAttempts++;

        double value;
        double calibrator;

        if (ss == 1)
        {
            value = (Math.random() * 5) + 3.0;
            calibrator = (value / 10.0) * 100;

            if (calibrator >= 50)
            {
                successfulServes++;
                return "Serving........\nSuccessful Float!";
            }
            else
            {
                failedServes++;
                return "Serving........\nFailed Float!";
            }
        }
        else if (ss == 2)
        {
            value = (Math.random() * 3) + 3.0;
            calibrator = (value / 10.0) * 100;

            if (calibrator >= 50)
            {
                successfulServes++;
                return "Serving........\nSuccessful Top Spin!";
            }
            else
            {
                failedServes++;
                return "Serving........\nFailed Top Spin!";
            }
        }
        else
        {
            value = (Math.random() * 3) + 4.0;
            calibrator = (value / 10.0) * 100;

            if (calibrator >= 50)
            {
                successfulServes++;
                return "Serving........\nSuccessful Short Serve!";
            }
            else
            {
                failedServes++;
                return "Serving........\nFailed Short Serve!";
            }
        }
    }

    // Overloaded method
    public String serve()
    {
        return serve(servingSkill);
    }

    // Determines player's rank
    public String rank()
    {
        double accuracy = calculateAccuracy();

        if (totalAttempts == 0)
        {
            return "No rank yet";
        }
        else if (accuracy < 0.30)
        {
            return "Novice";
        }
        else if (accuracy < 0.60)
        {
            return "Intermediate";
        }
        else if (accuracy < 0.90)
        {
            return "Advanced";
        }
        else
        {
            return "Elite";
        }
    }

    public void viewStats()
    {
        for (int i = 0; i < 25; i++)
        {
            System.out.print("-");
        }

        System.out.println("\nStatistics for " + club +
                           "'s player " + name);

        for (int i = 0; i < 25; i++)
        {
            System.out.print("-");
        }

        System.out.println("\nPlayer level: " + rank());
        System.out.println("Total attempts: " + totalAttempts);
        System.out.println("Successful serves: " + successfulServes);
        System.out.println("Failed serves: " + failedServes);

        System.out.printf("Accuracy: %.1f%%%n",calculateAccuracy() * 100);

        System.out.printf("Personal Best: %.1f%%%n", personalBest * 100);
    }
}
