package com.codepath.gram.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.codepath.gram.Post;
import com.codepath.gram.PostsAdapter;
import com.codepath.gram.R;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class TimelineFragment extends Fragment {

    private RecyclerView rvPosts;
    private PostsAdapter adapter;
    private List <Post> mPosts;
    private static final String TAG = "TimelineFragment";

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_timeline, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mPosts = new ArrayList<>();
        rvPosts= view.findViewById(R.id.rvPosts);
        adapter = new PostsAdapter(getContext(), mPosts);
        rvPosts.setAdapter(adapter);
        rvPosts.setLayoutManager(new LinearLayoutManager(getContext()));

    queryPosts();
    }

    private void queryPosts() {
        ParseQuery<Post> postQuery = new ParseQuery<Post>(Post.class);
        postQuery.include(Post.KEY_USER);
        postQuery.findInBackground(new FindCallback<Post>() {
            @Override
            public void done(List<Post> posts, ParseException e) {
                if (e!= null){
                    Log.e(TAG,"error in query");
                    e.printStackTrace();
                    return;
                }


                mPosts.addAll(posts);
                adapter.notifyDataSetChanged();
                for(int i = 0; i< posts.size(); i++) {
                    Toast.makeText(getContext(),"Post:" + posts.get(i).getDescription()+ posts.size(),Toast.LENGTH_SHORT ).show();
                    // Log.d(TAG, "Post:" + posts.get(i).getDescription());
                }
            }
        });
    }

}
