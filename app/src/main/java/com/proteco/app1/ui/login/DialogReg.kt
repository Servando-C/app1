package com.proteco.app1.ui.login

import android.app.Dialog
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.proteco.app1.R
import com.proteco.app1.databinding.DialogRegBinding


class DialogReg : DialogFragment() {

    private var _binding: DialogRegBinding? = null

    private val binding get() = _binding!!

    /** The system calls this to get the DialogFragment's layout, regardless
    of whether it's being displayed as a dialog or an embedded fragment. */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DialogRegBinding.inflate(inflater, container, false)

        var selecSex = false
        val registrarCon = _binding!!.conBtn
        val emailCreado = _binding!!.etEmail
        val passCreada = _binding!!.etContra
        val passCreadaC  = _binding!!.etCContra
        val userCreado = _binding!!.etUser
        val sexBoton = _binding!!.toggleButton

        registrarCon.setOnClickListener{

            sexBoton.addOnButtonCheckedListener{sexBoton, checkedId, isChecked ->
                selecSex = isChecked
            }

            if (passCreada.text!!.isNotEmpty() && passCreadaC.text!!.isNotEmpty() && userCreado.text!!.isNotEmpty() && emailCreado.text!!.isNotEmpty()){
                if(selecSex){
                    if(passCreada.text.toString() == passCreadaC.text.toString()){
                        //Registro exitoso
                        Toast.makeText(context, R.string.success_login, Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(context, R.string.notEqPass, Toast.LENGTH_SHORT).show()
                    }
                }
                else{
                    Toast.makeText(context, R.string.last_miss, Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(context, R.string.datos_incom, Toast.LENGTH_SHORT).show()
            }
        }
        // Inflate the layout to use as dialog or embedded fragment
        val view = binding.root

        return view
        //inflater.inflate(R.layout.dialog_reg, container,false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    /** The system calls this only when creating the layout in a dialog. */
     override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // The only reason you might override this method when using onCreateView() is
        // to modify any dialog characteristics. For example, the dialog includes a
        // title by default, but your custom layout might not need it. So here you can
        // remove the dialog title, but you must call the superclass to get the Dialog.
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        return dialog
    }

}