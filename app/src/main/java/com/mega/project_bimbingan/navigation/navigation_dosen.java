package com.mega.project_bimbingan.navigation;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.luseen.spacenavigation.SpaceItem;
import com.luseen.spacenavigation.SpaceNavigationView;
import com.luseen.spacenavigation.SpaceOnClickListener;
import com.mega.project_bimbingan.R;
import com.mega.project_bimbingan.fragment.AddDosenFragment;
import com.mega.project_bimbingan.fragment.DosenFragment;
import com.mega.project_bimbingan.fragment.FavoriteFragment;
import com.mega.project_bimbingan.fragment.HomeFragment;
import com.mega.project_bimbingan.fragment.SearchDosenFragment;

public class navigation_dosen extends AppCompatActivity {

    private HomeFragment homeFragment_dosen;
    private SearchDosenFragment searchFragment_dosen;
    private AddDosenFragment addFragment_dosen;
    private FavoriteFragment favoriteFragment_dosen;
    private DosenFragment dosenFragment_dosen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_dosen);

        homeFragment_dosen = new HomeFragment();
        searchFragment_dosen = new SearchDosenFragment();
        addFragment_dosen = new AddDosenFragment();
        favoriteFragment_dosen = new FavoriteFragment();
        dosenFragment_dosen = new DosenFragment();

        SpaceNavigationView spaceNavigationView = findViewById(R.id.space_dosen);
        spaceNavigationView.initWithSaveInstanceState(savedInstanceState);
        spaceNavigationView.showIconOnly();

        spaceNavigationView.addSpaceItem(new SpaceItem("HOME", R.drawable.icon_home));
        spaceNavigationView.addSpaceItem(new SpaceItem("SEARCH", R.drawable.icon_search));
        spaceNavigationView.addSpaceItem(new SpaceItem("LIKE", R.drawable.icon_favorite));
        spaceNavigationView.addSpaceItem(new SpaceItem("USER", R.drawable.icon_user));


        spaceNavigationView.setSpaceOnClickListener(new SpaceOnClickListener() {
            @Override
            public void onCentreButtonClick() {
                setFragment(addFragment_dosen);
            }

            @Override
            public void onItemClick(int itemIndex, String itemName) {
                switch (itemIndex) {
                    case 0:
                        setFragment(homeFragment_dosen);
                        return;
                    case 1:
                        setFragment(searchFragment_dosen);
                        return;
                    case 2:
                        setFragment(favoriteFragment_dosen);
                        return;
                    case 3:
                        setFragment(dosenFragment_dosen);
                        return;
                    default:
                        setFragment(homeFragment_dosen);
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
        fragmentTransaction.replace(R.id.fragment_container_dosen, fragment);
        fragmentTransaction.commit();
    }
}