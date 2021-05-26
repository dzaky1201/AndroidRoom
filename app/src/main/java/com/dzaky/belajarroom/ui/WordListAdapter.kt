package com.dzaky.belajarroom.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dzaky.belajarroom.R
import com.dzaky.belajarroom.data.Word
import com.dzaky.belajarroom.databinding.RecyclerItemBinding

class WordListAdapter : ListAdapter<Word, WordViewHolder>(WordsComparator()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        return WordViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current.word)
    }
}


class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val binding = RecyclerItemBinding.bind(itemView)

    fun bind(text: String?) {
        binding.textView.text = text
    }

    companion object {
        fun create(parent: ViewGroup): WordViewHolder {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
            return WordViewHolder(view)
        }
    }
}

class WordsComparator: DiffUtil.ItemCallback<Word>() {
    override fun areItemsTheSame(oldItem: Word, newItem: Word): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Word, newItem: Word): Boolean {
        return oldItem.word == newItem.word
    }

}