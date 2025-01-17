public class Cello extends MusicalInstrument {
    public Cello() {
        super("Віолончель", 
              "Віолончель — струнний інструмент, один з найбільших представників скрипкової родини.",
              "Віолончель з'явилась в Італії в 16 столітті.");
    }

    @Override
    public void Sound() {
        System.out.println("Віолончель звучить: глибокий, емоційний звук через резонансні струни.");
    }
}
