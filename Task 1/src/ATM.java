import java.util.HashMap;
import java.util.Map;

public class ATM {
    private final Map<Integer, Integer> banknotes;
    private final int minWithdrawalAmount;
    private final int maxBanknotes;

    public ATM(int minWithdrawalAmount, int maxBanknotes) {
        this.banknotes = new HashMap<>();
        this.minWithdrawalAmount = minWithdrawalAmount;
        this.maxBanknotes = maxBanknotes;
        initializeBanknotes();
    }

    private void initializeBanknotes() {
        int[] denominations = {1, 2, 5, 10, 20, 50, 100, 200, 500};
        for (int denom : denominations) {
            banknotes.put(denom, 0);
        }
    }

    public void loadBanknotes(int denomination, int count) {
        if (!banknotes.containsKey(denomination)) {
            throw new IllegalArgumentException("Некоректний номінал: " + denomination);
        }
        banknotes.put(denomination, banknotes.get(denomination) + count);
    }

    public void depositMoney(Map<Integer, Integer> deposit) {
        for (Map.Entry<Integer, Integer> entry : deposit.entrySet()) {
            int denomination = entry.getKey();
            int count = entry.getValue();
            loadBanknotes(denomination, count);
        }
    }

    public Map<Integer, Integer> withdrawMoney(int amount) {
        if (amount < minWithdrawalAmount) {
            throw new IllegalArgumentException("Сума менша за мінімальний ліміт для зняття.");
        }

        Map<Integer, Integer> withdrawal = new HashMap<>();
        int totalBanknotes = 0;

        for (int denom : banknotes.keySet().stream().sorted((a, b) -> b - a).toList()) {
            if (amount == 0) break;
            int availableNotes = banknotes.get(denom);
            int requiredNotes = Math.min(amount / denom, availableNotes);

            if (requiredNotes > 0) {
                withdrawal.put(denom, requiredNotes);
                amount -= denom * requiredNotes;
                totalBanknotes += requiredNotes;

                if (totalBanknotes > maxBanknotes) {
                    throw new IllegalArgumentException("Перевищено максимальну кількість купюр.");
                }
            }
        }

        if (amount > 0) {
            throw new IllegalArgumentException("Неможливо видати точну суму доступними купюрами.");
        }

        for (Map.Entry<Integer, Integer> entry : withdrawal.entrySet()) {
            banknotes.put(entry.getKey(), banknotes.get(entry.getKey()) - entry.getValue());
        }

        return withdrawal;
    }

    public int getTotalMoney() {
        return banknotes.entrySet().stream().mapToInt(e -> e.getKey() * e.getValue()).sum();
    }
}