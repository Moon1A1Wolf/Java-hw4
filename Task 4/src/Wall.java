public class Wall implements IPart {
    private boolean built = false;

    @Override
    public void build() {
        built = true;
        System.out.println("Будуємо стіну...");
    }

    @Override
    public boolean isBuilt() {
        return built;
    }
}