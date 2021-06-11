package com.rhappdeveloper.inventoryapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.rhappdeveloper.inventoryapp.DetailsActivity;
import com.rhappdeveloper.inventoryapp.R;
import com.rhappdeveloper.inventoryapp.model.PartObject;
import com.rhappdeveloper.inventoryapp.view.ItemClickListener;

import java.util.List;

public class PartListAdapter extends RecyclerView.Adapter<PartListAdapter.PartViewHolder>{
    Context mContext;
    List<PartObject> partObjectList;

    public PartListAdapter(Context mContext, List<PartObject> partObjectList) {
        this.mContext = mContext;
        this.partObjectList = partObjectList;
    }

    @NonNull
    @Override
    public PartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.row_item_layout, parent, false);
        return new PartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PartListAdapter.PartViewHolder holder, int position) {
        PartObject partObject = partObjectList.get(position);
        holder.bind(partObject);

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                Intent i=new Intent(mContext, DetailsActivity.class);
                i.putExtra("partObject", partObject);
                mContext.startActivity(i);
            }
        });
//        holder.itemView.setOnClickListener(v -> {
//            boolean expanded = partObject.isExpanded();
//            partObject.setExpanded(!expanded);
//            notifyItemChanged(position);
//        });


    }

    @Override
    public int getItemCount() {
        return partObjectList == null ? 0 : partObjectList.size();
    }

    public class PartViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView partNumber;
        ImageView photoImageView;
        private ItemClickListener itemClickListener;

        public PartViewHolder(@NonNull View itemView) {
            super(itemView);
            photoImageView = itemView.findViewById(R.id.photoImageView);
            partNumber = itemView.findViewById(R.id.partNumberTV);
            itemView.setOnClickListener(this);
        }

        private void bind(PartObject partObject) {

            boolean expanded = partObject.isExpanded();

            //subItem.setVisibility(expanded ? View.VISIBLE : View.GONE);

            partNumber.setText(partObject.getPartNumber());
            //genre.setText("Genre: " + partObject.getGenre());
            //year.setText("Year: " + partObject.getYear());
            Glide.with(mContext).load(partObject.getImage()).into(photoImageView);

        }

        @Override
        public void onClick(View v) {
            this.itemClickListener.onItemClick(v, getLayoutPosition());
        }
        public void setItemClickListener(ItemClickListener ic)
        {
            this.itemClickListener=ic;
        }
    }
}
