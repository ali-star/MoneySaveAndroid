package ir.siriusapps.moneysave.presenter

import android.content.res.Resources
import android.util.DisplayMetrics
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

inline fun <reified T : ViewModel> Fragment.viewModel(crossinline provider: (SavedStateHandle) -> T) =
    viewModels<T> { object : AbstractSavedStateViewModelFactory(this, null) {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(
            key: String,
            modelClass: Class<T>,
            handle: SavedStateHandle
        ): T = provider(handle) as T
    }
}

fun dpToPx(dp: Int) : Float {
    return dp * Resources.getSystem().displayMetrics.density
}