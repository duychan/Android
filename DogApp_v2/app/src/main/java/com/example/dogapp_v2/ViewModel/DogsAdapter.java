package com.example.dogapp_v2.ViewModel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dogapp_v2.Model.DogBreed;
import com.example.dogapp_v2.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DogsAdapter extends RecyclerView.Adapter<DogsAdapter.ViewHolder> {
    private ArrayList<DogBreed> dogBreeds;
    public DogsAdapter(ArrayList<DogBreed> _dogBreeds){
        this.dogBreeds = _dogBreeds;
    }
    @NonNull
    @Override
    public DogsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dog_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DogsAdapter.ViewHolder holder, int position) {
        holder.tvName.setText(dogBreeds.get(position).getName());
        holder.tvOrigin.setText(dogBreeds.get(position).getOrigin());
        Picasso.get().load(dogBreeds.get(position).getUrl()).into(holder.imgAvt);
    }

    @Override
    public int getItemCount() {
        return dogBreeds.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgAvt;
        public TextView tvName;
        public TextView tvOrigin;
        public ViewHolder(View view) {
            super(view);
            imgAvt = view.findViewById(R.id.img_avt);
            tvName = view.findViewById(R.id.tv_name);
            tvOrigin = view.findViewById(R.id.tv_origin);
            // Define click listener for the ViewHolder's View
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Navigation.findNavController(view).navigate(R.id.detailsFragment);
                }
            });
        }
    }
}
