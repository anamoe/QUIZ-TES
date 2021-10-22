package com.example.quiz;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quiz.databinding.ActivityTampilPertanyaanBinding;
import com.example.quiz.model.Pertanyaan;

import java.util.ArrayList;
import java.util.List;

public class TampilPertanyaan extends AppCompatActivity {

    ActivityTampilPertanyaanBinding binding;
    Pertanyaan pertanyaan = new Pertanyaan();
    List<Pertanyaan.Jawaban> hasil;
    int iq = 0;
    int mPertanyaan2 = 0;
    int mPertanyaanGambar = 0;
    boolean back = false;
    private String jawaban, pilihan = "";
    private int mPertanyaan = 0;
    private int mScore = 0;
    private int jawabanGambar;
    private int pilihanGambar = 0;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTampilPertanyaanBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        hasil = new ArrayList<>();
        updateQuestion();

        binding.btnNext.setOnClickListener(v -> {
            if (pilihan.isEmpty() && jawabanGambar == 0) {
                Toast.makeText(TampilPertanyaan.this, "Pilih Jawaban", Toast.LENGTH_LONG).show();
                return;
            }

//           if (back){
//               if (mPertanyaan > 14) {
//                   if (jawabanGambar == pilihanGambar) {
//                       mScore = mScore + 1;
//                       hasil.set(mPertanyaan, new Pertanyaan.Jawaban(mPertanyaan, true, String.valueOf(jawabanGambar)));
//                   } else {
//                       hasil.set(mPertanyaan, new Pertanyaan.Jawaban(mPertanyaan, false, String.valueOf(jawabanGambar)));
//                   }
//               } else {
//                   if (pilihan.toLowerCase().equals(jawaban)) {
//                       mScore = mScore + 1;
//                       hasil.set(mPertanyaan, new Pertanyaan.Jawaban(mPertanyaan, true, pilihan));
//                   } else {
//                       hasil.set(mPertanyaan, new Pertanyaan.Jawaban(mPertanyaan, false, pilihan));
//                   }
//               }
//               Log.d("jawaban",hasil.toString());
//           }else {
//               if (mPertanyaan > 14) {
//                   if (jawabanGambar == pilihanGambar) {
//                       mScore = mScore + 1;
//                       hasil.add(mPertanyaan, new Pertanyaan.Jawaban(mPertanyaan, true, String.valueOf(jawabanGambar)));
//                   } else {
//                       hasil.add(mPertanyaan, new Pertanyaan.Jawaban(mPertanyaan, false, String.valueOf(jawabanGambar)));
//                   }
//               } else {
//                   if (pilihan.toLowerCase().equals(jawaban)) {
//                       mScore = mScore + 1;
//                       hasil.add(mPertanyaan, new Pertanyaan.Jawaban(mPertanyaan, true, pilihan));
//                   } else {
//                       hasil.add(mPertanyaan, new Pertanyaan.Jawaban(mPertanyaan, false, pilihan));
//                   }
//               }
//               Log.d("jawaban",hasil.toString());
//
//           }
            if (mPertanyaan > 14) {
                if (jawabanGambar == pilihanGambar) {
                    mScore = mScore + 1;
                    hasil.add(mPertanyaan, new Pertanyaan.Jawaban(mPertanyaan, true, String.valueOf(jawabanGambar)));
                } else {
                    hasil.add(mPertanyaan, new Pertanyaan.Jawaban(mPertanyaan, false, String.valueOf(jawabanGambar)));
                }
            } else {
                if (pilihan.toLowerCase().equals(jawaban)) {
                    mScore = mScore + 1;
                    hasil.add(mPertanyaan, new Pertanyaan.Jawaban(mPertanyaan, true, pilihan));
                } else {
                    hasil.add(mPertanyaan, new Pertanyaan.Jawaban(mPertanyaan, false, pilihan));
                }
            }


            if (mPertanyaan == 19) {
                binding.btnNext.setVisibility(View.GONE);
                binding.btnFinish.setVisibility(View.VISIBLE);
                binding.btnKembaliSoal.setVisibility(View.VISIBLE);
                mPertanyaan++;

                return;
            }
            mPertanyaan++;
            if (mPertanyaan > 15 && mPertanyaan <20) {

                mPertanyaan2++;
                mPertanyaanGambar++;

                Log.d("gambar plus", "" + mPertanyaan2);
            }
            back = false;
            updateQuestion();
            Log.d("jawaban",hasil.toString());
            Log.d("isinya",""+hasil.size());


        });
        binding.btnFinish.setOnClickListener(v -> {
            updateScore();
            for (int i = 0; i < hasil.size(); i++) {
                if (hasil.get(i).isBenar()) {
                    binding.hasilAkhir.append("Nomor " + (i + 1) + " Jawaban Anda Benar \n");

                } else {
                    binding.hasilAkhir.append("Nomor " + (i + 1) + " Jawaban Anda Salah \n");

                }
            }
        });
        binding.btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        binding.pilihanPertama.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                binding.pilihanKeempat.setChecked(false);
                binding.pilihanKedua.setChecked(false);
                binding.pilihanKetiga.setChecked(false);
                binding.pilihanKelima.setChecked(false);
                pilihan = binding.textPilihanPertama.getText().toString();

            }
        });
        binding.pilihanPertamaGambar.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                binding.pilihanKeempatGambar.setChecked(false);
                binding.pilihanKeduaGambar.setChecked(false);
                binding.pilihanKetigaGambar.setChecked(false);
                binding.pilihanKelimaGambar.setChecked(false);
                jawabanGambar = pertanyaan.getPilihanGambar1((mPertanyaan2));


            }
        });
        binding.pilihanKeduaGambar.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                binding.pilihanKeempatGambar.setChecked(false);
                binding.pilihanPertamaGambar.setChecked(false);
                binding.pilihanKetigaGambar.setChecked(false);
                binding.pilihanKelimaGambar.setChecked(false);
                jawabanGambar = pertanyaan.getPilihanGambar2((mPertanyaan2));


            }
        });
        binding.pilihanKetigaGambar.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                binding.pilihanKeempatGambar.setChecked(false);
                binding.pilihanKeduaGambar.setChecked(false);
                binding.pilihanPertamaGambar.setChecked(false);
                binding.pilihanKelimaGambar.setChecked(false);
                jawabanGambar = pertanyaan.getPilihanGambar3((mPertanyaan2));


            }
        });
        binding.pilihanKeempatGambar.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                binding.pilihanPertamaGambar.setChecked(false);
                binding.pilihanKeduaGambar.setChecked(false);
                binding.pilihanKetigaGambar.setChecked(false);
                binding.pilihanKelimaGambar.setChecked(false);
                jawabanGambar = pertanyaan.getPilihanGambar4((mPertanyaan2));

            }
        });
        binding.pilihanKelimaGambar.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                binding.pilihanKeempatGambar.setChecked(false);
                binding.pilihanKeduaGambar.setChecked(false);
                binding.pilihanKetigaGambar.setChecked(false);
                binding.pilihanPertamaGambar.setChecked(false);
                jawabanGambar = pertanyaan.getPilihanGambar5((mPertanyaan2));


            }
        });
        binding.pilihanKedua.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                binding.pilihanKeempat.setChecked(false);
                binding.pilihanPertama.setChecked(false);
                binding.pilihanKetiga.setChecked(false);
                binding.pilihanKelima.setChecked(false);
                pilihan = binding.textPilihanKedua.getText().toString();

            }
        });
        binding.pilihanKetiga.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                binding.pilihanKeempat.setChecked(false);
                binding.pilihanPertama.setChecked(false);
                binding.pilihanKedua.setChecked(false);
                binding.pilihanKelima.setChecked(false);
                pilihan = binding.textPilihanKetiga.getText().toString();

            }
        });
        binding.pilihanKeempat.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                binding.pilihanKedua.setChecked(false);
                binding.pilihanPertama.setChecked(false);
                binding.pilihanKetiga.setChecked(false);
                binding.pilihanKelima.setChecked(false);
                pilihan = binding.textPilihanKeempat.getText().toString();

            }
        });
        binding.pilihanKelima.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                binding.pilihanKeempat.setChecked(false);
                binding.pilihanPertama.setChecked(false);
                binding.pilihanKetiga.setChecked(false);
                binding.pilihanKedua.setChecked(false);
                pilihan = binding.textPilihanKelima.getText().toString();

            }
        });

        binding.btnKembaliSoal.setOnClickListener(v -> {
            back = true;
            if (mPertanyaan > 19) {
                binding.btnNext.setVisibility(View.VISIBLE);
                binding.btnFinish.setVisibility(View.GONE);
                binding.btnKembaliSoal.setVisibility(View.VISIBLE);
                mPertanyaan--;
                hasil.remove(mPertanyaan);
                return;
            }
            mPertanyaan--;

            if (mPertanyaanGambar > 0) {
                mPertanyaanGambar--;
                Log.d(" min", "" + mPertanyaanGambar);

            }
            if (mPertanyaan <= 19) {
                binding.btnNext.setVisibility(View.VISIBLE);
                binding.btnFinish.setVisibility(View.GONE);
            }
            if (mPertanyaan2 >= 1) {
                mPertanyaan2 = mPertanyaan2 - 1;
                Log.d(" min kjkg", "" + mPertanyaan2);
            }
            backQuestion();
        });
    }

    private void updateScore() {
        iq = mScore * 200 / 20;

        binding.soalGambar.setVisibility(View.GONE);
        binding.btnFinish.setVisibility(View.GONE);
        binding.babSoal.setVisibility(View.GONE);
        binding.soalnya.setVisibility(View.GONE);
        binding.radioGroup.setVisibility(View.GONE);
        binding.radioGroupGambar.setVisibility(View.GONE);
        binding.judulSoal.setVisibility(View.GONE);
        binding.layoutSkor.setVisibility(View.VISIBLE);
        binding.layoutNama.setVisibility(View.VISIBLE);
        binding.btnKembali.setVisibility(View.VISIBLE);
        binding.scoreAkhir.setText(String.valueOf(mScore * 5));
        binding.btnKembaliSoal.setVisibility(View.GONE);
        binding.judulHasil.setVisibility(View.VISIBLE);
        if (iq <= 50) {
            binding.kualifiasi.setText("IQ dengan Kualifikasi Idiot");
        } else if (iq >= 60 && iq <= 80) {
            binding.kualifiasi.setText("IQ dengan Kualifikasi Bodoh");


        } else if (iq >= 90 && iq <= 120) {
            binding.kualifiasi.setText("IQ dengan Kualifikasi Normal");


        } else if (iq >= 130 && iq <= 160) {
            binding.kualifiasi.setText("IQ dengan Kualifikasi Cerdas");
        } else if (iq >= 160) {
            binding.kualifiasi.setText("IQ dengan Kualifikasi Jenius");

        }
        binding.namaOrang.setText(SessionManager.getKey_nama(TampilPertanyaan.this));
        binding.umurOrang.setText(String.valueOf(SessionManager.getUmur(TampilPertanyaan.this)));
        binding.iqOrang.setText(String.valueOf(iq));
    }

    private void updateQuestion() {
        if (mPertanyaan > 0) {
            binding.btnKembaliSoal.setVisibility(View.VISIBLE);
        }
        if (mPertanyaan < 2) {
            binding.babSoal.setText("Soal Psikotes Sinonim");
        } else if (mPertanyaan < 4) {
            binding.babSoal.setText("Soal Psikotes Antonim");

        } else if (mPertanyaan == 4) {
            binding.babSoal.setText("Soal Psikotes Analogi");

        } else if (mPertanyaan < 10) {
            binding.babSoal.setText("Soal Test Angka");

        } else if (mPertanyaan < 15) {
            binding.babSoal.setText("Soal Test Logika");

        } else {
            binding.babSoal.setText("Soal Test Gambar");

        }
        pilihan = "";
        jawabanGambar = 0;
        binding.judulSoal.setText("Soal Nomor " + (mPertanyaan + 1));
        binding.pilihanKeempat.setChecked(false);
        binding.pilihanPertama.setChecked(false);
        binding.pilihanKetiga.setChecked(false);
        binding.pilihanKedua.setChecked(false);
        binding.pilihanKelima.setChecked(false);
        binding.pilihanPertamaGambar.setChecked(false);
        binding.pilihanKeduaGambar.setChecked(false);
        binding.pilihanKetigaGambar.setChecked(false);
        binding.pilihanKeempatGambar.setChecked(false);
        binding.pilihanKelimaGambar.setChecked(false);
        if (mPertanyaan >= 5 && mPertanyaan <= 14) {
            binding.layoutKelima.setVisibility(View.VISIBLE);
            binding.textPilihanKelima.setText(pertanyaan.getPilihan5(mPertanyaan));
        }
        if (mPertanyaan > 14) {

            binding.radioGroupGambar.setVisibility(View.VISIBLE);
            binding.radioGroup.setVisibility(View.GONE);
            binding.soalGambar.setVisibility(View.VISIBLE);
            binding.soalnya.setText(pertanyaan.getPertanyaanTulis(mPertanyaan));
            binding.soalGambar.setImageResource(pertanyaan.getPertanyaanGambar(mPertanyaan2));
            binding.gambarPilihanPertama.setImageResource(pertanyaan.getPilihanGambar1(mPertanyaan2));
            binding.gambarPilihanKedua.setImageResource(pertanyaan.getPilihanGambar2(mPertanyaan2));
            binding.gambarPilihanKetiga.setImageResource(pertanyaan.getPilihanGambar3(mPertanyaan2));
            binding.gambarPilihanKeempat.setImageResource(pertanyaan.getPilihanGambar4(mPertanyaan2));
            binding.gambarPilihanKelima.setImageResource(pertanyaan.getPilihanGambar5(mPertanyaan2));
            pilihanGambar = pertanyaan.pilihanGambarBenar(mPertanyaan2);
            Log.d("Pilihan Gambar", "" + pilihanGambar);
            Log.d("gambar tampil", "" + mPertanyaan2);


        } else {
            binding.soalnya.setText(pertanyaan.getPertanyaanTulis(mPertanyaan));
            binding.textPilihanPertama.setText(pertanyaan.getPilihan1(mPertanyaan));
            binding.textPilihanKedua.setText(pertanyaan.getPilihan2(mPertanyaan));
            binding.textPilihanKetiga.setText(pertanyaan.getPilihan3(mPertanyaan));
            binding.textPilihanKeempat.setText(pertanyaan.getPilihan4(mPertanyaan));
            jawaban = pertanyaan.pilihanBenar(mPertanyaan).toLowerCase();
        }


    }

    private void backQuestion() {


        if (mPertanyaan > 0) {
            binding.btnKembaliSoal.setVisibility(View.VISIBLE);
        } else {
            binding.btnKembaliSoal.setVisibility(View.GONE);

        }
        if (mPertanyaan < 2) {
            binding.babSoal.setText("Soal Psikotes Sinonim");
        } else if (mPertanyaan < 4) {
            binding.babSoal.setText("Soal Psikotes Antonim");

        } else if (mPertanyaan == 4) {
            binding.babSoal.setText("Soal Psikotes Analogi");

        } else if (mPertanyaan < 10) {
            binding.babSoal.setText("Soal Test Angka");

        } else if (mPertanyaan < 15) {
            binding.babSoal.setText("Soal Test Logika");

        } else {
            binding.babSoal.setText("Soal Test Gambar");

        }

        binding.judulSoal.setText("Soal Nomor " + (mPertanyaan + 1));

        if (mPertanyaan >= 5 && mPertanyaan <= 14) {
            binding.layoutKelima.setVisibility(View.VISIBLE);
            binding.textPilihanKelima.setText(pertanyaan.getPilihan5(mPertanyaan));
        }

        if (mPertanyaan > 14) {

            binding.radioGroupGambar.setVisibility(View.VISIBLE);
            binding.radioGroup.setVisibility(View.GONE);
            binding.soalGambar.setVisibility(View.VISIBLE);
            binding.soalnya.setText(pertanyaan.getPertanyaanTulis(mPertanyaan));
            binding.soalGambar.setImageResource(pertanyaan.getPertanyaanGambar(mPertanyaan2));
            binding.gambarPilihanPertama.setImageResource(pertanyaan.getPilihanGambar1(mPertanyaan2));
            binding.gambarPilihanKedua.setImageResource(pertanyaan.getPilihanGambar2(mPertanyaan2));
            binding.gambarPilihanKetiga.setImageResource(pertanyaan.getPilihanGambar3(mPertanyaan2));
            binding.gambarPilihanKeempat.setImageResource(pertanyaan.getPilihanGambar4(mPertanyaan2));
            binding.gambarPilihanKelima.setImageResource(pertanyaan.getPilihanGambar5(mPertanyaan2));
            pilihanGambar = pertanyaan.pilihanGambarBenar(mPertanyaan2);
            if (hasil.get(mPertanyaan).getJawabannya().equals(String.valueOf(pertanyaan.getPilihanGambar1(mPertanyaan2)))) {
                binding.pilihanPertamaGambar.setChecked(true);


            } else if (hasil.get(mPertanyaan).getJawabannya().equals(String.valueOf(pertanyaan.getPilihanGambar2(mPertanyaan2)))) {
                binding.pilihanKeduaGambar.setChecked(true);


            } else if (hasil.get(mPertanyaan).getJawabannya().equals(String.valueOf(pertanyaan.getPilihanGambar3(mPertanyaan2)))) {
                binding.pilihanKetigaGambar.setChecked(true);


            } else if (hasil.get(mPertanyaan).getJawabannya().equals(String.valueOf(pertanyaan.getPilihanGambar4(mPertanyaan2)))) {
                binding.pilihanKeempatGambar.setChecked(true);


            } else if (hasil.get(mPertanyaan).getJawabannya().equals(String.valueOf(pertanyaan.getPilihanGambar5(mPertanyaan2)))) {
                binding.pilihanKelimaGambar.setChecked(true);


            }

        } else {
            binding.radioGroupGambar.setVisibility(View.GONE);
            binding.radioGroup.setVisibility(View.VISIBLE);
            binding.soalGambar.setVisibility(View.GONE);
            binding.soalnya.setText(pertanyaan.getPertanyaanTulis(mPertanyaan));
            binding.textPilihanPertama.setText(pertanyaan.getPilihan1(mPertanyaan));
            binding.textPilihanKedua.setText(pertanyaan.getPilihan2(mPertanyaan));
            binding.textPilihanKetiga.setText(pertanyaan.getPilihan3(mPertanyaan));
            binding.textPilihanKeempat.setText(pertanyaan.getPilihan4(mPertanyaan));
            if (hasil.get(mPertanyaan).getJawabannya().equals(pertanyaan.getPilihan1(mPertanyaan))) {
                binding.pilihanPertama.setChecked(true);

            } else if (hasil.get(mPertanyaan).getJawabannya().equals(pertanyaan.getPilihan2(mPertanyaan))) {
                binding.pilihanKedua.setChecked(true);

            } else if (hasil.get(mPertanyaan).getJawabannya().equals(pertanyaan.getPilihan3(mPertanyaan))) {
                binding.pilihanKetiga.setChecked(true);

            } else if (hasil.get(mPertanyaan).getJawabannya().equals(pertanyaan.getPilihan4(mPertanyaan))) {
                binding.pilihanKeempat.setChecked(true);

            } else if (hasil.get(mPertanyaan).getJawabannya().equals(pertanyaan.getPilihan5(mPertanyaan))) {
                binding.pilihanKelima.setChecked(true);

            }

            jawaban = pertanyaan.pilihanBenar(mPertanyaan).toLowerCase();

        }
        hasil.remove(mPertanyaan);


    }
}