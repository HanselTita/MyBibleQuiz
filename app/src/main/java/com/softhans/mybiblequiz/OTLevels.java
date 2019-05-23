package com.softhans.mybiblequiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class OTLevels extends AppCompatActivity {

    ImageButton level1;
    ImageButton level2;
    ImageButton level3;
    ImageButton level4;
    ImageButton level5;

    //TODO: for the rest of the levels.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ot_levels);

        level1 = (ImageButton) findViewById(R.id.levelOne);
        level2 = (ImageButton) findViewById(R.id.levelTwo);

        //TODO for the rest of the levels.

        level1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OTLevels.this, Level01.class));

            }
        });


       level2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OTLevels.this, Level02.class));

            }
        });
        /* level3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OTLevels.this, Level03.class));

            }
        });
        level4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OTLevels.this, Level04.class));

            }
        });
        level5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OTLevels.this, Level05.class));

            }
        });
            //TODO same for all levels.

*/





    }
}
