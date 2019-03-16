package com.certuit.agroapp.ui.productor_home.list.products;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.certuit.agroapp.R;
import com.certuit.agroapp.data.model.Product;

import java.util.List;
import java.util.Random;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MyProductsAdapter extends RecyclerView.Adapter<MyProductsAdapter.ProductViewHolder> {

    private List<Product> products;

    public MyProductsAdapter(List<Product> products) {
        this.products = products;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_products_item, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        holder.assignateData(products.get(position));
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.product_image)
        protected AppCompatImageView productImage;
        @BindView(R.id.product_name)
        protected AppCompatTextView productName;
        @BindView(R.id.product_desc)
        protected AppCompatTextView productDesc;
        @BindView(R.id.progressBar)
        protected ProgressBar progressBar;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void assignateData(Product product) {
            productName.setText(product.getCrop().getName());
            productDesc.setText(product.getDescription());

            Random random = new Random();

            progressBar.setProgress(random.nextInt(100));
        }
    }
}
