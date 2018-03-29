import android.content.Context;

public class ListPresidentAdapter extends RecyclerView.Adapter<ListPresidentAdapter>.Category
    private Context context;
    public Arraylist<President>getListPresident(){
        return listPresident;
    }
    public void setListPresident(ArrayList<President>listPresident){
        this.listPresident = listPresident;
    }
    private ArrayList<President>ListPresident;
    public ListPresidentAdapter(Context context){
        this.context=context;
    }