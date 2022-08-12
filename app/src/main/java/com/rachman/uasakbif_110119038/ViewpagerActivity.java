package com.rachman.uasakbif_110119038;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
/**
 * Identitas Diri
 * NIM  : 10119038
 * Kelas: IF-1
 * Nama : Rachman Aldiansyah
 */
public class ViewpagerActivity extends AppCompatActivity {

    ViewPager viewPager;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);

        // pasang adapter ke viewpager
        setupViewPager();
    }

    private void setupViewPager() {
        adapter = new Adapter(this);
        viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);
    }

    private class Adapter extends PagerAdapter {
        Context context;
        LayoutInflater inflater;

        public Adapter(Context context) {
            this.context = context;
        }

        // list image
        int[] list_img = {
                R.drawable.viewpager_content_1,
                R.drawable.viewpager_content_2
        };

        // list title
        int[] list_title = {
                R.string.title_1,
                R.string.title_2
        };

        // list description
        int[] list_desc = {
                R.string.desc_1,
                R.string.desc_2
        };

        // list color bg
        int[] list_color = {
                getResources().getColor(R.color.white),
                getResources().getColor(R.color.white)
        };

        @Override
        public int getCount() {
            return list_title.length;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return (view == object);
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.layout_item,container,false);
            LinearLayout linearLayout = view.findViewById(R.id.layout_item);
            ImageView imageView = view.findViewById(R.id.img);
            TextView title = view.findViewById(R.id.title);
            TextView desc = view.findViewById(R.id.desc);

            linearLayout.setBackgroundColor(list_color[position]);
            imageView.setImageResource(list_img[position]);
            title.setText(list_title[position]);
            desc.setText(list_desc[position]);

            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((LinearLayout)object);
        }
    }

    public void userLogin(View view) {
        Intent intent = new Intent(ViewpagerActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}