//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("=========[Welcome to the Soccer Analyzer!]=========");
        System.out.println("Upload your player! (name \\n age \\n country \\n overall)");

        Scanner keyboard = new Scanner(System.in);
        String playerName = keyboard.nextLine();
        //Using nextLine after using nextInt/next..
        //\n remains at input buffer!!!!
        int playerAge = keyboard.nextInt();
        String trash = keyboard.nextLine();
        String playerCountry = keyboard.nextLine();
        int playerOverall = keyboard.nextInt();
        trash = keyboard.nextLine();

        Player player1 = new Player(playerName, playerAge, playerCountry, playerOverall);

        System.out.println(player1);
    }
}