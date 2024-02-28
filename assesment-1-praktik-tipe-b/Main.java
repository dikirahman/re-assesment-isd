import java.util.LinkedList;
import java.util.Queue;

class Dokter {
    private String nama;
    private String jenis;

    public Dokter(String nama, String jenis) {
        this.nama = nama;
        this.jenis = jenis;
    }

    public String getNama() {
        return nama;
    }

    public String getJenis() {
        return jenis;
    }
}

class Klinik {
    private Queue<String> antrianUmum;
    private Queue<String> antrianSpesialis;
    private Dokter dokterUmum;
    private Dokter dokterSpesialis;

    public Klinik() {
        antrianUmum = new LinkedList<>();
        antrianSpesialis = new LinkedList<>();
        dokterUmum = new Dokter("dr. Budi", "Dokter Umum");
        dokterSpesialis = new Dokter("dr. Mimi", "Dokter THT");
    }

    public void ambilNomor(String nomor, String nama, String jenisDokter) {
        if (jenisDokter.equals("Dokter Umum")) {
            antrianUmum.add(nomor + " - " + nama);
            System.out.println("Anda adalah pasien dokter umum");
            if (antrianUmum.size() > 1) {
                System.out.println("Anda menunggu " + (antrianUmum.size() - 1) + " orang lagi");
            }
        } else if (jenisDokter.equals("Dokter THT")) {
            antrianSpesialis.add(nomor + " - " + nama);
            System.out.println("Anda adalah pasien dokter spesialis");
            if (antrianSpesialis.size() > 1) {
                System.out.println("Anda menunggu " + (antrianSpesialis.size() - 1) + " orang lagi");
            }
        } else {
            System.out.println("Jenis dokter tidak valid");
        }
    }

    public void panggilNomorUmum() {
        if (!antrianUmum.isEmpty()) {
            String pasien = antrianUmum.poll();
            System.out.println("Memanggil nomor untuk " + dokterUmum.getNama() + " - " + pasien);
        } else {
            System.out.println("Antrian dokter umum kosong");
        }
    }

    public void panggilNomorSpesialis() {
        if (!antrianSpesialis.isEmpty()) {
            String pasien = antrianSpesialis.poll();
            System.out.println("Memanggil nomor untuk " + dokterSpesialis.getNama() + " - " + pasien);
        } else {
            System.out.println("Antrian dokter spesialis kosong");
        }
    }

    public void resetAntrian() {
        antrianUmum.clear();
        antrianSpesialis.clear();
        System.out.println("Antrian telah dihapus");
    }
}

public class Main {
    public static void main(String[] args) {
        Klinik klinik = new Klinik();
        
        klinik.ambilNomor("A001", "Rita", "Dokter Umum");
        klinik.ambilNomor("A002", "Kiki", "Dokter Umum");
        klinik.ambilNomor("B001", "Ika", "Dokter THT");
        klinik.ambilNomor("A003", "Test", "Dokter Umum");

        klinik.panggilNomorUmum();
        klinik.panggilNomorUmum();
        klinik.panggilNomorSpesialis();
        klinik.panggilNomorUmum();

        klinik.resetAntrian();
    }
}