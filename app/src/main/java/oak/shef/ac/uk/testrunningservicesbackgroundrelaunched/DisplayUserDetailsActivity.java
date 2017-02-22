package oak.shef.ac.uk.testrunningservicesbackgroundrelaunched;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class DisplayUserDetailsActivity extends AppCompatActivity {

    private static FragmentManager fragmentManager;
    String img,id,fn,ln;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_user_details);
        Intent intent = getIntent();
        img = intent.getStringExtra("img");
        id = intent.getStringExtra("id");
        fn = intent.getStringExtra("fn");
        ln = intent.getStringExtra("ln");
        fragmentManager = getSupportFragmentManager();



        Fragment argumentFragment1 = new FragmentOneForImageActivity();
        Bundle data = new Bundle();//Use bundle to pass data
        data.putString("image",img);//put string, int, etc in bundle with a key value
        data.putString("email",id);
        argumentFragment1.setArguments(data);
        fragmentManager.beginTransaction().replace(R.id.myFirstFragment, argumentFragment1).commit();

        Fragment argumentFragment2 = new FragmentActivityForTextActivity();
        Bundle data1 = new Bundle();//Use bundle to pass data
        data1.putString("fname",fn);//put string, int, etc in bundle with a key value
        data1.putString("lname",ln);
        argumentFragment2.setArguments(data1);
        fragmentManager.beginTransaction().replace(R.id.mySecondFragment, argumentFragment2).commit();



    }
}
