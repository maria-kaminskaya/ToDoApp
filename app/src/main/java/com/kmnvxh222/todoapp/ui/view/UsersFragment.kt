package com.kmnvxh222.todoapp.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kmnvxh222.todoapp.R
import com.kmnvxh222.todoapp.databinding.FragmentUsersBinding
import com.kmnvxh222.todoapp.model.User
import com.kmnvxh222.todoapp.ui.adapters.UsersRecyclerAdapter
import com.kmnvxh222.todoapp.ui.viewmodel.UsersViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject


class UsersFragment : Fragment() {

    private var listUser: List<User> = ArrayList()
    private lateinit var binding: FragmentUsersBinding

    private val viewModel: UsersViewModel by viewModels()

    private lateinit var adapter: UsersRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUsersBinding.inflate(inflater, container, false)
        adapterInitialisation()
        return binding.root
    }

    private fun adapterInitialisation() {
        val userList = viewModel.getUsers()
        userList.observe(viewLifecycleOwner, Observer { user ->
            if (user != null) {
                listUser = user
                adapter = UsersRecyclerAdapter(listUser)
                adapter.setOnItemClickListener(adapterClickListener)
                binding.recyclerViewUser.let { it ->
                    it.adapter = adapter
                    it.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
                }

            }
        })
    }


    private val adapterClickListener = object : UsersRecyclerAdapter.OnItemClickListener {
        override fun onItemClick(view: View, position: Int) {
            val bundle = bundleOf("id" to listUser[position].id)
            findNavController().navigate(R.id.userDetailFragment, bundle)
        }
    }

    override fun onResume() {
        super.onResume()
        adapterInitialisation()
    }

}