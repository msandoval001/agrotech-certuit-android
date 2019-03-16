package com.certuit.agroapp.ui.productor_home.list.products;

import android.content.Context;

import com.certuit.agroapp.data.model.Product;

import java.util.List;

public interface MyProductsContract {


    interface View {

        void showProducts(List<Product> products);

        Context getAppContext();

    }

    interface Presenter {

        void getProducts();

        Context getAppContext();

    }
}
