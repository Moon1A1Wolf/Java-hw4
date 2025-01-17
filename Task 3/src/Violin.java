public class Violin extends MusicalInstrument {
    public Violin() {
        super("Скрипка", 
              "Скрипка — струнний музичний інструмент, який використовується для виконання класичної музики.",
              "Історія скрипки починається в Італії в XV столітті.");
    }

    @Override
    public void Sound() {
        System.out.println("Скрипка звучить: вібрує струнно через смичок.");
    }
}
