package com.certuit.agroapp.ui.productor_home.list.demand;

import android.content.Context;

import com.certuit.agroapp.data.manager.DataManager;
import com.certuit.agroapp.data.model.Demand;
import com.certuit.agroapp.util.NetworkUtil;
import com.certuit.agroapp.util.ViewCommonFunctions;

import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class DemandsPresenter implements DemandsContract.Presenter {

    private DemandsContract.View view;
    private DataManager dataManager;

    public DemandsPresenter(DemandsContract.View view) {
        this.view = view;
        dataManager = new DataManager();
    }


    @Override
    public void getDemands() {
        if (NetworkUtil.checkInternetConnection(getAppContext())) {
            Observable<List<Demand>> observable = dataManager.getDemands();
            observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<List<Demand>>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {
                            e.printStackTrace();
                            ViewCommonFunctions.showUnknowError(getAppContext());
                        }

                        @Override
                        public void onNext(List<Demand> demands) {
                            view.showDemands(demands);
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
