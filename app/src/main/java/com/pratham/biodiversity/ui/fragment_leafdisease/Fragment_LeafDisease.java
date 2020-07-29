package com.pratham.biodiversity.ui.fragment_leafdisease;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.pratham.biodiversity.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.io.File;
import java.util.Objects;

import static android.app.Activity.RESULT_OK;

@EFragment(R.layout.fragment_leaf_disease)
public class Fragment_LeafDisease extends Fragment {

    private static final int CAMERA_REQUEST = 1888;
    private static final int MY_CAMERA_PERMISSION_CODE = 100;
    private File output=null;

    @ViewById(R.id.iv_close)
    ImageView iv_close;
    @ViewById(R.id.iv_leafphoto)
    ImageView iv_leafphoto;
    @ViewById(R.id.et_leafName)
    EditText et_leafName;
    @ViewById(R.id.btn_submit)
    Button btn_submit;

    public Fragment_LeafDisease() {
        // Required empty public constructor
    }

    @AfterViews
    public void initalize(){
        EnableRuntimePermission();
    }

    @Click(R.id.iv_leafphoto)
    public void clickLeafImage(){

        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, CAMERA_REQUEST);
    }

    @Click(R.id.btn_submit)
    public void submitDetail(){

    }

    public void EnableRuntimePermission(){

        if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                Manifest.permission.CAMERA))
        {

            Toast.makeText(getActivity(),"CAMERA permission allows us to Access CAMERA app", Toast.LENGTH_LONG).show();

        } else {

            ActivityCompat.requestPermissions(getActivity(),new String[]{
                    Manifest.permission.CAMERA}, MY_CAMERA_PERMISSION_CODE);

        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == MY_CAMERA_PERMISSION_CODE)
        {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                Toast.makeText(getActivity(), "camera permission granted", Toast.LENGTH_LONG).show();
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
            else
            {
                Toast.makeText(getActivity(), "camera permission denied", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {

            Bitmap bitmap = (Bitmap) data.getExtras().get("data");

            iv_leafphoto.setImageBitmap(bitmap);
        }
    }

    @Click(R.id.iv_close)
    public void closeFragment(){
        Objects.requireNonNull(getActivity()).onBackPressed();
    }
}
