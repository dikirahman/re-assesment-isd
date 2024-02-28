import java.util.HashSet;
import java.util.Scanner;

public class Main {
    static HashSet<String> vocabulary = new HashSet<>();
    private static final Scanner scanner = new Scanner(System.in);

    private static void inputKata() {
        System.out.println("Masukan kata Irregular verb: ");
        String kata = scanner.nextLine().toLowerCase();
        vocabulary.add(kata);
    }

    private static void pencariankata() {
        System.out.println("Tuliskan kata yang dicari: ");
        String kata = scanner.nextLine().toLowerCase();
        if(!vocabulary.contains(kata)){
            System.out.println("Kata " + kata + " bukan merupakan irregular verb");
        } else {
            System.out.println("Kata " + kata + " merupakan irregular verb");
        }
    }

    private static void tampilkanSeluruhKata() {
        System.out.println(vocabulary);

    }

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("\nMenu Input Kosakata:");
            System.out.println("1. Input Verb Irregular");
            System.out.println("2. Cari kata");
            System.out.println("3. Tampilkan isi kamus");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    inputKata();
                    break;
                case 2:
                    pencariankata();
                    break;
                case 3:
                    tampilkanSeluruhKata();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Anda telah keluar!");
                    break;
                default:
                    System.out.println("Menu tidak valid. Silakan pilih lagi.");
            }
        }
    }

}
