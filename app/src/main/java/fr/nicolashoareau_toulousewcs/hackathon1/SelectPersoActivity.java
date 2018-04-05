package fr.nicolashoareau_toulousewcs.hackathon1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

/**
 * Created by wilder on 05/04/18.
 */

public class SelectPersoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selection_perso);

        final GridView gridview = (GridView) findViewById(R.id.grid_select_perso);
        ArrayList<SelectPersoModel> results = new ArrayList<>();

        //TODO : faire les résultats

        results.add(new SelectPersoModel(70, R.drawable.ic_launcher_background));
        results.add(new SelectPersoModel(149, R.drawable.ic_launcher_background));
        results.add(new SelectPersoModel(176, R.drawable.ic_launcher_background));
        results.add(new SelectPersoModel(208, R.drawable.ic_launcher_background));
        results.add(new SelectPersoModel(213, R.drawable.ic_launcher_background));
        results.add(new SelectPersoModel(263, R.drawable.ic_launcher_background));
        results.add(new SelectPersoModel(289, R.drawable.ic_launcher_background));
        results.add(new SelectPersoModel(310, R.drawable.ic_launcher_background));
        results.add(new SelectPersoModel(332, R.drawable.ic_launcher_background));
        results.add(new SelectPersoModel(346, R.drawable.ic_launcher_background));
        results.add(new SelectPersoModel(352, R.drawable.ic_launcher_background));
        results.add(new SelectPersoModel(370, R.drawable.ic_launcher_background));
        results.add(new SelectPersoModel(373, R.drawable.ic_launcher_background));
        results.add(new SelectPersoModel(404, R.drawable.ic_launcher_background));
        results.add(new SelectPersoModel(502, R.drawable.ic_launcher_background));
        results.add(new SelectPersoModel(540, R.drawable.ic_launcher_background));
        results.add(new SelectPersoModel(574, R.drawable.ic_launcher_background));
        results.add(new SelectPersoModel(644, R.drawable.ic_launcher_background));
        results.add(new SelectPersoModel(650, R.drawable.ic_launcher_background));
        results.add(new SelectPersoModel(720, R.drawable.ic_launcher_background));


        SelectPersoAdapter adapter = new SelectPersoAdapter(this, results);
        gridview.setAdapter(adapter);


        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                SelectPersoModel item = (SelectPersoModel) gridview.getItemAtPosition(position);
                Intent intent = new Intent(SelectPersoActivity.this, FightActivity.class);
                int idHero = item.getId();
                intent.putExtra("idHero",id);
                SelectPersoActivity.this.startActivity(intent);
            }
        });


    }







}
