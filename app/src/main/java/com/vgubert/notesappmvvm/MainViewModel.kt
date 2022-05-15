package com.vgubert.notesappmvvm

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vgubert.notesappmvvm.database.room.AppRoomDatabase
import com.vgubert.notesappmvvm.database.room.repository.RoomRepository
import com.vgubert.notesappmvvm.model.Note
import com.vgubert.notesappmvvm.utils.REPOSITORY
import com.vgubert.notesappmvvm.utils.TYPE_FIREBASE
import com.vgubert.notesappmvvm.utils.TYPE_ROOM

class MainViewModel (application: Application) : AndroidViewModel(application) {

    val context = application

    fun initDatabase(type: String, onSuccess: () -> Unit) {
        Log.d("checkData", "MainViewModel initDatabase with type: $type")
        when(type) {
            TYPE_ROOM -> {
                val dao = AppRoomDatabase.getInstance(context = context).getRoomDao()
                REPOSITORY = RoomRepository(dao)
                onSuccess()
            }
        }
    }
}

class MainViewModelFactory(private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(application = application) as T
        }
        throw IllegalAccessException("Unknown ViewModel Class")
    }

}