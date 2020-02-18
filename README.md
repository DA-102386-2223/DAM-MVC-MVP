# DAM-MVC-Active 

Course: Development of Mobile Applications (DAM)

## Description

Android Project using Java. This is an example of how to apply the MVC pattern using observers.

## Requirements
* Age App (Course sample Android App).

## New stuff
* DatePicker widget: We update the year,month,day birthday form to a Widget a DatePicker. 

## Code Structure:

### Master branch
* Model: A class that represents a user with a name (string) and a birthday (date). This will be the observable object. It will notify changes in its attributes (name and birthday) to the observers.
* Controller: MainActivity will act as the controller which registers the observers and define the model to observe.
* View: MainActivity will also act as the view.

### Using controller
* Model: A class that represents a user with a name (string) and a birthday (date). This will be the observable object. It will notify changes in its attributes (name and birthday) to the observers.
* Controller: UserController interacts with UserModel
* View: MainActivity act as the view and interacts only with the user inputs and is controlled by UserController.
