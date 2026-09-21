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
    public String Serve(){
        double value;
        double calibrator;
        totalAttempts++;
        if (this.servingSkill==1){ // float serve
            value = ((Math.random()*5)+3.0); // 3.0 - 9.0
            calibrator = (value/10.0)*100;
            if (calibrator>=50){
                successfulServes++;
                return "Successful Serve!";
            }
            else{
                failedServes++;
                return "Failed Serve!";
            }

        }
        if (this.servingSkill==2){ // top spin
            value = ((Math.random()*3)+3.0); // 3-6 
            calibrator = (value/10.0)*100;
            if (calibrator>=50){
                successfulServes++;
                return "Successful Serve!";
            }
            else{
                failedServes++;
                return "Failed Serve!";
            }
        }
        if (this.servingSkill==3){ // short serve
            value= (Math.random()*3)+4.0;
            calibrator = (value/10.0)*100;
            if (calibrator>=50.0){
                successfulServes++;
                return "Successful Serve!";
            }
            else{
                failedServes++;
                return "Failed Serve!";
            }

        }
        else{
            return "";
        }

    }
    public void viewStats(){
        for (int i =0; i<22; i++){
            System.out.print("-");
        }
        System.out.print("\n Statistics for "+ this.club + "'s player " + this.name + )
        for (int i =0; i<22; i++){
            System.out.print("-");
        }
    }


    public static void main(String[] args){
        Player player1 = new Player();
        
    }
}
