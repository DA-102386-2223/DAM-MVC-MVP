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

import cat.udl.tidic.amd.mvc2.models.UserModel;
import cat.udl.tidic.amd.mvc2.presenter.MainActivityPresenter;
import cat.udl.tidic.amd.mvc2.views.MainActivityActionView;

public class MainActivity extends AppCompatActivity implements MainActivityActionView {


    private TextView bioTextView;
    private EditText fullNameEditText;
    private DatePicker birthdayDatePicker;

    private MainActivityPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("MainActivity", "Starting onCreate() method");
        presenter = new MainActivityPresenter(this);

        bioTextView = findViewById(R.id.textView_bio);
        fullNameEditText = findViewById(R.id.editText_fullName);
        birthdayDatePicker = findViewById(R.id.datePicker_birthday);

    }

    @Override
    public void updateBio(String message) {
        bioTextView.setText(message);
    }

    public void resetButtonOnClick(View v){
        fullNameEditText.setText("");
        Calendar c = Calendar.getInstance();
        birthdayDatePicker.updateDate(c.get(Calendar.YEAR),c.get(Calendar.MONTH),
                c.get(Calendar.DAY_OF_MONTH));
        presenter.setModel("", new Date());
        presenter.showBio();
    }

    public void updateButtonOnClick(View view) {
        String name = fullNameEditText.getText().toString();
        Calendar c = Calendar.getInstance();
        c.set(birthdayDatePicker.getYear(),birthdayDatePicker.getMonth(),birthdayDatePicker.getDayOfMonth());
        Date birthday =  new Date(c.getTimeInMillis());
        presenter.setModel(name, birthday);
        presenter.showBio();
    }
}
