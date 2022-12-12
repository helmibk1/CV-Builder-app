package com.example.cvbuilderapp.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.cvbuilderapp.fragments.AboutFragment
import com.example.cvbuilderapp.fragments.ContactFragment
import com.example.cvbuilderapp.fragments.HomeFragment
import com.example.cvbuilderapp.fragments.WorkFragment

class ViewPagerAdapter(fragmentManager: FragmentManager,lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return   when(position){
            0->{
                HomeFragment()
            }
            1->{
                AboutFragment()
            }
            2->{
                WorkFragment()
            }
            3->{
                ContactFragment()
            }
            else->{
                Fragment()
            }

        }
    }
}