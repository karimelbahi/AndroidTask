package com.karim.task.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.karim.task.BR
import com.karim.task.R
import com.karim.task.data.entity.PostResult
import com.karim.task.databinding.ItemPostBinding
import com.karim.task.presentation.base.BaseSimpleBindingAdapter
import com.squareup.picasso.Picasso

class PostsAdapter (private val onItemClickListener: OnItemClickListener<PostResult>):
    BaseSimpleBindingAdapter<PostResult, ItemPostBinding>(object :
        DiffUtil.ItemCallback<PostResult>() {
        override fun areItemsTheSame(oldItem: PostResult, newItem: PostResult) =
            oldItem.id == newItem.id


        override fun areContentsTheSame(oldItem: PostResult, newItem: PostResult) =
            oldItem.toString() == newItem.toString()

    }) {

    override fun getItemLayout(viewType: Int) = R.layout.item_post

    override fun onBindViewHolder(holder: ViewHolder<ItemPostBinding>, position: Int) {
        holder.viewBinding.setVariable(BR.post, getItem(position))

        holder.viewBinding.setVariable(BR.onItemClickListener, onItemClickListener)

        if (getItem(position).media.isNullOrEmpty())
            Picasso.get().load(R.drawable.ic_place_holder)
                .into(holder.viewBinding.profileImg);
        else
            Picasso.get().load(getItem(position).media[0].media_metadata[0].url)
                .into(holder.viewBinding.profileImg);
        holder.viewBinding.executePendingBindings()
    }

}