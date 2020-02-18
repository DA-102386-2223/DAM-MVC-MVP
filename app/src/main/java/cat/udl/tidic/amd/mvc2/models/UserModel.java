package cat.udl.tidic.amd.mvc2.models;

import android.util.Log;

import androidx.annotation.NonNull;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Observable;

public class UserModel extends Observable {
    private String TAG = "UserModel";
    private String fullName;
    private Date birthday;


    public UserModel() {
        this.fullName = "";
        this.birthday = new Date();
    }

    public UserModel(String fullName, Date birthday) {
        this.fullName = fullName;
        this.birthday = birthday;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {

        Log.d(TAG,"Set fullName to the model");
        this.fullName = fullName;
        setChanged();
        Log.d(TAG,"Model is updated, let's notify observers");
        notifyObservers();
    }

    public Date getBirthday() {
        return birthday;
    }

    private int getAge() {

        // JAVA 7
        DateFormat formatter = new SimpleDateFormat("yyyyMMdd", Locale.US);
        int d1 = Integer.parseInt(formatter.format(this.birthday));
        int d2 = Integer.parseInt(formatter.format(new Date()));
        return (d2 - d1) / 10000;

        // JAVA 8
        //  return Period.between(birthDate, currentDate).getYears();

        // Using Joda-Time

        // <dependency>
        //  <groupId>joda-time</groupId>
        //  <artifactId>joda-time</artifactId>
        //  <version>2.10</version>
        //</dependency>

        // Years age = Years.yearsBetween(birthDate, currentDate);

    }


    public void setBirthday(Date birthday) {
        this.birthday = birthday;
        setChanged();
        notifyObservers();
    }

    @NonNull
    @Override
    public String toString(){
        Log.d(TAG,"Transform the object into a readable string");
        if (this.fullName.contentEquals("")){
            return "";
        }else{
            return "Hola, el meu nom és " + this.fullName + ". Tinc " + this.getAge() + " anys. ";
        }

    }
}
