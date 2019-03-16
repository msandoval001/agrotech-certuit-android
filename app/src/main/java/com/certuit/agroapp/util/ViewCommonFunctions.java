package com.certuit.agroapp.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.certuit.agroapp.R;

public class ViewCommonFunctions {


    private ViewCommonFunctions() {
    }

    public static void showAlertDialogInformative(Context context, String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton(R.string.accept, (dialog, which) -> dialog.dismiss())
                .create().show();
    }

    public static void showAlertDialogDesicion(Context context, String title, String message,
                                               String confirmMessage, String cancelMessage,
                                               DialogInterface.OnClickListener positive,
                                               DialogInterface.OnClickListener negative) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton(confirmMessage, positive)
                .setNegativeButton(cancelMessage, negative)
                .create().show();
    }

    public static void showLongToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

    public static void showShortToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static void showNoInternetDialog(Context context) {
        showAlertDialogInformative(context, context.getString(R.string.error),
                context.getString(R.string.no_internet));
    }

    public static void showUnknowError(Context context) {
        showAlertDialogInformative(context, context.getString(R.string.error),
                context.getString(R.string.unknown_error));
    }


    public static DialogInterface.OnClickListener getBasicCancel() {
        return (dialog, which) -> dialog.dismiss();
    }

    public static void setErrorFocus(int code, TextInputEditText view) {
        switch (code){
            case ValidatorUtil.EMPTY_TEXT:
                view.setError("Campo requerido");
                break;
            case ValidatorUtil.INVALID_EMAIL:
                view.setError("Correo inválido");
                break;
            case ValidatorUtil.INVALID_CHARACTERS:
                view.setError("Caracteres ingresados inválidos");
                break;
            case ValidatorUtil.INVALID_LENGHT:
                view.setError("Número de caracteres inválido");
                break;
            case ValidatorUtil.INVALID_RFC_FORMAT:
                view.setError("Formato de RFC inválido");
                break;
            default:
                view.setError("Campo no válido");
        }
        view.requestFocus();
    }

}
