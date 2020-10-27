package com.kmnvxh222.todoapp.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.kmnvxh222.todoapp.R
import com.kmnvxh222.todoapp.databinding.FragmentUserDetailBinding
import com.kmnvxh222.todoapp.ui.viewmodel.UserDetailViewModel


class UserDetailFragment : Fragment() {

    private lateinit var binding: FragmentUserDetailBinding
    private val viewModel: UserDetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserDetailBinding.inflate(inflater, container, false)
        setData()
        return binding.root
    }

    private fun setData() {
        val id = requireArguments().get("id") as Int
        val userId = viewModel.getUsers()
        userId.observe(viewLifecycleOwner, Observer { user ->

            binding.let {
                it.imageViewDetail.setImageResource(R.drawable.ic_person)
                if (user != null) {
                    for (i in user) {
                        if (i.id == id) {
                            it.textViewUserNameV.text = i.username
                            it.textViewNameV.text = i.name
                            it.textViewEmailV.text = i.email
                            it.textViewAddressV.text =
                                "${i.address.city}, ${i.address.suite}, ${i.address.street}"
                            it.textViewZipV.text = i.address.zipcode
                            it.textViewPhoneV.text = i.phone
                            it.textViewWebsiteV.text = i.website
                            it.textViewCompanyName.text = i.company.name
                            it.textViewCompanyCatchPhrase.text = i.company.catchPhrase
                            it.textViewCompanyBS.text = i.company.bs
                        }
                    }

                }
            }

        })
    }

}