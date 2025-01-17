public class Window implements IPart {
    private boolean built = false;

    @Override
    public void build() {
        built = true;
        System.out.println("Будуємо вікно...");
    }

    @Override
    public boolean isBuilt() {
        return built;
    }
}