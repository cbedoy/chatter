package chatter.chatter.backend

import android.annotation.SuppressLint
import android.os.Handler
import android.os.HandlerThread
import android.support.v4.app.Fragment
import timber.log.Timber

/**
 * Chatter
 *
 * Created by bedoy on 5/7/18.
 */
abstract class BaseViewController : Fragment() {

    @SuppressLint("BinaryOperationInTimber")
    fun runOnAsync(taskName: String, process: IAsyncProcess?) {
        val thread = HandlerThread(taskName)
        thread.start()
        val handler = Handler(thread.looper)

        Timber.d(tag, "runOnAsync: " + taskName)

        handler.post {
            process?.runOnAsync()
        }
    }

    interface IAsyncProcess {
        fun runOnAsync()
    }
}