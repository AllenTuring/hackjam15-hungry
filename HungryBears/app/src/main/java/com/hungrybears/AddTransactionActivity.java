package com.hungrybears;

/**
 * Created by vivian on 10/3/15.
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class AddTransactionActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_run);

        Spinner stores = (Spinner) findViewById(R.id.spin_store);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.stores, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        stores.setAdapter(adapter);
        stores.setOnItemSelectedListener(this);

        Button bttnAdd = (Button) findViewById(R.id.bttn_add);
        bttnAdd.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
