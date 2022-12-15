package com.example.kitsuapi.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.kitsuapi.base.BaseDiffUtilItemCallback
import com.example.kitsuapi.databinding.ItemMangaBinding
import com.example.kitsuapi.models.manga.MangaModel

class MangaAdapter :
    ListAdapter<MangaModel, MangaAdapter.FilmsViewHolder>(BaseDiffUtilItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = FilmsViewHolder(
        ItemMangaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: FilmsViewHolder, position: Int) {
        getItem(position).let { holder.onBind(it) }
    }

    inner class FilmsViewHolder(private val binding: ItemMangaBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(model: MangaModel) {
            binding.mangaTitleTextView.text = model.attributes.titles.ja_jp
            binding.ivPosterImage.load(model.attributes.posterImage.large)
            setupView(model)
        }

        private fun setupView(model: MangaModel) {
            if (binding.mangaTitleTextView.maxLines != 1) {
                binding.mangaTitleTextView.maxLines = 1
                binding.mangaTitleTextView.text = model.attributes.titles.ja_jp + "..."
            }
        }
    }


}