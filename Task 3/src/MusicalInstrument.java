public abstract class MusicalInstrument implements IInfo {
    protected String name;
    protected String description;
    protected String history;

    public MusicalInstrument(String name, String description, String history) {
        this.name = name;
        this.description = description;
        this.history = history;
    }

    @Override
    public void Show() {
        System.out.println("Назва інструменту: " + name);
    }

    @Override
    public void Desc() {
        System.out.println("Опис: " + description);
    }

    @Override
    public void History() {
        System.out.println("Історія: " + history);
    }
}
