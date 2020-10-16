package com.example.webservicetutorial.addressBook

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.webservicetutorial.MVVMApplication.Companion.UserID
import com.example.webservicetutorial.MVVMApplication.Companion.userAPIKey
import com.example.webservicetutorial.dbentities.entities.GetContactValue
import com.example.webservicetutorial.repository.ContactServiceRepository
import com.example.webservicetutorial.util.Coroutines

class AddressBookViewModel : ViewModel() {

    var repository : ContactServiceRepository? = null
    lateinit var context : Context
    lateinit var contactValues : List<GetContactValue>

    fun getAddressList(){
        Coroutines.main {
            val getContactResponse = repository!!.getContact("Bearer " + userAPIKey!!, 2)
            if (getContactResponse.isSuccessful) {
                if (getContactResponse.body()?.Result == true) {
                    contactValues = getContactResponse.body()!!.Value
                }
            } else {
                Toast.makeText(
                    context,
                    "Error occurred while getting the address book!",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}
