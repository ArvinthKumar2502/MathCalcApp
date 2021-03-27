package com.example.mathcalculator;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
public class LogarithmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logarithm);
    }

    public void calculateNaturalLog(View view) {
        EditText entValue=findViewById(R.id.valueEditText);
        TextView resultLbl=findViewById(R.id.resultLbl);
        double value = Double.parseDouble(String.valueOf(entValue.getText()));
        String res=String.valueOf(Math.log(value));
        resultLbl.setText(res);
    }

    public void calculateLog(View view) {
        EditText entValue=findViewById(R.id.valueEditText);
        EditText baseVal=findViewById(R.id.baseEditText);
        TextView resultLbl=findViewById(R.id.resultLbl);
        int base=Integer.parseInt(String.valueOf(baseVal.getText()));
        double value = Double.parseDouble(String.valueOf(entValue.getText()));
        String res=String.valueOf(Math.log(value)/Math.log(base));
        resultLbl.setText(res);
    }

    public void calculateAntiLog(View view) {
        EditText entValue=findViewById(R.id.valueEditText);
        EditText baseVal=findViewById(R.id.baseEditText);
        TextView resultLbl=findViewById(R.id.resultLbl);
        int base=Integer.parseInt(String.valueOf(baseVal.getText()));
        double value = Double.parseDouble(String.valueOf(entValue.getText()));
        String res=String.valueOf(Math.pow(value,base));
        resultLbl.setText(res);
    }
}