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
                ;
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
                        selected_from = "Mansarovar (MSOR)";
                        break;
                    case 1:
                        selected_from = "New Atish Market (NAMT)";
                        break;
                    case 2:
                        selected_from = "Vivek Vihar (VKVR)";
                        break;
                    case 3:
                        selected_from = "Shyam Nagar (SMNR)";
                        break;
                    case 4:
                        selected_from = "Ram Nagar (RMNR)";
                        break;
                    case 5:
                        selected_from = "Civil Lines (CLJP)";
                        break;
                    case 6:
                        selected_from = "Railway Station (MRSN)";
                        break;
                    case 7:
                        selected_from = "Sindhi Camp (SICP)";
                        break;
                    case 8:
                        selected_from = "Chandpole (CDPE)";
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
                        selected_to = "Mansarovar (MSOR)";
                        break;
                    case 1:
                        selected_to = "New Atish Market (NAMT)";
                        break;
                    case 2:
                        selected_to = "Vivek Vihar (VKVR)";
                        break;
                    case 3:
                        selected_to = "Shyam Nagar (SMNR)";
                        break;
                    case 4:
                        selected_to = "Ram Nagar (RMNR)";
                        break;
                    case 5:
                        selected_to = "Civil Lines (CLJP)";
                        break;
                    case 6:
                        selected_to = "Railway Station (MRSN)";
                        break;
                    case 7:
                        selected_to = "Sindhi Camp (SICP)";
                        break;
                    case 8:
                        selected_to = "Chandpole (CDPE)";
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



                if ((selected_from.equals("Mansarovar (MSOR)")) && (selected_to.equals("Mansarovar (MSOR)"))) {
                    fare_text.setText("Fare : ₹5");
                } else if ((selected_from.equals("Mansarovar (MSOR)")) && (selected_to.equals("New Atish Market (NAMT)"))) {
                    fare_text.setText("Fare : ₹5");
                } else if ((selected_from.equals("Mansarovar (MSOR)")) && (selected_to.equals("Vivek Vihar (VKVR)"))) {
                    fare_text.setText("Fare : ₹5");
                } else if ((selected_from.equals("Mansarovar (MSOR)")) && (selected_to.equals("Shyam Nagar (SMNR)"))) {
                    fare_text.setText("Fare : ₹10");
                } else if ((selected_from.equals("Mansarovar (MSOR)")) && (selected_to.equals("Ram Nagar (RMNR)"))) {
                    fare_text.setText("Fare : ₹10");
                } else if ((selected_from.equals("Mansarovar (MSOR)")) && (selected_to.equals("Civil Lines (CLJP)"))) {
                    fare_text.setText("Fare : ₹10");
                } else if ((selected_from.equals("Mansarovar (MSOR)")) && (selected_to.equals("Railway Station (MRSN)"))) {
                    fare_text.setText("Fare : ₹15");
                } else if ((selected_from.equals("Mansarovar (MSOR)")) && (selected_to.equals("Sindhi Camp (SICP)"))) {
                    fare_text.setText("Fare : ₹15");
                } else if ((selected_from.equals("Mansarovar (MSOR)")) && (selected_to.equals("Chandpole (CDPE)"))) {
                    fare_text.setText("Fare : ₹15");
                }


                if ((selected_from.equals("New Atish Market (NAMT)")) && (selected_to.equals("Mansarovar (MSOR)"))) {
                    fare_text.setText("Fare : ₹5");
                } else if ((selected_from.equals("New Atish Market (NAMT)")) && (selected_to.equals("New Atish Market (NAMT)"))) {
                    fare_text.setText("Fare : ₹5");
                } else if ((selected_from.equals("New Atish Market (NAMT)")) && (selected_to.equals("Vivek Vihar (VKVR)"))) {
                    fare_text.setText("Fare : ₹5");
                } else if ((selected_from.equals("New Atish Market (NAMT)")) && (selected_to.equals("Shyam Nagar (SMNR)"))) {
                    fare_text.setText("Fare : ₹5");
                } else if ((selected_from.equals("New Atish Market (NAMT)")) && (selected_to.equals("Ram Nagar (RMNR)"))) {
                    fare_text.setText("Fare : ₹10");
                } else if ((selected_from.equals("New Atish Market (NAMT)")) && (selected_to.equals("Civil Lines (CLJP)"))) {
                    fare_text.setText("Fare : ₹10");
                } else if ((selected_from.equals("New Atish Market (NAMT)")) && (selected_to.equals("Railway Station (MRSN)"))) {
                    fare_text.setText("Fare : ₹10");
                } else if ((selected_from.equals("New Atish Market (NAMT)")) && (selected_to.equals("Sindhi Camp (SICP)"))) {
                    fare_text.setText("Fare : ₹15");
                } else if ((selected_from.equals("New Atish Market (NAMT)")) && (selected_to.equals("Chandpole (CDPE)"))) {
                    fare_text.setText("Fare : ₹15");
                }


                if ((selected_from.equals("Vivek Vihar (VKVR)")) && (selected_to.equals("Mansarovar (MSOR)"))) {
                    fare_text.setText("Fare : ₹5");
                } else if ((selected_from.equals("Vivek Vihar (VKVR)")) && (selected_to.equals("New Atish Market (NAMT)"))) {
                    fare_text.setText("Fare : ₹5");
                } else if ((selected_from.equals("Vivek Vihar (VKVR)")) && (selected_to.equals("Vivek Vihar (VKVR)"))) {
                    fare_text.setText("Fare : ₹5");
                } else if ((selected_from.equals("Vivek Vihar (VKVR)")) && (selected_to.equals("Shyam Nagar (SMNR)"))) {
                    fare_text.setText("Fare : ₹5");
                } else if ((selected_from.equals("Vivek Vihar (VKVR)")) && (selected_to.equals("Ram Nagar (RMNR)"))) {
                    fare_text.setText("Fare : ₹5");
                } else if ((selected_from.equals("New Atish Market (NAMT)")) && (selected_to.equals("Civil Lines (CLJP)"))) {
                    fare_text.setText("Fare : ₹10");
                } else if ((selected_from.equals("Vivek Vihar (VKVR)")) && (selected_to.equals("Railway Station (MRSN)"))) {
                    fare_text.setText("Fare : ₹10");
                } else if ((selected_from.equals("Vivek Vihar (VKVR)")) && (selected_to.equals("Sindhi Camp (SICP)"))) {
                    fare_text.setText("Fare : ₹10");
                } else if ((selected_from.equals("Vivek Vihar (VKVR)")) && (selected_to.equals("Chandpole (CDPE)"))) {
                    fare_text.setText("Fare : ₹15");
                }


                if ((selected_from.equals("Shyam Nagar (SMNR)")) && (selected_to.equals("Mansarovar (MSOR)"))) {
                    fare_text.setText("Fare : ₹10");
                } else if ((selected_from.equals("Shyam Nagar (SMNR)")) && (selected_to.equals("New Atish Market (NAMT)"))) {
                    fare_text.setText("Fare : ₹5");
                } else if ((selected_from.equals("Shyam Nagar (SMNR)")) && (selected_to.equals("Vivek Vihar (VKVR)"))) {
                    fare_text.setText("Fare : ₹5");
                } else if ((selected_from.equals("Shyam Nagar (SMNR)")) && (selected_to.equals("Shyam Nagar (SMNR)"))) {
                    fare_text.setText("Fare : ₹5");
                } else if ((selected_from.equals("Shyam Nagar (SMNR)")) && (selected_to.equals("Ram Nagar (RMNR)"))) {
                    fare_text.setText("Fare : ₹5");
                } else if ((selected_from.equals("Shyam Nagar (SMNR)")) && (selected_to.equals("Civil Lines (CLJP)"))) {
                    fare_text.setText("Fare : ₹10");
                } else if ((selected_from.equals("Shyam Nagar (SMNR)")) && (selected_to.equals("Railway Station (MRSN)"))) {
                    fare_text.setText("Fare : ₹10");
                } else if ((selected_from.equals("Shyam Nagar (SMNR)")) && (selected_to.equals("Sindhi Camp (SICP)"))) {
                    fare_text.setText("Fare : ₹10");
                } else if ((selected_from.equals("Shyam Nagar (SMNR)")) && (selected_to.equals("Chandpole (CDPE)"))) {
                    fare_text.setText("Fare : ₹10");
                }


                if ((selected_from.equals("Ram Nagar (RMNR)")) && (selected_to.equals("Mansarovar (MSOR)"))) {
                    fare_text.setText("Fare : ₹10");
                } else if ((selected_from.equals("Ram Nagar (RMNR)")) && (selected_to.equals("New Atish Market (NAMT)"))) {
                    fare_text.setText("Fare : ₹10");
                } else if ((selected_from.equals("Ram Nagar (RMNR)")) && (selected_to.equals("Vivek Vihar (VKVR)"))) {
                    fare_text.setText("Fare : ₹5");
                } else if ((selected_from.equals("Ram Nagar (RMNR)")) && (selected_to.equals("Shyam Nagar (SMNR)"))) {
                    fare_text.setText("Fare : ₹5");
                } else if ((selected_from.equals("Ram Nagar (RMNR)")) && (selected_to.equals("Ram Nagar (RMNR)"))) {
                    fare_text.setText("Fare : ₹5");
                } else if ((selected_from.equals("Ram Nagar (RMNR)")) && (selected_to.equals("Civil Lines (CLJP)"))) {
                    fare_text.setText("Fare : ₹5");
                } else if ((selected_from.equals("Ram Nagar (RMNR)")) && (selected_to.equals("Railway Station (MRSN)"))) {
                    fare_text.setText("Fare : ₹5");
                } else if ((selected_from.equals("Ram Nagar (RMNR)")) && (selected_to.equals("Sindhi Camp (SICP)"))) {
                    fare_text.setText("Fare : ₹10");
                } else if ((selected_from.equals("Ram Nagar (RMNR)")) && (selected_to.equals("Chandpole (CDPE)"))) {
                    fare_text.setText("Fare : ₹10");
                }


                if ((selected_from.equals("Civil Lines (CLJP)")) && (selected_to.equals("Mansarovar (MSOR)"))) {
                    fare_text.setText("Fare : ₹10");
                } else if ((selected_from.equals("Civil Lines (CLJP)")) && (selected_to.equals("New Atish Market (NAMT)"))) {
                    fare_text.setText("Fare : ₹10");
                } else if ((selected_from.equals("Civil Lines (CLJP)")) && (selected_to.equals("Vivek Vihar (VKVR)"))) {
                    fare_text.setText("Fare : ₹10");
                } else if ((selected_from.equals("Civil Lines (CLJP)")) && (selected_to.equals("Shyam Nagar (SMNR)"))) {
                    fare_text.setText("Fare : ₹5");
                } else if ((selected_from.equals("Civil Lines (CLJP)")) && (selected_to.equals("Ram Nagar (RMNR)"))) {
                    fare_text.setText("Fare : ₹5");
                } else if ((selected_from.equals("Civil Lines (CLJP)")) && (selected_to.equals("Civil Lines (CLJP)"))) {
                    fare_text.setText("Fare : ₹5");
                } else if ((selected_from.equals("Civil Lines (CLJP)")) && (selected_to.equals("Railway Station (MRSN)"))) {
                    fare_text.setText("Fare : ₹5");
                } else if ((selected_from.equals("Civil Lines (CLJP)")) && (selected_to.equals("Sindhi Camp (SICP)"))) {
                    fare_text.setText("Fare : ₹5");
                } else if ((selected_from.equals("Civil Lines (CLJP)")) && (selected_to.equals("Chandpole (CDPE)"))) {
                    fare_text.setText("Fare : ₹10");
                }


                if ((selected_from.equals("Railway Station (MRSN)")) && (selected_to.equals("Mansarovar (MSOR)"))) {
                    fare_text.setText("Fare : ₹15");
                } else if ((selected_from.equals("Railway Station (MRSN)")) && (selected_to.equals("New Atish Market (NAMT)"))) {
                    fare_text.setText("Fare : ₹10");
                } else if ((selected_from.equals("Railway Station (MRSN)")) && (selected_to.equals("Vivek Vihar (VKVR)"))) {
                    fare_text.setText("Fare : ₹10");
                } else if ((selected_from.equals("Railway Station (MRSN)")) && (selected_to.equals("Shyam Nagar (SMNR)"))) {
                    fare_text.setText("Fare : ₹10");
                } else if ((selected_from.equals("Railway Station (MRSN)")) && (selected_to.equals("Ram Nagar (RMNR)"))) {
                    fare_text.setText("Fare : ₹5");
                } else if ((selected_from.equals("Railway Station (MRSN)")) && (selected_to.equals("Civil Lines (CLJP)"))) {
                    fare_text.setText("Fare : ₹5");
                } else if ((selected_from.equals("Railway Station (MRSN)")) && (selected_to.equals("Railway Station (MRSN)"))) {
                    fare_text.setText("Fare : ₹5");
                } else if ((selected_from.equals("Railway Station (MRSN)")) && (selected_to.equals("Sindhi Camp (SICP)"))) {
                    fare_text.setText("Fare : ₹5");
                } else if ((selected_from.equals("Railway Station (MRSN)")) && (selected_to.equals("Chandpole (CDPE)"))) {
                    fare_text.setText("Fare : ₹5");
                }


                if ((selected_from.equals("Sindhi Camp (SICP)")) && (selected_to.equals("Mansarovar (MSOR)"))) {
                    fare_text.setText("Fare : ₹15");
                } else if ((selected_from.equals("Sindhi Camp (SICP)")) && (selected_to.equals("New Atish Market (NAMT)"))) {
                    fare_text.setText("Fare : ₹15");
                } else if ((selected_from.equals("Sindhi Camp (SICP)")) && (selected_to.equals("Vivek Vihar (VKVR)"))) {
                    fare_text.setText("Fare : ₹10");
                } else if ((selected_from.equals("Sindhi Camp (SICP)")) && (selected_to.equals("Shyam Nagar (SMNR)"))) {
                    fare_text.setText("Fare : ₹10");
                } else if ((selected_from.equals("Sindhi Camp (SICP)")) && (selected_to.equals("Ram Nagar (RMNR)"))) {
                    fare_text.setText("Fare : ₹10");
                } else if ((selected_from.equals("Sindhi Camp (SICP)")) && (selected_to.equals("Civil Lines (CLJP)"))) {
                    fare_text.setText("Fare : ₹5");
                } else if ((selected_from.equals("Sindhi Camp (SICP)")) && (selected_to.equals("Railway Station (MRSN)"))) {
                    fare_text.setText("Fare : ₹5");
                } else if ((selected_from.equals("Sindhi Camp (SICP)")) && (selected_to.equals("Sindhi Camp (SICP)"))) {
                    fare_text.setText("Fare : ₹5");
                } else if ((selected_from.equals("Sindhi Camp (SICP)")) && (selected_to.equals("Chandpole (CDPE)"))) {
                    fare_text.setText("Fare : ₹5");
                }


                if ((selected_from.equals("Chandpole (CDPE)")) && (selected_to.equals("Mansarovar (MSOR)"))) {
                    fare_text.setText("Fare : ₹15");
                } else if ((selected_from.equals("Chandpole (CDPE)")) && (selected_to.equals("New Atish Market (NAMT)"))) {
                    fare_text.setText("Fare : ₹15");
                } else if ((selected_from.equals("Chandpole (CDPE)")) && (selected_to.equals("Vivek Vihar (VKVR)"))) {
                    fare_text.setText("Fare : ₹15");
                } else if ((selected_from.equals("Chandpole (CDPE)")) && (selected_to.equals("Shyam Nagar (SMNR)"))) {
                    fare_text.setText("Fare : ₹10");
                } else if ((selected_from.equals("Chandpole (CDPE)")) && (selected_to.equals("Ram Nagar (RMNR)"))) {
                    fare_text.setText("Fare : ₹10");
                } else if ((selected_from.equals("Chandpole (CDPE)")) && (selected_to.equals("Civil Lines (CLJP)"))) {
                    fare_text.setText("Fare : ₹10");
                } else if ((selected_from.equals("Chandpole (CDPE)")) && (selected_to.equals("Railway Station (MRSN)"))) {
                    fare_text.setText("Fare : ₹5");
                } else if ((selected_from.equals("Chandpole (CDPE)")) && (selected_to.equals("Sindhi Camp (SICP)"))) {
                    fare_text.setText("Fare : ₹5");
                } else if ((selected_from.equals("Chandpole (CDPE)")) && (selected_to.equals("Chandpole (CDPE)"))) {
                    fare_text.setText("Fare : ₹5");
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





