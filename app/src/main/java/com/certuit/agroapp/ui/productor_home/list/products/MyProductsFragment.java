package com.certuit.agroapp.ui.productor_home.list.products;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.certuit.agroapp.R;
import com.certuit.agroapp.data.model.Product;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyProductsFragment extends Fragment implements MyProductsContract.View {


    @BindView(R.id.recyclerView)
    protected RecyclerView recyclerView;

    private DisplayAddFragmentListener listener;
    private MyProductsPresenter presenter;

    public MyProductsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_products, container, false);
        ButterKnife.bind(this, view);

        presenter = new MyProductsPresenter(this);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        presenter.getProducts();

    }

    public void setListener(DisplayAddFragmentListener listener) {
        this.listener = listener;
    }

    @OnClick(R.id.addProduct)
    public void displayAddProductFragment() {
        listener.onClickAdd();
    }

    @Override
    public void showProducts(List<Product> products) {
        MyProductsAdapter adapter = new MyProductsAdapter(products);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public Context getAppContext() {
        return getContext();
    }

    public interface DisplayAddFragmentListener {
        void onClickAdd();
    }
}
