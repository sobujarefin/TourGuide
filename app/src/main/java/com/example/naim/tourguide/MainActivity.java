package com.example.naim.tourguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

public class MainActivity extends AppCompatActivity {
    GridLayout mainGrid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainGrid = (GridLayout) findViewById(R.id.mainGrid);

        setToggleEvent(mainGrid);
    }
    private void setToggleEvent(GridLayout mainGrid) {
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            CardView cardView = (CardView) mainGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this,City.class);
                    if(finalI==0)
                    {
                        intent.putExtra("city","Rajshahi");
                    }
                    else if(finalI==1)
                    {
                        intent.putExtra("city","Dhaka");
                    }
                    else if(finalI==2)
                    {
                        intent.putExtra("city","Rangpur");
                    }
                    else if(finalI==3)
                    {
                        intent.putExtra("city","Shylet");
                    }
                    else if(finalI==4)
                    {
                        intent.putExtra("city","Khulna");
                    }
                    else if(finalI==5)
                    {
                        intent.putExtra("city","Chittagong");
                    }
                    else if(finalI==6)
                    {
                        intent.putExtra("city","Comilla");
                    }
                    else if(finalI==7)
                    {
                        intent.putExtra("city","Barishal");
                    }
                    else
                    {
                        intent.putExtra("city","Mymenshingh");
                    }
                    startActivity(intent);
                }
            });
        }
    }

}
