package in.naveen.jaipurmetroguide;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Array;

/**
 * Created by naveen on 24/6/16.
 */
public class Fare_Class extends AppCompatActivity {
    Spinner spinner_from, spinner_to;
    String from_spinner_selection, to_spinner_selection, selected_from, selected_to;
    Button fare_btn;
    TextView fare_text;
    Snackbar snackbar;
	int from,to ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fare_layout);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);


    //show Sanckbar after 5 seconds
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                View coordinate = findViewById(R.id.snackbar_);
                snackbar = Snackbar.make(coordinate, "If traveling after 17:00 hrs. add ₹5 to final amount", Snackbar.LENGTH_LONG)
                        .setAction("Ok", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                snackbar.dismiss();
                            }
                        });
                snackbar.show();
                
            }
        }, 2500);

        
        spinner_from = (Spinner) findViewById(R.id.spinner_one);
        spinner_to = (Spinner) findViewById(R.id.spinner_two);
        fare_btn = (Button) findViewById(R.id.fare_button);
        fare_text = (TextView) findViewById(R.id.fare_text_detail);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.stations_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_from.setAdapter(adapter);


        spinner_to.setAdapter(adapter);


        spinner_from.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
						from = 0 ;
                        break;
                    case 1:
						from = 1;
                        break;
                    case 2:
						from = 2;
                        break;
                    case 3:
						from = 3;
                        break;
                    case 4:
						from = 4;
                        break;
                    case 5:
						from = 5;
                        break;
                    case 6:
						from = 6;
                        break;
                    case 7:
						from = 7;
                        break;
                    case 8:
						from = 8;
                        break;
                }
            }

            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner_to.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
						to = 0;
                        break;
                    case 1:
						to = 1;
                        break;
                    case 2:
						to = 2;
                        break;
                    case 3:
						to = 3;
                        break;
                    case 4:
						to = 4;
                        break;
                    case 5:
						to = 5;
                        break;
                    case 6:
						to = 6;
                        break;
                    case 7:
						to = 7;
                        break;
                    case 8:
						to = 8;
                        break;
                }

            }

            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
		
     //Set the fare according to Stations
        fare_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
				
				int diff = Math.abs(from - to) ;
				
				if(diff <3){
					fare_text.setText("Fare : ₹5");
				}
				else if(diff > 2 && diff < 6){
					fare_text.setText("Fare : ₹10");
				}
				else{
					fare_text.setText("Fare : ₹15");
				}
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:

                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}





