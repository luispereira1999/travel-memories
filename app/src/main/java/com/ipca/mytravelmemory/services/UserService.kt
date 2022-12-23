package com.ipca.mytravelmemory.services

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.ipca.mytravelmemory.models.UserModel
import kotlinx.coroutines.tasks.await

class UserService {
    // acessar base de dados
    private val db = Firebase.firestore

    fun create(userID: String, user: UserModel): Boolean {
        var isCreated = false

        db.collection("users")
            .document(userID)
            .set(user.convertToHashMap())
            .addOnSuccessListener {
                isCreated = true
                print("SUCESSO")
            }
            .addOnFailureListener { e ->
                isCreated = false
                print("ERRO: $e")
            }

        return isCreated
    }
}