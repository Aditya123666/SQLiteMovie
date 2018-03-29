package aditya.recycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ArrayList <Sport> mSportsData;
    private SportsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        //
        mRecyclerView.setLayoutManager(new LinearLayoutManager(context:this));

        //
        mAdapter = new SportsAdapter(context:this,mSportsData);
        mRecyclerView.setAdapter(mAdapter);

        //get the data
        initializeData();

        ItemTouchHelper helper =



    }
}
