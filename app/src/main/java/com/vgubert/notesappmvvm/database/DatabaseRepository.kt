package com.vgubert.notesappmvvm.database

import androidx.lifecycle.LiveData
import com.vgubert.notesappmvvm.model.Note
import com.vgubert.notesappmvvm.navigation.NavRoute

interface DatabaseRepository {

    val readAll: LiveData<List<Note>>

    suspend fun create(note: Note, onSuccess: ()-> Unit)

    suspend fun update(note: Note, onSuccess: ()-> Unit)

    suspend fun delete(note: Note, onSuccess: ()-> Unit)
}