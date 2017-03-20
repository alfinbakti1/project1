package com.example.alfin_bakti.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btncek, btnexit, btnclear;
    TextView textView, textView2, textView3, textView4;
    EditText editnama, edittinggi, editberat, hasilideal1, hasilket1, hasilket2;
    RadioButton radiobuttonlaki, radiobuttonperempuan;
    RadioGroup radioGroup;
    int h1, bt, ti;
    String temp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btncek = (Button) findViewById(R.id.btncek);
        btnexit = (Button) findViewById(R.id.btnexit);
        editnama = (EditText) findViewById(R.id.editnama);
        edittinggi = (EditText) findViewById(R.id.edittinggi);
        editberat = (EditText) findViewById(R.id.editberat);
        hasilideal1 = (EditText) findViewById(R.id.hasilideal1);
        hasilket1 = (EditText) findViewById(R.id.hasilket1);
        hasilket2 = (EditText) findViewById(R.id.hasilket2);
        radiobuttonlaki = (RadioButton) findViewById(R.id.radiobuttonlaki);
        radiobuttonperempuan = (RadioButton) findViewById(R.id.radiobuttonperempuan);
        btnclear = (Button) findViewById(R.id.btnclear);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        btncek.setOnClickListener(new View.OnClickListener() {
            @Overpublic
            void onClick(View v) {
                proses();
            }

            private void proses() {
                int ti = Integer.parseInt(String.valueOf(edittinggi.getText()));
                int bt = Integer.parseInt(String.valueOf(editberat.getText()));


                if (radiobuttonlaki.isSelected()) {
                    h1 = (ti - 100);
                } else if (radiobuttonperempuan.isSelected()) {
                    h1 = (ti - 104);
                }

                temp = Integer.toString(h1);

                if (h1 < bt) {
                    hasilideal1.setText("berat badan ideal anda " + temp);
                    hasilket1.setText("maaf " + editnama.getText() + "sepertina anda overweight");
                    hasilket2.setText("banyaklah berolahraga dan hindari makan berkolersterol");
                } else if (h1 > bt) {
                    hasilideal1.setText("berat badan ideal anda " + temp);
                    hasilket1.setText("maaf " + editnama.getText() + "sepertina anda underweight");
                    hasilket2.setText("banyaklah mengkonsumsi makan berekarbohidrat");
                } else {
                    hasilideal1.setText("berat badan ideal anda " + temp);
                    hasilket1.setText("maaf " + editnama.getText() + " berat badan anda sudah ideal");
                    hasilket2.setText("lanjutkan pola makan teratur dan gaya hidup sehat");
                }
            }
        });
        btnexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);

            }
        });

        btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editnama.setText("");
                edittinggi.setText("");
                editberat.setText("");
                hasilideal1.setText("");
                hasilket1.setText("");
                hasilket2.setText("");
                radioGroup.clearCheck();
            }
        });


    }
}