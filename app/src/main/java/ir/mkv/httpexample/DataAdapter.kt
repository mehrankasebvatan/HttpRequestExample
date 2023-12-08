package ir.mkv.httpexample

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ir.mkv.httpexample.databinding.ItemVolleyListBinding

class DataAdapter(
    private val list: MutableList<DataModel>,
) : RecyclerView.Adapter<DataAdapter.VH>() {
    class VH(val binding: ItemVolleyListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val binding =
            ItemVolleyListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VH(binding)
    }

    override fun getItemCount() = list.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: VH, position: Int) {
        val data = list[position]
        holder.binding.apply {
            Glide
                .with(holder.itemView.context)
                .load(data.thumbnailUrl)
                .into(imgThumbnail)

            txtTitle.text = data.title ?: ""
            txtId.text = "ID: " + data.id.toString()
            txtAlbumId.text = "Album ID: " + data.albumId.toString()
        }
    }
}