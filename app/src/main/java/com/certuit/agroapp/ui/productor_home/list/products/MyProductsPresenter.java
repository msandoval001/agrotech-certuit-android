package com.certuit.agroapp.ui.productor_home.list.products;

import android.content.Context;

import com.certuit.agroapp.data.manager.DataManager;
import com.certuit.agroapp.data.model.Product;
import com.certuit.agroapp.util.NetworkUtil;
import com.certuit.agroapp.util.ViewCommonFunctions;

import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MyProductsPresenter implements MyProductsContract.Presenter {

    private MyProductsContract.View view;
    private DataManager dataManager;

    public MyProductsPresenter(MyProductsContract.View view) {
        this.view = view;
        dataManager = new DataManager();
    }

    @Override
    public void getProducts() {
        if (NetworkUtil.checkInternetConnection(getAppContext())) {
            Observable<List<Product>> observable = dataManager.getProducts();
            observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<List<Product>>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {
                            e.printStackTrace();
                            ViewCommonFunctions.showUnknowError(getAppContext());
                        }

                        @Override
                        public void onNext(List<Product> products) {
                            view.showProducts(products);
                        }
                    });
        } else {
            ViewCommonFunctions.showNoInternetDialog(getAppContext());
        }
    }

    @Override
    public Context getAppContext() {
        return view.getAppContext();
    }
}
