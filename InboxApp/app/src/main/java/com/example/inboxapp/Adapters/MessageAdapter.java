package com.example.inboxapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.inboxapp.Model.Message;
import com.example.inboxapp.R;

import java.util.ArrayList;
import java.util.List;

public class MessageAdapter extends ArrayAdapter<Message> {

    Context mcontext;
    private int layoutResource;

    public MessageAdapter(@NonNull Context context, int resource, @NonNull List<Message> objects) {
        super(context, resource, objects);
        mcontext = context;
        layoutResource = resource;

    }

    private static class ViewHolder{
        TextView gönderen, konu, ileti;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final ViewHolder holder = new ViewHolder();
        convertView = LayoutInflater.from(mcontext).inflate(layoutResource, parent, false);
        holder.gönderen = convertView.findViewById(R.id.textsender);
        holder.konu = convertView.findViewById(R.id.textsubject);
        holder.ileti = convertView.findViewById(R.id.textmessage);
        final Message message = getItem(position);
        holder.gönderen.setText(message.getGönderen());
        holder.konu.setText(message.getKonu());
        holder.ileti.setText(message.getIleti());
        convertView.setTag(holder);
        return convertView;
    }
}
