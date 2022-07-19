package com.example.foodorderapp.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodorderapp.Model.UserModel
import com.google.firebase.database.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


private const val TAG = "LoginRegisterViewModel"

// question :: Why ViewModel
class LoginViewModel : ViewModel() {
    private lateinit var database: DatabaseReference
    private lateinit var keyy: String
    private lateinit var userModel: UserModel
    val isLoginSuccessful: MutableLiveData<Boolean> = MutableLiveData<Boolean>(false)

    fun login(enteredEmail: String, enteredPassword: String) {//reference: DatabaseReference) {
        viewModelScope.launch(Dispatchers.IO) {
            database = FirebaseDatabase.getInstance().getReference("User")
            database.addListenerForSingleValueEvent(
                object : ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        val children = dataSnapshot!!.children
                        children.forEach {
                            val getUser = it.getValue<UserModel>(UserModel::class.java)

                            if (getUser != null) {
                                if (getUser.email.equals(enteredEmail)&& getUser.pin?.equals(enteredPassword.toInt())==true ){
                                    isLoginSuccessful.postValue(true)
                                }
                                else
                                {
                                    Log.d("TAG", "user not found")
                                }
                            }

                        }


                    }

                    override fun onCancelled(databaseError: DatabaseError) {
                        //handle databaseError
                        Log.d("TAG", "heyyy cal")
                    }
                })
        }
    }


}



