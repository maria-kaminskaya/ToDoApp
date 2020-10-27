package com.kmnvxh222.todoapp.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kmnvxh222.todoapp.R
import com.kmnvxh222.todoapp.model.User
import kotlinx.android.synthetic.main.item_user.view.*

class UsersRecyclerAdapter(private var user: List<User>) :
    RecyclerView.Adapter<UsersRecyclerAdapter.UserViewHolder>() {

    private lateinit var mItemClickListener: OnItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view, mItemClickListener)
    }

    override fun getItemCount(): Int = user.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) =
        holder.bind(user[position])

    class UserViewHolder(itemView: View, private val mItemClickListener: OnItemClickListener) :
        RecyclerView.ViewHolder(itemView), View.OnClickListener {

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(user: User) {
            itemView.imageUser.setImageResource(R.drawable.ic_person)
            itemView.textViewName.text = user.name
        }

        override fun onClick(v: View) = mItemClickListener.onItemClick(v, adapterPosition)
    }

    fun updateList(list: List<User>) {
        user = list
        notifyDataSetChanged()
    }

    interface OnItemClickListener {
        fun onItemClick(view: View, position: Int)
    }

    fun setOnItemClickListener(mItemClickListener: OnItemClickListener) {
        this.mItemClickListener = mItemClickListener
    }

}