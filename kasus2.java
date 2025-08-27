package Minggu1_1;

import java.util.*;

class Acara {
    int mulai;
    int akhir;

    public Acara(int mulai, int akhir) {
        this.mulai = mulai;
        this.akhir = akhir;
    }
}

public class Kasus2 {

    public static boolean hasOverlap(List<Acara> semuaAcara) {
        semuaAcara.sort(Comparator.comparingInt(e -> e.mulai));

        for (int i = 0; i < semuaAcara.size() - 1; i++) {
            Acara sekarang = semuaAcara.get(i);
            Acara berikut = semuaAcara.get(i + 1);

            if (sekarang.akhir > berikut.mulai) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ArrayList<Acara> semuaAcara = new ArrayList<>();
        semuaAcara.add(new Acara(10, 11));
        semuaAcara.add(new Acara(12, 14));
        semuaAcara.add(new Acara(15, 16));

        if (hasOverlap(semuaAcara)) {
            System.out.println("Ada acara yang bertumpukan.");
        } else {
            System.out.println("Tidak ada acara yang bertumpukan.");
        }
    }
}
