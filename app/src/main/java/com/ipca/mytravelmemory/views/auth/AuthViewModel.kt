package com.ipca.mytravelmemory.views.auth

import androidx.lifecycle.*
import com.ipca.mytravelmemory.repositories.AuthRepository

class AuthViewModel : ViewModel() {
    private val result = MutableLiveData<Result<Boolean>>()

    private var authRepository = AuthRepository()

    fun loginUserFromFirebase(email: String, password: String): (LiveData<Result<Boolean>>) {
        if (email == "" || password == "") {
            result.value = Result.failure(Throwable("Campos vazios."))
            return result
        }

        authRepository.signIn(email, password)
            .addOnSuccessListener {
                result.value = Result.success(true)
            }
            .addOnFailureListener {
                result.value = Result.failure(Throwable("Erro ao registar utilizador."))
            }

        return result
    }
}