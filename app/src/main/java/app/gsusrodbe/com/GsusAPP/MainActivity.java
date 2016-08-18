package app.gsusrodbe.com.GsusAPP;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;

import app.gsusrodbe.com.codigofacilito.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button registrarse;
    EditText nombre;
    EditText apellido, usuario, password, email, edad, favorito;
    Button consulta;

    TextView textView;
    TextView textView2;
    List<String> lista;
    TextView textView3;
    String json_url = "https://jesusjrod19.cloudant.com/got";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);






        registrarse = (Button) findViewById(R.id.datos);
        registrarse.setOnClickListener(this);

        nombre = (EditText) findViewById(R.id.nombre);
        apellido = (EditText) findViewById(R.id.apellido);
        usuario = (EditText)findViewById(R.id.usuario);
        password = (EditText)findViewById(R.id.password);
        password.setTransformationMethod(new PasswordTransformationMethod());
        edad = (EditText)findViewById(R.id.edad);
        email = (EditText)findViewById(R.id.email);
        favorito = (EditText)findViewById(R.id.favorito);




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
        usuario.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    usuario.setHint("");
                else
                    usuario.setHint("Usuario");
            }
        });
        password.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    password.setHint("");
                else
                    password.setHint("Password");
            }
        });
        edad.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    edad.setHint("");
                else
                    edad.setHint("Edad");
            }
        });
        favorito.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    favorito.setHint("");
                else
                    favorito.setHint("Favorito");
            }
        });
        email.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    email.setHint("");
                else
                    email.setHint("Email");
            }
        });
    }


    @Override
    public void onClick(View v) {


        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        switch ((v.getId())) {

            case R.id.datos:


                String nom = nombre.getText().toString();
                String ape = apellido.getText().toString();
                String usu = usuario.getText().toString();
                String pas = password.getText().toString();
                String ed = edad.getText().toString();
                String fav = favorito.getText().toString();
                String ema = email.getText().toString();

                String id = usuario.getText().toString();

                HashMap<String,Object> map=new HashMap<String, Object>();
                map.put("_id",id);
                map.put("nombre", nom );
                map.put("apellido",ape);
                map.put("usuario",usu);
                map.put("password",pas);
                map.put("edad",ed);
                map.put("favorito",fav);
                map.put("email",ema);




                final JsonObjectRequest registro = new JsonObjectRequest(Request.Method.POST, json_url, new JSONObject(map),
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {

                                try {
                                    JSONObject jsonObject = new JSONObject(response.toString());

                                    //REV = jsonObject.getString("rev");
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Try Again ....", Toast.LENGTH_SHORT).show();
                        error.printStackTrace();
                    }
                }


                );



                requestQueue.add(registro);





        }
                /*db.execSQL("INSERT INTO personas (nombre, apellido) VALUES ('" + nombre.getText() + "','" + apellido.getText() + "')");


                Intent intent2 = new Intent(MainActivity.this, SecondActivity.class);
                String name = nombre.getText().toString();
                nombre.setText("");
                intent2.putExtra("NOMBRE", name);

                String lastName = apellido.getText().toString();
                intent2.putExtra("APELLIDO", lastName);
                apellido.setText("");
                startActivity(intent2);*/



           // case R.id.consulta:


               /* Cursor c = db.rawQuery("SELECT * FROM Personas ", null);
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
                    startActivity(intent3);*/


                    }

                }





