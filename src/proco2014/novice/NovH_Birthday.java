package proco2014.novice;

public class NovH_Birthday {
    public static void main(String[] args) {
        double p = Double.parseDouble(args[0]);

        assert (p >= 0.0001);
        assert (p <= 0.9995);

        double pAllDiff = 1.0;
        int nPeople = 1;

        while (1 - pAllDiff < p) {
            // p for everybody with a different birthday
            pAllDiff *= 1 - nPeople / 366.0;
            nPeople++;
        }

        System.out.println(nPeople);
    }
}
