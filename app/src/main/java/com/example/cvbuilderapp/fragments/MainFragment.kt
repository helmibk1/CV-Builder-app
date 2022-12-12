package com.example.cvbuilderapp.fragments


import android.os.Bundle
import android.os.Debug
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.cvbuilderapp.R
import com.example.cvbuilderapp.adapters.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class MainFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root: View = inflater.inflate(R.layout.fragment_main, container, false)

        val tabLayout= root.findViewById<TabLayout>(R.id.tab_layout)
        val viewPager2= root.findViewById<ViewPager2>(R.id.view_pager_2)

        val adapter= ViewPagerAdapter(getChildFragmentManager(),lifecycle)

        viewPager2.adapter=adapter

        TabLayoutMediator(tabLayout,viewPager2){tab,position->
            tab.text
            when(position){
                0->{
                    tab.text="HOME"
                }
                1->{
                    tab.text="ABOUT ME"
                }
                2->{
                    tab.text="WORK"
                }
                3->{
                    tab.text="CONTACT"
                }
            }
        }.attach()
        return root

    }
}