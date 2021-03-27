package com.example.calulations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class set_ops_activity extends AppCompatActivity {
    Set<String> A=new HashSet<>();
    Set<String> B=new HashSet<>();

    String a,b;
    String[] aValues,bValues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_ops_activity);
    }

    private void populate(){
        EditText aInput=findViewById(R.id.setA_etxt);
        EditText bInput=findViewById(R.id.setB_etxt);
        a=aInput.getText().toString();
        b=bInput.getText().toString();
        aValues=a.split(" ");
        bValues=b.split(" ");

        A.addAll(Arrays.asList(aValues));
        B.addAll(Arrays.asList(bValues));
    }

    public void calcUnion(View view) {
        populate();
        Set<String> union=new HashSet<>(A);
        union.addAll(B);
        TextView result=findViewById(R.id.res_txt_view);
        result.setText("Union : "+union.toString());

    }

    public void calcIntersection(View view) {
        populate();
        Set<String> intersection=new HashSet<>(A);
        intersection.retainAll(B);
        TextView result=findViewById(R.id.res_txt_view);
        result.setText("Intersection : "+intersection.toString());
    }

    public void calcDifference(View view) {
        populate();
        Set<String> diff=new HashSet<>(A);
        diff.removeAll(B);
        TextView result=findViewById(R.id.res_txt_view);
        result.setText("Difference : "+diff.toString());
    }
}