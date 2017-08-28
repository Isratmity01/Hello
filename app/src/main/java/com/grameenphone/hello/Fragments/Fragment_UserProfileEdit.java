package com.grameenphone.hello.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.grameenphone.hello.Adapter.AvatarAdapter;
import com.grameenphone.hello.R;
import com.grameenphone.hello.Utils.Constant;

import java.util.Random;

/**
 * Created by shadman.rahman on 13-Jun-17.
 */

public class Fragment_UserProfileEdit extends Fragment  {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    public Integer [] avatars = {R.drawable.avatar_airplane,
            R.drawable.avatar_balloon,
            R.drawable.avatar_cycle, R.drawable.avatar_forest,
            R.drawable.avatar_fountain,
            R.drawable.avatar_house,
            R.drawable.avatar_mountains,
            R.drawable.avatar_river,
            R.drawable.avatar_suitecase,R.drawable.avatar_windmill};
    AvatarAdapter avatarAdapter;
    View fragmentView;
    private int randomnumber;
    private ImageView userPic;
    private GridView gridView;
    public Fragment_UserProfileEdit() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        setHasOptionsMenu(true);
        setRetainInstance(true);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setHomeAsUpIndicator ( R.drawable.ic_backiconsmall );

        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);




        setActionBarTitle("প্রোফাইল এডিট করুন");

    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
        inflater.inflate(R.menu.group_menu, menu);
    }
    public boolean onSupportNavigateUp(){

        getActivity().getFragmentManager().popBackStack();
        return true;
    }
    public void setActionBarTitle(String title) {
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(title);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (fragmentView == null){


            fragmentView = inflater.inflate(R.layout.fragment_profile_edit,
                    container, false);
            bindViews(fragmentView);
        }


        return fragmentView;
    }
    private void bindViews(View view) {
        gridView=(GridView)view.findViewById(R.id.gridView);
        userPic=(ImageView)view.findViewById(R.id.user_pic);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                avatarAdapter.setSelected_position(position);
                // TODO Auto-generated method stub
                Glide.with(getActivity()).load(avatars[position])
                        .into(userPic);
            }
        });;
        FloatingActionsMenu floatingActionsMenu=  (FloatingActionsMenu) getActivity().findViewById(R.id.multiple_actions);
        floatingActionsMenu.setVisibility(View.GONE);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
    }
    public void init()
    {
        populateList();
    }
    public void populateList()
    {  randomnumber=Randomnumber();
        Glide.with(getActivity()).load(avatars[randomnumber]).into(userPic);
        avatarAdapter=new AvatarAdapter(getActivity(),avatars, randomnumber);
        gridView.setAdapter(avatarAdapter);
        gridView.setItemChecked(randomnumber,true);

       //

    }
    public int Randomnumber()
    {
        Random generator = new Random();
        int randomIndex = generator.nextInt(avatars.length);
        return randomIndex;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case android.R.id.home:
                // Do onliTck on menu action here
              ((AppCompatActivity)getActivity()).getSupportActionBar().setHomeAsUpIndicator ( R.drawable.ic_backiconsmall );

               ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);




                setActionBarTitle("ইউজার প্রোফাইল");
                getActivity().onBackPressed();
                return true;
            case R.id.edit_profile:
                // Do onliTck on menu action here

                return true;
        }
        return false;
    }

    public void refreshlistview()
    {



    }



}
