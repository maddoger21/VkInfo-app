package ru.samsung.itschool.vkinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.net.URL;

import static ru.samsung.itschool.vkinfo.utils.NetworkUtils.generateURL;
import static ru.samsung.itschool.vkinfo.utils.NetworkUtils.getResponseFromURL;

public class MainActivity extends AppCompatActivity {

    private EditText searchField;
    private Button searchButton;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchField = findViewById(R.id.et_search_field);
        searchButton = findViewById(R.id.b_search_vk);
        result = findViewById(R.id.tv_result);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                URL generateURL = generateURL(searchField.getText().toString());

                String response = null;
                try {
                    response = getResponseFromURL(generateURL);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                result.setText(response);
            }
        };

        searchButton.setOnClickListener(onClickListener);

    }
}