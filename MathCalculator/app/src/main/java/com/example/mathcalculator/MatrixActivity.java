package com.example.mathcalculator;
import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MatrixActivity extends AppCompatActivity implements
        View.OnClickListener, AdapterView.OnItemSelectedListener {
    Button button;
    Button button2;
    TextView row;
    TextView col;
    Spinner spinner;
    String[] nubs = {"Addition","Subtraction","Multiply","Power"};
    int rowNum=0;
    int colNum=0;
    EditText edt;
    int[][] mat;
    int[][] mat2;
    EditText[][] editTexts;
    EditText[][] editTexts2;
    EditText[][] editTexts3;
    {
        mat = new int[100][100];
        mat2 = new int[100][100];
    }
    GridLayout gridLayout;
    GridLayout gridLayout2;
    GridLayout gridLayout3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matrix);
        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button.setOnClickListener(this);
        edt = new EditText(this);
        button2.setOnClickListener(this);
        row = (EditText) findViewById(R.id.textView3);
        col = (EditText) findViewById(R.id.textView4);
        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,nubs);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(aa);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v == button)
        {
            rowNum=Integer.parseInt(row.getText().toString());
            colNum=Integer.parseInt(col.getText().toString());
            Intent passedIntent = getIntent();
            Bundle extras = passedIntent.getExtras();
            gridLayout = (GridLayout) findViewById(R.id.gird1);
            gridLayout2 = (GridLayout) findViewById(R.id.grid2);
            gridLayout.removeAllViews();
            gridLayout2.removeAllViews();
            editTexts = new EditText[rowNum][colNum];
            editTexts2 = new EditText[rowNum][colNum];
            gridLayout.setRowCount(rowNum);
            gridLayout.setColumnCount(colNum);

            for (int i = 0; i < rowNum; i++) {
                for (int j = 0; j < colNum; j++) {
                    editTexts[i][j] = new EditText(this);
                    editTexts2[i][j] = new EditText(this);
                    setPos(editTexts2[i][j],i,j);
                    setPos(editTexts[i][j], i, j);
                    gridLayout2.addView(editTexts[i][j]);
                    gridLayout.addView(editTexts2[i][j]);
                }
            }
        }
        if(v==button2){
            for(int i=0;i<rowNum;i++){
                for(int j=0;j<colNum;j++){
                    mat[i][j]= Integer.parseInt(editTexts[i][j].getText().toString());
                    if(spinner.getSelectedItemPosition()!=3)
                        mat2[i][j]= Integer.parseInt(editTexts2[i][j].getText().toString());
                }
            }
            switch (spinner.getSelectedItemPosition())
            {
                case 0:
                {
                    rowNum=Integer.parseInt(row.getText().toString());
                    colNum=Integer.parseInt(col.getText().toString());
                    for(int i=0;i<rowNum;i++) {
                        for (int j = 0; j < colNum; j++) {
                            mat2[i][j] = mat[i][j] + mat2[i][j];
                        }
                    }
                    Intent i = new Intent(this, outputMatrix.class);
                    i.putExtra("row",row.getText().toString());
                    i.putExtra("col",col.getText().toString());
                    Bundle mBundle = new Bundle();
                    mBundle.putSerializable("key_array_array",  mat2);
                    i.putExtras(mBundle);
                    startActivity(i);
                    break;
                }
                case 1:
                {
                    for(int i=0;i<rowNum;i++) {
                        for (int j = 0; j < colNum; j++) {
                            mat2[i][j] = mat[i][j] - mat2[i][j];
                        }
                    }
                    Intent i = new Intent(this, outputMatrix.class);
                    i.putExtra("row",row.getText().toString());
                    i.putExtra("col",col.getText().toString());
                    Bundle mBundle = new Bundle();
                    mBundle.putSerializable("key_array_array",  mat2);
                    i.putExtras(mBundle);

                    startActivity(i);
                    break;
                }
                case 2:
                {
                    Intent i = new Intent(this, outputMatrix.class);
                    i.putExtra("row",row.getText().toString());
                    i.putExtra("col",col.getText().toString());
                    Bundle mBundle = new Bundle();
                    mBundle.putSerializable("key_array_array", (new multiply()).matrixMultiply(rowNum,colNum,mat,rowNum,colNum,mat2));
                    i.putExtras(mBundle);
                    startActivity(i);
                    break;
                }
                case 3:
                {
                    int pow = Integer.parseInt(edt.getText().toString());
                    if(pow==0)
                    {
                        for(int i=0;i<rowNum;i++)
                        {
                            for(int j=0;j<colNum;j++)
                            {
                                if(i==j)
                                {
                                    mat[i][j]=1;
                                }
                                else{
                                    mat[i][j]=0;
                                }
                            }
                        }
                    }
                    for ( int i = 0;i < pow-1; i++)
                    {
                        mat=(new multiply()).matrixMultiply(rowNum,colNum,mat,rowNum,colNum,mat);
                    }
                    Intent i = new Intent(this, outputMatrix.class);
                    i.putExtra("row",row.getText().toString());
                    i.putExtra("col",col.getText().toString());
                    Bundle mBundle = new Bundle();
                    mBundle.putSerializable("key_array_array",  mat);
                    i.putExtras(mBundle);
                    startActivity(i);
                    break;
                }
            }
        }
    }


    private void setPos(EditText editText, int row, int column) {
        GridLayout.LayoutParams param =new GridLayout.LayoutParams();
        editText.setInputType(InputType.TYPE_CLASS_NUMBER);
        editText.setVisibility(View.VISIBLE);
        param.width = 100;
        param.height = 150;
        param.setGravity(Gravity.CENTER);
        param.rowSpec = GridLayout.spec(row);
        param.columnSpec = GridLayout.spec(column);
        editText.setLayoutParams(param);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(position == 3){
            gridLayout = (GridLayout) findViewById(R.id.gird1);
            gridLayout.removeAllViews();
            gridLayout.setRowCount(1);
            gridLayout.setColumnCount(1);
            setPos(edt,0,0);
            gridLayout.addView(edt);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}