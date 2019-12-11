package com.example.owneruser.calculatorapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    //inputs
    private EditText abwPrevious;
    private EditText abwPresent;
    private EditText daysOfCulture;
    private EditText stackingDensity;
    private EditText totalFeedConsumed;
    private EditText dailyFeedRation;
    private EditText foodConsumed;

    //the button
    private Button calculate;

    // outputs
    private TextView biomassPrevious;
    private TextView biomassPresent;
    private TextView biomassGain;
    private TextView feedingRate;
    private TextView growthGain;
    private TextView growthIncrement;
    private TextView feedConversionRatio;



// FORMULAE:
 //   Biomass Formula:        (ABW * SD) / 1000

 //   Growth Gain:            ABW[present] - ABW[previous]

 //   Growth Increment:       GG / DOC

 //   Biomass Gain:           Biomass[present] - Biomass[previous]

 //   OR

 //           ( GG * SD ) / 1000

 //   Feeding Rate:           (DFR / Biomass[present]) * 100

 //   FCR:                    (TFC * Bags) / BG

 //   Production Cost:        Price of Feeds [per kilo] * FCR


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        abwPrevious = (EditText)findViewById(R.id.inputABWprev);
        abwPresent = (EditText)findViewById(R.id.inputABWpresent);
        stackingDensity = (EditText) findViewById(R.id.inputSD);
        daysOfCulture = (EditText) findViewById(R.id.inputDOC);
        totalFeedConsumed = (EditText) findViewById(R.id.inputTFC);
        dailyFeedRation = (EditText)findViewById(R.id.inputDFR);
        foodConsumed = (EditText)findViewById(R.id.inputFCG);


        calculate = (Button)findViewById(R.id.btnCalculate);


        biomassPrevious = (TextView)findViewById(R.id.outputBiomassPrevious);
        biomassPresent = (TextView)findViewById(R.id.outputBiomassPresent);
        biomassGain = (TextView) findViewById(R.id.outputBiomassGain);
        feedingRate = (TextView)findViewById(R.id.outputFeedingRate);
        growthGain = (TextView)findViewById(R.id.outputGrowthGain);
        growthIncrement = (TextView)findViewById(R.id.outputGrowthIncrement);
        feedConversionRatio = (TextView)findViewById(R.id.outputFCR);


        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //convert to numbers that can be calculated
                float abwPrev = Float.parseFloat(abwPrevious.getText().toString());
                float abwPres = Float.parseFloat(abwPresent.getText().toString());
                float stackDens = Float.parseFloat(stackingDensity.getText().toString());
                int daysOC = Integer.parseInt(daysOfCulture.getText().toString());
                float totalFC = Float.parseFloat(totalFeedConsumed.getText().toString());
                float dailyFR = Float.parseFloat(dailyFeedRation.getText().toString());
                float foodCG = Float.parseFloat(foodConsumed.getText().toString());

                //calculations
                float biomassPrev = ((abwPrev * stackDens) / 1000 ) ;
                float biomassPres = ((abwPres * stackDens) / 1000 ) ;
                float bg = biomassPres - biomassPrev;
                float gg = abwPres - abwPrev;
                float gi = gg / daysOC;
                float fr = (dailyFR / biomassPres  * 100);
                float fcr = foodCG / gg;



                //set results
                biomassPrevious.setText(String.valueOf(biomassPrev));
                biomassPresent.setText(String.valueOf(biomassPres));
                biomassGain.setText(String.valueOf(bg));
                growthGain.setText(String.valueOf(gg));
                growthIncrement.setText(String.valueOf(gi));
                feedingRate.setText(String.valueOf(fr));
                feedConversionRatio.setText(String.valueOf(fcr));



            }
        });

    }
}
