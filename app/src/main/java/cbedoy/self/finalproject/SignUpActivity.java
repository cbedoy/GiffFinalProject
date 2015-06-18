package cbedoy.self.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import cbedoy.self.finalproject.entities.User;

/**
 * Created by Carlos Bedoy on 6/18/15.
 * <p/>
 * Mobile App Developer - Exchange Android
 * <p/>
 * Pademobile
 */
public class SignUpActivity extends ActionBarActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activty_sign_up);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = ((EditText) findViewById(R.id.your_name)).getText().toString();
                String password = ((EditText) findViewById(R.id.password)).getText().toString();
                String confirmPassword = ((EditText) findViewById(R.id.confirm_password)).getText().toString();

                if(password.equals(confirmPassword))
                {
                    User user = new User();
                    user.name = username;
                    user.password = password;
                    user.save();

                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    intent.putExtra("username", username);
                    intent.putExtra("password", password);

                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Unable credentials", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
