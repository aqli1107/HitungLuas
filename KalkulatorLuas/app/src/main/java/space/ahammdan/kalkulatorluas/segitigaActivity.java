package space.ahammdan.kalkulatorluas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class segitigaActivity extends AppCompatActivity {

    private EditText mInputA, mInputT;
    private TextView mHasil;
    private Button mHitung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segitiga);

        mInputA = findViewById(R.id.input_alas);
        mInputT = findViewById(R.id.input_tinggi);
        mHasil = findViewById(R.id.hasil);
        mHitung = findViewById(R.id.btn_hitung);

        if (savedInstanceState != null) {
            String hasil = savedInstanceState.getString(STATE_RESULT);
            mHasil.setText(hasil);
        }

        mHasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.btn_hitung) {
                    String alas = text(mInputA);
                    String tinggi = text(mInputT);

                    boolean isEmpty = false;
                    boolean isInvalidDouble = false;

                    if(alas.isEmpty()){
                        isEmpty = true;
                        mInputA.setError("Tidak Boleh Kosong");
                    }
                    if(tinggi.isEmpty()){
                        isEmpty = true;
                        mInputT.setError("Tidak Boleh Kosong");
                    }

                    Double dAlas = parseDouble(text(mInputA));
                    Double dTinggi = parseDouble(text(mInputT));

                    if(dAlas == null){
                        isInvalidDouble = true;
                        mInputA.setError("Invalid Format");
                    }
                    if(dTinggi == null){
                        isInvalidDouble = true;
                        mInputT.setError("Invalid Format");
                    }

                    if(!isEmpty && !isInvalidDouble){
                        double hasil = dAlas * dTinggi;
                        mHasil.setText(String.valueOf(hasil));
                    }
                }
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(
                STATE_RESULT, mHasil.getText().toString()
        );
    }

    private static final String STATE_RESULT = "state_result";

    String text(EditText a){
        return a.getText().toString().trim();
    }

    Double parseDouble(String a) {
        try {
            return Double.valueOf(a);
        } catch (NumberFormatException err){
            return null;
        }
    }
}
