package kv.android.com.implicitintentexamples;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button_web = (Button)findViewById(R.id.button_website);
       /* button_web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

            }
        });

*/
    }

    public void activities(View view)
    {
        Intent intent = null,  chooser= null;
        switch (view.getId())
        {
            case R.id.button_website:
                //Action
                 intent = new Intent(Intent.ACTION_VIEW);
                // Data to be passed as MIME type or set data as URI
                intent.setData(Uri.parse("http://www.google.com"));
                // To identify intent
                chooser = intent.createChooser(intent,"Open web");
                // start activity
                //startActivity(intent);
                //if none of the browsers are available, there is a chance of app to crash
                //solve that exception using the below steps
                if (intent.resolveActivity(getPackageManager())!= null)
                {  startActivity(chooser);}
                break;
        }
    }
}
