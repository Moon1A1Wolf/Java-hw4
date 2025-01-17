public class Roof implements IPart {
    private boolean built = false;

    @Override
    public void build() {
        built = true;
        System.out.println("Будуємо дах...");
    }

    @Override
    public boolean isBuilt() {
        return built;
    }
}