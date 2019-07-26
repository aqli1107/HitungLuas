package space.ahammdan.kalkulatorluas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mButtonPerse,mButtonSegi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonPerse = findViewById(R.id.btnluaspersegi);
        mButtonSegi = findViewById(R.id.btnluassegitiga);

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
    }
}
