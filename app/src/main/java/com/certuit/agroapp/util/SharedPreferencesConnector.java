package com.certuit.agroapp.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.certuit.agroapp.R;
import com.google.gson.Gson;

import java.io.File;

public class SharedPreferencesConnector {

    private final SharedPreferences sharedPreferences;

    /**
     * Constructor que recibe todos los parametros
     * @param sharedPreferences Interface que ayuda a la comunicación de datos.
     */
    private SharedPreferencesConnector(SharedPreferences sharedPreferences){
        this.sharedPreferences = sharedPreferences;
    }

    public static SharedPreferencesConnector getInstance(Context context){
        return new SharedPreferencesConnector(context.getSharedPreferences(String.valueOf(R.string.app_name),
                Context.MODE_PRIVATE));
    }

    /**
     * Método que escribe un valor booleano.
     * @param key Nombre de la llave con la que se guardará
     * @param value Valor booleano a guardar
     * @return Regresa true si se guardó exitosamente o false si no se guardó
     */
    public boolean writeBoolean (String key, boolean value){
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.putBoolean(key, value);
        return prefsEditor.commit();
    }

    /**
     * Método que recupera un valor booleano emparejado con la llave dada.
     * @param key Llave que recuperará el valor booleano.
     * @return Regresa el valor leído de memoria, si no, regresará un false por predeterminado.
     */
    public boolean readBoolean (String key) {
        return sharedPreferences.getBoolean(key, false);
    }

    /**
     * Método que remueve un valor previamente guardado.
     * @param key Llave que es perteneciente al valor a borrar.
     */
    public void removeValue (String key){
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.remove(key);
        prefsEditor.apply();
    }

    /**
     * Método que escribe en memoria un valor tipo String
     * @param key Llave con la que se guardará el String
     * @param data Valor que se guardará
     * @return Regresa true si la información fue guardada exitosamente, si no, regresa un false.
     */
    public boolean writeString(String key, String data) {
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.putString(key, data);
        return prefsEditor.commit();
    }

    /**
     * Método que regresa el valor guardado con la llave dada.
     * @param key Llave con la que se buscará el valor guardado.
     * @return Regresa el valor guardado en memoria.
     */
    public String readString(String key) {
        return sharedPreferences.getString(key, null);
    }

    /**
     * Escribe un objecto en su representación JSON con la ayuda de la librería GSON
     * @param key Llave relacionada al objeto
     * @param value Objeto a escribir
     * @return true si fue escrito exitosamente, false si no.
     */
    public boolean writeJSON (String key, Object value){
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(value);
        prefsEditor.putString(key, json);
        return prefsEditor.commit();
    }

    public <T> T readJSON(Class<T> type, String key){
        Gson gson = new Gson();
        String json = sharedPreferences.getString(key, null);
        return gson.fromJson(json, type);
    }

    public boolean clearJSON(File cacheDir) {
        File applicationDirectory = new File(cacheDir.getParent());
        if (applicationDirectory.exists()){
            String[] filesNames = applicationDirectory.list();
            for (String archive : filesNames){
                if (!archive.equals("lib")){
                    deleteFile(new File(applicationDirectory, archive));
                }
            }
        }
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        return editor.commit();
    }

    private boolean deleteFile(File file) {
        boolean deletedAll = true;
        if (file != null) {
            if (file.isDirectory()) {
                String[] children = file.list();
                for (int i = 0; i < children.length; i++) {
                    deletedAll = deleteFile(new File(file, children[i])) && deletedAll;
                }
            } else {
                deletedAll = file.delete();
            }
        }

        return deletedAll;
    }
}
