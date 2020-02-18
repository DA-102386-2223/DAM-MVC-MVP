package cat.udl.tidic.amd.mvc2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

import cat.udl.tidic.amd.mvc2.controllers.UserController;
import cat.udl.tidic.amd.mvc2.models.UserModel;

public class MainActivity extends AppCompatActivity {


    private TextView bioTextView;
    private EditText fullNameEditText;
    private DatePicker birthdayDatePicker;


    private UserController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("MainActivity", "Starting onCreate() method");
        bioTextView = findViewById(R.id.textView_bio);
        fullNameEditText = findViewById(R.id.editText_fullName);
        birthdayDatePicker = findViewById(R.id.datePicker_birthday);
    }


    public void updateBio(String bio){
        bioTextView.setText(bio);
    }


    public void updateButtonOnClick(View v){
        controller.setUserFullName(fullNameEditText.getText().toString());
        Calendar c = Calendar.getInstance();
        c.set(birthdayDatePicker.getYear(), birthdayDatePicker.getMonth(),
                birthdayDatePicker.getDayOfMonth());
        Date birthday = new Date(c.getTimeInMillis());
        controller.setUserBirthday(birthday);
    }

    public void resetButtonOnClick(View v){
        controller.setUserFullName("");
        controller.setUserBirthday(new Date());
        fullNameEditText.setText("");
        Calendar c = Calendar.getInstance();
        birthdayDatePicker.updateDate(c.get(Calendar.YEAR),c.get(Calendar.MONTH),
                c.get(Calendar.DAY_OF_MONTH));
    }

    public void clearNameEditTextOnClick(View v){
        fullNameEditText.setText("");
    }
}
