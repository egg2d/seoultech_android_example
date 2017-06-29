package android.bins.myapplication;

import android.bins.myapplication.model.Todo;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class TodoDetailActivity extends AppCompatActivity {

    private EditText etTitle;
    private EditText etContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_detail);

        etTitle = (EditText) findViewById(R.id.et_title);
        etContent = (EditText) findViewById(R.id.et_content);

        Intent intent = getIntent();
        Todo todo = (Todo) intent.getSerializableExtra("todo");

        etTitle.setText(todo.getTitle());
        etContent.setText(todo.getContent());

    }



}
