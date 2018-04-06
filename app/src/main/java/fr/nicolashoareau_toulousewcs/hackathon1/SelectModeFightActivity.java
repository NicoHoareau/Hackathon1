package fr.nicolashoareau_toulousewcs.hackathon1;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class SelectModeFightActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_mode_fight);


        ImageView boutonP1vsP2 = findViewById(R.id.button_p1vsp2);
        ImageView boutonP1vsCPU = findViewById(R.id.button_p1vscpu);

        boutonP1vsP2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectModeFightActivity.this, SelectPersoActivity.class);
                int val = 1;
                intent.putExtra("val", val);
                startActivity(intent);

            }
        });

        boutonP1vsCPU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectModeFightActivity.this, SelectPersoActivity.class);
                int val = 0;
                intent.putExtra("val", val);
                startActivity(intent);


            }
        });


    }
}
