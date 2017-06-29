package android.bins.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.webkit.ConsoleMessage.MessageLevel.LOG;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final static String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG,"on create");


        Button btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(this);

        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn_login).setOnClickListener(this);
        findViewById(R.id.btn_simple_list).setOnClickListener(this);
        findViewById(R.id.btn_todo_list).setOnClickListener(this);
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


    @Override
    public void onClick(View view) {

        switch(view.getId())
        {
            case R.id.btn1 :{

                Toast.makeText(this,String.valueOf(R.id.btn1), Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.btn2 :
            {
                Intent intent = new Intent(this, SubActivity.class);
                startActivity(intent);
                break;
            }

            case R.id.btn_login :
            {
                startActivity(new Intent(this, LoginActivity.class));
                break;

            }

            case R.id.btn_simple_list :
            {
                startActivity(new Intent(this, SimpleListActivity.class));
                break;
            }

            case R.id.btn_todo_list :{

                startActivity(new Intent(this, TodoListActivity.class));
                break;
            }

        }


    }


}
