package proco2014.novice;

public class NovC_Ampersand {
    public static void main(String[] args) {
        for (String arg : args) {
            System.out.print(arg.replaceAll("&", "&amp;"));
            System.out.print(" ");
        }
        System.out.println();
    }
}
