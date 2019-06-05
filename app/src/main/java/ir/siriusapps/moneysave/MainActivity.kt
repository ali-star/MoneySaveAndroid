package ir.siriusapps.moneysave

import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity
import ir.siriusapps.moneysave.data.database.AppDatabase
import ir.siriusapps.moneysave.model.SmsMessage
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.recycler_item_sms.view.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject lateinit var database: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = Adapter()
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.addItemDecoration(DividerItemDecoration(applicationContext, DividerItemDecoration.VERTICAL))
        recyclerView.adapter = adapter

        AsyncTask.execute{
            val list = database.smsMessageDao().getAllSmsMessages()
            runOnUiThread{
                adapter.setItems(list as ArrayList<SmsMessage>)
            }
        }

    }

    class Adapter: RecyclerView.Adapter<Adapter.Holder>() {

        private val items = ArrayList<SmsMessage>()

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
            return Holder(LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_sms, parent, false))
        }

        override fun getItemCount(): Int {
            return items.size
        }

        override fun onBindViewHolder(holder: Holder, position: Int) {
            holder.setItem(items[position])
        }

        fun addItem(item: SmsMessage) {
            items.add(item)
            notifyItemInserted(items.size  -1)
        }

        fun setItems(items: ArrayList<SmsMessage>) {
            this.items.clear()
            this.items.addAll(items)
            notifyDataSetChanged()
        }

        class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            fun setItem(smsMessage: SmsMessage) {
                itemView.textView.text = smsMessage.from + "\n" + smsMessage.body
            }
        }

    }
}
