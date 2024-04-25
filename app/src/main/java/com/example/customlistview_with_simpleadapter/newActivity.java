package com.example.customlistview_with_simpleadapter;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class newActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_new);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        TextView tv1 = findViewById(R.id.text1);
        TextView tv2 = findViewById(R.id.text2);
        ImageView img=findViewById(R.id.image);

        img.setImageResource(getIntent().getExtras().getInt("image"));

        tv1.setText(getIntent().getExtras().getString("name"));

        tv2.setText(getIntent().getExtras().getString("number"));





    }
}