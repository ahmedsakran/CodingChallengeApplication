package group.payback.codingchallengeapplication.util

import androidx.recyclerview.widget.DiffUtil
import group.payback.codingchallengeapplication.domain.models.Hit

class ItemsDiffUtil(
    private val oldList: List<Hit>,
    private val newList: List<Hit>,
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] === newList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}