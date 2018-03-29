package camp.bso.inf.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import camp.bso.inf.myapplication.Food;
import camp.bso.inf.myapplication.R;

/**
 * Created by MUL17 on 2/8/2018.
 */

public class FoodListAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<Food> foodsList;

    public FoodListAdapter(Context context,int layout,ArrayList<Food> foodsList){
        this.context = context;
        this.layout = layout;
        this.foodsList = foodsList;
    }

    @Override
    public int getCount(){
        return foodsList.size();
    }

    @Override
    public Object getItem(int position){
        return foodsList.get(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    private class ViewHolder{
        ImageView imageView;
        TextView txtName,txtAsal;
    }

    @Override
    public View getView (int position, View view, ViewGroup viewGroup){

        View row = view;
        ViewHolder holder = new ViewHolder();

        if(row == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout,null);

            holder.txtName = (TextView) row.findViewById(R.id.txtName);
            holder.txtAsal = (TextView) row.findViewById(R.id.txtAsal);
            holder.imageView = (ImageView) row.findViewById(R.id.imgFood);
            row.setTag(holder);
        }
        else{
            holder = (ViewHolder) row.getTag();

        }

        Food food = foodsList.get(position);

        holder.txtName.setText(food.getName());
        holder.txtAsal.setText(food.getAsal());

        byte[] foodImage = food.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(foodImage, 0,foodImage.length);
        holder.imageView.setImageBitmap(bitmap);


        return row;
    }



}