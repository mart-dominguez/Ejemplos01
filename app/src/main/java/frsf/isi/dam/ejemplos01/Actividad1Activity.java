package frsf.isi.dam.ejemplos01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Actividad1Activity extends AppCompatActivity {

    private static final int CODIGO_BUSCAR_PRODUCTO = 987;

    EditText edtLetra;
    Button btnBuscarDatos;
    TextView datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad1);
        edtLetra = (EditText) findViewById(R.id.edtPrimerLetra);
        datos = (TextView) findViewById(R.id.dato);
        btnBuscarDatos = (Button) findViewById(R.id.btnBuscarDato);
        btnBuscarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Actividad1Activity.this,Actividad2Activity.class);
                i.putExtra("primerLetra",edtLetra.getText().toString());
                startActivityForResult(i,CODIGO_BUSCAR_PRODUCTO);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Log.d("CLASE04","resultCode: "+resultCode+" == "+Activity.RESULT_OK);
        Log.d("CLASE04","requestCode: "+requestCode+" == "+CODIGO_BUSCAR_PRODUCTO);
        if( resultCode== Activity.RESULT_OK){
            if(requestCode==CODIGO_BUSCAR_PRODUCTO){
                String producto = data.getExtras().getString("producto");
                Integer cantidad = data.getExtras().getInt("cantidad");
                datos.setText("SELECCIONO <"+producto+"> Cantidad: "+cantidad+" unidades");
            }
        }
    }
}
