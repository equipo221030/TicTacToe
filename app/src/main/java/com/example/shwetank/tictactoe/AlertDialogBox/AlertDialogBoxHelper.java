package com.example.shwetank.tictactoe.AlertDialogBox;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by administrator on 11/7/17.
 */

public class AlertDialogBoxHelper {

    public static void showDialogBox(Context context, String message, String positivebuttonName, String title, final ClickEventListener clickEventListener){


        AlertDialog.Builder a_builder = new AlertDialog.Builder(context);
        a_builder.setMessage(message)
                .setCancelable(false)
                .setPositiveButton(positivebuttonName,new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        clickEventListener.positiveButtonClick();
                    }
                });
        AlertDialog alert = a_builder.create();
        alert.setTitle(title);
        alert.show();
    }

}
