package com.certuit.agroapp.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkUtil {

    private NetworkUtil(){}

    /**
     * Verifica la conexión de internet
     * @param context Contexto de la aplicacion
     * @return Regresa un booleano, true = si hay internet false = no hay internet
     */
    public static boolean checkInternetConnection(Context context){
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnected();
    }
}
