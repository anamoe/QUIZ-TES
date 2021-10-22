package com.example.quiz.model;

import com.example.quiz.R;

/**
 * Created by Dhimas Panji Sastra on
 * Copyright (c)  . All rights reserved.
 * Last modified $file.lastModified
 * Made With ❤ for U
 */
public class Pertanyaan {
    private String pertanyaanTulis[] = {
            "Sinonim dari kata EVOKASI",
            "Sinonim dari kata BAKU",
            "Antonim dari kata KENDALA",
            "Antonim dari kata EKSTRINSIK",
            "Soal psikotes analogi FIKTIF : FAKTA",
            "231  …  453   564",
            "4   8   …   …   64   128",
            "3   7   15   …   …  127   255",
            "1   1   2   3   …   …   13    21   34",
            "…   2    5    6    7   10   9   14",
            "Terdapat 20 ikan lele di empang, setengahnya ikan lele tenggelam. Jadi berapa banyak ikan lele tersisa?",
            "Lima orang makan buah apel, A selesai sebelum B, tapi duluan C. D selesai sebelum E, tetapi duluan B. Mari urutkan, dari yang habis duluan sampai terakhir!",
            "Ada lima angsa di kandang, dikali dua. Berapa jumlah angsanya??",
            "Ada enam burung dihutan, ditembak pemburu tiga. Berapakah jumlah bururng yang lari?",
            "Sebuah keluarga besar terdiri dari suami, istri, 7 anak laki laki dan masing masing anak laki-laki mempunyai satu  saudara perempuan. Berapakah jumlah orang yang ada pada keluarga tersebut?",
            "Bentuk yang dapat dibentuk gambar berikut....",
            "Bangun ruang yang dapat dibentuk pada gambar berikut adalah ",
            "Manakah gambar berikutnya?",
            "Gambar selanjutnya adalah....",
            "Gambar selanjutnya adalah....",
    };

    private String pilihanTulis[][] = {
            {"Penggugah rasa", "Penilaian", "Perubahan", "Ijin Menetap"},
            {"Perkiraan", "Standar", "Umum", "Normal"},
            {"Kekerasan", "Pendukung", "Manifestasi", "Bimbingan"},
            {"Individual", "Konsensus", "Keserasian", "Internal"},
            {"Dagelan : Sandiwara", "Dugaan : Rekaan", "Data : Estimasi", "Dongeng : Peristiwa"},
            {"321", "342", "421", "241", "325"},
            {"28 24", "16 32", "26 14", "13 29", "22 14"},
            {"31 63", "34 42", "25 16", "25 25", "38 14"},
            {"4 5", "5 19", "5 8", "2 10", "4 12"},
            {"6", "5", "3", "2", "1"},
            {"5", "7", "10", "20", "11"},
            {"abcde", "cadeb", "cabde", "debac", "edcba"},
            {"10", "7", "5", "salah semua", "benar semua"},
            {"3", "5", "6", "salah semua", "4"},
            {"9", "10", "14", "16", "7"}
    };

    private int pilihanGambar[][] = {
            {R.drawable.satu_a, R.drawable.satu_b, R.drawable.satu_c, R.drawable.satu_d, R.drawable.satu_e},
            {R.drawable.dua_a, R.drawable.dua_b, R.drawable.dua_c, R.drawable.dua_d, R.drawable.dua_e},
            {R.drawable.tiga_a, R.drawable.tiga_b, R.drawable.tiga_c, R.drawable.tiga_d, R.drawable.tiga_e},
            {R.drawable.empat_a, R.drawable.empat_b, R.drawable.empat_c, R.drawable.empat_d, R.drawable.empat_e},
            {R.drawable.lima_a, R.drawable.lima_b, R.drawable.lima_c, R.drawable.lima_d, R.drawable.lima_e}
    };
    private int pertanyaanGambar[] = {
            R.drawable.nomor_satu,
            R.drawable.nomor_dua,
            R.drawable.nomor_tiga,
            R.drawable.nomor_empat,
            R.drawable.nomor_lima
    };
    private String jawabanBenarTulis[] = {
            "Penggugah Rasa",
            "Standar",
            "Pendukung",
            "Internal",
            "Dongeng : Peristiwa",
            "342",
            "16 32",
            "31 63",
            "5 8",
            "3",
            "20",
            "cabde",
            "7",
            "salah semua",
            "10"
    };
    private int jawabanBenarGambar[] = {
            R.drawable.satu_e,
            R.drawable.dua_e,
            R.drawable.tiga_b,
            R.drawable.empat_e,
            R.drawable.lima_b
    };

    public String getPertanyaanTulis(int a) {
        return pertanyaanTulis[a];
    }

    public int getPertanyaanGambar(int a) {
        return pertanyaanGambar[a];
    }

    public int getPilihanGambar1(int a) {
        return pilihanGambar[a][0];
    }

    public int getPilihanGambar2(int a) {
        return pilihanGambar[a][1];
    }

    public int getPilihanGambar3(int a) {
        return pilihanGambar[a][2];
    }

    public int getPilihanGambar4(int a) {
        return pilihanGambar[a][3];
    }

    public int getPilihanGambar5(int a) {
        return pilihanGambar[a][4];
    }

    public String getPilihan1(int a) {
        return pilihanTulis[a][0];
    }

    public String getPilihan2(int a) {
        return pilihanTulis[a][1];
    }

    public String getPilihan3(int a) {
        return pilihanTulis[a][2];
    }

    public String getPilihan4(int a) {
        return pilihanTulis[a][3];
    }

    public String getPilihan5(int a) {
        return pilihanTulis[a][4];
    }

    public String pilihanBenar(int a) {
        return jawabanBenarTulis[a];
    }

    public int pilihanGambarBenar(int a) {
        return jawabanBenarGambar[a];
    }

    public static class Jawaban {
        int nomor;
        boolean benar;
        String jawabannya;

        public Jawaban(int nomor, boolean benar, String jawabannya) {
            this.nomor = nomor;
            this.benar = benar;
            this.jawabannya = jawabannya;
        }

        public String getJawabannya() {
            return jawabannya;
        }

        public void setJawabannya(String jawabannya) {
            this.jawabannya = jawabannya;
        }

        public int getNomor() {
            return nomor;
        }

        public void setNomor(int nomor) {
            this.nomor = nomor;
        }

        public boolean isBenar() {
            return benar;
        }

        public void setBenar(boolean benar) {
            this.benar = benar;
        }
    }
}
