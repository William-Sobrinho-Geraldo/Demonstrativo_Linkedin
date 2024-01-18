package com.william.demonstrativolinkedin

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class AdapterViewPager(frag: Fragment) : FragmentStateAdapter(frag) {
    lateinit var primeiroFragment: Fragment
    lateinit var segundoFragment: Fragment
    lateinit var terceiroFragment: Fragment

    fun escolhaFragment(
        primeiroFragment: Fragment,
        segundoFragment: Fragment,
        terceiroFragment: Fragment
    ) {
        this.primeiroFragment = primeiroFragment
        this.segundoFragment = segundoFragment
        this.terceiroFragment = terceiroFragment
    }


    override fun getItemCount(): Int {
        //quantidade de pages que meu viewPager vai ter
        return 3    //serão 3 páginas
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> primeiroFragment
            1 -> segundoFragment
            2 -> terceiroFragment
            else -> primeiroFragment
        }
    }
}