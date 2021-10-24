package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //获取RecycelerView实例
        val recycler_view=findViewById<RecyclerView>(R.id.recycler_view)
        val adapter=DogAdapter()
        //RecyclerView绑定Adapter
        recycler_view.adapter=adapter
        //RecyclerView绑定纵向布局管理器
        recycler_view.layoutManager=LinearLayoutManager(this)

        val items= arrayListOf<Dogs>()
        items.add(Dogs("Alice",R.drawable.dog1,"Shanghai","12345678",4))
        items.add(Dogs("Bob",R.drawable.dog2,"Shanghai","12345678",4))
        items.add(Dogs("Carol",R.drawable.dog3,"Shanghai","12345678",4))
        items.add(Dogs("Dave",R.drawable.dog4,"Shanghai","12345678",4))
        items.add(Dogs("Eric",R.drawable.dog5,"Shanghai","12345678",4))
        items.add(Dogs("Frank",R.drawable.dog6,"Shanghai","12345678",4))
        items.add(Dogs("Google",R.drawable.dog7,"Shanghai","12345678",4))
        items.add(Dogs("Helen",R.drawable.dog8,"Shanghai","12345678",4))
        items.add(Dogs("Issac",R.drawable.dog9,"Shanghai","12345678",4))
        items.add(Dogs("Jack",R.drawable.dog10,"Shanghai","12345678",4))
        items.add(Dogs("Kevin",R.drawable.dog11,"Shanghai","12345678",4))
        items.add(Dogs("Larry",R.drawable.dog12,"Shanghai","12345678",4))
        items.add(Dogs("Monkey",R.drawable.dog13,"Shanghai","12345678",4))

        adapter.updateItems(items)

        val context=this
        adapter.setListener(object : DogAdapter.itemListener{
            override fun onClick(position:Int){
                val intent=Intent(context,InfoActivity::class.java)
                intent.putExtra("dog_name",items[position].name)
                intent.putExtra("dog_image",items[position].image_id)
                intent.putExtra("dog_region",items[position].region)
                intent.putExtra("dog_contact",items[position].contact)
                intent.putExtra("dog_age",items[position].age)
                startActivity(intent)
            }
        })

    }
}