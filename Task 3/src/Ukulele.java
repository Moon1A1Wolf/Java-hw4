public class Ukulele extends MusicalInstrument {
    public Ukulele() {
        super("Укулеле", 
              "Укулеле — маленька гітара з Гавайських островів, зазвичай має чотири струни.",
              "Укулеле виникла в середині 19 століття на Гавайях.");
    }

    @Override
    public void Sound() {
        System.out.println("Укулеле звучить: яскравий, мелодійний звук з чіткими акцентами.");
    }
}
