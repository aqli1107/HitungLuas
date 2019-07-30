package space.ahammdan.kalkulatorluas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private Button mButtonPerse,mButtonSegi, mButtonResult;
    private TextView mResult;

    private int req_code = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonPerse = findViewById(R.id.btnluaspersegi);
        mButtonSegi = findViewById(R.id.btnluassegitiga);
        mButtonResult = findViewById(R.id.btn_result);
        mResult = findViewById(R.id.txt_result);

        mButtonPerse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveintent = new Intent(MainActivity.this,persegiActivity.class);
                startActivity(moveintent);
            }
        });

        mButtonSegi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveintent = new Intent(MainActivity.this,segitigaActivity.class);
                startActivity(moveintent);
            }
        });
        mButtonResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent(MainActivity.this, persegiActivity.class);
                startActivityForResult(data,req_code);
            }
        });
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == req_code) {
            if (resultCode == RESULT_OK){
                mResult.setText(text(data));
            }
        }
    }

    String text(Intent a) {
        return Objects.requireNonNull(a.getData()).toString().trim();
    }
}
