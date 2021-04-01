package com.example.tutorial_08;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CourseAdapter extends ArrayAdapter<Course> {

    public CourseAdapter(Context context, ArrayList<Course> courses) {
        super(context, 0, courses);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Get the data item from this position
        Course course = getItem(position);

        // Check if th ean existing vew is being reused, otherwise inflate the view
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.module_layout, parent, false);
        }

        // Lookup view for data population
        TextView courseName = (TextView) convertView.findViewById(R.id.moduleName);
        CheckBox chkb = convertView.findViewById(R.id.chk);
        chkb.setTag(position);

        chkb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = (Integer) v.getTag();
                // Access the row position here to get the correct data item
                Course course1 = getItem(position);

                if(chkb.isChecked()) {
                    course1.isSaved = true;
                }else {
                    course1.isSaved = false;
                }
            }
        });

        // Populate the data into the template view using the data object
        courseName.setText(course.name);
        chkb.setChecked(course.isSaved);

        // Return the completed view to render on screen
        return convertView;
    }
}
