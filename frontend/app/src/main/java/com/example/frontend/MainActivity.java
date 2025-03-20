package com.example.frontend;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.example.frontend.viewmodels.UserViewModel;

public class MainActivity extends AppCompatActivity {
    private TextView tvShow;
    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvShow = findViewById(R.id.tv_show);
        tvShow.setText("Hello World");

        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);

        userViewModel.getUsers().observe(this, users -> {
            if (users != null) {
                String result = "";
                for (int i = 0; i < users.size(); i++) {
                    result += users.get(i).toString();
                    result += "\n";
                }

                tvShow.setText(result);
            }
            else {
                Log.e("MainActivity", "Error fetching users");
            }
        });

    }
}