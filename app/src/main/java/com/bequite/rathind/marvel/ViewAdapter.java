package com.bequite.rathind.marvel;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.CustomViewHolder> {
    private Context context;

    public ViewAdapter(Context context, List<ResulList> dataList){
        this.context = context;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        //inflate our view holder
        LayoutInflater inflater = LayoutInflater.from(context);
        View view1 = inflater.inflate(R.layout.preview_data,null);
        return new CustomViewHolder(view1);
    }

    @Override
    public void onBindViewHolder( CustomViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {


        private ImageView previewImage;

        CustomViewHolder(View itemView) {
            super(itemView);
            previewImage = itemView.findViewById(R.id.prvImage);

        }
    }
}
