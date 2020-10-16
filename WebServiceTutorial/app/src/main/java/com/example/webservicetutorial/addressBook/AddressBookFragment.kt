package com.example.webservicetutorial.addressBook

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.webservicetutorial.R
import com.example.webservicetutorial.dbentities.entities.GetContactValue
import com.example.webservicetutorial.repository.ContactServiceRepository
import com.example.webservicetutorial.util.AddressBookAdapter
import kotlinx.android.synthetic.main.address_book_fragment.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class AddressBookFragment : Fragment() , KodeinAware{

    companion object {
        fun newInstance() = AddressBookFragment()
    }

    override val kodein by kodein()
    private lateinit var viewModel: AddressBookViewModel
    private lateinit var list : List<GetContactValue>
    private val repository : ContactServiceRepository by instance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.address_book_fragment, container, false)

        viewModel = ViewModelProvider(this).get<AddressBookViewModel>(AddressBookViewModel::class.java)
        viewModel.repository = repository

        viewModel.getAddressList()
        list = viewModel.contactValues
        val viewManager = LinearLayoutManager(context)
        val viewAdapter = AddressBookAdapter(list)
        address_book_recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AddressBookViewModel::class.java)
    }

}
