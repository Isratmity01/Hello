package com.grameenphone.hello;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.grameenphone.hello.Adapter.LiveUserListAdapter;
import com.grameenphone.hello.Adapter.RoomListAdapter;
import com.grameenphone.hello.Fragments.Fragment_MainPage;
import com.grameenphone.hello.Fragments.Fragment_UserProfile;
import com.grameenphone.hello.Fragments.Fragment_UserProfileEdit;
import com.grameenphone.hello.Model.ChatRoom;
import com.grameenphone.hello.Model.Message;
import com.grameenphone.hello.Model.User;
import com.grameenphone.hello.dbhelper.DatabaseHelper;

import java.util.ArrayList;

import static com.grameenphone.hello.R.id.allid;
import static com.grameenphone.hello.R.id.card_thumbnail_image;


public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    Drawable drawable;
    private MenuItem item;
    private ImageView transparentView;
    private ImageView liveBanner;
    private DatabaseHelper databaseHelper;
    private  FloatingActionsMenu menuMultipleActions;
    FrameLayout frameLayout;
    public static FirebaseUser mFirebaseUser;
       private DatabaseReference mFirebaseDatabaseReference;
    private FirebaseAuth mFirebaseAuth;
    android.support.v4.app.FragmentManager fragmentManager;
    android.support.v4.app.FragmentTransaction fragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
      /* if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }*/
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
         fragmentManager = MainActivity.this.getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();


        databaseHelper=new DatabaseHelper(MainActivity.this);
         drawable = ContextCompat.getDrawable(getApplicationContext(),R.drawable.ic_accept);
        toolbar.setOverflowIcon(drawable);
        ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.hellologo);
        ab.setDisplayHomeAsUpEnabled(true);
        loadliveUsers();
        ImageView icon = new ImageView(this); // Create an icon
        icon.setImageDrawable(getResources().getDrawable(R.drawable.ic_new_message));
        final View actionB = findViewById(R.id.action_b);

         frameLayout = (FrameLayout) findViewById(R.id.totalview);
        frameLayout.getBackground().setAlpha(0);

          menuMultipleActions = (FloatingActionsMenu) findViewById(R.id.multiple_actions);
        menuMultipleActions.setOnFloatingActionsMenuUpdateListener(new FloatingActionsMenu.OnFloatingActionsMenuUpdateListener() {
            @Override
            public void onMenuExpanded() {

              frameLayout.getBackground().setAlpha(240);
            }

            @Override
            public void onMenuCollapsed() {

                frameLayout.getBackground().setAlpha(0);
            }
        });





        //    ShapeDrawable drawable = new ShapeDrawable(new OvalShape());
        //    drawable.getPaint().setColor(getResources().getColor(R.color.white));
        //    ((FloatingActionButton) findViewById(R.id.setter_drawable)).setIconDrawable(drawable);

        final FloatingActionButton actionA = (FloatingActionButton) findViewById(R.id.action_dry_cleaning);
        actionA.setSize(FloatingActionButton.SIZE_MINI);
        actionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionA.setTitle("Action A clicked");
            }
        });

    }
    private void loadliveUsers()
    {


        Fragment_MainPage fragment = new Fragment_MainPage();

        fragmentTransaction.add(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack("msgs");
        fragmentTransaction.commit();
        /*
        mFirebaseDatabaseReference = FirebaseDatabase.getInstance().getReference();
        mFirebaseDatabaseReference.child("users_chat_room").child("9htn5aIb9wfxDB6B52sUOZE7xIU2").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                ChatRoom chatroom = dataSnapshot.getValue(ChatRoom.class);
                //  dbHelper.addRoom(chatroom.getRoomId(), chatroom.getName(), chatroom.getPhotoUrl(), chatroom.getType());
                if(chatroom.getType().equals("p2p")){
                    userArrayList.add(chatroom);
                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        mFirebaseDatabaseReference.child("users_chat_room").child("9htn5aIb9wfxDB6B52sUOZE7xIU2").addListenerForSingleValueEvent(new ValueEventListener() {
            public void onDataChange(DataSnapshot dataSnapshot) {

                Toast.makeText(MainActivity.this,"লোড হয়েছে " +dataSnapshot.getChildrenCount(),Toast.LENGTH_SHORT).show();
                try {

                    liveUserListAdapter=new LiveUserListAdapter(MainActivity.this,userArrayList);
                    userrecylcer.setAdapter(liveUserListAdapter);
                    //userrecylcer.setOnClickListener((View.OnClickListener) getActivity().getApplicationContext());
                }catch (Exception e)
                {

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }


        });*/
    }
    @Override
    public void onBackPressed() {

        Fragment f = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (f instanceof  Fragment_MainPage) {//the fragment on which you want to handle your back press
            Log.i("BACK PRESSED", "BACK PRESSED");


        }
      else  if (f instanceof  Fragment_UserProfile) {
            menuMultipleActions.setVisibility(View.VISIBLE);
            ActionBar ab = getSupportActionBar();
            ab.setHomeAsUpIndicator(R.drawable.hellologo);
            ab.setTitle("");
            ab.setDisplayHomeAsUpEnabled(true);
            super.onBackPressed();//the fragment on which you want to handle your back press
            Log.i("BACK PRESSED", "BACK PRESSED");
        }
        else  if (f instanceof Fragment_UserProfileEdit) {
            ActionBar ab = getSupportActionBar();
            ab.setHomeAsUpIndicator(R.drawable.ic_backiconsmall);
            ab.setTitle("ইউজার প্রোফাইল");
            ab.setDisplayHomeAsUpEnabled(true);
            super.onBackPressed();//the fragment on which you want to handle your back press
            Log.i("BACK PRESSED", "BACK PRESSED");
        }
        else{
            super.onBackPressed();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        item = menu.findItem(R.id.action_settings);
        item.setIcon(getResources().getDrawable(R.drawable.laila));
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            frameLayout.getBackground().setAlpha(0);
            menuMultipleActions.collapse();
            Fragment_UserProfile fragment2 = new Fragment_UserProfile();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.fragment_container, fragment2);
            fragmentTransaction.addToBackStack("profile");
            fragmentTransaction.commit();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
