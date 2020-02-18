package cat.udl.tidic.amd.mvc2.controllers;

import java.util.Calendar;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

import cat.udl.tidic.amd.mvc2.MainActivity;
import cat.udl.tidic.amd.mvc2.models.UserModel;

public class UserController implements Observer {

    private UserModel model;
    private MainActivity view;

    public UserController(MainActivity view){
        this.view = view;
        this.model = new UserModel();
        this.model.addObserver(this);

    }


    public void setUserFullName(String fullName){
        this.model.setFullName(fullName);
    }

    public void setUserBirthday(Date birthday){
        this.model.setBirthday(birthday);
    }

    @Override
    public void update(Observable o, Object arg) {
        this.view.updateBio(this.model.toString());
    }
}
