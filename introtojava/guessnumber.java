import java.util.*;
public class guessnumber
{
   public static void main(String args[]){
       Scanner s = new Scanner(System.in);
       Random r = new Random();
       
       double bank, bet,newTotal=0;
       int selectNum, randomNum;
       
       System.out.println("¡Bienvenidos a la casa del juego de java!\nHoy, vas a jugar \"Guess the Number\"");
       System.out.print("Cuánto dinero tienes? €");
       bank = s.nextDouble();
       int clean = 0;
       System.out.print("Cuánto dinero vas a apostar? €");
       bet = s.nextDouble();
       while (clean != 1){
           if (bet > bank){
               System.out.print("Probas otra vez\nCuánto dinero vas a apostar? €");
               bet = s.nextDouble();
            }
            else{
                clean = 1;
            }
        }
        System.out.print("\nQué numero seleccionas? (1-5): ");
        selectNum = s.nextInt();
        int clean2 = 0;
        while (clean2 != 1){
            if (selectNum < 1 || selectNum > 5){
                System.out.print("Probas otra vez\nQué numero seleccionas? (1-5): ");
                selectNum = s.nextInt();
            }
            else{
                clean2 = 1;
            }
        }
        randomNum = r.nextInt(5)+1;
        System.out.println("\nLa bola terrateniente en "+randomNum);
        if (randomNum == selectNum){
            System.out.println("¡Felicidades! ¡Tú eres victoriosa! Tú ganas €"+bet);
            newTotal = bank + bet;
        }
        else{
            System.out.println("¡Eres un peredor! Tú perdes €"+bet);
            newTotal = bank - bet;
        }
        System.out.println("Tú total nuevo es €"+newTotal);
        System.out.println("¡Hasta luego!");
    }
}
