package com.example.customlistview_with_simpleadapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ListView simpleListView;
    String []animalName={"this is a tiger","this is a bear","this is a elephant"};
    int []animalImages={R.drawable.tiger,R.drawable.bear,R.drawable.elephant};
    String []number={"12345","678910","12345"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

       simpleListView =(ListView) findViewById(R.id.simpleListView);

       //setting up a arraylist with hashmap parameters
        ArrayList<HashMap<String,String>> array_List= new ArrayList<>();
        for(int  i=0;i<animalName.length;i++)
        {

            HashMap<String,String> hashmap = new HashMap<>();
            hashmap.put("name",animalName[i]);
            hashmap.put("image",animalImages[i]+"");
            hashmap.put("number",number[i]);
            array_List.add(hashmap);

        }

        //key of the animal name and images arrays of hashmap
String [] from={"name","image","number"};
        //custom layout textview and imageview id
        int []to={R.id.textView,R.id.imageView,R.id.textView2};


        SimpleAdapter simpadaptr = new SimpleAdapter(this,array_List,R.layout.custom_layout,from,to);
        simpleListView.setAdapter(simpadaptr);


        simpleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                String animal_name = animalName[position];
                String num= number[position];
                int imageID=animalImages[position];
                Intent i = new Intent(getApplicationContext(), newActivity.class);

                i.putExtra("name",animal_name);
                i.putExtra("number",num);
                i.putExtra("image",imageID);
                startActivity(i);

                Toast.makeText(getApplicationContext(),animalName[position],Toast.LENGTH_LONG).show();
            }
        });


    }
}