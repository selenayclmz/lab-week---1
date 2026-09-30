import java.util.Scanner;

public class FootballTournament {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

   
        String[] teamNames = {"Team A", "Team B", "Team C", "Team D"};
        
        int[][] fixture = {
            {0, 1}, {2, 3}, {0, 2}, {1, 3}, {0, 3}, {1, 2}
        };

        
        int[][] stats = new int[4][8];
        int[][] scores = new int[6][2];

        // GÖREV 1
        System.out.println("--- Match Fixture ---");
        for (int i = 0; i < fixture.length; i++) {
            System.out.println("Match " + (i + 1) + ": " + teamNames[fixture[i][0]] + " vs " + teamNames[fixture[i][1]]);
        }
        System.out.println("---------------------\n");

        for (int i = 0; i < fixture.length; i++) {
            int t1 = fixture[i][0];
            int t2 = fixture[i][1];

            System.out.print("Match " + (i + 1) + ": " + teamNames[t1] + " vs " + teamNames[t2] + " - " + teamNames[t1] + " goals: ");
            scores[i][0] = scanner.nextInt();

            System.out.print("Match " + (i + 1) + ": " + teamNames[t1] + " vs " + teamNames[t2] + " - " + teamNames[t2] + " goals: ");
            scores[i][1] = scanner.nextInt();
            System.out.println();

            int g1 = scores[i][0];
            int g2 = scores[i][1];

            
            stats[t1][0]++;
            stats[t2][0]++;

            // GÖREV 2
            if (g1 > g2) {
                stats[t1][1]++; 
                stats[t1][4] += 3; 
                stats[t2][3]++; 
            } else if (g1 < g2) {
                stats[t2][1]++; 
                stats[t2][4] += 3; 
                stats[t1][3]++; 
            } else {
                stats[t1][2]++; 
                stats[t2][2]++; 
                stats[t1][4] += 1;
                stats[t2][4] += 1;
            }

            // GÖREV 3
            stats[t1][5] += g1; // T1 Atılan gol
            stats[t1][6] += g2; // T1 Yenilen gol
            stats[t2][5] += g2; // T2 Atılan gol
            stats[t2][6] += g1; // T2 Yenilen gol
        }

        // Görev 3 Devamı
        for (int i = 0; i < 4; i++) {
            stats[i][7] = stats[i][5] - stats[i][6];
        }

        // Görev 1 Devamı
        System.out.println("--- Entered Match Scores ---");
        for (int i = 0; i < fixture.length; i++) {
            System.out.println("Match " + (i + 1) + ": " + teamNames[fixture[i][0]] + " " + scores[i][0] + " - " + scores[i][1] + " " + teamNames[fixture[i][1]]);
        }

        // --- GÖREV 4
        System.out.println("\n--- Standings Table ---");
        System.out.printf("%-10s %-15s %-5s %-7s %-8s %-13s %-15s\n", "Team", "Matches played", "Wins", "Draws", "Losses", "Total points", "Goal difference");
        for (int i = 0; i < 4; i++) {
            System.out.printf("%-10s %-15d %-5d %-7d %-8d %-13d %-15d\n",
                    teamNames[i], stats[i][0], stats[i][1], stats[i][2], stats[i][3], stats[i][4], stats[i][7]);
        }

        // --- GÖREV 5
        int champIndex = 0;
        for (int i = 1; i < 4; i++) {
            
            if (stats[i][4] > stats[champIndex][4]) {
                champIndex = i;
            } 
            
            else if (stats[i][4] == stats[champIndex][4]) {
                if (stats[i][7] > stats[champIndex][7]) {
                    champIndex = i;
                }
            }
        }

        System.out.println("\nTournament Champion: " + teamNames[champIndex]); //[cite: 5]
        
       
    }
}