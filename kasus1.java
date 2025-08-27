package Minggu1_1;

import java.util.*;

public class Kasus1 {
    public static String generatorSandi(int n) {

        String upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String specialChars = "!@#$%^&*()-_=+[]{}<>?/";

        String allChars = upperCaseLetters + lowerCaseLetters + numbers + specialChars;
        Random random = new Random();

        List<Character> sandiChars = new ArrayList<>();
        sandiChars.add(upperCaseLetters.charAt(random.nextInt(upperCaseLetters.length())));
        sandiChars.add(lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length())));
        sandiChars.add(numbers.charAt(random.nextInt(numbers.length())));
        sandiChars.add(specialChars.charAt(random.nextInt(specialChars.length())));

        for (int i = 4; i < n; i++) {
            sandiChars.add(allChars.charAt(random.nextInt(allChars.length())));
        }

        Collections.shuffle(sandiChars);

        StringBuilder sandi = new StringBuilder();
        for (char c : sandiChars) {
            sandi.append(c);
        }

        return sandi.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean status = true;
        while(status) {
            System.out.print("Masukkan panjang password: ");
            int n = sc.nextInt();
            if (n < 4) {
                System.out.println("Panjang karakter min 4!\n");
            } else {
                String password = generatorSandi(n);
                System.out.println("Password keluar: " + password);
                status = false;
            }
        }
    }
}
