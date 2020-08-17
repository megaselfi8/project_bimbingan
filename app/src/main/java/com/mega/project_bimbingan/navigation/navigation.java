package com.mega.project_bimbingan.navigation;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.luseen.spacenavigation.SpaceItem;
import com.luseen.spacenavigation.SpaceNavigationView;
import com.luseen.spacenavigation.SpaceOnClickListener;
import com.mega.project_bimbingan.fragment.AddFragment;
import com.mega.project_bimbingan.fragment.HomeFragment;
import com.mega.project_bimbingan.fragment.LikeFragment;
import com.mega.project_bimbingan.R;
import com.mega.project_bimbingan.fragment.SearchFragment;
import com.mega.project_bimbingan.fragment.UserFragment;

public class navigation extends AppCompatActivity {

    private HomeFragment homeFragment;
    private SearchFragment searchFragment;
    private AddFragment addFragment;
    private LikeFragment likeFragment;
    private UserFragment userFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        homeFragment = new HomeFragment();
        searchFragment = new SearchFragment();
        addFragment = new AddFragment();
        likeFragment = new LikeFragment();
        userFragment = new UserFragment();

        SpaceNavigationView spaceNavigationView = findViewById(R.id.space);
        spaceNavigationView.initWithSaveInstanceState(savedInstanceState);
        spaceNavigationView.showIconOnly();

        spaceNavigationView.addSpaceItem(new SpaceItem("HOME", R.drawable.icon_home));
        spaceNavigationView.addSpaceItem(new SpaceItem("SEARCH", R.drawable.icon_search));
        spaceNavigationView.addSpaceItem(new SpaceItem("LIKE", R.drawable.icon_favorite));
        spaceNavigationView.addSpaceItem(new SpaceItem("USER", R.drawable.icon_user));

        spaceNavigationView.setSpaceOnClickListener(new SpaceOnClickListener() {
            @Override
            public void onCentreButtonClick() {
                setFragment(addFragment);
            }

            @Override
            public void onItemClick(int itemIndex, String itemName) {
                switch (itemIndex) {
                    case 0:
                        setFragment(homeFragment);
                        return;
                    case 1:
                        setFragment(searchFragment);
                        return;
                    case 2:
                        setFragment(likeFragment);
                        return;
                    case 3:
                        setFragment(userFragment);
                        return;
                    default:
                        setFragment(homeFragment);
                        return;
                }
            }

            @Override
            public void onItemReselected(int itemIndex, String itemName) {

            }
        });
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }
}
