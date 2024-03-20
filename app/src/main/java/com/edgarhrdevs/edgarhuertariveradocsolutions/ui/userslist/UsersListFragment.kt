package com.edgarhrdevs.edgarhuertariveradocsolutions.ui.userslist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.edgarhrdevs.edgarhuertariveradocsolutions.R
import com.edgarhrdevs.edgarhuertariveradocsolutions.databinding.UserslistFragmentBinding
import com.edgarhrdevs.edgarhuertariveradocsolutions.domain.UserResponseBody
import com.edgarhrdevs.edgarhuertariveradocsolutions.launchAndCollect
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class UsersListFragment : Fragment(R.layout.userslist_fragment) {

    private val viewModel: UsersListViewModel by viewModels()
    private lateinit var adapter: UserListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getToken()
    }


    var userlistBinding: UserslistFragmentBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = UserslistFragmentBinding.bind(view).apply {
            adapter = UserListAdapter()
            usersList.adapter = adapter


            searchButton.setOnClickListener {
                viewModel.getUser(search.text.toString())
            }
            newUser.setOnClickListener {
                findNavController().navigate(R.id.action_usersListFragment_to_registerFragment)
            }

        }

        launchAndCollect(viewModel.uiState){ state ->
            binding.user = state.user
        }



        userlistBinding = binding
    }

    override fun onDestroy() {
        super.onDestroy()
        userlistBinding = null
    }
}