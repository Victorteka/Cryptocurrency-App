package com.victorteka.core.crashlytics

import android.util.Log
import com.google.firebase.crashlytics.BuildConfig
import com.google.firebase.crashlytics.FirebaseCrashlytics
import timber.log.Timber

class CrashlyticsTree : Timber.Tree() {

    companion object {
        private const val CRASHLYTICS_KEY_PRIORITY = "priority"
        private const val CRASHLYTICS_KEY_TAG = "tag"
        private const val CRASHLYTICS_KEY_MESSAGE = "message"
    }

    private val crashlytics = FirebaseCrashlytics.getInstance()

    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        if (priority == Log.VERBOSE || priority == Log.INFO || priority == Log.DEBUG){
            return
        }
        if (BuildConfig.DEBUG){
            crashlytics.setCrashlyticsCollectionEnabled(false)
            return
        }
        crashlytics.setCustomKey(CRASHLYTICS_KEY_PRIORITY, priority)

        if (tag != null){
            crashlytics.setCustomKey(CRASHLYTICS_KEY_TAG, tag)
        }
        if (t == null){
            crashlytics.recordException(Exception(message))
        }else{
            crashlytics.recordException(t)
        }
    }
}