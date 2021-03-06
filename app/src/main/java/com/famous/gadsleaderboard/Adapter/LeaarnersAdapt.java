package com.famous.gadsleaderboard.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.famous.gadsleaderboard.Module.Learn;
import com.famous.gadsleaderboard.R;

import java.util.List;

public class LeaarnersAdapt extends RecyclerView.Adapter<LeaarnersAdapt.LearnersAdapterVH>
{

    private List<Learn> LearnersList;
    private Context context;

    public LeaarnersAdapt(Context context, List<Learn> learnersList) {
        LearnersList = learnersList;
        this.context = context;
    }


    @NonNull
    @Override
    public LearnersAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new LeaarnersAdapt.LearnersAdapterVH(LayoutInflater.from(context).inflate(R.layout.data, parent, false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull LearnersAdapterVH holder, int position) {

        Learn userResponse = LearnersList.get(position);

        String username = userResponse.getName();
        String country = userResponse.getCountry();
        String image = userResponse.getBadgeUrl();
        String hours = userResponse.getHours() + "";//learning hours,
        String scores = userResponse.getScore() + "";// " Skill IQ Score,


        holder.username.setText(username);


        holder.country.setText(country);

        Glide.with(context)
                .load(image)
                .into(holder.imageMore);

        if (scores.equals("null")) {
            holder.hours.setText(hours + " learning hours,");
        }
        if (hours.equals("null")) {
            holder.scores.setText(scores + " Skill IQ Score,");
        }


    }

    @Override
    public int getItemCount() {
        return LearnersList.size();
    }

    public class LearnersAdapterVH extends RecyclerView.ViewHolder {

        TextView username, hours, country, scores;
        ImageView imageMore;

        public LearnersAdapterVH(@NonNull View itemView) {
            super(itemView);
            username = itemView.findViewById(R.id.username);
            hours = itemView.findViewById(R.id.hours);
            scores = itemView.findViewById(R.id.scores);
            country = itemView.findViewById(R.id.country);
            imageMore = itemView.findViewById(R.id.imageMore);


        }
    }

}
