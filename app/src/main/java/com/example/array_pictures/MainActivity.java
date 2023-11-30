package com.example.array_pictures;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    protected void onCreate (Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button contentButton = new Button(this);
        contentButton.setText(R.string.contentButtonText);
        contentButton.setBackgroundColor(+R.color.crimson);

        LinearLayout layoutCenterArrayPic = findViewById(R.id.layoutCenterArrayPic);
        layoutCenterArrayPic.addView(contentButton);

        contentButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View button) {

                LinearLayout gameRowContainer1 = findViewById(R.id.gameRowContainer1);
                LinearLayout gameRowContainer2 = findViewById(R.id.gameRowContainer2);
                LinearLayout gameRowContainer3 = findViewById(R.id.gameRowContainer3);


                List<LinearLayout> gameRowContainers = new ArrayList<>();
                gameRowContainers.add(gameRowContainer1);
                gameRowContainers.add(gameRowContainer2);
                gameRowContainers.add(gameRowContainer3);


                //para agarrar los numeros aleatoriamente, necesito un num aleatorio

                int numeroAleatorio = (int) (Math.random() * gameRowContainers.size());
                LinearLayout selectedGameRowContainer = gameRowContainers.get(numeroAleatorio);

                LinearLayout layoutCenterRowsContainer = findViewById(R.id.layoutCenterRowsContainer);




                CharSequence msg = "Estado actualizado";
                Toast toast = Toast.makeText(contentButton.getContext(), msg, Toast.LENGTH_SHORT);
                toast.show();

                ImageView newImage = new ImageView(button.getContext());
                newImage.setImageDrawable(((ImageView) selectedGameRowContainer.getChildAt(0)).getDrawable());
                layoutCenterRowsContainer.addView(newImage);

                TextView newText = new TextView(button.getContext());
                newText.setText(((TextView) selectedGameRowContainer.getChildAt(1)).getText());
                layoutCenterRowsContainer.addView(newText);




            }
        });

    }
}