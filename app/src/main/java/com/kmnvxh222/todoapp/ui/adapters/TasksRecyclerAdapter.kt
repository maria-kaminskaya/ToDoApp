package com.kmnvxh222.todoapp.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kmnvxh222.todoapp.R
import com.kmnvxh222.todoapp.db.model.TaskEntity
import com.kmnvxh222.todoapp.model.Task
import com.kmnvxh222.todoapp.model.User
import kotlinx.android.synthetic.main.item_task.view.*

class TasksRecyclerAdapter(private var task: List<TaskEntity>, private var user: List<User>) :
    RecyclerView.Adapter<TasksRecyclerAdapter.TaskViewHolder>() {

//    private lateinit var mItemClickListener: OnItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)
        return TaskViewHolder(view)
    }

    override fun getItemCount(): Int = task.size

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) =
        holder.bind(task[position],user)

    class TaskViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView){

//        init {
//            itemView.setOnClickListener(this)
//        }

        fun bind(task: TaskEntity, userList: List<User>) {
            itemView.textViewId.text = task.id.toString()
            itemView.textViewStatus.text = when
                (task.completed){
                true -> "complete"
                false -> "not complete"
            }
            itemView.textViewTitle.text = task.title
            itemView.image.setImageResource(R.drawable.ic_person)
            itemView.textViewName.text = userList[task.userId.toInt()].name
        }

//        override fun onClick(v: View) = mItemClickListener.onItemClick(v, adapterPosition)
    }

    fun updateList(list: List<TaskEntity>, userList: List<User>) {
        task = list
        user = userList
        notifyDataSetChanged()
    }

//    interface OnItemClickListener {
//        fun onItemClick(view: View, position: Int)
//    }
//
//    fun setOnItemClickListener(mItemClickListener: OnItemClickListener) {
//        this.mItemClickListener = mItemClickListener
//    }

}