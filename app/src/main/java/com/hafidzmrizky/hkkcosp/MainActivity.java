package com.hafidzmrizky.hkkcosp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class MainActivity extends AppCompatActivity {
    EditText id, quantity;
    Button hitungDanSewa;
    TextView price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hitungDanSewa = findViewById(R.id.hitungDanSewa);
        id = findViewById(R.id.id);
        quantity = findViewById(R.id.quantity);
        price = findViewById(R.id.price);

        hitungDanSewa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (id.getText().toString().isEmpty()) {
                    id.setError("ID harus diisi");
                    return;
                }
                if (quantity.getText().toString().isEmpty()) {
                    quantity.setError("Quantity harus diisi");
                    return;
                }
                hitung(id, quantity, price);
            }
        });
    }

    private void hitung(EditText id, EditText quantity, TextView price) {
        int idQ = Integer.parseInt(id.getText().toString());
        int quantityQ = Integer.parseInt(quantity.getText().toString());
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator('.');
        symbols.setDecimalSeparator(',');
        DecimalFormat decimalFormat = new DecimalFormat("#,###.###", symbols);
        switch (idQ) {
            case 1:
                int total1 = quantityQ * 100000;
                price.setText("Rp. " + decimalFormat.format(total1));
                Toast.makeText(this, "Berhasil menyewa Xiao", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                int total2 = quantityQ * 125000;
                price.setText("Rp. " + decimalFormat.format(total2));
                Toast.makeText(this, "Berhasil menyewa Wanderer", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                int total3 = quantityQ * 95000;
                price.setText("Rp. " + decimalFormat.format(total3));
                Toast.makeText(this, "Berhasil menyewa Kazuha", Toast.LENGTH_SHORT).show();
                break;
            case 4:
                int total4 = quantityQ * 185000;
                price.setText("Rp. " + decimalFormat.format(total4));
                Toast.makeText(this, "Berhasil menyewa Furina/Focalors", Toast.LENGTH_SHORT).show();
                break;
            default:
                if (Integer.parseInt(id.getText().toString()) != 1 || Integer.parseInt(id.getText().toString()) != 2 || Integer.parseInt(id.getText().toString()) != 3 || Integer.parseInt(id.getText().toString()) != 4) {
                    price.setText("");
                    id.setError("Baju Tidak Ada");
                    Toast.makeText(this, "Gagal Mendapatkan Baju Cosplay", Toast.LENGTH_SHORT).show();
                    return;
                }
                // toaster
                break;
        }
    }


}