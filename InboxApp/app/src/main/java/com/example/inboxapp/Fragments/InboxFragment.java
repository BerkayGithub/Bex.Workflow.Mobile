package com.example.inboxapp.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.inboxapp.Adapters.MessageAdapter;
import com.example.inboxapp.Adapters.MyAdapter;
import com.example.inboxapp.Model.Message;
import com.example.inboxapp.OpenMailActivity;
import com.example.inboxapp.R;

import java.util.ArrayList;

import static androidx.recyclerview.widget.DividerItemDecoration.HORIZONTAL;


public class InboxFragment extends Fragment {

    String s1[], s2[], s3[];
    ListView listView;
    ArrayList<Message> selected_items;

    private ActionMode mode;
    private int count = 0;

    public InboxFragment() {
        // Required empty public constructor
    }

    public static InboxFragment newInstance() {
        InboxFragment fragment = new InboxFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_inbox, container, false);
        s1 = getResources().getStringArray(R.array.senders);
        s2 = getResources().getStringArray(R.array.subject);
        s3 = getResources().getStringArray(R.array.message);
        listView = view.findViewById(R.id.inboxMessageList);
        final ArrayList<Message> arrayList = new ArrayList<Message>();
        selected_items = new ArrayList<Message>();
        for (int i = 0; i<s1.length ; i++){
            arrayList.add(new Message(s1[i], s2[i], s3[i]));
        }
        final MessageAdapter adapter = new MessageAdapter(getActivity(), R.layout.my_row, arrayList);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        listView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode actionMode, int i, long l, boolean b) {
                if(selected_items.contains(arrayList.get(i))){
                    count--;
                    selected_items.remove(arrayList.get(i));
                    listView.getChildAt(i).setSelected(false);
                    listView.getChildAt(i).setBackgroundColor(getActivity().getResources().getColor(R.color.white));
                }else {
                    count++;
                    selected_items.add(arrayList.get(i));
                    listView.getChildAt(i).setSelected(true);
                    listView.getChildAt(i).setBackgroundColor(getActivity().getResources().getColor(R.color.design_default_color_secondary_variant));
                }
                actionMode.setTitle(count + " items selected");
            }

            @Override
            public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                getActivity().getMenuInflater().inflate(R.menu.contextual_menu,menu);
                getActivity().findViewById(R.id.toolbar).setVisibility(View.GONE);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.listview_delete:
                        for(Message msg : selected_items){
                            arrayList.remove(msg);
                            adapter.remove(msg);
                        }
                        break;
                    case R.id.listview_archive:
                        Toast.makeText(getContext(), "Archived", Toast.LENGTH_LONG).show();
                        break;
                    default:
                        break;
                }
                return true;
            }

            @Override
            public void onDestroyActionMode(ActionMode actionMode) {
                count = 0;
                selected_items.clear();
                getActivity().findViewById(R.id.toolbar).setVisibility(View.VISIBLE);
            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getContext(), OpenMailActivity.class);
                intent.putExtra("Gönderen", adapter.getItem(i).getGönderen());
                intent.putExtra("Konu", adapter.getItem(i).getKonu());
                intent.putExtra("İleti", adapter.getItem(i).getIleti());
                startActivity(intent);
            }
        });

        return view;
    }

}
