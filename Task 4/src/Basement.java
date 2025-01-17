public class Basement implements IPart {
    private boolean built = false;

    @Override
    public void build() {
        built = true;
        System.out.println("Будуємо фундамент...");
    }

    @Override
    public boolean isBuilt() {
        return built;
    }
}