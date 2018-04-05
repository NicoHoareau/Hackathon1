package fr.nicolashoareau_toulousewcs.hackathon1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

        GridView gridview = (GridView) findViewById(R.id.grid_select_perso);
        ArrayList<SelectPersoModel> results = new ArrayList<>();

        //TODO : faire les résultats

        results.add(new SelectPersoModel(1, R.drawable.ic_launcher_background));
        results.add(new SelectPersoModel(2, R.drawable.ic_launcher_background));
        results.add(new SelectPersoModel(3, R.drawable.ic_launcher_background));
        results.add(new SelectPersoModel(4, R.drawable.ic_launcher_background));
        results.add(new SelectPersoModel(5, R.drawable.ic_launcher_background));
        results.add(new SelectPersoModel(6, R.drawable.ic_launcher_background));
        results.add(new SelectPersoModel(7, R.drawable.ic_launcher_background));
        results.add(new SelectPersoModel(8, R.drawable.ic_launcher_background));
        results.add(new SelectPersoModel(9, R.drawable.ic_launcher_background));

        SelectPersoAdapter adapter = new SelectPersoAdapter(this, results);
        gridview.setAdapter(adapter);


    }







}
