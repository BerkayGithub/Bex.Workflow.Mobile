package com.example.bexflow.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.bexflow.R
import com.example.bexflow.Adapter.MyAdapter
import androidx.lifecycle.ViewModelProviders
import com.example.bexflow.`object`.Message

class InboxFragment : Fragment() {

    companion object {
        fun newInstance() = InboxFragment()
    }

    private lateinit var viewModel: InboxViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.inbox_fragment,
            container, false).apply { tag = "InboxFragment"}

        //val s1 = resources.getStringArray(R.array.senders)
        //val s2 = resources.getStringArray(R.array.subject)
        //val s3 = resources.getStringArray(R.array.message)
        recyclerView = rootView.findViewById<RecyclerView>(R.id.inbox_recyclerview)
        initializeRecyclerView()

        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(InboxViewModel::class.java)
        // TODO: Use the ViewModel
        viewModel.getMessages().observe(this.viewLifecycleOwner, Observer<List<Message>>{messages ->

        })
    }

    fun initializeRecyclerView() {
        val s1 = resources.getStringArray(R.array.senders)
        val s2 = resources.getStringArray(R.array.subject)
        val s3 = resources.getStringArray(R.array.message)
        var msgArrayList = ArrayList<Message>()
        for (x in 0 until s1.size){
            var msgToAdd = Message(s1[x],s2[x],s3[x])
            msgArrayList.add(msgToAdd)
        }
        viewManager = LinearLayoutManager(context)
        viewAdapter = MyAdapter(msgArrayList)

        recyclerView.apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = viewManager

            // specify an viewAdapter (see also next example)
            adapter = viewAdapter

        }
    }

}
