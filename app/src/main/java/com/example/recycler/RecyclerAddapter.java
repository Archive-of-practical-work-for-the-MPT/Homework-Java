package com.example.recycler;

import static androidx.core.content.ContextCompat.startActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Objects;

public class RecyclerAddapter extends RecyclerView.Adapter<RecyclerAddapter.ViewHolder> {

    private final LayoutInflater inflater;
    private final List<State> states;
    private final Context context;


    RecyclerAddapter(Context context, List<State> states) {
        this.states = states;
        this.inflater = LayoutInflater.from(context);

        this.context = context;
    }

    @Override
    public RecyclerAddapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerAddapter.ViewHolder holder, int position) {
        State state = states.get(position);
        holder.flagView.setImageResource(state.getFlagResource());
        holder.nameView.setText(state.getName());
        holder.capitalView.setText(state.getCapital());

        holder.capitalView.setText(state.getCapital());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Description.class);
                intent.putExtra("flag", state.getFlagResource());
                intent.putExtra("nameView", state.getName());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() { return  states.size(); }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView flagView;
        final TextView nameView, capitalView;

        ViewHolder(View view) {
            super(view);
            flagView = view.findViewById(R.id.flag);
            nameView = view.findViewById(R.id.name);
            capitalView = view.findViewById(R.id.capital);
        }
    }
}
