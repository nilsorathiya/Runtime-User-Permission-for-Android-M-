package com.nil.permission;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by nil on 10/03/16.
 */
public class BaseActivity extends AppCompatActivity {

    public static final int PERMISSION_CAMERA = 1;
    public static final int PERMISSION_RECORD_AUDIO = 2;
    public static final int PERMISSION_CONTACTS = 3;

    public boolean checkPermission(int permission) {

        if (ActivityCompat.checkSelfPermission(this, getPermission(permission)) != PackageManager.PERMISSION_GRANTED) {
            return false;
        } else {
            return true;
        }

    }

    public void requestForPermission(final int permission) {

        // BEGIN_INCLUDE(camera_permission_request)
        if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                getPermission(permission))) {


            final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);

            // Setting Dialog Message
            alertDialog.setMessage("Permission is needed to perform action...");

            // Setting Positive "Yes" Button
            alertDialog.setPositiveButton("Allow", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {

                    ActivityCompat.requestPermissions(BaseActivity.this, new String[]{getPermission(permission)}, permission);

                }
            });

            alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    // Write your code here to invoke NO event
                    dialog.dismiss();
                }
            });

            // Showing Alert Message
            alertDialog.show();
        } else {

            ActivityCompat.requestPermissions(this, new String[]{getPermission(permission)}, permission);

        }
        // END_INCLUDE(camera_permission_request)
    }

    @Override
    public void onRequestPermissionsResult(final int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {


        if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            // Camera permission has been granted, preview can be displayed

            final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);

            // Setting Dialog Message
            alertDialog.setMessage("Permission granted...");

            // Setting Positive "Yes" Button
            alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {

                    dialog.dismiss();

                }
            });
            // Showing Alert Message
            alertDialog.show();

        } else {

            final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);

            // Setting Dialog Message
            alertDialog.setMessage("Permission not granted...");

            // Setting Positive "Yes" Button
            alertDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {

                    dialog.dismiss();

                }
            });
            // Showing Alert Message
            alertDialog.show();
        }

    }

    public String getPermission(int permis) {

        String permission = null;

        switch (permis) {
            case PERMISSION_CAMERA:
                permission = Manifest.permission.CAMERA;
                return permission;
            case PERMISSION_RECORD_AUDIO:
                permission = Manifest.permission.RECORD_AUDIO;
                return permission;
            case PERMISSION_CONTACTS:
                permission = Manifest.permission.READ_CONTACTS;
                return permission;
        }
        return permission;
    }

}
