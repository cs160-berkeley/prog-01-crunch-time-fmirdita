package com.example.fmirdita.calorieconverter;

import android.app.Application;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

public class ScrollingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);

        final HashMap<String, Double> RepConversions = ((ExerciseApp) this.getApplication()).getRepConversions();
        final HashMap<String, Double> TimeConversions = ((ExerciseApp) this.getApplication()).getTimeConversions();

        final EditText input = (EditText) findViewById(R.id.input);
        final Spinner exerciseSpinner = (Spinner) findViewById(R.id.exerciseSpinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.exercises, R.layout.custom_spinner);
        adapter.setDropDownViewResource(R.layout.custom_spinner_dropdown);
        exerciseSpinner.setAdapter(adapter);
        exerciseSpinner.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                        Object item = parent.getItemAtPosition(pos);
                        input.setText("");
                        if (RepConversions.containsKey(item.toString()))
                            input.setHint(R.string.enterReps);
                        else
                            input.setHint(R.string.enterMins);
                    }

                    public void onNothingSelected(AdapterView<?> parent) {
                        input.setHint(R.string.choose);
                    }
                });

        input.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView view, int id, KeyEvent k) {

                String s1 = (String) ((EditText) findViewById(R.id.input)).getText().toString();
                String s2 = exerciseSpinner.getSelectedItem().toString();
                double num;
                if (RepConversions.containsKey(s2))
                    num = ((double) RepConversions.get(s2))*(Double.parseDouble(s1));
                else
                    num = ((double) TimeConversions.get(s2))*(Double.parseDouble(s1));

                String result = (String) "Calories: " + Double.toString(Math.round(num * 100) / 100);

                TextView cal = (TextView) findViewById(R.id.calories);
                cal.setText(result);
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
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
        return super.onOptionsItemSelected(item);
    }
}
