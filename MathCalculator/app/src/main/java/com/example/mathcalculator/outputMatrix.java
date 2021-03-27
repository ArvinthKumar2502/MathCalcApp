package com.example.mathcalculator;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import androidx.gridlayout.widget.GridLayout;
public class outputMatrix extends AppCompatActivity {
    GridLayout gridLayout3;
    EditText[][] editTexts3;
    int rowNum;
    int colNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output_matrix);
        int[][] arrayReceived=null;
        rowNum=Integer.parseInt(getIntent().getExtras().getString("row"));
        colNum=Integer.parseInt(getIntent().getExtras().getString("col"));
        Object[] objectArray = (Object[]) getIntent().getExtras().getSerializable("key_array_array");
        if(objectArray!=null){
            arrayReceived = new int[objectArray.length][];
            for(int i=0;i<objectArray.length;i++){
                arrayReceived[i]=(int[]) objectArray[i];
            }
        }
        createTheThing(arrayReceived);
    }
    void createTheThing(int[][] mat2) {

        gridLayout3 = (GridLayout) findViewById(R.id.grid3);
        gridLayout3.removeAllViews();
        gridLayout3.setRowCount(rowNum);
        gridLayout3.setColumnCount(colNum);
        editTexts3 = new EditText[rowNum][colNum];
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                editTexts3[i][j] = new EditText(this);
                setPos(editTexts3[i][j], i, j);
                editTexts3[i][j].setText(String.valueOf(mat2[i][j]));
                gridLayout3.addView(editTexts3[i][j]);
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
}