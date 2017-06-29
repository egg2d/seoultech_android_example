package android.bins.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class SubActivity extends AppCompatActivity {
    private final static String TAG = SubActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void onStart() {

        Log.d(TAG,"on Start");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d(TAG,"on Resume");
        super.onResume();
    }


    @Override
    protected void onPause() {
        Log.d(TAG,"on Pause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(TAG,"on Stop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
