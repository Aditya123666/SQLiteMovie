package aditya.recycleview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by Harun on 12/2/2017.
 */

public class SportsAdapter extends RecyclerView.Adapter<SportsAdapter.ViewHolder  {
    //
    private ArrayList<Sport>mSportsData;
    private Context mContext;




    SportsAdapter(Context context,ArrayList<Sport> sportsData){
        this.mSportsData = sportsData;
        this.mContext = context;
    }
    @Override
    public SportsAdapter.ViewHolder onCreateViewHolder (ViewGroup parent,int viewType){
        return new ViewHolder (LayoutInflater.from(mContext).inflate(R.layout.List_item,parent,attachToRoot:false));
    }
    @Override
    public void onBindViewHolder (SportsAdapter.ViewHolder holder,int position){
        //
        Sport currentSport = mSportsData.get(position);
        //
        holder.bindTo(currentSport);
        Glide.with(mContext).load(currentSport.getImageResources()).into(holder.mSportsImage);
    }
    @Override
    public int getItemCount(){
        return mSportsData.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView mTitleText;
        private TextView mInfoText;
        private ImageView mSportsImage;
        private Sport currentSport;

        ViewHolder(View itemView){
            super(itemView);
            mTitleText = (TextView) itemView.findViewById(R.id.title);
            mInfoText = (TextView) itemView.findViewById(R.id.subTitle);
            mSportsImage = (ImageView) itemView.findViewById(R.id.sportsImage);
            itemView.setOnClickListener(this);
        }
        void  bindTo (Sport currentSport){
            //
            mTitleText.setText(currentSport.getTitle());
            mInfoText.setText(currentSport.getInfo());
            //
            this.currentSport = currentSport;
        }
        @Override
        public void onClick (View view){
            Intent detailIntent = new Intent(mContext,DetailActivity.class);
            detailIntent.putExtra(name : "title",currentSport.getTitle());
            detailIntent.putExtra(name: "image_resource",currentSport.getImageResource());
            mContext.startActivity(detailIntent);
        }
    }

}
