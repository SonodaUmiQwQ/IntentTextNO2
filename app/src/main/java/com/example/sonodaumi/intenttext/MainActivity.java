package com.example.sonodaumi.intenttext;

import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Start();
    }

    private void Start(){
        final EditText mainText = (EditText)findViewById(R.id.messageMain);
        Button btnMain = (Button)findViewById(R.id.sendMain);

        btnMain.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NewActivity.class);
                if(!mainText.getText().toString().isEmpty()) {
                    intent.putExtra("MessageMain" ,mainText.getText().toString());
                }
                startActivityForResult(intent, 0);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 0 && resultCode == 0 && data != null){
            Toast.makeText(MainActivity.this, data.getStringExtra("Result"), Toast.LENGTH_SHORT).show();
        }
    }
}


