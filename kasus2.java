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
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan banyak Acara: ");
        int n = sc.nextInt();

        List<Acara> semuaAcara = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.print("Masukkan waktu mulai-akhir Acara: ");
            int mulai = sc.nextInt(), akhir = sc.nextInt();
            semuaAcara.add(new Acara(mulai, akhir));
        }

        if (hasOverlap(semuaAcara)) {
            System.out.println("Ada acara yang bertumpukan.");
        } else {
            System.out.println("Tidak ada acara yang bertumpukan.");
        }
    }
}
