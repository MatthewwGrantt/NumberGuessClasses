import java.util.ArrayList;

public class Player {
        private String name;
        private ArrayList<NumberGuess> gamesPlayed;
    
        public Player(String name) {
            this.name = name;
            this.gamesPlayed = new ArrayList<>();
        }
    
        public void addGame(NumberGuess game) {
            this.gamesPlayed.add(game);
        }
    
        public ArrayList<NumberGuess> getGamesPlayed() {
            return gamesPlayed;
        }
    
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Player name: " + name + "\n");
            sb.append("Games played: " + gamesPlayed.size() + "\n");
            int start = Math.max(0, gamesPlayed.size() - 5);
            for (int i = start; i < gamesPlayed.size(); i++) {
                sb.append("Game " + (i + 1) + ":\n" + gamesPlayed.get(i).toString());
            }
            return sb.toString();
        }
    }

