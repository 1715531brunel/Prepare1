package com.example.prepare;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


public class TasksFragment extends Fragment {


    private ListView taskList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tasks, container, false);

        taskList = (ListView)view.findViewById(R.id.task_list);
        TaskListAdapter taskListAdapter = listener.getTaskListAdapter();
        taskList.setAdapter(taskListAdapter);

        registerForContextMenu(taskList);
        return view;
    }

    interface  OnFragmentInteractionListener {
        TaskListAdapter getTaskListAdapter();
        void onFragmentInteraction(int position);

    }

    OnFragmentInteractionListener listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try{
            listener = (OnFragmentInteractionListener)context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString()
                    + "should implement interface OnFragmentInteractionListener");
        }
    }

    private AdapterView.OnItemClickListener listOnItemOnClickListener = (parent, view, position, id) -> {
        listener.onFragmentInteraction(position);
    };
}