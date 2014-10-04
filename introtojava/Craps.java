import java.util.*;
import java.text.*;
public class Craps
{
   static double bank;
   static double amtToBet, passBetAmt, placeBetAmt;
   static Scanner s = new Scanner(System.in);
   static int counter = 0;
   static int point = 0;
   static boolean pass, morebet = true, playagain=false;
   static double[] placeBetAmounts = {0, 0, 0, 0, 0, 0};
   static NumberFormat rnd = NumberFormat.getCurrencyInstance();
   static Random r = new Random();
   public static void main(String args[]){
       System.out.print("What how much money are you bringing to the table? $");
       bank = s.nextDouble();
       while (bank <= 0){
           System.out.println("You need to bring some cash to play.");
           System.out.print("What how much money are you bringing to the table? $");
           bank = s.nextDouble();
        }
        s.nextLine();
        playCraps();
    }
    public static void playCraps(){
       Scanner p = new Scanner(System.in);
       amtToBet = bank;
       System.out.print("Do you want to make a [P]ass or [D]on't Pass Bet? ");
       String input = p.nextLine();
       char passyn = input.charAt(0);
       while (passyn != 'p' && passyn != 'P' && passyn != 'D' && passyn != 'd'){
           System.out.println("Try Again.");
           input = p.nextLine();
           passyn = input.charAt(0);
        }
       if (passyn == 'P' || passyn == 'p'){
           pass = true;
           passBetAmt = getPassBet();
           while (passBetAmt > amtToBet){
               System.out.print("You can't bet more than you have! ");
               passBetAmt = getPassBet();
            }
           amtToBet = amtToBet - passBetAmt;
        }
       else if (passyn == 'D' || passyn == 'd'){
           pass = false;
           passBetAmt = getPassBet();
           while (passBetAmt > amtToBet){
               System.out.print("You can't bet more than you have! ");
               passBetAmt = getPassBet();
            }
           amtToBet = amtToBet - passBetAmt;
        }
        else{
            System.out.println("ERROR. EXITING.");
            System.exit(0);
        }
       playRoll();
    }
    public static double getPassBet(){
        System.out.print("What will you wager? $");
        double bet = s.nextDouble();
        return bet;
    }
    public static int getSingleBet(){
        System.out.print("Pick a single roll bet: [0=none, 1='any 7', 2='any craps', 3='double ones', 4 = 'three', 5 = 'eleven', 6 = 'double six']: ");
        int selection = s.nextInt();
        return selection;
    }
    public static double getSingleBetAmount(){
        System.out.print("How much to bet on a single roll? $");
        double amount = s.nextDouble();
        return amount;
    }
    public static int rollDie(){
        int result = r.nextInt(6) + 1;
        return result;
    }
    public static void playRoll(){
        counter++;
        System.out.print("\n\n");
        boolean singleBet = false;
        int singleRollBet = 0;
        double singleBetAmt = 0;
        if (counter == 1){
            playFirstRoll();
            return;
        }
        else if (amtToBet <= 0){
            singleBet = false;
            System.out.println("You cannot make any more bets.\nHere comes the next roll!");
        }
        else{
        singleRollBet = getSingleBet();
        while (singleRollBet < 0 || singleRollBet > 6){
            System.out.println("Try again.");
            singleRollBet = getSingleBet();
        }
        if(singleRollBet > 0){
            singleBet = true;
            singleBetAmt = getSingleBetAmount();
            while (singleBetAmt > amtToBet){
                System.out.print("You can't bet more than you have! ");
                singleBetAmt = getSingleBet();
            }
            amtToBet = amtToBet - singleBetAmt;
        }
        else{
            singleBet = false;
            s.nextLine();
        }
    }
        int die1 = rollDie();
        int die2 = rollDie();
        int rollPoint = die1+die2;
        System.out.print("The Roll is... ");
        sleep();
        System.out.println(rollPoint);
        if(singleBet == true){
            payoutSingleBet(singleRollBet, singleBetAmt, rollPoint);
        }
        if (rollPoint == 7){
            System.out.println("The roller did not pass, and the game is over.");
            payoutPassPoint(false);
            bank = amtToBet;
            System.out.println("You now have "+rnd.format(amtToBet)+" in your bank.");
            playAgain();
        }
        else{
        payoutPlaceBets(rollPoint);
        if (rollPoint == point){
            System.out.println("The point has been rolled.");
            payoutPassPoint(true);
            bank = amtToBet;
            System.out.println("You now have "+rnd.format(amtToBet)+" in your bank.");
            playAgain();
        }
        else{
            System.out.println("You now have "+rnd.format(amtToBet)+" to bet.\nWill Roll Again.");
            playRoll();
        }
        }
        
    }
    public static void payoutPassPoint(boolean pass1){
        if (pass == pass1){
            double payout = passBetAmt + passBetAmt;
            System.out.println("You won the pass/don't pass bet!");
            amtToBet += payout;
        }
        else{
            System.out.println("You lost the pass/don't pass bet!");
        }
    }
    public static void payoutPlaceBets(int roll){
        if(placeBetAmounts[0] != 0 && roll == 4){
                double payout4 = ((placeBetAmounts[0] * 9) / 5) + placeBetAmounts[0];
                System.out.println("You won the place bet of 4, paying 9 to 5.");
                amtToBet += payout4;
        }
        if(placeBetAmounts[1] != 0 && roll == 5){
                double payout5 = ((placeBetAmounts[1] * 7) / 5) + placeBetAmounts[1];
                System.out.println("You won the place bet of 5, paying 7 to 5.");
                amtToBet += payout5;
        }
        if(placeBetAmounts[2] != 0 && roll == 6){
                double payout6 = ((placeBetAmounts[2] * 7) / 6) + placeBetAmounts[2];
                System.out.println("You won the place bet of 6, paying 7 to 6.");
                amtToBet += payout6;
        }
        if(placeBetAmounts[3] != 0 && roll == 8){
                double payout8 = ((placeBetAmounts[3] * 7) / 6) + placeBetAmounts[3];
                System.out.println("You won the place bet of 8, paying 7 to 6.");
                amtToBet += payout8;
        }
        if(placeBetAmounts[4] != 0 && roll == 9){
                double payout9 = ((placeBetAmounts[4] * 7) / 5) + placeBetAmounts[4];
                System.out.println("You won the place bet of 9, paying 7 to 5.");
                amtToBet += payout9;
        }
        if(placeBetAmounts[5] != 0 && roll == 10){
                double payout10 = ((placeBetAmounts[5] * 9) / 5) + placeBetAmounts[5];
                System.out.println("You won the place bet of 10, paying 9 to 5.");
                amtToBet += payout10;
        }
        
    }
    public static void payoutSingleBet(int betType, double betAmt, int roll){
        double payout;
        if (betType == 1){
            if (roll == 7){
                System.out.println("You won the single bet! It pays 4 to 1.");
                payout = (betAmt * 4) + betAmt;
                amtToBet += payout; 
            }
            else{
                System.out.println("You lost the single bet.");
            }
        }
        else if (betType == 2){
            //any craps
            if (roll == 2 || roll == 3 || roll == 12){
                System.out.println("You won the single bet! It pays 7 to 1.");
                payout = (betAmt * 7) + betAmt;
                amtToBet += payout; 
            }
            else{
                System.out.println("You lost the single bet.");
            }
        }
        else if (betType == 3){
            //double ones
            if (roll == 2){
                System.out.println("You won the single bet! It pays 30 to 1.");
                payout = (betAmt * 30) + betAmt;
                amtToBet += payout; 
            }
            else{
                System.out.println("You lost the single bet.");
            }
        }
        else if (betType == 4){
            //three
            if (roll == 3){
                System.out.println("You won the single bet! It pays 15 to 1.");
                payout = (betAmt * 15) + betAmt;
                amtToBet += payout; 
            }
            else{
                System.out.println("You lost the single bet.");
            }
        }
        else if (betType == 5){
            //eleven
            if (roll == 11){
                System.out.println("You won the single bet! It pays 15 to 1.");
                payout = (betAmt * 15) + betAmt;
                amtToBet += payout; 
            }
            else{
                System.out.println("You lost the single bet.");
            }
        }
        else if (betType == 6){
            //double six
            if (roll == 12){
                System.out.println("You won the single bet! It pays 20 to 1.");
                payout = (betAmt * 30) + betAmt;
                amtToBet += payout; 
            }
            else{
                System.out.println("You lost the single bet.");
            }
        }
    }
    public static void payoutPass(){
        double payout = 0;
        if (pass==true){
            payout = passBetAmt;
            bank = bank + payout;
            amtToBet = bank;
            System.out.println("You won the pass bet with a roll of "+point+".");
            System.out.println("Your bank is now "+rnd.format(bank));
            playAgain();
        }
        else{
            payout = -1*(passBetAmt);
            bank = bank + payout;
            System.out.println("You lost the pass bet with a roll of "+point+".");
            System.out.println("Your bank is now "+rnd.format(bank));
            playAgain();
        }
    }
     public static void payoutDontPass(){
        double payout = 0;
        if (pass==false){
            payout = passBetAmt;
            bank = bank + payout;
            amtToBet = bank;
            System.out.println("You won the don't pass bet with a roll of "+point+".");
            System.out.println("Your bank is now "+rnd.format(bank));
            playAgain();
        }
        else{
            payout = -1*(passBetAmt);
            bank = bank + payout;
            System.out.println("You lost the don't pass bet with a roll of "+point+".");
            System.out.println("Your bank is now "+rnd.format(bank));
            playAgain();
        }
    }
    public static void playFirstRoll(){
        char result;
        System.out.println("Here we go!");
        sleep();
        int die1 = rollDie();
        int die2 = rollDie();
        point = die1+die2;
        if (point == 7 || point == 11){
            result = 'p';
        }
        else if (point == 2 || point == 3 || point == 12){
            result = 'd';
        }
        else{
            result = 'c';
        }
        switch (result){
            case 'p': payoutPass(); playAgain(); break;
            case 'd': payoutDontPass(); playAgain(); break;
            case 'c': System.out.println("The point is: " + point); placeBet(); break;
            default: System.out.println("ERROR. EXITING."); System.exit(0); break;
        }
    }
    public static void placeBet(){
       if(amtToBet > 0){
       System.out.print("Do you want to make a Place Bet [Y/N]? ");
       s.nextLine();
       String input = s.nextLine();
       char passyn = input.charAt(0);
       while (passyn != 'y' && passyn != 'Y' && passyn != 'n' && passyn != 'N'){
           System.out.println("Try Again.");
           input = s.nextLine();
           passyn = input.charAt(0);
        }
        if(passyn == 'n' || passyn == 'N'){
            playRoll();
        }
        else{
            char passyn1 = 'n';
            do{
                makePlaceBet();
                if (amtToBet > 0){
                System.out.print("Do you want to make another Place Bet [Y/N]? ");
                s.nextLine();
                String input1 = s.nextLine();
                passyn1 = input1.charAt(0);
                while (passyn1 != 'y' && passyn1 != 'Y' && passyn1 != 'n' && passyn1 != 'N'){
                    System.out.println("Try Again.");
                    input1 = s.nextLine();
                    passyn1 = input.charAt(0);
                }
            }
            else{
                System.out.println("You do not have the funds to make another Place Bet.");
                s.nextLine();
                playRoll();
                return;
            }
        }
            while (passyn1=='y' || passyn1 == 'Y');

            playRoll();
        }
        }
       else{
        System.out.println("You do not have the funds to make a Place Bet.");
        s.nextLine();
        playRoll();
    }
        
    }
    public static void makePlaceBet(){
         System.out.print("Pick a place bet [4, 5, 6, 8, 9, or 10]:  ");
         int pickPlaceBet = s.nextInt();
         while (pickPlaceBet != 4 && pickPlaceBet != 5 && pickPlaceBet != 6 && pickPlaceBet != 8 && pickPlaceBet != 9 && pickPlaceBet != 10){
             System.out.print("Try Again\nPick a place bet [0 for none, 4, 5, 6, 8, 9, or 10]:  ");
             pickPlaceBet = s.nextInt();
            }
             double placeBetAmt = getPassBet();
             while (placeBetAmt > amtToBet){
                    System.out.println("Try Again.");
                    placeBetAmt = getPassBet();
                }
        int betPosition = 6;
        switch(pickPlaceBet){
            case 4: betPosition = 0; break;
            case 5: betPosition = 1; break;
            case 6: betPosition = 2; break;
            case 8: betPosition = 3; break;
            case 9: betPosition = 4; break;
            case 10: betPosition = 5; break;
            default: System.out.println("ERROR. EXITING."); System.exit(0); break;
        }
        placeBetAmounts[betPosition] += placeBetAmt;
        amtToBet -= placeBetAmt;
        System.out.println("Place Bet Set");
    }
    
