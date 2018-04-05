package fr.nicolashoareau_toulousewcs.hackathon1;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by wilder on 05/04/18.
 */

public class SelectPersoActivity extends AppCompatActivity {

    ImageView imgPlayer1;
    ImageView imgPlayer2;
    Button boutonSelect;
    Button boutonFight;
    int status = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selection_perso);

        imgPlayer1 = findViewById(R.id.iv_player1);
        imgPlayer2 = findViewById(R.id.iv_player2);
        boutonSelect = findViewById(R.id.button_selection);
        boutonFight = findViewById(R.id.button_fight);

        final GridView gridview = (GridView) findViewById(R.id.grid_select_perso);
        ArrayList<HeroModel> results = new ArrayList<>();

        //TODO : faire les résultats

        results.add(new HeroModel(149, "Captain America", 69, 19, 38, 55, 60, 100,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background, R.drawable.spider2));
        results.add(new HeroModel(176, "Chuck Norris", 50, 80, 47, 56, 42, 99 ,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background, R.drawable.spiderman));
        results.add(new HeroModel(208, "Dark Vador", 69, 48, 33, 35, 100, 100,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background, R.drawable.ic_launcher_background));
        results.add(new HeroModel(213, "Dead Pool",69, 32, 50, 100, 100, 100, R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background, R.drawable.ic_launcher_background));
        results.add(new HeroModel(263, "Flash", 63, 10, 100, 50, 68, 32,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background, R.drawable.ic_launcher_background));
        results.add(new HeroModel(289, "Goku", 56, 100, 75, 90, 100, 100,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background, R.drawable.ic_launcher_background));
        results.add(new HeroModel(310, "Harry Potter", 75, 7, 21, 10, 100, 50, R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background, R.drawable.ic_launcher_background));
        results.add(new HeroModel(332, "Hulk", 88, 100, 63, 100, 98, 85, R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background, R.drawable.ic_launcher_background));
        results.add(new HeroModel(346, "Iron Man", 100, 85, 58, 85, 100, 64, R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background, R.drawable.ic_launcher_background));
        results.add(new HeroModel(352, "James Bond", 88, 13, 17, 35, 25, 90, R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background, R.drawable.ic_launcher_background));
        results.add(new HeroModel(370, "Joker", 100, 10, 12, 60, 43, 70, R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background, R.drawable.ic_launcher_background));
        results.add(new HeroModel(373, "Judge Dredd", 75, 18, 38, 50, 52, 95, R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background, R.drawable.ic_launcher_background));
        results.add(new HeroModel(404, "Leonardo", 75, 16, 50, 65, 59, 80, R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background, R.drawable.ic_launcher_background));
        results.add(new HeroModel(502, "Saïtama", 38, 100, 83, 95, 55, 50, R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background, R.drawable.ic_launcher_background));
        results.add(new HeroModel(540, "Rambo", 63, 14, 25, 30, 30, 100, R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background, R.drawable.ic_launcher_background));
        results.add(new HeroModel(574, "Sauron", 88, 85, 33, 100, 100, 70, R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background, R.drawable.ic_launcher_background));
        results.add(new HeroModel(644, "SuperMan", 94, 100, 100, 100, 100, 85, R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background, R.drawable.ic_launcher_background));
        results.add(new HeroModel(650, "T800", 75, 34, 17, 60, 73, 65 ,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background, R.drawable.ic_launcher_background));
        results.add(new HeroModel(720, "Wonder Woman", 88, 100, 79, 100, 100, 100, R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background, R.drawable.ic_launcher_background));


        SelectPersoAdapter adapter = new SelectPersoAdapter(this, results);
        gridview.setAdapter(adapter);
        final Intent intent = new Intent(SelectPersoActivity.this, FightActivity.class);



        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {


                if (status == 0) {
                    HeroModel item = (HeroModel) gridview.getItemAtPosition(position);
                    imgPlayer1.setImageResource(item.getIcon());
                    status++;
                    Parcelable hero1 = new HeroModel(item.getId(),item.getName(), item.getIntelligence(), item.getStrength(), item.getSpeed(), item.getDurability(), item.getPower(), item.getCombat(), item.getImage1(), item.getImage2(), item.getImage3(), item.getIcon());
                    intent.putExtra("intenthero1", hero1);

                } else if (status == 1) {
                    HeroModel item = (HeroModel) gridview.getItemAtPosition(position);
                    imgPlayer2.setImageResource(item.getIcon());
                    status++;
                    Parcelable hero2 = new HeroModel(item.getId(),item.getName(), item.getIntelligence(), item.getStrength(), item.getSpeed(), item.getDurability(), item.getPower(), item.getCombat(), item.getImage1(), item.getImage2(), item.getImage3(), item.getIcon());
                    gridview.setVisibility(View.GONE);
                    boutonFight.setVisibility(View.VISIBLE);
                    intent.putExtra("intenthero2", hero2);
                }
            }

        });

        boutonFight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });

        boutonSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                status = 0;
                gridview.setVisibility(View.VISIBLE);
                boutonFight.setVisibility(View.GONE);
            }
        });


    }







}
