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

import cat.udl.tidic.amd.mvc2.models.UserModel;

public class MainActivity extends AppCompatActivity implements Observer {


    private TextView bioTextView;
    private EditText fullNameEditText;
    private DatePicker birthdayDatePicker;


    private UserModel user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("MainActivity", "Starting onCreate() method");

        bioTextView = findViewById(R.id.textView_bio);
        fullNameEditText = findViewById(R.id.editText_fullName);
        birthdayDatePicker = findViewById(R.id.datePicker_birthday);

        user = new UserModel();
        user.addObserver(this);

    }

    @Override
    public void update(Observable o, Object arg) {
        String TAG = "MVCLog";
        Log.d(TAG,"Observer notifies changes..., so let's update the user bio with the new information about the user.");
        bioTextView.setText(user.toString());

    }


    public void updateButtonOnClick(View v){
        user.setFullName(fullNameEditText.getText().toString());

        Calendar c = Calendar.getInstance();
        c.set(birthdayDatePicker.getYear(), birthdayDatePicker.getMonth(),
                birthdayDatePicker.getDayOfMonth());
        Date birthday = new Date(c.getTimeInMillis());
        user.setBirthday(birthday);
    }

    public void resetButtonOnClick(View v){
        user.setFullName("");
        user.setBirthday(new Date());
        fullNameEditText.setText("");
        Calendar c = Calendar.getInstance();
        birthdayDatePicker.updateDate(c.get(Calendar.YEAR),c.get(Calendar.MONTH),
                c.get(Calendar.DAY_OF_MONTH));
    }

    public void clearNameEditTextOnClick(View v){
        fullNameEditText.setText("");
    }
}
