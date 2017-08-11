package com.example.muhwezidenisliam.parliament.comment_list_view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.muhwezidenisliam.parliament.R;

import java.util.ArrayList;


/**
 * Created by anupamchugh on 09/02/16.
 */
public class CustomAdapter extends ArrayAdapter<DataModel> {

    private ArrayList<DataModel> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView person_name;
        TextView timeAgo;
        TextView comment;
        ImageView person_image;
    }



    public CustomAdapter(ArrayList<DataModel> data, Context context) {
        super(context, R.layout.comments_card, data);
        this.dataSet = data;
        this.mContext=context;

    }


   /*Override
    public void onClick(View v) {


        int position=(Integer) v.getTag();
        Object object= getItem(position);
        DataModel dataModel=(DataModel)object;




        switch (v.getId())
        {

            case R.id.item_info:

                Snackbar.make(v, "Release date " +dataModel.getFeature(), Snackbar.LENGTH_LONG)
                        .setAction("No action", null).show();

                break;


        }


    }*/

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        DataModel dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {


            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.comments_card, parent, false);
            viewHolder.person_name= (TextView) convertView.findViewById(R.id.person_name);
            viewHolder.comment = (TextView) convertView.findViewById(R.id.comment);
            viewHolder.timeAgo = (TextView) convertView.findViewById(R.id.timeAgo);
            viewHolder.person_image = (ImageView) convertView.findViewById(R.id.person_image);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }
        lastPosition = position;


        viewHolder.person_name.setText(dataModel.getPerson_name());
        viewHolder.comment.setText(dataModel.getComment());
        viewHolder.timeAgo.setText(dataModel.getTime_ago());

        Drawable drawable= getContext().getResources().getDrawable(dataModel.getPerson_image());
        viewHolder.person_image.setImageDrawable(drawable);
        // Return the completed view to render on screen
        return convertView;
    }


}
