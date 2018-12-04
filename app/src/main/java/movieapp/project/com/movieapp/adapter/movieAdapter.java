package movieapp.project.com.movieapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import movieapp.project.com.movieapp.R;
import movieapp.project.com.movieapp.activity.DetailsActivity;
import movieapp.project.com.movieapp.model.movie;

/**
 * Created by hemant on 22/10/18.
 */

public class movieAdapter extends RecyclerView.Adapter<movieAdapter.ViewHolder>{
    Context context;
    List<movie> movies;


    public interface Listener{
        void onCartSelected(int position);
    }
    public movieAdapter(List<movie> movies,Context context){
        this.context = context;
        this.movies = movies;

    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
     LinearLayout layout =(LinearLayout) inflater.inflate(R.layout.movie_list_item,null);
        return new ViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final movie movie = movies.get(position);
        holder.textTitle.setText("Title - "+movie.getTitle());
        holder.textDate.setText("Date - "+movie.getRealeaseDate());

        if(movie.getAdult() == true){
            holder.textRating.setText("Rating - " + "(A)");
        }else
        {
            holder.textRating.setText("Rating - " + "(U/A)");
        }

        Glide.with(holder.imageView.getContext()).load(movie.getPosterPath()).into(holder.imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DetailsActivity.class);
                intent.putExtra("Movie",movie);
                v.getContext().startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textTitle,textDate,textRating;
        public ViewHolder(View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.textTitle);
            textDate = itemView.findViewById(R.id.date);
            textRating = itemView.findViewById(R.id.rating);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }

}
