package com.example.kitsuapi.ui.adapters

import android.content.res.Resources
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.kitsuapi.ui.fragments.anime.AnimeFragment
import com.example.kitsuapi.ui.fragments.manga.MangaFragment


class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> {
                AnimeFragment()
            }
            1 -> {
                MangaFragment()
            }
            else -> {throw Resources.NotFoundException("Position Not Found")}
        }


    }
}