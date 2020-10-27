package com.kmnvxh222.todoapp.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kmnvxh222.todoapp.R
import com.kmnvxh222.todoapp.databinding.FragmentTaskBinding
import com.kmnvxh222.todoapp.db.model.TaskEntity
import com.kmnvxh222.todoapp.model.Task
import com.kmnvxh222.todoapp.model.User
import com.kmnvxh222.todoapp.ui.adapters.TasksRecyclerAdapter
import com.kmnvxh222.todoapp.ui.viewmodel.TaskViewModel


class TaskFragment : Fragment() {

    private var listTask: List<TaskEntity> = ArrayList()
    private var listUser: List<User> = ArrayList()
    private lateinit var binding: FragmentTaskBinding
    private lateinit var viewModel: TaskViewModel
    private lateinit var adapter: TasksRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTaskBinding.inflate(inflater, container, false)
        viewModel= TaskViewModel(requireContext())
        adapterInitialisation()

        return binding.root
    }

    private fun adapterInitialisation() {
        val task = viewModel.getTask(viewLifecycleOwner)
        val user = viewModel.getUsers()
        task.observe(viewLifecycleOwner, Observer { task ->
            if (task != null) {
                listTask = task


            user.observe(viewLifecycleOwner, Observer { user ->
                if (user != null) {
                    listUser = user
                    adapter = TasksRecyclerAdapter(listTask,listUser)
//                    adapter.setOnItemClickListener(adapterClickListener)
                    binding.recyclerViewTask.let { it ->
                        it.adapter = adapter
                        it.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
                    }

                }
            })
            }

        })

    }

//    private val adapterClickListener = object : TasksRecyclerAdapter.OnItemClickListener {
//        override fun onItemClick(view: View, position: Int) {
//            val bundle = bundleOf("note" to listTask[position])
//        }
//    }

    override fun onResume() {
        super.onResume()
        adapterInitialisation()
    }

}