package com.example.bdt

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

 class BdAdapter internal constructor(context:Context):RecyclerView.Adapter<BdAdapter.BDVIEWHOLDER>(){
     private val inflater: LayoutInflater = LayoutInflater.from(context)
     private var bds = emptyList<DB>() // Cached copy of words

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BDVIEWHOLDER {
         val itemView = inflater.inflate(R.layout.recyclerview_item,parent,false)
         return BDVIEWHOLDER(itemView)
     }

     override fun getItemCount(): Int {
         return bds.size
     }

     override fun onBindViewHolder(holder: BDVIEWHOLDER, position: Int) {
        val bdRecord = bds.get(position)
         holder.textViewName.text= bdRecord.name
         holder.textViewDOB.text = bdRecord.dob
     }




    inner class BDVIEWHOLDER(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textViewName:TextView = itemView.findViewById(R.id.textViewName)
        val textViewDOB:TextView = itemView.findViewById(R.id.textViewDOB)
    }


     internal fun seDtBS(bds: List<DB>) {
         this.bds = bds
         notifyDataSetChanged()
     }

 }

