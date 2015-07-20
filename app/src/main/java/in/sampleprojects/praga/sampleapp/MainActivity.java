package in.sampleprojects.praga.sampleapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {

    EditText userEmail;
    EditText userPwd;
    TextView dbout;
    MyDbHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userEmail = (EditText) findViewById(R.id.userEmail);
        userPwd = (EditText) findViewById(R.id.userPWD);
        dbout = (TextView) findViewById(R.id.dbout);
        dbHandler = new MyDbHandler(this, null, null, 1);
        printDatabase();
    }


    //Add a product to the database
    public void onLoginClicked(View view){
        User user = new User(userEmail.getText().toString(), userPwd.getText().toString());
        dbHandler.addUser(user);
        printDatabase();
    }

    //Print the database
    public void printDatabase(){
        String dbString = dbHandler.databaseToString();
        dbout.setText(dbString);
        userEmail.setText("");
        userPwd.setText("");

    }


}
