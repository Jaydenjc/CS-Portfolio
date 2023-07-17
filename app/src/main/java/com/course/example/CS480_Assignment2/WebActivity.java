package com.course.example.CS480_Assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class WebActivity extends AppCompatActivity
{
    private EditText webET;
    private Button search;
    private WebView webView;


    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        webET = (EditText) findViewById(R.id.webET);
        search = (Button) findViewById(R.id.searchB);
        webView = (WebView) findViewById(R.id.webView);

        search.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                WebSettings webSettings = webView.getSettings();
                webSettings.setJavaScriptEnabled(true);

                //Keeps navigation in the browser
                WebViewClient webViewClient = new WebViewClient();
                webView.setWebViewClient(webViewClient);

                webView.loadUrl(webET.getText().toString());

            }
        });
    }

    //Handles the sending user back
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack())
        {
            webView.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    protected void onStop()
    {
        super.onStop();
        Toast.makeText(this, "Web Search Closed", Toast.LENGTH_LONG).show();
    }
}