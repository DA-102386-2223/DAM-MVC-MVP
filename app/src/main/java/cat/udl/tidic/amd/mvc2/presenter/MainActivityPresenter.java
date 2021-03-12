package cat.udl.tidic.amd.mvc2.presenter;

import java.util.Date;
import java.util.Observable;
import java.util.Observer;

import cat.udl.tidic.amd.mvc2.MainActivity;
import cat.udl.tidic.amd.mvc2.models.UserModel;
import cat.udl.tidic.amd.mvc2.views.MainActivityActionView;

public class MainActivityPresenter  {

    public UserModel model;
    public MainActivityActionView view;

    public MainActivityPresenter(MainActivityActionView view) {
        this.view = view;
    }

    public void setModel(String name, Date birthday) {
        this.model = new UserModel(name,birthday);
    }

    public void showBio(){
        view.updateBio(this.model.toString());
    }
}
