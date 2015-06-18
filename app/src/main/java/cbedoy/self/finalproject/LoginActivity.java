package cbedoy.self.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import cbedoy.self.finalproject.entities.User;

/**
 * Created by Carlos Bedoy on 6/18/15.
 * <p/>
 * Mobile App Developer - Exchange Android
 * <p/>
 * Pademobile
 */
public class LoginActivity extends ActionBarActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        Bundle extras = getIntent().getExtras();

        final EditText username = (EditText) findViewById(R.id.username);
        final EditText password = (EditText) findViewById(R.id.password);

        username.setText(extras != null && extras.containsKey("username") ? extras.getString("username") : "");

        password.setText(extras != null && extras.containsKey("password") ? extras.getString("password") : "");


        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                List<User> users = User.find(User.class, "username = ? and password ? ", username.getText().toString(), password.getText().toString());

                if(users != null && users.size() > 0){

                    Intent intent = new Intent(getApplicationContext(), MapActivity.class);

                    intent.putExtra("username", username.getText().toString());
                    intent.putExtra("password", password.getText().toString());

                    startActivity(intent);

                }else {
                    Toast.makeText(getApplicationContext(), "User dont found :c ", Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}
