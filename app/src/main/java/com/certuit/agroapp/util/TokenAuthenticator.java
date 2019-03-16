package com.certuit.agroapp.util;

//import com.certuit.agroapp.data.manager.DataManager;
//import com.certuit.agroapp.data.model.TokenResult;

public class TokenAuthenticator {

//    private DataManager dataManager;
//    private SharedPreferencesConnector connector;
//
//
//    public TokenAuthenticator(Context context) {
//        dataManager = new DataManager(context);
//        connector = SharedPreferencesConnector.getInstance(context);
//    }
//
//    @Nullable
//    @Override
//    public Request authenticate(@NonNull Route route, @NonNull final Response response) {
//
//        final String[] token = {""};
//        String refreshToken = connector.readString(String.valueOf(R.string.refresh_token));
//        Observable<TokenResult> observable;
//
//
//        if (refreshToken != null){
//            observable = dataManager.refreshToken();
//        }else {
//            observable = dataManager.getToken();
//        }
//        observable.subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<TokenResult>() {
//                    @Override
//                    public void onCompleted() {
//                        // Método no necesario
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        e.printStackTrace();
//                    }
//
//                    @Override
//                    public void onNext(TokenResult tokenResult) {
//                        String newToken = tokenResult.getAccessToken();
//                        String refreshToken = tokenResult.getRefreshToken();
//
//                        token[0] = tokenResult.getAccessToken();
//
//                        if (refreshToken != null){
//                            connector.writeString(String.valueOf(R.string.refresh_token), refreshToken);
//                        }
//                        connector.writeString(String.valueOf(R.string.token), newToken);
//                    }
//                });
//
//        while (token[0].equalsIgnoreCase("")) {}
//
//        return response.request().newBuilder().header("Authorization", "Bearer " + token[0]).build();
//    }
}
