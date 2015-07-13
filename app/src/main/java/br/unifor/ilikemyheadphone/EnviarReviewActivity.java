package br.unifor.ilikemyheadphone;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;


public class EnviarReviewActivity extends ActionBarActivity {

    EditText marca, modelo, comentario;
    Button enviar;
    RatingBar ratingBar;

    FeedUsuario feedUsuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enviar_review);

        comentario = (EditText) findViewById(R.id.editTextComentario);
        marca = (EditText) findViewById(R.id.editTextMarca);
        modelo = (EditText) findViewById(R.id.editTextModelo);

        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        enviar = (Button) findViewById(R.id.buttonEnviar);

    }

    public void postarReview(View v){

        Intent intent = new Intent(this, ListViewActivity.class );
        ListViewActivity.feed.add(new FeedUsuario(comentario.getText().toString(), marca.getText().toString(),modelo.getText().toString()
            ,ratingBar.getRating(),R.drawable.ic_charliesheen_1024x775));
        startActivity(intent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_enviar_review, menu);
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
