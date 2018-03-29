package camp.bso.inf.myapplication;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import java.util.ArrayList;

/**
 * Created by MUL17 on 2/8/2018.
 */

public class FoodList extends AppCompatActivity {
    GridView gridView;
    ArrayList<Food> list;
    FoodListAdapter adapter = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_list_activity);

        gridView = (GridView) findViewById(R.id.gridView);
        list = new ArrayList<>();
        adapter = new FoodListAdapter(this,R.layout.food_items,list);
        gridView.setAdapter(adapter);

        //ambil dari sqlite
        Cursor cursor = MainActivity.sqLiteHelper.getData("SELECT * FROM FOOD");
        list.clear();
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String asal = cursor.getString(2);
            byte[] image = cursor.getBlob(3);

            list.add(new Food(name,asal,image,id));
        }
        adapter.notifyDataSetChanged();
    }
}