package com.dilfa.dilfauts4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SuperheroAdapter(
    private val superherolist: ArrayList<Superhero>,
    private var mListener: OnItemClickListener? = null
) : RecyclerView.Adapter<SuperheroAdapter.SuperHeroViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_superhero, parent, false)
        return SuperHeroViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: SuperHeroViewHolder, position: Int) {
        val currentItem = superherolist[position]
        holder.bind(currentItem)
    }

    override fun getItemCount(): Int {
        return superherolist.size
    }

    inner class SuperHeroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.img_item_photo)
        private val namehero: TextView = itemView.findViewById(R.id.tv_item_name)
        private val namedesc: TextView = itemView.findViewById(R.id.tv_item_description)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    mListener?.onItemClick(position)
                }
            }
        }

        fun bind(superhero: Superhero) {
            imageView.setImageResource(superhero.imgSuperhero)
            namehero.text = superhero.nameSuperhero
            namedesc.text = superhero.descSuperhero
        }
    }
}
