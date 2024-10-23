package com.example.bt_save;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etNumber1, etNumber2;
    private Button btnCalculate;
    private TextView tvResult;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNumber1 = findViewById(R.id.etNumber1);
        etNumber2 = findViewById(R.id.etNumber2);
        btnCalculate = findViewById(R.id.btnCalculate);
        tvResult = findViewById(R.id.tvResult);

        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        int savedResult = sharedPreferences.getInt("saved_result", 0);
        tvResult.setText("Kết quả: " + savedResult);

        btnCalculate.setOnClickListener(v -> {
            int num1 = 0;
            int num2 = 0;


            num1 = Integer.parseInt(etNumber1.getText().toString());
            num2 = Integer.parseInt(etNumber2.getText().toString());

            int result = num1 + num2;

            tvResult.setText("Kết quả: " + result);

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("saved_result", result);
            editor.apply();
        });
    }
}
