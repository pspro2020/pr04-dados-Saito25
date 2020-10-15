package testing;

public class Marcador {

    private int[] diceValues = new int[6];
    private int totalRolls = 0;

    public int[] getDiceValues() {
        synchronized (this) {
            return diceValues;

        }
    }

    public int getTotalRolls() {
        return totalRolls;
    }

    public void setDiceValues(int i) {
        synchronized (this) {
            diceValues[i] += 1;
        }
    }

    public void setTotalRolls(int totalRolls) {
        this.totalRolls = totalRolls;
    }

    public void addTotalRoll() {
        synchronized (this) {
            totalRolls++;
        }
    }
}
