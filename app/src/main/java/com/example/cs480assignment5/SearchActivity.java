package com.example.cs480assignment5;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SearchActivity extends AppCompatActivity
{
    private EditText searchET;
    private Button searchB;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);

        searchET = (EditText) findViewById(R.id.webET);
        searchB = (Button) findViewById(R.id.search);
        webView = (WebView) findViewById(R.id.wView);

        webView.getSettings().setJavaScriptEnabled(true);


        webView.setWebViewClient(new WebViewClient());


        searchB.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                webView.loadUrl(searchET.getText().toString());
            }
        });

        searchET.setOnKeyListener(new View.OnKeyListener()
        {
            public boolean onKey(View view, int keyCode, KeyEvent event)
            {
                if (keyCode == KeyEvent.KEYCODE_ENTER)
                {
                    webView.loadUrl(searchET.getText().toString());
                    return true;
                }
                return false;
            }
        });

        Bundle extras = getIntent().getExtras();

        if (extras != null)
        {
            String schoolUrl = extras.getString("Search");
            searchET.setText(schoolUrl);
        }
    }

    @Override

    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack())
        {
            webView.goBack();
            return true;
        }
        return false;
    }

    public void onResume()
    {
        super.onResume();

        Bundle extras = getIntent().getExtras();
        if (extras != null)
        {
            // String schoolUrl = extras.getString("searchUrl");
            String schoolUrl = extras.getString("Search");
            searchET.setText(schoolUrl);
            webView.loadUrl(schoolUrl);
            Toast.makeText(getApplicationContext(), "Resume", Toast.LENGTH_LONG).show();
        }

    }
}
