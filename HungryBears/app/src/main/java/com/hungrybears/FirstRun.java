package com.hungrybears;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;


public class FirstRun extends AppCompatActivity
        implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Initialize the content view in the Activity
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_run);

        // Name Field
        EditText etext_name = (EditText) findViewById(R.id.etext_name);

        // Spinner
        Spinner meal_plan = (Spinner) findViewById(R.id.meal_plan);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.meal_plans, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        meal_plan.setAdapter(adapter);
        meal_plan.setOnItemSelectedListener(this);

        // Button Next
        Button bttnNext = (Button) findViewById(R.id.bttn_next);
        bttnNext.setOnClickListener(this);

        // Create a SharedPreferences value
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor sharedPrefEditor = sharedPref.edit();
        sharedPrefEditor.putBoolean("SetupComplete", false);
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


    @Override
    public void onClick(View v) {
        // Name Field
        EditText etext_name = (EditText) findViewById(R.id.etext_name);

        // Spinner
        Spinner meal_plan = (Spinner) findViewById(R.id.meal_plan);
        double points = MealPlan.getPointsFromPlan(meal_plan.getSelectedItem().toString());

        // Create Shared Preferences entries
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor sharedPrefEditor = sharedPref.edit();
        sharedPrefEditor.putString("Name", etext_name.getText().toString());
        sharedPrefEditor.putInt("NumMealPointsCents", (int) (points * 100));
        sharedPrefEditor.putLong("StartTimeMillis", System.currentTimeMillis());
        sharedPrefEditor.putBoolean("SetupComplete", true);
        sharedPrefEditor.commit();

        Toast.makeText(getApplicationContext(), "Saved!",
                Toast.LENGTH_SHORT).show();
        // Intent to transition
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
