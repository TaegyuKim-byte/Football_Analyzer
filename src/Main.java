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

        footballManager.addPlayerSet("players.txt");

        System.out.println("-----등록된 선수 목록----");
        for (Player p : footballManager.players) {
            System.out.println(p.getName() + " / Age: " + p.getAge() + " / Country: " + p.getCountry());
        }
        /*
        do {
            System.out.println("_______________________________________");
            System.out.println("Welcome to the Football Manager. choose your option");
            System.out.println("(1) Add players to library collection from a text file");
            System.out.println("(2) ");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");



        } while (goon);
        */
    }
}