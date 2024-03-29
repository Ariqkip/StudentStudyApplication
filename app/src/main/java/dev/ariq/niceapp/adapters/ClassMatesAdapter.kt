package dev.ariq.niceapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.ariq.niceapp.R

import dev.ariq.niceapp.modals.StudentData
import kotlinx.android.synthetic.main.activity_student_profile.*
import kotlinx.android.synthetic.main.classmate_view_card.view.*

class ClassMatesAdapter(val context: Context, private val classMatesList: ArrayList<StudentData>):
    RecyclerView.Adapter<dev.ariq.niceapp.adapters.ClassMatesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.classmate_view_card, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(classMatesList[position])
    }

    override fun getItemCount(): Int {
        return classMatesList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val txtStudentName = itemView.findViewById(R.id.studentName) as TextView
        val txtMailId  = itemView.findViewById(R.id.mailID) as TextView

        val profileText = itemView.profileTextLayout.findViewById(R.id.profileText) as TextView

        fun bindItems(classMates: StudentData) {

            txtStudentName.text = classMates.studentName
            txtMailId.text = classMates.emailID

            val studentName = classMates.studentName
            val count = classMates.studentName?.split(" ")!!.toTypedArray()

            if(count.size == 1) {
                profileText.text = studentName!![0].toString()
            } else {
                val index = studentName?.lastIndexOf(' ')
                val firstName = index?.let { it1 -> studentName?.substring(0, it1) }
                val lastName = index?.plus(1)?.let { it1 -> studentName?.substring(it1) }
                profileText.text = firstName?.toString()!![0] + lastName!![0]?.toString() as String
            }
        }

    }

}