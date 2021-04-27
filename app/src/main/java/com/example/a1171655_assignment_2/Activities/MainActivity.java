package com.example.a1171655_assignment_2.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a1171655_assignment_2.Models.CV;
import com.example.a1171655_assignment_2.R;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    private EditText edt_firstName;
    private EditText edt_lastName;
    private EditText edtEmail_email;
    private EditText edtPhone_phone;
    private EditText edt_address;
    private DatePicker datePicker_dop;
    private EditText edtMultiLine_about;

    public static final String DATA = "";
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupViews();
        setupSharedPrefs();
        checkLoadPrefs();
    }

    private void checkLoadPrefs() {
        Gson gson = new Gson();

        String dataString = prefs.getString(DATA, "");

        if (!dataString.equals("")) {
            CV cv = gson.fromJson(dataString, CV.class);

            edt_firstName.setText(cv.getFirstName());
            edt_lastName.setText(cv.getLastName());
            edtEmail_email.setText(cv.getEmail());
            edtPhone_phone.setText(cv.getPhone());
            edt_address.setText(cv.getAddress());

            String[] dateStringSp = cv.getDop().split("[/]");
            int dayOfMonth = Integer.parseInt(dateStringSp[0]);
            int month = Integer.parseInt(dateStringSp[1]);
            int year = Integer.parseInt(dateStringSp[2]);
            datePicker_dop.updateDate(year, month, dayOfMonth);

            edtMultiLine_about.setText(cv.getAbout());
        }
    }

    private void setupSharedPrefs() {
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        editor = prefs.edit();
    }

    private void setupViews() {
        edt_firstName = findViewById(R.id.edt_firstName);
        edt_lastName = findViewById(R.id.edt_lastName);
        edtEmail_email = findViewById(R.id.edtEmail_email);
        edtPhone_phone = findViewById(R.id.edtPhone_phone);
        edt_address = findViewById(R.id.edt_address);
        datePicker_dop = findViewById(R.id.datePicker_dop);
        edtMultiLine_about = findViewById(R.id.edtMultiLine_about);
    }

    public void btn_next_1_onClick(View view) {
        String firstName = edt_firstName.getText().toString();
        String lastName = edt_lastName.getText().toString();
        String dop = datePicker_dop.getDayOfMonth() + "/" + datePicker_dop.getMonth() + "/" + datePicker_dop.getYear();
        String email = edtEmail_email.getText().toString();
        String phone = edtPhone_phone.getText().toString();
        String address = edt_address.getText().toString();
        String about = edtMultiLine_about.getText().toString();

        CV cv = new CV(firstName, lastName, dop, email, phone, address, about);

        Gson gson = new Gson();
        String cvString = gson.toJson(cv);

        editor.putString(DATA, cvString);
        editor.commit();

        Intent intent = new Intent(this, SecondActivity.class);

        startActivity(intent);
    }
}