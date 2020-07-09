import java.util.ArrayList;
import java.util.List;

public class TrackingService {
    private int total;
    private int goal;
    private List<HistoryItem> history = new ArrayList<>();
    private int historyId = 0;

    public void removeCalories(int amount) {
        total -= amount;
        if (total < 0) total = 0;
        history.add(new HistoryItem(historyId++, amount, "remove", total));
    }
    public void addCalories(int amount) {
        total += amount;
        if (total < 0) total = 0;
        history.add(new HistoryItem(historyId++, amount, "add", total));
    }

    public int getTotal() {
        return total;
    }

    public void setGoal(int goal) {
        this.goal = goal;
    }

    public int getGoal() {
        return goal;
    }

    public List<HistoryItem> getHistory() {
        return history;
    }

    public boolean isGoalMet(){
        return total>=goal;
    }
}
