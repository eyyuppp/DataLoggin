package com.example.datalogging;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ageText;
    TextView nameText,saveAgeText,saveNameText;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //küçük verileri kaydetmek için
        sharedPreferences=this.getSharedPreferences("com.example.datalogging",MODE_PRIVATE);
         ageText=findViewById(R.id.numberAge);
         nameText=findViewById(R.id.textname);
        saveAgeText=findViewById(R.id.textSaveAge);
        saveNameText=findViewById(R.id.textSaveName);
        int storedAge=sharedPreferences.getInt("ageSave",0);
        String storedName=sharedPreferences.getString("nameSave","");
        if (storedAge==0){
            saveAgeText.setText("Your age : ");
        }
        else{
            saveAgeText.setText("Your age : "+storedAge);
        }
        if (storedName.equals("")){
            saveNameText.setText("Your Name : ");
        }
        else{
            saveNameText.setText("Your Name : "+storedName);
        }

     }
    public void save(View view){
        int ageSave=Integer.parseInt(ageText.getText().toString());
        if (ageSave!=0){
            saveAgeText.setText("Your Age :"+ageSave);
            sharedPreferences.edit().putInt("ageSave",ageSave).apply();
            Toast.makeText(MainActivity.this,"saved Age",Toast.LENGTH_LONG).show();

        }
        if (!nameText.getText().equals("")){
            String nameSave=nameText.getText().toString();
            saveNameText.setText("Your Name :"+nameSave);
            sharedPreferences.edit().putString("nameSave",nameSave).apply();
            Toast.makeText(MainActivity.this,"saved Name",Toast.LENGTH_LONG).show();

        }


    }

}