package com.example.calulations;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void gotoLcmPage(View view) {
        intent=new Intent(this,hcf_lcm_activity.class);
        startActivity(intent);
    }
    public void gotoFigWordsPage(View view) {
        intent=new Intent(this,figure_words_activity.class);
        startActivity(intent);
    }
    public void gotoMatrixPage(View view) {
        intent=new Intent(this,Matrix_operations_activity.class);
        startActivity(intent);
    }
    public void gotoSetPage(View view) {
        intent=new Intent(this,set_ops_activity.class);
        startActivity(intent);
    }
    public void gotoDatePage(View view) {
        intent=new Intent(this,date_difference_activity.class);
        startActivity(intent);
    }
}