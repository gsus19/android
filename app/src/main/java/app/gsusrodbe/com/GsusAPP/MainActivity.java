package app.gsusrodbe.com.GsusAPP;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import app.gsusrodbe.com.codigofacilito.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button registrarse;
    EditText nombre;
    EditText apellido;
    Button consulta;
    SQLiteDatabase db;
    TextView textView;
    TextView textView2;
    List<String> lista;
    TextView textView3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);






        registrarse = (Button) findViewById(R.id.datos);
        registrarse.setOnClickListener(this);

        nombre = (EditText) findViewById(R.id.nombre);
        apellido = (EditText) findViewById(R.id.apellido);

        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3= (TextView) findViewById(R.id.textView3) ;


        consulta = (Button) findViewById(R.id.consulta);
        consulta.setOnClickListener(this);

        Typeface myTypeFace= Typeface.createFromAsset(this.getAssets(),"game.ttf");
        textView3.setTypeface(myTypeFace);

        nombre.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    nombre.setHint("");
                else
                    nombre.setHint("Nombre");
            }
        });
        apellido.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    apellido.setHint("");
                else
                    apellido.setHint("Apellido");
            }
        });
    }


    @Override
    public void onClick(View v) {
        DBpersonas personas = new DBpersonas(this, "DBpersonas", null, 1);
        db = personas.getWritableDatabase();


        switch ((v.getId())) {

            case R.id.datos:



                db.execSQL("INSERT INTO personas (nombre, apellido) VALUES ('" + nombre.getText() + "','" + apellido.getText() + "')");


                Intent intent2 = new Intent(MainActivity.this, SecondActivity.class);
                String name = nombre.getText().toString();
                nombre.setText("");
                intent2.putExtra("NOMBRE", name);

                String lastName = apellido.getText().toString();
                intent2.putExtra("APELLIDO", lastName);
                apellido.setText("");
                startActivity(intent2);

                break;

            case R.id.consulta:


                Cursor c = db.rawQuery("SELECT * FROM Personas ", null);
                if (c.moveToFirst()) {
                    lista = new ArrayList<String>();

                    do {

                        Integer codigo = c.getInt(0);
                        String nombre = c.getString(1);
                        String apellido = c.getString(2);
                        lista.add(" " + codigo.toString() + " " + nombre + " " + apellido + "\n");

                    } while (c.moveToNext());

                    Intent intent3 = new Intent(MainActivity.this, Consulta.class);
                    intent3.putExtra("LISTA", (ArrayList<String>) lista);
                    startActivity(intent3);


                    }

                }
        }
    }



