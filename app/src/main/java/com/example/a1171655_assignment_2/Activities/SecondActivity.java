package com.example.a1171655_assignment_2.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.a1171655_assignment_2.Models.CV;
import com.example.a1171655_assignment_2.Models.Experience;
import com.example.a1171655_assignment_2.R;
import com.google.gson.Gson;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    private EditText edt_company;
    private EditText edt_position;
    private Spinner spinner_domains;
    private EditText edt_location;
    private DatePicker datePicker_startDate;
    private DatePicker datePicker_endDate;
    private EditText txtMultiLine_exp;

    public static final String expDATA = "expData";
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        setupViews();
        initiateDomainsSpinner();
        setupSharedPrefs();
        checkLoadPrefs();
    }

    private void checkLoadPrefs() {
        String dataString = prefs.getString(expDATA, "");

        if (!dataString.equals("")) {
            txtMultiLine_exp.setText(dataString);
        }
    }

    private void setupSharedPrefs() {
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        editor = prefs.edit();
    }

    private void setupViews() {
        edt_company = findViewById(R.id.edt_company);
        edt_position = findViewById(R.id.edt_position);
        spinner_domains = findViewById(R.id.spinner_domains);
        edt_location = findViewById(R.id.edt_location);
        datePicker_startDate = findViewById(R.id.datePicker_startDate);
        datePicker_endDate = findViewById(R.id.datePicker_endDate);
        txtMultiLine_exp = findViewById(R.id.edtMultiLine_exp);
        txtMultiLine_exp.setEnabled(false);
    }

    private void initiateDomainsSpinner() {
        ArrayList<String> domains = new ArrayList<>();

        domains.add("Security");
        domains.add("Finance");
        domains.add("Sales");
        domains.add("Shipping");
        domains.add("Stock Control");
        domains.add("Customer Support");
        domains.add("IT Helpdesk");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, domains);

        spinner_domains.setAdapter(adapter);
    }


    public void btn_addExp_onClick(View view) {
        String company = edt_company.getText().toString();
        String position = edt_position.getText().toString();
        String domain = spinner_domains.getSelectedItem().toString();
        String location = edt_location.getText().toString();
        String startDate = datePicker_startDate.getDayOfMonth() + "/" + datePicker_startDate.getMonth() + "/" + datePicker_startDate.getYear();
        String endDate = datePicker_endDate.getDayOfMonth() + "/" + datePicker_endDate.getMonth() + "/" + datePicker_endDate.getYear();

        Experience experience = new Experience(company, position, domain, location, startDate, endDate);

        //if (!edt_company.getText(). || !edt_company.getText().equals("")){
            txtMultiLine_exp.append("Company: " + experience.getCompany() +
                    ", Position: " + experience.getPosition() +
                    "\nLocation: " + experience.getLocation() +
                    ", Domain: " + experience.getDomain() +
                    "\n" + experience.getStartDate() +
                    " - " + experience.getEndDate() +
                    "\n----------------------------------------------------------\n");
       /* } else {
            Toast.makeText(this,"Please add a company first!", Toast.LENGTH_SHORT).show();
        }*/
    }

    public void btn_save_onClick(View view) {
        String experiences = txtMultiLine_exp.getText().toString();

        editor.putString(expDATA, experiences);
        editor.commit();

        Toast.makeText(this, "Experiences Saved", Toast.LENGTH_SHORT).show();
    }
}