package com.example.cs480assignment5;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends TabActivity
{

    Intent runMapActivity, runWebActivity, runResourceActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        TabHost tabhost = getTabHost();

        runMapActivity = new Intent(this, MapActivity.class);
        TabHost.TabSpec spec = tabhost.newTabSpec("Map");
        spec.setContent(runMapActivity);
        spec.setIndicator("Map");
        tabhost.addTab(spec);


        runWebActivity = new Intent(this, SearchActivity.class);
        spec = tabhost.newTabSpec("Web");
        spec.setContent(runWebActivity);
        spec.setIndicator("Web");
        tabhost.addTab(spec);


        runResourceActivity = new Intent(this, ResourceActivity.class);
        spec = tabhost.newTabSpec("Site List");
        spec.setContent(runResourceActivity);
        spec.setIndicator("Site List");
        tabhost.addTab(spec);


    }

    public void switchToWeb(String urlSearch)
    {
        runWebActivity.putExtra("Search", urlSearch);
        getTabHost().setCurrentTab(1);
    }
}