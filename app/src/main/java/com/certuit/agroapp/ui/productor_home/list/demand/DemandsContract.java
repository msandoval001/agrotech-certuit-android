package com.certuit.agroapp.ui.productor_home.list.demand;

import android.content.Context;

import com.certuit.agroapp.data.model.Demand;

import java.util.List;

public interface DemandsContract {

    interface View {

        void showDemands(List<Demand> demands);

        Context getAppContext();
    }

    interface Presenter {

        void getDemands();

        Context getAppContext();

    }
}
