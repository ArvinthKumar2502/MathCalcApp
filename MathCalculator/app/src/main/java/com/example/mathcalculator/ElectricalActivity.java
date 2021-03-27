package com.example.mathcalculator;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class ElectricalActivity extends AppCompatActivity implements
        View.OnClickListener, AdapterView.OnItemSelectedListener {
    Spinner spinner;
    EditText editText;
    EditText editText2;
    Button button;
    TextView textView;
    String[] types = {"Amps", "kW", "kVA", "VA", "Volts", "Watts", "Joules", "mAh", "Wh"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electrical);
        textView = findViewById(R.id.textView3);
        editText = findViewById(R.id.textView);
        editText2 = findViewById(R.id.textView2);
        spinner = findViewById(R.id.spinner);
        button = findViewById(R.id.button);
        ArrayAdapter aa = new
                ArrayAdapter(this, android.R.layout.simple_spinner_item, types);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(aa);
        spinner.setOnItemSelectedListener(this);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        try {
            String unit1 = editText.getText().toString();
            String unit2 = editText2.getText().toString();
            switch (spinner.getSelectedItemPosition()) {
                case 0: {
                    editText.setHint("Watts");
                    editText2.setHint("volts");
                    String text = String.valueOf(Double.parseDouble(unit1)/Double.parseDouble(unit2));
                    textView.setText(text);
                    break;
                }
                case 1: {
                    textView.setText(String.valueOf(1000/(Double.parseDouble(unit1)*Double.parseDouble(unit2))));
                    break;
                }
                case 2: {
                    textView.setText(String.valueOf(Double.parseDouble(unit1)/Double.parseDouble(unit2)));
                    break;
                }
                case 3: {
                    textView.setText(String.valueOf(Double.parseDouble(unit1)*Double.parseDouble(unit2)));
                    break;
                }
                case 4: {
                    textView.setText(String.valueOf(Double.parseDouble(unit1)/Double.parseDouble(unit2)));
                    break;
                }
                case 5: {
                    textView.setText(String.valueOf(Double.parseDouble(unit1)*Double.parseDouble(unit2)));
                    break;
                }
                case 6: {
                    textView.setText(String.valueOf(Double.parseDouble(unit1)*Double.parseDouble(unit2)));
                    break;
                }
                case 7: {
                    textView.setText(String.valueOf(Double.parseDouble(unit1)/Double.parseDouble(unit2)));
                    break;
                }
                case 8: {
                    textView.setText(String.valueOf(Double.parseDouble(unit1)*Double.parseDouble(unit2)));
                    break;
                }
            }
        } catch (Exception e) {
            editText.setError("Invalid input");
            editText2.setError("Invalid input");
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0: {
                editText.setHint("Watts");
                editText2.setHint("Volts");
            }
            case 1: {
                editText.setHint("Amps");
                editText2.setHint("Volts");
                break;
            }

            case 2: {
                editText.setHint("power factor (pf)");
                editText2.setHint("kW");
                break;
            }
            case 3: {
                editText.setHint("Vrms");
                editText2.setHint("Irms");
                break;
            }
            case 4: {
                editText.setHint("Watts");
                editText2.setHint("Amps");
                break;
            }
            case 5: {
                editText.setHint("Amps");
                editText2.setHint("Volts");
                break;
            }
            case 6: {
                editText.setHint("Watts");
                editText2.setHint("time in sec");
                break;
            }
            case 7: {
                editText.setHint("Watt - Hour");
                editText2.setHint("Volts");
                break;
            }
            case 8: {
                editText.setHint("Watts");
                editText2.setHint("Hours");
                break;
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}
