package com.certuit.agroapp.ui.buyers.detail.comments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.certuit.agroapp.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.CommentViewHolder> {

    private List<String> comments;
    private List<String> dates;

    public CommentsAdapter(List<String> comments, List<String> dates) {
        this.comments = comments;
        this.dates = dates;
    }

    @NonNull
    @Override
    public CommentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.comment_item, parent, false);
        return new CommentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentViewHolder holder, int position) {
        holder.assignateData(comments.get(position), dates.get(position));
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    class CommentViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.commentContent)
        protected AppCompatTextView content;
        @BindView(R.id.commentDate)
        protected AppCompatTextView date;

        public CommentViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void assignateData(String comment, String date) {
            content.setText(comment);
            this.date.setText(date);
        }
    }
}
