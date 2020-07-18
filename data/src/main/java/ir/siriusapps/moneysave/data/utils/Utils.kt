package ir.siriusapps.moneysave.data.utils

import android.content.Context
import java.io.IOException
import java.io.InputStream
import java.nio.charset.Charset

object Utils {

    fun loadJsonFormAsset(context: Context, fileName: String): String? {
        var json: String? = null
        var inputStream: InputStream? = null
        try {
            inputStream = context.assets.open(fileName)
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            json = String(buffer, Charset.forName("UTF-8"))

        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            inputStream?.close()
        }
        return json
    }

}