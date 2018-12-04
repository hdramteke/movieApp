package movieapp.project.com.movieapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import movieapp.project.com.movieapp.R;
import movieapp.project.com.movieapp.activity.InformationActivity;
import movieapp.project.com.movieapp.model.movie;

/**
 * Created by hemant on 7/11/18.
 */

public class detailsAdapter extends PagerAdapter {

    private Context context;
    private  String images;
    List<movie> movies = new ArrayList<>();


    public detailsAdapter(Context context, String images){
        this.context = context;
        this.images = images;
    }
    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.custom_layout,null);
        ImageView imageView = view.findViewById(R.id.imageView);

        Glide.with(container.getContext()).load(images).into(imageView);

        ViewPager vp = (ViewPager) container;
        vp.addView(view,0);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), InformationActivity.class);
                v.getContext().startActivity(intent);
            }
        });

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);


    }
}
