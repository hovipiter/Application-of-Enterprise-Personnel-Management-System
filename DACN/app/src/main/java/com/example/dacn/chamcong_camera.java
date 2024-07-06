package com.example.dacn;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class chamcong_camera extends AppCompatActivity {
    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private static final int REQUEST_IMAGE_PICK = 2;

    private ImageView imageView;
    private Button buttonUpload;
    private Button buttonRetake;
    private Button buttonDelete;
    private String imagePath; // Store the path/reference to the uploaded image

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chamcong_camera);

        imageView = findViewById(R.id.chamcong_camera_imageview);
        buttonUpload = findViewById(R.id.chamcong_camera_button_upload);
        buttonRetake = findViewById(R.id.chamcong_camera_button_takepicture_again);
        buttonDelete = findViewById(R.id.chamcong_camera_button_delete);

        // Check if there's a saved image path
        SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        imagePath = preferences.getString("imagePath", null);
        if (imagePath != null) {
            imageView.setImageURI(Uri.fromFile(new File(imagePath)));
        }

        // Open camera to take a picture
        buttonUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (imagePath != null && !imagePath.isEmpty()) {
                    // Simulate uploading logic
                    uploadImageToServer(imagePath);
                } else {
                    Toast.makeText(chamcong_camera.this, "No image selected", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Set listener for retake button
        buttonRetake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                }
            }
        });

        // Set listener for image view to pick image from gallery
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pickPhotoIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(pickPhotoIntent, REQUEST_IMAGE_PICK);
            }
        });

        // Set listener for delete button
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteImage();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK && data != null) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            // Save the bitmap to a file and get its path
            imagePath = saveBitmapToFile(imageBitmap);
            imageView.setImageBitmap(imageBitmap);
        } else if (requestCode == REQUEST_IMAGE_PICK && resultCode == RESULT_OK && data != null) {
            Uri selectedImageUri = data.getData();
            // Get the real path from URI
            imagePath = getRealPathFromURI(selectedImageUri);
            imageView.setImageURI(selectedImageUri);
        }
    }

    private String saveBitmapToFile(Bitmap bitmap) {
        File filesDir = getApplicationContext().getFilesDir();
        File imageFile = new File(filesDir, "image_" + System.currentTimeMillis() + ".jpg");

        try (FileOutputStream fos = new FileOutputStream(imageFile)) {
            bitmap.compress(Bitmap.CompressFormat.JPEG, 90, fos);
            return imageFile.getAbsolutePath();
        } catch (IOException e) {
            Log.e("TAG", "Error saving bitmap", e);
            return null;
        }
    }

    private String getRealPathFromURI(Uri contentUri) {
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor cursor = getContentResolver().query(contentUri, proj, null, null, null);
        if (cursor == null) return null;
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        String filePath = cursor.getString(column_index);
        cursor.close();
        return filePath;
    }

    private void uploadImageToServer(String imagePath) {
        // Simulate uploading logic, you can implement actual uploading using Retrofit or HTTP library
        Toast.makeText(this, "Image uploaded successfully", Toast.LENGTH_SHORT).show();
        // Save imagePath to SharedPreferences or database for persistence
        saveImagePath(imagePath);
    }

    private void saveImagePath(String imagePath) {
        SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("imagePath", imagePath);
        editor.apply();
    }

    private void deleteImage() {
        // Clear the image view
        imageView.setImageResource(0);
        imagePath = null;

        // Remove the image path from SharedPreferences
        SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove("imagePath");
        editor.apply();

        Toast.makeText(this, "Image deleted", Toast.LENGTH_SHORT).show();
    }
}
