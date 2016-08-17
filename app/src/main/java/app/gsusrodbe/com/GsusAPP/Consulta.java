package app.gsusrodbe.com.GsusAPP;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import app.gsusrodbe.com.codigofacilito.R;

public class Consulta extends AppCompatActivity {


    TextView textView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);

        textView2 = (TextView) findViewById(R.id.textView2);

       /* Intent intent3= getIntent();
        Bundle extras = intent3.getExtras();*/


        ArrayList<String> lista = (ArrayList<String>) getIntent().getSerializableExtra("LISTA");


        textView2.setText("");

        Typeface myTypeFace= Typeface.createFromAsset(this.getAssets(),"comici.ttf");
        textView2.setTypeface(myTypeFace);

        if (lista != null) {


            int listSize = lista.size();
            for (int i = 0; i < listSize; i++) {
                textView2.append(lista.get(i));
                //Log.i("", lista.get(i));
            }

           /* for (String list : lista){


                textView2.setText(list.toString());


            }
        }else textView2.setText("");*/

/*
        Bundle extras = getIntent().getExtras();
        List lista = intent.getSaraza("lista");
        for(String nombre : lista){

            textview.setText */
        }
    }
}





