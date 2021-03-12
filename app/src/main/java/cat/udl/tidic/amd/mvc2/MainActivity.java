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

import cat.udl.tidic.amd.mvc2.controllers.MainActivityController;
import cat.udl.tidic.amd.mvc2.models.UserModel;
import cat.udl.tidic.amd.mvc2.views.MainView;

public class MainActivity extends AppCompatActivity implements Observer, MainView {


    private TextView bioTextView;
    private EditText fullNameEditText;
    private DatePicker birthdayDatePicker;


    private UserModel model = new UserModel();
    private MainActivityController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("MainActivity", "Starting onCreate() method");
        controller = new MainActivityController(model);
        controller.bind(this);

        bioTextView = findViewById(R.id.textView_bio);
        fullNameEditText = findViewById(R.id.editText_fullName);
        birthdayDatePicker = findViewById(R.id.datePicker_birthday);

    }

    @Override
    public void onStart(){
        super.onStart();
        model.addObserver(this);
    }

    @Override
    public void onStop(){
        super.onStop();
        model.deleteObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        String TAG = "MVCLog";
        Log.d(TAG,"Observer notifies changes..., so let's update the user bio with the new information about the user.");
        bioTextView.setText(model.toString());

    }

    public void updateButtonOnClick(View v){
        controller.onUpdateButtonClicked();
    }

    public void resetButtonOnClick(View v){
        fullNameEditText.setText("");
        Calendar c = Calendar.getInstance();
        birthdayDatePicker.updateDate(c.get(Calendar.YEAR),c.get(Calendar.MONTH),
                c.get(Calendar.DAY_OF_MONTH));
        controller.onUpdateButtonClicked();
    }

    public void clearNameEditTextOnClick(View v){
        fullNameEditText.setText("");
    }

    @Override
    public String getUsername() {
        return fullNameEditText.getText().toString();
    }

    @Override
    public Date getBirthday() {
        Calendar c = Calendar.getInstance();
        c.set(birthdayDatePicker.getYear(), birthdayDatePicker.getMonth(),
                birthdayDatePicker.getDayOfMonth());
        return new Date(c.getTimeInMillis());
    }
}
