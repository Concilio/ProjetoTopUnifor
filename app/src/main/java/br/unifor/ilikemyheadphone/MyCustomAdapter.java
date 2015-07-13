package br.unifor.ilikemyheadphone;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import javax.microedition.khronos.egl.EGLDisplay;

/**
 * Created by labm4 on 10/07/2015.
 */
public class MyCustomAdapter extends BaseAdapter{

    private Context context;
    private LayoutInflater inflater;
    private List<FeedUsuario> feeds;
    private FeedUsuario feedUsuario;
    public static final String COMENTARIO_EXTRA = "comentario";
    public static final String MARCA_EXTRA = "marca";
    public static final String MODELO_EXTRA = "modelo";
    public static final String FOTO_EXTRA = "foto" ;



//    public MyCustomAdapter(Context context, List<FeedUsuario> feeds) {
//        this.context = context;
//        //this.inflater = inflater;
//        this.feeds = feeds;
//    }


    public MyCustomAdapter(Context context, List<FeedUsuario> feeds) {
        this.feeds = feeds;
        this.context = context;
        this.inflater = LayoutInflater.from(this.context);
    }



    public List<FeedUsuario> getFeeds() {
        return feeds;
    }

    public void setFeeds(List<FeedUsuario> feeds) {
        this.feeds = feeds;
    }

    public Context getContext() {
        return context;
    }



    public LayoutInflater getInflater() {
        return inflater;
    }

    @Override
    public int getCount() {
        return this.feeds.size();
    }

    @Override
    public FeedUsuario getItem(int position) {
        return this.feeds.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView  , ViewGroup parent){

        final FeedUsuario feed = this.feeds.get(position);
        MyViewHolder viewHolder;

        if(convertView == null){

            convertView =  inflater.inflate(R.layout.activity_custom_list, parent, false);
            viewHolder = new MyViewHolder(convertView);
            convertView.setTag(viewHolder);

        }else{

            viewHolder = (MyViewHolder) convertView.getTag();

        }



        //Criar classe Feed com as informações do feed
        viewHolder.comentario.setText(feed.getComentario());
        viewHolder.marca.setText(feed.getMarca());
        viewHolder.modelo.setText(feed.getModelo());
        viewHolder.foto.setImageResource(feed.getFoto());
        viewHolder.ratingBar.setRating(feed.getNota());


        viewHolder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,VerReviewActivity.class);
                intent.putExtra(COMENTARIO_EXTRA,feed.getComentario());
                intent.putExtra(MARCA_EXTRA,feed.getMarca());
                intent.putExtra(MODELO_EXTRA,feed.getModelo());
                intent.putExtra(FOTO_EXTRA,feed.getFoto());
                context.startActivity(intent);
            }
        });



        return convertView;
    }


    private class MyViewHolder{ // ViewHolder é quem exibe de fato na tela

        TextView comentario; // marca, modelo;
        TextView marca,modelo;
        ImageView foto;
        Button button;
        RatingBar ratingBar;

        public MyViewHolder(View v) {
            this.comentario = (TextView)v.findViewById(R.id.textViewComment);

            this.foto = (ImageView)v.findViewById(R.id.imageViewFoto);

            this.button = (Button) v.findViewById(R.id.button);

            this.marca = (TextView) v.findViewById(R.id.editTextMarca);

            this.modelo = (TextView) v.findViewById(R.id.editTextModelo);

            this.ratingBar = (RatingBar) v.findViewById(R.id.ratingBar);


        }


    }


}
