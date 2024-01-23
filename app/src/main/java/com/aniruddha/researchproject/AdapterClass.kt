package com.aniruddha.researchproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class AdapterClass(
    private val data: List<Element>,
    private val listener: (Element) -> Unit
) : RecyclerView.Adapter<AdapterClass.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val element = data[position]
        holder.bind(element)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val cardView: CardView = itemView.findViewById(R.id.cardView)
        private val textAtomicNumber: TextView = itemView.findViewById(R.id.atomic_number)
        private val textSymbol: TextView = itemView.findViewById(R.id.symbol)
        private val textLatinName: TextView = itemView.findViewById(R.id.latin_name)

        fun bind(element: Element) {
            textAtomicNumber.text = element.atomicNumber.toString()
            textSymbol.text = element.symbol
            textLatinName.text = element.elementName

            // Set the background color of the card view
            cardView.setBackgroundColor(element.color)

            itemView.setOnClickListener {
                listener.invoke(element)
            }
        }
    }
}
