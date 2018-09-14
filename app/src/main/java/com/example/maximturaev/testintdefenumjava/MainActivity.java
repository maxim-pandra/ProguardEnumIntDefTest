package com.example.maximturaev.testintdefenumjava;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private TextView mTextMessage;

    private StateEnum mStateEnum;

    @StateIntDef
    private int mStateIntDef;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    mStateEnum = StateEnum.STARTED;
                    mStateIntDef = StateIntDef.IDLE;
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    mStateEnum = StateEnum.RESUMED;
                    mStateIntDef = StateIntDef.FINISHED;
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    mStateEnum = StateEnum.CREATED;
                    mStateIntDef = StateIntDef.RUNNING;
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "Enum = " + (mStateEnum == StateEnum.CREATED) + " IntDef = " + (mStateIntDef == StateIntDef.RUNNING));
    }
}
