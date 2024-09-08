package com.example.tugaz2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etFirstNumber, etSecondNumber;
    RadioGroup radioGroup;
    Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etFirstNumber = findViewById(R.id.etFirstNumber);
        etSecondNumber = findViewById(R.id.etSecondNumber);
        radioGroup = findViewById(R.id.radioGroup);
        btnCalculate = findViewById(R.id.btnCalculate);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num1 = Double.parseDouble(etFirstNumber.getText().toString());
                double num2 = Double.parseDouble(etSecondNumber.getText().toString());
                double result = 0;

                int selectedOperation = radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton = findViewById(selectedOperation);

// Menggunakan if-else untuk operasi yang dipilih
                if (radioButton != null) {
                    if (selectedOperation == R.id.rbAdd) {
                        result = num1 + num2;
                    } else if (selectedOperation == R.id.rbSubtract) {
                        result = num1 - num2;
                    } else if (selectedOperation == R.id.rbMultiply) {
                        result = num1 * num2;
                    } else if (selectedOperation == R.id.rbDivide) {
                        if (num2 != 0) {
                            result = num1 / num2;
                        } else {
                            result = 0; // Menghindari pembagian oleh nol
                            Toast.makeText(MainActivity.this, "Tidak bisa membagi dengan nol", Toast.LENGTH_SHORT).show();
                        }
                    }
                } else {
                    // Jika tidak ada RadioButton yang dipilih
                    Toast.makeText(MainActivity.this, "Pilih operasi matematika!", Toast.LENGTH_SHORT).show();
                }


                // Kirim hasil ke halaman kedua
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("result", result);
                intent.putExtra("nim", "225150407111023");
                intent.putExtra("name", "Kartika Putri Dewa Yani");
                startActivity(intent);
            }
        });
    }
}