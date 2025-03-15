package com.example.myapplication.Lab5.Ex1.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Lab5.Ex1.User;
import com.example.myapplication.R;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    private List<User> userList;

    public UserAdapter(List<User> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = userList.get(position);
        String userInfo = "Username: " + user.getUsername() + "\n"
                + "Fullname: " + user.getFullname() + "\n"
                + "Email: " + user.getEmail();
        holder.userInfoTextView.setText(userInfo);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        TextView userInfoTextView;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            userInfoTextView = itemView.findViewById(R.id.userInfoTextView);
        }
    }
}