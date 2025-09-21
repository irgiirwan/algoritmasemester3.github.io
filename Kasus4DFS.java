package Minggu4;

import java.util.ArrayList;

class Pekerjaan {
    private String nama;
    private int durasi, bobot;

    public Pekerjaan(String nama, int durasi, int bobot) {
        this.nama = nama;
        this.durasi = durasi;
        this.bobot = bobot;
    }

    public String getNama() {
        return nama;
    }

    public int getDurasi() {
        return durasi;
    }

    public int getBobot() {
        return bobot;
    }

    @Override
    public String toString() {
        return getNama() + ": (" + getDurasi() + " jam, bobot " + getBobot() + ")";
    }
}

public class Kasus4DFS {
    static void dfs(ArrayList<Pekerjaan> currentUrutan, boolean[] sudahDipakai, ArrayList<Pekerjaan> daftar, int waktuSekarang, int nilaiSekarang, int kedalaman) {

        if (kedalaman == daftar.size()) {
            if (nilaiSekarang < nilaiTerbaik) {
                nilaiTerbaik = nilaiSekarang;
                urutanTerbaik = new ArrayList<>(currentUrutan);
            }
            return;
        }

        if (nilaiSekarang >= nilaiTerbaik){
            return;
        }

        for (int i = 0; i < daftar.size(); i++) {
            if (!sudahDipakai[i]) {
                sudahDipakai[i] = true;
                Pekerjaan pkj = daftar.get(i);

                int waktuBaru = waktuSekarang + pkj.getDurasi();
                int nilaiBaru = nilaiSekarang + pkj.getBobot() * waktuBaru;

                currentUrutan.add(pkj);
                dfs(currentUrutan, sudahDipakai, daftar, waktuBaru, nilaiBaru, kedalaman + 1);

                currentUrutan.remove(currentUrutan.size() - 1);
                sudahDipakai[i] = false;
            }
        }
    }

    static ArrayList<Pekerjaan> urutanTerbaik = new ArrayList<>();
    static int nilaiTerbaik = Integer.MAX_VALUE;

    public static void main(String[] args) {
        ArrayList<Pekerjaan> listPekerjaan = new ArrayList<>();
        listPekerjaan.add(new Pekerjaan("A", 3, 4));
        listPekerjaan.add(new Pekerjaan("B", 2, 2));
        listPekerjaan.add(new Pekerjaan("C", 5, 10));
        listPekerjaan.add(new Pekerjaan("D", 1, 1));
        listPekerjaan.add(new Pekerjaan("E", 4, 3));

        boolean[] sudahDipakai = new boolean[listPekerjaan.size()];
        dfs(new ArrayList<>(), sudahDipakai, listPekerjaan, 0, 0, 0);

        int totalSeluruhWaktu = 0, totalSeluruh = 0;
        for (Pekerjaan rekap : urutanTerbaik) {
            totalSeluruhWaktu += rekap.getDurasi();
            long hasilKali = (long) totalSeluruhWaktu * rekap.getBobot();
            totalSeluruh += hasilKali;

            System.out.println(rekap.getNama()+": ("+rekap.getDurasi()+" jam, bobot "+rekap.getBobot()+", Waktu Selesai "+totalSeluruhWaktu+", Selesai x Bobot "+ hasilKali+")");
        }
        System.out.println("Jadi, urutan pekerjaan supaya total ialah: waktu selesai × bobot = "+totalSeluruh+" dengan guna konsep DFS");
    }
}
