public class Main {
    public static void main(String[] args) {
        MusicalInstrument violin = new Violin();
        violin.Show();
        violin.Desc();
        violin.History();
        violin.Sound();

        System.out.println();

        MusicalInstrument trombone = new Trombone();
        trombone.Show();
        trombone.Desc();
        trombone.History();
        trombone.Sound();

        System.out.println();

        MusicalInstrument ukulele = new Ukulele();
        ukulele.Show();
        ukulele.Desc();
        ukulele.History();
        ukulele.Sound();

        System.out.println();

        MusicalInstrument cello = new Cello();
        cello.Show();
        cello.Desc();
        cello.History();
        cello.Sound();
    }
}
