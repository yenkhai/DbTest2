package com.example.dbtest


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.dbtest.Database.Student
import kotlinx.android.synthetic.main.fragment_view_record.*

/**
 * A simple [Fragment] subclass.
 */
class ViewRecordFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_view_record, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val arrayList = ArrayList<String>()
        val adapter = ArrayAdapter(context!!, android.R.layout.simple_list_item_1, arrayList)

        studentListView.adapter = adapter

        btnGet.setOnClickListener(){

        //todo::: get student records and display on view
            val sList = MainActivity.appDB.studentDAO().getAll()

            for (s in sList){
                adapter.add(s.studentName + "[" + s.studentid + "]")
            }

        }
    }
}
