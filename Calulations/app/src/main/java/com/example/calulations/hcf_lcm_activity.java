package com.example.calulations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class hcf_lcm_activity extends AppCompatActivity {
    int[] nums;
    int hcf;
    long lcm;
    double variance,sd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hcf_lcm_activity);
    }


    protected void populate(){
        EditText entry=findViewById(R.id.numberEntryText);
        String[] ent=entry.getText().toString().split(" ");
        nums=new int[ent.length];
        for(int i=0;i<ent.length;i++){
            nums[i]=Integer.parseInt(ent[i]);
        }
    }

    static int gcd(int a, int b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }


    static int findGCD(int arr[], int n)
    {
        int result = 0;
        for (int element: arr){
            result = gcd(result, element);

            if(result == 1)
            {
                return 1;
            }
        }
        return result;
    }



    public static long lcm_of_array_elements(int[] element_array)
    {
        long lcm_of_array_elements = 1;
        int divisor = 2;

        while (true) {
            int counter = 0;
            boolean divisible = false;

            for (int i = 0; i < element_array.length; i++) {
                if (element_array[i] == 0) {
                    return 0;
                }
                else if (element_array[i] < 0) {
                    element_array[i] = element_array[i] * (-1);
                }
                if (element_array[i] == 1) {
                    counter++;
                }
                if (element_array[i] % divisor == 0) {
                    divisible = true;
                    element_array[i] = element_array[i] / divisor;
                }
            }

            if (divisible) {
                lcm_of_array_elements = lcm_of_array_elements * divisor;
            }
            else {
                divisor++;
            }
            if (counter == element_array.length) {
                return lcm_of_array_elements;
            }
        }
    }

    static double variance(int a[], int n)
    {
        double sum = 0;
        for (int i = 0; i < n; i++)
            sum += a[i];
        double mean = (double)sum/(double)n;

        double sqDiff = 0;
        for (int i = 0; i < n; i++)
            sqDiff += (a[i] - mean) * (a[i] - mean);
        return (double)sqDiff/n;
    }


    public void calculateHCF(View view) {
        populate();
        TextView ress=findViewById(R.id.hcfPageResultLbl);
        hcf=findGCD(nums,nums.length);

        StringBuilder x=new StringBuilder("HCF : ");
        x.append(hcf);
        ress.setText(x);
    }

    public void calculateLCM(View view) {
        populate();
        TextView ress=findViewById(R.id.hcfPageResultLbl);
        lcm=lcm_of_array_elements(nums);

        StringBuilder x=new StringBuilder("LCM : ");
        x.append(lcm);
        ress.setText(x);
    }

    public void calculateVariance(View view) {
        populate();
        variance=variance(nums,nums.length);
        TextView ress=findViewById(R.id.hcfPageResultLbl);

        StringBuilder x=new StringBuilder("Variance : ");
        x.append(variance);
        ress.setText(x);
    }

    public void calulateSD(View view) {
        populate();
        variance=variance(nums,nums.length);
        sd=Math.sqrt(variance);
        TextView ress=findViewById(R.id.hcfPageResultLbl);

        StringBuilder x=new StringBuilder("Standard Deviation : ");
        x.append(sd);
        ress.setText(x);
    }
}