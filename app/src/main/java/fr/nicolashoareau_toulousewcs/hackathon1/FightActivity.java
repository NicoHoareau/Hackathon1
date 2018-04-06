package fr.nicolashoareau_toulousewcs.hackathon1;

import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

import pl.droidsonroids.gif.GifImageView;

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
    TextView résultat;
    Button boutonRevive;
    Button boutonSelection;
    TextView textFinGame;
    ImageView imgFinGame;

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
        résultat = findViewById(R.id.textView_result);
        boutonRevive = findViewById(R.id.butto_rematch);
        boutonSelection = findViewById(R.id.button_selection);
        textFinGame = findViewById(R.id.textView_fingame);
        imgFinGame = findViewById(R.id.imageView_fingame);

        final TextView textTest2 = findViewById(R.id.textView_test2);
        final TextView textTest1 = findViewById(R.id.textView_test1);

        // préparation combat :

        Intent intent = getIntent();
        final HeroModel hero1 = getIntent().getExtras().getParcelable("intenthero1");
        final int realLife1 = hero1.getDurability();
        final HeroModel hero2 = getIntent().getExtras().getParcelable("intenthero2");
        final int realLife2 = hero2.getDurability();
        imageperso1.setImageResource(hero1.getImage1());
        imageperso2.setImageResource(hero2.getImage1());
        icon1.setImageResource(hero1.getIcon());
        icon2.setImageResource(hero2.getIcon());
        name1.setText(hero1.getName());
        name2.setText(hero2.getName());
        life1.setMax(hero1.getDurability());
        life1.setProgress(hero1.getDurability());
        life1.setSecondaryProgress(hero1.getDurability());
        life2.setMax(hero2.getDurability());
        life2.setProgress(hero2.getDurability());
        life2.setSecondaryProgress(hero2.getDurability());

        final int[] photos={R.drawable.gifview1firehouse, R.drawable.gifview2rainkioske,R.drawable.gifview3cascadegif, R.drawable.dark_temple};

        final GifImageView gifImageView = findViewById(R.id.gif_iv);

        final Random ran =new Random();
        final int i = ran.nextInt(photos.length);
        gifImageView.setImageResource(photos[i]);
        gifImageView.setOnClickListener(new View.OnClickListener()
                                 {
                                     public void onClick(View v)
                                     {
                                         int k = ran.nextInt(photos.length);
                                         gifImageView.setImageResource(photos[k]);
                                     }
                                 }
        );
        //No clickable gif :
        gifImageView.setEnabled(false);

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

                // KO
                if (hero2.IsKO()) {
                    endgame();
                    textFinGame.setText(hero1.getName() + " Vainqueur !");
                    imgFinGame.setImageResource(hero1.getImage1());
                }

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

                    // KO
                    if (hero1.IsKO()) {
                       endgame();
                        textFinGame.setText(hero2.getName() + " Vainqueur !");
                        imgFinGame.setImageResource(hero2.getImage1());
                    }
                }
                else {

                        damage = hero2.getIntelligence() - hero1.getPower();
                    if(damage < 0) {
                        damage = 0;
                    }
                        hero1.setDurability(hero1.getDurability() - damage);
                        life1.setProgress(hero1.getDurability());

                    // KO
                    if (hero1.IsKO()) {
                        endgame();
                        textFinGame.setText(hero2.getName() + " Vainqueur !");
                        imgFinGame.setImageResource(hero2.getImage1());
                    }

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

                // KO
                if (hero2.IsKO()) {
                    endgame();
                    textFinGame.setText(hero1.getName() + " Vainqueur !");
                    imgFinGame.setImageResource(hero1.getImage1());
                }

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

        // KO
                    if (hero1.IsKO()) {
                       endgame();
                        textFinGame.setText(hero2.getName() + " Vainqueur !");
                        imgFinGame.setImageResource(hero2.getImage1());
                    }
                }
                else {

                        damage = hero2.getIntelligence() - hero1.getPower();
                    if(damage < 0) {
                        damage = 0;
                    }
                        hero1.setDurability(hero1.getDurability() - damage);
                        life1.setProgress(hero1.getDurability());

  // KO
                    if (hero1.IsKO()) {
                        endgame();
                        textFinGame.setText(hero2.getName() + " Vainqueur !");
                        imgFinGame.setImageResource(hero2.getImage1());
                    }

                }

                textTest1.setText(hero1.getIntelligence() + " , " + hero1.getStrength() + " , " + hero1.getPower() + " , " + hero1.getCombat() + " , " + hero1.getDurability());
                textTest2.setText(hero2.getIntelligence() + " , " + hero2.getStrength() + " , " + hero2.getPower() + " , " + hero2.getCombat() + " , " + hero2.getDurability());

            }
        });


        // Fin de Match :

        boutonSelection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retourSelect();
            }
        });

        boutonRevive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hero1.setDurability(realLife1);
                life1.setProgress(realLife1);
                hero2.setDurability(realLife2);
                life2.setProgress(realLife2);
                rematch();
            }
        });

    }


    // Methode :

    public void endgame() {
        boutonAtt.setEnabled(false);
        boutonAttSpé.setEnabled(false);
        boutonRevive.setVisibility(View.VISIBLE);
        boutonSelection.setVisibility(View.VISIBLE);
        textFinGame.setVisibility(View.VISIBLE);
        imgFinGame.setVisibility(View.VISIBLE);
    }

    public void rematch() {
        boutonAtt.setEnabled(true);
        boutonAttSpé.setEnabled(true);
        boutonRevive.setVisibility(View.GONE);
        boutonSelection.setVisibility(View.GONE);
        textFinGame.setVisibility(View.GONE);
        imgFinGame.setVisibility(View.GONE);
    }

    public void retourSelect() {
        Intent intent = new Intent(FightActivity.this, SelectPersoActivity.class);
        startActivity(intent);

    }
}
