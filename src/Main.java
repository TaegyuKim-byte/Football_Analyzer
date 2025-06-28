//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FootballManager footballManager = new FootballManager();

        Scanner keyboard = new Scanner(System.in);
        int enter;
        boolean goon = true;

        do {
            System.out.println("==========================================");
            System.out.println("Welcome to the Football Manager Program.");
            System.out.println("Choose your option:");
            System.out.println("------------------------------------------");
            System.out.println("(1) Register Players from text File");
            System.out.println("(2) Register Team and Assign Players");
            System.out.println("(3) Register League and Assign Teams");
            System.out.println("(4) Show all Players in this world");
            System.out.println("(5) Show all Teams in this world");
            System.out.println("(6) Show all Leagues in this world");
            //System.out.println("");
            //System.out.println("");
            System.out.println("(0) Exit Program");
            System.out.println("==========================================");


            enter = keyboard.nextInt();

            switch (enter) {
                case 1: {
                    System.out.println("Write TEXT FILE'S NAME what you want to register");
                    System.out.println("(If you want, You can add another player to text file)");
                    System.out.println("(You must be careful info's order)");
                    String filename = keyboard.next();

                    footballManager.addPlayerSet(filename);

                    break;
                }
                case 2: {

                    break;
                }
                case 3: {
                    //We will write here soon..
                    break;
                }
                case 4: {
                    //We will write here soon...
                    break;
                }
                case 5: {
                    //We will write here soon..
                    break;
                }
                case 6: {
                    //We will write here soon..
                    break;
                }
                case 0:
                    goon = false;
                    break;
                default:
                    System.out.println("Invalid input. Please choose between 0 to 5.");
                    break;
            }


        } while (goon);

    }
}