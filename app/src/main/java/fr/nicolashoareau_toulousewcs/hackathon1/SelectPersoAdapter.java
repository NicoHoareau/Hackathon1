package fr.nicolashoareau_toulousewcs.hackathon1;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.ArrayList;


/**
 * Created by wilder on 05/04/18.
 */

public class SelectPersoAdapter extends ArrayAdapter<SelectPersoModel> {

    public SelectPersoAdapter(Context context, ArrayList<SelectPersoModel> items) {
        super(context, 0, items);
    }


    @Override
    public View getView ( int position, View convertView, ViewGroup parent) {
        SelectPersoModel selectPersoModel = (SelectPersoModel) getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_grid, parent, false);
        }

        ImageView imgPerso = (ImageView) convertView.findViewById(R.id.imagePerso);
        imgPerso.setImageResource(selectPersoModel.getImagePerso());

        return convertView;

    }









}