package com.find.find_food.Confirmation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.find.find_food.Home_Page_Activity;
import com.find.find_food.PopUp_Dialogue;
import com.find.find_food.R;

public class User_Details_Activity extends AppCompatActivity {
    Button submitBtn;
    EditText fullNameET, cardET, cvvET, expirationET, addressOneET, addressTwoET, cityET, stateET, countryET,
    zipET, commentET;
    String name , card, cvv, expiration, address1, address2, city, state, country, zip, comment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        submitBtn = findViewById(R.id.submitBTN);

        fullNameET = findViewById(R.id.fullNameET);
        cardET = findViewById(R.id.cardET);
        cvvET = findViewById(R.id.cvvET);
        expirationET = findViewById(R.id.expirationET);
        addressOneET = findViewById(R.id.addressOneET);
        addressTwoET = findViewById(R.id.addressTwoET);
        cityET = findViewById(R.id.cityET);
        stateET = findViewById(R.id.stateET);
        countryET = findViewById(R.id.countryET);
        zipET = findViewById(R.id.zipET);
        commentET = findViewById(R.id.commentET);

        name = fullNameET.getText().toString();
        card = cardET.getText().toString();
        cvv = cvvET.getText().toString();
        expiration = expirationET.getText().toString();
        address1 = addressOneET.getText().toString();
        address2 = addressTwoET.getText().toString();
        city = cityET.getText().toString();
        state = stateET.getText().toString();
        country = countryET.getText().toString();
        zip = zipET.getText().toString();
        comment = commentET.getText().toString();




        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                if (name.isEmpty()||card.isEmpty()||cvv.isEmpty()||expiration.isEmpty()||address1.isEmpty()||address2.isEmpty()
//                ||city.isEmpty()||state.isEmpty()||country.isEmpty()||zip.isEmpty()||comment.isEmpty()){
//                    Toast.makeText(User_Details_Activity.this, "Plese fill up the fields first", Toast.LENGTH_SHORT).show();
//
//                }
//                else{

                    fullNameET.getText().clear();
                    cardET.getText().clear();
                    cvvET.getText().clear();
                    expirationET.getText().clear();
                    addressOneET.getText().clear();
                    addressTwoET.getText().clear();
                    cityET.getText().clear();
                    stateET.getText().clear();
                    countryET.getText().clear();
                    zipET.getText().clear();
                    commentET.getText().clear();

                    openDialogue();


                }




        });

    }

    private void openDialogue() {
        PopUp_Dialogue popUp_dialogue = new PopUp_Dialogue();
        popUp_dialogue.show(getSupportFragmentManager(),"Find Food");

    }
}