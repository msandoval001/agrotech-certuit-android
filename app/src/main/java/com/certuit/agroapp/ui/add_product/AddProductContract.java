package com.certuit.agroapp.ui.add_product;

import android.content.Context;

import com.certuit.agroapp.data.model.Crop;

import java.util.List;

public interface AddProductContract {

    interface View {

        void showCrops(List<Crop> crops);

        void onCreateProduct();

        Context getAppContext();

    }

    interface Presenter {

        void getCrops();

        void createProduct(int cropId, String quantity, String sowingDate, String harvestDate,
                           String status, int unit, String description, String price);

        Context getAppContext();

    }

}
