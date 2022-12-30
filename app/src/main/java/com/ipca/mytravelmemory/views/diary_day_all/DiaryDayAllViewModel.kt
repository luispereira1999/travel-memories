package com.ipca.mytravelmemory.views.diary_day_all

import androidx.lifecycle.*
import com.google.firebase.firestore.EventListener
import com.ipca.mytravelmemory.models.DiaryDayModel
import com.ipca.mytravelmemory.repositories.AuthRepository
import com.ipca.mytravelmemory.repositories.DiaryDayRepository

class DiaryDayAllViewModel : ViewModel() {
    private var result: MutableLiveData<Result<List<DiaryDayModel>>> = MutableLiveData()

    private var diaryDayRepository = DiaryDayRepository()
    private var authRepository = AuthRepository()

    fun getDiaryDaysFromFirebase(): LiveData<Result<List<DiaryDayModel>>> {
        val userID = authRepository.getUserID()

        //diaryDayRepository.selectAll(userID)
        //.addSnapshotListener(EventListener { documents, error ->
        //if (error != null) {
        //result.value = Result.failure(Throwable("Erro ao obter as viagens."))
        //return@EventListener
        //}

        //val diaryDays: MutableList<DiaryDayModel> = mutableListOf()
        //for (document in documents!!) {
        //val diaryDay = DiaryDayModel.convertToDiaryDayModel(document.data)
        //diaryDays.add(diaryDay)
        //}

        //result.value = Result.success(diaryDays)
        //})

        return result
    }
}