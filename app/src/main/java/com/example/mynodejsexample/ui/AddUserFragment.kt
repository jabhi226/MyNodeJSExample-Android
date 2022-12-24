package com.example.mynodejsexample.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.mynodejsexample.databinding.FragmentAddUserBinding
import com.example.mynodejsexample.models.User
import com.example.mynodejsexample.viewModels.ViewModel
import com.google.gson.Gson
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddUserFragment : BaseFragment<FragmentAddUserBinding>() {

    private val viewModel by activityViewModels<ViewModel>()

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentAddUserBinding {
        return FragmentAddUserBinding.inflate(layoutInflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeData()
        binding.addUser.setOnClickListener {
            viewModel.addUser(binding.username.text.toString())
        }
    }

    private fun observeData() {
        viewModel.addUserResponse.observe(viewLifecycleOwner) {
            if (it == null) return@observe
            it.clone().enqueue(object : Callback<User> {
                override fun onResponse(call: Call<User>, response: Response<User>) {
                    showResult(Gson().toJson(response.body()))
                }

                override fun onFailure(call: Call<User>, t: Throwable) {
                    showResult(Gson().toJson(t.message))
                    t.printStackTrace()
                }
            })
        }
    }

    private fun showResult(text: String) {
        CoroutineScope(Dispatchers.Main).launch {
            binding.result.text = text
        }
    }

}