package com.example.hartasimpla;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public final class Interface extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private static class CustomArrayAdapter extends ArrayAdapter<DemoDetails> {
        /**
         * @param demos An array containing the details of the demos to be displayed.
         */
        public CustomArrayAdapter(Context context, DemoDetails[] demos) {
            super(context, R.layout.feature, R.id.title, demos);
        }
        public FeatureView getView(int position, View convertView, ViewGroup parent) {
            FeatureView featureView;
            if (convertView instanceof FeatureView) {
                featureView = (FeatureView) convertView;
            } else {
                featureView = new FeatureView(parent.getContext());

            }
            DemoDetails demo = getItem(position);
            featureView.setTitleId(demo.titleId);

            featureView.setDescriptionId(demo.descriptionId);
            Resources resources = getContext().getResources();

            String title = resources.getString(demo.titleId);

            String description = resources.getString(demo.descriptionId);

            featureView.setContentDescription(title + ". " + description);

            return featureView;

        }

    }
public void onCreate(Bundle savedInstanceState)
{
   super.onCreate(savedInstanceState);
   setContentView(R.layout.main);

    ListView list = findViewById(R.id.list);

    ListAdapter adapter = new CustomArrayAdapter(this, DemoDetailsList.DEMOS);

    list.setAdapter(adapter);
    list.setOnItemClickListener(this);
    list.setEmptyView(findViewById(R.id.empty));

    if(getString(R.string.maps_api_key).isEmpty())
    {
        Toast.makeText(this,"add api ",Toast.LENGTH_LONG);
    }
}


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position , long id) {
        DemoDetails demo = (DemoDetails) parent.getAdapter().getItem(position);

        startActivity(new Intent(this, demo.activityClass));
    }
}
