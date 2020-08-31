package com.example.inboxapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.inboxapp.OpenMailActivity;
import com.example.inboxapp.R;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    String data1[], data2[], data3[];
    Context context;

    public MyAdapter(Context context, String data1[], String data2[], String data3[]) {
        this.context = context;
        this.data1 = data1;
        this.data2 = data2;
        this.data3 = data3;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.textView1.setText(data1[position]);
        holder.textView2.setText(data2[position]);
        holder.textView3.setText(data3[position]);

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, OpenMailActivity.class);
                intent.putExtra("Gönderen", data1[position]);
                intent.putExtra("Konu", data2[position]);
                intent.putExtra("İleti", data3[position]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data1.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textView1, textView2, textView3;
        ImageView imageView;
        ConstraintLayout layout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.textsender);
            textView2 = itemView.findViewById(R.id.textsubject);
            textView3 = itemView.findViewById(R.id.textmessage);
            layout = itemView.findViewById(R.id.recyclerConst);
        }
    }
}
