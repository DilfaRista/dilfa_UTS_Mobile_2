package com.dilfa.dilfauts4

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: SuperheroAdapter
    private lateinit var superheroArrayList: ArrayList<Superhero>

    private lateinit var imageid: Array<Int>
    private lateinit var nameSuperhero: Array<String>
    private lateinit var descSuperhero: Array<String>
    private lateinit var news: Array<String>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeData()
        val layoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = SuperheroAdapter(superheroArrayList)
        recyclerView.adapter = adapter

        adapter.setOnItemClickListener(object : SuperheroAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                val intent = Intent(activity, SuperheroDetail::class.java)
                intent.putExtra("nameS", superheroArrayList[position].nameSuperhero)
                intent.putExtra("img", superheroArrayList[position].imgSuperhero)
                intent.putExtra("descS", superheroArrayList[position].descSuperhero)
                startActivity(intent)
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        recyclerView = view.findViewById(R.id.tv_hero)
        return view
    }

    private fun initializeData() {
        superheroArrayList = ArrayList()

        imageid = arrayOf(
            R.drawable.a,
            R.drawable.b_renault,
            R.drawable.c_matilda,
            R.drawable.d_crusader,
            R.drawable.e_centurion,
            R.drawable.f_tiger,
            R.drawable.g_shalltear,
            R.drawable.h_akagi,
            R.drawable.i_kaga,
            R.drawable.j_yukikaze
        )

        nameSuperhero = arrayOf(
            getString(R.string.hero_a),
            getString(R.string.hero_b),
            getString(R.string.hero_c),
            getString(R.string.hero_d),
            getString(R.string.hero_e),
            getString(R.string.hero_f),
            getString(R.string.hero_g),
            getString(R.string.hero_h),
            getString(R.string.hero_i),
            getString(R.string.hero_j)
        )

        descSuperhero = arrayOf(
            getString(R.string.desc_a),
            getString(R.string.desc_b),
            getString(R.string.desc_c),
            getString(R.string.desc_d),
            getString(R.string.desc_e),
            getString(R.string.desc_f),
            getString(R.string.desc_g),
            getString(R.string.desc_h),
            getString(R.string.desc_i),
            getString(R.string.desc_j)
        )

        for (i in imageid.indices) {
            val superhero = Superhero(imageid[i], nameSuperhero[i], descSuperhero[i])
            superheroArrayList.add(superhero)
        }
    }
}
