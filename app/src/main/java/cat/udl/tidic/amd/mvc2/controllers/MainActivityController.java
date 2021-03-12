package cat.udl.tidic.amd.mvc2.controllers;

import cat.udl.tidic.amd.mvc2.models.UserModel;
import cat.udl.tidic.amd.mvc2.views.MainView;

public class MainActivityController {

    public UserModel model;
    public MainView view;

    public MainActivityController(UserModel model) {
        this.model = model;
    }

    public void bind(MainView view){
        this.view  = view;
    }

    public void onUpdateButtonClicked(){

        model.setFullName(view.getUsername());
        model.setBirthday(view.getBirthday());

    }
}
