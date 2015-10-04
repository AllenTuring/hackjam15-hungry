package com.hungrybears;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

public class FirstRun extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_run);

        Spinner meal_plan = (Spinner) findViewById(R.id.meal_plan);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.meal_plans, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        meal_plan.setAdapter(adapter);
        meal_plan.setOnItemSelectedListener(this);
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        Spinner meal_plan = (Spinner) findViewById(R.id.meal_plan);
        String selected_plan = parent.getItemAtPosition(pos).toString();
        LinearLayout other = (LinearLayout) findViewById(R.id.LL_other_meal_points);
        if(selected_plan.equals("Other")) {
            //throw new IllegalArgumentException();
            other.setVisibility(View.VISIBLE);
        }
        else {
            other.setVisibility(View.GONE);
        }
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Do Nothing
    }
}
