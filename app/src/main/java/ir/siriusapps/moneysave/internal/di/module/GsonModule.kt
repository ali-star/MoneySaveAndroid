package ir.siriusapps.moneysave.internal.di.module

import com.google.gson.Gson
import dagger.Module
import dagger.Provides

@Module
class GsonModule {

    @Provides
    fun gsonProvider(): Gson = Gson()

}