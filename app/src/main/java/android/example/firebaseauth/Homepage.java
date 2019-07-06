package android.example.firebaseauth;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Homepage extends AppCompatActivity {
   private FirebaseAuth mauth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        WebView web =findViewById(R.id.web);
        web.loadUrl("https://github.com/vipul1298");
        web.setWebViewClient(new WebViewClient());

        FirebaseUser muser=FirebaseAuth.getInstance().getCurrentUser();
        String email=((FirebaseUser) muser).getEmail();
        Toast.makeText(this,email, Toast.LENGTH_SHORT).show();

    }
}
