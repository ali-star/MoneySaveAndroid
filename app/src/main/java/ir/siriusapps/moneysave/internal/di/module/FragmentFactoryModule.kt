package ir.siriusapps.moneysave.internal.di.module

import androidx.fragment.app.FragmentFactory
import dagger.Binds
import dagger.Module
import ir.siriusapps.moneysave.presenter.AppFragmentFactory

@Module
interface FragmentFactoryModule {

    @Binds
    fun fragmentFactoryProvider(appFragmentFactory: AppFragmentFactory): FragmentFactory

}
