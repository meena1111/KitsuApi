package com.example.kitsuapi.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.kitsuapi.base.BaseDiffUtilItemCallback
import com.example.kitsuapi.databinding.ItemAnimeBinding
import com.example.kitsuapi.models.kitsu.KitsuModel


class AnimeAdapter :
    ListAdapter<KitsuModel, AnimeAdapter.AnimeViewHolder>(BaseDiffUtilItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = AnimeViewHolder(
        ItemAnimeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        getItem(position).let { holder.onBind(it) }
    }

    inner class AnimeViewHolder(private val binding: ItemAnimeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(model: KitsuModel) {
            binding.animeTitleTextView.text = model.attributes.titles.ja_jp
            binding.ivPosterImage.load(model.attributes.posterImage.large)
        }


    }


}
