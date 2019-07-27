package space.ahammdan.kalkulatorluas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class persegiActivity extends AppCompatActivity {

    private EditText mInputA,mInputZ;
    private TextView mHasil;
    private Button mHitung;

    boolean isEmpty = false;
    boolean isInvalidDouble = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persegi);
        mHitung = findViewById(R.id.btn_hitung);
        mHasil = findViewById(R.id.hasil);
        mInputA = findViewById(R.id.input_awal);
        mInputZ = findViewById(R.id.input_akhir);

        if (savedInstanceState != null) {
            String hasil = savedInstanceState.getString(STATE_RESULT);
            mHasil.setText(hasil);
        }


        mHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String sisia = text(mInputA);
                    String sisiz = text(mInputZ);



                    if(sisia.isEmpty()){
                        isEmpty = true;
                        mInputA.setError("Tidak Boleh Kosong");
                    }
                    if(sisiz.isEmpty()){
                        isEmpty = true;
                        mInputZ.setError("Tidak Boleh Kosong");
                    }

                    Double dSisia = parseDouble(text(mInputA));
                    Double dSisiz = parseDouble(text(mInputZ));

                    if(dSisia == null){
                        isInvalidDouble = true;
                        mInputA.setError("Invalid Format");
                    }
                    if(dSisiz == null){
                        isInvalidDouble = true;
                        mInputZ.setError("Invalid Format");
                    }

                    if(!isEmpty && !isInvalidDouble) {
                        double hasil = dSisia * dSisiz;
                        mHasil.setText(String.valueOf(hasil));
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
