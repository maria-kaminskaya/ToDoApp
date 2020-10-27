package com.kmnvxh222.todoapp.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.kmnvxh222.todoapp.R
import com.kmnvxh222.todoapp.databinding.FragmentFlowBinding
import com.kmnvxh222.todoapp.ui.adapters.MainFlowFragmentAdapter

class FlowFragment : Fragment(){

    private lateinit var viewPager: ViewPager2
    private lateinit var binding: FragmentFlowBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentFlowBinding.inflate(inflater, container, false)

        viewPager = binding.viewPagerMain
        val pagerAdapter = MainFlowFragmentAdapter(this)
        viewPager.adapter = pagerAdapter

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        TabLayoutMediator(binding.tabLayout, binding.viewPagerMain) { tab, position ->
            when (position) {
                TASK_TAB -> {
                    tab.text = resources.getText(R.string.tasks_fragment)
                }
                USERS_TAB -> {
                    tab.text = resources.getText(R.string.users_fragment)
                }
                else -> throw Exception("Wrong tab position")
            }
        }.attach()

    }

    companion object {
        const val TASK_TAB = 0
        const val USERS_TAB = 1
    }
}