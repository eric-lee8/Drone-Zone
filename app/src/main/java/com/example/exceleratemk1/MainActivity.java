package com.example.exceleratemk1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        //something

        return super.onOptionsItemSelected(item);
    }

    boolean firstTime = true;
    OnTouchListener testTouchListener = new OnTouchListener(){
        public boolean onTouch(View v, MotionEvent me){
            Rect r = new Rect();
            secondButton.getDrawingRect(r);
            if(r.contains((int)me.getX(),(int)me.getY())){
                //Log.i(myTag, "Moved to button 2");
                if(firstTime == true){
                    firstTime = false;
                    secondButton.performClick();
                }
            }
            if(me.getAction() == MotionEvent.ACTION_UP){
                //When we lift finger reset the firstTime flag
                firstTime = true;
            }
            return false;

        }
    };
    firstButton.setOnTouchListener(testTouchListener);
}
