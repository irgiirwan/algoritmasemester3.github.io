package Minggu1;

import java.util.ArrayList;
import java.util.Comparator;

class pekerjaan {
    private String nama;
    private int waktu, bobot;
    private double rasio;

    public pekerjaan(String nama, int waktu, int bobot) {
        this.nama = nama;
        this.waktu = waktu;
        this.bobot = bobot;
        this.rasio = (double) waktu / bobot;
    }

    public String getNama() {
        return nama;
    }

    public int getWaktu() {
        return waktu;
    }

    public int getBobot() {
        return bobot;
    }

    public double getRasio() {
        return rasio;
    }

    @Override
    public String toString() {
        String hasilData = getNama()+": ("+getWaktu()+" jam, bobot "+getBobot()+", Rasio"+getRasio()+")";
        return hasilData + "\n";
    }
}

public class Kasus4 {
    public static void main(String[] args) {
        ArrayList<pekerjaan> listPekerjaan = new ArrayList<>();

        listPekerjaan.add(
                new pekerjaan("A",3, 4)
        );
        listPekerjaan.add(
                new pekerjaan("B",2, 2)
        );
        listPekerjaan.add(
                new pekerjaan("C",5, 10)
        );
        listPekerjaan.add(
                new pekerjaan("D",1, 1)
        );
        listPekerjaan.add(
                new pekerjaan("E",4, 3)
        );

        for(pekerjaan rasioPekerja : listPekerjaan) {
            System.out.println(rasioPekerja.getNama()+": ("+rasioPekerja.getWaktu()+" jam, bobot "+rasioPekerja.getBobot()+")");
        }
        System.out.println();

        for(pekerjaan rasioPekerja : listPekerjaan) {
            System.out.println(rasioPekerja.getNama()+": ("+rasioPekerja.getWaktu()+" jam, bobot "+rasioPekerja.getBobot()+", Rasio "+rasioPekerja.getRasio()+")");
        }
        System.out.println();

        listPekerjaan.sort(Comparator.comparingDouble(pekerjaan::getRasio));

        int totalSeluruhWaktu = 0;
        long totalSeluruh = 0;

        for (pekerjaan rekap : listPekerjaan) {
            totalSeluruhWaktu += rekap.getWaktu();
            long hasilKali = (long) totalSeluruhWaktu * rekap.getBobot();
            totalSeluruh += hasilKali;

            System.out.println(rekap.getNama()+": ("+rekap.getWaktu()+" jam, bobot "+rekap.getBobot()+", Rasio "+rekap.getRasio()+", Waktu Selesai "+totalSeluruhWaktu+", Selesai x Bobot "+ hasilKali+")");
        }
        System.out.println();

        for(pekerjaan rasioPekerja : listPekerjaan) {
            System.out.println(rasioPekerja.getNama()+": ("+rasioPekerja.getWaktu()+" jam, bobot "+rasioPekerja.getBobot()+", Rasio "+rasioPekerja.getRasio()+")");
        }
        System.out.println();
        System.out.println("Jadi, urutan pekerjaan supaya total ialah: waktu selesai × bobot = "+totalSeluruh);
    }
}
