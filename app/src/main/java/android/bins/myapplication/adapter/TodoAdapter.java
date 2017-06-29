package android.bins.myapplication.adapter;

import android.bins.myapplication.R;
import android.bins.myapplication.model.Todo;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;


/**
 * Created by lg on 2017-06-27.
 */

public class TodoAdapter extends BaseAdapter {

    private Context context;
    private int layoutId;
    private List<Todo> items;
    private LayoutInflater inflater;

    // adapter 한건 이상의 데이터를 ui에 공급
    // listview는 list ui를 구성

    private SimpleDateFormat sdf;

    public TodoAdapter() {


    }

    public TodoAdapter(Context context, int layoutId, List<Todo> items) {
        this.context = context;
        this.layoutId = layoutId;
        this.items = items;
        this.inflater = LayoutInflater.from(context);

        sdf = new SimpleDateFormat("yyyy.MM.dd");
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return items.get(position).getId();
    }

    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {

        if (convertView == null) {

            convertView = inflater.inflate(this.layoutId, null); //  inflateter: view 객체를 만드는 역할
        //  스크롤을 할 떄 없으면 새로만들어와(?) 뷰를 만들어 놓고 값만 올려가며 뷰를 재사용하는 개념
        }

        TextView txtCreateAt = (TextView) convertView.findViewById(R.id.txt_create_at);
        TextView txtTitle = (TextView) convertView.findViewById(R.id.txt_title);
        TextView txtContent = (TextView) convertView.findViewById(R.id.txt_content);
        // 뷰 객체 찾아오기
        Todo todo = this.items.get(position);
        txtCreateAt.setText(sdf.format(todo.getCreateAt())); // 날짜 표현하는 공간
        txtTitle.setText(todo.getTitle());
        txtContent.setText(todo.getContent());
        // 뷰객체에 해당값 넣어주기
        return convertView;
    }

    public void addItem(int index, Todo todo)
    {
        this.items.add(index, todo); // 데이터 넣기
        notifyDataSetChanged(); // 데이터가 변경되었으니 뷰를 새로 받아와라 메서드
    }

    public void setItem(int index, Todo todo)
    {
       this.items.set(index, todo);
        notifyDataSetChanged();
    }

    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }
}
