package com.example.prepare;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExamContentAdapter extends RecyclerView.Adapter<ExamContentAdapter.MyViewHolder> {
    private final ArrayList<ExamContent> examContentsList;

    public ExamContentAdapter(ArrayList<ExamContent> examContentsList){
        this.examContentsList = examContentsList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private final TextView nameText;
        private final TextView subnameText;

        public MyViewHolder(final View view){
            super(view);
            nameText = view.findViewById(R.id.list_text_item);
            subnameText = view.findViewById(R.id.list_expand);

            nameText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ExamContent examContent = examContentsList.get(getAdapterPosition());
                    examContent.setExpanded(!examContent.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });

        }
    }


    @NonNull
    @Override
    public ExamContentAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
                return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ExamContentAdapter.MyViewHolder holder, int position) {
        String name = examContentsList.get(position).getTitle();
        String subName = examContentsList.get(position).getSubTitle();
        holder.nameText.setText(name);
        holder.subnameText.setText(subName);

        boolean isExpanded = examContentsList.get(position).isExpanded();
        holder.subnameText.setVisibility(isExpanded ? View.VISIBLE:View.GONE);
    }

    @Override
    public int getItemCount() {
        return examContentsList.size();
    }
}
