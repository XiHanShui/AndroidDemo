package com.socct.activityscene

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val list by lazy {
        ArrayList<ItemBean>(6).apply {
            add(ItemBean(drawableRes = R.drawable.a, txt = "图片1") { bean, iv, tv ->
                startActivity(bean, iv, tv)
            })
            add(ItemBean(drawableRes = R.drawable.b, txt = "图片2") { bean, iv, tv ->
                startActivity(bean, iv, tv)
            })
            add(ItemBean(drawableRes = R.drawable.c, txt = "图片3") { bean, iv, tv ->
                startActivity(bean, iv, tv)
            })
            add(ItemBean(drawableRes = R.drawable.d, txt = "图片4") { bean, iv, tv ->
                startActivity(bean, iv, tv)
            })
            add(ItemBean(drawableRes = R.drawable.e, txt = "图片5") { bean, iv, tv ->
                startActivity(bean, iv, tv)
            })
            add(ItemBean(drawableRes = R.drawable.f, txt = "图片6") { bean, iv, tv ->
                startActivity(bean, iv, tv)
            })
        }
    }


    private fun startActivity(bean: ItemBean, iv: ImageView, tv: TextView) {
        val pairIv = androidx.core.util.Pair<View, String>(iv, DefaultActivity.IMG)
        val pairTv = androidx.core.util.Pair<View, String>(tv, DefaultActivity.TXT)
        val optionsCompat =
            ActivityOptionsCompat.makeSceneTransitionAnimation(this, pairIv, pairTv)
        ActivityCompat.startActivity(
            this,
            Intent(this, DefaultActivity::class.java).apply {

            },
            optionsCompat.toBundle()
        )

    }

//      Item item = (Item) adapterView.getItemAtPosition(position);
//
//            // Construct an Intent as normal
//            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
//            intent.putExtra(DetailActivity.EXTRA_PARAM_ID, item.getId());
//
//            // BEGIN_INCLUDE(start_activity)
//            /*
//             * Now create an {@link android.app.ActivityOptions} instance using the
//             * {@link ActivityOptionsCompat#makeSceneTransitionAnimation(Activity, Pair[])} factory
//             * method.
//             */
//            @SuppressWarnings("unchecked")
//            ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(
//                    MainActivity.this,
//
//                    // Now we provide a list of Pair items which contain the view we can transitioning
//                    // from, and the name of the view it is transitioning to, in the launched activity
//                    new Pair<>(view.findViewById(R.id.imageview_item),
//                            DetailActivity.VIEW_NAME_HEADER_IMAGE),
//                    new Pair<>(view.findViewById(R.id.textview_name),
//                            DetailActivity.VIEW_NAME_HEADER_TITLE));
//
//            // Now we can start the Activity, providing the activity options as a bundle
//            ActivityCompat.startActivity(MainActivity.this, intent, activityOptions.toBundle());


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = MyAdapter()

    }


    inner class MyAdapter : RecyclerView.Adapter<MyViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            return MyViewHolder(
                LayoutInflater.from(this@MainActivity).inflate(
                    R.layout.item,
                    parent,
                    false
                )
            )
        }

        override fun getItemCount(): Int {
            return list.size
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            val itemBean = list[position]
            val itemView = holder.itemView
            val iv = itemView.findViewById<ImageView>(R.id.iv)
            val tv = itemView.findViewById<TextView>(R.id.tv)
            iv.setImageResource(itemBean.drawableRes)
            tv.text = itemBean.txt
            itemView.setOnClickListener { itemBean.closure.invoke(itemBean, iv, tv) }
        }


    }


    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

}
