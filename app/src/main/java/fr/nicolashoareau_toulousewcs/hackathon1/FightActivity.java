package fr.nicolashoareau_toulousewcs.hackathon1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by wilder on 05/04/18.
 */

public class FightActivity  extends AppCompatActivity {

    Button boutonAtt;
    Button boutonAttSpé;
    ImageView imageperso1;
    ImageView imageperso2;
    ImageView icon1;
    ImageView icon2;
    TextView name1;
    TextView name2;
    ProgressBar life1;
    ProgressBar life2;
    int damage = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fight);
        boutonAtt = findViewById(R.id.button_Att);
        boutonAttSpé = findViewById(R.id.button_attSpe);
        imageperso1 = findViewById(R.id.imageView_perso1);
        imageperso2 = findViewById(R.id.imageView_perso2);
        icon1 = findViewById(R.id.imageView_icon1);
        icon2 = findViewById(R.id.imageView_icon2);
        name1 = findViewById(R.id.textView_name1);
        name2 = findViewById(R.id.textView_name2);
        life1 = findViewById(R.id.progressBar_1);
        life2 = findViewById(R.id.progressBar2);
        final TextView textTest2 = findViewById(R.id.textView_test2);
        final TextView textTest1 = findViewById(R.id.textView_test1);

        // préparation combat :

        Intent intent = getIntent();
        final HeroModel hero1 = getIntent().getExtras().getParcelable("intenthero1");
        final HeroModel hero2 = getIntent().getExtras().getParcelable("intenthero2");
        name1.setText(hero1.getName());
        name2.setText(hero2.getName());
        life1.setMax(hero1.getDurability());
        life1.setProgress(hero1.getDurability());
        life2.setMax(hero2.getDurability());
        life2.setProgress(hero2.getDurability());

        textTest1.setText(hero1.getIntelligence() + " , " + hero1.getStrength() + " , " + hero1.getPower() + " , " + hero1.getCombat() + " , " + hero1.getDurability());
        textTest2.setText(hero2.getIntelligence() + " , " + hero2.getStrength() + " , " + hero2.getPower() + " , " + hero2.getCombat() + " , " + hero2.getDurability());

        // combat :


        //attaque physique
        boutonAtt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               damage = hero1.getStrength() - hero2.getCombat();
                if(damage < 0) {
                    damage = 0;
                }
                hero2.setDurability(hero2.getDurability() - damage);
                life2.setProgress(hero2.getDurability());

                // contre attaque
                Random random = new Random();
                int r = random.nextInt(2);
                if (r == 0) {
                    damage = hero2.getStrength() - hero1.getCombat();
                    if(damage < 0) {
                        damage = 0;
                    }
                    hero1.setDurability(hero1.getDurability() - damage);
                    life1.setProgress(hero1.getDurability());
                }
                else {

                        damage = hero2.getIntelligence() - hero1.getPower();
                    if(damage < 0) {
                        damage = 0;
                    }
                        hero1.setDurability(hero1.getDurability() - damage);
                        life1.setProgress(hero1.getDurability());

                }
                textTest1.setText(hero1.getIntelligence() + " , " + hero1.getStrength() + " , " + hero1.getPower() + " , " + hero1.getCombat() + " , " + hero1.getDurability());
                textTest2.setText(hero2.getIntelligence() + " , " + hero2.getStrength() + " , " + hero2.getPower() + " , " + hero2.getCombat() + " , " + hero2.getDurability());
            }
        });

        // attaque spécial
        boutonAttSpé.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                damage = hero1.getIntelligence() - hero2.getPower();
                if(damage < 0) {
                    damage = 0;
                }
                hero2.setDurability(hero2.getDurability() - damage);
                life2.setProgress(hero2.getDurability());

                //contre attaque spécial

                Random random = new Random();
                int r = random.nextInt(2);
                if (r == 0) {

                    damage = hero2.getStrength() - hero1.getCombat();
                    if(damage < 0) {
                        damage = 0;
                    }
                    hero1.setDurability(hero1.getDurability() - damage);
                    life1.setProgress(hero1.getDurability());
                }
                else {

                        damage = hero2.getIntelligence() - hero1.getPower();
                    if(damage < 0) {
                        damage = 0;
                    }
                        hero1.setDurability(hero1.getDurability() - damage);
                        life1.setProgress(hero1.getDurability());

                }

                textTest1.setText(hero1.getIntelligence() + " , " + hero1.getStrength() + " , " + hero1.getPower() + " , " + hero1.getCombat() + " , " + hero1.getDurability());
                textTest2.setText(hero2.getIntelligence() + " , " + hero2.getStrength() + " , " + hero2.getPower() + " , " + hero2.getCombat() + " , " + hero2.getDurability());

            }
        });




    }
}
