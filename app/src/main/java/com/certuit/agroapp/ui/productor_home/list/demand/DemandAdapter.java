package com.certuit.agroapp.ui.productor_home.list.demand;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.certuit.agroapp.R;
import com.certuit.agroapp.data.model.Product;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class DemandAdapter extends RecyclerView.Adapter<DemandAdapter.DemandViewHolder> {

    private List<Product> products;

    public DemandAdapter(List<Product> products) {
        this.products = products;
    }

    @NonNull
    @Override
    public DemandViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_demans_item, parent, false);
        return new DemandViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DemandViewHolder holder, int position) {
        holder.assignateData(products.get(position));
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    class DemandViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.product_image)
        protected AppCompatImageView productImage;
        @BindView(R.id.product_name)
        protected AppCompatTextView productName;
        @BindView(R.id.product_desc)
        protected AppCompatTextView productDesc;

        public DemandViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void assignateData(Product product) {
            productName.setText(product.getCrop().getName());
            productDesc.setText(product.getDescription());
        }
    }
}
