package ir.siriusapps.moneysave.di.module

import android.content.Context
import dagger.Binds
import dagger.Module
import ir.siriusapps.moneysave.App

@Module
abstract class ApplicationModule {
    @Binds abstract fun context(app: App):Context
}