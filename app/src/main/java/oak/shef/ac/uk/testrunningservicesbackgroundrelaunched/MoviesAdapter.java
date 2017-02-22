package oak.shef.ac.uk.testrunningservicesbackgroundrelaunched;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {

    private List<Datum> moviesList;
    Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, Fname, LName;
                ImageView img;
        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.tvUserId);
            Fname = (TextView) view.findViewById(R.id.tvFirstName);
            LName = (TextView) view.findViewById(R.id.tvLastName);
            img= (ImageView) view.findViewById(R.id.IvCustomImage);
        }
    }


    public MoviesAdapter(List<Datum> moviesList, Context context) {
        this.moviesList = moviesList;
        this.context=context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_list_raw, parent, false);

        return new MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final Datum movie = moviesList.get(position);
        holder.title.setText(movie.getId()+"");
        holder.Fname.setText(movie.getFirst_name()+"");
        holder.LName.setText(movie.getLast_name()+"");
        Picasso.with(context).load(movie.getAvatar()).into(holder.img);

        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoFragmentMainActivity=new Intent(context, DisplayUserDetailsActivity.class);
                gotoFragmentMainActivity.putExtra("img",movie.getAvatar());
                gotoFragmentMainActivity.putExtra("id",movie.getId());
                gotoFragmentMainActivity.putExtra("fn",movie.getFirst_name());
                gotoFragmentMainActivity.putExtra("ln",movie.getLast_name());
                context.startActivity(gotoFragmentMainActivity);
            }
        });
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}