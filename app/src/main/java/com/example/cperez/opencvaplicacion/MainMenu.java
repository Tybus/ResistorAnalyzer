package com.example.cperez.opencvaplicacion;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainMenu extends AppCompatActivity {
    private static final int PICK_IMAGE = 100;
    final DisplayHowToDialogFragment HowToDialog = new DisplayHowToDialogFragment();
    Uri imageURI;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    public void displayHowTo(View view){
        HowToDialog.show(getSupportFragmentManager(), "How to use");
    }
    public void startCapture(View view){
        Intent intent = new Intent(this, OpenCVActivity.class);
        startActivity(intent);
    }
    public void browseImage(View view){
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && requestCode == PICK_IMAGE){
            imageURI = data.getData();
            //imageView.setImageUri(imageUri);
        }
    }
}
