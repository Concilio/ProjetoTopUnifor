package br.unifor.ilikemyheadphone;

import android.content.Intent;
//import android.support.v4.widget.SearchViewCompatIcs;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;


public class MainActivity extends ActionBarActivity {

    TextView textViewRegistro;
    TextView textViewEsqueceuSenha;

    List<FeedUsuario> feed;
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewRegistro = (TextView) findViewById(R.id.textViewRegistro);
        textViewEsqueceuSenha = (TextView) findViewById(R.id.textViewEsqueceuSenha);

//        listview = (ListView) findViewById(R.id.customlist);
//
//        MyCustomAdapter adapter = new MyCustomAdapter(this, feed);
//
//        listview.setAdapter(adapter);



        //Método para fazer a linha sublinhada
        putUnderline();

    }


        //Método que implementa a criação das linhas sublinhadas
    public void putUnderline(){
        String registro = textViewRegistro.getText().toString();
        SpannableString content = new SpannableString(registro);
        content.setSpan(new UnderlineSpan(), 0, registro.length(), 0);
        textViewRegistro.setText(content);

        String recSenha = textViewEsqueceuSenha.getText().toString();
        SpannableString content2 = new SpannableString(recSenha);
        content2.setSpan(new UnderlineSpan(), 0, recSenha.length(), 0);
        textViewEsqueceuSenha.setText(content2);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void registrarConta(View v){

        Intent intent = new Intent(this, RegistroActivity.class);
        startActivity(intent);

    }

    public void recSenha(View v){

        Intent intent = new Intent(this, RecSenhaActivity.class);
        startActivity(intent);

    }

    public void entrarListView(View v){

        Intent intent = new Intent(this, ListViewActivity.class);
        startActivity(intent);

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
