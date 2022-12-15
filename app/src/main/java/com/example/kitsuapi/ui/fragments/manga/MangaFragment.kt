package com.example.kitsuapi.ui.fragments.manga

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.kitsuapi.R
import com.example.kitsuapi.base.BaseFragment
import com.example.kitsuapi.databinding.FragmentMangaBinding
import com.example.kitsuapi.ui.adapters.MangaAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MangaFragment :
    BaseFragment<MangaViewModel, FragmentMangaBinding>(R.layout.fragment_manga) {

    override val binding by viewBinding(FragmentMangaBinding::bind)
    override val viewModel: MangaViewModel by viewModels()
    private val adapter = MangaAdapter()
    private var offset: Int = 0


    override fun initialize() {
        setupRecyclerView()
    }

    override fun setupSubscribe() {
        subscribeToManga()
    }

    override fun setupListener() {
        binding.rvManga.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1)) {
                    binding.progressBar.visibility = View.VISIBLE
                    offset += 20
                    subscribeToManga()
                } else {
                    binding.progressBar.visibility = View.GONE
                }
            }
        })
    }

    private fun setupRecyclerView() {
        binding.rvManga.adapter = adapter
    }

    private fun subscribeToManga() {
        viewModel.fetchManga(20, offset).subscribe(
            onSuccess = {
                adapter.submitList(it.result)
            },
            onError = {
                Log.e("manga", it )
            }
        )
    }
}