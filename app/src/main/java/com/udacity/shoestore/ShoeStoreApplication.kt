package com.udacity.shoestore

import android.app.Application
import timber.log.Timber

//I put this in here for Timber, may not be needed

class ShoeStoreApplication : Application()  {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}