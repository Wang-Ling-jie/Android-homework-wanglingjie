package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Dogs(val name:String,val image_id:Int,val region:String,val contact:String,val age:Int){
}

class DogAdapter:RecyclerView.Adapter<DogViewHoder>(){
    private var listener:itemListener ?= null
    private val items= arrayListOf<Dogs>()

    //创建ItemView的ViewHolder，用于后续的数据绑定
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHoder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false)
        return DogViewHoder(itemView)
    }

    //items的数据绑定
    override fun onBindViewHolder(holder: DogViewHoder, position: Int) {
        holder.name.text=items[position].name
        holder.image.setImageResource(items[position].image_id)
        holder.itemView.setOnClickListener {
            listener?.onClick(position)
        }
    }

    //得到items的数量
    override fun getItemCount(): Int {
        return items.size
    }

    //  刷新列表项
    fun updateItems(items: List<Dogs>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun setListener(itemListener: itemListener){
        this.listener=itemListener
    }

    interface itemListener{
        fun onClick(position: Int)
    }

}

class DogViewHoder(itemView:View):RecyclerView.ViewHolder(itemView){
    var name=itemView.findViewById<TextView>(R.id.item_text)
    var image=itemView.findViewById<ImageView>(R.id.item_image)
}