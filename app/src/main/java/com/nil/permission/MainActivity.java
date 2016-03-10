package com.nil.permission;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by nil on 10/03/16.
 */
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvCamera = (TextView) findViewById(R.id.tvCamera);
        tvCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkPermission(PERMISSION_CAMERA)) {
                    Toast.makeText(MainActivity.this, "You can use Camera", Toast.LENGTH_SHORT).show();
                } else {
                    requestForPermission(PERMISSION_CAMERA);
                }
            }
        });

        TextView tvRecord = (TextView) findViewById(R.id.tvRecord);
        tvRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkPermission(PERMISSION_RECORD_AUDIO)) {
                    Toast.makeText(MainActivity.this, "You can record Voice", Toast.LENGTH_SHORT).show();
                } else {
                    requestForPermission(PERMISSION_RECORD_AUDIO);
                }
            }
        });

        TextView tvContact = (TextView) findViewById(R.id.tvContact);
        tvContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkPermission(PERMISSION_CONTACTS)) {
                    Toast.makeText(MainActivity.this, "You can access User-Contact", Toast.LENGTH_SHORT).show();
                } else {
                    requestForPermission(PERMISSION_CONTACTS);
                }
            }
        });

    }
}
