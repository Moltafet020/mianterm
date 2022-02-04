package com.example.proje7

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class fragm_etelaAt : Fragment() {

    private var email:String=""
    private var gender:String=""
    private var birth_date:String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    email=requireArguments().getString("email").toString()
        gender=requireArguments().getString("gender").toString()
        birth_date=requireArguments().getString("birth_date").toString()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragm_etela_at, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val txt_email=view.findViewById<TextView>(R.id.txt_email)
        val txt_gender=view.findViewById<TextView>(R.id.txt_gender)
        val txt_birth_date=view.findViewById<TextView>(R.id.txt_birth_date)
        txt_email.text=email
        txt_gender.text=gender
        txt_birth_date.text=birth_date
    }
}