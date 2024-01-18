package com.william.demonstrativolinkedin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.william.demonstrativolinkedin.databinding.FragmentHomeBinding
import com.william.demonstrativolinkedin.fragsViewPager.PrimeiroFragment
import com.william.demonstrativolinkedin.fragsViewPager.SegundoFragment
import com.william.demonstrativolinkedin.fragsViewPager.TerceiroFragment

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tabLayout = binding.tabLayout
        viewPager = binding.viewPager
        setup()
    }

    private fun setup() {

        val adapter = AdapterViewPager(this)
        adapter.escolhaFragment(
            //Preciso criar os fragments para colocar aqui
            PrimeiroFragment(),
            SegundoFragment(),
            TerceiroFragment(),
        )

        viewPager.adapter = adapter
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
//            when (position) {
//                0 -> tab.text = "Primeiro"
//                1 -> tab.text = "Segundo"
//                2 -> tab.text = "Terceiro"
//            }
            // SE EU QUISESSE ALTERAR ICONES AO INVÉS DE TEXTO
            when (position) {
                0 -> tab.icon = ContextCompat.getDrawable(requireContext(), R.drawable.ic_primeiro)
                1 -> tab.icon = ContextCompat.getDrawable(requireContext(), R.drawable.ic_estrela)
                2 -> tab.icon = ContextCompat.getDrawable(requireContext(), R.drawable.ic_home)
            }


        }.attach()


    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}