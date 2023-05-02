package com.bignerdranch.android.apiproject

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.bignerdranch.android.apiproject.api.Article
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


class ArticleAdapter (private val articleList:List<Article>):RecyclerView.Adapter<ArticleAdapter.MainViewHolder>(){
    class MainViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindData(article: Article) {
            val title = itemView.findViewById<TextView>(R.id.title)
            val image = itemView.findViewById<ImageView>(R.id.image)
            val published = itemView.findViewById<TextView>(R.id.published)
            val description = itemView.findViewById<TextView>(R.id.description)
            title.text = article.title
            description.text = article.description
            image.load(article.urlToImage)


            itemView.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(article.url)
                itemView.context.startActivity(intent)

            }
            val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSSS'Z'")
            val outputFormat = SimpleDateFormat("MM/dd/yyyy")
            try {
                val date = inputFormat.parse(article.publishedAt)
                val outputDate = outputFormat.format(date)
                published.text = outputDate

            } catch (e: ParseException) {
                e.printStackTrace()
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bindData(articleList[position])
    }

    override fun getItemCount(): Int {
        return articleList.size
    }

}
