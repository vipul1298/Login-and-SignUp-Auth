package android.example.firebaseauth;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mauth;
    Button sn;
    String Email,Password;
    EditText e,p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sn=findViewById(R.id.sign);
        e=findViewById(R.id.email);
        p=findViewById(R.id.password);
        mauth=FirebaseAuth.getInstance();

        sn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Email=e.getText().toString();
                Password=p.getText().toString();
                if(p.getText().length()>=6){
                    SignUp(Email,Password);
                }
            }
        });

    }
    public void SignUp(String email,String password){
        mauth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(getApplicationContext(),"Registration Successful",Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(getApplicationContext(),"Already registered",Toast.LENGTH_LONG).show();
                            startActivity(new Intent(MainActivity.this,Login.class));
                        }

                        // ...
                    }
                });
    }

}
