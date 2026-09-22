import java.math.BigDecimal;
public class Player {
    public String name;
    public String club;
    private int servingSkill; // 1 = float - 2 = top spin - 3 = short - 
    private int successfulServes;
    private int failedServes;
    private int totalAttempts;
    public double accuracy;
    public boolean finished = false;
    static int numPlayers;
    public Player(){
        numPlayers++;
        name="Naman";
        club = "Bay-to-Bay";
        servingSkill=1;
        
    }
    public Player(String n, int ss, String c){
        numPlayers++;
        name = n;
        club = c;
        servingSkill= ss;
    }
    public String Serve(int ss){
        double value;
        double calibrator;
        totalAttempts++;

        accuracy = Math.round((successfulServes/(double)totalAttempts)*100)/100.0;
        if(ss==0){
            System.out.println(Serve());
        }
        if (ss==1){ // float serve
            value = ((Math.random()*5)+3.0); // 3.0 - 9.0
            calibrator = (value/10.0)*100;
            if (calibrator>=50){
                successfulServes++;
                return "Serving........ \nSuccessful Float!";
            }
            else{
                failedServes++;
                return "Serving........ \nFailed Float!";
            }

        }
        if (ss==2){ // top spin
            value = ((Math.random()*3)+3.0); // 3-6 
            calibrator = (value/10.0)*100;
            if (calibrator>=50){
                successfulServes++;
                return "Serving........ \nSuccessful Top spin!";
            }
            else{
                failedServes++;
                return "Serving........ \nFailed Top spin!";
            }
        }
        if (ss==3){ // short serve
            value= (Math.random()*3)+4.0;
            calibrator = (value/10.0)*100;
            if (calibrator>=50.0){
                successfulServes++;
                return "Serving........ \nSuccessful short serve!!";
            }
            else{
                failedServes++;
                return "Serving........ \nFailed short serve!";
            }

        }
        else{
            return "";
        }
        
    }
    
    public String Serve()
    {
        
        return Serve(this.servingSkill);
    }

    public String Rank(){
        if (totalAttempts==0){
            return "";
        }
        if (accuracy<0.30){
            return "Novice";
        }
        else if (accuracy<0.60){
            return "Intermediate";
        }
        else if (accuracy<0.90){
            return "Advanced";
        }
        else{
            return "elite";
        }
    }

    public void viewStats(){
        
        for (int i =0; i<25; i++){
            System.out.print("-");
        }
        System.out.print("\nStatistics for "+ this.club + "'s player " + this.name+"\n");
        for (int i =0; i<25; i++){
            System.out.print("-");
        }
        System.out.println("\n"+ "Player level: " + Rank()  );
        System.out.println("Accuracy: " + accuracy*100 + "%");
    }


    public static void main(String[] args){
        Player player1 = new Player();
        
        
    }
}
