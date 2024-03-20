package com.edgarhrdevs.edgarhuertariveradocsolutions.ui.register

import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.viewModels
import com.edgarhrdevs.edgarhuertariveradocsolutions.R
import com.edgarhrdevs.edgarhuertariveradocsolutions.databinding.RegisterFragmentBinding
import com.edgarhrdevs.edgarhuertariveradocsolutions.launchAndCollect
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : BottomSheetDialogFragment(R.layout.register_fragment) {

    var registerBinding: RegisterFragmentBinding? = null
    val viewModel: RegisterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getToken()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = RegisterFragmentBinding.bind(view).apply {
            registerNameTv.doOnTextChanged { text, start, before, count ->
                viewModel.setName(text)
            }

            registerSecondNamefatherTv.doOnTextChanged { text, start, before, count ->
                viewModel.setSecondNameFather(text)
            }
            registerSencondNamemotherTv.doOnTextChanged { text, start, before, count ->
                viewModel.setSecondNameMother(text)
            }
            registerEmailTv.doOnTextChanged { text, start, before, count ->
                viewModel.setEmail(text)
            }
            registerPhonenumberTv.doOnTextChanged { text, start, before, count ->
                viewModel.setPhoneNumber(text)
            }
            registerUsernameTv.doOnTextChanged { text, start, before, count ->
                viewModel.setUserName(text)
            }
            registerPassTv.doOnTextChanged { text, start, before, count ->
                viewModel.setPassword(text)
            }
            registerValidatepassTv.doOnTextChanged { text, start, before, count ->
                viewModel.setValidatePassword(text)
            }
            registerButton.setOnClickListener {
                viewModel.registerUser()
            }
        }

        launchAndCollect(viewModel.uiState){ state ->
            if(state.isOk == true) dismiss()
            if(state.isOk == false){
                Toast.makeText(context, "Verifica tu información ${state.responseMessage}", Toast.LENGTH_SHORT).show()
            }
            if(state.passwordIncorrect){
                Toast.makeText(context, "Las contraseñas no son iguales, verifica tu información ", Toast.LENGTH_SHORT).show()
                viewModel.resetPasswordIncorrect()
            }
        }

        registerBinding = binding
    }

    override fun onDestroy() {
        super.onDestroy()
        registerBinding = null
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
    }
}