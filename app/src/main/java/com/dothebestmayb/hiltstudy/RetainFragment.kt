package com.dothebestmayb.hiltstudy

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class RetainFragment : Fragment() {

    @Inject
    lateinit var myInfo: MyInfo

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_retain, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        retainInstance = true

        println(myInfo)
    }

    override fun onDetach() {
        super.onDetach()

        Log.e("Fragment", "onDetach called")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        Log.d("Fragment", "onAttach called")
    }
}