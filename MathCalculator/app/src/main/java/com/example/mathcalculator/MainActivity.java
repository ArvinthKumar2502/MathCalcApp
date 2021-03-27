package com.example.mathcalculator;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gotoLogarithmPage(View view) {
        intent=new Intent(this,LogarithmActivity.class);
        startActivity(intent);
    }

    public void gotoElectricalPage(View view) {
        intent=new Intent(this,ElectricalActivity.class);
        startActivity(intent);
    }

    public void gotoTrigonometryPage(View view) {
        intent=new Intent(this,TrigonometryActivity.class);
        startActivity(intent);
    }

    public void gotoNumberSysPage(View view) {
        intent=new Intent(this,NumberSystemActivity.class);
        startActivity(intent);
    }

    public void gotoMatrixPage(View view) {
        intent=new Intent(this,MatrixActivity.class);
        startActivity(intent);
    }
}