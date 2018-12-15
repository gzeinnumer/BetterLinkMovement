package com.zein.zeinyt12;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.util.Linkify;
import android.widget.TextView;
import android.widget.Toast;

import me.saket.bettermovementmethod.BetterLinkMovementMethod;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView txtDemo = (TextView)findViewById(R.id.txtDemo);
        BetterLinkMovementMethod.linkify(Linkify.ALL,txtDemo)
                .setOnLinkClickListener(new BetterLinkMovementMethod.OnLinkClickListener() {
                    @Override
                    public boolean onClick(TextView textView, String url) {
                        if(url.contains("tel:"))
                            Toast.makeText(MainActivity.this,"Phone number: "+url.replace("tel:",""),Toast.LENGTH_SHORT).show();
                        else if(url.contains("mailto:"))
                            Toast.makeText(MainActivity.this,"Email: "+url.replace("emailto:",""),Toast.LENGTH_SHORT).show();
                        else if(url.contains("http"))
                            Toast.makeText(MainActivity.this,"Website: "+url    ,Toast.LENGTH_SHORT).show();
                        return false;
                    }
                });
    }
}
