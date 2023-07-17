package com.example.cs480assignment5;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

import androidx.appcompat.app.AppCompatActivity;

public class ResourceActivity extends AppCompatActivity
{
    Button button;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resource);


        button = (Button) findViewById(R.id.srB);


        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                PopupMenu pulldownMenu = new PopupMenu(ResourceActivity.this, button);


                pulldownMenu.getMenuInflater().inflate(R.menu.pulldownmenu, pulldownMenu.getMenu());
                { }

                pulldownMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener()
                {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {

                        String selectItem = menuItem.getTitle().toString();
                        switch(selectItem)
                        {
                            case "Restaurants":
                            {
                                url = "https://www.tripadvisor.com/RestaurantsNear-g60713-d5790106-University_of_San_Francisco-San_Francisco_California.html";
                                break;
                            }
                            case "Sightseeing":
                            {
                                url = "https://www.planetware.com/tourist-attractions-/san-francisco-us-ca-sf.htm";
                                break;
                            }
                            case "Public Transportation":
                            {
                                url = "https://www.sfmta.com/getting-around-san-francisco";
                                break;
                            }
                            case "Off-Campus Housing":
                            {
                                url = "https://www.student.com/us/san-francisco";
                                break;
                            }
                            case "USF Library Resource Guide":
                            {
                                url = "https://www.usfca.edu/library";
                                break;
                            }
                            default:
                            {
                                url = "https://www.google.com/";
                            }
                        }
                        switchTabToWeb(url);
                        return true;
                    }
                });

                pulldownMenu.show();
            }
        });
    }

    public void switchTabToWeb(String urlToSearch)
    {
        MainActivity parentActivity;
        parentActivity = (MainActivity) this.getParent();
        parentActivity.switchToWeb(urlToSearch);
    }
}
