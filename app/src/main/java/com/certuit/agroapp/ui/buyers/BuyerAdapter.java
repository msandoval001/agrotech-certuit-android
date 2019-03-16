package com.certuit.agroapp.ui.buyers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.certuit.agroapp.R;
import com.certuit.agroapp.data.model.User;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class BuyerAdapter extends RecyclerView.Adapter<BuyerAdapter.BuyerViewHolder> {

    private List<User> users;

    public BuyerAdapter(List<User> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public BuyerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.buyers_item, parent, false);
        return new BuyerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BuyerViewHolder holder, int position) {
        holder.assignateData(users.get(position));
    }

    @Override
    public int getItemCount() {
        return users.size();
    }


    class BuyerViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.profilePic)
        protected CircleImageView profilePic;
        @BindView(R.id.buyerName)
        protected AppCompatTextView buyerName;
        @BindView(R.id.buyerLocation)
        protected AppCompatTextView buyerLocation;
        @BindView(R.id.buyerRequest)
        protected AppCompatTextView buyerRequest;

        public BuyerViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void assignateData(User user) {
            buyerName.setText(user.getName());
            buyerLocation.setText("Mexicali");
            buyerRequest.setText("20 cajas de Naranjas");
        }
    }
}
