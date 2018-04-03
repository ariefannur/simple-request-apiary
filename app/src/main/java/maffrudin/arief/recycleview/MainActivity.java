package maffrudin.arief.recycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;


public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.title);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

       // toolbar.setNavigationIcon(R.drawable.ic_launcher_foreground);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("AF ", "ini click ");
            }
        });

        recyclerView= findViewById(R.id.rv_main);

        /*StaggeredGridLayoutManager gridLayoutManager =
                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);*/
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Adapter adapter = new Adapter();
        recyclerView.setAdapter(adapter);


    }


    class Adapter extends RecyclerView.Adapter<ViewHolder>{

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cell, null, false);

            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 10;
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder{


        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_home, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        /*switch (item.getItemId()){
            case R.id.id_title:
                Log.d("AF", "ini click menu");

                break;

        }*/

        if(item.getItemId() == R.id.id_title){
            Log.d("AF", "ini click menu");
        }

        return super.onOptionsItemSelected(item);
    }
}
