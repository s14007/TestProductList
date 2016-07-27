package com.example.s14007.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ListViewの読み込み
        ListView listView = (ListView)findViewById(R.id.listViewItem);

// Adapterの作成
        final ArrayList<Person> personList = new ArrayList<Person>();
        personList.add(new Person("田中さん", "登山"));
        personList.add(new Person("渡辺さん", "水泳"));
        personList.add(new Person("山本さん", "映画鑑賞"));
        personList.add(new Person("山田さん", "ランニング"));
        personList.add(new Person("佐藤さん", "料理"));
        final PersonAdapter adapter = new PersonAdapter(MainActivity.this, personList);

// Adapterの設定
        assert listView != null;
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        // ボタンクリックイベント
        Button btn = (Button)findViewById(R.id.btnCheck);
        assert btn != null;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 選択アイテムを取得
                ListView listView = (ListView) findViewById(R.id.listViewItem);
                assert listView != null;
                SparseBooleanArray checked = listView.getCheckedItemPositions();
                Log.e("checkedSize:", String.valueOf(checked.size()));

                List<Person> list = adapter.getSelectList();
                for (Person name : list) {
                    Log.e("List:", name.getName());
                    Log.e("listHobby:", name.getHobby());
                }
            }
        });
    }
}