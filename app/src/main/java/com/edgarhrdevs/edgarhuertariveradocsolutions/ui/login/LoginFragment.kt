package com.edgarhrdevs.edgarhuertariveradocsolutions.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.edgarhrdevs.edgarhuertariveradocsolutions.R
import com.edgarhrdevs.edgarhuertariveradocsolutions.databinding.LoginFragmentBinding
import com.edgarhrdevs.edgarhuertariveradocsolutions.launchAndCollect
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LoginFragment : Fragment(R.layout.login_fragment) {

    private val viewModel: LoginViewModel by viewModels()

    private var loginBinding: LoginFragmentBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = LoginFragmentBinding.bind(view).apply {
            userNameEditText.doOnTextChanged { text, start, before, count ->
                viewModel.setUser(text)
            }
            passwordEditText.doOnTextChanged { text, start, before, count ->
                viewModel.setPassword(text)
            }
            loginButton.setOnClickListener {
                viewModel.login()
            }
        }

        launchAndCollect(viewModel.uiState){ state ->
            if (state.isOk == true){
                findNavController().navigate(R.id.action_loginFragment_to_usersListFragment)
            }
        }


        loginBinding = binding

    }

    override fun onDestroy() {
        super.onDestroy()
        loginBinding = null
    }
}