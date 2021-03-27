package com.example.mathcalculator;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;
public class NumberSystemActivity extends AppCompatActivity {
    String[] bases={"Binary","Quinary","Octal","Hexadecimal"};
    int numBase;
    String base= "";
    int num1,num2;
    Spinner b;

  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_system);

        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,bases);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        b= findViewById(R.id.baseSelector);
        b.setAdapter(aa);
        base=b.getSelectedItem().toString();
    }

    void checkSelectedItem(){
        base=b.getSelectedItem().toString();
        switch (base){
            case "Binary":
                numBase=2;break;
            case "Quinary":
                numBase=5;break;
            case "Octal":
                numBase=8;break;
            case "Hexadecimal":
                numBase=16;break;
        }
        EditText fn=findViewById(R.id.firstNumEditText);
        EditText sn=findViewById(R.id.secondNumEditText);

        String n1=fn.getText().toString();
        String n2=sn.getText().toString();
        try{
            num1=Integer.parseInt(Integer.toString(Integer.parseInt(String.valueOf(n1), numBase), 10));
        }
        catch (NumberFormatException e){
            fn.setError("Invalid input");
        }

        try{
            num2=Integer.parseInt(Integer.toString(Integer.parseInt(String.valueOf(n2), numBase), 10));
        }
        catch (NumberFormatException e){
            sn.setError("Invalid input");
        }
    }

    public void performAddition(View view) {
        checkSelectedItem();
        TextView res=findViewById(R.id.numBaseResultLbl);
        String sum=Integer.toString(Integer.parseInt(String.valueOf(num1+num2), 10), numBase);
        res.setText(sum);
    }

    public void performSubtraction(View view) {
        checkSelectedItem();
        TextView res=findViewById(R.id.numBaseResultLbl);
        String sum=Integer.toString(Integer.parseInt(String.valueOf(num1-num2), 10), numBase);
        res.setText(sum);
    }

    public void performMultiplication(View view) {
        checkSelectedItem();
        TextView res=findViewById(R.id.numBaseResultLbl);
        String sum=Integer.toString(Integer.parseInt(String.valueOf(num1*num2), 10), numBase);
        res.setText(sum);
    }

    public void performDivision(View view) {
        checkSelectedItem();
        TextView res=findViewById(R.id.numBaseResultLbl);
        String sum=Integer.toString(Integer.parseInt(String.valueOf(num1/num2), 10), numBase);
        res.setText(sum);
    }
}