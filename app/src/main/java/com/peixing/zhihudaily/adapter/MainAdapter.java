package com.peixing.zhihudaily.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.peixing.zhihudaily.R;
import com.peixing.zhihudaily.ui.DetailActivity;
import com.peixing.zhihudaily.utils.GlideUtils;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A custom adapter to use with the RecyclerView widget.
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {


    private Context context;
    private ArrayList<HashMap<String, String>> store;

    public MainAdapter(Context context, ArrayList<HashMap<String, String>> list) {
        this.context = context;
        this.store = list;
    }

    public void setdata(ArrayList<HashMap<String, String>> list) {
        this.store = list;
        this.notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_layout_store, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder itemViewHolder, final int position) {

        //Here you can fill your row view
        itemViewHolder.tvWord.setText(store.get(position).get("title"));
        GlideUtils.LoadPic(context, store.get(position).get("image"), itemViewHolder.ivSrc);
        itemViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(context, store.get(position).get("title"), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("title", store.get(position).get("title"));
                intent.putExtra("id", store.get(position).get("id"));
                intent.putExtra("image", store.get(position).get("image"));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return store.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvWord;
        private ImageView ivSrc;

        public ViewHolder(View itemView) {
            super(itemView);
            tvWord = (TextView) itemView.findViewById(R.id.tv_word);
            ivSrc = (ImageView) itemView.findViewById(R.id.iv_src);

        }
    }
}
