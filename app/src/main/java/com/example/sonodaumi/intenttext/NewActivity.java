package com.example.sonodaumi.intenttext;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        Start();
    }

    private void Start(){
        final Intent intent = getIntent();
        final EditText newText = (EditText)findViewById(R.id.messageNew);
        Button btnNew = (Button)findViewById(R.id.sendNew);

        if(intent.getStringExtra("MessageMain") != null){
            Toast.makeText(NewActivity.this ,intent.getStringExtra("MessageMain"), Toast.LENGTH_SHORT).show();
        }

        btnNew.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                if(!newText.getText().toString().isEmpty()){
                    intent.putExtra("Result", newText.getText().toString());
                    setResult(0, intent);
                }
                finish();
            }
        });
    }
}
