package com.example.seniorhomecareapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
public class giverProfile_adapter extends RecyclerView.Adapter<giverProfile_adapter.ViewHolder> {
    //KEN class for care giver
    private List<Profile> profiles;
    private List<Profile> selectedProfiles;
    //private static boolean isHighlighted = false;

    public giverProfile_adapter(List<Profile> profiles) {
        this.profiles = profiles;
        this.selectedProfiles = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_giver_profile_adapter, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Bind data to each item in the RecyclerView
        Profile profile = profiles.get(position);
        holder.nameTextView.setText(profile.getName());
        holder.timeTextView.setText(profile.getTime());
        holder.locationTextView.setText(profile.getLocation());
        holder.bioTextView.setText(profile.getBio());
        int rating = profile.getRating();
        holder.certifiedBadge.setVisibility(profile.getCertified() ? View.VISIBLE : View.GONE);
        holder.verifiedBadge.setVisibility(profile.getVerified() ? View.VISIBLE : View.GONE);
        //boolean cert = profile.getCertified();
        //boolean verify = profile.getVerified();


        switch (rating) {
            case 0:
                holder.starImageView.setImageResource(R.drawable.review_stars_0);
                break;
            case 1:
                holder.starImageView.setImageResource(R.drawable.rating_stars_1);
                break;
            case 2:
                holder.starImageView.setImageResource(R.drawable.rating_stars_2);
                break;
            case 3:
                holder.starImageView.setImageResource(R.drawable.rating_stars_3);
                break;
            case 4:
                holder.starImageView.setImageResource(R.drawable.rating_stars_4);
                break;
            case 5:
                holder.starImageView.setImageResource(R.drawable.rating_stars_5);
                break;
            default:
                // Handle invalid rating
                break;
        }

    }

    @Override
    public int getItemCount() {
        // Return the number of items in the profiles list
        return profiles.size();
    }

    public List<Profile> getSelectedProfiles() {
        return selectedProfiles;
    }

    // ViewHolder class to hold references to the views for each item
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        TextView bioTextView;
        TextView timeTextView;
        TextView locationTextView;
        ImageView likeButton;
        ImageView starImageView;
        boolean isHighlighted = false;
        ImageView verifiedBadge;
        ImageView certifiedBadge;
        // Add references for other views (likebtn, location, time, description) if needed

        ViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.name);
            timeTextView = itemView.findViewById(R.id.time);
            locationTextView = itemView.findViewById(R.id.location);
            bioTextView = itemView.findViewById(R.id.description);
            likeButton = itemView.findViewById(R.id.likeButton);
            starImageView = itemView.findViewById(R.id.starImageView);
            verifiedBadge = itemView.findViewById(R.id.verifiedBadge);
            certifiedBadge = itemView.findViewById(R.id.certifiedBadge);
            if (likeButton != null) {
                likeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Toggle the highlighted state
                        isHighlighted = !isHighlighted;

                        // Update the image based on the highlighted state
                        if (isHighlighted) {
                            likeButton.setImageResource(R.drawable.save);
                        } else {
                            likeButton.setImageResource(R.drawable.unsave);
                        }
                    }
                });
            }
        }
    }
}