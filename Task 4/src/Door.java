public class Door implements IPart {
    private boolean built = false;

    @Override
    public void build() {
        built = true;
        System.out.println("Будуємо двері...");
    }

    @Override
    public boolean isBuilt() {
        return built;
    }
}