package com.grameenphone.hello.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.grameenphone.hello.Adapter.LiveUserListAdapter;
import com.grameenphone.hello.Adapter.RoomListAdapter;
import com.grameenphone.hello.MainActivity;
import com.grameenphone.hello.Model.Message;
import com.grameenphone.hello.Model.User;
import com.grameenphone.hello.R;

import java.util.ArrayList;


/**
 * Created by shadman.rahman on 13-Jun-17.
 */

public class Fragment_MainPage extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private RecyclerView userrecylcer,msgrecyler;
    private LiveUserListAdapter liveUserListAdapter;

    private RoomListAdapter roomListAdapter;
    private ArrayList<Integer> userArrayList=new ArrayList<>();
    RecyclerView allusers;
    String [] names = {"Rahim","Arif","Miral","Akhter","Selim","Masum"};
    String [] dates = {"25th Oct","8th Nov","1st Jan","14 March","14 April","9 July"};
    String [] captions = {"অপু সাহেব","ইথার ভাই","সাদ্মান কাকু","লাইলা","আল ইম্রান"," মেধা"};
    String [] images = {"https://www.telegraphindia.com/1130830/images/30hilsa.jpg","http://img.bdcricteam.com/2015/03/wpid-mashrafi.jpg",
            "http://www.sideshowtoy.com/assets/products/902349-heisenberg/lg/902349-heisenberg-017.jpg","http://europe.chinadaily.com.cn/china/images/attachement/jpg/site241/20130314/7427ea21079d12aba00d40.jpg","http://wildaid.org/sites/default/files/photos/iStock_000008484745Large%20%20tiger%20-%20bengal.jpg","http://static.sportskeeda.com/wp-content/uploads/2012/10/Lee-1349239922.jpg"};
    ArrayList<Message> data = new ArrayList<Message>();

    View fragmentView;

    public Fragment_MainPage() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        setHasOptionsMenu(true);
        setRetainInstance(true);

   ((AppCompatActivity)getActivity()).getSupportActionBar().setHomeAsUpIndicator ( R.drawable.hellologo );

       ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);




       setActionBarTitle("");

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


            fragmentView = inflater.inflate(R.layout.content_main,
                    container, false);
            bindViews(fragmentView);
        }


        return fragmentView;
    }
    private void bindViews(View view) {

        userrecylcer=(RecyclerView)view.findViewById(R.id.horizontallayoutholder);
        msgrecyler=(RecyclerView)view.findViewById(R.id.friendListRecyclerView);

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
        data.clear();
        userArrayList.clear();
        for (int i = 0; i < names.length; i++) {
            String input_name = names[i];
            String input_image = images[i];
            String input_date = dates[i];
            String input_caption= captions[i];

            Message mw = new Message(input_name,input_image,input_caption,input_date,captions.length);
            data.add(mw);

        }
        roomListAdapter=new RoomListAdapter(getActivity(),data);
        msgrecyler.setNestedScrollingEnabled(false);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        layoutManager.setAutoMeasureEnabled(true);


        msgrecyler.setLayoutManager(layoutManager);

        msgrecyler.setAdapter(roomListAdapter);
        for(int i=0;i<10;i++)
        {
            userArrayList.add(i);
        }
        try {

            liveUserListAdapter=new LiveUserListAdapter(getActivity(),userArrayList);
            userrecylcer.setAdapter(liveUserListAdapter);
            //userrecylcer.setOnClickListener((View.OnClickListener) getActivity().getApplicationContext());
        }catch (Exception e)
        {

        }


     /*   for(int i=0;i<userCallsArrayList.size();i++)
        {
            names.add(userCallsArrayList.get(i).getCallingTo() + userCallsArrayList.get(i).getCallType());
        }
        if(names.size()>0)linearLayout.setVisibility(View.VISIBLE);
        arrayAdapter = new ArrayAdapter<String>(
                getActivity().getApplicationContext(),
                android.R.layout.simple_list_item_1,
                names );
*/
        //listView.setAdapter(arrayAdapter);

    }
    @Override
    public void  onResume(){
        super.onResume();

    }
    /*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case android.R.id.home:
                // Do onliTck on menu action here
                getActivity().onBackPressed();
                return true;
        }
        return false;
    }*/

    public void refreshlistview()
    {



    }


}
