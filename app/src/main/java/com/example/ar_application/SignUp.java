package com.example.ar_application;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SignUp extends AppCompatActivity {

    public void loginBtn(View view){
        EditText userName = findViewById(R.id.userNameIdLogin);
        EditText pass =  findViewById(R.id.userPassIdLogin);

        String userNameString = userName.getText().toString();
        String passString = pass.getText().toString();

        if(userNameString.isEmpty() || passString.isEmpty()){
            Toast.makeText(this, "Make sure you have filled all the required details", Toast.LENGTH_LONG).show();
        }
        else{
            String userFirstName = userNameString.split(" ")[0];

            Intent land = new Intent(this, MainActivity.class);
            land.putExtra("userFirstName", userFirstName);
            startActivity(land);
        }
    }

    public void openSignInPage(View view){
        Intent signInIntent = new Intent(this, SignIn.class);
        startActivity(signInIntent);
    }

    public void signInMethods(View view){
        Toast.makeText(this, "Will be Implemented Soon", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}