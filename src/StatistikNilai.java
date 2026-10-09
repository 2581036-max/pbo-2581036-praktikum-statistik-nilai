import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StatistikNilai {
    static final int SELESAI = -1;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> daftar = new ArrayList<>();


        int nilai;
        do {
            System.out.print("Nilai ke-" + (daftar.size() + 1) + " : ");
            nilai = input.nextInt();
            if (nilai == SELESAI) {
                continue;               // lanjut ke kondisi do-while, loop berhenti
            }
            if (nilai < 0 || nilai > 100) {
                System.out.println("Nilai harus 0-100, coba lagi.");
                continue;               // ditolak: tidak di-add, nomor prompt tetap
            }
            daftar.add(nilai);
        } while (nilai != SELESAI);

        System.out.println();

        if (daftar.isEmpty()) {
            System.out.println("Tidak ada nilai yang dimasukkan.");
            return;
        }

        int total = 0;
        for (int x : daftar) {
            total += x;
        }
        double rata = (double) total / daftar.size();

        // 4. Tertinggi & terendah dengan loop sendiri.
        // Mulai dari elemen PERTAMA (bukan 0): kalau terendah dimulai dari 0,
        // hasilnya selalu 0 karena tidak ada nilai yang lebih kecil dari itu.
        // Tertinggi pun dimulai dari elemen pertama supaya konsisten.
        int maks = daftar.get(0);
        int min = daftar.get(0);
        for (int x : daftar) {
            if (x > maks) maks = x;
            if (x < min) min = x;
        }

        // 5. Putaran kedua: jumlah di atas rata-rata.
        // Tidak bisa dihitung di putaran pertama karena rata-rata baru
        // diketahui setelah SEMUA nilai terbaca dan dijumlahkan.
        int diAtas = 0;
        for (int x : daftar) {
            if (x > rata) diAtas++;
        }
        int[] jumlahGrade = new int[5];
        for (int x : daftar) {
            if (x >= 90) jumlahGrade[0]++;
            else if (x >= 80) jumlahGrade[1]++;
            else if (x >= 70) jumlahGrade[2]++;
            else if (x >= 60) jumlahGrade[3]++;
            else jumlahGrade[4]++;
        }

        String[] namaGrade = {"A", "B", "C", "D", "E"};
        StringBuilder distribusi = new StringBuilder();
        for (int i = 0; i < jumlahGrade.length; i++) {
            if (i > 0) distribusi.append(" ");
            distribusi.append(namaGrade[i]).append("=").append(jumlahGrade[i]);
        }
        ArrayList<Integer> terurut = new ArrayList<>(daftar);
        Collections.sort(terurut);

        System.out.println("Nilai tersimpan : " + daftar);
        System.out.println("Jumlah          : " + daftar.size());
        System.out.println("Rata-rata       : " + String.format("%.2f", rata));
        System.out.println("Tertinggi       : " + maks);
        System.out.println("Terendah        : " + min);
        System.out.println("Di atas rata2   : " + diAtas + " orang");
        System.out.println("Distribusi      : " + distribusi);
        System.out.println("Terurut         : " + terurut);
        System.out.println("Urutan asli     : " + daftar);
    }
}