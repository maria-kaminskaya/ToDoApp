package com.kmnvxh222.todoapp.ui.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.kmnvxh222.todoapp.ui.view.TaskFragment
import com.kmnvxh222.todoapp.ui.view.UsersFragment

class MainFlowFragmentAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    private val tabFragmentsCreators: Map<Int, () -> Fragment> = mapOf(
        TASK_PAGE_INDEX to { TaskFragment() },
        USERS_PAGE_INDEX to { UsersFragment() }
    )

    override fun createFragment(position: Int): Fragment {
        return tabFragmentsCreators[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }

    override fun getItemCount() = tabFragmentsCreators.size

    companion object {
        private const val TASK_PAGE_INDEX = 0
        private const val USERS_PAGE_INDEX = 1
    }
}