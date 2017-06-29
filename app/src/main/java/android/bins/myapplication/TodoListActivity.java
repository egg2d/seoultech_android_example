package android.bins.myapplication;

import android.app.Activity;
import android.bins.myapplication.adapter.TodoAdapter;
import android.bins.myapplication.model.Todo;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class TodoListActivity extends AppCompatActivity implements View.OnClickListener , AdapterView.OnItemClickListener {

    private final static int REQUEST_CODE_ADD =1;
    private final static  int REQUEST_CODE_DETAIL =2;


    private ListView listView;
    private TodoAdapter adapter;
    private EditText etTitle;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list);

        listView = (ListView) findViewById(R.id.list_view); // 리스트 뷰 가져옴
        etTitle = (EditText) findViewById(R.id.et_title);

        findViewById(R.id.btn_save).setOnClickListener(this);
        // 버튼 누르면 onclicklistener 연결

        List<Todo> items =findTodoList();
        adapter = new TodoAdapter(this,R.layout.list_item_todo,items);
        // 데이터아 어댑터 가져옴
        listView.setAdapter(adapter);
        // 연결

        listView.setOnItemClickListener(this);


    }

    private List<Todo> findTodoList() {
        List<Todo> list = new ArrayList<Todo>();
        for (int i = 0; i < 40; i++) {
            list.add(new Todo(0l, "제목", "내용", new Date()));
        }
        return list;
    }



    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.btn_save :
            {
               String title = etTitle.getText().toString();
                Todo todo = new Todo(0l, title,"", new Date());

                adapter.addItem(0, todo); //
                etTitle.setText(""); // 데이터 추가 후에 입력창 공백화
                hideKeyboard(etTitle); // 데이터 입력후에 키보드 숨기기기
                // break;
            }



        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {  // 메뉴를 만드는것

        getMenuInflater().inflate(R.menu.menu_todo_list,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) { // 메뉴를 클릭했을때때 (실행했을때)

        switch (item.getItemId())
        {
            case R.id.menu_add :{

                Intent intent = new Intent(this, TodoAddActivity.class);
                startActivityForResult(intent, REQUEST_CODE_ADD);
                return true;
            }
        }
        return false;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode != Activity.RESULT_OK) return; // 비정상일 경우

        if(requestCode == REQUEST_CODE_ADD){ //정상일경우

            Todo todo = (Todo) data.getSerializableExtra("todo"); // 데이터 가져오기
            adapter.addItem(0,todo); // 넣어주기
        }else if(requestCode== REQUEST_CODE_DETAIL)
        {
          Todo todo = (Todo) data.getSerializableExtra("todo");
            int position = data.getIntExtra("position",-1);
            adapter.setItem(position,todo);

        }

      }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

        Todo todo = (Todo) adapter.getItem(position);
        Intent intent = new Intent(this, TodoDetailActivity.class);
        intent.putExtra("todo",todo);
        intent.putExtra("position",position);

        startActivityForResult(intent, REQUEST_CODE_DETAIL);
    }

    private void hideKeyboard(EditText editText){ // 가상 키보드 닫기
        InputMethodManager imm =
                (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }

}
