import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Bank {
    private final List<ATM> atms;

    public Bank() {
        this.atms = new ArrayList<>();
    }

    public void addATM(ATM atm) {
        atms.add(atm);
    }

    public int getTotalMoneyInNetwork() {
        return atms.stream().mapToInt(ATM::getTotalMoney).sum();
    }

    public void loadATM(int index, Map<Integer, Integer> banknotes) {
        if (index < 0 || index >= atms.size()) {
            throw new IndexOutOfBoundsException("Некоректний індекс банкомату.");
        }
        atms.get(index).depositMoney(banknotes);
    }

    public void initializeATMs(int count, int minWithdrawalAmount, int maxBanknotes) {
        for (int i = 0; i < count; i++) {
            atms.add(new ATM(minWithdrawalAmount, maxBanknotes));
        }
    }

    public ATM getATM(int index) {
        if (index < 0 || index >= atms.size()) {
            throw new IndexOutOfBoundsException("Некоректний індекс банкомату.");
        }
        return atms.get(index);
    }

    public int getNumberOfATMs() {
        return atms.size();
    }
}