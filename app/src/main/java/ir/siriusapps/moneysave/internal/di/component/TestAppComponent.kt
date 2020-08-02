package ir.siriusapps.moneysave.internal.di.component

import androidx.fragment.app.FragmentFactory
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import ir.siriusapps.moneysave.App
import ir.siriusapps.moneysave.domain.scope.ApplicationScope
import ir.siriusapps.moneysave.internal.di.module.*

@ApplicationScope
@Component(
    modules = [
        AndroidInjectionModule::class, ApplicationModule::class,
        AppDataBaseModule::class, ViewModelModule::class,
        RepositoryModule::class, SharedPreferencesModule::class, GsonModule::class,
        BindingModule::class, FragmentFactoryModule::class
    ]
)
interface TestAppComponent : AndroidInjector<App> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: App): TestAppComponent
    }

    fun fragmentFactory(): FragmentFactory

}