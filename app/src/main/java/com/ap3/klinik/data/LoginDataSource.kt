package com.ap3.klinik.data

import com.ap3.klinik.api.database
import com.ap3.klinik.data.model.LoggedInUser
import java.io.IOException
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource {

    fun login(username: String, password: String): Result<LoggedInUser> {
        try {
            // TODO: handle loggedInUser authentication

            var fakeUser: LoggedInUser = LoggedInUser("1", username)

            CoroutineScope(Dispatchers.Main).launch {
                val status = database().api.get_login_status(username, password)
                fakeUser = LoggedInUser(status.toString(), username)


            }

            return Result.Success(fakeUser)

        } catch (e: Throwable) {
            return Result.Error(IOException("Error logging in", e))
        }
    }

    fun logout() {
        // TODO: revoke authentication
    }
}