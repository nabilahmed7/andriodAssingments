package com.fyp.assignmentjobs;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NabilAdapter extends RecyclerView.Adapter<NabilAdapter.viewHolder> {

    private ArrayList<Items> cList = new ArrayList<>();
    Context context;
    ItemClickListener mListener;


    public NabilAdapter(ArrayList<Items> cList, Context context, ItemClickListener mListener) {
        this.cList = cList;
        this.context = context;
        this.mListener = mListener;
    }


    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Log.d("123456789", "Create viewHolder: ");


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items, parent, false);
        viewHolder viewHolder = new NabilAdapter.viewHolder(view);
        return viewHolder;


    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        Log.d("123456789", "Bind viewHolder:    " + position);

        Items userItem = cList.get(position);

        holder.imageView.setImageResource(cList.get(position).getcImages());
        holder.textView1.setText(cList.get(position).getcTextName());
        holder.textView2.setText(cList.get(position).getcTextDescription());
        holder.textView3.setText(cList.get(position).getcTextLocation());

        holder.btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (context instanceof Clicklisten) {
                    ((Clicklisten) context).onClick(userItem, position, v);
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return cList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;
        TextView textView1, textView2, textView3;
        Button btnSelect;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView_card);
            textView1 = itemView.findViewById(R.id.item_name);
            textView2 = itemView.findViewById(R.id.item_companyName);
            textView3 = itemView.findViewById(R.id.item_location);

            // button
            btnSelect = itemView.findViewById(R.id.button_save);

            itemView.setOnClickListener(this);

            Log.d("123456789", "viewHolder: ");

        }


        @Override
        public void onClick(View v) {
            mListener.openDetail(cList.get(getAdapterPosition()),getAdapterPosition(),v);

        }
    }

    interface ItemClickListener {
        public void openDetail(Items items, int position, View view);
    }
}
