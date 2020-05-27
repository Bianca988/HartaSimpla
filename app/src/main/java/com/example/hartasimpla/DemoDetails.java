package com.example.hartasimpla;

import androidx.appcompat.app.AppCompatActivity;

public class DemoDetails {


    /**
     * The resource id of the title of the demo.
     */

    public final int titleId;


    /**
     * The resources id of the description of the demo.
     */

    public final int descriptionId;


    /**
     * The demo activity's class.
     */

    public final Class<? extends AppCompatActivity> activityClass;


    public DemoDetails(

            int titleId, int descriptionId, Class<? extends AppCompatActivity> activityClass) {

        this.titleId = titleId;

        this.descriptionId = descriptionId;

        this.activityClass = activityClass;

    }
}