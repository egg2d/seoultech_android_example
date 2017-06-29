package android.bins.myapplication;

import android.bins.myapplication.model.Todo;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import java.util.Date;

public class TodoAddActivity extends AppCompatActivity {

    private EditText etTitle;
    private  EditText etContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_add);

        etTitle = (EditText) findViewById(R.id.et_title);
        etContent = (EditText) findViewById(R.id.et_content);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_todo_add, menu);

        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch(item.getItemId())
        {
            case R.id.menu_save :
            {
                String title = etTitle.getText().toString();
                String content = etContent.getText().toString();

                Todo todo = new Todo(0l,title, content, new Date());

                Intent intent = new Intent();
                intent.putExtra("todo",todo);

                setResult(RESULT_OK, intent);
                finish();
                return true;
            }

        }


        return super.onOptionsItemSelected(item);
    }


}
