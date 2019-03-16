package com.certuit.agroapp.ui.add_product;

import android.content.Context;

import com.certuit.agroapp.data.manager.DataManager;
import com.certuit.agroapp.data.model.Crop;
import com.certuit.agroapp.data.model.GenericResponse;
import com.certuit.agroapp.util.NetworkUtil;
import com.certuit.agroapp.util.ViewCommonFunctions;

import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class AddProductPresenter implements AddProductContract.Presenter {

    private AddProductContract.View view;
    private DataManager dataManager;

    public AddProductPresenter(AddProductContract.View view) {
        this.view = view;
        dataManager = new DataManager();
    }

    @Override
    public void getCrops() {
        if (NetworkUtil.checkInternetConnection(getAppContext())) {
            Observable<List<Crop>> observable = dataManager.getCrops();
            observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<List<Crop>>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {
                            e.printStackTrace();
                            ViewCommonFunctions.showUnknowError(getAppContext());
                        }

                        @Override
                        public void onNext(List<Crop> crops) {
                            view.showCrops(crops);
                        }
                    });
        } else {
            ViewCommonFunctions.showNoInternetDialog(getAppContext());
        }
    }

    // unidad 0 = caja 1 = toneladas
    @Override
    public void createProduct(int cropId, int quantity, String sowingDate, String harvestDate,
                              String status, int unit, String description, float price) {
        if (NetworkUtil.checkInternetConnection(getAppContext())) {
            Observable<GenericResponse> observable = dataManager.createProduct(cropId, quantity, sowingDate,
                    harvestDate, status, unit, description);
            observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<GenericResponse>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {
                            e.printStackTrace();
                            ViewCommonFunctions.showUnknowError(getAppContext());
                        }

                        @Override
                        public void onNext(GenericResponse genericResponse) {
                            view.onCreateProduct();
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
