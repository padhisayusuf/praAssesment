package org.d3if4119.pra_assesment

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import kotlinx.android.synthetic.main.fragment_persegi.view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [persegi.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [persegi.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class persegi : Fragment() {
        private lateinit var binding: FragmentPersegiBinding
        private var luas = 0.0
        private var keliling = 0.0

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            judul()
            binding = DataBindingUtil.inflate(inflater, R.layout.fragment_persegi, container, false)

            binding.btnHitung.setOnClickListener { checkInput() }

            // Inflate the layout for this fragment
            return binding.root
        }

        private fun judul() {
            val getActivity = activity!! as MainActivity
            getActivity.supportActionBar?.title = "Persegi Panjang"
        }

        private fun checkInput() {
            when {
                binding.panjang_persegi.text.isEmpty() -> {
                    Toast.makeText(activity, "Panjang harus diisi!", Toast.LENGTH_SHORT).show()
                }
                binding.lebar_persegi.text.isEmpty() -> {
                    Toast.makeText(activity, "Lebar harus diisi!", Toast.LENGTH_SHORT).show()
                }
                else -> hitungHasil()
            }
        }

        private fun hitungHasil() {
            var panjang = binding.panjang_persegi.text.toString().toDouble()
            var lebar = binding.lebar_persegi.text.toString().toDouble()
            luas = panjang * lebar
            keliling = 2 * (panjang + lebar)

            // visible result
            // inject result to text view
            binding.tvLuas.text = "${luas}"
            binding.tvKeliling.text = "${keliling}"
        }
    }
