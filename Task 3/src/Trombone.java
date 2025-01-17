public class Trombone extends MusicalInstrument {
    public Trombone() {
        super("Тромбон", 
              "Тромбон — мідний духовий інструмент, що має висувну трубу для зміни висоти звуку.",
              "Тромбон виник в Європі в середині XV століття.");
    }

    @Override
    public void Sound() {
        System.out.println("Тромбон звучить: глибокий, металевий звук через коливання повітря.");
    }
}
