package com.example.mathcalculator;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
public class TrigonometryActivity extends AppCompatActivity
        implements  View.OnClickListener,AdapterView.OnItemSelectedListener {
    String[] trigUnits={"Degrees","Radians"};
    Spinner tu;
    double radians;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trigonometry);
        ArrayAdapter aa = new
                ArrayAdapter(this, android.R.layout.simple_spinner_item, trigUnits);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tu=findViewById(R.id.unit);
        tu.setAdapter(aa);
        tu.setOnItemSelectedListener(this);
    }

    public void calculateTrigValues(View view) {
        EditText input=findViewById(R.id.degreeInputTxt);
        TextView sinlbl=findViewById(R.id.sinLbl);
        TextView coslbl=findViewById(R.id.cosLbl);
        TextView tanlbl=findViewById(R.id.tanLbl);
        TextView coseclbl=findViewById(R.id.cosecLbl);
        TextView seclbl=findViewById(R.id.secLbl);
        TextView cotlbl=findViewById(R.id.cotLbl);
        TextView asinlbl=findViewById(R.id.arcSinLbl);
        TextView acoslbl=findViewById(R.id.arcCosLbl);
        TextView atanlbl=findViewById(R.id.arcTanLbl);

        double val=Double.parseDouble(String.valueOf(input.getText()));

        switch (tu.getSelectedItemPosition()){
            case 0: radians=Math.toRadians(val);
                    break;
            case 1: radians=val;
                    break;
        }

        sinlbl.setText("sin : "+ Math.sin(radians));
        coslbl.setText("cos : "+ Math.cos(radians));
        tanlbl.setText("tan : "+ Math.tan(radians));

        coseclbl.setText("cosec : "+ 1 / (Math.sin(radians)));
        seclbl.setText("sec : "+ 1 / (Math.cos(radians)));
        cotlbl.setText("cot : "+ 1 / (Math.tan(radians)));

        asinlbl.setText("Arc sin : "+ Math.asin(radians));
        acoslbl.setText("Arc cos : "+ Math.acos(radians));
        atanlbl.setText("Arc tan : "+ Math.atan(radians));
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}