package com.example.niceapp.utils

import android.content.Context
import android.content.SharedPreferences
import com.example.niceapp.adapters.ClassNotesAdapter

object AppPreferences {
    private const val NAME = "Stumate"
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var preferences: SharedPreferences

    //SharedPreferences variables
    private val IS_LOGIN = Pair("is_login", false)
    private val STUDENT_NAME = Pair("studentName", "")
    private val STUDENT_ID = Pair("studentID", "")
    private val STUDENT_EMAIL_ID = Pair("studentEmailID", "")

    const val AUTH_KEY_FCM = "BJ3CBt-zlfp9HvQRiAGHqBqd_9SNxoVp8O_D95LkzB7N7rUpJB5NgqSVoXZ2ngOx6kQMTTfRDRdv8382jtpGZk0"


    fun init(context: Context) {
        preferences = context.getSharedPreferences(NAME, MODE)
    }

    //an inline function to put variable and save it
    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    //SharedPreferences variables getters/setters
    var isLogin: Boolean
        get() = preferences.getBoolean(IS_LOGIN.first, IS_LOGIN.second)
        set(value) = preferences.edit {
            it.putBoolean(IS_LOGIN.first, value)
        }

    var studentName: String
        get() = preferences.getString(STUDENT_NAME.first, STUDENT_NAME.second) ?: ""
        set(value) = preferences.edit {
            it.putString(STUDENT_NAME.first, value)
        }

    var studentID: String
        get() = preferences.getString(STUDENT_ID.first, STUDENT_ID.second) ?: ""
        set(value) = preferences.edit {
            it.putString(STUDENT_ID.first, value)
        }

    var studentEmailID: String
        get() = preferences.getString(STUDENT_EMAIL_ID.first, STUDENT_EMAIL_ID.second) ?: ""
        set(value) = preferences.edit {
            it.putString(STUDENT_EMAIL_ID.first, value)
        }


}