package com.example.spellbook;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import io.vavr.collection.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
    private String[] mDataset;
    private List<String> mData;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public ConstraintLayout frameLayout;
        public MyViewHolder(ConstraintLayout v){
            super(v);
            frameLayout = v;
        }
    }

//    public MyAdapter(String[] myDataset) {
//        mDataset = myDataset;
//    }

    public MyAdapter(List<String> data) {
        mData = data;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ConstraintLayout v =(ConstraintLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item_info, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        TextView tv = holder.frameLayout.findViewById(R.id.spellNameTextview);
        tv.setText(mData.get(position));
//        holder.textView.setText(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.length();
    }
}
