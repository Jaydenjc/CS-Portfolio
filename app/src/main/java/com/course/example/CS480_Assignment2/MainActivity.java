package com.course.example.CS480_Assignment2;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.net.Uri;
import com.google.android.gms.maps.GoogleMap;

public class MainActivity extends AppCompatActivity
{
    private Button tip, web, dial, map;
    private TextView tipCalc, checkAmountT, numOfPeopleT, tipPercentT, totalBillT, totalPerPersonT,
                    totalTipT, tipPerPersonT, totalBillE, totalPerPersonE, totalTipE, tipPerPersonE;
    private EditText checkAmountE, numOfPeopleE, tipPercentE;

    private double check = 0, num = 0, tipP = 0, bill = 0, tipV = 0;

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get references to widgets
        tipCalc = (TextView)findViewById(R.id.tipCalcT);
        checkAmountT = (TextView)findViewById(R.id.caT);
        checkAmountE = (EditText)findViewById(R.id.caE);
        numOfPeopleT = (TextView)findViewById(R.id.nopT);
        numOfPeopleE = (EditText)findViewById(R.id.nopE);
        tipPercentT = (TextView)findViewById(R.id.tpT);
        tipPercentE = (EditText)findViewById(R.id.tpE);
        totalBillT = (TextView)findViewById(R.id.tbT);
        totalBillE = (TextView)findViewById(R.id.tbE);
        totalPerPersonT = (TextView)findViewById(R.id.tppT);
        totalPerPersonE = (TextView)findViewById(R.id.tppE);
        totalTipT = (TextView)findViewById(R.id.ttT);
        totalTipE = (TextView)findViewById(R.id.ttE);
        tipPerPersonT = (TextView)findViewById(R.id.tipppT);
        tipPerPersonE = (TextView)findViewById(R.id.tipppE);

        tip = (Button)findViewById(R.id.tipB);
        web = (Button)findViewById(R.id.webB);
        dial = (Button)findViewById(R.id.dialB);
        map = (Button)findViewById(R.id.mapB);



        //set listener of go button
        tip.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {


                double check = Double.parseDouble(checkAmountE.getText().toString());
                double num = Double.parseDouble(numOfPeopleE.getText().toString());
                double tipP = Double.parseDouble(tipPercentE.getText().toString());
                double bill = Double.parseDouble(totalBillE.getText().toString());
                double tipV = Double.parseDouble(totalTipE.getText().toString());

                double tipValue = check * (tipP / 100);
                totalTipE.setText(new Double(tipValue).toString());
                double billValue = check + tipValue;
                totalBillE.setText(new Double(billValue).toString());
                double totalppValue = billValue / num;
                totalPerPersonE.setText(new Double(totalppValue).toString());
                double tipppValue = tipValue / num;
                tipPerPersonE.setText(new Double(tipppValue).toString());
            }

        });


            web.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    Intent intent = new Intent(getBaseContext(), WebActivity.class);
                    startActivity(intent);
                }

            });


        dial.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Uri uri = Uri.parse("tel:7818912000");
               // Intent intent = new Intent(Intent.ACTION_DIAL,uri);
                Intent intent2 = new Intent(Intent.ACTION_CALL,uri);
             //   startActivity(intent);
                startActivity(intent2);
            }
        });


        map.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                
                Uri uri = Uri.parse("geo:0,0?q=175+forest+street+waltham+ma");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);

                if (intent.resolveActivity(getPackageManager()) != null)
                {
                    startActivity(intent);
                }

            }

        });


    }

}