    public static void playAgain(){
        Scanner t = new Scanner(System.in);
        if (amtToBet <= 0){
            System.out.print("You do not have the funds to play another game. Cash in more? Yes/No: ");
            String input1 = t.nextLine();
            char passyn1 = input1.charAt(0);
            while (passyn1 != 'y' && passyn1 != 'Y' && passyn1 != 'n' && passyn1 != 'N'){
                System.out.println("Try Again.");
                input1 = s.nextLine();
                passyn1 = input1.charAt(0);
            }
            if (passyn1 == 'y' || passyn1 == 'Y'){
                playagain = true;
                counter = 0;
                main(null);
                return;
            }
            else{
                System.out.println("Buh Bye!");
                System.exit(0);
            }
        }
        else{
        System.out.print("\nPlay Again? Yes/No: ");
        String input = t.nextLine();
        char yn = input.charAt(0);
        if (yn == 'Y' || yn == 'y'){
            counter = 0;
            System.out.print("\n\nYour Bank: "+rnd.format(bank)+"\n");
            playCraps();
        }
        else if (yn == 'N' || yn == 'n'){
            System.out.println("Buh Bye!");
            System.exit(0);
        }
        else{
            System.out.println("Yes or No, Please.");
            playAgain();
        }
    }
    }
    public static void sleep(){
        int x = (r.nextInt(5)+5)*1000; 
        try {
            Thread.sleep(x);
        } catch(InterruptedException e) {
        } 
    }
    }

