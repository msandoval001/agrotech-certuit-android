package com.certuit.agroapp.ui.buyers.detail.directory;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.certuit.agroapp.R;
import com.certuit.agroapp.data.model.User;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class DirectoryAdapter extends RecyclerView.Adapter<DirectoryAdapter.DirectoryViewHolder> {

    private List<User> users;
    private List<String> phones;
    private Context context;

    public DirectoryAdapter(List<User> users, List<String> phones, Context context) {
        this.users = users;
        this.phones = phones;
        this.context = context;
    }

    @NonNull
    @Override
    public DirectoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.directory_item, parent, false);
        return new DirectoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DirectoryViewHolder holder, int position) {
        holder.assignateData(users.get(position));
        holder.phoneIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phones.get(position),
                        null));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }


    class DirectoryViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.directoryName)
        protected AppCompatTextView directoryName;
        @BindView(R.id.phoneIcon)
        protected AppCompatImageView phoneIcon;

        public DirectoryViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void assignateData(User user) {
            directoryName.setText(user.getName());
        }
    }
}
