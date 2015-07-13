package br.unifor.ilikemyheadphone;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public class VerReviewActivity extends ActionBarActivity {

    TextView textViewComentario;
    TextView editTextModelo, editTextMarca;
    ImageView imageViewFoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_review);

        textViewComentario = (TextView) findViewById(R.id.editTextComentario);
        editTextMarca = (TextView) findViewById(R.id.editTextMarca);
        editTextModelo = (TextView) findViewById(R.id.editTextModelo);
        imageViewFoto = (ImageView) findViewById(R.id.imageViewFoto);

        Intent intent = getIntent();
        String comment = intent.getStringExtra(MyCustomAdapter.COMENTARIO_EXTRA);
        String marca = intent.getStringExtra(MyCustomAdapter.MODELO_EXTRA);
        String modelo = intent.getStringExtra(MyCustomAdapter.MARCA_EXTRA);
        int foto = intent.getIntExtra(MyCustomAdapter.FOTO_EXTRA, 0); // 0 signiifca que caso retorne um erro retornará 0

        textViewComentario.setText(comment);
        editTextMarca.setText(marca);
        editTextModelo.setText(modelo);
        imageViewFoto.setImageResource(foto);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ver_review, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
