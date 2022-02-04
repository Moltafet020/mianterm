package com.example.proje7

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

class thabt_name : Fragment() {
  lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_thabt_name, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController=navigation.findNavcontroller(view)
        val edt_email = view.findViewById<EditText>(R.id.edt_email)
        val edt_password = view.findViewById<EditText>(R.id.edt_password)
        val edt_confirm_password = view.findViewById<EditText>(R.id.edt_confirm_password)
        val edt_first_name = view.findViewById<EditText>(R.id.edt_first_name)
        val edt_last_name = view.findViewById<EditText>(R.id.edt_last_name)
        val sp_birth_date = view.findViewById<spiner>(R.id.sp_birth_date)
        val edt_description = view.findViewById<EditText>(R.id.edt_description)
        val radio_group = view.findViewById<RadioGroup>(R.id.radio_group)
        /*val rb_male = view.findViewById<RadioButton>(R.id.rb_male)
        val rb_femail = view.findViewById<RadioButton>(R.id.rb_femail)*/
        val edt_phone_number = view.findViewById<EditText>(R.id.edt_phone_number)
        val edt_zip_code = view.findViewById<EditText>(R.id.edt_zip_code)
        val btn_submit = view.findViewById<EditText>(R.id.btn_submit)
        val cb_agree = view.findViewById<CheckBox>(R.id.cb_agree)

        val list = arrayOf("سال را انتخاب کنید","1400","1399","1398","1397","1396")
        val arrayArray=ArrayAdapter<string>(requireContext()(),android.R.layout.simple_spinner_item,list)
        sp_birth_date.adapter=arrayAdaptor
        btn_submit.setOnClickListener{
            var isError:Boolean=false
            if (edt_email.text.tostring().equals("") || edt_password.text.tostring()!=(edt_confirm_password.text.tostring())){
                Toast.makeText(requireContext(), "فیلد ها خالی میباشد", Toast.LENGTH_LONG).show()
                isError=true
        }

            if (sp_birth_date.selectedItemPosition==0){
                Toast.makeText(requireContext(),"سال را انتخاب کنید",Toast.LENGTH_LONG).show()
                isError=true
            }

            if ((edt_phone_number.text.toString()length!=11 ||  edt_phone_number.text.tostring()[0]!='0' || edt_phone_number.text.tostring()[1]!='9')){
                Toast.makeText(requireContext(),"شماره تلفن صحیح نیست",Toast.LENGTH_LONG).show()
            isError=true
            }
            if(!cb_agree.isChecked){
                Toast.makeText(requireContext(),"تیک قوانین",Toast.LENGTH_LONG).show()
                isError=true
            }
            if(radio_group.checkedRadioButtonId==-1){
                Toast.makeText(requireContext(),"جنسیت",Toast.LENGTH_LONG).show()
                isError=true
            }


            if (!isError){
                val rb=view.findViewById<RadioButton>(radio_group.checkedRadioButtonId)
                val  bundle: Bundle = Bundle()
                bundle.putString("email",edt_email.text.toString())
                bundle.putString("gender",rb.text.toString())
                bundle.putString("birth_date",list[sp_birth_date.selectedItemPosition])
                navController.navigation(R.id.action_thabt_name_to_fragm_etelaAt)
            }


        }

    }
}