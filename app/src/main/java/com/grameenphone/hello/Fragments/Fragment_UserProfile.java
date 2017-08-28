package com.grameenphone.hello.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.grameenphone.hello.Adapter.LiveUserListAdapter;
import com.grameenphone.hello.Adapter.RoomListAdapter;
import com.grameenphone.hello.Model.Message;
import com.grameenphone.hello.Model.User;
import com.grameenphone.hello.R;
import com.grameenphone.hello.dbhelper.DatabaseHelper;

import java.util.ArrayList;


/**
 * Created by shadman.rahman on 13-Jun-17.
 */

public class Fragment_UserProfile extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private RecyclerView userrecylcer,msgrecyler;
    private LiveUserListAdapter liveUserListAdapter;

    private RoomListAdapter roomListAdapter;
    private ArrayList<Integer> userArrayList=new ArrayList<>();
    RecyclerView allusers;
    private CardView notificationCardView;
    private CardView privacyCardView;
    private CardView helpAboutCardView, signoutCard;
    public static final String ANONYMOUS = "anonymous";
    private FirebaseAuth mFirebaseAuth;
    public static FirebaseUser mFirebaseUser;
    private ImageView usersPhoto;
    private TextView userName;
    private TextView usersPhoneNumber;
    private GoogleApiClient mGoogleApiClient;
    private DatabaseHelper dbHelper;
    private User me;
    private Switch Lanswitch;
    private String mUsername;
    private Toolbar toolbar;
    ImageButton ProfileEdit;

    View fragmentView;

    public Fragment_UserProfile() {
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




       setActionBarTitle("ইউজার প্রোফাইল");

    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        MenuItem item = menu.findItem(R.id.action_settings);
        item.setVisible(false);
        // TODO Add your menu entries here

        inflater.inflate(R.menu.group_edit_profile, menu);
        super.onCreateOptionsMenu(menu, inflater);
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


            fragmentView = inflater.inflate(R.layout.activity_user_profile,
                    container, false);
            bindViews(fragmentView);
        }


        return fragmentView;
    }
    private void bindViews(View view) {
        notificationCardView = (CardView) view.findViewById(R.id.notification_card);
        privacyCardView = (CardView) view.findViewById(R.id.privacy_card);
        helpAboutCardView = (CardView) view.findViewById(R.id.help_about_card);
        signoutCard = (CardView) view.findViewById(R.id.signout_card);
        usersPhoto = (ImageView) view.findViewById(R.id.profile_picture);
        userName = (TextView) view.findViewById(R.id.profile_name);
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
    {


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case android.R.id.home:
                // Do onliTck on menu action here
                ((AppCompatActivity)getActivity()).getSupportActionBar().setHomeAsUpIndicator ( R.drawable.hellologo );

                ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);




                setActionBarTitle(" ");
                getActivity().onBackPressed();
                return true;
            case R.id.edit_profile:
                // Do onliTck on menu action here
                Fragment_UserProfileEdit fragment2 = new Fragment_UserProfileEdit();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment2);
                fragmentTransaction.addToBackStack("profile_edit");
                fragmentTransaction.commit();
                return true;
        }
        return false;
    }

    public void refreshlistview()
    {



    }


}
