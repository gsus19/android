package app.gsusrodbe.com.GsusAPP;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import app.gsusrodbe.com.codigofacilito.R;

public class SecondActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textView=(TextView)findViewById(R.id.textView);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        Typeface myTypeFace= Typeface.createFromAsset(this.getAssets(),"game.ttf");
        textView.setTypeface(myTypeFace);

        if(extras!=null){
            String nombre = extras.getString("NOMBRE");
            String apellido = extras.getString("APELLIDO");
            textView.setText("Hola " +nombre +"  " +apellido + " Gracias por unirte a la Casa Stark el Rey del Norte te lo agradece");

        }
    }
}
