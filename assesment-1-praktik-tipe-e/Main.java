import java.util.LinkedList;
import java.util.Stack;

class BackForward {
    Stack<String> activePage = new Stack<>();
    Stack<String> inActivePage = new Stack<>();

    LinkedList<String> history = new LinkedList<>();

    public void back() {

        // cek apakah ada page yang sedang dibuka?
        if(activePage.isEmpty()) {
            System.out.println("Tidak ada page");
        }

        // keluarkan page yang aktif
        String url = activePage.pop();
        
        // Simpan page ke tidak aktif
        inActivePage.push(url);

        System.out.println("Mundur ke alamat " + activePage.peek());
    }

    public void forward() {
        if(inActivePage.isEmpty()) {
            System.out.println("Tidak ada page sebelumnya");
        }

        String url = inActivePage.pop();
        activePage.push(url);

        System.out.println("Kembali lagi ke alamat " + activePage.peek());
    }

    public void history() {
        System.out.println("History Penelusuran web: ");
        System.out.print(history);
    }

    public void tambahData(String url) {
        // buka page baru
        activePage.push(url);

        // tambahkan page yang dikeluarkan ke history
        history.add(url);

        System.out.println("Website " + url + " dibuka");
    }
}

public class Main {
    public static void main(String[] args) {
        BackForward backForward = new BackForward();
        
        backForward.tambahData("https://www.google.com/search?q=comparable+java+integer");
        backForward.tambahData("https://www.javatpoint.com/java-integer-compareto-method");
        backForward.tambahData("https://www.javatpoint.com/java-integer-compareunsigned-method");

        backForward.back();
        backForward.forward();
        backForward.history();
    }
}