package br.unifor.ilikemyheadphone;

import android.content.Intent;
import android.support.v4.app.ListFragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class ListViewActivity extends ActionBarActivity {

    public static List<FeedUsuario> feed = new ArrayList<>();
            //= new ArrayList<>();
    ListView listview;
    FeedUsuario feedUsuario;
    //public static final String IMG_EXTRA = "imagem";
    public static final String COMENTARIO_EXTRA = "comentario";
    public static int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

//        ListFragment fragment = new ListFragment();

        this.feed = getFeed();

        listview = (ListView) findViewById(R.id.customlist);

        MyCustomAdapter adapter = new MyCustomAdapter(this, getFeed());

        listview.setAdapter(adapter);

    }

    public List<FeedUsuario> getFeed(){
        if(flag == 0){

        feed.add( new FeedUsuario("bla bla bla", "Sony", "SO0001",1,R.drawable.ic_user_photo));
        feed.add(new FeedUsuario("ble le ble", "LG", "LG001",2,R.drawable.ic_headphone_icon));
        feed.add(new FeedUsuario("bli bli bli", "Samsung", "Sam01",3,R.drawable.ic_charliesheen_1024x775));
        feed.add(new FeedUsuario("blo blo blo", "Beats", "BBD01",4,R.drawable.ic_user_photo));
        feed.add(new FeedUsuario("blu blu blu", "Multilaser", "Mult10",5,R.drawable.ic_charliesheen_1024x775));
        flag = 1;
        }

//        List<FeedUsuario> feed = new ArrayList<>();
//        feed.add(new FeedUsuario("Bla bla", R.drawable.ic_charliesheen_1024x775));
//        feed.add(new FeedUsuario("Ble ble", R.drawable.ic_user_photo));
//        feed.add( new FeedUsuario("bla bla bla", "Sony", "SO0001",1,R.drawable.ic_user_photo));
//        feed.add(new FeedUsuario("ble le ble", "LG", "LG001",2,R.drawable.ic_headphone_icon));
//        feed.add(new FeedUsuario("bli bli bli", "Samsung", "Sam01",3,R.drawable.ic_charliesheen_1024x775));
//        feed.add(new FeedUsuario("blo blo blo", "Beats", "BBD01",4,R.drawable.ic_user_photo));
//        feed.add(new FeedUsuario("blu blu blu", "Multilaser", "Mult10",5,R.drawable.ic_charliesheen_1024x775));
        //feed.add(new FeedUsuario("Bla bla", R.drawable.ic_charliesheen_1024x775));
//        feed.add(new FeedUsuario("Ble ble"));
        return feed;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_view, menu);
        return true;
    }

    public void verReview(View v){

//        getFeed();
//        String comment = feedUsuario.getComentario();

//        Intent intent = new Intent(this, VerReviewActivity.class);
////        intent.putExtra(COMENTARIO_EXTRA, comment);
//        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_new) {
            Intent intent = new Intent(this,EnviarReviewActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
