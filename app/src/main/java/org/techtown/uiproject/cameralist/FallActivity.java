package org.techtown.uiproject.cameralist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import org.techtown.uiproject.R;

public class FallActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fall);

        final ImageView img_test = findViewById(R.id.img_test);
        final ImageView img_test2 = findViewById(R.id.img_test2);

        FirebaseStorage storage = FirebaseStorage.getInstance("gs://ui-project-9ffb3.appspot.com");
        StorageReference storageRef = storage.getReference();
        storageRef.child("images/2020-11-06_13-43-23 fall.jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                //이미지 로드 성공시

                Glide.with(getApplicationContext())
                        .load(uri)
                        .into(img_test);

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                //이미지 로드 실패시
                Toast.makeText(getApplicationContext(), "실패", Toast.LENGTH_SHORT).show();
            }
        });

        storageRef.child("images/2020-11-06_13-43-34 fall.jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                //이미지 로드 성공시

                Glide.with(getApplicationContext())
                        .load(uri)
                        .into(img_test2);

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                //이미지 로드 실패시
                Toast.makeText(getApplicationContext(), "실패", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
